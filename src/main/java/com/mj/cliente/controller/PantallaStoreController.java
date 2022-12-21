/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mj.cliente.controller;

import com.mj.cliente.App;
import com.mj.cliente.crud.BibliotecaCRUD;
import com.mj.cliente.crud.DescargasCRUD;
import com.mj.cliente.crud.JuegoCRUD;
import com.mj.cliente.dao.Biblioteca;
import com.mj.cliente.dao.Descarga;
import com.mj.cliente.dao.Juego;
import com.mj.cliente.dao.Usuario;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author M3J2
 */
public class PantallaStoreController implements Initializable {

    @FXML
    private Button btn_Exit;
    @FXML
    private Button btn_Tienda;
    @FXML
    private Button btn_Biblioteca;
    @FXML
    private Button btn_perfil;
    private GridPane juegosGrid;
    @FXML
    private GridPane gridBiblioteca;
    @FXML
    private GridPane gridStore;
    @FXML
    private GridPane panelMenu;
    @FXML
    private Button btn_subir;

    public static boolean actualizarStore = true;
    public static boolean actualizarBiblioteca = true;
    static List<Juego> listaJuegos = new ArrayList();
    static List<Juego> listaJuegosUsuario= new ArrayList();;
    //ObservableList<Juego> listaJuegos  =(ObservableList<Juego>)PantallaLoginController.lista;
    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        int columns = 0;
        int columns2 = 0;
        int row = 1;
        //Juegos de la app

        if (actualizarStore) {
            listaJuegos = JuegoCRUD.verListaJuegos();
            actualizarStore = false;
        }

        try {
            for (int x = 0; x < listaJuegos.size(); x++) {
                FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("view/PantallaJuego.fxml"));
                VBox box = fxmlLoader.load();
                PantallaJuegoController controlador = fxmlLoader.getController();
                controlador.setData(listaJuegos.get(x));
                controlador.juegoGuardado = listaJuegos.get(x);
                gridBiblioteca.add(box, columns++, 1);
                GridPane.setMargin(box, new Insets(10));
                PantallaJuegoController.juegoEspecifico = listaJuegos.get(x);
            }
        } catch (IOException ex) {

        }

        if (actualizarBiblioteca) {
            Usuario usuario = PantallaLoginController.correcto;
            Biblioteca biblioteca = BibliotecaCRUD.verBiblioteca(usuario.getPkusuario());
            List<Descarga> listaDescargas = DescargasCRUD.verListaDescargas();
            
            for (Descarga d : listaDescargas) {
                if (d.getAkbiblioteca().equals(biblioteca)) {
                    if(!listaJuegosUsuario.contains(d.getAkjuego()))
                    listaJuegosUsuario.add(d.getAkjuego());
                }
            }
            actualizarBiblioteca=false;
        }

        try {
            for (int x = 0; x < listaJuegosUsuario.size(); x++) {
                FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("view/PantallaJuego.fxml"));
                VBox box = fxmlLoader.load();
                PantallaJuegoController controlador = fxmlLoader.getController();
                controlador.setData(listaJuegosUsuario.get(x));
                controlador.juegoGuardado = listaJuegosUsuario.get(x);
                gridStore.add(box, columns++, 1);
                GridPane.setMargin(box, new Insets(10));
                PantallaJuegoController.juegoEspecifico = listaJuegosUsuario.get(x);
            }
        } catch (IOException ex) {

        }

        addboton(PantallaLoginController.correcto);
    }

    @FXML
    private void abrirBiblioteca(ActionEvent event) throws IOException {
        App.setRoot("PantallaBiblioteca");

    }

    @FXML
    private void abrirTienda(ActionEvent event) throws IOException {
        App.setRoot("PantallaStore");

    }

    @FXML
    private void abrirPerfil(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("view/PantallaPerfil.fxml"));
        AnchorPane box = fxmlLoader.load();
        PantallaPerfilController controlador = fxmlLoader.getController();
        App.setRoot("PantallaPerfil");

    }

    @FXML
    private void cerrarSesion(ActionEvent event) throws IOException {
        App.setRoot("PantallaLogin");
    }

    public void addboton(Usuario user) {
        if (user.getAkperfil().getRol().equalsIgnoreCase("Desarrollador")) {

            btn_subir.setVisible(true);
        } else {
            btn_subir.setVisible(false);
        }
    }

    @FXML
    private void abrirSubirJuego(ActionEvent event) throws IOException {
        App.setRoot("PantallaSubirJuego");
    }

}
