/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.insa.gonzalvo.projet;

import java.util.ArrayList;
import java.util.List;
import javafx.scene.canvas.GraphicsContext;

/**
 *
 * @author gonza
 */
public abstract class Noeuds {
    
    private double px;
    private double py;
    private List<Barre> barreconcou;
    
    
/*    
    
    
    public Noeuds(int i,Treillis T){
        this.identificateur=i;
        this.TreillisNoeuds=T;
        
    }
    
    public Treillis getTreillisNoeuds(){
        return this.TreillisNoeuds;
    }
    
    public void setTreillisNoeuds(Treillis Treillis){
    this.TreillisNoeuds=Treillis;
    }
    
    public List<Noeuds> getListNoeuds(){
        return this.TreillisNoeuds.getEnsembleNoeuds();
        
    }
    
    public void setListNoeuds(List<Noeuds> ListNoeuds){
        this.TreillisNoeuds.setEnsembleNoeuds(ListNoeuds);
    }
*/  
    //représentation graphique du noeud
    public abstract void dessine(GraphicsContext context);
    public abstract void dessineSelection(GraphicsContext context);

    /**
     * @return the px
     */
    public double getPx() {
        return px;
    }

    /**
     * @param px the px to set
     */
    public void setPx(double px) {
        this.px = px;
    }

    /**
     * @return the py
     */
    public double getPy() {
        return py;
    }

    /**
     * @param py the py to set
     */
    public void setPy(double py) {
        this.py = py;
    }
    

    public List<Barre> getbarreconcou() {
        return this.barreconcou;
    }
    public void setbarreconcou(List<Barre> L) {
        this.barreconcou=L;
    }
}
