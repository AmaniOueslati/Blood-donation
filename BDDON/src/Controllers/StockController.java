/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template


*/
package Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert.AlertType;
import models.stock;

public class StockController implements Initializable {

    @FXML
    private TableView<stock> tab;

    @FXML
    private TableColumn<stock, Integer> Quantité;

    @FXML
    private TableColumn<stock, String> Type;

    @FXML
    private TextField t3;

    @FXML
    private Button butajou;

    @FXML
    private Button butsupp;

    private ObservableList<stock> list;
    private Map<String, stock> stockMap;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        list = FXCollections.observableArrayList(
                new stock("A", 33),
                new stock("B", 33),
                new stock("AB", 33),
                new stock("O", 33)
        );

        stockMap = new HashMap<>();
        for (stock s : list) {
            stockMap.put(s.getTypeSang(), s);
        }

        Quantité.setCellValueFactory(cellData -> cellData.getValue().getQuantiteProperty().asObject());
        Type.setCellValueFactory(cellData -> cellData.getValue().getTypeSangProperty());

        tab.setItems(list);
    }

    @FXML
    private void handleAddAction(ActionEvent event) {
        handleQuantityChange(1); // Add the value from the TextField to the quantity
    }

    @FXML
    private void handleRemoveAction(ActionEvent event) {
        handleQuantityChange(-1); // Subtract 1 from the quantity
    }

    private void handleQuantityChange(int sign) {
        try {
            int selectedIndex = tab.getSelectionModel().getSelectedIndex();

            if (selectedIndex >= 0) {
                stock selectedStock = list.get(selectedIndex);
                int quantityChange = Integer.parseInt(t3.getText()) * sign;

                // Check if the resulting quantity would be negative
                if (selectedStock.getQuantite() + quantityChange >= 0) {
                    selectedStock.setQuantite(selectedStock.getQuantite() + quantityChange);
                    tab.refresh(); // Refresh the TableView to reflect the changes

                    // Check if a limit is reached and display an alert
                    int limit = 20; // Set your desired limit here
                    if (selectedStock.getQuantite() <= limit) {
                        showAlert("Quantity limit reached! Maximum allowed: " + limit);
                    }
                } else {
                    // Display an alert for negative quantity
                    showAlert("Quantity cannot be negative!");
                }
            }
        } catch (NumberFormatException e) {
            // Display an alert for invalid numeric value
            showAlert("Please select an item from the TableView and enter a valid numeric value in the TextField.");
        }
    }

    private void showAlert(String message) {
        Alert alert = new Alert(AlertType.WARNING);
        alert.setTitle("Warning");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}

/*
package Controllers;

import models.stock;
import javafx.event.ActionEvent;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class StockController implements Initializable {

    @FXML
    private TableView<stock> tab;

    @FXML
    private TableColumn<stock, Integer> Quantité;

    @FXML
    private TableColumn<stock, String> Type;

    @FXML
    private TextField t3;

    @FXML
    private Button butajou;

    @FXML
    private Button butsupp;

    ObservableList<stock> list = FXCollections.observableArrayList(
            new stock("A", 33),
            new stock("B", 33),
            new stock("AB", 33),
            new stock("O", 33)
    );

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Quantité.setCellValueFactory(cellData -> cellData.getValue().getQuantiteProperty().asObject());
        Type.setCellValueFactory(cellData -> cellData.getValue().getTypeSangProperty());

        tab.setItems(list);
    }

@FXML
private void handleAddAction(ActionEvent event) {
    handleQuantityChange(1); // Add the value from the TextField to the quantity
}

@FXML
    private void handleRemoveAction(ActionEvent event) {
        handleQuantityChange(-1); // Subtract 1 from the quantity
    }

private void handleQuantityChange(int sign) {
    try {
        int selectedIndex = tab.getSelectionModel().getSelectedIndex();

        if (selectedIndex >= 0) {
            stock selectedStock = list.get(selectedIndex);
            int quantityChange = Integer.parseInt(t3.getText()) * sign;

            // Check if the resulting quantity would be negative
            if (selectedStock.getQuantite() + quantityChange >= 0) {
                selectedStock.setQuantite(selectedStock.getQuantite() + quantityChange);
                tab.refresh(); // Refresh the TableView to reflect the changes

                // Check if a limit is reached and display an alert
                int limit = 20; // Set your desired limit here
                if (selectedStock.getQuantite() <= limit) {
                    showAlert("Quantity limit reached! Maximum allowed: " + limit);
                }
            } else {
                // Display an alert for negative quantity
                showAlert("Quantity cannot be negative!");
            }
        }
    } catch (NumberFormatException e) {
        // Display an alert for invalid numeric value
        showAlert("Please select an item from the TableView and enter a valid numeric value in the TextField.");
    }
}


private void showAlert(String message) {
    Alert alert = new Alert(AlertType.WARNING);
    alert.setTitle("Warning");
    alert.setHeaderText(null);
    alert.setContentText(message);
    alert.showAndWait();
}

}
*/