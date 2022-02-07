
package Observer;

import DomainClasses.DKSkiKarta;
import AbstractProductC.Kontroler;

public class ConcreteObserver implements Observer {

    Kontroler kon;

    public ConcreteObserver(Kontroler kon1) {
        kon = kon1;
    }

    @Override
    public void Update(int brojPrijave) {
        DKSkiKarta tekucask = (DKSkiKarta) kon.getDKObject();
        if (tekucask != null) {
            if (brojPrijave == tekucask.getSifraSkiKarte()) {
                kon.nadjiDomenskiObjekat();
            }
        }
    }

}
