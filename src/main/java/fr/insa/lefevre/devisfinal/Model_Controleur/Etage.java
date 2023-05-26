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

public class Etage {
    public Etage (){
    }
    public static Double créerEtage(int id){
        File file = new File("Sauvegarde_des_données.txt");
        List<Double> listePiece = new ArrayList<>();
        int nbPiece, i;
        double idPiece;
        double prixPiece, prixEtage=0;
        System.out.println("Combien de pièces pour l'étage "+id+" ?");
        nbPiece=Lire.i();
        for (i=1;i<=nbPiece;i++){
            System.out.println("Donner l'ID de la pièce à creer");
            idPiece=Lire.d();
            Piece piece1 = new Piece();
            prixPiece=piece1.créerPièce(idPiece);
            prixEtage=prixEtage+prixPiece;
            listePiece.add(idPiece);
        }
        listePiece.add(prixEtage);
        return prixEtage;
    }
}
