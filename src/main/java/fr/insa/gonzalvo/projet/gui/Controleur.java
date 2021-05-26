/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.insa.gonzalvo.projet.gui;

import fr.insa.gonzalvo.projet.Barre;
import fr.insa.gonzalvo.projet.Noeud_Simple;
import fr.insa.gonzalvo.projet.Noeuds;
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
    
    private List<Noeuds> contientN;
    
    public Controleur(MainPane vue) {
        this.vue = vue;
        //this.selection = new ArrayList<>();
    }
    
    
    
    public void changeEtat(int nouvelEtat) {
        if (nouvelEtat == 10) {
            // Début
            this.getVue().getRbPoints().setVisible(false);
            this.getVue().getRbSegments_Terrain().setVisible(false);
            this.getVue().getRbTrianglesT().setVisible(false);
            this.getVue().getRbBarres().setVisible(false);
            this.getVue().getRbNoeuds().setVisible(false);
            this.getVue().getRbNoeuds_Simple().setVisible(false);
            this.getVue().getRbAppui().setVisible(false);
            this.getVue().getRbAppui_Simple().setVisible(false);
            this.getVue().getRbAppui_Double().setVisible(false);
            this.getVue().getRbAppui_Encastre().setVisible(false);
            this.getVue().redrawAll();
        } else if (nouvelEtat == 20) {
            // sélection
            this.getVue().getModel().getContientN().removeAll();
        } else if (nouvelEtat == 100) {
            // édition Terrain
            this.getVue().getRbPoints().setVisible(true);
            this.getVue().getRbSegments_Terrain().setVisible(true);
            this.getVue().getRbTrianglesT().setVisible(true);
            this.getVue().getRbBarres().setVisible(false);
            this.getVue().getRbNoeuds().setVisible(false);
            this.getVue().redrawAll();
        } else if (nouvelEtat == 110) {
            // création Point
            this.getVue().redrawAll();
        } else if (nouvelEtat == 120) {
            // creation de segments étape 1
            this.getVue().getRbSelect().setDisable(false);
            this.getVue().getRbPoints().setDisable(false);
            this.getVue().getRbTrianglesT().setDisable(false);
            this.getVue().redrawAll();
        } else if (nouvelEtat == 121) {
            // creation de segments étape 2
            this.getVue().getRbSelect().setDisable(true);
            this.getVue().getRbPoints().setDisable(true);
            this.getVue().getRbTrianglesT().setDisable(true);
            this.getVue().redrawAll();
        } else if (nouvelEtat == 130) {
            // creation Triangle étape 1
            this.getVue().getRbSelect().setDisable(false);
            this.getVue().getRbPoints().setDisable(false);
            this.getVue().getRbSegments_Terrain().setDisable(false);
            this.getVue().redrawAll();
        } else if (nouvelEtat == 131) {
            // creation Triangle étape 2
            this.getVue().getRbSelect().setDisable(true);
            this.getVue().getRbPoints().setDisable(true);
            this.getVue().getRbSegments_Terrain().setDisable(true);
            this.getVue().redrawAll();
        } else if (nouvelEtat == 132) {
            // creation Triangle étape 3
            this.getVue().redrawAll();
        } else if (nouvelEtat == 200) {
            // édition Treillis
            this.getVue().getRbBarres().setVisible(true);
            this.getVue().getRbNoeuds().setVisible(true);
            this.getVue().getRbNoeuds_Simple().setVisible(true);
            this.getVue().getRbAppui().setVisible(true);
            this.getVue().getRbAppui_Simple().setVisible(true);
            this.getVue().getRbAppui_Double().setVisible(true);
            this.getVue().getRbAppui_Encastre().setVisible(true);
            this.getVue().getRbPoints().setVisible(false);
            this.getVue().getRbSegments_Terrain().setVisible(false);
            this.getVue().getRbTrianglesT().setVisible(false);
            this.getVue().redrawAll();
        } else if (nouvelEtat == 210) {
            // création Noeuds
            this.getVue().redrawAll();
        } else if (nouvelEtat == 211) {
            // création Noeuds_Simple
            this.getVue().redrawAll();
        } else if (nouvelEtat == 212) {
            // création Appui
            this.getVue().redrawAll();
        } else if (nouvelEtat == 213) {
            // création Appui_Double
            this.getVue().redrawAll();
        } else if (nouvelEtat == 214) {
            // création Appui_Encastré
            this.getVue().redrawAll();
        } else if (nouvelEtat == 215) {
            // création Appui_Simple
            this.getVue().redrawAll();
        } else if (nouvelEtat == 220) {
            // création Barres
            this.getVue().redrawAll();
        }
        this.etat = nouvelEtat;
    }

    void clicDansZoneDessin(MouseEvent t) {
        if (this.etat == 20) {
            Point pclic = new Point(t.getX(), t.getY());
            // pas de limite de distance entre le clic et l'objet selectionné
            Noeuds proche = this.getVue().getModel().getEnsembleNoeuds().get(0).plusProcheN(pclic, Double.MAX_VALUE, this.getVue().getModel());
            // il faut tout de même prévoir le cas ou le groupe est vide
            // donc pas de plus proche
            if (proche != null) {
                if (t.isShiftDown()) {
                    this.getVue().getModel().getContientN().add(proche);
                } else if (t.isControlDown()) {
                    if (this.getVue().getModel().getContientN().contains(proche)) {
                        this.getVue().getModel().getContientN().remove(proche);
                    } else {
                        this.getVue().getModel().getContientN().add(proche);
                    }
                } else {
                    this.getVue().getModel().getContientN().removeAll();
                    this.getVue().getModel().getContientN().add(proche);
                }
                this.activeBoutonsSuivantSelection();
                this.getVue().redrawAll();
            }
        } else  if (this.etat == 100) {
            
        } else  if (this.etat == 110) {
            double px = t.getX();
            double py = t.getY();
            Treillis model = this.getVue().getModel();
            model.getTerrainT().getEnsemblePoint().add(new Point(px, py));
            this.getVue().redrawAll();
        } else if (this.etat == 120) {
            this.pclic1 = new Point(t.getX(), t.getY());
            this.changeEtat(121);
        } else if (this.etat == 121) {
            this.pclic2 = new Point(t.getX(), t.getY());
            Treillis model = this.getVue().getModel();
            model.getTerrainT().getEnsembleST().add(new Segment_Terrain(pclic1, pclic2));
            this.getVue().redrawAll();
            this.changeEtat(120);
        } else if (this.etat == 130){
            this.pclic1 = new Point(t.getX(), t.getY());
            this.changeEtat(131);
        } else if (this.etat == 131){
            this.pclic2 = new Point(t.getX(), t.getY());
            this.changeEtat(132);
        } else if (this.etat == 132) {
            this.pclic3 = new Point(t.getX(), t.getY());
            Treillis model = this.getVue().getModel();
            model.getTerrainT().getEnsembleTT().add(new Triangle_Terrain(pclic1, pclic2,pclic3));
            this.getVue().redrawAll();
            this.changeEtat(130);
        } else if (this.etat == 200) {
            
        } else if (this.etat == 210) {
            
        } else if (this.etat == 211) {
            double px = t.getX();
            double py = t.getY();
            Treillis model = this.getVue().getModel();
            model.getEnsembleNoeuds().add(new Noeud_Simple(px, py));
            this.getVue().redrawAll();
        } else if (this.etat == 212) {
            
        } else if (this.etat == 213) {
            
        } else if (this.etat == 214) {
            
        } else if (this.etat == 215) {
            
        } else if (this.etat == 220) {
            this.contientN = new ArrayList<Noeuds>();
            if (t.isShiftDown()) {
                Point pclic = new Point(t.getX(), t.getY());
                Noeuds proche = this.vue.getModel().procheNoeuds(pclic);
                this.contientN.add(proche);
            } else {
                Noeuds nclic = new Noeud_Simple(t.getX(), t.getY());
                Treillis model = this.getVue().getModel();
                model.getEnsembleNoeuds().add(nclic);
                this.contientN.add(nclic);
            }
            this.changeEtat(221);
        } else if (this.etat == 221) {
            if (t.isShiftDown()) {
                Point pclic = new Point(t.getX(), t.getY());
                Noeuds proche = this.vue.getModel().procheNoeuds(pclic);
                Treillis model = this.getVue().getModel();
                model.getEnsembleBarres().add(new Barre(this.contientN.get(0), proche));
                this.getVue().redrawAll();
            } else {
                Noeuds nclic = new Noeud_Simple(t.getX(), t.getY());
                Treillis model = this.getVue().getModel();
                model.getEnsembleNoeuds().add(nclic);
                model.getEnsembleBarres().add(new Barre(this.contientN.get(0), nclic));
                this.getVue().redrawAll();
            }
            this.changeEtat(220);
        }
    }
    
    public void boutonSelect(ActionEvent t) {
        this.changeEtat(20);
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
    
    public void boutonNoeuds(ActionEvent t) {
        this.changeEtat(210);
    }

    public void boutonNoeuds_Simple(ActionEvent t) {
        this.changeEtat(211);
    }
    
    public void boutonAppui(ActionEvent t) {
        this.changeEtat(212);
    }
    
    public void boutonAppui_Double(ActionEvent t) {
        this.changeEtat(213);
    }
    
    public void boutonAppui_Encastre(ActionEvent t) {
        this.changeEtat(214);
    }
    
    public void boutonAppui_Simple(ActionEvent t) {
        this.changeEtat(215);
    }
    
    public void boutonBarres(ActionEvent t) {
        this.changeEtat(220);
    }
    
    private void activeBoutonsSuivantSelection() {
        if (this.getVue().getModel().getContientN().size() < 2) {
        } else {
        }
    }
    
    private void realSave(File f) {
        try {
            this.getVue().getModel().sauvegarde(f);
            this.getVue().setCurFile(f);
            this.getVue().getInStage().setTitle(f.getName());
        } catch (IOException ex) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText("Problème durant la sauvegarde");
            alert.setContentText(ex.getLocalizedMessage());

            alert.showAndWait();
        } finally {
            this.changeEtat(10);
        }
    }

    public void menuSave(ActionEvent t) {
        if (this.getVue().getCurFile() == null) {
            this.menuSaveAs(t);
        } else {
            this.realSave(this.getVue().getCurFile());
        }
    }

    public void menuSaveAs(ActionEvent t) {
        FileChooser chooser = new FileChooser();
        File f = chooser.showSaveDialog(this.getVue().getInStage());
        if (f != null) {
            this.realSave(f);
        }
    }

    public void menuOpen(ActionEvent t) {
        FileChooser chooser = new FileChooser();
        File f = chooser.showOpenDialog(this.getVue().getInStage());
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
                this.changeEtat(10);
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
    
    public void menuTerrain(ActionEvent t) {
        this.changeEtat(100);
    }
    
    public void menuTreillis(ActionEvent t) {
        this.changeEtat(200);
    }

    public void menuApropos(ActionEvent t) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("A propos");
        alert.setHeaderText(null);
        alert.setContentText("Logiceil de création de Treillis par Timothé, Noé et Pablo");

        alert.showAndWait();
    }

    /**
     * @return the vue
     */
    public MainPane getVue() {
        return vue;
    }
}
