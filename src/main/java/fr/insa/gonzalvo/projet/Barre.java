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
    private Color couleur = Color.BLUE;
    
    public Barre(Noeuds ND,Noeuds NF){
        this.NDebut = ND;
        this.NFin = NF;
    }
    
    public Barre(Noeuds ND,Noeuds NF, Color col){
        this.couleur = Color.BLUE;
        this.NDebut = ND;
        this.NFin = NF;
    }
    
    public Noeuds getNDebut() {
        return this.NDebut;
    }
    
    public Noeuds getNFin() {
        return this.NFin;
    }
    public int getid() {
        return id;
    }
    
    //représentation graphique de la barre
    public void dessine(GraphicsContext context, Treillis Tr) {
        context.setStroke(Color.BLUE);
        this.NDebut.dessine(context, Tr);
        this.NFin.dessine(context, Tr);
        context.strokeLine(this.NDebut.getPx(Tr), this.NDebut.getPy(Tr), this.NFin.getPx(Tr), this.NFin.getPy(Tr));
    }
    
    public void save(Writer w, Numeroteur<Barre> numB, Numeroteur<Noeuds> numN, Numeroteur<Triangle_Terrain> numTT) throws IOException {
        if(! numB.objExist(this)) {
            int id = numB.creeID(this);
            this.NDebut.save(w, numN, numTT);
            this.NFin.save(w, numN, numTT);
            w.append("Barre;"+id+";"+numN.getID(this.NDebut)+";"+numN.getID(this.NFin)+
                    ";" + Barre.saveColor(this.getCouleur()) + "\n");
        }
    }
    
    public static String saveColor(Color c) {
        return c.getRed()+";"+c.getGreen()+";"+c.getBlue();
    }
    public Color getCouleur() {
        return couleur;
    }
}
