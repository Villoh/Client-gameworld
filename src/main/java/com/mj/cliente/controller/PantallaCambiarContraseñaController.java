/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mj.cliente.controller;

import com.mj.cliente.App;
import com.mj.cliente.OtrasOperacionesBD.OperacionesEspecificas;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

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
    @FXML
    private AnchorPane parent;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        makeStageDragable();
    }

    /**
     * Método para cambiar la contraseña del usuario
     *
     * @param event
     * @throws IOException
     */
    @FXML
    private void cambiarContraseña(ActionEvent event) throws IOException {
        //Comprobamos el alias y el email y cambiamos la contraseña
        if (pass.getText().equals(repepass.getText())) {
            Boolean correcto = OperacionesEspecificas.cambiarContraseña(alias.getText(), email.getText(), pass.getText());
            if (correcto) {
                App.setRoot("PantallaLogin");
            } else {
                System.out.println("No existe ese alias con ese email");
            }
        } else {
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

    private double xOffSet = 0;
    private double yOffSet = 0;

    /**
     * Hace la interfaz arrastable
     */
    private void makeStageDragable() {

        parent.setOnMousePressed((event) -> {

            xOffSet = event.getSceneX();
            yOffSet = event.getSceneY();

        });

        parent.setOnMouseDragged((event) -> {

            App.st.setX(event.getScreenX() - xOffSet);
            App.st.setY(event.getScreenY() - yOffSet);
            App.st.setOpacity(0.8f);

        });

        parent.setOnDragDone((event) -> {

            App.st.setOpacity(1.0f);

        });

        parent.setOnMouseReleased((event) -> {

            App.st.setOpacity(1.0f);

        });

    }

    private void min_stage(ActionEvent event) {

        App.st.setIconified(true);

    }

    @FXML
    private void Close_app(ActionEvent event) {

        System.exit(0);

    }

    @FXML
    private void minStage(ActionEvent event) {
        App.st.setIconified(true);
    }

}
