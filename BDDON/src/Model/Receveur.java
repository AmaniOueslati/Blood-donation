/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author amena
 */
public class Receveur {
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
