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
    //méthodes pour avoir les get et set seulement d'un des tableaux

    public List<Barre> getEnsembleBarres() {
        return EnsembleBarres;
    }

    public List<Noeuds> getEnsembleNoeuds() {
        return EnsembleNoeuds;
    }

    public void setEnsembleBarres(List<Barre> EnsembleBarres) {
        this.EnsembleBarres = EnsembleBarres;
    }

    public void setEnsembleNoeuds(List<Noeuds> EnsembleNoeuds) {
        this.EnsembleNoeuds = EnsembleNoeuds;
    }
    
    
    
    public void AddBarre(Barre B){
       if(B.getListBarres() != this.EnsembleBarres){
           if(B.getListBarres()!= null){
               throw new Error("Barre est dans un autre treillis");
           }
           else{
               this.EnsembleBarres.add(B);
               B.setListBarres(this.EnsembleBarres);
           }
       } 
    }
    
    public void AddNoeuds(Noeuds N){
        if(N.getListNoeuds() != this.EnsembleNoeuds){
            throw new Error ("Noeud est dans un autre treillis");
        }
        else{
             this.EnsembleNoeuds.add(N);
             N.setListNoeuds(this.EnsembleNoeuds);
        }
    }

   public String MontrerListeNoeuds(){
       String res = "Groupe {\n";
       for (int i = 0; i<this.EnsembleNoeuds.size();i++){
           res= res + (this.EnsembleNoeuds.get(i).toString(),"  ")+"\n";
       }
       return res;
   }
}
