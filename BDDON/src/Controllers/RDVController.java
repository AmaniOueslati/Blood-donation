/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */

package Controllers;
import mailApp.*; 

import tableView.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import models.Donneur;


/**
 * FXML Controller class
 *
 * @author wesla
 */
public class RDVController implements Initializable {
    
    @FXML
    private TextField nomField;
    @FXML
    private TextField prenomField;
    @FXML
    private TextField groupeSanguinField;

    @FXML
    private TextField emailField;
    
    private Donneur donneur;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
     public void setDonneur(Donneur donneur) {
        this.donneur = donneur;
        fillFields();
    }
     
       private void fillFields() {
        nomField.setText(donneur.getNom());
        prenomField.setText(donneur.getPrenom());
        groupeSanguinField.setText(donneur.getGroupeSanguin());
        emailField.setText(donneur.getEmail());
    }
       
       public void initDataMail(Donneur donneur) {
        this.donneur = donneur;
        fillFields();
    }

 @FXML
private void EnvoyerMail(ActionEvent event) {
    // Create a list with a single email address
    List<String> emailList = new ArrayList<>();
    emailList.add(donneur.getEmail());

    // Call the sendMail method with the list
    MailApp.sendMail(emailList);

    // Display a success message
    showAlert("Email Envoyé", "L'email a été envoyé avec succès.");
}

private void showAlert(String title, String content) {
    Alert alert = new Alert(AlertType.INFORMATION);
    alert.setTitle(title);
    alert.setHeaderText(null);
    alert.setContentText(content);
    alert.showAndWait();
}

}

