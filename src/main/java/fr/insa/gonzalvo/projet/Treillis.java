/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.insa.gonzalvo.projet;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import fr.insa.gonzalvo.projet.Terrain;
/**
 *
 * @author gonza
 */
public class Treillis {
    
    private List<Barre> EnsembleBarres;
    private List<Noeuds> EnsembleNoeuds;
    private Terrain TerrainT;
    private List<Noeuds> contientNoeuds;
    private List<Barre> contientBarre;
   //Après on a aussi catalogue barres et le terrain mais sont des eléments simples
    
    public Treillis(List<Barre> EnsembleBarres,List<Noeuds> EnsembleNoeuds, Terrain Terrain){
        this.TerrainT = Terrain;
        this.EnsembleBarres= EnsembleBarres;
        this.EnsembleNoeuds= EnsembleNoeuds;
    }
    
    public Treillis(Terrain Terrain){
        this.TerrainT = Terrain;
        this.EnsembleBarres=new ArrayList<Barre>();
        this.EnsembleNoeuds=new ArrayList<Noeuds>();
    }
    
    public Treillis(){
        this.TerrainT = new Terrain();
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
    
    
    //hasta aquí todo bien
    
/*    public void AddBarre(Barre B){
       if(B.getTreillis() != this){
           if(B.getTreillis()!= null){
               throw new Error("Barre est dans un autre treillis");
           }
           else{
               this.EnsembleBarres.add(B);
               B.setTreillis(this);
           }
       } 
    }
    
    public void AddNoeuds(Noeuds N){
        if(N.getTreillis() != this){
            if(N.getTreillis()!=null){
            throw new Error ("Noeud est dans un autre treillis");
            }
            else{
             this.EnsembleNoeuds.add(N);
             N.setTreillis(this);
        }
            }
    }
*/
   public String MontrerListNoeuds(){
       String res = "Groupe {\n";
       for (int i = 0; i<this.getEnsembleNoeuds().size();i++){
           res= res + (this.getEnsembleNoeuds().get(i).toString()+"  ")+"\n";
       }
       return res+"}";
   }
   
   public String MontrerListBarres(){
       String res = "Goupe {\n";
       for(int i = 0; i<this.getEnsembleBarres().size();i++){
           res = res + (this.getEnsembleBarres().get(i).toString()+"  ")+"\n"; 
       }
       return res+"}";
   }
   
   public static void TestPoint(){
    Noeud_Simple p1= new Noeud_Simple(1,2);
    Noeud_Simple p2= new Noeud_Simple(3,2);
    Noeud_Simple p3= new Noeud_Simple(4,2);   
   }
   public static void main(String[] args){
      
   }
   
   public static Treillis TreillisTest() {
       
       Treillis TreillisTest = new Treillis(Terrain.TerrainTest());
       
       return TreillisTest;
   }

    public void dessine(GraphicsContext context) {
        for(Noeuds n : this.getEnsembleNoeuds()) {
            n.dessine(context);
        }
        for(Barre b : this.getEnsembleBarres()) {
            b.dessine(context);
        }
        
    }

    /**
     * @return the TerrainT
     */
    public Terrain getTerrainT() {
        return TerrainT;
    }

    /**
     * @param TerrainT the TerrainT to set
     */
    public void setTerrainT(Terrain TerrainT) {
        this.TerrainT = TerrainT;
    }
}
