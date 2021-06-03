/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.insa.gonzalvo.projet.gui;

import fr.insa.gonzalvo.projet.Appui_Double;
import fr.insa.gonzalvo.projet.Appui_Encastre;
import fr.insa.gonzalvo.projet.Appui_Simple;
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
    private List<Point> contientP;
    private List<Object> contientO;
    
    public Controleur(MainPane vue) {
        this.vue = vue;
        //this.selection = new ArrayList<>();
    }
    
    //définit les actions lors d'un changement d'état
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
        } else if (nouvelEtat == 100) {
            // édition Terrain
            this.getVue().getRbPoints().setVisible(true);
            this.getVue().getRbSegments_Terrain().setVisible(true);
            this.getVue().getRbTrianglesT().setVisible(true);
            this.getVue().getRbBarres().setVisible(false);
            this.getVue().getRbNoeuds().setVisible(false);
            this.getVue().getRbNoeuds_Simple().setVisible(false);
            this.getVue().getRbAppui().setVisible(false);
            this.getVue().getRbAppui_Simple().setVisible(false);
            this.getVue().getRbAppui_Double().setVisible(false);
            this.getVue().getRbAppui_Encastre().setVisible(false);
            this.getVue().getRbBarres().setSelected(false);
            this.getVue().getRbNoeuds().setSelected(false);
            this.getVue().getRbNoeuds_Simple().setSelected(false);
            this.getVue().getRbAppui().setSelected(false);
            this.getVue().getRbAppui_Simple().setSelected(false);
            this.getVue().getRbAppui_Double().setSelected(false);
            this.getVue().getRbAppui_Encastre().setSelected(false);
            this.getVue().getRbPoints().setSelected(false);
            this.getVue().getRbSegments_Terrain().setSelected(false);
            this.getVue().getRbTrianglesT().setSelected(false);
            this.getVue().redrawAll();
        } else if (nouvelEtat == 110) {
            // création Point
            this.getVue().redrawAll();
        } else if (nouvelEtat == 120) {
            // creation de segments étape 1
            this.getVue().getRbPoints().setDisable(false);
            this.getVue().getRbTrianglesT().setDisable(false);
            this.getVue().redrawAll();
        } else if (nouvelEtat == 121) {
            // creation de segments étape 2
            this.getVue().getRbPoints().setDisable(true);
            this.getVue().getRbTrianglesT().setDisable(true);
            this.getVue().redrawAll();
        } else if (nouvelEtat == 130) {
            // creation Triangle étape 1
            this.getVue().getRbPoints().setDisable(false);
            this.getVue().getRbSegments_Terrain().setDisable(false);
            this.getVue().redrawAll();
        } else if (nouvelEtat == 131) {
            // creation Triangle étape 2
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
            this.getVue().getRbBarres().setDisable(false);
            this.getVue().getRbNoeuds().setDisable(false);
            this.getVue().getRbNoeuds_Simple().setDisable(true);
            this.getVue().getRbAppui().setDisable(true);
            this.getVue().getRbAppui_Simple().setDisable(true);
            this.getVue().getRbAppui_Double().setDisable(true);
            this.getVue().getRbAppui_Encastre().setDisable(true);
            this.getVue().getRbPoints().setVisible(false);
            this.getVue().getRbSegments_Terrain().setVisible(false);
            this.getVue().getRbTrianglesT().setVisible(false);
            this.getVue().getRbBarres().setSelected(false);
            this.getVue().getRbNoeuds().setSelected(false);
            this.getVue().getRbNoeuds_Simple().setSelected(false);
            this.getVue().getRbAppui().setSelected(false);
            this.getVue().getRbAppui_Simple().setSelected(false);
            this.getVue().getRbAppui_Double().setSelected(false);
            this.getVue().getRbAppui_Encastre().setSelected(false);
            this.getVue().getRbPoints().setSelected(false);
            this.getVue().getRbSegments_Terrain().setSelected(false);
            this.getVue().getRbTrianglesT().setSelected(false);
            this.getVue().redrawAll();
        } else if (nouvelEtat == 210) {
            // création Noeuds
            this.getVue().getRbNoeuds_Simple().setDisable(false);
            this.getVue().getRbAppui().setDisable(false);
            this.getVue().getRbAppui_Simple().setDisable(true);
            this.getVue().getRbAppui_Double().setDisable(true);
            this.getVue().getRbAppui_Encastre().setDisable(true);
            this.getVue().getRbBarres().setDisable(false);
            this.getVue().redrawAll();
        } else if (nouvelEtat == 211) {
            // création Noeuds_Simple
            this.getVue().getRbAppui().setDisable(true);
            this.getVue().getRbBarres().setDisable(true);
            this.getVue().redrawAll();
        } else if (nouvelEtat == 212) {
            // création Appui
            this.getVue().getRbNoeuds_Simple().setDisable(true);
            this.getVue().getRbAppui_Simple().setDisable(false);
            this.getVue().getRbAppui_Double().setDisable(false);
            this.getVue().getRbAppui_Encastre().setDisable(false);
            this.getVue().getRbBarres().setDisable(true);
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
            // création Barres étape 1
            this.getVue().getRbNoeuds().setDisable(false);
            this.getVue().getRbNoeuds_Simple().setDisable(true);
            this.getVue().getRbAppui().setDisable(true);
            this.getVue().getRbAppui_Simple().setDisable(true);
            this.getVue().getRbAppui_Double().setDisable(true);
            this.getVue().getRbAppui_Encastre().setDisable(true);
            this.getVue().redrawAll();
        } else if (nouvelEtat == 221) {
            // création Barres étape 2
            this.getVue().getRbNoeuds().setDisable(true);
            this.getVue().redrawAll();
        }
        this.etat = nouvelEtat;
    }
