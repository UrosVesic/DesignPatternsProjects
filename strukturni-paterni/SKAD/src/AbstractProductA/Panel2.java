
package AbstractProductA;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JTextField;

/**
 *
 * @author UrosVesic
 */
public class Panel2 extends Panel {

    /**
     * Creates new form Panel2
     */
    public Panel2() {
        initComponents();
        prepare();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtPoruka = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtSifraKarte = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtImePrezime = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtCena = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtSifraCentra = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        cmbDan = new javax.swing.JComboBox<>();
        cmbMesec = new javax.swing.JComboBox<>();
        cmbGodina = new javax.swing.JComboBox<>();
        btnKreiraj = new javax.swing.JButton();
        btnPromeni = new javax.swing.JButton();
        btnObrisi = new javax.swing.JButton();
        btnNadji = new javax.swing.JButton();

        jLabel1.setText("Poruka: ");

        jLabel2.setText("Sifra ski karte: ");

        jLabel3.setText("Ime i prezime kupca: ");

        jLabel4.setText("Cena: ");

        jLabel5.setText("Sifra ski centra: ");

        jLabel6.setText("Datum izdavanja: ");

        cmbMesec.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));
        cmbMesec.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbMesecItemStateChanged(evt);
            }
        });

        cmbGodina.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbGodinaItemStateChanged(evt);
            }
        });

        btnKreiraj.setText("kreiraj");

        btnPromeni.setText("promeni");

        btnObrisi.setText("obrisi");

        btnNadji.setText("nadji");
        btnNadji.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNadjiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGap(47, 47, 47)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtPoruka, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtSifraKarte)
                                .addGap(105, 105, 105))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtImePrezime)
                            .addComponent(txtCena)
                            .addComponent(txtSifraCentra)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cmbDan, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(cmbMesec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(cmbGodina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnKreiraj)
                        .addGap(32, 32, 32)
                        .addComponent(btnPromeni)
                        .addGap(52, 52, 52)
                        .addComponent(btnObrisi)
                        .addGap(40, 40, 40)
                        .addComponent(btnNadji)))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtPoruka, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtSifraKarte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtImePrezime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtCena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtSifraCentra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cmbDan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbMesec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbGodina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnKreiraj)
                    .addComponent(btnPromeni)
                    .addComponent(btnObrisi)
                    .addComponent(btnNadji))
                .addContainerGap(45, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnNadjiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNadjiActionPerformed
        // TODO add your handling code here:
       
    }//GEN-LAST:event_btnNadjiActionPerformed

    private void cmbMesecItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbMesecItemStateChanged
        // TODO add your handling code here:
        cmbDan.removeAllItems();
        fillCmbDan();
    }//GEN-LAST:event_cmbMesecItemStateChanged

    private void cmbGodinaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbGodinaItemStateChanged
        // TODO add your handling code here:
         cmbDan.removeAllItems();
        fillCmbDan();
    }//GEN-LAST:event_cmbGodinaItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnKreiraj;
    private javax.swing.JButton btnNadji;
    private javax.swing.JButton btnObrisi;
    private javax.swing.JButton btnPromeni;
    private javax.swing.JComboBox<String> cmbDan;
    private javax.swing.JComboBox<String> cmbGodina;
    private javax.swing.JComboBox<String> cmbMesec;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField txtCena;
    private javax.swing.JTextField txtImePrezime;
    private javax.swing.JTextField txtPoruka;
    private javax.swing.JTextField txtSifraCentra;
    private javax.swing.JTextField txtSifraKarte;
    // End of variables declaration//GEN-END:variables

    @Override
    public String getSifraSkiKarte() {
        return txtSifraKarte.getText();
    }

    @Override
    public String getImePrezimeKupca() {
        return txtImePrezime.getText();
    }

    @Override
    public String getCena() {
        return txtCena.getText();
    }

    @Override
    public String getSifraSkiCentra() {
        return txtSifraCentra.getText();
    }

    @Override
    public Date getDatumIzdavanja() {
        String dan = (String) cmbDan.getSelectedItem();
        String mesec = (String) cmbMesec.getSelectedItem();
        String godina = (String) cmbGodina.getSelectedItem();
        String datStr = dan + "." + mesec + "." + godina;
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        try {
            Date datum = sdf.parse(datStr);
            return datum;
        } catch (ParseException ex) {

            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public void setSifraSkiKarte(String sifraSkiKarte) {
        txtSifraKarte.setText(sifraSkiKarte);
    }

    @Override
    public void setImePrezimeKupca(String imePrezimeKupca) {
        txtImePrezime.setText(imePrezimeKupca);
    }

    @Override
    public void setCena(String cena) {
        txtCena.setText(cena);
    }

    @Override
    public void setSifraSkiCentra(String sifraSkiCentra) {
        txtSifraCentra.setText(sifraSkiCentra);
    }

    @Override
    public void setDatum(Date Datum) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy.");
        String datum = sdf.format(Datum);

        String[] niz = datum.split("\\.");
        cmbDan.setSelectedItem(niz[0]);
        cmbMesec.setSelectedItem(niz[1]);
        cmbGodina.setSelectedItem(niz[2]);

    }

    @Override
    public void setPoruka(String Poruka) {
        txtPoruka.setText(Poruka);
    }

    @Override
    public JButton getKreiraj() {
        return btnKreiraj;
    }

    @Override
    public JButton getPromeni() {
        return btnPromeni;
    }

    @Override
    public JButton getObrisi() {
        return btnObrisi;
    }

    @Override
    public JButton getNadji() {
        return btnNadji;
    }

    private void prepare() {
        fillCmbDan();
        fillCmbGodina();
    }

    private void fillCmbDan() {
        if (cmbMesec.getSelectedItem().equals("1") || cmbMesec.getSelectedItem().equals("3") || cmbMesec.getSelectedItem().equals("5")
                || cmbMesec.getSelectedItem().equals("7") || cmbMesec.getSelectedItem().equals("8") || cmbMesec.getSelectedItem().equals("10")
                || cmbMesec.getSelectedItem().equals("12")) {
            for (int i = 1; i <= 31; i++) {
                cmbDan.addItem(String.valueOf(i));
            }
        } else if (cmbMesec.getSelectedItem().equals("2") && Integer.parseInt((String) cmbGodina.getSelectedItem()) % 4 == 0) {

            for (int i = 1; i <= 29; i++) {
                cmbDan.addItem(String.valueOf(i));
            }
        } else if (cmbMesec.getSelectedItem().equals("2") && Integer.parseInt((String) cmbGodina.getSelectedItem()) % 4 != 0) {
            for (int i = 1; i <= 28; i++) {
                cmbDan.addItem(String.valueOf(i));
            }
        } else {

            for (int i = 1; i <= 30; i++) {
                cmbDan.addItem(String.valueOf(i));
            }
        }
    }

    private void fillCmbGodina() {
        for (int i = 2000; i < 2100; i++) {
            cmbGodina.addItem(i + "");
        }
    }

    @Override
    public JTextField getSifraSkiKarte1() {
        return txtSifraKarte;
    }
}
