/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.insa.gonzalvo.projet.gui;

import fr.insa.gonzalvo.projet.Treillis;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Label;

/**
 *
 * @author Elève
 */
public class Main extends Application {

    @Override
    public void start(Stage stage) {
        Scene sc = new Scene(new MainPane(stage, Treillis.TreillisTest()),1000,650);
        stage.setScene(sc);
        stage.setTitle("Treillis");
          stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}
