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
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

/**
 * FXML Controller class
 *
 * @author dam107
 */
public class PantallaJuegoEspecificoController implements Initializable {

    @FXML
    private ImageView imagen;
    @FXML
    private Label titulo;
    @FXML
    private Button volver;
    @FXML
    private Label genero;
    @FXML
    private Label nivel;
    @FXML
    private Label pegi;
    @FXML
    private Label descripcion;
    @FXML
    private Label creador;
    @FXML
    private Label fechacreacion;
    @FXML
    private Label pvp;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            setData(PantallaJuegoController.juegoEspecifico);
        } catch (IOException ex) {
            Logger.getLogger(PantallaJuegoEspecificoController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setImagen(ImageView imagen) {
        this.imagen = imagen;
    }

    public void setTitulo(Label titulo) {
        this.titulo = titulo;
    }
    

    public void setData(Juego juego) throws IOException {
        System.out.println(juego.getTitulo());
        //Image image = new Image(getClass().getResourceAsStream(juego.getImagen()));
        //Image image = new Image("D:\\Users\\DAM107\\Desktop\\Git\\cliente\\src\\main\\resources\\com\\mj\\cliente\\images\\persona.png");
        //imagen.setImage(image);
        titulo.setText(juego.getTitulo());
        descripcion.setText(juego.getDescripcion());
        genero.setText(juego.getAkgenero().getNombre());
        nivel.setText(juego.getAknivel().getPknivel());
        pegi.setText(juego.getAkpegi().getRangopegi());
        creador.setText(juego.getAkcreador().getNombre()+" "+juego.getAkcreador().getApellidos());
        fechacreacion.setText(juego.getFechacreacion().toString());
        pvp.setText(juego.getPvp().toString());
        }

    @FXML
    private void abrirStore(ActionEvent event) throws IOException {
         App.setRoot("PantallaStore");
    }

}
