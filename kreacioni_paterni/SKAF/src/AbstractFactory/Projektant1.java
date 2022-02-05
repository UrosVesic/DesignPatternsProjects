

package AbstractFactory;

import AbstractProductA.*;
import AbstractProductB.*;
import AbstractProductC.*;

// Promenljivo!!!
public class Projektant1 implements Projektant {
        
    @Override
    public EkranskaForma kreirajEkranskuFormu() {
        Panel pan = new Panel1(); // Promenljivo!!!
        EkranskaForma sk = new EkranskaForma1(); // Promenljivo!!!
        sk.setPanel(pan);
        return sk;
    }   
    
    @Override
    public BrokerBazePodataka kreirajBrokerBazePodataka () 
      { BrokerBazePodataka dbbr = new BrokerBazePodataka1(); // Promenljivo!!!
        return dbbr;}  
    
    @Override
    public Kontroler kreirajKontroler (EkranskaForma ef,BrokerBazePodataka dbbr) {
        //Kontroler kon = new Kontroler1(ef,dbbr); // Promenljivo!!!
        Kontroler kon = new Kontroler1(ef,dbbr);
        return kon;
    }
        
   
}

