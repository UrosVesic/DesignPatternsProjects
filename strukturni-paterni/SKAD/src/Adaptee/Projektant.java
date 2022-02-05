

package Adaptee;

import AbstractProductA.*;
import AbstractProductB.*;
import AbstractProductC.*;


public abstract class Projektant { // Adaptee
      class SoftverskiSistem 
           {  EkranskaForma ef; 
              BrokerBazePodataka bbp; 
              Kontroler kon; 
           }
      
       SoftverskiSistem ss;
               
       abstract public void kreirajEkranskuFormu();   
       abstract public void kreirajBrokerBazePodataka ();
       abstract public void kreirajKontroler ();
       abstract public void kreirajSoftverskiSistem();
       abstract public void prikaziEkranskuFormu();
}
