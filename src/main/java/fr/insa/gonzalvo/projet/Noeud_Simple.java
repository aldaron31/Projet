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
public class Noeud_Simple extends Noeuds {
    //private Point point;
    //private int nbr_barre[];
    private double Nx;
    private double Ny;
    
    public Noeud_Simple(Point P){
        this.Nx = P.getPx();
        this.Ny = P.getPy();
    }
    public Noeud_Simple(double x,double y){
        this.Nx=x;
        this.Ny=y;
    }
    public getListNoeuds
    
}