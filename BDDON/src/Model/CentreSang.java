/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;
import models.*;
import java.util.List; 
import java.util.LinkedList;
import java.util.Set; 
import java.util.HashSet; 

/**
 *
 * @author wesla
 */
public class CentreSang {
    String nomCentre; 
    private List<Donneur> donneurs ; 
     private List<Receveur> receveurs ; 
     
     
     
      public CentreSang(String nom){
    
     this.nomCentre=nom;
     donneurs=new LinkedList <Donneur>(); 
     receveurs = new LinkedList <Receveur>(); 
    }
    
    public List<Donneur> getDonneurs(){return donneurs; }
    
    public String getNom(){return nomCentre; }
    
    
    public void ajouterDonneur(Donneur emp) {
     donneurs.add(emp); 
    }
    
     public List<Receveur> getReceveurs(){return receveurs; }
     
     
   
    public void ajouterReceveur(Receveur emp) {
     receveurs.add(emp); 
    }




}
    
    
    
    
    

