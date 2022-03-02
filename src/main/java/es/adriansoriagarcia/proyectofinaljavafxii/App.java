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
        short tamYPantalla=570;
        
        paneRoot = new GridPane();
        var scene = new Scene(paneRoot, tamXPantalla, tamYPantalla);
        stage.setScene(scene);
        stage.show();
        stage.setTitle("Memoria");
        
        //TAMAÑOS TABLERO(4X4|6X6)
        //(short)6,(short)6
        Control control= new Control();
        
<<<<<<< HEAD
        //boolean prueba = control.buscarPareja(Tablero.columna,Tablero.fila,Tablero.columna1,Tablero.fila1);
        //System.out.println(prueba);
        
        //boolean fin = control.finPartida();
        //System.out.println("fin partida " +fin);
        
        //control.mostrarTableroConsola();
        
        
        Tablero tablero = new Tablero(control);
        paneRoot.getChildren().add(tablero);
        
=======
        boolean prueba = control.buscarPareja(0,0,1,0);
        System.out.println(prueba);
        
        boolean fin = control.finPartida();
        System.out.println("fin partida " +fin);
        
        control.mostrarTableroConsola();
        
        Tablero tablero = new Tablero();
        paneRoot.getChildren().add(tablero);
        
>>>>>>> 79619659374fe550171a58ec7e6f086386a97299
        
        
    }

    public static void main(String[] args) {
        launch();
    }

}