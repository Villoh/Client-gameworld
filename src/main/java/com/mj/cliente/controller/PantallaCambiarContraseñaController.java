/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mj.cliente.controller;

import com.mj.cliente.App;
import com.mj.cliente.OtrasOperacionesBD.OperacionesEspecificas;
import com.mj.cliente.dao.Usuario;
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
    private Button login;
    @FXML
    private Button crearCuenta;
    @FXML
    private TextField pass;
    @FXML
    private TextField email;
    @FXML
    private TextField alias;
    @FXML
    private TextField repepass;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void cambiarContraseña(ActionEvent event) throws IOException {
        //Comprobamos el alias y el email y cambiamos la contraseña
        if(pass.getText().equals(repepass.getText())){
            Boolean correcto =OperacionesEspecificas.cambiarContraseña(alias.getText(), email.getText(),pass.getText());
            if(correcto){
                App.setRoot("PantallaLogin");
            }else{
                System.out.println("No existe ese alias con ese email");
            }
        }else{
            System.out.println("Las contraseñas no coinciden");
        }
        
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
