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
    //private Point point;
    //private int nbr_barre[];
    private double Nx;
    private double Ny;
    
    public Noeud_Simple(Point P){
        this.Nx = P.getPx();
        this.Ny = P.getPy();
    }
    public Noeud_Simple(double x,double y){
        this.Nx=x;
        this.Ny=y;
    }

    @Override
    public double maxX() {
        return this.Nx;
    }

    @Override
    public double minX() {
        return this.Nx;
    }

    @Override
    public double maxY() {
       return this.Ny;
    }

    @Override
    public double minY() {
       return this.Ny;
    }

   

    @Override
    public double distancePoint(Point p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void dessine(GraphicsContext context) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void dessineSelection(GraphicsContext context) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void changeCouleur(Color value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void save(Writer w, Numeroteur<Figure> num) throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}