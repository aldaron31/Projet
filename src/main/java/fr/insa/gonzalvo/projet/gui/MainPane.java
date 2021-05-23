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
import java.io.File;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ToggleGroup;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.Window;

/**
 *
 * @author Elève
 */
public class MainPane extends BorderPane {
    
    private Treillis model;
    private Controleur controleur;
    
    private Stage inStage;
    private File curFile;
    
    private RadioButton rbSelect;
    private RadioButton rbPoints;
    private RadioButton rbSegments_Terrain;
    private RadioButton rbTrianglesT;
    private RadioButton rbNoeuds;
    private RadioButton rbNoeuds_Simple;
    private RadioButton rbAppui;
    private RadioButton rbAppui_Simple;
    private RadioButton rbAppui_Double;
    private RadioButton rbAppui_Encastre;
    private RadioButton rbBarres;
    
    private Button bTerrain;
    private Button bTreillis;
    private Button bCalcul;
    
    private DessinTreillis cDessin;
    private MainMenu menu;
    
    public MainPane(Stage inStage) {
        this(inStage, new Treillis());
    }

    public MainPane(Stage inStage, Treillis model) {
        this(inStage, null, model);
    }
    
    public MainPane(Stage inStage, File fromFile, Treillis model){
        this.inStage = inStage;
        this.curFile = fromFile;
        this.model = model;
        this.controleur = new Controleur(this);
        
        this.rbSelect = new RadioButton("Select");
        this.rbSelect.setOnAction((t) -> {
            this.controleur.boutonSelect(t);
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
        this.rbNoeuds = new RadioButton("Noeuds");
        this.rbNoeuds.setOnAction((t) -> {
            this.controleur.boutonNoeuds(t);
        });
        this.rbBarres = new RadioButton("Barres");
        this.rbBarres.setOnAction((t) -> {
            this.controleur.boutonBarres(t);
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
        
        this.bTerrain = new Button("Terrain");
        this.bTerrain.setOnAction((t) -> {
            this.controleur.boutonTerrain(t);
        });
        
        this.bTreillis = new Button("Treillis");
        this.bTreillis.setOnAction((t) -> {
            this.controleur.boutonTreillis(t);
        });
        
        this.bCalcul = new Button("Calcul");
        this.bCalcul.setOnAction((t) -> {
            System.out.println("bouton Calcul cliqué");
        });
        
        VBox vbDroite = new VBox(this.getbCalcul(), this.getbTerrain(), this.getbTreillis());
        this.setRight(vbDroite);
        
        this.cDessin = new DessinTreillis(this);
        this.setCenter(this.cDessin);
        
        this.menu = new MainMenu(this);
        this.setTop(this.menu);
        
        this.controleur.changeEtat(10);
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
    public Button getbTerrain() {
        return bTerrain;
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
    public Button getbTreillis() {
        return bTreillis;
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

    public Stage getInStage() {
        return inStage;
    }

    public File getCurFile() {
        return curFile;
    }

    public void setCurFile(File curFile) {
        this.curFile = curFile;
    }
    
}
