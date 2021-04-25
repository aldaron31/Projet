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
public class Triangle_Terrain {
   private Point p1;
   private Point p2;
   private Point p3;
   
   //constructeur où on indique les 3 points
   public Triangle_Terrain(Point p1, Point p2, Point p3) {
       this.p1=p1;
       this.p2=p2;
       this.p3=p3;
   }
   //
   public boolean Test_Triangle_Point (Triangle_Terrain T, Point p) {
       //Variable qui contient le signe de l'angle
       int angle1;
       int angle2;
       int angle3;
       //on commence par angle1
       if (p1.getPx()<p2.getPx()) {
           //le vecteur est vers la droite
           if (p.getPy()<p1.getPy() && p.getPy()<p2.getPy()) {
              //p est en dessous du segment, donc l'angle est >pi et donc neg
              angle1=-1;
           }
           else {
               //sinon il est au dessus donc angle est pos
               angle1=1;
           }
           
       }
       else {
           //le vecteur est vers la gauche
           if (p.getPy()<p1.getPy() && p.getPy()<p2.getPy()) {
               //p est en dessous, donc en allant dans le sens trigo,
               //il est <pi donc angle pos
               angle1=1;
           }
           else {
               //sinon il est au dessus donc angle est neg
               angle1=-1;
           }
       }
       //on fait les autres angles
       if (p2.getPx()<p3.getPx()) {
           if (p.getPy()<p2.getPy() && p.getPy()<p3.getPy()) {
              angle2=-1;
           }
           else {
               angle2=1;
           }
       }
       else {
           if (p.getPy()<p2.getPy() && p.getPy()<p3.getPy()) {
               angle2=1;
           }
           else {
               angle2=-1;
           }
       }
       //angle3
       if (p3.getPx()<p1.getPx()) {
           if (p.getPy()<p3.getPy() && p.getPy()<p1.getPy()) {
              angle3=-1;
           }
           else {
               angle3=1;
           }
       }
       else {
           if (p.getPy()<p3.getPy() && p.getPy()<p1.getPy()) {
               angle3=1;
           }
           else {
               angle3=-1;
           }
       }
       //Si tous les angles sont de même signe, alors p est dans le triangle
       if (angle1<=0 && angle2<=0 && angle3<=0) {
           return true;
       }
       else if (angle1>=0 && angle2>=0 && angle3>=0) {
           return true;
       }
       else {
           return false;
       }
   }
}
