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
public class Segment_Terrain {
    
    private Point debut;
    private Point fin;
    
    public Segment_Terrain(Point debut,Point fin,Color c){
        
        this.debut=debut;
        this.fin=fin;
    }
    
    public Segment_Terrain(Point debut,Point fin){
        this(debut,fin,Color.BLUE);
    }
    
    private Segment_Terrain() {
        this(null, null);
    }
    
    public Point getDebut(){
        return debut;
    }
    public Point getFin(){
        return fin;
    }
    public String DefSegment(){
        return "("+this.debut.DefPoint()+","+this.fin.DefPoint()+")";
    }
     @Override
    public String toString() {
        return "[" + this.debut + "," + this.fin + ']';
    }

    public static Segment_Terrain demandeSegment() {
        System.out.println("point début : ");
        Point deb = Point.demandePoint();
        System.out.println("point fin : ");
        Point fin = Point.demandePoint();
        return new Segment_Terrain(deb, fin);
    }
    
    public void dessine(GraphicsContext context) {
        context.setStroke(Color.GREEN);
        context.strokeLine(this.debut.getPx(), this.debut.getPy(), this.fin.getPx(), this.fin.getPy());
        this.getDebut().dessine(context);
        this.getFin().dessine(context);
    }
}
