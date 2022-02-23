package es.adriansoriagarcia.proyectofinaljavafxii;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


/**
 * JavaFX App
 * https://www.memo-juegos.com/pdf/memorama_para_imprimir_mario_kart.pdf
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        // Panel principal que contendrá los elementos de la pantalla
        GridPane paneRoot;
        short tamXPantalla=640;
        short tamYPantalla=480;
        
        paneRoot = new GridPane();
        var scene = new Scene(paneRoot, tamXPantalla, tamYPantalla);
        stage.setScene(scene);
        stage.show();
        stage.setTitle("Memoria");
        
        Tablero tablero= new Tablero();
        
        
        boolean prueba = tablero.buscarPareja(0,0,1,0);
        System.out.println(prueba);
        
        boolean fin = tablero.finPartida();
        System.out.println("fin partida " +fin);
        
        tablero.mostrarTableroConsola();
        
        Carta carta = new Carta((byte)7);
        paneRoot.getChildren().add(carta);
        
        
    }

    public static void main(String[] args) {
        launch();
    }

}