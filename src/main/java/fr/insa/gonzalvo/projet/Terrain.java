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
 * @author Elève
 */
public class Terrain {
    
   private double xmin;
   private double xmax;
   private double ymin;
   private double ymax;
   private List<Triangle_Terrain> EnsembleTT;
   private List<Point> EnsemblePoint;
   private List<Segment_Terrain> EnsembleST;
   
   public Terrain(double xmin, double xmax, double ymin, double ymax, ArrayList<Triangle_Terrain> EnsembleTT) {
       
       this.xmin = xmin;
       this.xmax = xmax;
       this.ymin = ymin;
       this.ymax = ymax;
       this.EnsembleTT = EnsembleTT;
   }
   
   public Terrain() {
       
       this.xmin = 0;
       this.xmax = 1000;
       this.ymin = 0;
       this.ymax = 1000;
       this.EnsembleTT = new ArrayList<Triangle_Terrain>();
   }
   
   public Terrain(List<Triangle_Terrain> EnsembleTT, List<Point> EnsemblePoint, List<Segment_Terrain> EnsembleST) {
       
       this.xmin = 0;
       this.xmax = 1000;
       this.ymin = 0;
       this.ymax = 1000;
       this.EnsembleTT = EnsembleTT;
       this.EnsemblePoint = EnsemblePoint;
       this.EnsembleST = EnsembleST;
   }
   
   public static Terrain TerrainTest() {
       
       Point p1 = new Point(5, 645);
       Point p2 = new Point(5, 445);
       Point p3 = new Point(205, 645);
       Point p4 = new Point(405, 445);
       Point p5 = new Point(405, 645);
       Point p6 = new Point(875, 445);
       Point p7 = new Point(875,645);
       Point p8 = new Point(675,645);
       Triangle_Terrain TT1 = new Triangle_Terrain(p1,p2,p3);
       Triangle_Terrain TT2 = new Triangle_Terrain(p2,p3,p4);
       Triangle_Terrain TT3 = new Triangle_Terrain(p3,p4,p5);
       Triangle_Terrain TT4 = new Triangle_Terrain(p6,p7,p8);
       List<Triangle_Terrain> EnsembleTT = new ArrayList<Triangle_Terrain>();
       List<Point> EnsemblePoint = new ArrayList<Point>();
       List<Segment_Terrain> EnsembleST = new ArrayList<Segment_Terrain>();
       EnsembleTT.add(TT1);
       EnsembleTT.add(TT2);
       EnsembleTT.add(TT3);
       EnsembleTT.add(TT4);
       EnsemblePoint.add(p6);
       EnsemblePoint.add(p7);
       EnsemblePoint.add(p8);
       Terrain TerrainTest = new Terrain(EnsembleTT, EnsemblePoint, EnsembleST);
       return TerrainTest;
   }

    /**
     * @return the xmin
     */
    public double getXmin() {
        return xmin;
    }

    /**
     * @param xmin the xmin to set
     */
    public void setXmin(double xmin) {
        this.xmin = xmin;
    }

    /**
     * @return the xmax
     */
    public double getXmax() {
        return xmax;
    }

    /**
     * @param xmax the xmax to set
     */
    public void setXmax(double xmax) {
        this.xmax = xmax;
    }

    /**
     * @return the ymin
     */
    public double getYmin() {
        return ymin;
    }

    /**
     * @param ymin the ymin to set
     */
    public void setYmin(double ymin) {
        this.ymin = ymin;
    }

    /**
     * @return the ymax
     */
    public double getYmax() {
        return ymax;
    }

    /**
     * @param ymax the ymax to set
     */
    public void setYmax(double ymax) {
        this.ymax = ymax;
    }

    /**
     * @return the EnsembleTT
     */
    public List<Triangle_Terrain> getEnsembleTT() {
        return EnsembleTT;
    }

    /**
     * @param EnsembleTT the EnsembleTT to set
     */
    public void setEnsembleTT(List<Triangle_Terrain> EnsembleTT) {
        this.EnsembleTT = EnsembleTT;
    }
    
    public List<Point> getEnsemblePoint() {
        return EnsemblePoint;
    }

    public void setEnsemblePoint(List<Point> EnsemblePoint) {
        this.EnsemblePoint = EnsemblePoint;
    }

    public void dessine(GraphicsContext context) {
        for(Triangle_Terrain TT : this.getEnsembleTT()) {
            TT.dessine(context);
        }
        for(Point p : this.getEnsemblePoint()) {
            p.dessine(context);
        }
        for(Segment_Terrain ST : this.getEnsembleST()) {
            ST.dessine(context);
        }
            
    }

    /**
     * @return the EnsembleST
     */
    public List<Segment_Terrain> getEnsembleST() {
        return EnsembleST;
    }

    /**
     * @param EnsembleST the EnsembleST to set
     */
    public void setEnsembleST(List<Segment_Terrain> EnsembleST) {
        this.EnsembleST = EnsembleST;
    }
}
