


package AbstractProductA;



import java.awt.event.KeyEvent;
import java.util.Date;

// Promenljivo!!!
public abstract class Panel extends javax.swing.JPanel{
       
       public abstract String getSifraSkiKarte(); // Promenljivo!!!
       public abstract javax.swing.JTextField getSifraSkiKarte1(); 
       public abstract String getImePrezimeKupca(); // Promenljivo!!!
       public abstract String getCena(); // Promenljivo!!!
       public abstract String getSifraSkiCentra(); // Promenljivo!!!
       public abstract Date getDatumIzdavanja(); // Promenljivo!!!
       
       public abstract void setSifraSkiKarte(String sifraSkiKarte); // Promenljivo!!!
       public abstract void setImePrezimeKupca(String imePrezimeKupca); // Promenljivo!!!
       public abstract void setCena(String cena); // Promenljivo!!!
       public abstract void setSifraSkiCentra(String sifraSkiCentra); // Promenljivo!!!
       public abstract void setDatum(Date Datum); // Promenljivo!!!
       
       public abstract void setPoruka(String Poruka);
       
       public abstract javax.swing.JButton getKreiraj(); 
       public abstract javax.swing.JButton getPromeni(); 
       public abstract javax.swing.JButton getObrisi(); 
       public abstract javax.swing.JButton getNadji();
       public abstract javax.swing.JButton getMemento();
       
       
       
}
