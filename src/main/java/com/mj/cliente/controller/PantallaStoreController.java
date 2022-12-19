/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mj.cliente.controller;

import com.mj.cliente.App;
import com.mj.cliente.crud.JuegoCRUD;
import com.mj.cliente.dao.Juego;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author M3J2
 */
public class PantallaStoreController implements Initializable {

    @FXML
    private Button btn_Exit;
    @FXML
    private Button btn_Tienda;
    @FXML
    private Button btn_Biblioteca;
    @FXML
    private Button btn_perfil;
    private GridPane juegosGrid;
    @FXML
    private GridPane gridBiblioteca;
    @FXML
    private GridPane gridStore;

    //ObservableList<Juego> listaJuegos  =(ObservableList<Juego>)PantallaLoginController.lista;
    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        int columns = 0;
        int columns2=0;
        int row = 1;
        List<Juego> listaJuegos = JuegoCRUD.verListaJuegos();
        try {
            for (int x = 0; x < listaJuegos.size(); x++) {
                Button button = new Button();
                FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("view/PantallaJuego.fxml"));
                VBox box = fxmlLoader.load();
                PantallaJuegoController controlador = fxmlLoader.getController();
                controlador.setData(listaJuegos.get(x));
                gridBiblioteca.add(box, columns++, 1);
                GridPane.setMargin(box, new Insets(10));
                controlador.juegoEspecifico= listaJuegos.get(x);

            }
        } catch (IOException ex) {

        }
        /*
        try {
            for (int x = 0; x <= 20; x++) {
                Button button = new Button();

                FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("view/PantallaJuego.fxml"));
                VBox box = fxmlLoader.load();

                
                gridStore.add(box, columns2++, 1);
                GridPane.setMargin(box, new Insets(10));

            }
        } catch (IOException ex) {

        }
*/
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
