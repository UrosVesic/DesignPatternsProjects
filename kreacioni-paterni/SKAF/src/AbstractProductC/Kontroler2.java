/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AbstractProductC;

import AbstractProductA.EkranskaForma;
import AbstractProductB.BrokerBazePodataka;
import DomainClasses.DKSkiKarta;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.text.SimpleDateFormat;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @author UrosVesic
 */
public class Kontroler2 extends Kontroler{
     public Kontroler2(EkranskaForma ef1,BrokerBazePodataka bbp1){ef=ef1;bbp=bbp1; Povezi(); osveziFormu();}
    
    void Povezi()
    {javax.swing.JButton Kreiraj = ef.getPanel().getKreiraj();
     javax.swing.JButton Promeni = ef.getPanel().getPromeni();
     javax.swing.JButton Obrisi = ef.getPanel().getObrisi();
     javax.swing.JButton Nadji = ef.getPanel().getNadji();
     Kreiraj.addActionListener( new OsluskivacKreiraj1(this));
     Promeni.addActionListener( new OsluskivacPromeni1(this));
     Obrisi.addActionListener( new OsluskivacObrisi1(this));
     Nadji.addActionListener( new OsluskivacNadji11(this));
     
     javax.swing.JTextField SifraPrijave = ef.getPanel().getSifraSkiKarte1(); // Promenljivo!!!
     SifraPrijave.addFocusListener( new OsluskivacNadji12(this));
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
    
    }

// Promenljivo!!!
void napuniGrafickiObjekatIzDomenskogObjekta(DKSkiKarta sk){
       ef.getPanel().setSifraSkiKarte(Integer.toString(sk.getSifraSkiKarte()));
       ef.getPanel().setImePrezimeKupca(sk.getImePrezimeKupca());
       ef.getPanel().setSifraSkiCentra(Integer.toString(sk.getSifraSkiCentra()));
       ef.getPanel().setCena(Double.toString(sk.getCena()));
       ef.getPanel().setDatum(sk.getDatumIzdavanja());
      
    }

// Promenljivo!!!
void isprazniGrafickiObjekat(){

 ef.getPanel().setSifraSkiKarte("");
 ef.getPanel().setImePrezimeKupca("");
 ef.getPanel().setSifraSkiCentra("0");
 ef.getPanel().setCena("0");
 ef.getPanel().setDatum(new java.util.Date());
}


void prikaziPoruku() 
{ ef.getPanel().setPoruka(poruka);
      
  Timer timer = new Timer();
  
  timer.schedule(new TimerTask() {
  @Override
  public void run() {
    ef.getPanel().setPoruka(""); 
  }
}, 3000);
  
}


void prikaziPoruku(String poruka) 
{ ef.getPanel().setPoruka(poruka);
      
  Timer timer = new Timer();
  
  timer.schedule(new TimerTask() {
  @Override
  public void run() {
    ef.getPanel().setPoruka(poruka); 
  }
}, 1000);
  
}

void osveziFormu() 
{    
  Timer timer = new Timer();
  
  timer.scheduleAtFixedRate(new TimerTask() {
  @Override
  public void run() {
      napuniDomenskiObjekatIzGrafickogObjekta();
      nadjiDomenskiObjekat();
      prikaziPoruku("???????????????????? ??????????!!!");
  }
}, 0,5000);
  
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

boolean obrisiDomenskiObjekat(){
    bbp.makeConnection();
    boolean signal = bbp.deleteRecord(sk);
    if (signal==true) 
        { bbp.commitTransation();
          poruka = "???????????? je o???????????? ?????? ??????????."; // Promenljivo!!!
            isprazniGrafickiObjekat();
        }
        else
        { bbp.rollbackTransation();
          poruka = "???????????? ???? ???????? ???? ???????????? ?????? ??????????."; // Promenljivo!!!
        }
    prikaziPoruku();
    bbp.closeConnection();
    return signal;   
}

boolean promeniDomenskiObjekat(){
    bbp.makeConnection();
    boolean signal = bbp.updateRecord(sk);
    if (signal==true) 
        { bbp.commitTransation();
          poruka = "???????????? je ???????????????? ?????? ??????????."; // Promenljivo!!!
        }
        else
        { bbp.rollbackTransation();
          isprazniGrafickiObjekat();
          poruka = "???????????? ???? ???????? ???? ?????????????? ?????? ??????????"; // Promenljivo!!!
        }
    prikaziPoruku();
    bbp.closeConnection();
    return signal;   
}


boolean nadjiDomenskiObjekat(){
    boolean signal;
    bbp.makeConnection();
    sk = (DKSkiKarta)bbp.findRecord(sk); // Promenljivo!!!
    if (sk != null) 
        { napuniGrafickiObjekatIzDomenskogObjekta(sk);
          poruka = "???????????? je ?????????? ?????? ??????????.";  // Promenljivo!!!
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

}

class OsluskivacZapamti1 implements ActionListener
{   Kontroler2 kon;
 
    OsluskivacZapamti1(Kontroler2 kon1) {kon = kon1;}
    
@Override
    public void actionPerformed(ActionEvent e) {
         kon.napuniDomenskiObjekatIzGrafickogObjekta();
         kon.zapamtiDomenskiObjekat();
        
    }
}

class OsluskivacKreiraj1 implements ActionListener
{   Kontroler2 kon;
 
    OsluskivacKreiraj1(Kontroler2 kon1) {kon = kon1;}
    
@Override
    public void actionPerformed(ActionEvent e) {
         kon.kreirajDomenskiObjekat();
         
        
    }
}

class OsluskivacObrisi1 implements ActionListener
{   Kontroler2 kon;
 
    OsluskivacObrisi1(Kontroler2 kon1) {kon = kon1;}
    
@Override
    public void actionPerformed(ActionEvent e) {
         kon.napuniDomenskiObjekatIzGrafickogObjekta();
         kon.obrisiDomenskiObjekat();
        
    }
}

class OsluskivacPromeni1 implements ActionListener
{   Kontroler2 kon;
 
    OsluskivacPromeni1(Kontroler2 kon1) {kon = kon1;}
    
@Override
    public void actionPerformed(ActionEvent e) {
         kon.napuniDomenskiObjekatIzGrafickogObjekta();
         kon.promeniDomenskiObjekat();
        
    }
}

class OsluskivacNadji11 implements ActionListener
{   Kontroler2 kon;
 
    OsluskivacNadji11(Kontroler2 kon1) {kon = kon1;}
    
@Override
    public void actionPerformed(ActionEvent e) {
         kon.napuniDomenskiObjekatIzGrafickogObjekta();
         kon.nadjiDomenskiObjekat();
        
    }
}

class OsluskivacNadji12 implements FocusListener
{   Kontroler2 kon;
 
    OsluskivacNadji12(Kontroler2 kon1) {kon = kon1;}
    

    public void focusLost(java.awt.event.FocusEvent e) {
         kon.napuniDomenskiObjekatIzGrafickogObjekta();
         kon.nadjiDomenskiObjekat();
        
    }

    @Override
    public void focusGained(FocusEvent e) {
       
    }
}
