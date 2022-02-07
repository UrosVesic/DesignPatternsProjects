

package AbstractProductC;

import AbstractProductA.EkranskaForma;
import ConcreteSubject.BrokerBazePodataka;
import DomainClasses.DKSkiKarta;
import DomainClasses.GeneralDObject;

public abstract class Kontroler {
    EkranskaForma ef;
    BrokerBazePodataka bbp;
    DKSkiKarta sk;   // Promenljivo!!!
    String poruka;
    public GeneralDObject getDKObject(){return sk;}
    public abstract void napuniDomenskiObjekatIzGrafickogObjekta(); 
    public abstract boolean nadjiDomenskiObjekat();
}
