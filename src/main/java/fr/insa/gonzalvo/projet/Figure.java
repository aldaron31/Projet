/*
Copyright 2000- Francois de Bertrand de Beuvron

This file is part of CoursBeuvron.

CoursBeuvron is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

CoursBeuvron is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with CoursBeuvron.  If not, see <http://www.gnu.org/licenses/>.
 */
package fr.insa.gonzalvo.projet;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 *
 * @author francois
 */
public abstract class Figure {

    public static Color COULEUR_SELECTION = Color.RED;

    /**
     * null si aucun groupe
     */
    private Treillis treillis;

    public Treillis getTreillis() {
        return this.treillis;
    }

    void setTreillis(Treillis treillis) {
        this.treillis = treillis;
    }

    public abstract double maxX();
    public abstract double minX();
    public abstract double maxY();
    public abstract double minY();

    public abstract double distancePoint(Point p);

    public abstract void dessine(GraphicsContext context);

    public abstract void dessineSelection(GraphicsContext context);

    public abstract void changeCouleur(Color value);

    public abstract void save(Writer w, Numeroteur<Figure> num) throws IOException;

    public void sauvegarde(File fout) throws IOException {
        Numeroteur<Figure> num = new Numeroteur<Figure>();
        try (BufferedWriter bout = new BufferedWriter(new FileWriter(fout))) {
            this.save(bout, num);
        }
    }

    public static Figure lecture(File fin) throws IOException {
        Numeroteur<Figure> num = new Numeroteur<Figure>();
        Figure derniere = null;
        try (BufferedReader bin = new BufferedReader(new FileReader(fin))) {
            String line;
            while ((line = bin.readLine()) != null && line.length() != 0) {
                String[] bouts = line.split(";");
                if (bouts[0].equals("Point")) {
                    int id = Integer.parseInt(bouts[1]);
                    double px = Double.parseDouble(bouts[2]);
                    double py = Double.parseDouble(bouts[3]);
                    Color col = FigureSimple.parseColor(bouts[4], bouts[5], bouts[6]);
                    Point np = new Point(px, py, col);
                    num.associe(id, np);
                    derniere = np;
                } else if (bouts[0].equals("Segment")) {
                    int id = Integer.parseInt(bouts[1]);
                    int idP1 = Integer.parseInt(bouts[2]);
                    int idP2 = Integer.parseInt(bouts[3]);
                    Color col = FigureSimple.parseColor(bouts[4], bouts[5], bouts[6]);
                    Point p1 = (Point) num.getObj(idP1);
                    Point p2 = (Point) num.getObj(idP2);
                    Segment_Terrain ns = new Segment_Terrain(p1, p2, col);
                    num.associe(id, ns);
                    derniere = ns;
                } else if (bouts[0].equals("Groupe")) {
                    int id = Integer.parseInt(bouts[1]);
                    Groupe ng = new Groupe();
                    num.associe(id, ng);
                    for (int i = 2; i < bouts.length; i++) {
                        int idSous = Integer.parseInt(bouts[i]);
                        Figure fig = num.getObj(idSous);
                        ng.add(fig);
                    }
                    derniere = ng;
                }
            }

        }
        return derniere;
    }

    Object getGroupe() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void setGroupe(Groupe aThis) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
