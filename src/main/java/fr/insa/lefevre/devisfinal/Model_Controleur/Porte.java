/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.lefevre.devisfinal.Model_Controleur;
 
import java.util.ArrayList;
import java.util.List;

public class Porte extends Ouverture {

    public Porte(int idOuverture) {
        super(idOuverture);
    }

    @Override
    public double surface() {
        dimX=0.9;
        dimY=2.1;
        return dimX * dimY;
    }

    @Override
    public List<Double> afficher() {
        System.out.println("\nCombien de portes le mur contient-il ?");
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
