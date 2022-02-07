
package ConcreteClass;

import AbstractClass.OpstaDBSO;
import AbstractProductB.BrokerBazePodataka;
import Client.Kontroler;
import DomainClasses.DKSkiKarta;
import DomainClasses.GeneralDObject;
import java.util.concurrent.atomic.AtomicInteger;

public class KreirajDomenskiObjekat extends OpstaDBSO { // ConcreteClass

    public KreirajDomenskiObjekat(BrokerBazePodataka bbp1, Kontroler kon1) {
        super(bbp1, kon1);
    }

    @Override
    public void makeConnection() {
        bbp.makeConnection();
    }

    @Override
    public boolean konkretnaDBSO() // insert record
    {
        kon.isprazniGrafickiObjekat();
        GeneralDObject ip = kon.getDomenskiObjekat();
        AtomicInteger counter = new AtomicInteger(0);

        if (!bbp.getCounter(ip, counter)) {
            return false;
        }
        if (!bbp.increaseCounter(ip, counter)) {
            return false;
        }

        ((DKSkiKarta) ip).setSifraSkiKarte(counter.get()); // Promenljivo!!!

        return bbp.insertRecord(ip);

    }

    @Override
    public void uspesnaDBOperacija() {
        bbp.commitTransation();
        kon.setPoruka("Систем је креирао нову ски карту.");
        kon.napuniGrafickiObjekatIzDomenskogObjekta(kon.getDomenskiObjekat());
    }

    @Override
    public void neuspesnaDBOperacija() {
        bbp.rollbackTransation();
        kon.isprazniGrafickiObjekat();
        kon.setPoruka("Систем не може да креира нову ски карту.");
    }

}
