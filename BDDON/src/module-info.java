/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/module-info.java to edit this template
 */

module BDDON {
    requires mysql.connector.j;
    requires fontawesomefx;
    requires java.mail;
    requires java.logging;
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires java.sql;
     requires java.desktop;
    requires java.base;
    requires javafx.base;

    opens bddon to javafx.fxml;
    exports bddon;

    opens Main;
    exports Main;

    opens tableView;
    exports tableView;

    opens operationTable;
    exports operationTable;

    opens models;  // Add this line to open the models package
     exports models; 
    opens Controllers;
    exports Controllers;
}


