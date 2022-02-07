
package Builder;


import AbstractProductA.EkranskaForma2;
import AbstractProductA.Panel;
import AbstractProductA.Panel1;
import AbstractProductC.Kontroler1;
import ConcreteSubject.BrokerBazePodataka1;
import Subject.Subject;

// promenljivo!!!
public class Projektant1 extends Projektant {
    
    @Override
    public void kreirajSoftverskiSistem()
    { ss = new SoftverskiSistem();
    }
    
    @Override
    public void kreirajEkranskuFormu() 
      { Panel pan = new Panel1(); // promenljivo!!!
        ss.ef = new EkranskaForma2(); // promenljivo!!!
        ss.ef.setPanel(pan);
      }   
    
    @Override
    public void kreirajBrokerBazePodataka (Subject sub) 
      { ss.bbp = new BrokerBazePodataka1(sub); // promenljivo!!!
      }  
        
    @Override
    public void kreirajKontroler () 
      { ss.kon = new Kontroler1(ss.ef,ss.bbp); // promenljivo!!!
      }

    @Override
    public void prikaziEkranskuFormu() 
      { ss.ef.prikaziEkranskuFormu();
      }
}

