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

public class Piece {
    
    static int idSol;
    static int idPlafond;
    static List<Mur> listeMur = new ArrayList<>();
    static List<Integer> listeCoin = new ArrayList<>();
    
    
    public Piece() {
    }
    
    
    public double créerPièce(double id){
        int identier = (int) id;
        File file = new File("Sauvegarde_des_données.txt");
        

        // CREATION PIECE
        System.out.println("entrez la hauteur de l'étage de la pièce "+id);
        double hauteurPiece = Lire.d();

        
        
        // Création d'un coin c1
        Coin c1;
        System.out.println("Identifiant du Coin 1");
        int idCoin=Lire.i();
        System.out.println("Abscisse du Coin");
        double x=Lire.d();
        System.out.println("Ordonnée du Coin");
        double y=Lire.d();
        c1=new Coin(idCoin,x,y);
        // Pour afficher textuellement le coin c1
        c1.afficher();
        listeCoin.add(c1.idCoin);

        // Création d'un coin c2
        Coin c2;
        System.out.println("Identifiant du Coin 2");
        idCoin=Lire.i();
        System.out.println("Abscisse du Coin");
        x=Lire.d();
        System.out.println("Ordonnée du Coin");
        y=Lire.d();
        c2=new Coin(idCoin,x,y);
        // Pour afficher textuellement le coin c2
        c2.afficher();
        listeCoin.add(c2.idCoin);

        // Création d'un mur m1
        Mur m1;
        System.out.println("Identifiant du Mur 1");
        int idMur=Lire.i();
        m1=new Mur(idMur,c1,c2, hauteurPiece);
        m1.afficher();
        //Formattage de l'affichage, pour afficher seuleument à 2 chiffres après la virgule
        System.out.format("\nLongueur du mur = %.2f",m1.longueur());
        // Calcul et affichage de la surface d'un mur
        System.out.format("\nSurface apres enlevement des ouvertures = %.2f",m1.surface());
        listeMur.add(m1);

        // Création d'un coin c3 pour créer le deuxième mur de la pièce 
        Coin c3;
        System.out.println("\nIdentifiant du Coin 3");
        idCoin=Lire.i();
        System.out.println("Abscisse du Coin");
        x=Lire.d();
        System.out.println("Ordonnée du Coin");
        y=Lire.d();
        c3=new Coin(idCoin,x,y);
        // Pour afficher textuellement le coin c3
        c3.afficher();
        listeCoin.add(c3.idCoin);

        // Création d'un mur m2
        Mur m2;
        System.out.println("Identifiant du Mur 2");
        idMur=Lire.i();
        m2=new Mur(idMur,c2,c3,hauteurPiece);
        m2.afficher();
        //Formattage de l'affichage, pour afficher seuleument à 2 chiffres après la virgule
        System.out.format("Longueur du mur = %.2f",m2.longueur());
        // Calcul et affichage de la surface d'un mur
        System.out.format("Surface apres enlevement des ouvertures = %.2f",m2.surface());
        listeMur.add(m2);

        // Création d'un coin c4 pour créer le troisième mur de la pièce 
        Coin c4;
        System.out.println("\nIdentifiant du Coin 4");
        idCoin=Lire.i();
        System.out.println("Abscisse du Coin");
        x=Lire.d();
        System.out.println("Ordonnée du Coin");
        y=Lire.d();
        c4=new Coin(idCoin,x,y);
        // Pour afficher textuellement le coin c4
        c4.afficher();
        listeCoin.add(c4.idCoin);

        // Création d'un mur m3
        Mur m3;
        System.out.println("Identifiant du Mur 3");
        idMur=Lire.i();
        m3=new Mur(idMur,c3,c4,hauteurPiece);
        m3.afficher();
        //Formattage de l'affichage, pour afficher seuleument à 2 chiffres après la virgule
        System.out.format("Longueur du mur = %.2f",m3.longueur());
        // Calcul et affichage de la surface d'un mur
        System.out.format("Surface apres enlevement des ouvertures = %.2f",m3.surface());
        listeMur.add(m3);

        // Création d'un mur m4
        Mur m4;
        System.out.println("\nIdentifiant du Mur 4");
        idMur=Lire.i();
        m4=new Mur(idMur,c4,c1,hauteurPiece);
        m4.afficher();
        //Formattage de l'affichage, pour afficher seuleument à 2 chiffres après la virgule
        System.out.format("Longueur du mur = %.2f",m4.longueur());
        // Calcul et affichage de la surface d'un mur
        System.out.format("Surface apres enlevement des ouvertures = %.2f",m4.surface());
        listeMur.add(m4);


        //création du plafond 
        Plafond p1;
        System.out.println("\nIdentifiant du plafond");
        idPlafond=Lire.i();
        p1 = new Plafond (idPlafond,m1,m2);    
        p1.afficher(p1.surface(p1.calculerSurfacePlafond()));
        
        //création du sol
        Sol s1;
        System.out.println("Identifiant du sol");
        idSol=Lire.i();
        s1 = new Sol(idSol,m1,m2);
        s1.afficher(s1.calculerSurface());

        //Revetements
        int idRevetement=0;
        String designation="rien";
        boolean pourMur=false;
        boolean pourSol=false;
        boolean pourPlafond=false;
        double prixUnitaire=0;
        Revetements revetements = new Revetements (idRevetement, designation, pourMur, pourSol, pourPlafond, prixUnitaire);
        revetements.lireFichier("revetements.txt");
        List<Double> prixPiece = revetements.demanderRevêtements(m1.surface, m2.surface, m3.surface, m4.surface, p1.calculerSurfacePlafond(), s1.calculerSurface());
        
        
        
                //sauvegarde des données
        c1.SauvegardeCoin();
        c2.SauvegardeCoin();
        c3.SauvegardeCoin();
        c4.SauvegardeCoin();
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file,true))){
            bufferedWriter.newLine();
            bufferedWriter.close();
        } catch(IOException e){
            e.printStackTrace();
        }
        m1.SauvergardeMur();
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file,true))){
            bufferedWriter.write(Double.toString(prixPiece.get(0)));
            bufferedWriter.newLine();
            bufferedWriter.close();
        } catch(IOException e){
            e.printStackTrace();
        }
        m2.SauvergardeMur();
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file,true))){
            bufferedWriter.write(Double.toString(prixPiece.get(1)));
            bufferedWriter.newLine();
            bufferedWriter.close();
        } catch(IOException e){
            e.printStackTrace();
        }
        m3.SauvergardeMur();
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file,true))){
            bufferedWriter.write(Double.toString(prixPiece.get(2)));
            bufferedWriter.newLine();
            bufferedWriter.close();
        } catch(IOException e){
            e.printStackTrace();
        }
        m4.SauvergardeMur();
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file,true))){
            bufferedWriter.write(Double.toString(prixPiece.get(3)));
            bufferedWriter.newLine();
            bufferedWriter.close();
        } catch(IOException e){
            e.printStackTrace();
        }
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file,true))){
            bufferedWriter.newLine();
            bufferedWriter.close();
        } catch(IOException e){
            e.printStackTrace();
        }
        s1.SauvergardeSol(listeCoin);
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file,true))){
            bufferedWriter.write(Double.toString(prixPiece.get(4))); //son IdRevetement
            bufferedWriter.newLine();
            bufferedWriter.newLine();
            bufferedWriter.close();
        } catch(IOException e){
            e.printStackTrace();
        }
        p1.SauvergardePlafond(listeCoin);
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file,true))){
            bufferedWriter.write(Double.toString(prixPiece.get(5))); //son IdRevetement
            bufferedWriter.newLine();
            bufferedWriter.close();
        } catch(IOException e){
            e.printStackTrace();
        }
        
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file,true))){
            bufferedWriter.write("Piece;"+Integer.toString(identier)+";"+Piece.idSol+";"+Piece.idPlafond+";"+m1.idMur+";"+m2.idMur+";"+m3.idMur+";"+m4.idMur);
            bufferedWriter.newLine();
            bufferedWriter.close();
        } catch(IOException e){
            e.printStackTrace();
        }
        
        return prixPiece.get(6);
    }
}
