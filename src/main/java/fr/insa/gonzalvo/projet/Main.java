/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.insa.gonzalvo.projet;

/**
 *
 * @author Elève
 */
import Matrice.Matrice;
import Matrice.ResGauss;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import recup.Lire;

/**
 *
 * @author francois
 */
public class Main extends Application {

    @Override
    public void start(Stage stage){
        Scene sc = new Scene(new Label("coucou"));
        stage.setScene(sc);
        stage.show();
    }
            
    
    public static void main(String[] args) {
        launch(args);
        Matrice m=new Matrice(6, 6);
        int a=0;
        int i;
        int j;
        double coeff;
        while (a==0) {
            i=Lire.i();
            j=Lire.i();
            coeff=Lire.d();
            m.set(i,j,coeff);
        }
        
    }

}

