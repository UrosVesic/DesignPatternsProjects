/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DomainClasses;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author UrosVesic
 */
public class DKSkiCentar implements GeneralDObject {

    private int sifraSkiCentra;
    private String nazivSkiCentra;

    public DKSkiCentar() {
    }

    public DKSkiCentar(int sifraSkiCentra, String nazivSkiCentra) {
        this.sifraSkiCentra = sifraSkiCentra;
        this.nazivSkiCentra = nazivSkiCentra;
    }

    public int getSifraSkiCentra() {
        return sifraSkiCentra;
    }

    public void setSifraSkiCentra(int sifraSkiCentra) {
        this.sifraSkiCentra = sifraSkiCentra;
    }

    public String getNazivSkiCentra() {
        return nazivSkiCentra;
    }

    public void setNazivSkiCentra(String nazivSkiCentra) {
        this.nazivSkiCentra = nazivSkiCentra;
    }

    @Override
    public String getNameByColumn(int column) {
        String names[] = {"sifraSkiCentra", "nazivSkiCentra"};
        return names[column];
    }

    @Override
    public GeneralDObject getNewRecord(ResultSet rs) throws SQLException {
        return new DKSkiCentar(rs.getInt("sifraSkiCentra"), rs.getString("nazivSkiCentra"));
    }

    @Override
    public String getAtrValue() {
        return sifraSkiCentra + ", " + (nazivSkiCentra == null ? null : "'" + nazivSkiCentra + "'");
    }

    @Override
    public String setAtrValue() {
        return "SifraPredmeta=" + sifraSkiCentra + ", " + "NazivPredmeta=" + (nazivSkiCentra == null ? null : "'" + nazivSkiCentra + "'");
    }

    @Override
    public String getClassName() {
        return "DKSkiCentar";
    }

    @Override
    public String getWhereCondition() {
        return "sifraSkiCentra = " + sifraSkiCentra;
    }

}
