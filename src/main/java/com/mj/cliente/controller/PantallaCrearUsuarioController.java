/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mj.cliente.controller;

import com.mj.cliente.App;
import com.mj.cliente.crud.PerfilCRUD2;
import com.mj.cliente.crud.UsuarioCRUD2;
import com.mj.cliente.dao.Perfil;
import com.mj.cliente.dao.Usuario;
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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
//import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author M3J2
 */
public class PantallaCrearUsuarioController implements Initializable {

    @FXML
    private PasswordField pass;
    @FXML
    private PasswordField confirmarpass;
    @FXML
    private TextField nombre;
    @FXML
    private TextField apellidos;
    @FXML
    private TextField email;
    @FXML
    private TextField alias;
    @FXML
    private DatePicker fechanac;
    @FXML
    private Button botonCrearCuenta;
    @FXML
    private ImageView imagen;
    @FXML
    private Button botonAvatar;
    @FXML
    private Button crearCuenta;
    @FXML
    private ComboBox rol;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        rol.getItems().addAll("Jugador", "Creador", "Admin");
    }

    /**
     * Metodo que te pide una imagen y la pinta en pantall
     *
     * @param event
     * @throws FileNotFoundException
     */
    @FXML
    private void escogerAvatar(ActionEvent event) throws FileNotFoundException {

        FileChooser avatar = new FileChooser();
        File file = avatar.showOpenDialog(new Stage());
        if (file.getName().endsWith(".png") || file.getName().endsWith(".jpg")) {
            avatar.setTitle("¡Escoge tu avatar!");
            Image image = new Image(new FileInputStream(file));
            imagen.setImage(image);
        } else {
            //JOptionPane.showMessageDialog(null, "Los formatos validos son: JPG y PNG", "No es un archivo valido", 2);
        }

    }

    @FXML
    private void crearCuenta(ActionEvent event) {
        //Hacemos las comprobaciones necesarias para crear la cuenta

        //Si todo es correcto guardamos la info en la base de datos y volvemos al Login donde inciara sesion
        Perfil perfil = new Perfil();
        perfil = PerfilCRUD2.readPerfil(1);

        Usuario usuario = new Usuario();
        UsuarioCRUD2 uCrud=new UsuarioCRUD2();
        usuario.setNombre(nombre.getText());
        usuario.setApellidos(apellidos.getText());
        usuario.setAlias(alias.getText());
        usuario.setPassword(pass.getText());
        usuario.setFechanace(java.sql.Date.valueOf(fechanac.getValue()));
        usuario.setEmail(email.getText());
        usuario.setAkperfil(perfil);
        usuario.setAvatar("");
        uCrud.createUsuario(usuario);
        
    }

    @FXML
    private void volverLogin(ActionEvent event) throws IOException {
        App.setRoot("PantallaLogin");
    }
}
