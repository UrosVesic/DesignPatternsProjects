

package AbstractProductB;

import java.util.concurrent.atomic.AtomicInteger;
import DomainClasses.OpstiDomenskiObjekat;


public abstract class BrokerBazePodataka 
{   public abstract boolean makeConnection();
    public abstract boolean insertRecord(OpstiDomenskiObjekat odo);
    public abstract boolean updateRecord(OpstiDomenskiObjekat odo,OpstiDomenskiObjekat odoold);
    public abstract boolean updateRecord(OpstiDomenskiObjekat odo); 
    public abstract boolean deleteRecord(OpstiDomenskiObjekat odo);
    public abstract OpstiDomenskiObjekat findRecord(OpstiDomenskiObjekat odo);
    public abstract boolean commitTransation();
    public abstract boolean rollbackTransation();
    public abstract boolean getCounter(OpstiDomenskiObjekat odo,AtomicInteger counter); 
    public abstract boolean increaseCounter(OpstiDomenskiObjekat odo,AtomicInteger counter); 
    public abstract void closeConnection();
}
