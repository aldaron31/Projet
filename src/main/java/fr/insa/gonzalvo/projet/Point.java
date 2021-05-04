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
public class Point {
    
    private double px;
    private double py;

    public Point() {
        this(0.0, 0.0,Color.black);
    }

    public Point(double px, double py) {
      this(px,py,Color.black);
     }

    public Point(double px, double py, Color c) {
        
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
        return "("+px+","+py+")";
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

    public double minX() {
        return this.px;
    }
    
    public static void testConstructeur() {
        Point p1,p2,p3;
        p1 = new Point();
        p2 = new Point(1, 2);
        p3 = new Point(0, 0, Color.red);
        System.out.println("p1 = " + p1);
        System.out.println("p2 = " + p2);
        System.out.println("p3 = " + p3);
    }

    public static void main(String[] args) {
//        testDistance();
testConstructeur();
testDistance();
    }

}
