package es.adriansoriagarcia.proyectofinaljavafxii;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


/**
 * JavaFX App
 * https://www.memo-juegos.com/pdf/memorama_para_imprimir_mario_kart.pdf
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        // Panel principal que contendrá los elementos de la pantalla
        Pane paneRoot;
        final short tamXPantalla=800;//Constante con el tamaño horizontal de la pantalla
        final short tamYPantalla=580;//Constante con el tamaño vertical de la pantalla
        
        paneRoot = new Pane();
        //paneRoot.setAlignment(Pos.CENTER);
        var scene = new Scene(paneRoot, tamXPantalla, tamYPantalla);
        stage.setScene(scene);
        stage.show();
        stage.setTitle("Memoria");
        stage.setResizable(false);
        
        //TAMAÑOS TABLERO(4X4|6X6)
        //(short)6,(short)6
        Tablero tablero = new Tablero();
        tablero.setLayoutX(10);
        tablero.setLayoutY(10);
        paneRoot.getChildren().add(tablero);
        //tablero.
        
        PanelLateral panel = new PanelLateral();
        panel.setLayoutX(600);
        panel.setLayoutY(180);
        paneRoot.getChildren().add(panel);
        
        
        
    }

    public static void main(String[] args) {
        launch();
    }

}