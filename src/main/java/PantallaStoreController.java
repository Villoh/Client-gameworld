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
import javafx.fxml.FXMLLoader;

import javafx.fxml.Initializable;
import javafx.geometry.Insets;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author M3J2
 */
public class PantallaStoreController implements Initializable {

    @FXML
    private ImageView btn_Store;
    @FXML
    private ImageView btn_Library;
    @FXML
    private ImageView btn_UserProfile;
    @FXML
    private Button btn_Exit;
    @FXML
    private Button btn_Tienda;
    @FXML
    private Button btn_Biblioteca;
    @FXML
    private Button btn_perfil;
    private GridPane gridPane;
    @FXML
    private GridPane juegoGrid;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        //Image image = new Image("com/mj/cliente/images/profile-user.png", 90, 90, false, false);
        int columns = 0;
        int row = 1;
        try {
            for (int x = 0; x <= 20; x++) {
            Button button = new Button();

                FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("view/PantallaJuego.fxml"));
//               
                VBox box = fxmlLoader.load();
               

                if (columns == 2) {
                    columns = 0;
                    row++;
                }
//                gridPane.add(new ImageView(image), columns++, row);
                juegoGrid.add(box, columns++, row);
                GridPane.setMargin(box, new Insets(10));
            }
        } catch (IOException ex) {

        }

    }

    @FXML
    private void abrirBiblioteca(ActionEvent event) throws IOException {
        App.setRoot("PantallaBiblioteca");

    }

    @FXML
    private void abrirTienda(ActionEvent event) throws IOException {
        App.setRoot("PantallaStore");

    }

    @FXML
    private void abrirPerfil(ActionEvent event) throws IOException {
        App.setRoot("PantallaPerfil");

    }

    @FXML
    private void cerrarSesion(ActionEvent event) throws IOException {
        App.setRoot("PantallaLogin");
    }

}
