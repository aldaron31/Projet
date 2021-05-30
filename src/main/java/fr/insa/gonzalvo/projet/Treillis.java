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
    
      public Barre getbarreTableau(int i){
        return this.getEnsembleBarres().get(i);
    }
      /*récupère toutes les barres concourantes du noeud
      et les envoie dans la liste barrecoucon située dans la classe neoud
      */
      public void barreconcou(Noeuds N) {
          List<Barre> La=new ArrayList<Barre>();
          N.setbarreconcou(La);
          for (int i=0; i<this.EnsembleBarres.size(); i++) {
              if ((this.EnsembleBarres.get(i).getNDebut()==N) ||(this.EnsembleBarres.get(i).getNFin()==N)) {
                  N.getbarreconcou().add(this.EnsembleBarres.get(i));
              }
          }
      }
      //crée la matrice de calcul
      public Matrice CreaMat() {
          int j=this.EnsembleAppuiDouble.size()+this.EnsembleBarres.size()+1;
          int i=2*this.EnsembleNoeuds.size();
          Matrice Mat=new Matrice(i,j);
          return Mat;
      }
      //crée une liste avec les identificateurs des objets dont les forces sont inconnues
      public List<Integer> CreaListCol() {
          int i=this.EnsembleAppuiDouble.size()+this.EnsembleBarres.size()+1;
          List<Integer> ListCol=new ArrayList<Integer>();
          for (int k=0; k<this.EnsembleAppuiDouble.size(); k++) {
              ListCol.add(this.EnsembleAppuiDouble.get(k).getid());
          }
          for (int k=0; k<this.EnsembleBarres.size(); k++) {
              ListCol.add(this.EnsembleBarres.get(k).getid());
          }
          ListCol.add(0);
          return ListCol;
      }

      public static void testArray(){
          Barre Be;
        Noeud_Simple p1= new Noeud_Simple(1,2);
        Noeud_Simple p2= new Noeud_Simple(3,2);
        Barre B= new Barre(p1,p2);
        Treillis T= new Treillis();
       Be=T.getbarreTableau(1);
        
        
}

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
       Noeud_Simple ns1 = new Noeud_Simple(200,200);
       Noeud_Simple ns2 = new Noeud_Simple(300,300);
       Appui_Simple as1 = new Appui_Simple(TreillisTest.getTerrainT().getEnsembleTT().get(1), 1, 3, 0.5);
       Barre b1 = new Barre(ns1,ns2);
       Barre b2 = new Barre(as1,ns1);
       Barre b3 = new Barre(as1,ns2);
       
       TreillisTest.getEnsembleNoeuds().add(ns1);
       TreillisTest.getEnsembleNoeuds().add(ns2);
       TreillisTest.getEnsembleNoeuds().add(as1);
       TreillisTest.getEnsembleBarres().add(b1);
       TreillisTest.getEnsembleBarres().add(b2);
       TreillisTest.getEnsembleBarres().add(b3);
       return TreillisTest;
   }

   //représentation grapique du treillis en dessinant les barres et les noeuds
   public void dessine(GraphicsContext context, Treillis Tr) {
        Tr = this;
        for(Noeuds n : this.getEnsembleNoeuds()) {
            n.dessine(context, Tr);
        }
        for(Barre b : this.getEnsembleBarres()) {
            b.dessine(context, Tr);
        }
    }
    public Terrain getTerrainT() {
        return TerrainT;
    }
    
    public void setTerrainT(Terrain TerrainT) {
        this.TerrainT = TerrainT;
    }
    
    //concstruction de la couleur lors de la lecture
    public static Color parseColor(String sr, String sg, String sb) {
       double rouge = Double.parseDouble(sr);
       double vert = Double.parseDouble(sg);
       double bleu = Double.parseDouble(sb);
       return Color.color(rouge, vert, bleu);
    }
    //écrit dans le fichier de sauvegarde
    public void save(Writer w, Numeroteur<Treillis> num, Numeroteur<Barre> numB, Numeroteur<Noeuds> numN,
            Numeroteur<Terrain> numT, Numeroteur<Triangle_Terrain> numTT, Numeroteur<Segment_Terrain> numS, 
            Numeroteur<Point> numP) throws IOException {
        if (!num.objExist(this)) {
            int id = num.creeID(this);
            this.getTerrainT().save(w, numT, numTT, numS, numP);
            for (Barre b : this.EnsembleBarres) {
                b.save(w, numB, numN, numTT);
            }
            w.append("Treillis;" + id +";" + numT.getID(this.getTerrainT()));
            for (Barre b : this.EnsembleBarres) {
                w.append(";" + numB.getID(b));
            }
            w.append("\n");
        }
    }
    //création du fichier de sauvegarde
    public void sauvegarde(File fout) throws IOException {
        Numeroteur<Treillis> num = new Numeroteur<Treillis>();
        Numeroteur<Barre> numB = new Numeroteur<Barre>();
        Numeroteur<Noeuds> numN = new Numeroteur<Noeuds>();
        Numeroteur<Terrain> numT = new Numeroteur<Terrain>();
        Numeroteur<Triangle_Terrain> numTT = new Numeroteur<Triangle_Terrain>();
        Numeroteur<Segment_Terrain> numS = new Numeroteur<Segment_Terrain>();
        Numeroteur<Point> numP = new Numeroteur<Point>();
        try (BufferedWriter bout = new BufferedWriter(new FileWriter(fout))) {
                this.save(bout, num, numB, numN, numT, numTT, numS, numP);
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
    
    //lecture du fichier de sauvegarde
    public static Treillis lecture(File fin) throws IOException {
        Numeroteur<Treillis> num = new Numeroteur<Treillis>();
        Numeroteur<Terrain> numT = new Numeroteur<Terrain>();
        Numeroteur<Triangle_Terrain> numTT = new Numeroteur<Triangle_Terrain>();
        Numeroteur<Segment_Terrain> numS = new Numeroteur<Segment_Terrain>();
        Numeroteur<Point> numP = new Numeroteur<Point>();
        Numeroteur<Barre> numB = new Numeroteur<Barre>();
        Numeroteur<Noeuds> numN = new Numeroteur<Noeuds>();
        Treillis ntr = new Treillis();
        int cb = 0;
        int cn = 0;
        int ctt = 0;
        int cst = 0;
        int cp = 0;
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
                    cp++;
                } else if (bouts[0].equals("SegmentT")) {
                    int id = Integer.parseInt(bouts[1]);
                    int idP1 = Integer.parseInt(bouts[2]);
                    int idP2 = Integer.parseInt(bouts[3]);
                    Color col = Treillis.parseColor(bouts[4], bouts[5], bouts[6]);
                    Point p1 = (Point) numP.getObj(idP1);
                    Point p2 = (Point) numP.getObj(idP2);
                    Segment_Terrain ns = new Segment_Terrain(p1, p2, col);
                    numS.associe(id, ns);
                    cst++;
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
                    ctt++;
                } else if (bouts[0].equals("Terrain")) {
                    int id = Integer.parseInt(bouts[1]);
                    Terrain nt = new Terrain();
                    numT.associe(id, nt);
                    int i=2;
                    for (i = 2; i < ctt+2; i++) {
                        int idSous = Integer.parseInt(bouts[i]);
                        Triangle_Terrain TT = numTT.getObj(idSous);
                        nt.getEnsembleTT().add(TT);
                        if(!nt.existePoint(TT.getP1())) {
                            nt.getEnsemblePoint().add(TT.getP1());
                        }
                        if(!nt.existePoint(TT.getP2())) {
                            nt.getEnsemblePoint().add(TT.getP2());
                        }
                        if(!nt.existePoint(TT.getP3())) {
                            nt.getEnsemblePoint().add(TT.getP3());
                        }
                        if(!nt.existeSeg(TT.getS1())) {
                            nt.getEnsembleST().add(TT.getS1());
                        }
                        if(!nt.existeSeg(TT.getS2())) {
                            nt.getEnsembleST().add(TT.getS2());
                        }
                        if(!nt.existeSeg(TT.getS3())) {
                            nt.getEnsembleST().add(TT.getS3());
                        }
                    }
                    ntr.setTerrainT(nt);
                } else if (bouts[0].equals("Noeud_Simple")) {
                    int id = Integer.parseInt(bouts[1]);
                    double px = Double.parseDouble(bouts[2]);
                    double py = Double.parseDouble(bouts[3]);
                    Color col = Treillis.parseColor(bouts[4], bouts[5], bouts[6]);
                    Noeud_Simple ns = new Noeud_Simple(px, py, col);
                    numN.associe(id, ns);
                    cn++;
                } else if (bouts[0].equals("Appui_Simple")) {
                    int id = Integer.parseInt(bouts[1]);
                    int idTT = Integer.parseInt(bouts[2]);
                    int idP1 = Integer.parseInt(bouts[3]);
                    int idP2 = Integer.parseInt(bouts[4]);
                    double posSeg = Double.parseDouble(bouts[5]);
                    Color col = Treillis.parseColor(bouts[6], bouts[7], bouts[8]);
                    Triangle_Terrain TT = (Triangle_Terrain) numTT.getObj(idTT);
                    Appui_Simple as = new Appui_Simple(TT, idP1, idP2, posSeg, col);
                    numN.associe(id, as);
                    cn++;
                } else if (bouts[0].equals("Appui_Double")) {
                    int id = Integer.parseInt(bouts[1]);
                    int idTT = Integer.parseInt(bouts[2]);
                    int idP1 = Integer.parseInt(bouts[3]);
                    int idP2 = Integer.parseInt(bouts[4]);
                    double posSeg = Double.parseDouble(bouts[5]);
                    Color col = Treillis.parseColor(bouts[6], bouts[7], bouts[8]);
                    Triangle_Terrain TT = (Triangle_Terrain) numTT.getObj(idTT);
                    Appui_Double ad = new Appui_Double(TT, idP1, idP2, posSeg, col);
                    numN.associe(id, ad);
                    cn++;
                } else if (bouts[0].equals("Appui_Encastre")) {
                    int id = Integer.parseInt(bouts[1]);
                    int idTT = Integer.parseInt(bouts[2]);
                    int idP1 = Integer.parseInt(bouts[3]);
                    int idP2 = Integer.parseInt(bouts[4]);
                    double posSeg = Double.parseDouble(bouts[5]);
                    Color col = Treillis.parseColor(bouts[6], bouts[7], bouts[8]);
                    Triangle_Terrain TT = (Triangle_Terrain) numTT.getObj(idTT);
                    Appui_Encastre ae = new Appui_Encastre(TT, idP1, idP2, posSeg, col);
                    numN.associe(id, ae);
                    cn++;
                } else if (bouts[0].equals("Barre")) {
                    int id = Integer.parseInt(bouts[1]);
                    int idN1 = Integer.parseInt(bouts[2]);
                    int idN2 = Integer.parseInt(bouts[3]);
                    Color col = Treillis.parseColor(bouts[4], bouts[5], bouts[6]);
                    Noeuds NDebut = (Noeuds) numN.getObj(idN1);
                    Noeuds NFin = (Noeuds) numN.getObj(idN2);
                    Barre b = new Barre(NDebut, NFin, col);
                    numB.associe(id, b);
                    cb++;
                } else if (bouts[0].equals("Treillis")) {
                    int id = Integer.parseInt(bouts[1]);
                    num.associe(id, ntr);
                    int idTer = Integer.parseInt(bouts[2]);
                    Terrain Ter = (Terrain) numT.getObj(idTer);
                    ntr.setTerrainT(Ter);
                    int i=3;
                    for (i = 3; i < cb+3; i++) {
                        int idSous = Integer.parseInt(bouts[i]);
                        Barre b = numB.getObj(idSous);
                        ntr.getEnsembleBarres().add(b);
                        if(!ntr.existeNoeud(b.getNDebut())) {
                            ntr.getEnsembleNoeuds().add(b.getNDebut());
                        }
                        if(!ntr.existeNoeud(b.getNFin())) {
                            ntr.getEnsembleNoeuds().add(b.getNFin());
                        }
                    }
                }
            }
        }
        
        return ntr;
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
    
    //trouve le noeud le plus proche
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
    
    public double distancePointN(Point p, Noeuds n) {
        double dx = p.getPx() - n.getPx(this);
        double dy = p.getPy() - n.getPy(this);
        return Math.sqrt(dx*dx+dy*dy);
    }
    
    public Point prochePoint(Point p){
        double distance;
        Point res = getTerrainT().getEnsemblePoint().get(0);
        double distanceprec = distancePointP(p, res);
        for(Point pt : getTerrainT().getEnsemblePoint()){
            distance = distancePointP(p,pt);
            if(distance<distanceprec){
                distanceprec = distance;
                res = pt;
            }
            
        }
        return res;
    }
    
    public static double distancePointP(Point p1, Point p2) {
        double dx = p1.getPx() - p2.getPx();
        double dy = p1.getPy() - p2.getPy();
        return Math.sqrt(dx*dx+dy*dy);

    }
    
    public Segment_Terrain procheSegment(Point p){
        double distance;
        Segment_Terrain res = getTerrainT().getEnsembleST().get(0);
        double distanceprec = distancePointSegment(res.coeffDirecteur(), res.ordonneeAlOrigine(), p);
        for(Segment_Terrain st1 : getTerrainT().getEnsembleST()){
            distance = distancePointSegment(st1.coeffDirecteur(), st1.ordonneeAlOrigine(), p);
            if(distance<distanceprec){
                distanceprec = distance;
                res = st1;
            }
        }
        return res;
    }
    
    public static double distancePointSegment(double a, double b, Point p) {
        double distance = p.getPy()-a*p.getPx()-b;
        distance = Math.abs(distance);
        return distance;
    }
    
    public double posSurSeg(Segment_Terrain st, Point p){
        if(st.getDebut().getPx()<st.getFin().getPx()) {
            double gauche = st.getDebut().getPx();
            double droite = st.getFin().getPx();
            double posPs = p.getPx();
            droite = droite-gauche;
            posPs = posPs - gauche;
            gauche = gauche-gauche;
            posPs = posPs/droite;
            gauche = gauche/droite;
            droite = droite/droite;
            return posPs;
        } else {
           double droite = st.getDebut().getPx();
           double gauche = st.getFin().getPx();
           double posPs = p.getPx();
           droite = droite-gauche;
           posPs = posPs - gauche;
           gauche = gauche-gauche;
           posPs = posPs/droite;
           gauche = gauche/droite;
           droite = droite/droite; 
           return posPs;
        }
    }
    
    public boolean existeNoeud(Noeuds n) {
        int c =0;
        for(Noeuds ne : this.getEnsembleNoeuds()) {
            if(ne == n) {
                c++;
            }
        }
        if(c==0) {
            return false;
        } else {
            return true;
        }
    }
    
    public boolean existeBarre(Barre b) {
        int c =0;
        for(Barre be : this.getEnsembleBarres()) {
            if(be == b) {
                c++;
            }
        }
        if(c==0) {
            return false;
        } else {
            return true;
        }
    }
    
    
}
