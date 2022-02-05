

package AbstractFactory;

import Abstraction.BrokerBazePodataka;
import AbstractProductA.*;
import AbstractProductC.*;

public interface Projektant {
       EkranskaForma kreirajEkranskuFormu();   
       BrokerBazePodataka kreirajBrokerBazePodataka ();
       Kontroler kreirajKontroler (EkranskaForma ef,BrokerBazePodataka dbbr);   
}
