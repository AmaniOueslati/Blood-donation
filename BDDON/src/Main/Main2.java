/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package Main;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


import static javafx.stage.StageStyle.TRANSPARENT;

/**
 *
 * @author amena
 */
public class Main2 extends Application {
       

    @Override
    public void start(Stage primaryStage) {
        try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Views/main.fxml"));
            Parent root = loader.load();
            Scene scene1 = new Scene(root);
            scene1.setFill(Color.TRANSPARENT);

            // Show the first stage
            Stage st = new Stage();
            st.setScene(scene1);
            st.initStyle(StageStyle.TRANSPARENT);
            st.show();

            // Set an event handler to show the second stage when the first one is hidden
         
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
// Load the FXML file


 public static void main(String[] args) {
        launch(args);
    }
    
}

    

    


    
  

