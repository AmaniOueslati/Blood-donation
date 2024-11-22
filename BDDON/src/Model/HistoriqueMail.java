/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;
import models.*;
import Model.*;
import models.*; 

import java.time.LocalDate;

public record HistoriqueMail(Donneur donneur, LocalDate date, String typeSang) {
    
    // Méthode pour obtenir le nom du donneur
    public String getNomDonneur() {
        return donneur.getNom();
    }

    // Méthode pour obtenir le prénom du donneur
    public String getPrenomDonneur() {
        return donneur.getPrenom();
    }

    // Méthode pour obtenir le groupe sanguin du donneur
    public String getGroupeSanguinDonneur() {
        return donneur.getGroupeSanguin();
    }

    

    // Méthode pour obtenir la date de l'envoi de l'email
    public LocalDate getDateEnvoi() {
        return date;
    }

    // Méthode pour obtenir le type de sang
    public String getTypeSang() {
        return typeSang;
    }

    // Vous pouvez ajouter d'autres méthodes si nécessaire.
}
