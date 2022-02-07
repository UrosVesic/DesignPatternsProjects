

package Direktor;

import Builder.*;


public class Sef { // Facade
        Projektant proj;    
        
public Sef (){proj = new Projektant1(); }   

public void kreirajSoftverskiSistem() {proj.kreirajSoftverskiSistem();}
public void kreirajEkranskuFormu() { proj.kreirajEkranskuFormu();}
public void kreirajBrokerBazePodataka(){ proj.kreirajBrokerBazePodataka();}
public void kreirajKontroler(){ proj.kreirajKontroler();}
public void prikaziEkranskuFormu (){ proj.prikaziEkranskuFormu();}
  
}
