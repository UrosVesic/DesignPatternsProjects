
package AbstractProductC;


import ConcreteState.Obradjen;
import ConcreteState.Storniran;
import ConcreteState.Neobradjen;
import ConcreteState.NullStanje;
import AbstractProductA.*;
import AbstractProductB.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.text.SimpleDateFormat;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.Timer;
import java.util.TimerTask;
import DomainClasses.DKSkiKarta;  // Promenljivo
import State.*;



public final class Kontroler1 extends Kontroler{
   
    
   
    
    public Kontroler1(EkranskaForma ef1,BrokerBazePodataka bbp1){ef=ef1;bbp=bbp1; Povezi();}
    
    void Povezi()
    {javax.swing.JButton Kreiraj = ef.getPanel().getKreiraj();
     javax.swing.JButton Promeni = ef.getPanel().getPromeni();
     javax.swing.JButton Obradi = ef.getPanel().getObradi();
     javax.swing.JButton Storniraj = ef.getPanel().getStorniraj();
     javax.swing.JButton Nadji = ef.getPanel().getNadji();
     Kreiraj.addActionListener( new OsluskivacKreiraj(this));
     Promeni.addActionListener( new OsluskivacPromeni(this));
     Obradi.addActionListener( new OsluskivacObradi(this));
     Storniraj.addActionListener( new OsluskivacStorniraj(this));
     Nadji.addActionListener( new OsluskivacNadji(this));
     
     javax.swing.JTextField SifraPrijave = ef.getPanel().getSifraSkiKarte1(); // Promenljivo!!!
     SifraPrijave.addFocusListener( new OsluskivacNadji1(this));
    }
    
// Promenljivo!!!  
void napuniDomenskiObjekatIzGrafickogObjekta()   {
       sk= new DKSkiKarta();
       sk.setSifraSkiKarte(getInteger(ef.getPanel().getSifraSkiKarte()));
       sk.setImePrezimeKupca(ef.getPanel().getImePrezimeKupca());
       sk.setSifraSkiCentra(getInteger(ef.getPanel().getSifraSkiCentra()));
       if(!ef.getPanel().getCena().equals("")){
           sk.setCena(Double.parseDouble(ef.getPanel().getCena()));
       }
       SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
       java.util.Date Datum = java.sql.Date.valueOf(sdf.format(ef.getPanel().getDatumIzdavanja())); 
       sk.setDatumIzdavanja(Datum); 
       sk.setStanje(ef.getPanel().getStanje()); 
    
    }

// Promenljivo!!!
public void napuniGrafickiObjekatIzDomenskogObjekta(DKSkiKarta sk){
       ef.getPanel().setSifraSkiKarte(Integer.toString(sk.getSifraSkiKarte()));
       ef.getPanel().setImePrezimeKupca(sk.getImePrezimeKupca());
       ef.getPanel().setSifraSkiCentra(Integer.toString(sk.getSifraSkiCentra()));
       ef.getPanel().setCena(Double.toString(sk.getCena()));
       ef.getPanel().setDatum(sk.getDatumIzdavanja());
       ef.getPanel().setStanje(sk.getStanje());
      
    }

// Promenljivo!!!
void isprazniGrafickiObjekat(){

 ef.getPanel().setSifraSkiKarte("");
 ef.getPanel().setImePrezimeKupca("");
 ef.getPanel().setSifraSkiCentra("0");
 ef.getPanel().setCena("0");
 ef.getPanel().setDatum(new java.util.Date());
 ef.getPanel().setStanje("neobradjen");
}

public void prikaziPoruku() 
{ ef.getPanel().setPoruka(poruka);
      
  Timer timer = new Timer();
  
  timer.schedule(new TimerTask() {
  @Override
  public void run() {
    ef.getPanel().setPoruka(""); 
  }
}, 3000);
  
}

 public int getInteger(String s) {
    int broj = 0;
    try
        {
            if(s != null)
                broj = Integer.parseInt(s);
        }
            catch (NumberFormatException e)
            { broj = 0;}
   
    return broj;
}


 
boolean zapamtiDomenskiObjekat(){ 
    
    bbp.makeConnection();
    boolean signal = bbp.insertRecord(sk);
    if (signal==true) 
        { bbp.commitTransation();
          poruka ="???????????? ???? ???????????????? ???????? ?????? ??????????."; // Promenljivo!!!
        }
        else
        { bbp.rollbackTransation();
          poruka ="???????????? ???? ???????? ???? ?????????????? ???????? ?????? ??????????."; // Promenljivo!!!  
        }
    prikaziPoruku();
    bbp.closeConnection();
    return signal; 
       
    }
    
boolean kreirajDomenskiObjekat(){
    boolean signal;
    sk= new DKSkiKarta(); // Promenljivo!!!
    AtomicInteger counter = new AtomicInteger(0);
    
    bbp.makeConnection();
    if (!bbp.getCounter(sk,counter)) return false;
    if (!bbp.increaseCounter(sk,counter)) return false;
          
    sk.setSifraSkiKarte(counter.get()); // Promenljivo!!!
    signal = bbp.insertRecord(sk);
    if (signal==true) 
        { bbp.commitTransation();
          napuniGrafickiObjekatIzDomenskogObjekta(sk);
          poruka = "???????????? ???? ?????????????? ???????? ?????? ??????????."; // Promenljivo!!!
        }
        else
        { bbp.rollbackTransation();
        isprazniGrafickiObjekat();
        poruka ="???????????? ???? ???????? ???? ???????????? ???????? ?????? ??????????."; // Promenljivo!!!
        }
    prikaziPoruku();
    bbp.closeConnection();
    return signal;
}


Stanje odrediStanjeSkiKarte()
{
    bbp.makeConnection();
    Stanje st = null;
    DKSkiKarta sk1 = (DKSkiKarta)bbp.findRecord(sk);
    bbp.closeConnection();
    if (sk1 != null) 
        { if (sk1.getStanje().equals("obradjen")) {st = new Obradjen(this);} 
          if (sk1.getStanje().equals("neobradjen")) {st = new Neobradjen(this);}
          if (sk1.getStanje().equals("storniran")) {st = new Storniran(this);} 
        }
        else
        {  st = new NullStanje(this);
        }
    return st;
}

void obradiDomenskiObjekat(){
    Stanje st = odrediStanjeSkiKarte();
    st.obradiDomenskiObjekat();
}

void stornirajDomenskiObjekat(){
    Stanje st = odrediStanjeSkiKarte();
    st.stornirajDomenskiObjekat();
}


void promeniDomenskiObjekat1(){
   Stanje st = odrediStanjeSkiKarte();
   st.promeniDomenskiObjekat();
}


