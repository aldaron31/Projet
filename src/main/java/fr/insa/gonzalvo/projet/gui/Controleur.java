/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.insa.gonzalvo.projet.gui;

import fr.insa.gonzalvo.projet.Point;
import fr.insa.gonzalvo.projet.Segment_Terrain;
import fr.insa.gonzalvo.projet.Treillis;
import fr.insa.gonzalvo.projet.Terrain;
import fr.insa.gonzalvo.projet.Triangle_Terrain;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 *
 * @author Elève
 */
public class Controleur {
    
    private MainPane vue;
    private int etat;
    
    private Point pclic1;
    private Point pclic2;
    private Point pclic3;
    
    public Controleur(MainPane vue) {
        this.vue = vue;
        //this.selection = new ArrayList<>();
    }
    
    public void changeEtat(int nouvelEtat) {
        if (nouvelEtat == 10) {
            // Début
            this.vue.getRbBarres().setVisible(false);
            this.vue.getRbNoeuds().setVisible(false);
            this.vue.getRbPoints().setVisible(false);
            this.vue.getRbSegments_Terrain().setVisible(false);
            this.vue.getRbTrianglesT().setVisible(false);
            this.vue.redrawAll();
        } else if (nouvelEtat == 20) {
            // sélection
        } else if (nouvelEtat == 100) {
            // édition Terrain
            this.vue.getRbPoints().setVisible(true);
            this.vue.getRbSegments_Terrain().setVisible(true);
            this.vue.getRbTrianglesT().setVisible(true);
            this.vue.getRbBarres().setVisible(false);
            this.vue.getRbNoeuds().setVisible(false);
            this.vue.redrawAll();
        } else if (nouvelEtat == 110) {
            // création Point
            this.vue.redrawAll();
        } else if (nouvelEtat == 120) {
            // creation de segments étape 1
            this.vue.redrawAll();
        } else if (nouvelEtat == 121) {
            // creation de segments étape 2
            this.vue.redrawAll();
        } else if (nouvelEtat == 130) {
            // creation Triangle étape 1
            this.vue.redrawAll();
        } else if (nouvelEtat == 131) {
            // creation Triangle étape 2
            this.vue.redrawAll();
        } else if (nouvelEtat == 132) {
            // creation Triangle étape 3
            this.vue.redrawAll();
        } else if (nouvelEtat == 200) {
            // édition Treillis
            this.vue.getRbBarres().setVisible(true);
            this.vue.getRbNoeuds().setVisible(true);
            this.vue.getRbPoints().setVisible(false);
            this.vue.getRbSegments_Terrain().setVisible(false);
            this.vue.getRbTrianglesT().setVisible(false);
            this.vue.redrawAll();
        } else if (nouvelEtat == 210) {
            // création Noeuds
            this.vue.redrawAll();
        } else if (nouvelEtat == 211) {
            // création Noeuds_Simple
            this.vue.redrawAll();
        } else if (nouvelEtat == 212) {
            // création Appui
            this.vue.redrawAll();
        } else if (nouvelEtat == 213) {
            // création Appui_Double
            this.vue.redrawAll();
        } else if (nouvelEtat == 214) {
            // création Appui_Encastré
            this.vue.redrawAll();
        } else if (nouvelEtat == 215) {
            // création Appui_Simple
            this.vue.redrawAll();
        } else if (nouvelEtat == 220) {
            // création Barres
            this.vue.redrawAll();
        }
        this.etat = nouvelEtat;
    }

