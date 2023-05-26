/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.lefevre.devisfinal.Model_Controleur;
 
import java.util.ArrayList;
import java.util.List;

public class Tremie extends Ouverture {

    public Tremie(int idOuverture) {
        super(idOuverture);
    }

    @Override
    public double surface() {
        dimX=1;
        dimY=1;
        return dimX * dimY;
    }

    @Override
    public List<Double> afficher() {
        System.out.println("\nCombien de tremis le plafond contient-il ?");
        double n = Lire.i();
        List<Double> listereturn = new ArrayList<>();
        listereturn.add(n);
        listereturn.add(n*this.surface());
        return listereturn;  
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}