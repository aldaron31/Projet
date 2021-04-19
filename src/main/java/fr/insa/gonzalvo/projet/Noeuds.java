/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.insa.gonzalvo.projet;

/**
 *
 * @author gonza
 */
public abstract class Noeuds {
    //position du noeud
    protected double px;
    protected double py;
    //vecteur somme des forces
    protected double fx;
    protected double fy;
    
    //méthodes de base
    public void setpx(double px) {
        this.px=px;
    }     
    public double getpx() {
        return px;
    }
    public void setpy(double py) {
        this.py=py;
    }     
    public double getpy() {
        return py;
    }
}
