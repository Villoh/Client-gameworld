/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mj.cliente.controller;

import com.mj.cliente.App;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;

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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    private void userLogin(ActionEvent event) throws IOException {
        //Aqui comprobamos la info y hacemos lo necesario
        
        App m = new App();
        m.closeScene();
        Parent root = FXMLLoader.load(getClass().getResource("PantallaStore.fxml"));
        Scene scene = new Scene(root);
        stage.setResizable(false);
        stage.setTitle("M3J2");
        stage.getIcons().add(new Image("com/mj/cliente/images/LogoApp.png"));
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    private void crearCuenta(ActionEvent event) throws IOException {
        
        App m = new App();
        m.changeScene("view/PantallaCrearUsuario.fxml");

    }

    @FXML
    private void recuperarPass(ActionEvent event) throws IOException {

        App m = new App();
        m.changeScene("view/PantallaCambiarContraseña.fxml");
    }

    public void closeScene() {
        stage.close();
    }

}
