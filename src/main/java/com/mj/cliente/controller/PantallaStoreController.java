/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mj.cliente.controller;

import com.mj.cliente.App;
import com.mj.cliente.dao.Juego;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

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
    @FXML
    private GridPane gridPane;
    
    //ObservableList<Juego> listaJuegos  =(ObservableList<Juego>)PantallaLoginController.lista;
    
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //GridPane gridPaneMain = new GridPane();
        Image image = new Image("com/mj/cliente/images/profile-user.png", 90, 90, false, false);
        int columns = 0;
        int row = 1;
        for (int x = 0; x <= 6; x++) {
//            Button button = new Button();
//            gridPane.add(button, x, 0, 1, 1);
//            ImageView imv = new ImageView();
//            imv.setImage(image);
//            final HBox pictureRegion = new HBox();
//            pictureRegion.getChildren().add(imv);
//            gridPane.add(pictureRegion, x, 1);

//            FXMLLoader fxmlLoader = new FXMLLoader();
//            fxmlLoader.setLocation(getClass().getResource(image));
            
//            
            if (columns == 2) {
                columns = 0;
                row++;
            }
            gridPane.add(new ImageView(image),columns++,row);

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
    
    @FXML
    private void descargar(ActionEvent event) throws IOException {
//        List<Juego> juego =PantallaLoginController.lista;
//        String titulo = "";
//        Juego adescargar =null;
//        for(Juego j: juego){
//            if(titulo.equals(j.getTitulo())){
//                adescargar =j;
//            }
//        }
        
    }

}