//définit les actions lors d'un clic dans la zone de dessin en fonction de l'état
    void clicDansZoneDessin(MouseEvent t) {
        Treillis model = this.vue.getModel();
        Terrain mTer = model.getTerrainT();
        if (this.etat == 100) {
            
        } else  if (this.etat == 110) {
            double px = t.getX();
            double py = t.getY();
            mTer.getEnsemblePoint().add(new Point(px, py));
            this.getVue().redrawAll();
        } else if (this.etat == 120) {
            this.contientP = new ArrayList<Point>();
            if (t.isShiftDown()) {
                Point pclic = new Point(t.getX(), t.getY());
                Point proche = model.prochePoint(pclic);
                this.getContientP().add(proche);
            } else {
                this.getContientP().add(new Point(t.getX(), t.getY()));
            }
            this.changeEtat(121);
        } else if (this.etat == 121) {
            if (t.isShiftDown()) {
                Point pclic = new Point(t.getX(), t.getY());
                Point proche = this.vue.getModel().prochePoint(pclic);
                this.getContientP().add(proche);
            } else {
                this.getContientP().add(new Point(t.getX(), t.getY()));
            }
            mTer.getEnsembleST().add(new Segment_Terrain(this.getContientP().get(0), this.getContientP().get(1)));
            if(!mTer.existePoint(this.getContientP().get(0))) {
                mTer.getEnsemblePoint().add(this.getContientP().get(0));
            }
            if(!mTer.existePoint(this.getContientP().get(1))) {
                mTer.getEnsemblePoint().add(this.getContientP().get(1));
            }
            this.getVue().redrawAll();
            this.changeEtat(120);
        } else if (this.etat == 130){
            this.contientP = new ArrayList<Point>();
            if (t.isShiftDown()) {
                Point pclic = new Point(t.getX(), t.getY());
                Point proche = model.prochePoint(pclic);
                this.getContientP().add(proche);
            } else {
                this.getContientP().add(new Point(t.getX(), t.getY()));
            }   
            this.changeEtat(131);
        } else if (this.etat == 131){
            if (t.isShiftDown()) {
                Point pclic = new Point(t.getX(), t.getY());
                Point proche = model.prochePoint(pclic);
                this.getContientP().add(proche);
            } else {
                this.getContientP().add(new Point(t.getX(), t.getY()));
            }
            this.changeEtat(132);
        } else if (this.etat == 132) {
            if (t.isShiftDown()) {
                Point pclic = new Point(t.getX(), t.getY());
                Point proche = model.prochePoint(pclic);
                this.getContientP().add(proche);
            } else {
                this.getContientP().add(new Point(t.getX(), t.getY()));
            }
            mTer.getEnsembleTT().add(new Triangle_Terrain(this.getContientP().get(0), 
                    this.getContientP().get(1), this.getContientP().get(2), 
                    new Segment_Terrain(this.getContientP().get(0),this.getContientP().get(1)), 
                    new Segment_Terrain(this.getContientP().get(1),this.getContientP().get(2)), 
                    new Segment_Terrain(this.getContientP().get(2),this.getContientP().get(0))));
            if(!mTer.existePoint(this.getContientP().get(0))) {
                mTer.getEnsemblePoint().add(this.getContientP().get(0));
            }
            if(!mTer.existePoint(this.getContientP().get(1))) {
                mTer.getEnsemblePoint().add(this.getContientP().get(1));
            }
            if(!mTer.existePoint(this.getContientP().get(2))) {
                mTer.getEnsemblePoint().add(this.getContientP().get(2));
            }
            if(!mTer.existeSeg(new Segment_Terrain(this.getContientP().get(0),this.getContientP().get(1)))) {
                mTer.getEnsembleST().add(new Segment_Terrain(this.getContientP().get(0),
                        this.getContientP().get(1)));
            }
            if(!mTer.existeSeg(new Segment_Terrain(this.getContientP().get(1),this.getContientP().get(2)))) {
                mTer.getEnsembleST().add(new Segment_Terrain(this.getContientP().get(1),
                        this.getContientP().get(2)));
            }
            if(!mTer.existeSeg(new Segment_Terrain(this.getContientP().get(2),this.getContientP().get(0)))) {
                mTer.getEnsembleST().add(new Segment_Terrain(this.getContientP().get(2),
                        this.getContientP().get(0)));
            }
            this.getVue().redrawAll();
            this.changeEtat(130);
        } else if (this.etat == 200) {
            
        } else if (this.etat == 210) {
            
        } else if (this.etat == 211) {
            double px = t.getX();
            double py = t.getY();
            model.getEnsembleNoeuds().add(new Noeud_Simple(px, py));
            this.getVue().redrawAll();
        } else if (this.etat == 212) {
            
        } else if (this.etat == 213) {
            Point pclic = new Point(t.getX(), t.getY());
            Segment_Terrain proche = this.vue.getModel().procheSegment(pclic);
            double posSeg = this.vue.getModel().posSurSeg(proche, pclic);
            if(posSeg<0) {
                posSeg =0;
            } else if(posSeg>1) {
                posSeg=1;
            }
            int[] numPoint = this.vue.getModel().getTerrainT().numPointConcou(proche);
            if(this.vue.getModel().getTerrainT().getEnsemblePoint().get(numPoint[0]).getPx()>
                    this.vue.getModel().getTerrainT().getEnsemblePoint().get(numPoint[1]).getPx()) {
                int mem = numPoint[0];
                numPoint[0] = numPoint[1];
                numPoint[1] = mem;
            }
            Triangle_Terrain TT = this.vue.getModel().getTerrainT().trouveTT(proche);
            Appui_Double Ad = new Appui_Double(TT,numPoint[0],numPoint[1],posSeg);
            this.getVue().getModel().getEnsembleNoeuds().add(Ad);
            this.getVue().redrawAll();
        } else if (this.etat == 214) {
            Point pclic = new Point(t.getX(), t.getY());
            Segment_Terrain proche = this.vue.getModel().procheSegment(pclic);
            double posSeg = this.vue.getModel().posSurSeg(proche, pclic);
            if(posSeg<0) {
                posSeg =0;
            } else if(posSeg>1) {
                posSeg=1;
            }
            int[] numPoint = this.vue.getModel().getTerrainT().numPointConcou(proche);
            if(this.vue.getModel().getTerrainT().getEnsemblePoint().get(numPoint[0]).getPx()>
                    this.vue.getModel().getTerrainT().getEnsemblePoint().get(numPoint[1]).getPx()) {
                int mem = numPoint[0];
                numPoint[0] = numPoint[1];
                numPoint[1] = mem;
            }
            Triangle_Terrain TT = this.vue.getModel().getTerrainT().trouveTT(proche);
            Appui_Encastre Ae = new Appui_Encastre(TT,numPoint[0],numPoint[1],posSeg);
            this.getVue().getModel().getEnsembleNoeuds().add(Ae);
            this.getVue().redrawAll();
        } else if (this.etat == 215) {
            Point pclic = new Point(t.getX(), t.getY());
            Segment_Terrain proche = this.vue.getModel().procheSegment(pclic);
            double posSeg = this.vue.getModel().posSurSeg(proche, pclic);
            if(posSeg<0) {
                posSeg =0;
            } else if(posSeg>1) {
                posSeg=1;
            }
            int[] numPoint = this.vue.getModel().getTerrainT().numPointConcou(proche);
            if(this.vue.getModel().getTerrainT().getEnsemblePoint().get(numPoint[0]).getPx()>
                    this.vue.getModel().getTerrainT().getEnsemblePoint().get(numPoint[1]).getPx()) {
                int mem = numPoint[0];
                numPoint[0] = numPoint[1];
                numPoint[1] = mem;
            }
            Triangle_Terrain TT = this.vue.getModel().getTerrainT().trouveTT(proche);
            Appui_Simple As = new Appui_Simple(TT,numPoint[0],numPoint[1],posSeg);
            this.getVue().getModel().getEnsembleNoeuds().add(As);
            this.getVue().redrawAll();
        } else if (this.etat == 220) {
            this.contientN = new ArrayList<Noeuds>();
            if (t.isShiftDown()) {
                Point pclic = new Point(t.getX(), t.getY());
                Noeuds proche = this.vue.getModel().procheNoeuds(pclic);
                this.getContientN().add(proche);
            } else {
                Noeuds nclic = new Noeud_Simple(t.getX(), t.getY());
                this.getContientN().add(nclic);
            }
            this.changeEtat(221);
        } else if (this.etat == 221) {
            if (t.isShiftDown()) {
                Point pclic = new Point(t.getX(), t.getY());
                Noeuds proche = this.vue.getModel().procheNoeuds(pclic);
                model.getEnsembleBarres().add(new Barre(this.getContientN().get(0), proche));
                this.getVue().redrawAll();
            } else {
                Noeuds nclic = new Noeud_Simple(t.getX(), t.getY());
                model.getEnsembleNoeuds().add(this.getContientN().get(0));
                model.getEnsembleNoeuds().add(nclic);
                model.getEnsembleBarres().add(new Barre(this.getContientN().get(0), nclic));
                this.getVue().redrawAll();
            }
            this.changeEtat(220);
        }
    }
    //change l'état lors du clic sur un bouton
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
    
    public void boutonCalcul(ActionEvent t) {
        System.out.println("Calculs effectués");
    }
    //lancement de la sauvegarde
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
//bouton sauveharde
    public void menuSave(ActionEvent t) {
        if (this.getVue().getCurFile() == null) {
            this.menuSaveAs(t);
        } else {
            this.realSave(this.getVue().getCurFile());
        }
    }
