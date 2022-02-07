package Receiver;

import AbstractProductB.BrokerBazePodataka;
import Client.Kontroler;

public class PromeniDomenskiObjekat { // Receiver

    BrokerBazePodataka bbp;
    Kontroler kon;

    public PromeniDomenskiObjekat(BrokerBazePodataka bbp1, Kontroler kon1) {
        bbp = bbp1;
        kon = kon1;
    }

    public boolean promeniDomenskiObjekat() {
        kon.napuniDomenskiObjekatIzGrafickogObjekta();
        bbp.makeConnection();
        boolean signal = bbp.updateRecord(kon.getDomenskiObjekat());
        if (signal == true) {
            kon.getBrokerBazePodataka().commitTransation();
            kon.setPoruka("Систем je променио ски карту."); // Promenljivo!!!
        } else {
            kon.getBrokerBazePodataka().rollbackTransation();
            kon.isprazniGrafickiObjekat();
            kon.setPoruka("Систем не може да промени ски карту."); // Promenljivo!!!
        }
        kon.prikaziPoruku();
        bbp.closeConnection();
        return signal;
    }

}
