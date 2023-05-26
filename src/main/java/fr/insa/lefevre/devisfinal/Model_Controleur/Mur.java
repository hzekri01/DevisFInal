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

public class Mur {

    File file = new File("Sauvegarde_des_données.txt");
    private static String mur;
    //atributs
    int idMur;
    Coin debut, fin;
    double surface,longueur,hsp;
    
    //constructeur
    Mur(int id, Coin dc, Coin fc, double hauteur)
    {
        this.idMur=id;
        this.debut=dc;
        this.fin=fc;
        this.hsp=hauteur;
    }
    
    void afficher()
    {System.out.println("Attribut du mur "+this.idMur+" :");
        this.debut.afficher();
        this.fin.afficher();
    }
    
    public double getLongueur() {
        return longueur;
    }

    public double getHsp() {
        return hsp;
    }

    ArrayList<Mur> listeMur= new ArrayList<Mur>();
    
    public ArrayList<Mur> getListeMur() {
        return listeMur;
    }
    
    double longueur()
    {
        longueur = Math.sqrt((this.fin.cx-this.debut.cx)*(this.fin.cx-this.debut.cx) + (this.fin.cy-this.debut.cy)*(this.fin.cy-this.debut.cy));
        return(longueur);
    }
    
     Fenetre fenetre = new Fenetre (1);
     Porte porte = new Porte (1);
        List<Double> nbfenetre = fenetre.afficher();
        double surfaceFenetre = nbfenetre.get(1);
        List<Double> nbporte = porte.afficher();
        double surfacePorte = nbporte.get(1);
    
    double surface()
    {
        surface = (this.longueur()*this.hsp)-surfaceFenetre-surfacePorte;
        return(surface);
    }
    
    
    public void SauvergardeMur(){
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file,true))){
            bufferedWriter.write("mur;");
            bufferedWriter.write(this.idMur+";");
            bufferedWriter.write(debut.idCoin+";");
            bufferedWriter.write(fin.idCoin+";");
            bufferedWriter.write(Double.toString(nbporte.get(0))+";");
            bufferedWriter.write(Double.toString(nbfenetre.get(0))+";");
            bufferedWriter.close();
        } catch(IOException e){
            e.printStackTrace();
        }
    } 
}
