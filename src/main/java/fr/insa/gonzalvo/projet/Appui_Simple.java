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
public class Appui_Simple extends Appui {
    
    private double RAYON_IN_DRAW = 5;
    private Color couleur = Color.BLACK;
    
    public Appui_Simple(Triangle_Terrain TT, int numPoint1, int numPoint2, double posSeg) {
        
        super.setTT(TT);
        super.setNumPoint1(numPoint1);
        super.setNumPoint2(numPoint2);
        super.setPosSeg(posSeg);
    }
    
    public Appui_Simple(Triangle_Terrain TT, int numPoint1, int numPoint2, double posSeg, Color col) {
        this.couleur = col;
        super.setTT(TT);
        super.setNumPoint1(numPoint1);
        super.setNumPoint2(numPoint2);
        super.setPosSeg(posSeg);
    }
       
   @Override
    public void dessine(GraphicsContext context,Treillis Tr) {
        context.setFill(Color.BLACK);
        context.fillOval((super.getPosSeg()*(Tr.getTerrainT().getEnsemblePoint().get(super.getNumPoint2()).getPx())+
                (1-super.getPosSeg())*(Tr.getTerrainT().getEnsemblePoint().get(super.getNumPoint1()).getPx()))
                -RAYON_IN_DRAW, (super.getPosSeg()*(Tr.getTerrainT().getEnsemblePoint().get(super.getNumPoint2())
                        .getPy())+(1-super.getPosSeg())*(Tr.getTerrainT().getEnsemblePoint().get(super.getNumPoint1())
                                .getPy()))-RAYON_IN_DRAW, 2*RAYON_IN_DRAW, 2*RAYON_IN_DRAW);
    }
    
    @Override
    public void dessineSelection(GraphicsContext context, Treillis tr) {
        context.setFill(Color.BLACK);
        
    }

    @Override
    public double getPx(Treillis Tr) {
        return (super.getPosSeg()*(Tr.getTerrainT().getEnsemblePoint().get(super.getNumPoint2()).getPx())+
                (1-super.getPosSeg())*(Tr.getTerrainT().getEnsemblePoint().get(super.getNumPoint1()).getPx()));
    }

    @Override
    public void setPx(double px) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double getPy(Treillis Tr) {
        return (super.getPosSeg()*(Tr.getTerrainT().getEnsemblePoint().get(super.getNumPoint2()).getPy())+
                (1-super.getPosSeg())*(Tr.getTerrainT().getEnsemblePoint().get(super.getNumPoint1()).getPy()));
    }

    @Override
    public void setPy(double py) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void save(Writer w, Numeroteur<Noeuds> numN, Numeroteur<Triangle_Terrain> numTT) throws IOException {
        if(! numN.objExist(this)) {
            int id = numN.creeID(this);
            w.append("Appui_Simple;"+id+";"+numTT.getID(super.getTT())+";"+super.getNumPoint1()+
                    ";"+super.getNumPoint2()+";"+super.getPosSeg()+";"+ Appui_Double.saveColor(this.getCouleur()) + "\n");
        }
    }
    
    public static String saveColor(Color c) {
        return c.getRed()+";"+c.getGreen()+";"+c.getBlue();
    }
    
    @Override
    public Color getCouleur() {
        return couleur;
    }
}
