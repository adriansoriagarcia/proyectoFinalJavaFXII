package es.adriansoriagarcia.proyectofinaljavafxii;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        short tamXPantalla=640;
        short tamYPantalla=480;
        
        var scene = new Scene(new StackPane(), tamXPantalla, tamYPantalla);
        stage.setScene(scene);
        stage.show();
        
        Tablero tablero= new Tablero();
        
        
        boolean prueba = tablero.buscarPareja(0,0,1,0);
        System.out.println(prueba);
        
        tablero.mostrarTableroConsola();
    }

    public static void main(String[] args) {
        launch();
    }

}