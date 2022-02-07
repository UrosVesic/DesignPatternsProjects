
package ConcreteStrategy;

import AbstractProductB.BrokerBazePodataka;
import AbstractProductC.Kontroler;
import DomainClasses.DKSkiKarta;
import Strategy.SistemskaOperacija;
import java.util.concurrent.atomic.AtomicInteger;

public class KreirajDomenskiObjekat implements SistemskaOperacija { // Receiver

    BrokerBazePodataka bbp;
    Kontroler kon;

    public KreirajDomenskiObjekat(BrokerBazePodataka bbp1, Kontroler kon1) {
        bbp = bbp1;
        kon = kon1;
    }

    @Override
    public boolean izvrsiSO() {
        boolean signal;
        DKSkiKarta sk = new DKSkiKarta(); // Promenljivo!!!
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
            kon.napuniGrafickiObjekatIzDomenskogObjekta(sk);
            kon.setPoruka("Систем је креирао нову ски карту."); // Promenljivo!!!
        } else {
            bbp.rollbackTransation();
            kon.isprazniGrafickiObjekat();
            kon.setPoruka("Систем не може да креира нову ски карту."); // Promenljivo!!!
        }
        kon.prikaziPoruku();
        bbp.closeConnection();
        return signal;
    }

}
