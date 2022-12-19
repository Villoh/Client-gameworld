/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mj.cliente.controller;

import com.mj.cliente.dao.Juego;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

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
        
        
    }
    
}
