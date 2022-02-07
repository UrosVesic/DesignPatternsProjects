package Receiver;

import AbstractProductB.BrokerBazePodataka;
import Client.Kontroler;

public class ZapamtiDomenskiObjekat { // Receiver

    BrokerBazePodataka bbp;
    Kontroler kon;

    public ZapamtiDomenskiObjekat(BrokerBazePodataka bbp1, Kontroler kon1) {
        bbp = bbp1;
        kon = kon1;
    }

    public boolean zapamtiDomenskiObjekat() {
        kon.napuniDomenskiObjekatIzGrafickogObjekta();
        bbp.makeConnection();
        boolean signal = bbp.insertRecord(kon.getDomenskiObjekat());
        if (signal == true) {
            kon.getBrokerBazePodataka().commitTransation();
            kon.setPoruka("Систем je запамтио ски карту."); // Promenljivo!!!
        } else {
            kon.getBrokerBazePodataka().rollbackTransation();
            kon.isprazniGrafickiObjekat();
            kon.setPoruka("Систем не може да запамти ски карту."); // Promenljivo!!!
        }
        kon.prikaziPoruku();
        bbp.closeConnection();
        return signal;
    }

}
