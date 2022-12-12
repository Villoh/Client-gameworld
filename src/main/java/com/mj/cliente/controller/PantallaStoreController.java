/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mj.cliente.controller;

import com.mj.cliente.App;
import static com.mj.cliente.App.stg;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;


/**
 * FXML Controller class
 *
 * @author M3J2
 */
public class PantallaStoreController implements Initializable {

    @FXML
    private Button biblioteca;
    @FXML
    private Button tienda;
    @FXML
    private Button perfil;
    @FXML
    private Button logout;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void abrirBiblioteca(ActionEvent event) {
    }

    @FXML
    private void abrirTienda(ActionEvent event) {
        
    }

    @FXML
    private void abrirPerfil(ActionEvent event) {
        //Abre el perfil
        
    }

    @FXML
    private void cerrarSesion(ActionEvent event) throws IOException {
        App m = new App();
        PantallaLoginController p = new PantallaLoginController();
        p.closeScene();
        m.changeScene("view/PantallaLogin.fxml");
        m.openScene();
        
    }
     public void changeScene(String fxml) throws IOException {
        Parent pane = FXMLLoader.load(getClass().getResource(fxml));
        stg.getScene().setRoot(pane);
    }
    
}
