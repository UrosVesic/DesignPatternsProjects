
package ConcreteState;

import AbstractProductC.Kontroler;
import State.Stanje;

public class NullStanje extends Stanje {

    public NullStanje(Kontroler kon1) {
        kon = kon1;
    }

    @Override
    public void obradiDomenskiObjekat() {
        kon.setPoruka("Не може да се обради непостојећа ски карта!");
        kon.prikaziPoruku();
    }

    @Override
    public void stornirajDomenskiObjekat() {
        kon.setPoruka("Не може да се сторнира непостојећа ски карта!");
        kon.prikaziPoruku();
    }

    @Override
    public void promeniDomenskiObjekat() {
        kon.setPoruka("Не може да се промени непостојећа ски карта!");
        kon.prikaziPoruku();
    }

}
