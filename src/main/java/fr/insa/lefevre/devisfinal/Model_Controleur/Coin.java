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
public class Coin {

    static Coin parseCoin(String element) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    File file = new File("Sauvegarde_des_données.txt");
    // Attributs
    int idCoin;
    double cx;
    double cy;
    
    // Constructeur
    Coin(int id, double x, double y)
    {
      this.idCoin=id;
      this.cx=x;
      this.cy=y;
    }
    
    void afficher()
    {
        System.out.println("Coin : id = "+this.idCoin+" ; abscisse = "+this.cx+ " ; ordonnée = "+this.cy);
    }
    public static ArrayList<Coin> listeCoin = new ArrayList<Coin>();
    
    //sauvegarder les données du coin 
    public void SauvegardeCoin(){ 
    try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file,true))){
            bufferedWriter.write("Coin;");
            bufferedWriter.write(this.idCoin+";");
            bufferedWriter.write(this.cx+";");
            bufferedWriter.write(this.cy+";");
            bufferedWriter.newLine();
            bufferedWriter.close();
            } catch(IOException e){
                e.printStackTrace();
            }}
            
}
