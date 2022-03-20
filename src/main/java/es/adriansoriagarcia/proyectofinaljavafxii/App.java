package es.adriansoriagarcia.proyectofinaljavafxii;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        // Panel principal que contendrá los elementos de la pantalla
        Pane paneRoot;
        final short tamXPantalla=750;//Constante con el tamaño horizontal de la pantalla
        final short tamYPantalla=580;//Constante con el tamaño vertical de la pantalla
        
        paneRoot = new Pane();
        //paneRoot.setAlignment(Pos.CENTER);
        var scene = new Scene(paneRoot, tamXPantalla, tamYPantalla);
        stage.setScene(scene);
        stage.show();
        stage.setTitle("Memoria");
        //Evitar cambiar tamaño de ventana
        stage.setResizable(false);
        
        MenuPrincipal menu = new MenuPrincipal();
        //Añadir el menu al paneRoot.
        paneRoot.getChildren().add(menu);
        
        //Añadir imagen de fondo.
        paneRoot.setStyle("-fx-background-image:url('images/background.jpg');");
        
        
        
    }

    public static void main(String[] args) {
        launch();
    }

}