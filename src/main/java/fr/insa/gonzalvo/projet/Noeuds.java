/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.insa.gonzalvo.projet;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 *
 * @author gonza
 */
public abstract class Noeuds {
    
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
    public abstract void dessine(GraphicsContext context, Treillis Tr);
    public abstract void dessineSelection(GraphicsContext context, Treillis Tr);

   
    public abstract double getPx(Treillis Tr);
    public abstract void setPx(double px);
    public abstract double getPy(Treillis Tr);
    public abstract void setPy(double py);
    

    public List<Barre> getbarreconcou() {
        return this.barreconcou;
    }
    public void setbarreconcou(List<Barre> L) {
        this.barreconcou=L;
    }
    
    public abstract void save(Writer w, Numeroteur<Noeuds> numN, Numeroteur<Triangle_Terrain> numTT) throws IOException;
    
    public abstract Color getCouleur();
}
