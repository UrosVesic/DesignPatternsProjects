
package AbstractProductC;

import AbstractProductA.EkranskaForma;
import AbstractProductB.BrokerBazePodataka;
import DomainClasses.DKSkiKarta;
import DomainClasses.GeneralDObject;

public abstract class Kontroler {
    EkranskaForma ef;
    BrokerBazePodataka bbp;
    DKSkiKarta sk;   // Promenljivo!!!
    String poruka;
    public GeneralDObject getDKObject(){return sk;}
    public abstract boolean promeniDomenskiObjekat();
    public void setPoruka(String poruka1){poruka = poruka1;}
    public abstract void prikaziPoruku(); 
    abstract public void napuniGrafickiObjekatIzDomenskogObjekta(DKSkiKarta sk);
    abstract public boolean nadjiDomenskiObjekat1();
}
