/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.adriansoriagarcia.proyectofinaljavafxii;

/**
 *
 * @author usuario
 */

//recorre el array de numeros y dependiendo del valor de cada posición coloca una imagen en grindpanel
public class Tablero {

    public Tablero() {
       for(int x=0; x<Control.tamXTablero;x++){   
        for(int y=0; y<Control.tamYTablero;y++){
            Control.tablero[x][y]= '0';
            System.out.println(Control.tablero[x][y]);
        }
       } 
        
    }
    
}
