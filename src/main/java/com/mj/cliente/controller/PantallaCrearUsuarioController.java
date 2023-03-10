/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mj.cliente.controller;

import com.mj.cliente.App;
import com.mj.cliente.OtrasOperacionesBD.OperacionesEspecificas;
import com.mj.cliente.crud.UsuarioCRUD;
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
import java.util.regex.Pattern;
import javafx.scene.layout.AnchorPane;
import javax.swing.JOptionPane;

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
    private ComboBox rol;
    @FXML
    private Button VolverBoton;

    public static Usuario correcto = null;
    public static String imagenURL;
    @FXML
    private AnchorPane parent;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        makeStageDragable();
        rol.getItems().addAll("Desarrollador", "Jugador", "Invitado");
    }

    /**
     * Metodo para seleccionar el avatar del usuario
     *
     * @param event
     * @throws FileNotFoundException
     */
    @FXML
    private void escogerAvatar(ActionEvent event) throws FileNotFoundException {

        FileChooser avatar = new FileChooser();
        File file = avatar.showOpenDialog(new Stage());
        if (file.getName().endsWith(".png") || file.getName().endsWith(".jpg")) {
            avatar.setTitle("??Escoge tu avatar!");
            Image image = new Image(new FileInputStream(file));
            imagen.setImage(image);
            imagenURL = file.getAbsolutePath();
            System.out.println(imagenURL);
        } else {
            JOptionPane.showMessageDialog(null, "Los formatos validos son: JPG y PNG", "No es un archivo valido", 2);
        }

    }

    /**
     * Metodo para crear un nuevo Usuario en la base de datos
     *
     * @param event
     * @throws IOException
     */
    @FXML
    private void crearCuenta(ActionEvent event) throws IOException {
        Boolean aliasDisponible = OperacionesEspecificas.comprobarAlias(alias.getText());
        Boolean emailDisponible = OperacionesEspecificas.comprobarEmail(email.getText());

        if (alias.getText().isEmpty() || pass.getText().isEmpty() || confirmarpass.getText().isEmpty() || nombre.getText().isEmpty() || apellidos.getText().isEmpty() || fechanac.getValue() == null) {
            JOptionPane.showMessageDialog(null, "Te faltan datos!", "Error!", 2);
        } else {
            if (isValid(email.getText())) {
                if (aliasDisponible && emailDisponible) {
                    //Comprobamos que las contrase??as sean iguales
                    if (pass.getText().equals(confirmarpass.getText())) {
                        //Creamos un usuario nuevo
                        Usuario usuario = new Usuario();
                        usuario.setAlias(alias.getText());
                        usuario.setPassword(pass.getText());
                        usuario.setNombre(nombre.getText());
                        usuario.setApellidos(apellidos.getText());
                        usuario.setFechanace(java.sql.Date.valueOf(fechanac.getValue()));
                        usuario.setAvatar(imagenURL);
                        usuario.setEmail(email.getText());
                        Perfil perfil = new Perfil();
                        perfil.setRol(rol.getValue().toString());
                        String rol = perfil.getRol();
                        int pkperfil = 0;
                        if (rol.equalsIgnoreCase("Desarrollador")) {
                            pkperfil = 1;
                        }
                        if (rol.equalsIgnoreCase("Jugador")) {
                            pkperfil = 2;
                        }
                        if (rol.equalsIgnoreCase("Invitado")) {
                            pkperfil = 3;
                        }
                        perfil.setPkperfil(pkperfil);
                        //Insertamos el usuario
                        UsuarioCRUD.nuevoUsuario(usuario, perfil);
                        System.out.println("Usuario Creado correctamente");
                        correcto = usuario;//Guardamos el usuario para utilizarlo en otros sitios
                        PantallaPerfilController.loginOcreado = 2;

                        App.setRoot("PantallaLogin");
                    } else {
                        //Limpiamos sin son diferentes
                        pass.clear();
                        confirmarpass.clear();
                        JOptionPane.showMessageDialog(null, "Las contrase??as no coinciden", "Error!", 2);
                    }
                } else {
                    email.clear();
                    JOptionPane.showMessageDialog(null, "El email no es valido", "Error!", 2);
                }
            } else {
                alias.clear();
                JOptionPane.showMessageDialog(null, "El alias o el email no esta disponible", "Error!", 2);
            }
        }

    }

    @FXML
    private void Volver(ActionEvent event) throws IOException {
        App.setRoot("PantallaLogin");
    }

    /**
     * Metodo para comprobar la validadez de un email
     *
     * @param email a comprobar
     * @return devuelver verdadero o falso si pasa el regex
     */
    public static boolean isValid(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."
                + "[a-zA-Z0-9_+&*-]+)*@"
                + "(?:[a-zA-Z0-9-]+\\.)+[a-z"
                + "A-Z]{2,7}$";

        Pattern pat = Pattern.compile(emailRegex);
        if (email == null) {
            return false;
        }
        return pat.matcher(email).matches();
    }

    private double xOffSet = 0;
    private double yOffSet = 0;

    /**
     * Hace la interfaz arrastable
     */
    private void makeStageDragable() {

        parent.setOnMousePressed((event) -> {

            xOffSet = event.getSceneX();
            yOffSet = event.getSceneY();

        });

        parent.setOnMouseDragged((event) -> {

            App.st.setX(event.getScreenX() - xOffSet);
            App.st.setY(event.getScreenY() - yOffSet);
            App.st.setOpacity(0.8f);

        });

        parent.setOnDragDone((event) -> {

            App.st.setOpacity(1.0f);

        });

        parent.setOnMouseReleased((event) -> {

            App.st.setOpacity(1.0f);

        });

    }

    private void min_stage(ActionEvent event) {

        App.st.setIconified(true);

    }

    @FXML
    private void Close_app(ActionEvent event) {

        System.exit(0);

    }

    @FXML
    private void minStage(ActionEvent event) {
        App.st.setIconified(true);
    }
}
