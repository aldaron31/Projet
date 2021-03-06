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
import static javafx.scene.paint.Color.color;
import recup.Lire;

/**
 *
 * @author gonza
 */
public class Point {
    
    public static double RAYON_IN_DRAW = 5;
    private double px;
    private double py;
    private Color couleur = Color.GREEN;

    public Point() {
        this(0.0, 0.0,Color.BLACK);
    }

    public Point(double px, double py) {
      this(px,py,Color.BLACK);
     }

    public Point(double px, double py, Color c) {
        this.couleur = c;
        this.px = px;
        this.py = py;
    }

    public double getPx() {
        return this.px;
    }

    public void setPx(double px) {
        this.px = px;
    }
    public double getPy() {
        return this.py;
    }

    public void setPy(double py) {
        this.py = py;
    }
    
    public String DefPoint(){
        return "("+this.px+","+this.py+")";
    }

    public double distance(Point p2) {
        double dx = this.px - p2.px;
        double dy = this.py - p2.py;
        return Math.sqrt(dx * dx + dy * dy);
    }

    public Point milieu(Point p2) {
        Point res;
        res = new Point();
        res.px = (this.px + p2.px) / 2;
        res.py = (this.py + p2.py) / 2;
        return res;
    }

    public static void testDistance() {
        Point p1, point2, pp, mi;
        p1 = new Point(0, 0);
        point2 = new Point(1, 2);
        pp = new Point(1, 1);
        double dist = p1.distance(point2);
        double dist2 = pp.distance(p1);
        System.out.println("distance : " + dist);
        mi = p1.milieu(pp);
        System.out.println("milieu : " + mi.DefPoint());
    }
    
    public static void testConstructeur() {
        Point p1,p2,p3;
        p1 = new Point();
        p2 = new Point(1, 2);
        p3 = new Point(0, 0, Color.RED);
        System.out.println("p1 = " + p1);
        System.out.println("p2 = " + p2);
        System.out.println("p3 = " + p3);
    }

    public static void main(String[] args) {
//      testDistance();
        testConstructeur();
        testDistance();
    }
    @Override
    public String toString() {
        return "(" + px + "," + py + ')';
    }
/*
    public static Point demandePoint() {
        System.out.println("abscisse : ");
        double px = Lire.d();
        System.out.println("ordonn??e : ");
        double py = Lire.d();
        return new Point(px, py);
    }
    */
    //repr??sentation graphique du point
    public void dessine(GraphicsContext context) {
        context.setFill(Color.GREEN);
        context.fillOval(this.px-RAYON_IN_DRAW, this.py-RAYON_IN_DRAW, 2*RAYON_IN_DRAW, 2*RAYON_IN_DRAW);
    }
    //sauvegarde du point
    public void save(Writer w, Numeroteur<Point> num) throws IOException {
        if(! num.objExist(this)) {
            int id = num.creeID(this);
            w.append("Point;"+id+";"+this.px+";"+this.py+
                    ";" + Point.saveColor(this.getCouleur()) + "\n");
        }
    }
    
    public static String saveColor(Color c) {
        return c.getRed()+";"+c.getGreen()+";"+c.getBlue();
    }
    public Color getCouleur() {
        return couleur;
    }
    
    public double distancePoint(Point p) {
        double dx = this.px - p.px;
        double dy = this.py - p.py;
        return Math.sqrt(dx*dx+dy*dy);

    }
}
