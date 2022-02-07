
package Receiver;


import Client.Kontroler;
import DomainClasses.DKSkiKarta;
import java.util.concurrent.atomic.AtomicInteger;

 public class KreirajDomenskiObjekat { // Receiver
    
   Kontroler kon;
     
    public KreirajDomenskiObjekat(Kontroler kon1){kon=kon1;} 
     
    public boolean kreirajDomenskiObjekat(){
    boolean signal;
    DKSkiKarta sk= new DKSkiKarta(); // Promenljivo!!!
    AtomicInteger counter = new AtomicInteger(0);
    
    kon.getBrokerBazePodataka().makeConnection();
    if (!kon.getBrokerBazePodataka().getCounter(sk,counter)) return false;
    if (!kon.getBrokerBazePodataka().increaseCounter(sk,counter)) return false;
          
    sk.setSifraSkiKarte(counter.get()); // Promenljivo!!!
    signal = kon.getBrokerBazePodataka().insertRecord(sk);
    if (signal==true) 
        { kon.getBrokerBazePodataka().commitTransation();
          kon.napuniGrafickiObjekatIzDomenskogObjekta(sk);
          kon.setPoruka("Систем је креирао нову ски карту."); // Promenljivo!!!
        }
        else
        { kon.getBrokerBazePodataka().rollbackTransation();
         kon.isprazniGrafickiObjekat();
         kon.setPoruka("Систем не може да креира нову ски карту."); // Promenljivo!!!
        }
    kon.prikaziPoruku();
    kon.getBrokerBazePodataka().closeConnection();
    return signal;
}
    
}
