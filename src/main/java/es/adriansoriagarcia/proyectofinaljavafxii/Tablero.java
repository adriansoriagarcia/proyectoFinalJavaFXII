/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.adriansoriagarcia.proyectofinaljavafxii;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.util.Duration;


/**
 *
 * @author adrián
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
    Image cartaBackground;
    ImageView imgView;
    private boolean congelado=false;
    ImageView [][] imageOculta;
    boolean controlAcierto;
    
    
    public Tablero(Control control) { 
       imageOculta = new ImageView [Control.tamXTablero][Control.tamYTablero];
       setImage();
       ocultarImagenes();
       mouseEvent(control);
       
       
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
                imageOculta[columna][fila].setVisible(false);
                //System.out.println("colum carta 1 " + columna);
                //System.out.println("fila carta 1 " + fila);
            }else if (c==2){
                columna1 = (int)(event.getX() / Carta.TAM_CARTA);
                fila1 = (int)(event.getY() / Carta.TAM_CARTA);
                imageOculta[columna1][fila1].setVisible(false);
                //System.out.println("colum carta 2 " + columna1);
                //System.out.println(" fila carta 2 " + fila1);
                //System.out.println(c);
                System.out.println("colum carta1 " + columna);
                System.out.println("fila carta1 " + fila);
                System.out.println("colum carta2 " + columna1);
                System.out.println(" fila carta2 " + fila1);
                control.buscarPareja(columna,fila,columna1,fila1);
                controlAcierto = control.buscarPareja(columna,fila,columna1,fila1);
                System.out.println(controlAcierto);
                if (controlAcierto == false) {
                    ocultarImagenesDistintas();
                }
                c=0;    
            }else{ //mas de 2 clic consecutivos no toma en cuenta
                    c=0; 
            }
                  
        });
    }
    
    public void ocultarImagenes() {
        for(int x=0; x<Control.tamXTablero;x++){   
            for(int y=0; y<Control.tamYTablero;y++){
                cartaBackground = new Image(getClass().getResourceAsStream("/images/30.jpg"));
                imgView = new ImageView(cartaBackground);
                this.add(imgView, x, y); 
                imageOculta[x][y]=imgView;

            }
        }  
    }
    
    /**
     * Oculta las imágenes cuando no coinciden
     */
    public void ocultarImagenesDistintas(){
        
        timelineImagen = new Timeline(
            new KeyFrame(Duration.seconds(2.000), (ActionEvent t) -> {
                imageOculta[columna][fila].setVisible(true);
                imageOculta[columna1][fila1].setVisible(true);
                timelineImagen.stop();
        })
        );
        timelineImagen.setCycleCount(Timeline.INDEFINITE);
        timelineImagen.play();
    }

}