 @Override
 public boolean promeniDomenskiObjekat(){
    bbp.makeConnection();
    boolean signal = bbp.updateRecord(sk);
    if (signal==true) 
        { bbp.commitTransation();
          poruka = "???????????? je ???????????????? ?????? ??????????."; // Promenljivo!!!
        }
        else
        { bbp.rollbackTransation();
          isprazniGrafickiObjekat();
          poruka = "???????????? ???? ???????? ???? ?????????????? ?????? ??????????."; // Promenljivo!!!
        }
    prikaziPoruku();
    bbp.closeConnection();
    return signal;   
}


public boolean nadjiDomenskiObjekat(){
    boolean signal;
    bbp.makeConnection();
    sk = (DKSkiKarta)bbp.findRecord(sk); // Promenljivo!!!
    if (sk != null) 
        { napuniGrafickiObjekatIzDomenskogObjekta(sk);
          poruka = "???????????? je ?????????? ?????? ??????????."; // Promenljivo!!!
          signal = true;
        }
        else
        { isprazniGrafickiObjekat();
          poruka ="???????????? ???? ???????? ???? ???????? ?????? ??????????."; // Promenljivo!!!
          signal = false;
        }
    prikaziPoruku();
    bbp.closeConnection();
    return signal;   
}



 @Override
 public boolean nadjiDomenskiObjekat1(){
    boolean signal;
    bbp.makeConnection();
    sk = (DKSkiKarta)bbp.findRecord(sk); 
    if (sk != null) 
        { napuniGrafickiObjekatIzDomenskogObjekta(sk);
          signal = true;
        }
        else
        { isprazniGrafickiObjekat();
          signal = false;
        }
    bbp.closeConnection();
    return signal;   
}

}



class OsluskivacZapamti implements ActionListener
{   Kontroler1 kon;
 
    OsluskivacZapamti(Kontroler1 kon1) {kon = kon1;}
    
@Override
    public void actionPerformed(ActionEvent e) {
         kon.napuniDomenskiObjekatIzGrafickogObjekta();
         kon.zapamtiDomenskiObjekat();
        
    }
}

class OsluskivacKreiraj implements ActionListener
{   Kontroler1 kon;
 
    OsluskivacKreiraj(Kontroler1 kon1) {kon = kon1;}
    
@Override
    public void actionPerformed(ActionEvent e) {
         kon.kreirajDomenskiObjekat();
         
        
    }
}

class OsluskivacObradi implements ActionListener
{   Kontroler1 kon;
 
    OsluskivacObradi(Kontroler1 kon1) {kon = kon1;}
    
@Override
    public void actionPerformed(ActionEvent e) {
         kon.napuniDomenskiObjekatIzGrafickogObjekta();
         kon.obradiDomenskiObjekat();
        
    }
}

class OsluskivacStorniraj implements ActionListener
{   Kontroler1 kon;
 
    OsluskivacStorniraj(Kontroler1 kon1) {kon = kon1;}
    
@Override
    public void actionPerformed(ActionEvent e) {
         kon.napuniDomenskiObjekatIzGrafickogObjekta();
         kon.stornirajDomenskiObjekat();
        
    }
}


class OsluskivacPromeni implements ActionListener
{   Kontroler1 kon;
 
    OsluskivacPromeni(Kontroler1 kon1) {kon = kon1;}
    
@Override
    public void actionPerformed(ActionEvent e) {
         kon.napuniDomenskiObjekatIzGrafickogObjekta();
         kon.promeniDomenskiObjekat1();
        
    }
}

class OsluskivacNadji implements ActionListener
{   Kontroler1 kon;
 
    OsluskivacNadji(Kontroler1 kon1) {kon = kon1;}
    
@Override
    public void actionPerformed(ActionEvent e) {
         kon.napuniDomenskiObjekatIzGrafickogObjekta();
         kon.nadjiDomenskiObjekat();
        
    }
}

class OsluskivacNadji1 implements FocusListener
{   Kontroler1 kon;
 
    OsluskivacNadji1(Kontroler1 kon1) {kon = kon1;}
    

    public void focusLost(java.awt.event.FocusEvent e) {
         kon.napuniDomenskiObjekatIzGrafickogObjekta();
         kon.nadjiDomenskiObjekat();
        
    }

    @Override
    public void focusGained(FocusEvent e) {
        
    }
}

