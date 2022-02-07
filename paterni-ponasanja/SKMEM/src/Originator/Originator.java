
package Originator;

import DomainClasses.DKSkiKarta;
import Memento.Memento;

/**
 *
 * @author UrosVesic
 */
public class Originator {
    DKSkiKarta sk;
    
    public Originator(DKSkiKarta sk) {this.sk = sk;}
    
    public DKSkiKarta setMemento(Memento mem)
    { 
      this.sk = mem.getState();
      return this.sk;
    }
    
    public Memento createMemento()
    { return new Memento(this.sk);}
    
    
}
