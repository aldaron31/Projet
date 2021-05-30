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
    private double Px;
    private double Py;
    private Color couleur = Color.GRAY;
    private double RAYON_IN_DRAW = 5;
    
    public Noeud_Simple(Point P){
        this.Px = P.getPx();
        this.Py = P.getPy();
    }
    public Noeud_Simple(double x,double y, Color col){
        this.couleur = Color.BLACK;
        this.Px=x;
        this.Py=y;
    }
    
    public Noeud_Simple(double x,double y){
        this.Px=x;
        this.Py=y;
    }
    
    @Override
    //représentation graphique du noeud simple
    public void dessine(GraphicsContext context, Treillis Tr) {
        context.setFill(Color.GRAY);
        context.fillOval(this.getPx(Tr)-RAYON_IN_DRAW, this.getPy(Tr)-RAYON_IN_DRAW, 2*RAYON_IN_DRAW, 2*RAYON_IN_DRAW);
    }
    
    @Override
    //représentation graphique lors de la sélection
    public void dessineSelection(GraphicsContext context, Treillis Tr) {
        context.setFill(Color.RED);
        context.fillOval(this.getPx(Tr)-RAYON_IN_DRAW, this.getPy(Tr)-RAYON_IN_DRAW, 2*RAYON_IN_DRAW, 2*RAYON_IN_DRAW);
    }
    
    @Override
    public double getPx(Treillis Tr) {
        return Px;
    }

    @Override
    public void setPx(double Px) {
        this.Px = Px;
    }

    @Override
    public double getPy(Treillis Tr) {
        return Py;
    }

    @Override
    public void setPy(double Py) {
        this.Py = Py;
    }
    
    @Override
    public Color getCouleur() {
        return couleur;
    }

    public void setCouleur(Color couleur) {
        this.couleur = couleur;
    }
    
    @Override
    public void save(Writer w, Numeroteur<Noeuds> numN, Numeroteur<Triangle_Terrain> numTT) throws IOException {
        if(! numN.objExist(this)) {
            int id = numN.creeID(this);
            Treillis Tr = new Treillis();
            w.append("Noeud_Simple;"+id+";"+this.getPx(Tr)+";"+this.getPy(Tr)+
                    ";" + Noeud_Simple.saveColor(this.getCouleur()) + "\n");
        }
    }
    
    public static String saveColor(Color c) {
        return c.getRed()+";"+c.getGreen()+";"+c.getBlue();
    }
    
}