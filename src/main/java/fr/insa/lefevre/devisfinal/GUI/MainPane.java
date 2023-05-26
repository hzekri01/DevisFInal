/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.lefevre.devisfinal.GUI;

import java.io.File;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;

/**
 *
 * @author lemiu
 */
public class MainPane extends BorderPane {
    //attributs
    
    // A FAIRE: private Batiement model;    // A IMPORTER SI ON LE MET DANS UN AUTRE PACKAGE
    private Controleur controleur;      // get de model et controleur à faire 
    
    private Button bNouvelEtage;
    private Button bValiderRevetementMur1;
    private Button bValiderRevetementMur2;
    private Button bValiderNombrePorte;
    private Button bValiderNombreFenetre;
    private Button bValiderRevetementSol;
    private Button bValiderRevetementPlafond;
     
    private DessinCanvas cDessin;
    
    private ChoiceBox cbEtage;
    
    private TextField tfMessageInstantane;

    
    private VBox vbGauche; //ici le Vbox sera modifiable donc est un attribut.
    private VBox vbMenu;
    private VBox vbMessageInstantane;
    
    
      
    
    
    //constructeur
    public MainPane (){
        
    //-BARRE DE MENU-
               
       MenuBar barreMenu = new MenuBar();
            
        //Création d'un separateur
        SeparatorMenuItem separator = new SeparatorMenuItem();
        
        //FICHIER 
        Menu menuFichier = new Menu("Fichier");
            //item
        MenuItem menuItemNouveau = new MenuItem("Nouveau");
        MenuItem menuItemOuvrir = new MenuItem("Ouvrir");
    //mise sous ecoute
       // FileChooser fileChooser = new FileChooser();
       // menuItemOuvrir.setOnAction((t) -> {
        //  File selectedFile = fileChooser.showOpenDialog(Main stage);
       //     System.out.println(selectedFile);
       // });
        MenuItem menuItemEnregistrerSous = new MenuItem("Enregistrer sous");

        menuFichier.getItems().add(menuItemNouveau);
      //  menuFichier.getItems().add(separator);
        menuFichier.getItems().add(menuItemOuvrir);
     //   menuFichier.getItems().add(separator);
        menuFichier.getItems().add(menuItemEnregistrerSous);
        
        //CREATION
        Menu menuCréation = new Menu("Création");
            //item
        MenuItem menuItemCoin = new MenuItem("Coin");
        MenuItem menuItemMur = new MenuItem("Mur");
        MenuItem menuItemPiece = new MenuItem("Piece");
        MenuItem menuItemEtage = new MenuItem("Etage");
        
   //Mise sous écoute et action
        menuItemCoin.setOnAction((t) -> {
            creationCoin();
        });
        menuItemMur.setOnAction((t) -> {
            creationMur();
        });   
        menuItemPiece.setOnAction((t) -> {
            creationPiece();
        }); 
        menuItemEtage.setOnAction((t) -> {
            creationEtage();
        }); 
                
            //ajout item dans menu
        menuCréation.getItems().add(menuItemCoin);
       // menuCréation.getItems().add(separator);
        menuCréation.getItems().add(menuItemMur);
       // menuCréation.getItems().add(separator);
        menuCréation.getItems().add(menuItemPiece);
        //menuCréation.getItems().add(separator);
        menuCréation.getItems().add(menuItemEtage);
        
        //CALCUL
        Menu menuCalcul = new Menu("Calcul");
        
            //item
        MenuItem menuItemLancerDevis = new MenuItem("Lancer Devis");
        
            //ajout item dans menu
        menuCalcul.getItems().add(menuItemLancerDevis);
        
            
        //Ajout des menus dans le menu bar
        
        barreMenu.getMenus().add(menuFichier);
        barreMenu.getMenus().add(menuCréation);
        barreMenu.getMenus().add(menuCalcul);
        
           
        this.vbMenu = new VBox(barreMenu);  
        this.setTop(vbMenu);
       
        
        //-BOUTONS POUR LES VBOX-
        
        this.bNouvelEtage = new Button("Nouvel Etage");
        this.bValiderRevetementMur1 = new Button("Valider le 1er revêtement Mur");
        this.bValiderRevetementMur2 = new Button("Valider le 2eme revêtement Mur");
        this.bValiderNombrePorte = new Button("Valider le nombre de portes");
        this.bValiderNombreFenetre = new Button("Valider le nombre de fenetres");
        this.bValiderRevetementSol = new Button("Valider le revêtement Sol");
        this.bValiderRevetementPlafond = new Button("Valider le revêtement Plafond");     
        
        this.cbEtage = new ChoiceBox();
        
        
        Text texteBienvenue = new Text("\n\n\nBienvenue dans votre application.");
        texteBienvenue.setFont(Font.font("Arial", 15));
        
        
        
        this.vbGauche = new VBox(texteBienvenue);
        this.setLeft(vbGauche); //on inclus le Vbox dans panneau principal qui est this
        
        this.tfMessageInstantane = new TextField();
        this.vbMessageInstantane = new VBox(tfMessageInstantane);
        this.setBottom(this.tfMessageInstantane);
       
       
        this.cDessin = new DessinCanvas ();
        this.setCenter(this.cDessin);

 
        

        
    }
    
