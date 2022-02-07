

package ConcreteHandler;



import Handler.Kontroler;


public class KontrolerVrOg extends Kontroler{ // Proxy
       
    public KontrolerVrOg(Kontroler kon1,Kontroler konOsnovni) {super(kon1,konOsnovni);konOsnovni.Povezi(this);}
          
       
    @Override
    public boolean promeniDomenskiObjekat()
    
    {    String sifraSkiCentra = konOsnovni.getEkranskaForma().getPanel().getSifraSkiCentra();
         if  (Broj.daLiJeBroj(sifraSkiCentra))   
               return kon.promeniDomenskiObjekat();
         konOsnovni.prikaziPoruku("Формат поља Sifra ski centra није добар!!!");
         konOsnovni.getEkranskaForma().getPanel().setSifraSkiCentra("0");
         return false;
    } 
    
    
    } 


class Broj  
{ static boolean daLiJeBroj(String broj)
   { try  { int c = Integer.parseInt(broj);
          }  catch(NumberFormatException nfe)  { return false; }
     return true;
   }
}