    void clicDansZoneDessin(MouseEvent t) {
        if (this.etat == 20) {
            Point pclic = new Point(t.getX(), t.getY());
        } else  if (this.etat == 100) {
            
        } else  if (this.etat == 110) {
            double px = t.getX();
            double py = t.getY();
            Treillis model = this.vue.getModel();
            model.getTerrainT().getEnsemblePoint().add(new Point(px, py));
            this.vue.redrawAll();
        } else if (this.etat == 120) {
            this.pclic1 = new Point(t.getX(), t.getY());
            this.changeEtat(121);
        } else if (this.etat == 121) {
            this.pclic2 = new Point(t.getX(), t.getY());
            Treillis model = this.vue.getModel();
            model.getTerrainT().getEnsembleST().add(new Segment_Terrain(pclic1, pclic2));
            this.vue.redrawAll();
            this.changeEtat(120);
        } else if (this.etat == 130){
            this.pclic1 = new Point(t.getX(), t.getY());
            this.changeEtat(131);
        } else if (this.etat == 131){
            this.pclic2 = new Point(t.getX(), t.getY());
            this.changeEtat(132);
        } else if (this.etat == 132) {
            this.pclic3 = new Point(t.getX(), t.getY());
            Treillis model = this.vue.getModel();
            model.getTerrainT().getEnsembleTT().add(new Triangle_Terrain(pclic1, pclic2,pclic3));
            this.vue.redrawAll();
            this.changeEtat(130);
        } else if (this.etat == 200) {
            
        } else if (this.etat == 210) {
            
        } else if (this.etat == 211) {
            
        } else if (this.etat == 212) {
            
        } else if (this.etat == 213) {
            
        } else if (this.etat == 214) {
            
        } else if (this.etat == 215) {
            
        } else if (this.etat == 220) {
            
        }
    }
    
    public void boutonSelect(ActionEvent t) {
        this.changeEtat(20);
    }
    
    public void boutonTerrain(ActionEvent t) {
        this.changeEtat(100);
    }

    public void boutonPoints(ActionEvent t) {
        this.changeEtat(110);
    }

    public void boutonSegments(ActionEvent t) {
        this.changeEtat(120);
    }
    
    public void boutonTriangles(ActionEvent t) {
        this.changeEtat(130);
    }
    
    public void boutonTreillis(ActionEvent t) {
        this.changeEtat(200);
    }
    
    public void boutonNoeuds(ActionEvent t) {
        this.changeEtat(210);
    }

    public void boutonBarres(ActionEvent t) {
        this.changeEtat(220);
    }
    
    private void realSave(File f) {
        try {
            this.vue.getModel().sauvegarde(f);
            this.vue.setCurFile(f);
            this.vue.getInStage().setTitle(f.getName());
        } catch (IOException ex) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText("Problème durant la sauvegarde");
            alert.setContentText(ex.getLocalizedMessage());

            alert.showAndWait();
        } finally {
            this.changeEtat(20);
        }
    }

    public void menuSave(ActionEvent t) {
        if (this.vue.getCurFile() == null) {
            this.menuSaveAs(t);
        } else {
            this.realSave(this.vue.getCurFile());
        }
    }

    public void menuSaveAs(ActionEvent t) {
        FileChooser chooser = new FileChooser();
        File f = chooser.showSaveDialog(this.vue.getInStage());
        if (f != null) {
            this.realSave(f);
        }
    }

    public void menuOpen(ActionEvent t) {
        FileChooser chooser = new FileChooser();
        File f = chooser.showOpenDialog(this.vue.getInStage());
        if (f != null) {
            try {
                Treillis lue = Treillis.lecture(f);
                Treillis glu = (Treillis) lue;
                Stage nouveau = new Stage();
                nouveau.setTitle(f.getName());
                Scene sc = new Scene(new MainPane(nouveau, f, glu), 800, 600);
                nouveau.setScene(sc);
                nouveau.show();
            } catch (Exception ex) {
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Erreur");
                alert.setHeaderText("Problème durant la sauvegarde");
                alert.setContentText(ex.getLocalizedMessage());

                alert.showAndWait();
            } finally {
                this.changeEtat(20);
            }
        }
    }
//    }

    public void menuNouveau(ActionEvent t) {
        Stage nouveau = new Stage();
        nouveau.setTitle("Nouveau");
        Scene sc = new Scene(new MainPane(nouveau), 1000, 650);
        nouveau.setScene(sc);
        nouveau.show();
    }

    public void menuApropos(ActionEvent t) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("A propos");
        alert.setHeaderText(null);
        alert.setContentText("Logiceil de création de Treillis par Timothé, Noé et Pablo");

        alert.showAndWait();
    }
}
