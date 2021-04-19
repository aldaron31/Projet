/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.insa.gonzalvo.projet;

/**
 *
 * @author gonza
 */
public class Appui_Double extends Noeuds {
    //constructeur avec position fixée
    public Appui_Double (double px, double py) {
        this.px=px;
        this.py=py;
    }

    // on fixe la position en enlevant les set
    @Override
    public void setpx(double px) {
        
    }
    @Override
    public void setpy(double py) {
        
    }  
    
}
