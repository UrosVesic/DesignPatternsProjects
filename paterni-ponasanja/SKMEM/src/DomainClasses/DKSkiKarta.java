/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DomainClasses;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author UrosVesic
 */
public class DKSkiKarta implements Serializable, OpstiDomenskiObjekat {

    private int sifraSkiKarte;
    private String imePrezimeKupca;
    private double cena;
    private int sifraSkiCentra;
    private Date datumIzdavanja;

    public DKSkiKarta() {
        sifraSkiKarte = 0;
        imePrezimeKupca = "";
        cena = 0;
        sifraSkiCentra = 0;
        SimpleDateFormat sm = new SimpleDateFormat("yyyy-MM-dd");
        Date dDatum = new Date();
        datumIzdavanja = java.sql.Date.valueOf(sm.format(dDatum));
    }

    public DKSkiKarta(int sifraSkiKarte, String imePrezimeKupca, double cena, int sifraSkiCentra, Date datumIzdavanja) {
        this.sifraSkiKarte = sifraSkiKarte;
        this.imePrezimeKupca = imePrezimeKupca;
        this.cena = cena;
        this.sifraSkiCentra = sifraSkiCentra;
        this.datumIzdavanja = datumIzdavanja;
    }

    public DKSkiKarta(DKSkiKarta state) {
        this.sifraSkiKarte = state.sifraSkiKarte;
        this.imePrezimeKupca = state.imePrezimeKupca;
        this.sifraSkiCentra = state.sifraSkiCentra;
        this.cena = state.cena;
        this.datumIzdavanja = state.datumIzdavanja;
    }

    // Primarni kljuc		
    public DKSkiKarta(int sifraSkiKarte) {
        this.sifraSkiKarte = sifraSkiKarte;
    }

    public int getSifraSkiKarte() {
        return sifraSkiKarte;
    }

    public void setSifraSkiKarte(int sifraSkiKarte) {
        this.sifraSkiKarte = sifraSkiKarte;
    }

    public String getImePrezimeKupca() {
        return imePrezimeKupca;
    }

    public void setImePrezimeKupca(String imePrezimeKupca) {
        this.imePrezimeKupca = imePrezimeKupca;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public int getSifraSkiCentra() {
        return sifraSkiCentra;
    }

    public void setSifraSkiCentra(int sifraSkiCentra) {
        this.sifraSkiCentra = sifraSkiCentra;
    }

    public Date getDatumIzdavanja() {
        return datumIzdavanja;
    }

    public void setDatumIzdavanja(Date datumIzdavanja) {
        this.datumIzdavanja = datumIzdavanja;
    }

    @Override
    public String getAtrValue() {
        SimpleDateFormat sm = new SimpleDateFormat("yyyy-MM-dd");
        Date dDatum = datumIzdavanja;
        datumIzdavanja = java.sql.Date.valueOf(sm.format(dDatum));
        return sifraSkiKarte + ", " + (imePrezimeKupca == null ? null : "'" + imePrezimeKupca + "'") + ", " + cena + ", " + sifraSkiCentra + ", " + "'" + datumIzdavanja + "'";
    }

    @Override
    public String setAtrValue() {
        SimpleDateFormat sm = new SimpleDateFormat("yyyy-MM-dd");
        Date dDatum = datumIzdavanja;
        datumIzdavanja = java.sql.Date.valueOf(sm.format(dDatum));
        return "sifraSkiKarte=" + sifraSkiKarte + ", " + "imePrezimeKupca=" + (imePrezimeKupca == null ? null : "'" + imePrezimeKupca + "'") + ", " + "cena=" + cena + ", " + "sifraSkiCentra=" + sifraSkiCentra + ", " + "datumizdavanja=" + "'" + datumIzdavanja + "'";
    }

    @Override
    public String getClassName() {
        return "DKSkiKarta";
    }

    @Override
    public String getWhereCondition() {
        return "sifraSkiKarte = " + sifraSkiKarte;
    }

    @Override
    public String getNameByColumn(int column) {
        String names[] = {"sifraSkiKarte", "imePrezimeKupca", "cena", "sifraSkiCentra", "datumIzdavanja"};
        return names[column];
    }

    @Override
    public OpstiDomenskiObjekat getNewRecord(ResultSet rs) throws SQLException {
        return new DKSkiKarta(rs.getInt("sifraSkiKarte"), rs.getString("imePrezimeKupca"), rs.getInt("cena"), rs.getInt("sifraSkiCentra"), new Date(rs.getDate("datumIzdavanja").getTime()));
    }

}
