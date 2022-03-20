/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.adriansoriagarcia.proyectofinaljavafxii;

import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

/**
 *
 * @author usuario
 */
public class MenuPrincipal extends Pane{
    Button ButtonContinuar;//Declaración de boton continuar.
    public MenuPrincipal(){
        ButtonContinuar = new Button("Continuar");
        ButtonContinuar.setLayoutX(300);
        ButtonContinuar.setLayoutY(250);
        ButtonContinuar.setMinSize(150,100);
        
        Text textDefinicion = new Text();//Declaración de text para expicar el juego.
        textDefinicion.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 15));
        textDefinicion.setTextAlignment(TextAlignment.CENTER);
        textDefinicion.setLayoutY(50);
        textDefinicion.setLayoutX(10);
        textDefinicion.setText("Juego de memoria es un juego de mesa con una baraja de cartas específicas."
                + "\n El objetivo consiste en encontrar los pares con la misma figura impresa utilizando\n la memoria.");
        
        Text nombreDesarrollador = new Text();//Declaración de text para nombre del desarrollador.
        nombreDesarrollador.setLayoutX(210);
        nombreDesarrollador.setLayoutY(550);
        nombreDesarrollador.setText("Desarrollado por: Adrián Soria García.");
        nombreDesarrollador.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 15));
        nombreDesarrollador.setTextAlignment(TextAlignment.CENTER);
        
        this.getChildren().add(ButtonContinuar);//añadir el boton al panel.
        this.getChildren().add(textDefinicion);//añadir el textDefinicion al panel.
        this.getChildren().add(nombreDesarrollador);//añadir el nombreDesarrollador al panel.
        
        ButtonContinuar.setOnAction((t) -> {
            Iniciar();//LLamada al método iniciar.
            ButtonContinuar.setVisible(false);//ocultar el boton.
            textDefinicion.setVisible(false);//ocultar el textDefinicion.
            nombreDesarrollador.setVisible(false);//ocultar el nombreDesarrollador.
            
        });
        
        
    }
    
    public void Iniciar(){
        Tablero tablero = new Tablero();
        tablero.setLayoutX(10);
        tablero.setLayoutY(10);
        this.getChildren().add(tablero);
        
        PanelLateral panel = new PanelLateral();
        panel.setLayoutX(600);
        panel.setLayoutY(140);
        this.getChildren().add(panel);
    }
    
}
