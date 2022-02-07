

package ConcreteState;

import AbstractProductC.Kontroler;
import DomainClasses.DKSkiKarta;
import State.Stanje;

public class Obradjen extends Stanje{ 
    public Obradjen(Kontroler kon1) {kon = kon1;}
    @Override
    public void obradiDomenskiObjekat()
     { kon.setPoruka("Не може да се обради обрађена ски карта!");
       kon.prikaziPoruku();
       kon.nadjiDomenskiObjekat1();
     }
    @Override
    public void stornirajDomenskiObjekat()
    { DKSkiKarta dk = (DKSkiKarta) kon.getDKObject();
       dk.setStanje("storniran");
       kon.promeniDomenskiObjekat();
       kon.napuniGrafickiObjekatIzDomenskogObjekta(dk);
    }
    
    @Override
    public void promeniDomenskiObjekat()
     { kon.setPoruka("Не може да се промени обрађена ски карта!");
       kon.prikaziPoruku();
       kon.nadjiDomenskiObjekat1();
      
     }
    
}
