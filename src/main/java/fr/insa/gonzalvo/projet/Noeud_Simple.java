/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.insa.gonzalvo.projet;

import java.io.IOException;
import java.io.Writer;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 *
 * @author gonza
 */
public class Noeud_Simple extends Noeuds {
    //private Point point;
    //private int nbr_barre[];
    private double Px;
    private double Py;
    private double RAYON_IN_DRAW = 5;
    
    public Noeud_Simple(Point P){
        this.Px = P.getPx();
        this.Py = P.getPy();
    }
    public Noeud_Simple(double x,double y){
        this.Px=x;
        this.Py=y;
    }
    
    @Override
    public void dessine(GraphicsContext context) {
        context.setFill(Color.BLACK);
        context.fillOval(this.Px-RAYON_IN_DRAW, this.Py-RAYON_IN_DRAW, 2*RAYON_IN_DRAW, 2*RAYON_IN_DRAW);
    }
}