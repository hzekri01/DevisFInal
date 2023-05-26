package fr.insa.lefevre.devisfinal.Model_Controleur;

import fr.insa.lefevre.devisfinal.GUI.Main;
import fr.insa.lefevre.devisfinal.GUI.MainPane;
import java.lang.String;
import java.io.IOException;
import java.util.List;
import java.io.File;
import java.io.FileWriter;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class DevisBatiment {

    


    private static List<Revetements> revetements;
    private static Iterable<Mur> listeMur;
    

    public static void main(String[] args){
        Main.lancerinterface();
        File file = new File("Sauvegarde_des_données.txt");
        //vide le fichier de sauvegarde
        try {
        FileWriter fw = new FileWriter(file, false); // false pour écraser le fichier existant
        fw.write(""); // écrit une chaîne vide pour vider le fichier
        fw.close(); // ferme le fichier
        } catch (IOException e) {
        e.printStackTrace();
        }
        int idBatiment, nbEtage, idEtage, i;
        double prixTotal=0, prixEtage;
        System.out.println("Donner l'ID du batiment que vous souhaiter créer");
        idBatiment=Lire.i();
        System.out.println("Combien d'étages pour le batiment "+idBatiment+" ?");
        nbEtage=Lire.i();
        for (i=1; i<=nbEtage; i++) {
            System.out.println("Donner l'ID de l'étage que vous souhaiter créer");
            idEtage=Lire.i();
            Etage Etage = new Etage();
            prixEtage=Etage.créerEtage(idEtage);
            System.out.println("Prix de l'étage "+idEtage+" : "+prixEtage);
            prixTotal=prixTotal+prixEtage;
        }
        System.out.println("Prix total du batiment "+idBatiment+" : "+prixTotal);
    }     
}