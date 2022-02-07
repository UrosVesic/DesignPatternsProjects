package Receiver;

import AbstractProductB.BrokerBazePodataka;
import Client.Kontroler;
import DomainClasses.DKSkiKarta;

public class NadjiDomenskiObjekat { // Receiver

    BrokerBazePodataka bbp;
    Kontroler kon;

    public NadjiDomenskiObjekat(BrokerBazePodataka bbp1, Kontroler kon1) {
        bbp = bbp1;
        kon = kon1;
    }

    public boolean nadjiDomenskiObjekat() {
        kon.napuniDomenskiObjekatIzGrafickogObjekta();
        boolean signal;
        bbp.makeConnection();
        DKSkiKarta sk = (DKSkiKarta) bbp.findRecord(kon.getDomenskiObjekat()); // Promenljivo!!!
        if (sk != null) {
            kon.napuniGrafickiObjekatIzDomenskogObjekta(sk);
            kon.setPoruka("Систем je нашао ски карту."); // Promenljivo!!!
            signal = true;
        } else {
            kon.isprazniGrafickiObjekat();
            kon.setPoruka("Систем не може да нађе ски карту."); // Promenljivo!!!
            signal = false;
        }
        kon.prikaziPoruku();
        bbp.closeConnection();
        return signal;
    }

}
