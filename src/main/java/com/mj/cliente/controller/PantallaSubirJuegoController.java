/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mj.cliente.controller;

import com.mj.cliente.App;
import static com.mj.cliente.controller.PantallaCrearUsuarioController.imagenURL;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author M3j2
 */
public class PantallaSubirJuegoController implements Initializable {

    @FXML
    private TextField txt_Desarrollador;
    @FXML
    private TextField txt_NombreJuego;
    @FXML
    private TextField txt_precio;
    @FXML
    private Button btn_SubirJUego;
    @FXML
    private ImageView img_Logo;
    @FXML
    private ComboBox comboGenero;
    @FXML
    private DatePicker fechaJuego;
    @FXML
    private ComboBox comboDificultad;
    @FXML
    private ComboBox comboClasificacion;
    @FXML
    private Button btn_cambiarImg;

    public static String imagenURL;
    public static String juegoURL;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //rol.getItems().addAll("Desarrollador", "Jugador", "Invitado");
        comboGenero.getItems().addAll("Accion", "Arcade", "Aventura", "Clicker", "Plataformas");
        comboDificultad.getItems().addAll("Alta", "Media", "Baja");
        comboClasificacion.getItems().addAll("PEGI 3", "PEGI 7", "PEGI 12", "PEGI 16", "PEGI 18");

    }

    @FXML
    private void subirJuego(ActionEvent event) throws IOException {
        App.setRoot("PantallaStore");
    }

    private void escogerPortada(ActionEvent event) throws FileNotFoundException {

        FileChooser avatar = new FileChooser();
        File file = avatar.showOpenDialog(new Stage());
        if (file.getName().endsWith(".png") || file.getName().endsWith(".jpg")) {
            avatar.setTitle("¡Escoge tu avatar!");
            Image image = new Image(new FileInputStream(file));
            img_Logo.setImage(image);
            imagenURL = file.getAbsolutePath();
            System.out.println(imagenURL);
        } else {
            JOptionPane.showMessageDialog(null, "Los formatos validos son: JPG y PNG", "No es un archivo valido", 2);
        }
    }

    private void escogerZip(ActionEvent event) throws FileNotFoundException {

        FileChooser archivoZip = new FileChooser();
        File file = archivoZip.showOpenDialog(new Stage());
        if (file.getName().endsWith(".zip")) {
            archivoZip.setTitle("¡Escoge tu Juego!");
            juegoURL = file.getAbsolutePath();
            System.out.println(juegoURL);
        } else {
            JOptionPane.showMessageDialog(null, "El formato válido es: ZIP", "No es un archivo valido", 2);
        }

    }

}
