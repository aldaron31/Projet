/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.insa.gonzalvo.projet;

import java.util.List;
import Matrice;

/**
 *
 * @author gonza
 */
public class Barre {
    private Treillis TreillisBarre;
    private int id;
    private Noeuds NDebut;
    private Noeuds NFin;
    private Type_Barre type;
    private double traction;
    
    /*
    public Treillis getTreillisBarre(){
        return this.TreillisBarre;
    }
    
    public void setTreillisBarre(Treillis Treillis){
        this.TreillisBarre = Treillis ;
    }
*/
    public List<Barre> getListBarres(){
        return this.TreillisBarre.getEnsembleBarres();
    }
    
    public void setListBarres(List<Barre> ListBarre){
        this.TreillisBarre.setEnsembleBarres(ListBarre);
    }
    
    public Barre(Noeuds Na, Noeuds Nb) {
        this.NDebut=Na;
        this.NFin=Nb;
        int i=100;
        while (i<100 && Tab_Barre[i]!=0) {
        
    }
    }
}
