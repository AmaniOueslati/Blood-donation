/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controllers;

import Model.ReceveurException;
import models.Receveur;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author amena
 */
public class ReceveurController implements Initializable {

    @FXML
    private TableColumn<Receveur, String> Nom;
    @FXML
    private TableColumn<Receveur, String> Prenom;
    @FXML
    private TableColumn<Receveur, String> groupesanguin;
    @FXML
    private TableColumn<Receveur, String> email;
    @FXML
    private TableView<Receveur> tab;
    
    private ObservableList<Receveur> list = FXCollections.observableArrayList(
            new Receveur("Amine", "boj", "A", "amine@gmail.com"),
            new Receveur("ahmed", "dah", "O", "ahmed@gmail.com"),
            new Receveur("seif", "aaf", "B", "saif@gmail.com"),
            new Receveur("amen", "say", "AB", "amen@gmail.com"));
    @FXML
    private TextField txnom;
    @FXML
    private TextField txprenom;
    @FXML
    private TextField txttype;
    @FXML
    private TextField txtemaill;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
         Nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        Prenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        email.setCellValueFactory(new PropertyValueFactory<>("email"));
        groupesanguin.setCellValueFactory(new PropertyValueFactory<>("groupeSanguin"));


        tab.setItems(list);
        // TODO
    }    

    @FXML
    private void handleModifierButto(ActionEvent event) {
        Receveur selectedDonneur = tab.getSelectionModel().getSelectedItem();

    if (selectedDonneur != null) {
        // Create a TextInputDialog
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Modifier Receveur");
        dialog.setHeaderText("Modifier les détails de Donneur");

        // Set the default values in the dialog
        dialog.setContentText("Nouveau email:");
        dialog.getEditor().setText(selectedDonneur.getEmail());

        // Show the dialog and wait for the user's input
        Optional<String> result = dialog.showAndWait();

        // If the user clicked OK, update the Donneur's details
        result.ifPresent(newemail-> {
            selectedDonneur.setEmail(newemail);
            // You can repeat the above steps for other Donneur details (Prenom, email, etc.)
            // Update your table view accordingly
            tab.refresh();  // This refreshes the TableView to reflect the changes
        });
    } else {
        showAlert("Aucun Receveur sélectionné", "Veuillez sélectionner un Donneur pour le modifier.");
    }
       
    }

    @FXML
    private void handleAjouterButto(ActionEvent event) {
         TextInputDialog nomDialog = new TextInputDialog();
    nomDialog.setTitle("Ajouter Receveur");
    nomDialog.setHeaderText("Ajouter un nouveau Receveur");
    nomDialog.setContentText("Nom:");

    // Show the dialog and wait for user input
    Optional<String> nomResult = nomDialog.showAndWait();
    if (!nomResult.isPresent()) {
        return; // User canceled the input
    }
    String newNom = nomResult.get();
      if (newNom.trim().isEmpty()) {
        try {
            throw new ReceveurException("Le nom du Receveur ne peut pas être vide.");
        } catch (ReceveurException e) {
            showAlert("Erreur lors de l'ajout du Receveur", e.getMessage());
            return;
        }
    }

    // Create a dialog with text input for Prenom
    TextInputDialog prenomDialog = new TextInputDialog();
    prenomDialog.setTitle("Ajouter Receveur");
    prenomDialog.setHeaderText("Ajouter un nouveau Receveur");
    prenomDialog.setContentText("Prenom:");

    // Show the dialog and wait for user input
    Optional<String> prenomResult = prenomDialog.showAndWait();
    if (!prenomResult.isPresent()) {
        return; // User canceled the input
    }
    String newPrenom = prenomResult.get();

    // Create a dialog with text input for Groupe Sanguin
    TextInputDialog groupeSanguinDialog = new TextInputDialog();
    groupeSanguinDialog.setTitle("Ajouter Receveur");
    groupeSanguinDialog.setHeaderText("Ajouter un nouveau Receveur");
    groupeSanguinDialog.setContentText("Groupe Sanguin:");

    // Show the dialog and wait for user input
    Optional<String> groupeSanguinResult = groupeSanguinDialog.showAndWait();
    if (!groupeSanguinResult.isPresent()) {
        return; // User canceled the input
    }
    String newGroupeSanguin = groupeSanguinResult.get();

    // Create a dialog with text input for Email
    TextInputDialog emailDialog = new TextInputDialog();
    emailDialog.setTitle("Ajouter Receveur");
    emailDialog.setHeaderText("Ajouter un nouveau Receveur");
    emailDialog.setContentText("Email:");

    // Show the dialog and wait for user input
    Optional<String> emailResult = emailDialog.showAndWait();
    if (!emailResult.isPresent()) {
        return; // User canceled the input
    }
    String newEmail = emailResult.get();

    // Create a new Donneur with the provided details
    Receveur newReceveur = new Receveur(newNom, newPrenom, newGroupeSanguin, newEmail);

    // Add the new Donneur to the list
    list.add(newReceveur);

    // Update your table view accordingly
    tab.refresh();
    }

    @FXML
    private void handleSupprimerButto(ActionEvent event) {
               Receveur selectedDonneur = tab.getSelectionModel().getSelectedItem();
        if (selectedDonneur != null) {
            // Show a confirmation dialog
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation de suppression");
            alert.setHeaderText("Supprimer Donneur");
            alert.setContentText("Êtes-vous sûr de vouloir supprimer ce Donneur?");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.isPresent() && result.get() == ButtonType.OK) {
                // User clicked OK, remove the selected Donneur
                list.remove(selectedDonneur);
            }
        } else {
            showAlert("Aucun Donneur sélectionné", "Veuillez sélectionner un Donneur à supprimer.");
        }
        
    }
     private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }

    @FXML
    private void handelchercherbutton(ActionEvent event) {
          String searchNom = txnom.getText().trim();
    String searchPrenom = txprenom.getText().trim();
    String searchEmail = txtemaill.getText().trim();
    String searchTypeSang = txttype.getText().trim();

    // Filter the list based on the search criteria
    ObservableList<Receveur> filteredList = list.filtered(receveur ->
            (searchNom.isEmpty() || receveur.getNom().contains(searchNom)) &&
            (searchPrenom.isEmpty() || receveur.getPrenom().contains(searchPrenom)) &&
            (searchEmail.isEmpty() || receveur.getEmail().contains(searchEmail)) &&
            (searchTypeSang.isEmpty() || receveur.getGroupeSanguin().contains(searchTypeSang))
    );

    // Update the TableView with the filtered list
    tab.setItems(filteredList);
    }

    @FXML
    private void handleResetButton(ActionEvent event) {
        // Clear the text fields
    txnom.clear();
    txprenom.clear();
    txttype.clear();
    txtemaill.clear();

    // Deselect any selected item in the TableView
    tab.setItems(list);
    tab.getSelectionModel().clearSelection();
    
    }
    
}
