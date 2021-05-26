/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.insa.gonzalvo.projet;

import Matrice.Matrice;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author gonza
 */
public class Treillis {

  
    private List<Barre> EnsembleBarres;
    private List<Noeuds> EnsembleNoeuds;
    private List<Appui_Double> EnsembleAppuiDouble;
    private Terrain TerrainT;
    
    
    private Conteneur<Noeuds> ContientN;
    private Conteneur<Barre> ContientB;
    private Conteneur<Triangle_Terrain> ContientTT;
   //Après on a aussi catalogue barres et le terrain mais sont des eléments simples
    
    public Treillis(List<Barre> EnsembleBarres,List<Noeuds> EnsembleNoeuds, Terrain Terrain){
        this.TerrainT = Terrain;
        this.EnsembleBarres= EnsembleBarres;
        this.EnsembleNoeuds= EnsembleNoeuds;
        this.ContientN = new Conteneur<Noeuds>();
        this.ContientB = new Conteneur<Barre>();
        this.ContientTT = new Conteneur<Triangle_Terrain>();
    }
    
    public Treillis(Terrain Terrain){
        this.TerrainT = Terrain;
        this.EnsembleBarres=new ArrayList<Barre>();
        this.EnsembleNoeuds=new ArrayList<Noeuds>();
        this.ContientN = new Conteneur<Noeuds>();
        this.ContientB = new Conteneur<Barre>();
        this.ContientTT = new Conteneur<Triangle_Terrain>();
    }
    
