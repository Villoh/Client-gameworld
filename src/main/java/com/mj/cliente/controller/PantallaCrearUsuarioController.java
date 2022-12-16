/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mj.cliente.controller;

import com.mj.cliente.App;
import com.mj.cliente.crud.PerfilCRUD2;
import com.mj.cliente.crud.UsuarioCRUD2;
import com.mj.cliente.OtrasOperacionesBD.OperacionesEspecificas;
import com.mj.cliente.crud.UsuarioCRUD;
import com.mj.cliente.dao.Biblioteca;
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
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.output.ByteArrayOutputStream;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

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
        rol.getItems().addAll("Desarrollador", "Jugador", "Invitado");
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
    private void crearCuenta(ActionEvent event) throws IOException {
   
            //Comprobamos que las contraseñas sean iguales
            if (pass.getText().equals(confirmarpass.getText())) {
                //Creamos un usuario nuevo
                Usuario usuario = new Usuario();
                usuario.setAlias(alias.getText());
                usuario.setPassword(pass.getText());
                usuario.setNombre(nombre.getText());
                usuario.setApellidos(apellidos.getText());
                usuario.setFechanace(java.sql.Date.valueOf(fechanac.getValue()));
                usuario.setAvatar(null);
                usuario.setEmail(email.getText());
                Perfil perfil = new Perfil();
                perfil.setRol(rol.getValue().toString());
                String rol = perfil.getRol();
                int pkperfil =0;
                if(rol.equalsIgnoreCase("Desarrollador")){
                    pkperfil =1;
                }
                if(rol.equalsIgnoreCase("Jugador")){
                    pkperfil =2;
                } 
                if(rol.equalsIgnoreCase("Invitado")){
                    pkperfil =3;
                }
                perfil.setPkperfil(pkperfil);
                

                //Insertamos el usuario
                UsuarioCRUD.nuevoUsuario(usuario,perfil);
                System.out.println("Usuario Creado correctamente");
                
                App.setRoot("PantallaLogin");
            } else {
                //Limpiamos sin son diferentes
                pass.clear();
                confirmarpass.clear();
                System.out.println("No coincide la contraseña");
            }
        
    }
    @FXML
    private void volverLogin(ActionEvent event) throws IOException {
        App.setRoot("PantallaLogin");
    }
}

   
