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
import java.util.ArrayList;
import java.util.List;
import javafx.event.ActionEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

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
//    private List<Figure> selection;
    private List<Point> selectionpoint;
    
    public Controleur(MainPane vue) {
        this.vue = vue;
        //this.selection = new ArrayList<>();
    }
    
    public void changeEtat(int nouvelEtat) {
        if (nouvelEtat == 20) {
            //select
            //this.selection.clear();
            this.vue.redrawAll();
        } else if (nouvelEtat == 30) {
            // creation de points
            //this.selection.clear();
            //this.vue.getbGrouper().setDisable(true);
            this.vue.redrawAll();
        } else if (nouvelEtat == 40) {
            // creation de segments étape 1
            //this.selection.clear();
            //this.vue.getbGrouper().setDisable(true);
            this.vue.redrawAll();
        } else if (nouvelEtat == 41) {
            // creation de segments étape 2
        }
        this.etat = nouvelEtat;
    }

    void clicDansZoneDessin(MouseEvent t) {
        if (this.etat == 20) {
            Point pclic = new Point(t.getX(), t.getY());
            // pas de limite de distance entre le clic et l'objet selectionné
            //Figure proche = this.vue.getModel().plusProche(pclic, Double.MAX_VALUE);
            // il faut tout de même prévoir le cas ou le groupe est vide
            // donc pas de plus proche
            /*  if (proche != null) {
                if (t.isShiftDown()) {
                    this.selection.add(proche);
                } else if (t.isControlDown()) {
                    if (this.selection.contains(proche)) {
                        this.selection.remove(proche);
                    } else {
                        this.selection.add(proche);
                    }
                } else {
                    this.selection.clear();
                    this.selection.add(proche);
                }
                this.activeBoutonsSuivantSelection();
                this.vue.redrawAll();
            } */
        } else  if (this.etat == 30) {
            double px = t.getX();
            double py = t.getY();
            //Color col = this.vue.getcpCouleur().getValue();
            Treillis model = this.vue.getModel();
            model.getTerrainT().getEnsemblePoint().add(new Point(px, py));
            this.vue.redrawAll();
        } else if (this.etat == 40) {
            this.pclic1 = new Point(t.getX(), t.getY());
            this.vue.getRbPoints().setDisable(true);
            this.changeEtat(41);
        } else if (this.etat == 41) {
            this.pclic2 = new Point(t.getX(), t.getY());
            Treillis model = this.vue.getModel();
            model.getTerrainT().getEnsembleST().add(new Segment_Terrain(pclic1, pclic2));
            this.vue.redrawAll();
            this.changeEtat(40);
        } else if (this.etat == 50){
            this.pclic1 = new Point(t.getX(), t.getY());
            this.changeEtat(51);
        } else if (this.etat == 51){
            this.pclic2 = new Point(t.getX(), t.getY());
            this.changeEtat(52);
        } else if (this.etat == 52) {
            this.pclic3 = new Point(t.getX(), t.getY());
            Treillis model = this.vue.getModel();
            model.getTerrainT().getEnsembleTT().add(new Triangle_Terrain(pclic1, pclic2,pclic3));
            this.vue.redrawAll();
            this.changeEtat(50);
        }
    }
    
    public void boutonSelect(ActionEvent t) {
        this.changeEtat(20);
    }

    public void boutonPoints(ActionEvent t) {
        this.changeEtat(30);
    }

    public void boutonSegments(ActionEvent t) {
        this.changeEtat(40);
    }
    
    public void boutonTriangles(ActionEvent t) {
        this.changeEtat(50);
    }
    
    public void boutonNoeuds(ActionEvent t) {
        this.changeEtat(60);
    }

    public void boutonBarres(ActionEvent t) {
        this.changeEtat(70);
    }
    
/*  private void activeBoutonsSuivantSelection() {
        if (this.selection.size() < 2) {
            this.vue.getbGrouper().setDisable(true);
        } else {
            this.vue.getbGrouper().setDisable(false);
        }
    }*/

/*    public List<Figure> getSelection() {
        return selection;
    }*/
    
/*    public void changeColor(Color value) {
        if (this.etat == 20 && this.selection.size() > 0) {
            for (Figure f : this.selection) {
                f.changeCouleur(value);
            }
            this.vue.redrawAll();
        }
    }*/
    
/*    public void boutonGrouper(ActionEvent t) {
        if (this.etat == 20 && this.selection.size() > 1) {
            // normalement le bouton est disabled dans le cas contraire
            Groupe ssGroupe = this.vue.getModel().sousGroupe(selection);
            this.selection.clear();
            this.selection.add(ssGroupe);
            this.vue.redrawAll();
        }
    }*/
}
