
package com.mj.cliente;

import com.mj.cliente.service.DirectorioApp;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.stage.StageStyle;

public class App extends Application {

    /**
     * Stage Principal
     */
    private static Scene scene;
    public static Stage st;
    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("PantallaLogin"));
        st = stage;
        st.setTitle("M3J2");
        st.getIcons().add(new Image("com/mj/cliente/images/Logo sin texto.png"));
        st.setResizable(false);
        st.setIconified(false);
        st.initStyle(StageStyle.UNDECORATED);
        st.setScene(scene);
        st.sizeToScene();
        st.centerOnScreen();
        st.show();
    }

    /**
     * Metodo para cambiar la escena actual por otra escena
     * @param fxml Solo pasamo el nombre del fichero ya que en el metodo
     * loadFXML se define la ruta y la extension
     * @throws IOException 
     */
    public static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
        st.sizeToScene();
        st.centerOnScreen();
    }

    /**
     * Metodo para cargar un fxml
     * @param fxml Solo pasamo el nombre del fichero ya que dentro se define la ruta y la extension
     * @return
     * @throws IOException 
     */
    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("view/" + fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        //Al iniciar la aplicacion, crea las carpetas correspondientes donde almacenaremos los datos en local
        DirectorioApp.crearDirectorio();
        launch();
    }

}
