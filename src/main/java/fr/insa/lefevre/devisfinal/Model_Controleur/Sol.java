/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.lefevre.devisfinal.Model_Controleur;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.lang.NumberFormatException;


public class Sol {
    File file = new File("Sauvegarde_des_données.txt");
    private Mur m1, m2;
    private int idSol;
    

    public Sol(int idSol, Mur m1, Mur m2) {
        this.idSol = idSol;
        this.m1 = m1;
        this.m2 = m2;
    }
    
    public int getIdSol() {
        return idSol;
    }

    public double calculerSurface() {
        // Récupérer les dimensions des deux murs
        double longueur1 = m1.getLongueur();
        double longueur2 = m2.getLongueur();
        // Calculer la surface du plafond
        double surface = longueur1*longueur2;
        return surface;
    }
    
    void afficher(double surface){
    System.out.println("Attribut du sol :\nid = "+this.idSol+" ; surface = "+surface);
    }
    
    public void SauvergardeSol(List<Integer> listeCoin){
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file,true))){
            bufferedWriter.write("sol;");
            bufferedWriter.write(listeCoin.get(0)+";"+listeCoin.get(1)+";"+listeCoin.get(2)+";"+listeCoin.get(3)+";");
            bufferedWriter.close();
        } catch(IOException e){
            e.printStackTrace();
        }
    }
}



