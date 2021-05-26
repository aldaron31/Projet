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
    private Color couleur = Color.GRAY;
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
        context.setFill(this.getCouleur());
        context.fillOval(this.getPx()-RAYON_IN_DRAW, this.getPy()-RAYON_IN_DRAW, 2*RAYON_IN_DRAW, 2*RAYON_IN_DRAW);
    }
    
    @Override
    public void dessineSelection(GraphicsContext context) {
        context.setFill(Color.RED);
        context.fillOval(this.getPx()-RAYON_IN_DRAW, this.getPy()-RAYON_IN_DRAW, 2*RAYON_IN_DRAW, 2*RAYON_IN_DRAW);
    }
    /**
     * @return the Px
     */
    public double getPx() {
        return Px;
    }

    /**
     * @param Px the Px to set
     */
    public void setPx(double Px) {
        this.Px = Px;
    }

    /**
     * @return the Py
     */
    public double getPy() {
        return Py;
    }

    /**
     * @param Py the Py to set
     */
    public void setPy(double Py) {
        this.Py = Py;
    }

    /**
     * @return the couleur
     */
    public Color getCouleur() {
        return couleur;
    }

    /**
     * @param couleur the couleur to set
     */
    public void setCouleur(Color couleur) {
        this.couleur = couleur;
    }
    
    
}