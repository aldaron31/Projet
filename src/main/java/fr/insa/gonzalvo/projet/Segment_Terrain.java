/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.insa.gonzalvo.projet;
import java.awt.Color;
/**
 *
 * @author gonza
 */
public class Segment_Terrain {
    private Point debut;
    private Point fin;
    private Color c;
    
    public Segment_Terrain(Point debut,Point fin,Color c){
        this.debut=debut;
        this.fin=fin;
        this.c=c;
    }
    
    public Segment_Terrain(Point debut,Point fin){
        this(debut,fin,Color.black);
    }
    
    public Point getDebut(){
        return debut;
    }
    public Point getFin(){
        return fin;
    }
}
