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
 * @author Elève
 */
public class Conteneur<TO> {
    
    private List<TO> contient;
    
    public Conteneur() {
        this.contient = new ArrayList<TO>();
    }
    
    public void add(TO obj) {
        this.getContient().add(obj);
    }

    public void remove(TO obj) {
        this.getContient().remove(obj);
    }

    public void removeAll() {
        for (TO obj : this.getContient()) {
            this.remove(obj);
        }
    }

    public List<TO> getContient() {
        return contient;
    }

    public void setContient(List<TO> contient) {
        this.contient = contient;
    }
    
    public int size() {
        return this.contient.size();
    }
    
    public TO get(int i) {
        return this.contient.get(i);
    }
    
    public boolean contains(TO Obj1) {
        int c = 0;
        for(TO Obj : getContient()) {
            if(Obj == Obj1){
                c = 1;
            }
        }
        if(c!=0) {
            return true;
        } else {
            return false;
        }
    }
}