    // FONCTIONS POUR LE MENU
    
    /**
    public void menuOuvrir(ActionEvent t){
        FileChooser chooser = new FileChooser();
        File f = chooser.showSaveDialog(this.vue.getInStage());
       
        }
        * */
    
    
    
    
    //FONCTIONS POUR MODIFIER VBOX GAUCHE  
   
    public void creationCoin() {
    // Effacer le contenu existant du VBox
    vbGauche.getChildren().clear();

    // Créer un nouveau nœud de texte avec le contenu souhaité
    Text texte1 = new Text("CREATION DE COIN\nVeuillez cliquer sur la fenêtre\n pour créer vos coins.");
    

    // Ajouter le nouveau nœud de texte au VBox
    vbGauche.getChildren().add(texte1);
}
    
    public void creationMur() {
    // Effacer le contenu existant du VBox
    vbGauche.getChildren().clear();

    // Créer un nouveau nœud de texte avec le contenu souhaité
    Text texte1 = new Text("CREATION DE MUR\nVeuillez cliquer sur 2 coins\n pour créer un mur.");
    Text texte2 = new Text("Veuillez entrer si dessous un\nrevêtement AVANT la saisie du mur\net le valider :");
    Text texte3 = new Text("ici mettre un valideur qui permet de dire si il a cliqué");
    
    
    // Ajouter le nouveau nœud de texte au VBox
    vbGauche.getChildren().add(texte1);
    vbGauche.getChildren().add(texte2);
    TextField textFieldRevetementMur1 = new TextField();
    vbGauche.getChildren().add(textFieldRevetementMur1); 
    vbGauche.getChildren().add(bValiderRevetementMur1);
    TextField textFieldRevetementMur2 = new TextField();
    vbGauche.getChildren().add(textFieldRevetementMur2); 
    vbGauche.getChildren().add(bValiderRevetementMur2);
    TextField textFieldNombrePorte = new TextField();
    vbGauche.getChildren().add(textFieldNombrePorte); 
    vbGauche.getChildren().add(bValiderNombrePorte);
    TextField textFieldNombreFenetre = new TextField();
    vbGauche.getChildren().add(textFieldNombreFenetre); 
    vbGauche.getChildren().add(bValiderNombreFenetre);
    
    vbGauche.getChildren().add(texte3); // texte de validation 
       
}
    
    public void creationPiece() {
    // Effacer le contenu existant du VBox
    vbGauche.getChildren().clear();

    // Créer un nouveau nœud de texte avec le contenu souhaité
    Text texte1 = new Text("CREATION DE PIECE\nVeuillez cliquer sur 2 murs\n pour créer une piece.");
    Text texte2 = new Text("Veuillez entrer si dessous AVANT la saisie de la piece :\n-un revêtement sol\n-un revetement plafond.");
    Text texte3 = new Text("ici mettre un valideur qui permet de dire si il a cliqué");
    
    
    // Ajouter le nouveau nœud de texte au VBox
    vbGauche.getChildren().add(texte1);
    vbGauche.getChildren().add(texte2);
    TextField textFieldRevetementSol = new TextField();
    vbGauche.getChildren().add(textFieldRevetementSol);
    vbGauche.getChildren().add(bValiderRevetementSol);
    TextField textFieldRevetementPlafond = new TextField();
    vbGauche.getChildren().add(textFieldRevetementPlafond);
    vbGauche.getChildren().add(bValiderRevetementPlafond);
    vbGauche.getChildren().add(texte3);
}
    public void creationEtage() {
    // Effacer le contenu existant du VBox
    vbGauche.getChildren().clear();

    // Créer un nouveau nœud de texte avec le contenu souhaité
    Text texte1 = new Text("CREATION ETAGE\nVeuillez selectionner l'etage\n a modifier.");
    Text texte2 = new Text("Pour creer un nouvel etage,\ncliquer ici :");
    Text texte3 = new Text("ici mettre un valideur qui permet de dire si il a cliqué");
    
    
    // Ajouter le nouveau nœud de texte au VBox
    vbGauche.getChildren().add(texte1);
    vbGauche.getChildren().add(cbEtage);  
    vbGauche.getChildren().add(texte2);
    vbGauche.getChildren().add(bNouvelEtage);
    vbGauche.getChildren().add(texte3);
}
}