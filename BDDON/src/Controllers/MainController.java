/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controllers;



import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author amena
 */

public class MainController implements Initializable {

    @FXML
    private VBox vbox;
    @FXML
    private Button btncrée;
    @FXML
    private Button btnconn;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        TranslateTransition t = new TranslateTransition(Duration.seconds(1), vbox);
        t.setToX(-vbox.getLayoutX() * -8); // Utilisation d'une valeur négative

        t.play();
        t.setOnFinished(e -> {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/Views/sign_in.fxml"));
                Parent signInRoot = loader.load();
                vbox.getChildren().removeAll();
                vbox.getChildren().setAll(signInRoot);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
    }

    @FXML
    private void clickconn() {
        double currentX = 300;

        TranslateTransition t = new TranslateTransition(Duration.seconds(1), vbox);
        t.setToX(currentX);

        t.play();
        t.setOnFinished(e -> {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/Views/sign_in.fxml"));
                Parent root = loader.load();
                vbox.getChildren().removeAll();
                vbox.getChildren().setAll(root);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
    }

    @FXML
    private void clickcréer() {
        double currentX = 7;

        TranslateTransition t = new TranslateTransition(Duration.seconds(1), vbox);
        t.setToX(currentX);

        t.play();
        t.setOnFinished(e -> {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/Views/sign_up.fxml"));
                Parent root = loader.load();
                vbox.getChildren().removeAll();
                vbox.getChildren().setAll(root);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
    }
}


  
    

                 
  
      
    
    

