

package AbstractFactory;

import RealSubject.Kontroler2;
import Subject.Kontroler;
import AbstractProductA.*;
import AbstractProductB.*;
import Proxy.ProxyKontroler;

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
      { BrokerBazePodataka dbbr = new BrokerBazePodataka1(); // Promenljivo!!!
        return dbbr;}  
    
    @Override
    public Kontroler kreirajKontroler (EkranskaForma ef,BrokerBazePodataka dbbr) {
        Kontroler2 kon = new Kontroler2(ef,dbbr); // Promenljivo!!!
        ProxyKontroler pk = new ProxyKontroler(kon);
        return pk;
    }
        
   
}

