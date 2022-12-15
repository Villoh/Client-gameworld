/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mj.cliente.controller;

import com.mj.cliente.App;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.Observable;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;

/**
 * FXML Controller class
 *
 * @author M3J2
 */
public class PantallaBibliotecaController implements Initializable {

    @FXML
    private Button btn_Tienda;
    @FXML
    private ImageView btn_Store;
    @FXML
    private Button btn_Biblioteca;
    @FXML
    private ImageView btn_Library;
    @FXML
    private Button btn_perfil;
    @FXML
    private ImageView btn_UserProfile;
    @FXML
    private Button btn_Exit;
    @FXML
    private ListView<String> listaUsuario;

    //Almacenamos el titulo de los juegos existentes en la biblioteca del usuario
    ObservableList<String> listaJuegos = FXCollections.observableArrayList("juego1", "juego2", "juego3", "juego4", "juego2", "juego3", "juego4", "juego2", "juego3");

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        listaUsuario.setItems(listaJuegos);
        GridPane pane = new GridPane();
        Label name = new Label("h");
        Button btn = new Button("Boton");
        pane.add(name, 0, 0);
        pane.add(btn, 0, 1);

        listaUsuario.setCellFactory(param -> new Cell());
        listaUsuario.getSelectionModel().getSelectedItem();
        //Otra forma de obtener el item seleccionado
//        listaUsuario.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
//            @Override
//            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
//                System.out.println("ListView selection changed from oldValue = "
//                        + oldValue + " to newValue = " + newValue);
//            }
//        });
        listaUsuario.getSelectionModel().selectedItemProperty().addListener(this::seleccion);

    }

    /**
     * Metodo para conocer cual celda ha sido seleccionada
     *
     * @param Observable
     * @param oldValue
     * @param newValue
     */
    public void seleccion(ObservableValue<? extends String> Observable, String oldValue, String newValue) {
        ObservableList<String> selectedItens = listaUsuario.getSelectionModel().getSelectedItems();
        String item = selectedItens.toString();
        System.out.println("BTN Seleccionado_ " + item);

    }

    /**
     * Metodo para dibujar las celdas con los datos dentro de la listaUsuario
     */
    static class Cell extends ListCell<String> {

        HBox hbox = new HBox();
        Button btn = new Button("Boton");
        Label label = new Label("Etiquetaaaa");
        Pane pane = new Pane();
        //Ruta de la imagen del juego > reemplazar por la imagen correspondiente 
        Image imgJuego = new Image("com/mj/cliente/images/profile-user.png", 90, 90, false, false);
        //Image nueva= imgJuego
        ImageView img = new ImageView(imgJuego);

        public Cell() {
            super();
            hbox.getChildren().addAll(img, label, pane, btn);
            hbox.setHgrow(pane, Priority.ALWAYS);
            //Comportamiento del boton
            //Borra la celda en la que se encuentra el boton
            //btn.setOnAction(e -> getListView().getItems().remove(getItem()));
        }

        public void updateItem(String name, boolean empty) {
            super.updateItem(name, empty);
            setText(null);
            setGraphic(null);

            if (name != null && !empty) {
                label.setText(name);
                setGraphic(hbox);
            }
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
