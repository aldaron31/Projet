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
public class Barre {
    private int id;
    private Noeuds Na;
    private Noeuds Nb;
    private Type_Barre type;
    
    public double longueur() {
    return Math.sqrt((Nb.getpx()-Na.getpx())*(Nb.getpx()-Na.getpx())+(Nb.getpy()-Na.getpy()*(Nb.getpy()-Na.getpy())));
}
    
}
