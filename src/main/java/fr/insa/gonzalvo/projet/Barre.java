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
public class Barre {
    private Treillis TreillisBarre;
    private int id;
    private Noeuds Na;
    private Noeuds Nb;
    private Type_Barre type;
    private double traction;
    
    public Treillis getTreillisBarre(){
        return this.TreillisBarre;
    }
    
    public void setTreillisBarre(Treillis Treillis){
        this.TreillisBarre = Treillis ;
    }
}
