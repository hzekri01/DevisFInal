package fr.insa.lefevre.devisfinal.GUI;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class Main extends Application {

    
    @Override
    public void start(Stage stage) {
        stage.setTitle("Devis Bâtiment");
        Scene sc = new Scene(new MainPane(),800,600);  //je mets dans ma scène le main pane 
        stage.setScene(sc);
        stage.show();     
        
    }


        
    
    public static void lancerinterface() {
        launch();
    }
}
