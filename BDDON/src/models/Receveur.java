/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import Model.*;

/**
 *
 * @author amena
 */


public class Receveur extends Personne{
   private String groupeSanguin;

    public Receveur(String groupeSanguin, String nom, String prenom, String email) {
        super(nom, prenom, email);
        this.groupeSanguin = groupeSanguin;
    }

    public String getGroupeSanguin() {
        return groupeSanguin;
    }

    public void setGroupeSanguin(String groupeSanguin) {
        this.groupeSanguin = groupeSanguin;
    }

    @Override
    public void setEmail(String email) {
        this.email=email ;     }




}
/*
public class Receveur   {
     private String nom;
    private String prenom;
    private String groupeSanguin;
    private String email;
    
    public Receveur(String nom, String prenom,String groupeSanguin, String email ) {
        this.nom = nom;
        this.prenom = prenom;
       
        this.groupeSanguin = groupeSanguin;
         this.email = email;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getGroupeSanguin() {
        return groupeSanguin;
    }

    public String getEmail() {
        return email;
    }

    // Other code...

     public void setemail(String email) {
        this.email = email;
    }
     
       public void setnom(String nom) {
        this.nom = nom;
    }
              public void setprenom(String prenom) {
        this.prenom = prenom;
    }
              
}
*/