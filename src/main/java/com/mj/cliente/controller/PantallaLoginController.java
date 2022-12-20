/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mj.cliente.controller;

import com.mj.cliente.App;

import com.mj.cliente.conexion.Conexion;
import com.mj.cliente.crud.Consulta;
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
import javafx.stage.Stage;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
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
    public static Usuario correcto;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    private void userLogin(ActionEvent event) throws IOException {
//      Buscamos el usuario con ese login y pass
        correcto=UsuarioCRUD.verUsuario(loginID.getText(), passwordID.getText());
        System.out.println("Perfecto");
        if(correcto!=null) {
            lista = JuegoCRUD.verListaJuegos();
            App.setRoot("PantallaStore");
        }else{
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

}
