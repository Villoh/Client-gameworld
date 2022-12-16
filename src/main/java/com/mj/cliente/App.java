package com.mj.cliente;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import javafx.scene.Parent;
import javafx.scene.image.Image;

public class App extends Application {

    /**
     * Stage Principal
     */
    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("PantallaLogin"), 640, 480);
        stage.setTitle("M3J2");
        stage.getIcons().add(new Image("com/mj/cliente/images/LogoApp.png"));
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Metodo para cambiar la escena actual por otra escena
     * @param fxml
     * @throws IOException 
     */
    public static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("view/" + fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}
