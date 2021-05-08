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
    // identificateur
    protected int id;
    private Treillis TreillisNoeuds;
    //vecteur somme des forces
    protected double fx;
    protected double fy;
    
    public Treillis getTreillisNoeuds(){
        return this.TreillisNoeuds;
    }
    
    public void setTreillisNoeuds(Treillis Treillis){
    this.TreillisNoeuds=Treillis;
    }
}
