package fr.insa.lefevre.devisfinal.Model_Controleur;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
 
public class Revetements {
    static private Map<Integer, Revetements> revetements = new HashMap<>();
    private int idRevetement;
    private String designation;
    private boolean pourMur;
    private boolean pourSol;
    private boolean pourPlafond;
    private double prixUnitaire;
    
    public Revetements(int idRevetement, String designation, boolean pourMur, boolean pourSol, boolean pourPlafond, double prixUnitaire) {
        this.idRevetement = idRevetement;
        this.designation = designation;
        this.pourMur = pourMur;
        this.pourSol = pourSol;
        this.pourPlafond = pourPlafond;
        this.prixUnitaire = prixUnitaire;
    }
    
    public static void lireFichier(String nomFichier) {
        try (BufferedReader br = new BufferedReader(new FileReader("revetements.txt"))) {
            revetements = new HashMap<>();
            String ligne;
            // Ignorer la première ligne contenant les noms des colonnes
            br.readLine();
            while ((ligne = br.readLine()) != null) {
                String[] valeurs = ligne.split(";");
                int idRevetement = Integer.parseInt(valeurs[0]);
                String designation = valeurs[1];
                boolean pourMur = Integer.parseInt(valeurs[2]) == 1;
                boolean pourSol = Integer.parseInt(valeurs[3]) == 1;
                boolean pourPlafond = Integer.parseInt(valeurs[4]) == 1;
                double prixUnitaire = Double.parseDouble(valeurs[5]);

                Revetements revetement = new Revetements(idRevetement, designation, pourMur, pourSol, pourPlafond, prixUnitaire);
                revetements.put(idRevetement, revetement);
            }
        } catch (IOException e) {
            System.out.println("Erreur lors de la lecture du fichier : " + e.getMessage());
        }
    }
    
    public static boolean estApplicable(int id, boolean pourMur, boolean pourSol, boolean pourPlafond) {
        Revetements revetement = revetements.get(id);
        if (revetement != null) {
            return (pourMur && revetement.estPourMur())
                    || (pourSol && revetement.estPourSol())
                    || (pourPlafond && revetement.estPourPlafond());
        }
        return false;
    }

    public static List<Double> demanderRevêtements(double S1, double S2, double S3, double S4, double S5, double S6) {
        List<Double> listerevetements = new ArrayList<>();
        lireFichier("revetements.txt");
        double prixTotal = 0.0;
        System.out.println("ID du revetement pour le mur 1 ?");
        double idRevetement1=Lire.d();
        int id1 = (int) idRevetement1;
        while (!estApplicable(id1, true, false, false)) {
            System.out.println("Ce revetement n'est pas applicable pour un mur, choisissez en un autre");
            idRevetement1=Lire.d();
            id1 = (int) idRevetement1;
        }
        listerevetements.add(idRevetement1);
        System.out.println("ID du revetement pour le mur 2 ?");
        double idRevetement2=Lire.d();
        int id2 = (int) idRevetement2;
        while (!estApplicable(id2, true, false, false)) {
            System.out.println("Ce revetement n'est pas applicable pour un mur, choisissez en un autre");
            idRevetement2=Lire.d();
            id2 = (int) idRevetement2;
        }
        listerevetements.add(idRevetement2);
        System.out.println("ID du revetement pour le mur 3 ?");
        double idRevetement3=Lire.d();
        int id3 = (int) idRevetement3;
        while (!estApplicable(id3, true, false, false)) {
            System.out.println("Ce revetement n'est pas applicable pour un mur, choisissez en un autre");
            idRevetement3=Lire.d();
            id3 = (int) idRevetement3;
        }
        listerevetements.add(idRevetement3);
        System.out.println("ID du revetement pour le mur 4 ?");
        double idRevetement4=Lire.d();
        int id4 = (int) idRevetement4;
        while (!estApplicable(id4, true, false, false)) {
            System.out.println("Ce revetement n'est pas applicable pour un mur, choisissez en un autre");
            idRevetement4=Lire.d();
            id4 = (int) idRevetement4;
        }
        listerevetements.add(idRevetement4);
        System.out.println("ID du revetement pour le sol ?");
        double idRevetement5=Lire.d();
        int id5 = (int) idRevetement5;
        while (!estApplicable(id5, false, true, false)) {
            System.out.println("Ce revetement n'est pas applicable pour un sol, choisissez en un autre");
            idRevetement5=Lire.d();
            id5 = (int) idRevetement5;
        }
        listerevetements.add(idRevetement5);
        System.out.println("ID du revetement pour le plafond ?");
        double idRevetement6=Lire.d();
        int id6 = (int) idRevetement6;
        while (!estApplicable(id6, false, false, true)) {
            System.out.println("Ce revetement n'est pas applicable pour un plafond, choisissez en un autre");
            idRevetement6=Lire.d();
            id6 = (int) idRevetement6;
        }
        listerevetements.add(idRevetement6);
        System.out.print("Prix pour le revetement du mur 1 : ");
        prixTotal += calculerPrixRevêtement(prixTotal, id1, S1);
        System.out.print("Prix pour le revetement du mur 2 : ");
        prixTotal += calculerPrixRevêtement(prixTotal, id2, S2);
        System.out.print("Prix pour le revetement du mur 3 : ");
        prixTotal += calculerPrixRevêtement(prixTotal, id3, S3);
        System.out.print("Prix pour le revetement du mur 4 : ");
        prixTotal += calculerPrixRevêtement(prixTotal, id4, S4);
        System.out.print("Prix pour le revetement du sol : ");
        prixTotal += calculerPrixRevêtement(prixTotal, id5, S5);
        System.out.print("Prix pour le revetement du plafond : ");
        prixTotal += calculerPrixRevêtement(prixTotal, id6, S6);

        System.out.println("Prix total des revêtements de la piece : "+prixTotal);
        listerevetements.add(prixTotal);
        return listerevetements;
    }

    private static double calculerPrixRevêtement(double prixTotal, int idRevetement, double surface) {
        Revetements revetement = revetements.get(idRevetement);
        if (revetement != null && revetement.estPourMur()) {
            double prixUnitaire = revetement.getPrixUnitaire();
            double prix = prixUnitaire * surface;
            System.out.println("revêtement "+idRevetement+" : " + revetement.getDesignation() + " : " + prix);
            return prix;
        }
        if (revetement != null && revetement.estPourSol()) {
            double prixUnitaire = revetement.getPrixUnitaire();
            double prix = prixUnitaire * surface;
            System.out.println("revêtement "+idRevetement+" " + revetement.getDesignation() + " : " + prix);
            return prix;
        }
        if (revetement != null && revetement.estPourPlafond()) {
            double prixUnitaire = revetement.getPrixUnitaire();
            double prix = prixUnitaire * surface;
            System.out.println("revêtement "+idRevetement+" " + revetement.getDesignation() + " : " + prix);
            return prix;
        }
        return prixTotal;
    }
    
    public boolean estPourMur() {
        return pourMur;
    }

    public boolean estPourSol() {
        return pourSol;
    }

    public boolean estPourPlafond() {
        return pourPlafond;
    }

    public double getPrixUnitaire() {
        return prixUnitaire;
    }

    public String getDesignation() {
        return designation;
    }
}