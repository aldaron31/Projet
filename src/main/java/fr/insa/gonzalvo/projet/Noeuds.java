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
    
    // identificateur
/*    protected int identificateur;
    private Treillis TreillisNoeuds;
    //vecteur somme des forces
    protected double fx;
    protected double fy;
    
    
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
    
    public Noeuds plusProcheN(Point p, double distMax, Treillis Tr) {
        if (Tr.getContientN().size() == 0) {
            return null;
        } else {
            Noeuds nmin = Tr.getContientN().get(0);
            double min = Tr.distancePointN(p, nmin);
            for (int i = 1; i < Tr.getContientN().size(); i++) {
                Noeuds ncur = Tr.getContientN().get(i);
                double cur = Tr.distancePointN(p, ncur);
                if (cur < min) {
                    min = cur;
                    nmin = ncur;
                }
            }
            if (min <= distMax) {
                return nmin;
            } else {
                return null;
            }
        }
    }
}
