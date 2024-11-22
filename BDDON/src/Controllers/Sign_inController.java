/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controllers;

import java.sql.*;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author amena
 */
public class Sign_inController implements Initializable {
    Connection cnx;
    public PreparedStatement st ;
    public ResultSet result;

    @FXML
    private TextField txt_username;
    @FXML
    private TextField txt_password;
    @FXML
    private HBox hbox;
    @FXML
    private HBox hbx;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      
    }    

    @FXML
    private void openmail(ActionEvent event) {
    }
  private Parent fxml ;
    @FXML
    private void openhome(ActionEvent event) {
                String nom=txt_username.getText();
        String pass=txt_password.getText();
        String sql="select userName, password from admin";
        if (nom.equals("user")&&pass.equals("user")){
           
            Stage home=new Stage();
            try{
                fxml= FXMLLoader.load(getClass().getResource("/Views/Dashboard.fxml"));
                Scene scene=new Scene(fxml);
                home.setScene(scene);
                home.show();
            }
            catch(IOException e){
                e.printStackTrace();
            }
        }else{
            System.out.println("nomde l'utilisateur ou mot de passe incorrect:");
        }
 
    }
    

}
