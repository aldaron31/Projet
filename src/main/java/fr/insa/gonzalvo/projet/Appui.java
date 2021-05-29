/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.insa.gonzalvo.projet;

import static fr.insa.gonzalvo.projet.Point.RAYON_IN_DRAW;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 *
 * @author gonza
 */
public abstract class Appui extends Noeuds{
    protected int id;
    protected Triangle_Terrain TT;
    protected int numero_point;
    protected double position_segment;
    
    public int getid() {
        return id;
    }
    
    @Override
    public void dessine(GraphicsContext context) {
        context.setFill(Color.BLACK);
        context.fillOval(this.position_segment-RAYON_IN_DRAW, this.position_segment-RAYON_IN_DRAW, 2*RAYON_IN_DRAW, 2*RAYON_IN_DRAW);
    }
}
