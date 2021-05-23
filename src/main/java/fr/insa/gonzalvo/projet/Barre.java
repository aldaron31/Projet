/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.insa.gonzalvo.projet;

import static fr.insa.gonzalvo.projet.Point.RAYON_IN_DRAW;
import java.io.IOException;
import java.io.Writer;
import java.util.List;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 *
 * @author gonza
 */
public class Barre {
    private int id;
    private Noeuds NDebut;
    private Noeuds NFin; 
    private Type_Barre type;
    private double traction;
    
    public Barre(Noeuds ND,Noeuds NF){
        this.NDebut = ND;
        this.NFin = NF;
    }
    /*
       public Barre(Noeud_Simple ND,Noeud_Simple NF){
        this.NDebut = ND;
        this.NFin = NF;
    }
    */
    public Noeuds getNDebut() {
        return this.NDebut;
    }
    
    public Noeuds getNFin() {
        return this.NFin;
    }
    

    public void dessine(GraphicsContext context) {
        context.setStroke(Color.BLACK);
        context.strokeLine(this.NDebut.getPx(), this.NDebut.getPy(), this.NFin.getPx(), this.NFin.getPy());
    }
}
