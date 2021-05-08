/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.insa.gonzalvo.projet;

import java.util.List;

/**
 *
 * @author gonza
 */
public class Noeuds {
    // identificateur
    protected int identificateur;
    private Treillis TreillisNoeuds;
    //vecteur somme des forces
    protected double fx;
    protected double fy;
    
    
    public Noeuds(int i,Treillis T){
        this.identificateur=i;
        this.TreillisNoeuds=T;
        
    }
    /*
    public Treillis getTreillisNoeuds(){
        return this.TreillisNoeuds;
    }
    
    public void setTreillisNoeuds(Treillis Treillis){
    this.TreillisNoeuds=Treillis;
    }
*/
    
    public List<Noeuds> getListNoeuds(){
        return this.TreillisNoeuds.getEnsembleNoeuds();
        
    }
    
    public void setListNoeuds(List<Noeuds> ListNoeuds){
        this.TreillisNoeuds.setEnsembleNoeuds(ListNoeuds);
    }
}
