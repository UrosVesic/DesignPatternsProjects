

package AbstractFactory;

import Abstraction.BrokerBazePodataka1;
import Abstraction.BrokerBazePodataka;
import AbstractProductA.*;
import AbstractProductC.*;
import Abstraction.BrokerBazePodataka2;
import RefinedAbstraction.BrokerBazePodataka11;

// Promenljivo!!!
public class Projektant1 implements Projektant {
        
    @Override
    public EkranskaForma kreirajEkranskuFormu() {
        Panel pan = new Panel1(); // Promenljivo!!!
        EkranskaForma2 ip = new EkranskaForma2(); // Promenljivo!!!
        ip.setPanel(pan);
        return ip;
    }   
    
    @Override
    public BrokerBazePodataka kreirajBrokerBazePodataka () 
      { BrokerBazePodataka dbbr = new BrokerBazePodataka11(); // Promenljivo!!!
        return dbbr;}  
    
    @Override
    public Kontroler kreirajKontroler (EkranskaForma ef,BrokerBazePodataka dbbr) {
        Kontroler kon = new Kontroler1(ef,dbbr); // Promenljivo!!!
        return kon;
    }
        
   
}
