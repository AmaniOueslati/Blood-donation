package tableView;

import helpers.Dbconnect;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import models.Donneur;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateDonneurController {

    @FXML
    private TextField nomField;
    @FXML
    private TextField prenomField;
    @FXML
    private TextField groupeSanguinField;
    @FXML
    private TextField emailField;

    private Donneur donneur;
    private TableViewController tableViewController;

    public void setDonneur(Donneur donneur) {
        this.donneur = donneur;
        fillFields();
    }

    public void setTableViewController(TableViewController tableViewController) {
        this.tableViewController = tableViewController;
    }

    private void fillFields() {
        nomField.setText(donneur.getNom());
        prenomField.setText(donneur.getPrenom());
        groupeSanguinField.setText(donneur.getGroupeSanguin());
        emailField.setText(donneur.getEmail());
    }

    @FXML
    private void updateDonneur() {
        try {
            // Establish a connection
            Connection connection = Dbconnect.connection();

            // Prepare the SQL statement
            String query = "UPDATE donneurs SET nom = ?, prenom = ?, groupeSanguin = ?, email = ? WHERE id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                // Set the parameters (new values for the donneur)
                preparedStatement.setString(1, nomField.getText());
                preparedStatement.setString(2, prenomField.getText());
                preparedStatement.setString(3, groupeSanguinField.getText());
                preparedStatement.setString(4, emailField.getText());
                preparedStatement.setInt(5, donneur.getId());

                // Execute the update operation
                preparedStatement.executeUpdate();
            }

            // Close the connection
            connection.close();

            // Notify the table view to refresh
            if (tableViewController != null) {
                tableViewController.refreshView();
            }

            // Optional: Provide feedback to the user (e.g., show a success message)
            System.out.println("Donneur updated successfully.");

            // Close the update window
            closeUpdateWindow();

        } catch (SQLException ex) {
            // Handle any SQL errors
            ex.printStackTrace();
        }
    }

    // Add a method to close the update window
    private void closeUpdateWindow() {
        // Get the current stage (window) and close it
        nomField.getScene().getWindow().hide();
    }
    
    // Add the initData method to set initial data
    public void initData(Donneur donneur) {
        this.donneur = donneur;
        fillFields();
    }
}
