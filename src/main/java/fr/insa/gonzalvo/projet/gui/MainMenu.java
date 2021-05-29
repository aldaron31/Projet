
package fr.insa.gonzalvo.projet.gui;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;

public class MainMenu extends MenuBar{
    
    private MainPane main;
    //crée le menu avec les différents boutons
    /*
    public MainMenu(MainPane main) {
        this.main = main;
        Menu file = new Menu("Fichier");
        MenuItem nouveau = new MenuItem("Nouveau");
        nouveau.setOnAction((t) -> {
            this.main.getControleur().menuNouveau(t);
        });
        MenuItem save = new MenuItem("Sauvegarder");
        save.setOnAction((t) -> {
            this.main.getControleur().menuSave(t);
        });
        MenuItem saveAs = new MenuItem("Sauvegarder sous...");
        saveAs.setOnAction((t) -> {
            this.main.getControleur().menuSaveAs(t);
        });
        MenuItem load = new MenuItem("Ouvrir");
        load.setOnAction((t) -> {
            this.main.getControleur().menuOpen(t);
        });        
        file.getItems().addAll(nouveau,save,saveAs,load);
        Menu edit = new Menu("Edition");
        MenuItem terrain = new MenuItem("Terrain");
        terrain.setOnAction((t) -> {
            this.main.getControleur().menuTerrain(t);
        });
        MenuItem treillis = new MenuItem("Treillis");
        treillis.setOnAction((t) -> {
            this.main.getControleur().menuTreillis(t);
        });
        edit.getItems().addAll(terrain,treillis);
        Menu help = new Menu("Aide");
        MenuItem apropos = new MenuItem("A propos");
        apropos.setOnAction((t) -> {
            this.main.getControleur().menuApropos(t);
        });        
        help.getItems().addAll(apropos);
        
        this.getMenus().addAll(file,help,edit);
    }
    */
}
