package Receiver;

import AbstractProductB.BrokerBazePodataka;
import Client.Kontroler;

public class ObrisiDomenskiObjekat {

    BrokerBazePodataka bbp;
    Kontroler kon;

    public ObrisiDomenskiObjekat(BrokerBazePodataka bbp1, Kontroler kon1) {
        bbp = bbp1;
        kon = kon1;
    }

    public boolean obrisiDomenskiObjekat() {
        kon.napuniDomenskiObjekatIzGrafickogObjekta();
        bbp.makeConnection();
        boolean signal = bbp.deleteRecord(kon.getDomenskiObjekat());
        if (signal == true) {
            kon.getBrokerBazePodataka().commitTransation();
            kon.setPoruka("Систем je oбрисао ски карту."); // Promenljivo!!!
            kon.isprazniGrafickiObjekat();
        } else {
            kon.getBrokerBazePodataka().rollbackTransation();
            kon.setPoruka("Систем не може да обрише ски карту."); // Promenljivo!!!
        }
        kon.prikaziPoruku();
        bbp.closeConnection();
        return signal;
    }
}
