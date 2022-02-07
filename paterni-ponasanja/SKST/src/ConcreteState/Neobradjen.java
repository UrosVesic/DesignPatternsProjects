
package ConcreteState;

import AbstractProductC.Kontroler;
import DomainClasses.DKSkiKarta;
import State.Stanje;

public class Neobradjen extends Stanje{ 
    public Neobradjen(Kontroler kon1) {kon = kon1;}
    @Override
    public void obradiDomenskiObjekat()
    {  DKSkiKarta dk = (DKSkiKarta) kon.getDKObject();
       dk.setStanje("obradjen");
       kon.promeniDomenskiObjekat();
       kon.napuniGrafickiObjekatIzDomenskogObjekta(dk);
    }
    @Override
    public void stornirajDomenskiObjekat()
     { DKSkiKarta dk = (DKSkiKarta) kon.getDKObject();
       dk.setStanje("storniran");
       kon.promeniDomenskiObjekat();
       kon.napuniGrafickiObjekatIzDomenskogObjekta(dk);
     }
    
    public void promeniDomenskiObjekat()
    {  kon.promeniDomenskiObjekat();
    }
    
}
