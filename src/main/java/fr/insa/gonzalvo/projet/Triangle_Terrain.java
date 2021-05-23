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
public class Triangle_Terrain {
   private Point p1;
   private Point p2;
   private Point p3;
   private Segment_Terrain s1;
   private Segment_Terrain s2;
   private Segment_Terrain s3;
   private int id;
   private Color couleur = Color.GREEN;
   
   //constructeur où on indique les 3 points
   public Triangle_Terrain(Point p1, Point p2, Point p3) {
       
       this.p1 = p1;
       this.p2 = p2;
       this.p3 = p3;
       this.s1 = new Segment_Terrain(p1, p2);
       this.s2 = new Segment_Terrain(p2, p3);
       this.s3 = new Segment_Terrain(p3, p1);
       
   }
   
   public Triangle_Terrain(Point p1, Point p2, Point p3, Segment_Terrain s1, Segment_Terrain s2, Segment_Terrain s3, Color col) {
       this.couleur = col;
       this.p1 = p1;
       this.p2 = p2;
       this.p3 = p3;
       this.s1 = s1;
       this.s2 = s2;
       this.s3 = s3;
       
   }
    /**
     * @return the p1
     */
    public Point getP1() {
        return p1;
    }

    /**
     * @param p1 the p1 to set
     */
    public void setP1(Point p1) {
        this.p1 = p1;
    }

    /**
     * @return the p2
     */
    public Point getP2() {
        return p2;
    }

    /**
     * @param p2 the p2 to set
     */
    public void setP2(Point p2) {
        this.p2 = p2;
    }

    /**
     * @return the p3
     */
    public Point getP3() {
        return p3;
    }

    /**
     * @param p3 the p3 to set
     */
    public void setP3(Point p3) {
        this.p3 = p3;
    }

    /**
     * @return the s1
     */
    public Segment_Terrain getS1() {
        return s1;
    }

    /**
     * @param s1 the s1 to set
     */
    public void setS1(Segment_Terrain s1) {
        this.s1 = s1;
    }

    /**
     * @return the s2
     */
    public Segment_Terrain getS2() {
        return s2;
    }

    /**
     * @param s2 the s2 to set
     */
    public void setS2(Segment_Terrain s2) {
        this.s2 = s2;
    }

    /**
     * @return the s3
     */
    public Segment_Terrain getS3() {
        return s3;
    }

    /**
     * @param s3 the s3 to set
     */
    public void setS3(Segment_Terrain s3) {
        this.s3 = s3;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }
    
    public void dessine(GraphicsContext context) {
        this.p1.dessine(context);
        this.p2.dessine(context);
        this.p3.dessine(context);
        this.s1.dessine(context);
        this.s2.dessine(context);
        this.s3.dessine(context);
        
    }
    
    public boolean Test_Triangle_Point (Triangle_Terrain T, Point p) {
       //Variable qui contient le signe de l'angle
       int angle1;
       int angle2;
       int angle3;
       //on commence par angle1
       if (getP1().getPx()<getP2().getPx()) {
           //le vecteur est vers la droite
           if (p.getPy()<getP1().getPy() && p.getPy()<getP2().getPy()) {
              //p est en dessous du segment, donc l'angle est >pi et donc neg
              angle1=-1;
           }
           else {
               //sinon il est au dessus donc angle est pos
               angle1=1;
           }
           
       }
       else {
           //le vecteur est vers la gauche
           if (p.getPy()<getP1().getPy() && p.getPy()<getP2().getPy()) {
               //p est en dessous, donc en allant dans le sens trigo,
               //il est <pi donc angle pos
               angle1=1;
           }
           else {
               //sinon il est au dessus donc angle est neg
               angle1=-1;
           }
       }
       //on fait les autres angles
       if (getP2().getPx()<getP3().getPx()) {
           if (p.getPy()<getP2().getPy() && p.getPy()<getP3().getPy()) {
              angle2=-1;
           }
           else {
               angle2=1;
           }
       }
       else {
           if (p.getPy()<getP2().getPy() && p.getPy()<getP3().getPy()) {
               angle2=1;
           }
           else {
               angle2=-1;
           }
       }
       //angle3
       if (getP3().getPx()<getP1().getPx()) {
           if (p.getPy()<getP3().getPy() && p.getPy()<getP1().getPy()) {
              angle3=-1;
           }
           else {
               angle3=1;
           }
       }
       else {
           if (p.getPy()<getP3().getPy() && p.getPy()<getP1().getPy()) {
               angle3=1;
           }
           else {
               angle3=-1;
           }
       }
       //Si tous les angles sont de même signe, alors p est dans le triangle
       if (angle1<=0 && angle2<=0 && angle3<=0) {
           return true;
       }
       else if (angle1>=0 && angle2>=0 && angle3>=0) {
           return true;
       }
       else {
           return false;
       }
   }
    
    public void save(Writer w, Numeroteur<Triangle_Terrain> num, Numeroteur<Segment_Terrain> numS, Numeroteur<Point> numP) throws IOException {
        if(! num.objExist(this)) {
            int id = num.creeID(this);
            this.p1.save(w, numP);
            this.p2.save(w, numP);
            this.p3.save(w, numP);
            this.s1.save(w, numS, numP);
            this.s2.save(w, numS, numP);
            this.s3.save(w, numS, numP);
            w.append("TriangleT;"+id+";"+numP.getID(this.p1)+";"+numP.getID(this.p2)+
                    ";"+numP.getID(this.p3)+";"+numS.getID(this.s1)+";"+numS.getID(this.s2)+
                    ";"+numS.getID(this.s3)+";" + Triangle_Terrain.saveColor(this.getCouleur()) + "\n");
        }
    }
    
    public static String saveColor(Color c) {
        return c.getRed()+";"+c.getGreen()+";"+c.getBlue();
    }
    public Color getCouleur() {
        return couleur;
    }
}
