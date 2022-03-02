/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.adriansoriagarcia.proyectofinaljavafxii;

<<<<<<< HEAD
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.GridPane;
import javafx.util.Duration;
=======
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
>>>>>>> 79619659374fe550171a58ec7e6f086386a97299

/**
 *
 * @author usuario
 */

//Recorre el array de numeros y dependiendo del valor de cada posición coloca una imagen en grindpanel
public class Tablero extends GridPane {
    
<<<<<<< HEAD
    public boolean play = false;
    int c=0;
    int columna;
    int fila;
    int columna1;
    int fila1;
    Control control;
    Timeline timelineImagen;
    
    public Tablero(Control control) {
=======
    public Tablero() {
>>>>>>> 79619659374fe550171a58ec7e6f086386a97299
       for(int x=0; x<Control.tamXTablero;x++){   
        for(int y=0; y<Control.tamYTablero;y++){
            Carta carta = new Carta((byte)Control.tablero[x][y]);
            this.add(carta,x,y);

        }
       } 
<<<<<<< HEAD
       this.setOnMouseClicked((event) -> {
            c++;
            if(c==1) {
                columna = (int)(event.getX() / Carta.TAM_CARTA);
                fila = (int)(event.getY() / Carta.TAM_CARTA);
                //System.out.println("colum carta 1 " + columna);
                //System.out.println("fila carta 1 " + fila);
            }else if (c==2){
                columna1 = (int)(event.getX() / Carta.TAM_CARTA);
                fila1 = (int)(event.getY() / Carta.TAM_CARTA);
                //System.out.println("colum carta 2 " + columna1);
                //System.out.println(" fila carta 2 " + fila1);
                //System.out.println(c);
                System.out.println("colum carta1 " + columna);
                System.out.println("fila carta1 " + fila);
                System.out.println("colum carta2 " + columna1);
                System.out.println(" fila carta2 " + fila1);
                control.buscarPareja(columna,fila,columna1,fila1);
                boolean prueba = control.buscarPareja(columna,fila,columna1,fila1);
                c=0; 
                System.out.println(prueba);
            }else{ //mas de 2 clic consecutivos no toma en cuenta
                    c=0; 
            }
                  
        });
       
    } 
    
    public void ocultarImagenes() {
        timelineImagen = new Timeline(
            new KeyFrame(Duration.seconds(3.000), new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent t) {                    
                    System.out.println("duro 3 segundos");
                }        
            })
        );
    }
    
=======
    } 
    
>>>>>>> 79619659374fe550171a58ec7e6f086386a97299
 
}


