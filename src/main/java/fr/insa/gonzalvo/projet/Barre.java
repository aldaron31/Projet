/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.insa.gonzalvo.projet;

import java.util.List;

/**
 *
 * @author gonza
 */
public class Barre extends Composants {
    private int id;
    private Noeuds NDebut;
    private Noeuds NFin;
    private Type_Barre type;
    private double traction;
    
    public Barre(Noeuds ND,Noeuds NF){
        this.NDebut = ND;
        this.NFin = NF;
    }

  
}
