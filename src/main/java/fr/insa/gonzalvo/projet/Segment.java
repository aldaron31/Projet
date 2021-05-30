/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.insa.gonzalvo.projet;

import static java.lang.Math.sqrt;

/**
 *
 * @author Admin
 */
public class Segment {
    private double XS;
    private double YS;
    public Segment(double x,double y){
        this.XS=x;
        this.YS=y;
    }
    
    public Segment(){
        this(0,0);
    }

    public double getXS() {
        return XS;
    }

    public double getYS() {
        return YS;
    }

    public void setXS(double XS) {
        this.XS = XS;
    }

    public void setYS(double YS) {
        this.YS = YS;
    }
    
    public double LongueurSegment(){
        
       return (sqrt((this.XS*this.XS)+(this.YS*this.YS)));
    }
}
