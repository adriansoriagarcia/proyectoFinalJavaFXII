/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.adriansoriagarcia.proyectofinaljavafxii;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
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
    byte c=0;
    byte columna;
    byte fila;
    byte columnaTemporal;
    byte filaTemporal;
    byte columna1;
    byte fila1;
    Control control;
    Carta carta;
    Timeline timelineocultaImagen;
    Timeline timelineImagen;
    Image cartaBackground;
    ImageView imgView;
    ImageView [][] imageOculta;
    boolean controlAcierto;
    Button myButton;
    final ChoiceBox<String> nivelDifi;
    String valor;
    short intentosRestantes;
    
    /*
     * Método constructor de la clase Tablero.
    */
    public Tablero(Control control) { 
        myButton = new Button("Iniciar");
        myButton.setMaxSize(100,50);
        this.add(myButton, 7, 1);
       
       
        nivelDifi = new ChoiceBox<String>();
        nivelDifi.getSelectionModel().select("Medio");

        nivelDifi.getItems().add("Facil");
        nivelDifi.getItems().add("Medio");
        nivelDifi.getItems().add("Dificil");

        nivelDifi.getSelectionModel()
            .selectedItemProperty()
            .addListener( (ObservableValue<? extends String> observable, String oldValue, String newValue) -> System.out.println(newValue) );
        this.add(nivelDifi, 7, 0);
        
        valor=nivelDifi.getValue();
        System.out.println(valor + "variable");
       
        //System.out.println(nivelDifi.getValue());//Valor seleccionado nivel dificultad
        //System.out.println(nivelDifi.getSelectionModel(). getSelectedItem());

        imageOculta = new ImageView [Control.tamXTablero][Control.tamYTablero];
        ocultarImagenes();
        muestraImagenesInicio(control);
        //mouseEvent(control); 
       
    } 
    /*
     * Muestra las imágenes de todo el tablero durante x segundos al iniciar.
    */
    public void muestraImagenesInicio(Control control){
        myButton.setOnAction((t) -> {
            anadeImagenes();
            timelineImagen.play(); 
        });
        
        timelineImagen = new Timeline(
            new KeyFrame(Duration.seconds(4.000), (ActionEvent t) -> {
               ocultarImagenes(); 
               mouseEvent(control); 
               //myButton.setCancelButton(false);
               myButton.setVisible(false);
        })
        );
        timelineImagen.setCycleCount(1);
        //timelineImagen.play();
    }
    /*
     * Asigna la imágen que contendra cada casilla
    */
    public void anadeImagenes(){
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
            columnaTemporal = (byte)(event.getX() / Carta.TAM_CARTA);
            filaTemporal = (byte)(event.getY() / Carta.TAM_CARTA);
            
            //if que controla que no se pueda volver a tapar una carta acertada.
            if(Control.encontrado[columnaTemporal][filaTemporal] == Control.SIPAREJA) {
                    imageOculta[columnaTemporal][filaTemporal].setVisible(false);
                    
            }else {//en el caso de que no este levantada levanta las correspondiente a las 2 deseadas.
                c++;
                System.out.println(c);
                if(c==1) {  
                    columna = columnaTemporal;
                    fila =  filaTemporal;
                    imageOculta[columna][fila].setVisible(false);

                    System.out.println("colum carta 1 " + columna);
                    System.out.println("fila carta 1 " + fila);
                }else if (c==2){
                    columna1 = columnaTemporal;
                    fila1 = filaTemporal;
                    imageOculta[columna1][fila1].setVisible(false);
                    intentosRestantes--;
                    System.out.println("colum carta 2 " + columna1);
                    System.out.println(" fila carta 2 " + fila1);
                    //System.out.println(c);
                    if(columna==columna1 && fila==fila1) {
                        c--;
                    }else {
                        control.buscarPareja(columna,fila,columna1,fila1);
                        controlAcierto = control.buscarPareja(columna,fila,columna1,fila1);
                        System.out.println(controlAcierto);
                    }
                    //System.out.println("colum carta1 " + columna);
                    //System.out.println("fila carta1 " + fila);
                    //System.out.println("colum carta2 " + columna1);
                    //System.out.println(" fila carta2 " + fila1);
                    
                    //Si la pareja mostrada es distinta llama al metodo para ocultarlas.
                    if (controlAcierto == false) {
                        ocultarImagenesDistintas();
                    }else {
                       c=0; 
                       
                    } 
                    //System.out.println(intentosRestantes);  
                }
            }
            
            
                
        });
        
    }
    
    /*
     * Oculta todas las imágenes del tablero.
    */
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

        timelineocultaImagen = new Timeline(
            new KeyFrame(Duration.seconds(1.000), (ActionEvent t) -> {
                imageOculta[columna][fila].setVisible(true);//Oculta la imágen levantada
                imageOculta[columna1][fila1].setVisible(true);//Oculta la imágen levantada
                c=0;//Contador de clic en 0 una vez ocultada las imagenes para no mostrar mas de 2 imágenes 
 
        })
        );
        timelineocultaImagen.setCycleCount(1);
        timelineocultaImagen.play();
    }
    
    public void fin(){
        boolean fin = control.finPartida();
        System.out.println("fin partida " +fin);
    }

}

//el nivel de dificultad depende de la cantidad de click disponibles


