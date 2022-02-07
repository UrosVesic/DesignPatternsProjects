
package ConcreteHandler;

import AbstractProductA.*;
import AbstractProductB.*;
import Handler.Kontroler;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.text.SimpleDateFormat;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.Timer;
import java.util.TimerTask;
import DomainClasses.DKSkiKarta;  // Promenljivo

public final class Kontroler1 extends Kontroler { // RealSubject

    public Kontroler1(EkranskaForma ef1, BrokerBazePodataka bbp1) {
        super(null, null);
        ef = ef1;
        bbp = bbp1;
    }

    @Override
    public void Povezi(Kontroler kon) {

        if (kon != null) {
            javax.swing.JButton Kreiraj = ef.getPanel().getKreiraj();
            javax.swing.JButton Promeni = ef.getPanel().getPromeni();
            javax.swing.JButton Obrisi = ef.getPanel().getObrisi();
            javax.swing.JButton Nadji = ef.getPanel().getNadji();
            Kreiraj.addActionListener(new OsluskivacKreiraj(kon));
            Promeni.addActionListener(new OsluskivacPromeni(kon));
            Obrisi.addActionListener(new OsluskivacObrisi(kon));
            Nadji.addActionListener(new OsluskivacNadji(kon));
            javax.swing.JTextField SifraPrijave = ef.getPanel().getSifraSkiKarte1(); // Promenljivo!!!
            SifraPrijave.addFocusListener(new OsluskivacNadji1(kon));
        }
    }

    // Promenljivo!!!  
    @Override
    public void napuniDomenskiObjekatIzGrafickogObjekta() {
        sk = new DKSkiKarta();
        sk.setSifraSkiKarte(getInteger(ef.getPanel().getSifraSkiKarte()));
        sk.setImePrezimeKupca(ef.getPanel().getImePrezimeKupca());
        sk.setSifraSkiCentra(getInteger(ef.getPanel().getSifraSkiCentra()));
        if(!ef.getPanel().getCena().equals("")){
           sk.setCena(Double.parseDouble(ef.getPanel().getCena()));
       }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date Datum = java.sql.Date.valueOf(sdf.format(ef.getPanel().getDatumIzdavanja()));
        sk.setDatumIzdavanja(Datum);

    }

    // Promenljivo!!!
    public void napuniGrafickiObjekatIzDomenskogObjekta(DKSkiKarta sk) {
        ef.getPanel().setSifraSkiKarte(Integer.toString(sk.getSifraSkiKarte()));
        ef.getPanel().setImePrezimeKupca(sk.getImePrezimeKupca());
        ef.getPanel().setSifraSkiCentra(Integer.toString(sk.getSifraSkiCentra()));
        ef.getPanel().setCena(Double.toString(sk.getCena()));
        ef.getPanel().setDatum(sk.getDatumIzdavanja());

    }

// Promenljivo!!!
    public void isprazniGrafickiObjekat() {
        ef.getPanel().setSifraSkiKarte("");
        ef.getPanel().setImePrezimeKupca("");
        ef.getPanel().setSifraSkiCentra("0");
        ef.getPanel().setCena("0");
        ef.getPanel().setDatum(new java.util.Date());
    }

