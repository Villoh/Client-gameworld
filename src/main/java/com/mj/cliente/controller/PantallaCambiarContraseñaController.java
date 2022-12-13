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
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author M3J2
 */
public class PantallaCambiarContraseñaController implements Initializable {

    @FXML
    private TextField loginID3;
    @FXML
    private TextField loginID;
    @FXML
    private TextField loginID1;
    @FXML
    private TextField loginID4;
    @FXML
    private Button login;
    @FXML
    private Button crearCuenta;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void cambiarContraseña(ActionEvent event) {
        //Comprobamos el alias y el email y cambiamos la contraseña

    }

    @FXML
    private void volverCrearCuenta(ActionEvent event) throws IOException {
        App.setRoot("PantallaCrearUsuario");
    }

    @FXML
    private void volverInicio(ActionEvent event) throws IOException {
        App.setRoot("PantallaLogin");
    }

}
