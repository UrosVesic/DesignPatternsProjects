
package ConcreteHandler;



import DomainClasses.DKSkiCentar;
import Handler.Kontroler;


public class KontrolerStOg extends Kontroler{ // Proxy
       
    
    
    public KontrolerStOg(Kontroler kon1,Kontroler konOsnovni) {super(kon1,konOsnovni);}
          
    @Override
    public boolean promeniDomenskiObjekat()
    
      {
         if (nadjiPredmet()) 
             return kon.promeniDomenskiObjekat();
         else
             return false;
      } 
    
    public boolean nadjiPredmet(){
    boolean signal;
    konOsnovni.getBrokerBazePodataka().makeConnection();
    DKSkiCentar sc = new DKSkiCentar();
    int SifraPredmeta = Integer.parseInt(konOsnovni.getEkranskaForma().getPanel().getSifraSkiCentra());
    sc.setSifraSkiCentra(SifraPredmeta);
    
    sc = (DKSkiCentar)konOsnovni.getBrokerBazePodataka().findRecord(sc); // Promenljivo!!!
    if (sc != null) 
        { poruka = "Систем је нашао ски центар";  // Promenljivo!!!
          signal = true;
        }
        else
        { poruka ="Систем није нашао ски центар!!!"; // Promenljivo!!!
          signal = false;
        }
    konOsnovni.prikaziPoruku(poruka);
    konOsnovni.getBrokerBazePodataka().closeConnection();
    return signal;   
   
    }
}