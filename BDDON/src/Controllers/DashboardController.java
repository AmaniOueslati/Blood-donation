package Controllers;
import Controllers.*;
import java.io.IOException;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import tableView.UpdateDonneurController;

/**
 *
 * @author wesla
 */
public class DashboardController extends Application {

    @FXML
    private VBox A;
    
       @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/Views/Dashboard.fxml"));
        
        Scene scene = new Scene(root,1315,810);
        
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    @FXML
    private void DonList(ActionEvent event) {
        
          try {
            // Load the UpdateDonneur.fxml file
             FXMLLoader loader = new FXMLLoader(getClass().getResource("/tableView/tableView.fxml"));
             Parent root = loader.load();
          
            // Create a new scene 
            Scene scene = new Scene(root);

            // Create a new stage (window)
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.initStyle(StageStyle.UTILITY);

            // Show the stage
            stage.show();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @FXML
    private void RecList(ActionEvent event) {
        try {
            // Load the UpdateDonneur.fxml file
             FXMLLoader loader = new FXMLLoader(getClass().getResource("/Views/Receveur.fxml"));
             Parent root = loader.load();
            // Get the controller from the loader
           

            // Create a new scene
            Scene scene = new Scene(root);

            // Create a new stage (window)
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.initStyle(StageStyle.UTILITY);

            // Show the stage
            stage.show();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @FXML
    private void stock(ActionEvent event) {
        try {
            // Load the UpdateDonneur.fxml file
             FXMLLoader loader = new FXMLLoader(getClass().getResource("/Views/stock.fxml"));
             Parent root = loader.load();
            // Get the controller from the loader
          

            // Create a new scene
            Scene scene = new Scene(root);

            // Create a new stage (window)
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.initStyle(StageStyle.UTILITY);

            // Show the stage
            stage.show();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @FXML
    private void RdvForm(ActionEvent event) {
        
          try {
            // Load the UpdateDonneur.fxml file
             FXMLLoader loader = new FXMLLoader(getClass().getResource("/Views/RDV.fxml"));
             Parent root = loader.load();
            // Get the controller from the loader
            RDVController rdvController = loader.getController();

       

            // Create a new scene
            Scene scene = new Scene(root);

            // Create a new stage (window)
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.initStyle(StageStyle.UTILITY);

            // Show the stage
            stage.show();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

   
    @FXML
    private void Apropos(ActionEvent event) {
          try {
            // Load the UpdateDonneur.fxml file
             FXMLLoader loader = new FXMLLoader(getClass().getResource("/Views/FXML.fxml"));
             Parent root = loader.load();
            // Get the controller from the loader
            FXMLController fxmlController = loader.getController();

       

            // Create a new scene
            Scene scene = new Scene(root);

            // Create a new stage (window)
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.initStyle(StageStyle.UTILITY);

            // Show the stage
            stage.show();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

 @FXML
private void logOut(ActionEvent event) {
    try {
        // Close the current stage
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        currentStage.hide();

        // Load main.fxml file
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Views/main.fxml"));
        Parent root = loader.load();

        // Get the controller from the loader
        MainController mainController = loader.getController();

        // Create a new scene
        Scene scene = new Scene(root);

        // Create a new stage (window)
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.initStyle(StageStyle.UTILITY);

        // Show the new stage
        stage.show();

    } catch (IOException ex) {
        ex.printStackTrace();
    }
}

    
}