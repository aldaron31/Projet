/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.insa.gonzalvo.projet;

import static fr.insa.gonzalvo.projet.Point.RAYON_IN_DRAW;
import java.io.IOException;
import java.io.Writer;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 *
 * @author gonza
 */
public abstract class Appui extends Noeuds{
    
    private int id;
    private Triangle_Terrain TT;
    private int numPoint1;
    private int numPoint2;
    private double posSeg;
    
    public int getid() {
        return id;
    }
    
    @Override
    //représentation graphique de l'appui
    public abstract void dessine(GraphicsContext context, Treillis Tr);

    /**
     * @return the TT
     */
    public Triangle_Terrain getTT() {
        return TT;
    }

    /**
     * @return the numPoint1
     */
    public int getNumPoint1() {
        return numPoint1;
    }

    /**
     * @return the numPoint2
     */
    public int getNumPoint2() {
        return numPoint2;
    }

    /**
     * @return the posSeg
     */
    public double getPosSeg() {
        return posSeg;
    }

    /**
     * @param TT the TT to set
     */
    public void setTT(Triangle_Terrain TT) {
        this.TT = TT;
    }

    /**
     * @param numPoint1 the numPoint1 to set
     */
    public void setNumPoint1(int numPoint1) {
        this.numPoint1 = numPoint1;
    }

    /**
     * @param numPoint2 the numPoint2 to set
     */
    public void setNumPoint2(int numPoint2) {
        this.numPoint2 = numPoint2;
    }

    /**
     * @param posSeg the posSeg to set
     */
    public void setPosSeg(double posSeg) {
        this.posSeg = posSeg;
    }
    
    @Override
    public double getPx(Treillis Tr){
        return (this.getPosSeg()*(Tr.getTerrainT().getEnsemblePoint().get(this.getNumPoint2()).getPx())+
                (1-this.getPosSeg())*(Tr.getTerrainT().getEnsemblePoint().get(this.getNumPoint1()).getPx()));
    }
    
    @Override
    public double getPy(Treillis Tr){
        return (this.getPosSeg()*(Tr.getTerrainT().getEnsemblePoint().get(this.getNumPoint2()).getPy())+
                (1-this.getPosSeg())*(Tr.getTerrainT().getEnsemblePoint().get(this.getNumPoint1()).getPy()));
    }
    
    public abstract void save(Writer w, Numeroteur<Noeuds> numN, Numeroteur<Triangle_Terrain> numTT) throws IOException;
    
    public abstract Color getCouleur();
}