    public Treillis(){
        this.TerrainT = new Terrain();
        this.EnsembleBarres=new ArrayList<Barre>();
        this.EnsembleNoeuds=new ArrayList<Noeuds>();
        this.ContientN = new Conteneur<Noeuds>();
        this.ContientB = new Conteneur<Barre>();
        this.ContientTT = new Conteneur<Triangle_Terrain>();
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
    
      public Barre getbarreTableau(int i){
        return this.getEnsembleBarres().get(i);
    }
      public void barreconcou(Noeuds N) {
          List<Barre> La=new ArrayList<Barre>();
          N.setbarreconcou(La);
          for (int i=0; i<this.EnsembleBarres.size(); i++) {
              if ((this.EnsembleBarres.get(i).getNDebut()==N) ||(this.EnsembleBarres.get(i).getNFin()==N)) {
                  N.getbarreconcou().add(this.EnsembleBarres.get(i));
              }
          }
      }
      
      public Matrice CreaMat() {
          int i=this.EnsembleAppuiDouble.size()+this.EnsembleBarres.size()+1;
          int j=2*this.EnsembleNoeuds.size();
          Matrice Mat=new Matrice(i,j);
          return Mat;
      }

      public static void testArray(){
          Barre Be;
        Noeud_Simple p1= new Noeud_Simple(1,2);
        Noeud_Simple p2= new Noeud_Simple(3,2);
        Barre B= new Barre(p1,p2);
        Treillis T= new Treillis();
       Be=T.getbarreTableau(1);
        
        
}

    
    //hasta aquí todo bien
    /*
    public void AddBarre(Barre B){
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
    /*
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
   
   public static void NoeudPoint(){
    Noeud_Simple n1= new Noeud_Simple(1,2);
    Noeud_Simple n2= new Noeud_Simple(3,2);
    Noeud_Simple n3= new Noeud_Simple(4,2);   
    Noeud_Simple n4= new Noeud_Simple(5,3);
    Barre b1= new Barre(n1,n2);
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
    public Terrain getTerrainT() {
        return TerrainT;
    }
    
    public void setTerrainT(Terrain TerrainT) {
        this.TerrainT = TerrainT;
    }
    
    public static Color parseColor(String sr, String sg, String sb) {
       double rouge = Double.parseDouble(sr);
       double vert = Double.parseDouble(sg);
       double bleu = Double.parseDouble(sb);
       return Color.color(rouge, vert, bleu);
    }
    
    public void save(Writer w, Numeroteur<Treillis> num, Numeroteur<Terrain> numT, Numeroteur<Triangle_Terrain> numTT, Numeroteur<Segment_Terrain> numS, Numeroteur<Point> numP) throws IOException {
        if (!num.objExist(this)) {
            int id = num.creeID(this);
            this.getTerrainT().save(w, numT, numTT, numS, numP);
            w.append("Treillis;" + id +";" + numT.getID(this.getTerrainT())+ "\n");
        }
    }
    
    public void sauvegarde(File fout) throws IOException {
        Numeroteur<Treillis> num = new Numeroteur<Treillis>();
        Numeroteur<Terrain> numT = new Numeroteur<Terrain>();
        Numeroteur<Triangle_Terrain> numTT = new Numeroteur<Triangle_Terrain>();
        Numeroteur<Segment_Terrain> numS = new Numeroteur<Segment_Terrain>();
        Numeroteur<Point> numP = new Numeroteur<Point>();
        try (BufferedWriter bout = new BufferedWriter(new FileWriter(fout))) {
                this.save(bout, num, numT, numTT, numS, numP);
        }
    }
    
    public static void testSauvegarde() {
        
        Treillis TreillisTest = new Treillis(Terrain.TerrainTest());
        try {
            TreillisTest.sauvegarde(new File("TreillisTest.txt"));
        } catch (IOException ex) {
            throw new Error("Problème :" + ex.getMessage()); 
        }
    }
    
    public static Treillis lecture(File fin) throws IOException {
        Numeroteur<Treillis> num = new Numeroteur<Treillis>();
        Numeroteur<Terrain> numT = new Numeroteur<Terrain>();
        Numeroteur<Triangle_Terrain> numTT = new Numeroteur<Triangle_Terrain>();
        Numeroteur<Segment_Terrain> numS = new Numeroteur<Segment_Terrain>();
        Numeroteur<Point> numP = new Numeroteur<Point>();
        Treillis derniere = new Treillis();
        try (BufferedReader bin = new BufferedReader(new FileReader(fin))) {
            String line;
            while ((line = bin.readLine()) != null && line.length() != 0) {
                String[] bouts = line.split(";");
                if (bouts[0].equals("Point")) {
                    int id = Integer.parseInt(bouts[1]);
                    double px = Double.parseDouble(bouts[2]);
                    double py = Double.parseDouble(bouts[3]);
                    Color col = Treillis.parseColor(bouts[4], bouts[5], bouts[6]);
                    Point np = new Point(px, py, col);
                    numP.associe(id, np);
                } else if (bouts[0].equals("SegmentT")) {
                    int id = Integer.parseInt(bouts[1]);
                    int idP1 = Integer.parseInt(bouts[2]);
                    int idP2 = Integer.parseInt(bouts[3]);
                    Color col = Treillis.parseColor(bouts[4], bouts[5], bouts[6]);
                    Point p1 = (Point) numP.getObj(idP1);
                    Point p2 = (Point) numP.getObj(idP2);
                    Segment_Terrain ns = new Segment_Terrain(p1, p2, col);
                    numS.associe(id, ns);
                } else if (bouts[0].equals("TriangleT")) {
                    int id = Integer.parseInt(bouts[1]);
                    int idP1 = Integer.parseInt(bouts[2]);
                    int idP2 = Integer.parseInt(bouts[3]);
                    int idP3 = Integer.parseInt(bouts[4]);
                    int idS1 = Integer.parseInt(bouts[5]);
                    int idS2 = Integer.parseInt(bouts[6]);
                    int idS3 = Integer.parseInt(bouts[7]);
                    Color col = Treillis.parseColor(bouts[8], bouts[9], bouts[10]);
                    Point p1 = (Point) numP.getObj(idP1);
                    Point p2 = (Point) numP.getObj(idP2);
                    Point p3 = (Point) numP.getObj(idP3);
                    Segment_Terrain s1 = (Segment_Terrain) numS.getObj(idS1);
                    Segment_Terrain s2 = (Segment_Terrain) numS.getObj(idS2);
                    Segment_Terrain s3 = (Segment_Terrain) numS.getObj(idS3);
                    Triangle_Terrain ntt = new Triangle_Terrain(p1, p2, p3, s1, s2, s3, col);
                    numTT.associe(id, ntt);
                } else if (bouts[0].equals("Terrain")) {
                    int id = Integer.parseInt(bouts[1]);
                    Terrain nt = new Terrain();
                    numT.associe(id, nt);
                    for (int i = 2; i < bouts.length; i++) {
                        int idSous = Integer.parseInt(bouts[i]);
                        Triangle_Terrain TT = numTT.getObj(idSous);
                        nt.getEnsembleTT().add(TT);
                    }
                    derniere.setTerrainT(nt);
                } else if (bouts[0].equals("Treillis")) {
                    int id = Integer.parseInt(bouts[1]);
                    Treillis ntr = new Treillis();
                    num.associe(id, ntr);
                    int idTer = Integer.parseInt(bouts[2]);
                    Terrain Ter = (Terrain) numT.getObj(idTer);
                    ntr.setTerrainT(Ter);
                }
            }
        }
        
        return derniere;
    }
    
    public static void testLecture() {
        try {
            Treillis lue = Treillis.lecture(new File("TreillisTest.txt"));
            System.out.println("Treillis lue : " + lue);
        } catch (IOException ex) {
            throw new Error(ex);
        }
    }
    
    public static void main(String[] args) {
        //testSauvegarde();
        //testLecture();
        Noeud_Simple Na=new Noeud_Simple(1, 2);
        Noeud_Simple Nb=new Noeud_Simple(4, 2);
        Barre B=new Barre(Na, Nb);
        Treillis T=new Treillis();
        T.EnsembleBarres.add(B);
        T.barreconcou(Nb);
        for (int i=0; i<Nb.getbarreconcou().size(); i++) {
            System.out.println("Oui");
        }
    }

    /**
     * @return the ContientN
     */
    public Conteneur<Noeuds> getContientN() {
        return ContientN;
    }

    /**
     * @param ContientN the ContientN to set
     */
    public void setContientN(Conteneur<Noeuds> ContientN) {
        this.ContientN = ContientN;
    }

    /**
     * @return the ContientB
     */
    public Conteneur<Barre> getContientB() {
        return ContientB;
    }

    /**
     * @param ContientB the ContientB to set
     */
    public void setContientB(Conteneur<Barre> ContientB) {
        this.ContientB = ContientB;
    }

    /**
     * @return the ContientTT
     */
    public Conteneur<Triangle_Terrain> getContientTT() {
        return ContientTT;
    }

    /**
     * @param ContientTT the ContientTT to set
     */
    public void setContientTT(Conteneur<Triangle_Terrain> ContientTT) {
        this.ContientTT = ContientTT;
    }
    
    public Noeuds procheNoeuds(Point p){
        double distance;
        Noeuds res = getEnsembleNoeuds().get(0);
        
        double distanceprec = distancePointN(p, res);
        for(Noeuds n : getEnsembleNoeuds()){
            distance = distancePointN(p,n);
            if(distance<distanceprec){
                distanceprec = distance;
                res = n;
            }
            
        }
        return res;
    }
    
    public static double distancePointN(Point p, Noeuds n) {
        double dx = p.getPx() - n.getPx();
        double dy = p.getPy() - n.getPy();
        return Math.sqrt(dx*dx+dy*dy);

    }
    
    public double distancePoint(Point p, Noeuds N) {
        if (this.getContientN().size() == 0) {
            return new Point(0, 0).distancePoint(p);
        } else {
            double dist = this.distancePointN(p, this.getContientN().get(0));
            for (int i = 1; i < this.getContientN().size(); i++) {
                double cur = this.distancePointN(p, this.getContientN().get(i));
                if (cur < dist) {
                    dist = cur;
                }
            }
            return dist;
        }
    }
}
