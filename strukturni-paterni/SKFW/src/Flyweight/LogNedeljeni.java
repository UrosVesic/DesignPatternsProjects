
package Flyweight;

import DomainClasses.GeneralDObject;

public class LogNedeljeni implements Log { // UnsharedConcreteFlyweight

    GeneralDObject gdo;

    public LogNedeljeni(GeneralDObject gdo1) {
        gdo = gdo1;
    }

    @Override
    public String vratiNazivOperacije() {
        return "";
    }

    @Override
    public String vratiDomenskiObjekat() {
        if(gdo == null){
            return null;
        }
        return gdo.getAtrValue();
    }

    @Override
    public String vratiPoruku() {
        return null;
    }

}
