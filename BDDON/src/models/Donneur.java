/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author wesla
 */
public class Donneur implements EntiteSanguine {
    
    int id ; 
    String nom ; 
    String prenom;
    String email; 
    String groupeSanguin;

    public Donneur() {
    }

    public Donneur(int id, String nom, String prenom, String groupeSanguin, String email) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.groupeSanguin = groupeSanguin;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setGroupeSanguin(String groupeSanguin) {
        this.groupeSanguin = groupeSanguin;
    }
    
    @Override
    public int getId() {
        return id;
    }

    
    @Override
    public String getNom() {
        return nom;
    }
    
    @Override
    public String getPrenom() {
        return prenom;
    }

     @Override
    public String getEmail() {
        return email;
    }

    
     @Override
    public String getGroupeSanguin() {
        return groupeSanguin;
    }
    
    
}
