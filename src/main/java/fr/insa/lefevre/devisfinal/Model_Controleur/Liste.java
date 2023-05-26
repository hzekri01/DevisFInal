/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.lefevre.devisfinal.Model_Controleur;

/**
 *
 * @author Elève
 */
import java.util.ArrayList;
import java.util.List;
import java.util.function.IntFunction;

public class Liste<T> {

    private String nom;
    private List<T> elements;

    public Liste(String nom) {
        this.nom = nom;
        this.elements = new ArrayList<>();
    }

    Liste() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public List<T> getElements(int i) {
        return elements;
    }

    public String getNom() {
        return nom;
    }

    public void ajouterElement(T element) {
        elements.add(element);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Liste ").append(nom).append(":");
        for (T element : elements) {
            sb.append("\n").append(element);
        }
        return sb.toString();
    }

    
}

