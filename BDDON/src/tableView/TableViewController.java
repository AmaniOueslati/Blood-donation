    /*
     * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
     * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
     */
    package tableView;

    import helpers.*; 
    import bddon.*; 
    import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
    import helpers.*; 
    import Controllers.*; 
  //  import java.awt.Insets;
    import models.*; 
    //import com.sun.jdi.connect.spi.Connection;
 //   import java.awt.event.MouseEvent;
    import java.io.IOException;
    import models.*;

    import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;

    import java.io.IOException;
    import java.net.URL;
    import java.sql.Connection;
    import java.sql.PreparedStatement;
    import java.sql.ResultSet;
    import java.sql.SQLException;
    import java.time.LocalDate;
    import java.util.Observable;
    import java.util.ResourceBundle;
    import java.util.logging.Level;
    import java.util.logging.Logger;
    import javafx.collections.FXCollections;
    import javafx.collections.ObservableList;
    import javafx.fxml.FXML;
    import javafx.fxml.FXMLLoader;
    import javafx.fxml.Initializable;

    import javafx.scene.Node;
    import javafx.scene.Parent;
    import javafx.scene.Scene;
    import javafx.scene.control.TableCell;
    import javafx.scene.control.TableColumn;
    import javafx.scene.control.TableView;
    import javafx.scene.control.cell.PropertyValueFactory;

    import javafx.scene.layout.HBox;
    import javafx.stage.Stage;
    import javafx.stage.StageStyle;
    import javafx.util.Callback;

    import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
    import java.awt.Insets;

    import de.jensd.fx.glyphs.GlyphIcon;
    import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import java.util.ArrayList;
    import javafx.event.ActionEvent;
    import javafx.scene.control.Button;





    /**
     * FXML Controller class
     *
     * @author wesla
     */
    public class TableViewController implements Initializable {

        @FXML
        private TableView<Donneur> donneursTable;
        @FXML
        private TableColumn<Donneur, String> idCol;
        @FXML
        private TableColumn<Donneur, String> NomCol;
        @FXML
        private TableColumn<Donneur, String> PrenomCol;
        @FXML
        private TableColumn<Donneur, String> SanCol;
        @FXML
        private TableColumn<Donneur, String> EmailCol;
        @FXML
        private TableColumn<Donneur, String> OpCol;


      String query = null;
      Connection connection = null;
      PreparedStatement preparedStatement = null;
      ResultSet resultSet = null;
      Donneur donneur = null;
      ObservableList<Donneur> DonneursList = FXCollections.observableArrayList();
      private ArrayList<Donneur> donneursArrayList = new ArrayList<>();

        /**
         * Initializes the controller class.
         */
        @Override
        public void initialize(URL url, ResourceBundle rb) {
            // TODO
             connection = Dbconnect.connection();
            loadData();
        }

        /**
         *
         */
        @FXML
    public void refreshView() {
        // Your existing code to refresh the TableView
        try {
            if (connection != null) {
                DonneursList.clear();
                query = "SELECT * FROM `donneurs`";
                preparedStatement = connection.prepareStatement(query);
                resultSet = preparedStatement.executeQuery();

                while (resultSet.next()) {
                    DonneursList.add(new Donneur(
                            resultSet.getInt("id"),
                            resultSet.getString("nom"),
                            resultSet.getString("prenom"),
                            resultSet.getString("groupeSanguin"),
                            resultSet.getString("email")
                    ));
                }

                donneursTable.setItems(DonneursList);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TableViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }





        private void loadData() {
            connection=Dbconnect.connection(); 
            refreshView(); 

            idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
            NomCol.setCellValueFactory(new PropertyValueFactory<>("nom"));
            PrenomCol.setCellValueFactory(new PropertyValueFactory<>("prenom"));
            SanCol.setCellValueFactory(new PropertyValueFactory<>("groupeSanguin"));
            EmailCol.setCellValueFactory(new PropertyValueFactory<>("email"));
            donneursArrayList = new ArrayList<>(DonneursList);

             setupOpColButtons();
        }
       private void setupOpColButtons() {
        // Create cell factory for OpCol
        Callback<TableColumn<Donneur, String>, TableCell<Donneur, String>> cellFactory = new Callback<>() {
            @Override
            public TableCell<Donneur, String> call(final TableColumn<Donneur, String> param) {
                return new TableCell<>() {
                    private final HBox buttonsBox = new HBox();
                    private final Button deleteButton = new Button("Delete");
                    private final Button updateButton = new Button("Update");
                    private final Button MailButton = new Button("Send mail ");

                    {
                        // Set up delete button
                        deleteButton.setOnAction((ActionEvent event) -> {
                            // Handle delete action here
                            Donneur donneur = getTableView().getItems().get(getIndex());
                            deleteDonneur(donneur);
                            refreshView();
                        });

                        // Set up update button
                       // Set up update button
                     updateButton.setOnAction((ActionEvent event) -> {
                     // Handle update action here
                    Donneur donneur = getTableView().getItems().get(getIndex());
                         updateDonneur(donneur);
    });
                     
                        MailButton.setOnAction((ActionEvent event) -> {
                     // Handle update action here
                     
                    Donneur donneurMail = getTableView().getItems().get(getIndex());
                        MailDonneur(donneurMail);
    });


                        buttonsBox.getChildren().addAll(deleteButton, updateButton , MailButton );
                        buttonsBox.setSpacing(5);
                        
                        // Apply initial CSS styles to buttons
                         
// Apply initial CSS styles to buttons
deleteButton.setStyle("-fx-background-color: rgba(0, 0, 0, 0); -fx-border-color: #000; -fx-text-fill: #000; -fx-padding: 10px 20px; -fx-cursor: pointer;");
updateButton.setStyle("-fx-background-color: rgba(0, 0, 0, 0); -fx-border-color: #000; -fx-text-fill: #000; -fx-padding: 10px 20px; -fx-cursor: pointer;");
MailButton.setStyle("-fx-background-color: rgba(0, 0, 0, 0); -fx-border-color: #000; -fx-text-fill: #000; -fx-padding: 10px 20px; -fx-cursor: pointer;");

// Add event handler to change style when clicked
deleteButton.setOnMousePressed(event -> deleteButton.setStyle("-fx-background-color: #ff0000; -fx-border-color: #000; -fx-text-fill: #fff; -fx-padding: 10px 20px; -fx-cursor: pointer;"));
deleteButton.setOnMouseReleased(event -> deleteButton.setStyle("-fx-background-color: rgba(0, 0, 0, 0); -fx-border-color: #000; -fx-text-fill: #000; -fx-padding: 10px 20px; -fx-cursor: pointer;"));

updateButton.setOnMousePressed(event -> updateButton.setStyle("-fx-background-color: #ff0000; -fx-border-color: #000; -fx-text-fill: #fff; -fx-padding: 10px 20px; -fx-cursor: pointer;"));
updateButton.setOnMouseReleased(event -> updateButton.setStyle("-fx-background-color: rgba(0, 0, 0, 0); -fx-border-color: #000; -fx-text-fill: #000; -fx-padding: 10px 20px; -fx-cursor: pointer;"));

MailButton.setOnMousePressed(event -> MailButton.setStyle("-fx-background-color: #ff0000; -fx-border-color: #000; -fx-text-fill: #fff; -fx-padding: 10px 20px; -fx-cursor: pointer;"));
MailButton.setOnMouseReleased(event -> MailButton.setStyle("-fx-background-color: rgba(0, 0, 0, 0); -fx-border-color: #000; -fx-text-fill: #000; -fx-padding: 10px 20px; -fx-cursor: pointer;"));                       
                        
                    }

                    @Override
                    protected void updateItem(String item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                        } else {
                            setGraphic(buttonsBox);
                        }
                    }

                    
                    
                    
        private void MailDonneur(Donneur donneur) {
                        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
                   
                    
          try {
            // Load the UpdateDonneur.fxml file
             FXMLLoader loader = new FXMLLoader(getClass().getResource("/Views/RDV.fxml"));
             Parent root = loader.load();
            // Get the controller from the loader
             RDVController rdvController = loader.getController();

            // Set the donneur data to the update controller
             rdvController.initDataMail(donneur);

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
                };
            }
        };

        OpCol.setCellFactory(cellFactory);
    }





    private void deleteDonneur(Donneur donneur) {
        try {
            // Establish a connection
            Connection connection = Dbconnect.connection();

            // Prepare the SQL statement
            String query = "DELETE FROM donneurs WHERE id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                // Set the parameter (ID of the donneur to be deleted)
                preparedStatement.setInt(1, donneur.getId());

                // Execute the delete operation
                preparedStatement.executeUpdate();
            }

            // Close the connection
            connection.close();

            // Optional: Provide feedback to the user (e.g., show a success message)
            System.out.println("Donneur deleted successfully.");

        } catch (SQLException ex) {
            // Handle any SQL errors
            ex.printStackTrace();
        }
    }

    private void updateDonneur(Donneur donneur) {
        try {
            // Load the UpdateDonneur.fxml file
             FXMLLoader loader = new FXMLLoader(getClass().getResource("/tableView/UpdateDonneur.fxml"));
             Parent root = loader.load();
            // Get the controller from the loader
            UpdateDonneurController updateController = loader.getController();

            // Set the donneur data to the update controller
            updateController.initData(donneur);

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
        }}





        @FXML
        private void getAddView(javafx.scene.input.MouseEvent event) {

              try {
                Parent parent = FXMLLoader.load(getClass().getResource("/tableView/AddStudent.fxml"));
                Scene scene = new Scene(parent);
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.initStyle(StageStyle.UTILITY);
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(TableViewController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

          private void refreshView(javafx.scene.input.MouseEvent event) {
            // Call the refreshView method of the TableViewController
           refreshView();

        }

        @FXML
        private void print(javafx.scene.input.MouseEvent event) {
        }

    }
