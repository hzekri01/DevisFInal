/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.lefevre.devisfinal.Model_Controleur;

import java.util.ArrayList;
import java.util.List;
 
public class Fenetre extends Ouverture {

    public Fenetre(int idOuverture) {
        super(idOuverture);
    }

    @Override
    public double surface() {
        dimX=1.2;
        dimY=1.2;
        return dimX * dimY;
    }

    @Override
    public List<Double> afficher() {
        System.out.println("\nCombien de fenetres le mur contient-il ?");
        double n = Lire.i();
        List<Double> listereturn = new ArrayList<>();
        listereturn.add(n);
        listereturn.add(n*this.surface());
        return listereturn;  
    }

    @Override
    public String toString() {
        return "Porte [idOuverture=" + idOuverture + ", dimX=" + dimX + ", dimY=" + dimY + "]";
    }

}
