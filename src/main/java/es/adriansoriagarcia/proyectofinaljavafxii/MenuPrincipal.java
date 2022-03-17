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
    Button ButtonInicio;
    public MenuPrincipal(){
        ButtonInicio = new Button("Continuar");
        ButtonInicio.setLayoutX(300);
        ButtonInicio.setLayoutY(250);
        ButtonInicio.setMinSize(150,100);
        
        Text text = new Text();
        text.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 15));
        text.setTextAlignment(TextAlignment.CENTER);
        text.setLayoutY(50);
        text.setLayoutX(10);
        text.setText("Juego de memoria es un juego de mesa con una baraja de cartas específicas."
                + "\n El objetivo consiste en encontrar los pares con la misma figura impresa utilizando\n la memoria.");
        
        Text nombre = new Text();
        nombre.setLayoutX(210);
        nombre.setLayoutY(550);
        nombre.setText("Desarrollado por: Adrián Soria García.");
        nombre.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 15));
        nombre.setTextAlignment(TextAlignment.CENTER);
        
        this.getChildren().add(ButtonInicio);
        this.getChildren().add(text);
        this.getChildren().add(nombre);
        
        ButtonInicio.setOnAction((t) -> {
            Iniciar();
            ButtonInicio.setVisible(false);
            text.setVisible(false);
            nombre.setVisible(false);
            
        });
        
        
    }
    
    public void Iniciar(){
        Tablero tablero = new Tablero();
        tablero.setLayoutX(10);
        tablero.setLayoutY(10);
        this.getChildren().add(tablero);
        
        PanelLateral panel = new PanelLateral();
        panel.setLayoutX(600);
        panel.setLayoutY(180);
        this.getChildren().add(panel);
    }
    
}
