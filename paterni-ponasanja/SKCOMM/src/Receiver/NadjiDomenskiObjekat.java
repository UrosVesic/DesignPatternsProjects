
package Receiver;


import Client.Kontroler;
import DomainClasses.DKSkiKarta;

 public class NadjiDomenskiObjekat { // Receiver
    
   Kontroler kon;
    
    
    public NadjiDomenskiObjekat(Kontroler kon1){kon=kon1;} 
     
    public boolean nadjiDomenskiObjekat(){
    kon.napuniDomenskiObjekatIzGrafickogObjekta();
    boolean signal;
    kon.getBrokerBazePodataka().makeConnection();
    DKSkiKarta sk = (DKSkiKarta)kon.getBrokerBazePodataka().findRecord(kon.getDomenskiObjekat()); // Promenljivo!!!
    if (sk != null) 
        { kon.napuniGrafickiObjekatIzDomenskogObjekta(sk);
          kon.setPoruka("Систем je нашао ски карту."); // Promenljivo!!!
          signal = true;
        }
        else
        { kon.isprazniGrafickiObjekat();
          kon.setPoruka("Систем не може да нађе ски карту."); // Promenljivo!!!
          signal = false;
        }
    kon.prikaziPoruku();
    kon.getBrokerBazePodataka().closeConnection();
    return signal;  
}
    
}
