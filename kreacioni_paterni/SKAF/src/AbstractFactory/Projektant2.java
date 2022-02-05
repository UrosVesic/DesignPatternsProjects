

package AbstractFactory;

import AbstractProductA.*;
import AbstractProductB.*;
import AbstractProductC.*;

// Promenljivo!!!
public class Projektant2 implements Projektant {
        
    @Override
    public EkranskaForma kreirajEkranskuFormu() {
        Panel pan = new Panel2(); // Promenljivo!!!
        EkranskaForma sk = new EkranskaForma2(); // Promenljivo!!!
        sk.setPanel(pan);
        return sk;
    }   
    
    @Override
    public BrokerBazePodataka kreirajBrokerBazePodataka () 
      { BrokerBazePodataka dbbr = new BrokerBazePodataka2(); // Promenljivo!!!
        return dbbr;}  
    
    @Override
    public Kontroler kreirajKontroler (EkranskaForma ef,BrokerBazePodataka dbbr) {
        Kontroler kon = new Kontroler2(ef,dbbr); // Promenljivo!!!
        return kon;
    }
        
   
}

