/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.insa.gonzalvo.projet.gui;

import fr.insa.gonzalvo.projet.Terrain;
import fr.insa.gonzalvo.projet.Treillis;
import java.util.List;
import javafx.scene.layout.Pane;
import javafx.scene.canvas.Canvas;
import javafx.scene.paint.Color;
import javafx.scene.canvas.GraphicsContext;


public class DessinTreillis extends Pane {
    
    private MainPane main;
    
    private Canvas realCanvas;
    
    public DessinTreillis(MainPane main) {
        this.main = main;
        this.realCanvas = new Canvas(this.getWidth(),this.getHeight());
        this.getChildren().add(this.realCanvas);
        this.realCanvas.heightProperty().bind(this.heightProperty());
        this.realCanvas.heightProperty().addListener((o) -> {
            System.out.println("w = " + this.realCanvas.getWidth() + " h = " + this.realCanvas.getHeight());
            this.redrawAll();
        });
        this.realCanvas.widthProperty().bind(this.widthProperty());
        this.realCanvas.widthProperty().addListener((o) -> {
            this.redrawAll();
        });
        this.realCanvas.setOnMouseClicked((t) -> {
            Controleur control = this.main.getControleur();
            control.clicDansZoneDessin(t);
        });
        this.redrawAll();
    }
    public void redrawAll() {
        GraphicsContext context = this.realCanvas.getGraphicsContext2D();
        Treillis model =  this.main.getModel();
        Terrain Tmodel = this.main.getModel().getTerrainT();
        model.dessine(context);
        Tmodel.dessine(context);
    }
}
