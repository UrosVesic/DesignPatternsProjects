
package Client;

import AbstractProductA.*;
import AbstractProductB.*;
import ConcreteCommand.SO;
import java.text.SimpleDateFormat;
import java.util.Timer;
import java.util.TimerTask;
import DomainClasses.DKSkiKarta;  // Promenljivo
import DomainClasses.GeneralDObject;
import ConcreteCommand.SOKreiraj;
import ConcreteCommand.SONadji;
import ConcreteCommand.SOObrisi;
import ConcreteCommand.SOPromeni;

import Receiver.KreirajDomenskiObjekat;
import Receiver.NadjiDomenskiObjekat;
import Receiver.ObrisiDomenskiObjekat;
import Receiver.PromeniDomenskiObjekat;

public final class Kontroler1 extends Kontroler { // Client

    public Kontroler1(EkranskaForma ef1, BrokerBazePodataka bbp1, SO so) {
        ef = ef1;
        bbp = bbp1;
        Povezi(so);
    }

    void Povezi(SO so) {

        KreirajDomenskiObjekat kdo = new KreirajDomenskiObjekat(this);
        so.sok = new SOKreiraj(kdo); // povezivanje ConcreteCommand i Receiver

        PromeniDomenskiObjekat pdo = new PromeniDomenskiObjekat(this);
        so.sop = new SOPromeni(pdo);

        ObrisiDomenskiObjekat odo = new ObrisiDomenskiObjekat(this);
        so.soo = new SOObrisi(odo);

        NadjiDomenskiObjekat ndo = new NadjiDomenskiObjekat(this);
        so.son = new SONadji(ndo);

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
    @Override
    public void napuniGrafickiObjekatIzDomenskogObjekta(GeneralDObject gdo) {
        DKSkiKarta sk = (DKSkiKarta) gdo;
        ef.getPanel().setSifraSkiKarte(Integer.toString(sk.getSifraSkiKarte()));
        ef.getPanel().setImePrezimeKupca(sk.getImePrezimeKupca());
        ef.getPanel().setSifraSkiCentra(Integer.toString(sk.getSifraSkiCentra()));
        ef.getPanel().setCena(Double.toString(sk.getCena()));
        ef.getPanel().setDatum(sk.getDatumIzdavanja());

    }

// Promenljivo!!!
    @Override
    public void isprazniGrafickiObjekat() {

        ef.getPanel().setSifraSkiKarte("");
        ef.getPanel().setImePrezimeKupca("");
        ef.getPanel().setSifraSkiCentra("0");
        ef.getPanel().setCena("0");
        ef.getPanel().setDatum(new java.util.Date());
    }

    @Override
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

}
