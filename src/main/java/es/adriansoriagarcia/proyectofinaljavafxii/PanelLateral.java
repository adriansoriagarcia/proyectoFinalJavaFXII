/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.adriansoriagarcia.proyectofinaljavafxii;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

/**
 *
 * @author usuario
 */
public class PanelLateral extends VBox{
    
    static Label labelCuentaAtras;//Declaración de label para la cuenta atras.
    static Text textTiempo;//Declaración de text que contiene el tiempo restante.
    static Text texTitleTempo;//Declaración de text que contiene el texto "tiempo".
    static Text textClick;//Declaración de text que contiene los click restantes.
    static Text texClickRestante;//Declaración de text que contiene el texto "intentos".
    final int TEXT_SIZE = 24;//Declaración e inicialización de usada para el tamaño de letra de los text. 
    static int selectedNivel;//Indice del nivel de dificultad.
    static ChoiceBox<String> nivelDifi;//Declaración de choicebox con los diferentes niveles de dificultad.
    static Button ButtonInicio;//Declaración botón de incio partida.
    static Button btnStart;//Declaración botón de activar sonido.
    static Button btnPause;//Declaración botón de desactivar sonido.
    
    /*
     * Metodo constructor de la clase PanleLateral.
    */
    public PanelLateral(){
        this.setAlignment(Pos.CENTER);//Posición centrada del panel.
        //----------------------------------------------------------------------
            //BOTONES SONIDO
        //----------------------------------------------------------------------
        
        btnStart.setGraphic(new ImageView("/images/sound.PNG"));
        btnPause.setGraphic(new ImageView("/images/mute.PNG"));
        this.getChildren().addAll(btnStart,btnPause);
        //----------------------------------------------------------------------
        nivelDifi = new ChoiceBox<>();
        nivelDificultad();
        layoutPanel();
        //----------------------------------------------------------------------
            //BOTON INICION
        //----------------------------------------------------------------------
        ButtonInicio.setMaxSize(100,50);
        this.getChildren().add(ButtonInicio);
        //this.getStylesheets().add("/stylesheet.css");
        this.setId("panel");
        //this.setStyle("-fx-font: normal bold 15px 'serif' ");
        //----------------------------------------------------------------------

    }
    
    /*
     * seleccion del nivel de dificultar deseado..
    */
    private void nivelDificultad(){
        //----------------------------------------------------------------------
            //CHOICEBOX OPCIONES
        //----------------------------------------------------------------------
        
        nivelDifi.getSelectionModel().select("Medio");

        nivelDifi.getItems().add("Facil");
        nivelDifi.getItems().add("Medio");
        nivelDifi.getItems().add("Dificil");
        
        nivelDifi.setOnAction((evento) -> {
        selectedNivel = nivelDifi.getSelectionModel().getSelectedIndex();
        String  selectedItem  = nivelDifi.getSelectionModel().getSelectedItem();
        //System.out.println("Selección realizada: [" + selectedNivel + "] " +selectedItem );
            switch (selectedNivel) {
                case 0:
                    System.out.println("nivel facil");
                    Tablero.intentosRestantes=20;
                    textClick.setText(String.valueOf(Tablero.intentosRestantes));
                    break;
                case 1:
                    System.out.println("nivel medio");
                    Tablero.intentosRestantes=15;
                    textClick.setText(String.valueOf(Tablero.intentosRestantes));
                    break;
                case 2:
                    System.out.println("nivel dificil");
                    Tablero.intentosRestantes=10;
                    textClick.setText(String.valueOf(Tablero.intentosRestantes));
                    break;
                default:
                    break;
            }
        });
        
        this.getChildren().add(nivelDifi);
        
    }
    
    /*
     * Muestra los intentos restantes y el tiempo de la cuenta atras.
    */
    private void layoutPanel(){
        this.setSpacing(10);//Espacio entre componentes.
        //Texto de etiqueta para tiempo
        texTitleTempo = new Text("Tiempo:");
        texTitleTempo.setFont(Font.font(TEXT_SIZE));
        texTitleTempo.setFill(Color.BLACK);
        //Texto para el tiempo restante
        textTiempo = new Text("4");
        textTiempo.setFont(Font.font(TEXT_SIZE));
        textTiempo.setFill(Color.BLACK);
        this.getChildren().add(texTitleTempo);
        this.getChildren().add(textTiempo);

        //-------------------------------------------------
        //Texto de etiqueta para intentos
        texClickRestante = new Text("Intentos:");
        texClickRestante.setFont(Font.font(TEXT_SIZE));
        texClickRestante.setFill(Color.BLACK);
        //Texto para intentos restante
        textClick = new Text("15");
        textClick.setFont(Font.font(TEXT_SIZE));
        textClick.setFill(Color.BLACK);
        this.getChildren().add(texClickRestante);
        this.getChildren().add(textClick);
          
    }
    
}