    public void prikaziPoruku() {
        ef.getPanel().setPoruka(poruka);

        Timer timer = new Timer();

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                ef.getPanel().setPoruka("");
            }
        }, 3000);

    }

    public int getInteger(String s) {
        int broj = 0;
        try {
            if (s != null) {
                broj = Integer.parseInt(s);
            }
        } catch (NumberFormatException e) {
            broj = 0;
        }

        return broj;
    }

    @Override
    public boolean zapamtiDomenskiObjekat() {

        bbp.makeConnection();
        boolean signal = bbp.insertRecord(sk);
        if (signal == true) {
            bbp.commitTransation();
            poruka = "Систем је запамтио нову ски карту."; // Promenljivo!!!
        } else {
            bbp.rollbackTransation();
            poruka = "Систем не може да запамти нову ски карту."; // Promenljivo!!!  
        }
        prikaziPoruku();
        bbp.closeConnection();
        return signal;

    }

    @Override
    public boolean kreirajDomenskiObjekat() {
        boolean signal;
        sk = new DKSkiKarta(); // Promenljivo!!!
        AtomicInteger counter = new AtomicInteger(0);

        bbp.makeConnection();
        if (!bbp.getCounter(sk, counter)) {
            return false;
        }
        if (!bbp.increaseCounter(sk, counter)) {
            return false;
        }

        sk.setSifraSkiKarte(counter.get()); // Promenljivo!!!
        signal = bbp.insertRecord(sk);
        if (signal == true) {
            bbp.commitTransation();
            napuniGrafickiObjekatIzDomenskogObjekta(sk);
            poruka = "Систем је креирао нову ски карту."; // Promenljivo!!!
        } else {
            bbp.rollbackTransation();
            isprazniGrafickiObjekat();
            poruka = "Систем не може да креира нову ски карту."; // Promenljivo!!!
        }
        prikaziPoruku();
        bbp.closeConnection();
        return signal;
    }

    @Override
    public boolean promeniDomenskiObjekat() {
        bbp.makeConnection();
        boolean signal = bbp.updateRecord(sk);
        if (signal == true) {
            bbp.commitTransation();
            poruka = "������ je �������� ������� ������."; // Promenljivo!!!
        } else {
            bbp.rollbackTransation();
            isprazniGrafickiObjekat();
            poruka = "������ �� ���� �� ������� ������� ������."; // Promenljivo!!!
        }
        prikaziPoruku();
        bbp.closeConnection();
        return signal;
    }

    @Override
    public boolean nadjiDomenskiObjekat() {
        bbp.makeConnection();
        boolean signal = bbp.deleteRecord(sk);
        if (signal == true) {
            bbp.commitTransation();
            poruka = "Систем je oбрисао ски карту."; // Promenljivo!!!
            isprazniGrafickiObjekat();
        } else {
            bbp.rollbackTransation();
            poruka = "Систем не може да обрише ски карту."; // Promenljivo!!!
        }
        prikaziPoruku();
        bbp.closeConnection();
        return signal;
    }

}

// Osluskivaci su kod primera za proxy patern klijenti.
class OsluskivacZapamti implements ActionListener {

    Kontroler1 kon;

    OsluskivacZapamti(Kontroler1 kon1) {
        kon = kon1;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        kon.napuniDomenskiObjekatIzGrafickogObjekta();
        kon.zapamtiDomenskiObjekat();

    }
}

class OsluskivacKreiraj implements ActionListener {

    Kontroler kon;

    OsluskivacKreiraj(Kontroler kon1) {
        kon = kon1;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        kon.kreirajDomenskiObjekat();

    }
}

class OsluskivacObrisi implements ActionListener {

    Kontroler kon;

    OsluskivacObrisi(Kontroler kon1) {
        kon = kon1;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        kon.napuniDomenskiObjekatIzGrafickogObjekta();
        kon.obrisiDomenskiObjekat();

    }
}

class OsluskivacPromeni implements ActionListener {

    Kontroler kon;

    OsluskivacPromeni(Kontroler kon1) {
        kon = kon1;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        kon.napuniDomenskiObjekatIzGrafickogObjekta();
        kon.promeniDomenskiObjekat();

    }
}

class OsluskivacNadji implements ActionListener {

    Kontroler kon;

    OsluskivacNadji(Kontroler kon1) {
        kon = kon1;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        kon.napuniDomenskiObjekatIzGrafickogObjekta();
        kon.nadjiDomenskiObjekat();

    }
}

class OsluskivacNadji1 implements FocusListener {

    Kontroler kon;

    OsluskivacNadji1(Kontroler kon1) {
        kon = kon1;
    }

    @Override
    public void focusLost(java.awt.event.FocusEvent e) {
        kon.napuniDomenskiObjekatIzGrafickogObjekta();
        kon.nadjiDomenskiObjekat();
    }

    @Override
    public void focusGained(FocusEvent e) {

    }
}
