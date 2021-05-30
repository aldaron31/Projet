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
       this.EnsembleST = new ArrayList<Segment_Terrain>();
       this.EnsemblePoint = new ArrayList<Point>();
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
       
       Point p1 = new Point(5, 600);
       Point p2 = new Point(5, 445);
       Point p3 = new Point(205, 600);
       Point p4 = new Point(405, 445);
       Point p5 = new Point(405, 600);
       Point p6 = new Point(850, 445);
       Point p7 = new Point(850,600);
       Point p8 = new Point(675,600);
       Segment_Terrain ST1 = new Segment_Terrain(p1,p2);
       Segment_Terrain ST2 = new Segment_Terrain(p2,p3);
       Segment_Terrain ST3 = new Segment_Terrain(p3,p1);
       Segment_Terrain ST4 = new Segment_Terrain(p3,p4);
       Segment_Terrain ST5 = new Segment_Terrain(p4,p2);
       Segment_Terrain ST6 = new Segment_Terrain(p4,p5);
       Segment_Terrain ST7 = new Segment_Terrain(p5,p3);
       Segment_Terrain ST8 = new Segment_Terrain(p6,p7);
       Segment_Terrain ST9 = new Segment_Terrain(p7,p8);
       Segment_Terrain ST10 = new Segment_Terrain(p8,p6);
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
       EnsembleST.add(ST1);
       EnsembleST.add(ST2);
       EnsembleST.add(ST3);
       EnsembleST.add(ST4);
       EnsembleST.add(ST5);
       EnsembleST.add(ST6);
       EnsembleST.add(ST7);
       EnsembleST.add(ST8);
       EnsembleST.add(ST9);
       EnsembleST.add(ST10);
       EnsemblePoint.add(p1);
       EnsemblePoint.add(p2);
       EnsemblePoint.add(p3);
       EnsemblePoint.add(p4);
       EnsemblePoint.add(p5);
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

    /*représentation graphique du terrain en dessinant tous
    les triangles du terrain, les points et segments.
    */
    public void dessine(GraphicsContext context) {
        
        if(this.getEnsembleTT() != null) {
            for(Triangle_Terrain TT : this.getEnsembleTT()) {
                TT.dessine(context);
            }
        }
        if(this.getEnsemblePoint() != null) {
            for(Point p : this.getEnsemblePoint()) {
                p.dessine(context);
            }
        }
        if(this.getEnsembleST() != null) {
            for(Segment_Terrain ST : this.getEnsembleST()) {
                ST.dessine(context);
            }
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
    
    public int[] numPointConcou(Segment_Terrain st) {
        int[] numConcou = new int[2];
        Point Debut = st.getDebut();
        Point Fin = st.getFin();
        int i =0;
        for (Point p : this.getEnsemblePoint()) {
            if(p == Debut) {
                numConcou[0] = i;
            }
            if(p == Fin) {
                numConcou[1] = i;
            }
            i++;
        }
        return numConcou;
    }
    
    public Triangle_Terrain trouveTT(Segment_Terrain st) {
        Triangle_Terrain TT = null;
        for(Triangle_Terrain TTl : this.getEnsembleTT()) {
            if(((TTl.getS1().getDebut() == st.getDebut())&&(TTl.getS1().getFin() == st.getFin()))
                    ||((TTl.getS2().getDebut() == st.getDebut())&&(TTl.getS2().getFin() == st.getFin()))
                    ||((TTl.getS3().getDebut() == st.getDebut())&&(TTl.getS3().getFin() == st.getFin()))) {
                TT = TTl;
            }
        }
        return TT;
    }
    
    
    //sauvegarde du terrain
    public void save(Writer w, Numeroteur<Terrain> num, Numeroteur<Triangle_Terrain> numTT, 
            Numeroteur<Segment_Terrain> numS, Numeroteur<Point> numP) throws IOException {
        if (!num.objExist(this)) {
            int id = num.creeID(this);
            for (Triangle_Terrain tt : this.EnsembleTT) {
                tt.save(w, numTT, numS, numP);
            }
            w.append("Terrain;" + id);
            for (Triangle_Terrain tt : this.EnsembleTT) {
                w.append(";" + numTT.getID(tt));
            }
            w.append("\n");
        }
    }
    public boolean existePoint(Point p) {
        int c =0;
        for(Point pe : this.getEnsemblePoint()) {
            if(pe == p) {
                c++;
            }
        }
        if(c==0) {
            return false;
        } else {
            return true;
        }
    }
    
    public boolean existeSeg(Segment_Terrain st) {
        int c =0;
        for(Segment_Terrain ste : this.getEnsembleST()) {
            if((ste.getDebut()==st.getDebut())&&(ste.getFin()==st.getFin())) {
                c++;
            } else if((ste.getDebut()==st.getFin())&&(ste.getFin()==st.getDebut())) {
                c++;
            }
        }
        if(c==0) {
            return false;
        } else {
            return true;
        }
    }
    
    public boolean existeTri(Triangle_Terrain tt) {
        int c =0;
        for(Triangle_Terrain tte : this.getEnsembleTT()) {
            if(tte == tt) {
                c++;
            }
        }
        if(c==0) {
            return false;
        } else {
            return true;
        }
    }
}
