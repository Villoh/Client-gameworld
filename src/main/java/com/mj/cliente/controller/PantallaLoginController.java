/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mj.cliente.controller;

import com.mj.cliente.App;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author M3J2
 */
public class PantallaLoginController implements Initializable {

    public static Stage stage = new Stage();
    @FXML
    private TextField loginID;
    @FXML
    private PasswordField passwordID;
    @FXML
    private Button crearCuenta;
    @FXML
    private Button recuperarPass;
    @FXML
    private Button login;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    private void userLogin(ActionEvent event) throws IOException {
        App.setRoot("PantallaStore");
    }

    @FXML
    private void crearCuenta(ActionEvent event) throws IOException {
        App.setRoot("PantallaCrearUsuario");

    }

    @FXML
    private void recuperarPass(ActionEvent event) throws IOException {
        App.setRoot("PantallaCambiarContraseña");
    }

}
