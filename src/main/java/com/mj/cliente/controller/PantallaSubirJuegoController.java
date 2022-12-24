/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mj.cliente.controller;

import com.mj.cliente.App;
import com.mj.cliente.conexion.Conexion;
import com.mj.cliente.crud.JuegoCRUD;
import com.mj.cliente.dao.Genero;
import com.mj.cliente.dao.Juego;
import com.mj.cliente.dao.Nivel;
import com.mj.cliente.dao.Pegi;
import com.mj.cliente.dao.Usuario;
import com.mj.cliente.service.SocketTransfer;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author M3j2
 */
public class PantallaSubirJuegoController implements Initializable {

    @FXML
    private TextField txt_NombreJuego;
    @FXML
    private TextField txt_precio;
    @FXML
    private ImageView img_Logo;
    @FXML
    private ComboBox comboGenero;
    @FXML
    private DatePicker fechaJuego;
    @FXML
    private ComboBox comboDificultad;
    @FXML
    private ComboBox comboClasificacion;
    @FXML
    private TextField txf_descripcion;
    @FXML
    private Label label_nombreZip;

    public static String rutaImagen;
    public static String rutaZipJuego;
    public static String nombreImagen;
    public static String nombreZipJuego;
    @FXML
    private AnchorPane parent;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        makeStageDragable();
        comboGenero.getItems().addAll("Accion", "Arcade", "Aventura", "Clicker", "Plataformas");
        comboDificultad.getItems().addAll("Alta", "Media", "Baja");
        comboClasificacion.getItems().addAll("PEGI 3", "PEGI 7", "PEGI 12", "PEGI 16", "PEGI 18");

    }

    /**
     * Metodo para subir los juegos desde la app al servidor. Realizamos la
     * inserción de los datos en la BBDD, si se ha relizado la transaccion
     * prodecemos a enviar los archivos al servidor de juegos.
     *
     * @param event
     * @throws IOException
     */
    @FXML
    private void subirJuego(ActionEvent event) throws IOException {
        JuegoCRUD jCrud = new JuegoCRUD();
        if (txt_NombreJuego.getText().isEmpty() || fechaJuego.getValue() == null || comboGenero.getValue().toString().isEmpty()
                || comboDificultad.getValue().toString().isEmpty() || comboClasificacion.getValue().toString().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Te faltan datos!", "Error!", 2);
        } else {
            //Creamos el objeto Juego para realizar la persistencia
            Juego juego = new Juego();
            Genero genero = new Genero();
            Nivel nivel = new Nivel();
            Pegi pegi = new Pegi();
            Conexion con = new Conexion();
            EntityManager em = con.conecta();
            try {
                //
                Query query = em.createNamedQuery("Genero.findByNombre");
                query.setParameter("nombre", comboGenero.getValue().toString());
                genero = (Genero) query.getSingleResult();
                //
                query = em.createNamedQuery("Nivel.findByPknivel");
                query.setParameter("pknivel", comboDificultad.getValue().toString());
                nivel = (Nivel) query.getSingleResult();
                //
                query = em.createNamedQuery("Pegi.findByRangopegi");
                query.setParameter("rangopegi", comboClasificacion.getValue().toString());
                pegi = (Pegi) query.getSingleResult();
                //
            } catch (NoResultException ex) {
                System.out.println(">>> No encuentro el genero - " + ex.getMessage());
            } catch (IllegalArgumentException ex) {
                System.out.println(">>> Error de argumento - " + ex.getMessage());
            }
            con.desconecta(em);

            //Obtenemos los datos de la base de datos
            Usuario usuario = PantallaLoginController.correcto;
//   >>     Creamos el objeto juego
            juego.setTitulo(txt_NombreJuego.getText());
            juego.setDescripcion(txf_descripcion.getText());///Asignar id en fxml
            juego.setImagen(nombreImagen);
            juego.setZipjuego(nombreZipJuego);
            juego.setAkgenero(genero);
            juego.setAknivel(nivel);
            juego.setAkpegi(pegi);
            juego.setAkcreador(usuario);
            juego.setFechacreacion(java.sql.Date.valueOf(fechaJuego.getValue()));
            juego.setPvp(Float.parseFloat(txt_precio.getText()));
            juego.setNumdescargas(0);
            //Persistencia de datos
            int resultado = jCrud.nuevoJuego(juego);
            System.out.println("Juego Creado");
            //Subir juego al servidor
            if (resultado == 1) {
                //Haciendo uso de la clase SocketTransfer(Hilo), realizamos la subida de los archivos
                ExecutorService executor = Executors.newSingleThreadExecutor();
//                System.out.println("De nuevi " + rutaZipJuego);
//                System.out.println("De nuevi " + rutaImagen);
                SocketTransfer zipFile = new SocketTransfer(2, rutaZipJuego, nombreZipJuego);
                SocketTransfer image = new SocketTransfer(4, rutaImagen, nombreImagen);
                executor.submit(zipFile);
                executor.submit(image);
                executor.shutdown();
                JOptionPane.showMessageDialog(null, "Juego Subido a la Plataforma", "Nuevo Juego", 2);
            } else {
                JOptionPane.showMessageDialog(null, "Error con con la BBDD", "Nuevo Juego", 2);
            }
            PantallaStoreController.actualizarStore = true;
            //Volvemos a la pantalla anterior.
            //App.setRoot("PantallaStore");

        }

    }

    /**
     * Metodo que genera un FileChosser para seleccionar la portada del juego.
     * Sólo permite imagenes en el formato indicado
     *
     * @param event
     * @throws FileNotFoundException
     */
    @FXML
    private void escogerPortada(ActionEvent event) throws FileNotFoundException {

        FileChooser avatar = new FileChooser();
        File file = avatar.showOpenDialog(new Stage());
        if (file.getName().endsWith(".png") || file.getName().endsWith(".jpg")) {
            avatar.setTitle("¡Escoge tu avatar!");
            Image image = new Image(new FileInputStream(file));
            img_Logo.setImage(image);
            String rutaTemporal = file.getAbsolutePath();
            rutaImagen = rutaTemporal.replace("\\", "\\\\");
            nombreImagen = file.getName();
            System.out.println(rutaImagen);
        } else {
            JOptionPane.showMessageDialog(null, "Los formatos validos son: JPG y PNG", "No es un archivo valido", 2);
        }
    }

    /**
     * Metodo que genera un FileChosser para seleccionar el zip del juego. Sólo
     * permite archivos en formato zip
     *
     * @param event
     * @throws FileNotFoundException
     */
    @FXML
    private void escogerZip(ActionEvent event) throws FileNotFoundException {

        FileChooser archivoZip = new FileChooser();
        File file = archivoZip.showOpenDialog(new Stage());
        if (file.getName().endsWith(".zip")) {
            archivoZip.setTitle("¡Escoge tu Juego!");
            String rutaTemporal = file.getAbsolutePath();
            rutaZipJuego = rutaTemporal.replace("\\", "\\\\");
            nombreZipJuego = file.getName();
            label_nombreZip.setText(nombreZipJuego);
            System.out.println(rutaZipJuego);
        } else {
            JOptionPane.showMessageDialog(null, "El formato válido es: ZIP", "No es un archivo valido", 2);
        }

    }

    @FXML
    private void volver(ActionEvent event) throws IOException {
        App.setRoot("PantallaStore");
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

    /**
     * Capacidad de minimizar la ventana
     * @param event 
     */
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
