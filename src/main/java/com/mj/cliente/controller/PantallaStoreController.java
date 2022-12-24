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
    private Button btn_perfil;
    @FXML
    private GridPane gridStore;
    @FXML
    private GridPane panelMenu;
    @FXML
    private Button btn_subir;

    public static boolean actualizarStore = true;
    public static boolean actualizarBiblioteca = true;
    static List<Juego> listaJuegosStore = new ArrayList();
    static List<Juego> listaJuegosUsuario = new ArrayList();
    ;
    @FXML
    private AnchorPane parent;
    @FXML
    private GridPane gridBibliotecaPersonal;

  
    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        makeStageDragable();
        int columns = 0;
        int columns2 = 0;
       
        //Juegos de la app
        //Cargamos la lista de juegos Disponibles en la tienda
        listaJuegosStore = JuegoCRUD.verListaJuegos();

        try {
            for (int x = 0; x < listaJuegosStore.size(); x++) {
                //Cargamos la plantilla xml
                FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("view/PantallaJuego.fxml"));
                VBox box = fxmlLoader.load();
                PantallaJuegoController controlador = fxmlLoader.getController();
                //Pasamos el objeto juego a la ventana del juego(PantallaJuego.fxml)
                controlador.setData(listaJuegosStore.get(x));
                controlador.juegoGuardado = listaJuegosStore.get(x);
                //Agregamos una ventana por juego al Grid
                gridStore.add(box, columns++, 1);
                GridPane.setMargin(box, new Insets(10));
                PantallaJuegoController.juegoEspecifico = listaJuegosStore.get(x);
            }
        } catch (IOException ex) {

        }

        //>>>>>>>>  Juegos Biblioteca Personal Jugador <<<<<<<<<<<<
        /*Obtenemos los juegos espeficios del usuario, los almacenamos en uns lista y luego
        mostramos los juegos por pantalla*/
        Usuario usuario = PantallaLoginController.correcto;
        Biblioteca biblioteca = BibliotecaCRUD.verBiblioteca(usuario.getPkusuario());
        List<Descarga> listaDescargas = DescargasCRUD.verListaDescargas();

        for (Descarga d : listaDescargas) {
            if (d.getAkbiblioteca().equals(biblioteca)) {
                if (!listaJuegosUsuario.contains(d.getAkjuego())) {
                    listaJuegosUsuario.add(d.getAkjuego());
                }
            }
        }

        try {
            for (int x = 0; x < listaJuegosUsuario.size(); x++) {
                //Cargamos la plantilla xml
                FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("view/PantallaJuego.fxml"));
                VBox box = fxmlLoader.load();
                PantallaJuegoController controlador = fxmlLoader.getController();
                controlador.setData(listaJuegosUsuario.get(x));
                controlador.juegoGuardado = listaJuegosUsuario.get(x);
                 //Agregamos una ventana por juego al Grid
                gridBibliotecaPersonal.add(box, columns++, 1);
                GridPane.setMargin(box, new Insets(10));
                PantallaJuegoController.juegoEspecifico = listaJuegosUsuario.get(x);
            }
        } catch (IOException ex) {

        }

        addboton(PantallaLoginController.correcto);
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
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("view/PantallaPerfil.fxml"));
        AnchorPane box = fxmlLoader.load();
        PantallaPerfilController controlador = fxmlLoader.getController();
        App.setRoot("PantallaPerfil");

    }

    @FXML
    private void cerrarSesion(ActionEvent event) throws IOException {
        App.setRoot("PantallaLogin");
    }

    /**
     * Con este metodo habilitamos el boton subir juego si el perfil de login 
     * es desarrollador
     * @param user 
     */
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
