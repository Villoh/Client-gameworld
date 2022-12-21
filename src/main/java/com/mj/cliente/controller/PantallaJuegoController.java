/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mj.cliente.controller;

import com.mj.cliente.App;
import com.mj.cliente.crud.JuegoCRUD;
import com.mj.cliente.dao.Juego;
import com.mj.cliente.service.SocketTransfer;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
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
    private Label titulo;

    public static Juego juegoEspecifico;

    Juego juegoGuardado;

    public ImageView getImagen() {
        return imagen;
    }

    public void setImagen(ImageView imagen) {
        this.imagen = imagen;
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    public void setData(Juego juego) {
        String rutaImagen = "C:\\GameWorld\\Img\\ImgJuegos\\";
        String nombreImagen = juego.getImagen();
        File imagenExiste = new File(rutaImagen.concat(nombreImagen));
        if (!imagenExiste.exists()) {
            ExecutorService executor = Executors.newSingleThreadExecutor();
            SocketTransfer imageServidor = new SocketTransfer(3, "", juego.getImagen());
            executor.submit(imageServidor);
            executor.shutdown();
        }

        //Image image = new Image(getClass().getResourceAsStream(juego.getImagen()));
        Image image = new Image(rutaImagen.concat(nombreImagen));
        imagen.setFitWidth(100);
        imagen.setFitHeight(100);
        imagen.setImage(image);
        titulo.setText(juego.getTitulo());
    }

    @FXML
    private void abrirVentanaJuego(MouseEvent event) throws IOException {
        Juego j = JuegoCRUD.verJuego(titulo.getText());
        PantallaJuegoEspecificoController.juego = j;
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("view/PantallaJuegoEspecifico.fxml"));
        AnchorPane box = fxmlLoader.load();
        App.setRoot("PantallaJuegoEspecifico");
    }

}
