/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.insa.gonzalvo.projet;

import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author gonza
 */
public class Treillis {
    
    private List<Barre> EnsembleBarres;
    private List<Noeuds> EnsembleNoeuds;
   //Après on a aussi catalogue barres et le terrain mais sont des eléments simples
    
    public Treillis(List<Barre> EnsembleBarres,List<Noeuds> EnsembleNoeuds){
        this.EnsembleBarres= EnsembleBarres;
        this.EnsembleNoeuds= EnsembleNoeuds;
    }
    
    public Treillis(){
        this.EnsembleBarres=new ArrayList<Barre>();
        this.EnsembleNoeuds=new ArrayList<Noeuds>();
    }
    
    public void AddBarre(Barre B){
        
    }
}
