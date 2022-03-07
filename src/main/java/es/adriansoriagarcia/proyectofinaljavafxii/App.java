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
        final short tamXPantalla=800;//Constante con el tamaño horizontal de la pantalla
        final short tamYPantalla=570;//Constante con el tamaño vertical de la pantalla
        
        paneRoot = new GridPane();
        var scene = new Scene(paneRoot, tamXPantalla, tamYPantalla);
        stage.setScene(scene);
        stage.show();
        stage.setTitle("Memoria");
        
        //TAMAÑOS TABLERO(4X4|6X6)
        //(short)6,(short)6
        Control control= new Control();
        
        
        //boolean fin = control.finPartida();
        //System.out.println("fin partida " +fin);
        
        //control.mostrarTableroConsola();
        
        
        Tablero tablero = new Tablero(control);
        paneRoot.getChildren().add(tablero);
        
        
        
    }

    public static void main(String[] args) {
        launch();
    }

}