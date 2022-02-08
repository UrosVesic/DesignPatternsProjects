/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Memento;

import DomainClasses.DKSkiKarta;

/**
 *
 * @author UrosVesic
 */
public class Memento {
    DKSkiKarta dksk;
    
    public Memento(DKSkiKarta dksk){this.dksk = dksk;}
    
    public DKSkiKarta getState() {return dksk;}
    public void setState(DKSkiKarta dksk) {this.dksk = dksk;}
}
