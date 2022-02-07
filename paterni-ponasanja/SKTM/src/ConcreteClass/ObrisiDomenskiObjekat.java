
package ConcreteClass;

import AbstractClass.OpstaDBSO;
import AbstractProductB.BrokerBazePodataka;
import Client.Kontroler;

public class ObrisiDomenskiObjekat extends OpstaDBSO { // ConcreteClass

    public ObrisiDomenskiObjekat(BrokerBazePodataka bbp1, Kontroler kon1) {
        super(bbp1, kon1);
    }

    @Override
    public boolean konkretnaDBSO() // delete record
    {
        return bbp.deleteRecord(kon.getDomenskiObjekat());
    }

    @Override
    public void uspesnaDBOperacija() {
        bbp.commitTransation();
        kon.setPoruka("Систем je oбрисао ски карту.");
        kon.isprazniGrafickiObjekat();
    }

    @Override
    public void neuspesnaDBOperacija() {
        bbp.rollbackTransation();
        kon.setPoruka("Систем не може да обрише ски карту.");
    }
}
