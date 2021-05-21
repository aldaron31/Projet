/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.insa.gonzalvo.projet.gui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.RadioButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import fr.insa.gonzalvo.projet.Point;
import fr.insa.gonzalvo.projet.Terrain;
import fr.insa.gonzalvo.projet.Treillis;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ToggleGroup;
import javafx.scene.paint.Color;

/**
 *
 * @author Elève
 */
public class MainPane extends BorderPane {
    
    private Treillis model;
    private Controleur controleur;
    
    private RadioButton rbSelect;
    private RadioButton rbNoeuds;
    private RadioButton rbBarres;
    private RadioButton rbPoints;
    private RadioButton rbSegments_Terrain;
    private RadioButton rbTrianglesT;
    
    private Button bGrouper;
    private Button bCalcul;
    private ColorPicker cpCouleur;
    
    private DessinTreillis cDessin;
    
    public MainPane() {
        this(new Treillis());
    }
    
    public MainPane(Treillis model){
        this.model = model;
        this.controleur = new Controleur(this);
        
        this.rbSelect = new RadioButton("Select");
        this.rbSelect.setOnAction((t) -> {
            this.controleur.boutonSelect(t);
        });
        this.rbNoeuds = new RadioButton("Noeuds");
        this.rbNoeuds.setOnAction((t) -> {
            this.controleur.boutonNoeuds(t);
        });
        this.rbBarres = new RadioButton("Barres");
        this.rbBarres.setOnAction((t) -> {
            this.controleur.boutonBarres(t);
        });
        this.rbPoints = new RadioButton("Points");
        this.rbPoints.setOnAction((t) -> {
            this.controleur.boutonPoints(t);
        });
        this.rbSegments_Terrain = new RadioButton("Segments");
        this.rbSegments_Terrain.setOnAction((t) -> {
            this.controleur.boutonSegments(t);
        });
        this.rbTrianglesT = new RadioButton("Triangles");
        this.rbTrianglesT.setOnAction((t) -> {
            this.controleur.boutonTriangles(t);
        });
        
        ToggleGroup bgEtat = new ToggleGroup();
        this.rbSelect.setToggleGroup(bgEtat);
        this.rbNoeuds.setToggleGroup(bgEtat);
        this.rbBarres.setToggleGroup(bgEtat);
        this.rbPoints.setToggleGroup(bgEtat);
        this.rbSegments_Terrain.setToggleGroup(bgEtat);
        this.rbTrianglesT.setToggleGroup(bgEtat);
        this.rbPoints.setSelected(true); 
        
        VBox vbGauche = new VBox(this.getRbSelect(), this.getRbNoeuds(), this.getRbBarres(), this.getRbPoints(), this.getRbSegments_Terrain(), this.getRbTrianglesT());
        this.setLeft(vbGauche);
        
/*        this.bGrouper = new Button("Grouper");
        this.bGrouper.setOnAction((t) -> {
            this.controleur.boutonGrouper(t);
        });
        
        this.cpCouleur = new ColorPicker(Color.BLACK);
        this.cpCouleur.setOnAction((t) -> {
            this.controleur.changeColor(this.cpCouleur.getValue());
        });*/
        
        this.bCalcul = new Button("Calcul");
        this.bCalcul.setOnAction((t) -> {
            System.out.println("bouton Calcul cliqué");
        });
        
        VBox vbDroite = new VBox(this.getbCalcul());
        this.setRight(vbDroite);
        
        this.cDessin = new DessinTreillis(this);
        this.setCenter(this.cDessin);
        this.controleur.changeEtat(30);
    }
    
    public void redrawAll() {
        this.cDessin.redrawAll();
    }
    
    public Treillis getModel() {
        return model;
    }

    public Controleur getControleur() {
        return controleur;
    }

    /**
     * @return the rbSelect
     */
    public RadioButton getRbSelect() {
        return rbSelect;
    }

    /**
     * @return the rbNoeuds
     */
    public RadioButton getRbNoeuds() {
        return rbNoeuds;
    }

    /**
     * @return the rbBarres
     */
    public RadioButton getRbBarres() {
        return rbBarres;
    }

    /**
     * @return the bGrouper
     */
    public Button getbGrouper() {
        return bGrouper;
    }

    /**
     * @return the bCalcul
     */
    public Button getbCalcul() {
        return bCalcul;
    }

    /**
     * @return the cpCouleur
     */
    public ColorPicker getcpCouleur() {
        return cpCouleur;
    }

    /**
     * @return the cDessin
     */
    public DessinTreillis getcDessin() {
        return cDessin;
    }

    /**
     * @return the rbPoints
     */
    public RadioButton getRbPoints() {
        return rbPoints;
    }

    /**
     * @return the rbSegments_Terrain
     */
    public RadioButton getRbSegments_Terrain() {
        return rbSegments_Terrain;
    }

    /**
     * @return the rbTrianglesT
     */
    public RadioButton getRbTrianglesT() {
        return rbTrianglesT;
    }
    
}
