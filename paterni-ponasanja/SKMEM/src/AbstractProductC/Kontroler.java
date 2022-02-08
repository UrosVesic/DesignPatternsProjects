

package AbstractProductC;

import AbstractProductA.EkranskaForma;
import AbstractProductB.BrokerBazePodataka;
import DomainClasses.DKSkiKarta;
import Memento.Memento;
import Originator.Originator;

public abstract class Kontroler { //Caretaker
    EkranskaForma ef;
    BrokerBazePodataka bbp;
    DKSkiKarta sk;   
    Memento memento;
    Originator orig;
    String poruka;
         
}
