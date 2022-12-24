/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mj.cliente.controller;

import com.mj.cliente.App;

import com.mj.cliente.crud.JuegoCRUD;
import com.mj.cliente.crud.UsuarioCRUD;
import com.mj.cliente.dao.Juego;
import com.mj.cliente.dao.Usuario;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author M3J2
 */
public class PantallaLoginController implements Initializable {

    public static Stage stage = new Stage();
    @FXML
    private TextField loginID;
    @FXML
    private PasswordField passwordID;
    @FXML
    private Button crearCuenta;
    @FXML
    private Button recuperarPass;
    @FXML
    private Button login;
    public static List<Juego> lista;
    public static Usuario correcto = null;
    @FXML
    private AnchorPane parent;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        makeStageDragable();

    }

    /**
     * Metodo para comprobar el Login del usuario en la base de datos Si los
     * datos coinciden con lo establecido en la base de datos nos abre la
     * ventana Store
     *
     * @param event
     * @throws IOException
     */
    @FXML
    private void userLogin(ActionEvent event) throws IOException {
//      Buscamos el usuario con ese login y pass
        correcto = UsuarioCRUD.verUsuario(loginID.getText(), passwordID.getText());
        if (correcto != null) {
            System.out.println("Perfecto");
            lista = JuegoCRUD.verListaJuegos();
            PantallaPerfilController.loginOcreado = 1;

            App.setRoot("PantallaStore");
        } else {
            loginID.clear();
            passwordID.clear();
            JOptionPane.showMessageDialog(null, "Los datos no son correctos", "Error!", 2);
        }

    }

    @FXML
    private void crearCuenta(ActionEvent event) throws IOException {
        App.setRoot("PantallaCrearUsuario");

    }

    @FXML
    private void recuperarPass(ActionEvent event) throws IOException {
        App.setRoot("PantallaCambiarContraseña");
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

    @FXML
    private void Close_app(ActionEvent event) {

        System.exit(0);

    }

    @FXML
    private void Draged(MouseEvent event) {
    }

    @FXML
    private void Presed(MouseEvent event) {
    }

    @FXML
    private void Intro(KeyEvent event) {
    }

    @FXML
    private void minStage(ActionEvent event) {
        App.st.setIconified(true);
    }

}
