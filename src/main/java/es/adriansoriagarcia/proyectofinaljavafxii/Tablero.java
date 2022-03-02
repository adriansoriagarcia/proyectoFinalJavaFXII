/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.adriansoriagarcia.proyectofinaljavafxii;

import javafx.animation.Timeline;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;


/**
 *
 * @author usuario
 */

//Recorre el array de numeros y dependiendo del valor de cada posición coloca una imagen en grindpanel
public class Tablero extends GridPane {
    
    public boolean play = false;
    int c=0;
    int columna;
    int fila;
    int columna1;
    int fila1;
    Control control;
    Carta carta;
    Timeline timelineImagen;
    private boolean congelado=false;
    
    
    public Tablero(Control control) { 
       setImage();
       mouseEvent(control);
       ocultarImagenes();
       
    } 
    /*
     * Asigna la imágen que contendra cada casilla
    */
    public void setImage(){
        for(int x=0; x<Control.tamXTablero;x++){   
        for(int y=0; y<Control.tamYTablero;y++){
            carta = new Carta((byte)Control.tablero[x][y]);
            this.add(carta,x,y);

        }
       }  
    }
    
    /**
    * Asigna la posición de X e Y de las 2 cartas seleccionadas
    * @param control necesario para enviar parametros de cada click
    */
    public void mouseEvent(Control control){
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
        /*timelineImagen = new Timeline(
            new KeyFrame(Duration.seconds(3.000), new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent t) {                    
                    System.out.println("duro 3 segundos");
                }        
            })
        );*/
        for(int x=0; x<Control.tamXTablero;x++){   
            for(int y=0; y<Control.tamYTablero;y++){
                

            }
        }  
    }
    
 
}


