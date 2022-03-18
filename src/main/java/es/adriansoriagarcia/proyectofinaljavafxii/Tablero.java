/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.adriansoriagarcia.proyectofinaljavafxii;

import static es.adriansoriagarcia.proyectofinaljavafxii.PanelLateral.textClick;
import static es.adriansoriagarcia.proyectofinaljavafxii.PanelLateral.textTiempo;

import java.net.URISyntaxException;
import java.net.URL;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DialogPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import javafx.util.Duration;




/**
 *
 * @author adriÃ¡n
 */

//Recorre el array de numeros y dependiendo del valor de cada posiciÃ³n coloca una imagen en grindpanel
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
    Timeline timelineCuentaAtras;
    Timeline timelineEsperaFin;
    Image cartaBackground;
    ImageView imgView;
    ImageView [][] imageOculta;
    boolean controlAcierto;
    Button ButtonInicio;
    int valor;
    static short intentosRestantes = 5;
    byte cuentaAtras = 4;
    final int TEXT_SIZE = 24;
    int selectedNivel;//Indice del nivel de dificultad
    Alert AlertFin ;
    AudioClip audioClip1;
    URL urlAudio;
    
    /*
     * MÃ©todo constructor de la clase Tablero.
    */
    public Tablero() { 
        //this.setMinWidth(Carta.TAM_CARTA * Control.tamXTablero);
        //this.setMinHeight(Carta.TAM_CARTA * (Control.tamYTablero + 1)); 
        //this.setMaxWidth(Carta.TAM_CARTA * Control.tamXTablero);
        //this.setMaxHeight(Carta.TAM_CARTA * (Control.tamYTablero + 1)); 
        //this.setPrefWidth(Carta.TAM_CARTA * Control.tamXTablero);
        //this.setPrefHeight(Carta.TAM_CARTA * (Control.tamYTablero + 1)); 
        this.setAlignment(Pos.CENTER);
        control= new Control();
        //panel= new PanelLateral();
 
        
        PanelLateral.ButtonInicio = new Button("Iniciar");
        PanelLateral.btnStart=new Button("");
        PanelLateral.btnPause = new Button("");
        //----------------------------------------------------------------------
        //array de tamaÃ±o del tablero
        imageOculta = new ImageView [Control.tamXTablero][Control.tamYTablero];
        ocultarImagenes();
        muestraImagenesInicio(control);
        //this.getStylesheets().add("stylesheet.css");
        //urlAudio = getClass().getResource("/audio/carta.mp3");
        
        PanelLateral.btnStart.setOnAction((t) -> {
            urlAudio = getClass().getResource("/audio/carta.mp3");
        });
        PanelLateral.btnPause.setOnAction((t) -> {
            urlAudio = getClass().getResource("/audio/silencio.mp3");
        });
        
    } 
    /*
     * Muestra las imÃ¡genes de todo el tablero durante x segundos al iniciar.
    */
    private void muestraImagenesInicio(Control control){
        PanelLateral.ButtonInicio.setOnAction((t) -> {
            anadeImagenes();
            timelineCuentaAtras.play();
            timelineImagen.play();
            textClick.setText(String.valueOf(intentosRestantes));
            PanelLateral.nivelDifi.setDisable(true);
            PanelLateral.ButtonInicio.setDisable(true);
            this.setDisable(false);//Activamos el gridPane para empezar la partida
            
            
        });
        
        //Timeline para la cuenta atras 
        timelineCuentaAtras = new Timeline(
            new KeyFrame(Duration.seconds(0.990), (ActionEvent t) -> {
            cuentaAtras--; 
            PanelLateral.textTiempo.setText(String.valueOf(cuentaAtras));
            textTiempo.setText(String.valueOf(cuentaAtras));
            if (cuentaAtras==0){
               timelineCuentaAtras.stop();
            }
                System.out.println(cuentaAtras);
                
               
        })
        );
        timelineCuentaAtras.setCycleCount(Timeline.INDEFINITE);
        //timelineCuentaAtras.play();
        //timelineCuentaAtras.play();

        //Timeline con espera de 4 segundos para ocultar las cartas
        timelineImagen = new Timeline(
            new KeyFrame(Duration.seconds(4.000), (ActionEvent t) -> {
               ocultarImagenes(); 
               mouseEvent(control); 
               //myButton.setCancelButton(false);   
        })
        );
        timelineImagen.setCycleCount(1);
        //timelineImagen.play();
      

    }
    /*
     * Asigna la imÃ¡gen que contendra cada casilla
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
    * Asigna la posiciÃ³n de X e Y de las 2 cartas seleccionadas
    * @param control necesario para enviar parametros de cada click
    */
    public void mouseEvent(Control control){
        this.setOnMouseClicked((event) -> {
            //System.out.println("entra en mouse event");
            System.out.println("getx: "+event.getX());
            System.out.println("gety: "+event.getY());
            columnaTemporal = (byte)(event.getX() / Carta.TAM_CARTA);
            filaTemporal = (byte)(event.getY() / Carta.TAM_CARTA);
            System.out.println(columnaTemporal);
            System.out.println(filaTemporal);
            //if que controla que no se pueda volver a tapar una carta acertada.
            if(Control.encontrado[columnaTemporal][filaTemporal] == Control.SIPAREJA) {
                    imageOculta[columnaTemporal][filaTemporal].setVisible(false);
                    
            }else {//en el caso de que no este levantada levanta las correspondiente a las 2 deseadas.
                c++;
                System.out.println(c);
                if(c==1) { //Primer click
                    columna = columnaTemporal;
                    fila =  filaTemporal;
                    imageOculta[columna][fila].setVisible(false);

                    System.out.println("colum carta 1 " + columna);
                    System.out.println("fila carta 1 " + fila);
                    
                    if(urlAudio != null) {
                        try {
                            audioClip1 = new AudioClip(urlAudio.toURI().toString());
                            audioClip1.play();
                        } catch (URISyntaxException ex) {
                            System.out.println("Error en el formato de ruta de archivo de audio");
                        }            
                    } else {
                        System.out.println("No se ha encontrado el archivo de audio");
                    }
                    
                }else if (c==2){//Segundo click
                    columna1 = columnaTemporal;
                    fila1 = filaTemporal;
                    imageOculta[columna1][fila1].setVisible(false);

                    if(urlAudio != null) {
                        try {
                            audioClip1 = new AudioClip(urlAudio.toURI().toString());
                            audioClip1.play();
                        } catch (URISyntaxException ex) {
                            System.out.println("Error en el formato de ruta de archivo de audio");
                        }            
                    } else {
                        System.out.println("No se ha encontrado el archivo de audio");
                    }

                    System.out.println("colum carta 2 " + columna1);
                    System.out.println(" fila carta 2 " + fila1);
                    //System.out.println(c);
                    //If que controla si se pulsa dos veces sobre la misma carta no cuente el segundo click.
                    if(columna==columna1 && fila==fila1) {
                        c--;
                    }else {//Envia los cuatro parÃ¡metros de las 2 cartas seleccionadas.
                        intentosRestantes--;
                        textClick.setText(String.valueOf(intentosRestantes));
                        finPerdida();
                        control.buscarPareja(columna,fila,columna1,fila1);
                        controlAcierto = control.buscarPareja(columna,fila,columna1,fila1);
                        System.out.println(controlAcierto);
                        boolean fin = control.finPartida();
                        if(fin==true) {
                            finGanada();
                        }
                        System.out.println("fin partida " +fin);
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
     * Oculta todas las imÃ¡genes del tablero.
    */
    private void ocultarImagenes() {
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
     * Oculta las imÃ¡genes cuando no coinciden
     */
    public void ocultarImagenesDistintas(){

        timelineocultaImagen = new Timeline(
            new KeyFrame(Duration.seconds(1.000), (ActionEvent t) -> {
                imageOculta[columna][fila].setVisible(true);//Oculta la imÃ¡gen levantada
                imageOculta[columna1][fila1].setVisible(true);//Oculta la imÃ¡gen levantada
                c=0;//Contador de clic en 0 una vez ocultada las imagenes para no mostrar mas de 2 imÃ¡genes 
 
        })
        );
        timelineocultaImagen.setCycleCount(1);
        timelineocultaImagen.play();
    }
    
    /**
     * Muestra un alert cuando los intentos llegan a 0
     */
    public void finPerdida(){
        
        if (intentosRestantes==0){
            System.out.println("entra en fin perdida");
            timelineEsperaFin = new Timeline(
            new KeyFrame(Duration.seconds(1.000), (ActionEvent t) -> {
               ocultarImagenes();//llama al metodo ocultarImagenes.
 
            })
            );
            timelineEsperaFin.setCycleCount(1);
            timelineEsperaFin.play();
            //System.out.println("fin partida perdida");
             
            AlertFin = new Alert(Alert.AlertType.INFORMATION);
            DialogPane dialogPane = AlertFin.getDialogPane();
            //dialogPane.setStyle("-fx-font: normal bold 15px 'serif'");
            AlertFin.getDialogPane().setGraphic(new ImageView("/images/fallo.PNG"));
            dialogPane.getStylesheets().add("css/myDialogs.css");
            dialogPane.setId("dialogo");
            dialogPane.getScene().setFill(Color.TRANSPARENT);
            AlertFin.setHeaderText(null);
            AlertFin.setTitle("Fin Partida");
            AlertFin.setContentText("Has perdido.");
            AlertFin.showAndWait();
             
            intentosRestantes=0;
            this.setDisable(true);//Desactivamos el gridPane para no poder realizar ninguna acciÃ³n
            //textClick.setVisible(false);
            reinicio();

        }
    }
    
    /**
     * Muestra un alert cuando consigue emparejar todas las cartas.
     */
    public void finGanada(){
        System.out.println("fin partida ganada");
        timelineEsperaFin = new Timeline(
            new KeyFrame(Duration.seconds(1.000), (ActionEvent t) -> {
               ocultarImagenes();
 
            })
        );
        timelineEsperaFin.setCycleCount(1);
        timelineEsperaFin.play();
        
        AlertFin = new Alert(Alert.AlertType.INFORMATION);
        DialogPane dialogPane = AlertFin.getDialogPane();
        //dialogPane.setStyle("-fx-font: normal bold 15px 'serif',-fx-border-radius: 0 0 18 18 ");
        AlertFin.getDialogPane().setGraphic(new ImageView("/images/superar.PNG"));
        dialogPane.getStylesheets().add("css/myDialogs.css");
        dialogPane.setId("dialogo");
        AlertFin.setHeaderText(null);
        AlertFin.setTitle("Fin Partida");
        AlertFin.setContentText("Has Ganado.");
        AlertFin.showAndWait();
        intentosRestantes=0;
        this.setDisable(true);//Desactivamos el gridPane para no poder realizar ninguna acciÃ³n
        //textClick.setVisible(false);
        reinicio();
        
    }
    
    /**
     * llama a la clase control para crear un nuevo array y reiniciar todas las variables necesarias.
     */
    public void reinicio(){
        control= new Control();
        //textClick.setVisible(true);
        //System.out.println("nivel de dificultad " + PanelLateral.continuidad);
        intentosRestantes=5;
        cuentaAtras = 4;
        ocultarImagenes();
        muestraImagenesInicio(control);
        PanelLateral.nivelDifi.setDisable(false);
        PanelLateral.nivelDifi.getSelectionModel().select("Medio");
        PanelLateral.ButtonInicio.setDisable(false);
       
        
        
    }
    
    public void eliminarCartas(){
        
        for(int x=0; x<=23;x++){   
            this.getChildren().remove(x);
        }  
        //this.getChildren().size();

        System.out.println(this.getChildren().size());

    }

}
