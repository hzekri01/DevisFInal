/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.lefevre.devisfinal.GUI;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

/**
 *
 * @author lemiu
 */
public class DessinCanvas extends Pane {
    
    private Canvas Canvas;
    
    public DessinCanvas(){
        this.Canvas = new Canvas(this.getWidth(), this.getHeight());
        this.getChildren().add(this.Canvas);
        this.Canvas.heightProperty().bind(this.heightProperty()); //à chq fois que la propriété de hauteur du pain va être modifiée, alors la propriété de hauteur du canvas va ê modifiée
        this.Canvas.heightProperty().addListener((o) -> {
                // System.out.println("w="+this.Canvas.getWidth()+" ;  h="+this.Canvas.getHeight());

            this.redrawAll();
        });
        this.Canvas.widthProperty().bind(this.widthProperty()); //à chq fois que la propriété de hauteur du pain va être modifiée, alors la propriété de hauteur du canvas va ê modifiée
        this.Canvas.widthProperty().addListener((o) -> {
            this.redrawAll();
        });
        
        this.redrawAll();
    
}
    public void redrawAll(){
        GraphicsContext context = this.Canvas.getGraphicsContext2D();
        context.setFill(Color.LIGHTGREY);
        context.fillRect(0, 0, this.Canvas.getWidth(), this.Canvas.getHeight()); //on dessine de la taille de la zone du canvas
    }
}
