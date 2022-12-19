/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mj.cliente.controller;

import com.mj.cliente.App;
import com.mj.cliente.dao.Juego;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author dam107
 */
public class PantallaJuegoController extends VBox implements Initializable {

    @FXML
    public ImageView imagen;
    @FXML
    public VBox contenedor;
    @FXML
    private Label titulo;
    
    public  Juego  juegoEspecifico;
    public ImageView getImagen() {
        return imagen;
    }

    public void setImagen(ImageView imagen) {
        this.imagen = imagen;
    }

    public VBox getContenedor() {
        return contenedor;
    }

    public void setContenedor(VBox contenedor) {
        this.contenedor = contenedor;
    }

    
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void setData(Juego juego){
        //Image image = new Image(getClass().getResourceAsStream(juego.getImagen()));
        Image image = new Image("D:\\Users\\DAM107\\Desktop\\Git\\cliente\\src\\main\\resources\\com\\mj\\cliente\\images\\persona.png");
        imagen.setImage(image);
        titulo.setText(juego.getTitulo());
        juegoEspecifico = juego;
    }

    @FXML
    private void abrirVentanaJuego(MouseEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("view/PantallaJuegoEspecifico.fxml"));
        PantallaJuegoEspecificoController controlador = fxmlLoader.getController();
        controlador.setData(juegoEspecifico);
        App.setRoot("PantallaJuegoEspecifico");
    }
    
    
    
}
