

package AbstractFactory;

import Subject.Kontroler;
import AbstractProductA.*;
import AbstractProductB.*;

public interface Projektant {
       EkranskaForma kreirajEkranskuFormu();   
       BrokerBazePodataka kreirajBrokerBazePodataka ();
       Kontroler kreirajKontroler (EkranskaForma ef,BrokerBazePodataka dbbr);   
}
