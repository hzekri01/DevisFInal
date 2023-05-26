/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.lefevre.devisfinal.Model_Controleur;

import java.util.ArrayList;
import java.util.List;

public abstract class Ouverture {
    protected int idOuverture;
    protected double dimX;
    protected double dimY;

    public Ouverture(int idOuverture) {
        this.idOuverture = idOuverture;
    }

    public abstract double surface();
    public abstract List<Double> afficher();
    public abstract String toString();
    
    // Getters and setters
    public int getIdOuverture() {
        return idOuverture;
    }

    public void setIdOuverture(int idOuverture) {
        this.idOuverture = idOuverture;
    }

    public double getDimX() {
        return dimX;
    }

    public void setDimX(double dimX) {
        this.dimX = dimX;
    }

    public double getDimY() {
        return dimY;
    }

    public void setDimY(double dimY) {
        this.dimY = dimY;
    }
}

