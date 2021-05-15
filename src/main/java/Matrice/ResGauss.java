/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Matrice;

/**
 *
 * @author gonza
 */
public class ResGauss {
     public int rang;
     public int signaturePermutation;

    public ResGauss(int rang, int signaturePermutation) {
            this.rang = rang;
            this.signaturePermutation = signaturePermutation;
        }

        @Override
        public String toString() {
            return "{ResGauss : rang = " + this.rang + " ; sigPerm = "
                    + this.signaturePermutation + "}";
        }
}
