/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.lefevre.devisfinal.Model_Controleur;
 
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Plafond {
    File file = new File("Sauvegarde_des_données.txt");
    private int idPlafond;
    private Liste<Mur> listeMur;
    private Liste<Revetements> listeRevetement;
    public int indexMur1, indexMur2;
    Mur m1, m2;

    Plafond(int idPlafond, Mur m1, Mur m2) {
        this.idPlafond = idPlafond;
        this.m1 = m1;
        this.m2 = m2;
    }

    public int getIdPlafond() {
        return idPlafond;
    }

    public Liste<Revetements> getListeRevetements() {
        return listeRevetement;
    }
 
    public void setIdPlafond(int idPlafond) {
        this.idPlafond = idPlafond;
    }

    public void setListeMur(Liste<Mur> listeMur) {
        this.listeMur = listeMur;
    }

    public void setListeRevetements(Liste<Revetements> listeRevetements) {
        this.listeRevetement = listeRevetements;
    }
    
    
    void afficher(double surface){
    System.out.println("Attribut du plafond :\nid = "+this.idPlafond+" ; surface = "+surface);
    }
    
    Tremie tremie = new Tremie (1);
    List<Double> nbtremis = tremie.afficher();
    double surfaceTremie = nbtremis.get(1);
        
    double surface(double surface){
        surface=surface-surfaceTremie;
        return(surface);
    }
        
    public double calculerSurfacePlafond() {
    // Récupérer les dimensions des deux murs
    double longueur1 = m1.getLongueur();
    double longueur2 = m2.getLongueur();
    // Calculer la surface du plafond
    double surfacePlafond = (longueur1 * longueur2);
    return surfacePlafond;
}
    
     public void SauvergardePlafond(){
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file,true))){
            bufferedWriter.write("Plafond;");
            bufferedWriter.write(this.idPlafond+";");
            bufferedWriter.write(m1.idMur+";");
            bufferedWriter.write(m2.idMur+";");
            bufferedWriter.write(Double.toString(nbtremis.get(0))+";");
            //bufferedWriter.write(longeur+";");
            //bufferedWriter.write(surface+";");
            bufferedWriter.newLine();
        } catch(IOException e){
            e.printStackTrace();
        }
    }
     
    public void SauvergardePlafond(List<Integer> listeCoin){
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file,true))){
            bufferedWriter.write("plafond;");
            bufferedWriter.write(listeCoin.get(0)+";"+listeCoin.get(1)+";"+listeCoin.get(2)+";"+listeCoin.get(3)+";");
            bufferedWriter.close();
        } catch(IOException e){
            e.printStackTrace();
        }
    }
}

