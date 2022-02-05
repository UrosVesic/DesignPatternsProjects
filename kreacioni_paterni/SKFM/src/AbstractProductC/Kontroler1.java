
package AbstractProductC;

import AbstractProductA.*;
import AbstractProductB.*;
import DomainClasses.DKSkiKarta;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.text.SimpleDateFormat;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.Timer;
import java.util.TimerTask;

public final class Kontroler1 extends Kontroler {

    public Kontroler1(EkranskaForma ef1, BrokerBazePodataka bbp1) {
        ef = ef1;
        bbp = bbp1;
        Povezi();
    }

    void Povezi() {
        javax.swing.JButton Kreiraj = ef.getPanel().getKreiraj();
        javax.swing.JButton Promeni = ef.getPanel().getPromeni();
        javax.swing.JButton Obrisi = ef.getPanel().getObrisi();
        javax.swing.JButton Nadji = ef.getPanel().getNadji();
        Kreiraj.addActionListener(new OsluskivacKreiraj(this));
        Promeni.addActionListener(new OsluskivacPromeni(this));
        Obrisi.addActionListener(new OsluskivacObrisi(this));
        Nadji.addActionListener(new OsluskivacNadji(this));

        javax.swing.JTextField SifraPrijave = ef.getPanel().getSifraSkiKarte1(); // Promenljivo!!!
        SifraPrijave.addFocusListener(new OsluskivacNadji1(this));
    }

// Promenljivo!!!  
    void napuniDomenskiObjekatIzGrafickogObjekta() {
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
    void napuniGrafickiObjekatIzDomenskogObjekta(DKSkiKarta sk) {
        ef.getPanel().setSifraSkiKarte(Integer.toString(sk.getSifraSkiKarte()));
        ef.getPanel().setImePrezimeKupca(sk.getImePrezimeKupca());
        ef.getPanel().setSifraSkiCentra(Integer.toString(sk.getSifraSkiCentra()));
        ef.getPanel().setCena(Double.toString(sk.getCena()));
        ef.getPanel().setDatum(sk.getDatumIzdavanja());

    }

// Promenljivo!!!
    void isprazniGrafickiObjekat() {

        ef.getPanel().setSifraSkiKarte("");
        ef.getPanel().setImePrezimeKupca("");
        ef.getPanel().setSifraSkiCentra("0");
        ef.getPanel().setCena("0");
        ef.getPanel().setDatum(new java.util.Date());
    }

    void prikaziPoruku() {
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

    boolean zapamtiDomenskiObjekat() {

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

    boolean kreirajDomenskiObjekat() {
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

    boolean obrisiDomenskiObjekat() {
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

    boolean promeniDomenskiObjekat() {
        bbp.makeConnection();
        boolean signal = bbp.updateRecord(sk);
        if (signal == true) {
            bbp.commitTransation();
            poruka = "Систем je променио ски карту."; // Promenljivo!!!
        } else {
            bbp.rollbackTransation();
            isprazniGrafickiObjekat();
            poruka = "Систем не може да промени ски карту.";  // Promenljivo!!!
        }
        prikaziPoruku();
        bbp.closeConnection();
        return signal;
    }

    boolean nadjiDomenskiObjekat() {
        boolean signal;
        bbp.makeConnection();
        sk = (DKSkiKarta) bbp.findRecord(sk); // Promenljivo!!!
        if (sk != null) {
            napuniGrafickiObjekatIzDomenskogObjekta(sk);
            poruka = "Систем je нашао ски карту."; // Promenljivo!!!
            signal = true;
        } else {
            isprazniGrafickiObjekat();
            poruka = "Систем не може да нађе ски карту.";// Promenljivo!!!
            signal = false;
        }
        prikaziPoruku();
        bbp.closeConnection();
        return signal;
    }

}

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

    Kontroler1 kon;

    OsluskivacKreiraj(Kontroler1 kon1) {
        kon = kon1;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        kon.kreirajDomenskiObjekat();

    }
}

class OsluskivacObrisi implements ActionListener {

    Kontroler1 kon;

    OsluskivacObrisi(Kontroler1 kon1) {
        kon = kon1;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        kon.napuniDomenskiObjekatIzGrafickogObjekta();
        kon.obrisiDomenskiObjekat();

    }
}

class OsluskivacPromeni implements ActionListener {

    Kontroler1 kon;

    OsluskivacPromeni(Kontroler1 kon1) {
        kon = kon1;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        kon.napuniDomenskiObjekatIzGrafickogObjekta();
        kon.promeniDomenskiObjekat();

    }
}

class OsluskivacNadji implements ActionListener {

    Kontroler1 kon;

    OsluskivacNadji(Kontroler1 kon1) {
        kon = kon1;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        kon.napuniDomenskiObjekatIzGrafickogObjekta();
        kon.nadjiDomenskiObjekat();

    }
}

class OsluskivacNadji1 implements FocusListener {

    Kontroler1 kon;

    OsluskivacNadji1(Kontroler1 kon1) {
        kon = kon1;
    }

    public void focusLost(java.awt.event.FocusEvent e) {
        kon.napuniDomenskiObjekatIzGrafickogObjekta();
        kon.nadjiDomenskiObjekat();

    }

    @Override
    public void focusGained(FocusEvent e) {

    }
}
