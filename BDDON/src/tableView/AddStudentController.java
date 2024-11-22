/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package tableView;

import helpers.Dbconnect;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import models.*;
import javafx.stage.Stage;




import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import java.sql.PreparedStatement; 
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;


/**
 * FXML Controller class
 *
 * @author wesla
 */
public class AddStudentController implements Initializable {

    @FXML
    private TextField nameField;
    @FXML
    private TextField prenomField;
    @FXML
    private TextField typeField;
    @FXML
    private TextField EmailField;
    
    private boolean update;
    int donneurId;
    
     
  String query = null;
  Connection connection = null;
  PreparedStatement preparedStatement = null;
  ResultSet resultSet = null;
  Donneur donneur = null;
  private TableViewController tableViewController;
   public void setTableViewController(TableViewController tableViewController) {
        this.tableViewController = tableViewController;
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

   
@FXML
private void save(MouseEvent event) {
    connection = Dbconnect.connection();
    String nom = nameField.getText();
    String prenom = prenomField.getText();
    String email = EmailField.getText();
    String groupeSanguin = typeField.getText();

    if (nom.isEmpty() || prenom.isEmpty() || email.isEmpty() || groupeSanguin.isEmpty()) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText(null);
        alert.setContentText("Please Fill All DATA");
        alert.showAndWait();
    } else {
        getQuery();
        insert();
        clean();

        // If the tableViewController is set, refresh the TableView
        if (tableViewController != null) {
            tableViewController.refreshView();
        }
    }
}



    @FXML
    private void clear(MouseEvent event) {
    }

    private void getQuery() {
        query = "INSERT INTO `donneurs`(`nom`, `prenom`, `groupeSanguin`, `email`) VALUES (?, ?, ?, ?)";}

    private void insert() {
        
        
       try {

            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, nameField.getText());
            preparedStatement.setString(2, prenomField.getText());
            preparedStatement.setString(3, typeField.getText());
            preparedStatement.setString(4, EmailField.getText());
            preparedStatement.execute();
             Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setContentText("Donneur added successfully!");
            alert.showAndWait();

        } catch (SQLException ex) {
            Logger.getLogger(AddStudentController.class.getName()).log(Level.SEVERE, null, ex);
              // Optionally, show an error message or perform other actions upon insertion failure
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Error adding donneur. Please try again.");
            alert.showAndWait();
        }
    
    }

private void clean() {
    // Empty implementation
}



    
}
