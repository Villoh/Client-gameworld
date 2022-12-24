/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mj.cliente.controller;

import com.mj.cliente.App;
import com.mj.cliente.conexion.Conexion;
import com.mj.cliente.crud.BibliotecaCRUD;
import com.mj.cliente.dao.Biblioteca;
import com.mj.cliente.dao.Descarga;
import com.mj.cliente.dao.Juego;
import com.mj.cliente.dao.Usuario;
import com.mj.cliente.service.SocketTransfer;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

/**
 * FXML Controller class
 *
 * @author dam107
 */
public class PantallaJuegoEspecificoController implements Initializable {

    @FXML
    private ImageView imagen;
    @FXML
    private Label titulo;
    @FXML
    private Label genero;
    @FXML
    private Label nivel;
    @FXML
    private Label pegi;
    @FXML
    private Label descripcion;
    @FXML
    private Label creador;
    @FXML
    private Label fechacreacion;
    @FXML
    private Label pvp;

    static Juego juego = new Juego();
    @FXML
    private AnchorPane parent;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        makeStageDragable();
        try {
            setData(PantallaJuegoEspecificoController.juego);
        } catch (IOException ex) {
            Logger.getLogger(PantallaJuegoEspecificoController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public PantallaJuegoEspecificoController() {

    }

    public void setImagen(ImageView imagen) {
        this.imagen = imagen;
    }

    public void setTitulo(Label titulo) {
        this.titulo = titulo;
    }

    /**
     * Establecemos los datos que se muestran en la ventana de información de
     * cada juego
     *
     * @param juego
     * @throws IOException
     */
    public void setData(Juego juego) throws IOException {
        String rutaImagen = "C:\\GameWorld\\Img\\ImgJuegos\\";
        String nombreImagen = juego.getImagen();
        Image image = new Image(rutaImagen.concat(nombreImagen));
        imagen.setFitWidth(100);
        imagen.setFitHeight(100);
        imagen.setImage(image);
        titulo.setText(juego.getTitulo());
        descripcion.setText(juego.getDescripcion());
        genero.setText(juego.getAkgenero().getNombre());
        nivel.setText(juego.getAknivel().getPknivel());
        pegi.setText(juego.getAkpegi().getRangopegi());
        creador.setText(juego.getAkcreador().getNombre() + " " + juego.getAkcreador().getApellidos());
        fechacreacion.setText(juego.getFechacreacion().toString());
        pvp.setText(juego.getPvp().toString());

    }

    /**
     * Metodo para descargar un juego desde la ventana de JuegoEspecifico
     *
     * @param event
     * @throws IOException
     */
    @FXML
    private void descargarJuego(ActionEvent event) throws IOException {
        int update = 0;
        //Obtenemos el objeto juego para buscar sus propiedades de imagen y zip.
        Juego juego = PantallaJuegoEspecificoController.juego;
        //Obtenemos el nuevo numero, para actualizar el numero de descargas del juego.
        int nuevoNumeroDescargas = juego.getNumdescargas() + 1;
        // Realizamos la petiicion al servidor de archivos pasando el nombre de la imagen
        // y el nombre del archivo.zip que queremos descargar.
        ExecutorService executor = Executors.newSingleThreadExecutor();
        SocketTransfer zipFile = new SocketTransfer(1, "", juego.getZipjuego());
        SocketTransfer image = new SocketTransfer(3, "", juego.getImagen());
        executor.submit(zipFile);
        executor.submit(image);
        executor.shutdown();
        System.out.println("Descaga del servidor finalizada");
        System.out.println("Descargado>>>>>>>>>>>>>>>>");
        //Realizamos la transaccion correspondiente con la base de datos
        Conexion con = new Conexion();
        EntityManager em = con.conecta();
        EntityTransaction tx = em.getTransaction();
        try {
            //Update numero descargasjuego
            tx.begin();
            String jpql = "update Juego j set j.numdescargas=:numdescargas where j.pkjuego=:pkjuego";
            Query query = em.createQuery(jpql);
            query.setParameter("numdescargas", nuevoNumeroDescargas);
            query.setParameter("pkjuego", juego.getPkjuego());
            query.executeUpdate();
            //Añadimos el juego descargado a la biblioteca del usuario correspondiente
            Usuario usuario = PantallaLoginController.correcto;
            Biblioteca biblioteca = BibliotecaCRUD.verBiblioteca(usuario.getPkusuario());
            Descarga descarga = new Descarga();
            descarga.setAkbiblioteca(biblioteca);
            descarga.setAkjuego(juego);
            descarga.setFecha(java.sql.Date.valueOf(LocalDate.now()));
            em.persist(descarga);
            tx.commit();
            PantallaStoreController.actualizarBiblioteca = true;
            update = 1;
            //
        } catch (NoResultException ex) {
            System.out.println(">>> No encuentro el genero - " + ex.getMessage());
        } catch (IllegalArgumentException ex) {
            System.out.println(">>> Error de argumento - " + ex.getMessage());
        } catch (PersistenceException ex) {
            tx.rollback();
            System.err.println("ERROR de persistencia. " + ex.getLocalizedMessage());

        }
        con.desconecta(em);

        System.out.println("Juego Descomprimido");
        App.setRoot("PantallaStore");

    }

    @FXML
    private void volveStore(ActionEvent event) throws IOException {

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

    private void min_stage(ActionEvent event) {

        App.st.setIconified(true);

    }

    @FXML
    private void Close_app(ActionEvent event) {

        System.exit(0);

    }

    @FXML
    private void lanzarJuego(ActionEvent event) {
    }

    @FXML
    private void minStage(ActionEvent event) {
        App.st.setIconified(true);
    }

}
