/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.adriansoriagarcia.proyectofinaljavafxii;

import javafx.scene.layout.GridPane;

/**
 *
 * @author usuario
 */

//Recorre el array de numeros y dependiendo del valor de cada posición coloca una imagen en grindpanel
public class Tablero extends GridPane {
    
    public Tablero() {
       for(int x=0; x<Control.tamXTablero;x++){   
        for(int y=0; y<Control.tamYTablero;y++){
            Carta carta = new Carta((byte)Control.tablero[x][y]);
            this.add(carta,x,y);
        }
       } 
        
    }
    
}
