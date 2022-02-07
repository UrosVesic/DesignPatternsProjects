

package Subject;

import AbstractProductA.EkranskaForma;
import AbstractProductB.BrokerBazePodataka;
import DomainClasses.DKSkiKarta;


public abstract class Kontroler { // Subject
    protected EkranskaForma ef;
    protected BrokerBazePodataka bbp;
    protected DKSkiKarta sk;   // Promenljivo!!!
    protected String poruka;
    
    public void Povezi(Kontroler kon) {}
    public abstract boolean zapamtiDomenskiObjekat();
    public abstract boolean kreirajDomenskiObjekat();
    public abstract boolean obrisiDomenskiObjekat();
    public abstract boolean promeniDomenskiObjekat();
    public abstract boolean nadjiDomenskiObjekat();
    public void napuniDomenskiObjekatIzGrafickogObjekta(){}
    public EkranskaForma getEkranskaForma(){return ef;}
    public void setIkonu(String nazivIkone){}
    public void startAudioKlip(String nazivKlipa){}
}
