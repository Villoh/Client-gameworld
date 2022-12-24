/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mj.cliente.controller;

import com.mj.cliente.App;
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
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author M3J2
 */
public class PantallaPerfilController implements Initializable {

    @FXML
    private Button btn_Tienda;
    @FXML
    private Button btn_perfil;
    @FXML
    private Button btn_Exit;
    private ImageView imagenPerfil;
    @FXML
    private Label nombre_apellidos;
    @FXML
    private Label fechanace;
    @FXML
    private Label email;

    public static int loginOcreado = 0;
    @FXML
    private AnchorPane root;
    @FXML
    private AnchorPane parent;
    @FXML
    private ImageView avatar;

    /**
     * Initializes the controller class.
     *
     * @param url
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        makeStageDragable();
        if (loginOcreado == 1) {
            setData(PantallaLoginController.correcto);
        }
        if (loginOcreado == 2) {
            setData(PantallaCrearUsuarioController.correcto);
        }

    }

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

    /**
     * Establecemos los datos del usuario para ser mostrados en la ventana de
     * Perfil
     *
     * @param user
     */
    public void setData(Usuario user) {
        //Image image = new Image(user.getAvatar());
        //Image image = new Image("C:\\Users\\Usuario\\Downloads\\cliente\\src\\main\\resources\\com\\mj\\cliente\\images\\persona.png");
//        imagen.setFitWidth(100);
        //avatar.setImage(image);

        this.nombre_apellidos.setText(user.getNombre() + " " + user.getApellidos());
        this.fechanace.setText(user.getFechanace().toString());
        this.email.setText(user.getEmail());

    }

    /**
     * Metodo para cambiar el avatar del usuario
     *
     * @param event
     * @throws FileNotFoundException
     */
    private void editarFoto(ActionEvent event) throws FileNotFoundException {

        FileChooser avatar = new FileChooser();
        File file = avatar.showOpenDialog(new Stage());
        if (file.getName().endsWith(".png") || file.getName().endsWith(".jpg")) {
            avatar.setTitle("¡Escoge tu avatar!");
            Image image = new Image(new FileInputStream(file));
            imagenPerfil.setImage(image);
        } else {
            //JOptionPane.showMessageDialog(null, "Los formatos validos son: JPG y PNG", "No es un archivo valido", 2);
        }
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
    private void abrirSubirJuego(ActionEvent event) {
    }

    @FXML
    private void minStage(ActionEvent event) {
        App.st.setIconified(true);
    }

}