//bouton sauvegarde sous
    public void menuSaveAs(ActionEvent t) {
        FileChooser chooser = new FileChooser();
        File f = chooser.showSaveDialog(this.getVue().getInStage());
        if (f != null) {
            this.realSave(f);
        }
    }
//bouton ouvir un fichier
    public void menuOpen(ActionEvent t) {
        FileChooser chooser = new FileChooser();
        File f = chooser.showOpenDialog(this.getVue().getInStage());
        if (f != null) {
            try {
                Treillis lue = Treillis.lecture(f);
                Treillis glu = (Treillis) lue;
                Stage nouveau = new Stage();
                nouveau.setTitle(f.getName());
                Scene sc = new Scene(new MainPane(nouveau, f, glu), 1000, 650);
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
//bouton création d'un nouveau treillis
    public void menuNouveau(ActionEvent t) {
        Stage nouveau = new Stage();
        nouveau.setTitle("Nouveau Treillis");
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

    void menuAnnul(ActionEvent t) {
        if(this.getContientO() != null) {
            this.getContientO().clear();
        }
        if(this.getContientN() != null) {
            this.getContientN().clear();
        }
        if(this.getContientP() != null) {
            this.getContientP().clear();
        }
        this.changeEtat(10);
    }

    void menuSuprTout(ActionEvent t) {
        this.vue.setModel(new Treillis());
        this.getVue().redrawAll();
    }

    /**
     * @return the contientN
     */
    public List<Noeuds> getContientN() {
        return contientN;
    }

    /**
     * @return the contientP
     */
    public List<Point> getContientP() {
        return contientP;
    }

    /**
     * @return the contientO
     */
    public List<Object> getContientO() {
        return contientO;
    }
    
}
