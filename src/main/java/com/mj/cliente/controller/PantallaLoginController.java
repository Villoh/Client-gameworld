/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mj.cliente.controller;

import com.mj.cliente.App;

import com.mj.cliente.conexion.Conexion;
import com.mj.cliente.crud.Consulta;
import com.mj.cliente.dao.Usuario;
import java.io.IOException;
import java.net.URL;
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
//        App.setRoot("PantallaStore");
        //Buscamos el usuario con ese login y pass
//        Usuario correcto=UsuarioCRUD.verUsuario(loginID.getText(), passwordID.getText());
//        System.out.println("asd");
//        if(correcto!=null) {
//            App.setRoot("PantallaStore");
//        }else{
//            loginID.clear();
//            passwordID.clear();
//            System.out.println("Incorrecto");
//        }
        System.out.println("hola");
         App.setRoot("PantallaStore");
        Consulta.listaClientes();
    }

    @FXML
    private void crearCuenta(ActionEvent event) throws IOException {
        App.setRoot("PantallaCrearUsuario");

    }

    @FXML
    private void recuperarPass(ActionEvent event) throws IOException {
        App.setRoot("PantallaCambiarContraseña");
    }

    public static void verUsuarios(int pk) {
        Usuario usuario = new Usuario();
        Conexion con = new Conexion();
        EntityManager em = con.conecta();
        try {
            Query query = em.createNamedQuery("Usuario.findByPkusuario");
            query.setParameter("pkusuario", pk);
            usuario = (Usuario) query.getSingleResult();
            System.out.println("User_ " + usuario.getNombre());
        } catch (NoResultException ex) {
            System.out.println(">>> No encuentro el carrito - " + ex.getMessage());
        } catch (IllegalArgumentException ex) {
            System.out.println(">>> Error de argumento - " + ex.getMessage());
        }
        con.desconecta(em);
    }

}
