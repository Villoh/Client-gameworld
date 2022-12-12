package com.mj.cliente;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import javafx.scene.Parent;
import javafx.scene.image.Image;

public class App extends Application {
    public static Stage stg;
    
    @Override
    public void start(Stage stage) throws IOException {
        stg = stage;
        try{
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("view/PantallaLogin.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 650, 400);
        stage.setTitle("M3J2");
        stage.getIcons().add(new Image("com/mj/cliente/images/LogoApp.png"));
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
  
        }catch (IOException ex) {
            
        }
    }

    public static void main(String[] args) {
        launch();
    }
    
     /**
     * Metodo que permite cambiar la escena en la misma pantalla
     *
     * @param fxml
     * @throws IOException
     */
    public void changeScene(String fxml) throws IOException {
        Parent pane = FXMLLoader.load(getClass().getResource(fxml));
        stg.getScene().setRoot(pane);
    }

    public void closeScene() {
        stg.close();
    }

    public void openScene() {
        stg.show();
    }
}