/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.adriansoriagarcia.proyectofinaljavafxii;

import java.util.Random;

/**
 *
 * @author adrián
 */
public class Control {
    static short tamXTablero;
    static short tamYTablero;            
    static int [][] tablero;
    static char [][] encontrado;
    final char VACIO= 0;
    final char SIPAREJA= 'S';
    final char NOPAREJA= 'N';
    int aleatorioFilas;
    int aleatorioColumnas;
    int aleatorioFilas1;
    int aleatorioColumnas1;
    boolean finPartida = false;
    char turnoJugador = JUGADOR1;
    static final char JUGADOR1 = '1';
    static final char JUGADOR2 = '2';

    //Método constructor
    public Control(){
        tamXTablero = 4;
        tamYTablero = 4;
        int canNumeros= 9;
        int numRepeticiones=2;
        tablero = new int [tamXTablero][tamYTablero];
        encontrado = new char [tamXTablero][tamYTablero];
        Random random = new Random();
        
        //Bloque para generación de aleatorios array tablero
        for(int i=1; i<canNumeros; i++){
            for(int x=0; x<numRepeticiones; x++){
                aleatorioFilas = random.nextInt(tamXTablero);
                aleatorioColumnas = random.nextInt(tamYTablero);
                if(tablero[aleatorioColumnas][aleatorioFilas] == VACIO){
                    tablero[aleatorioColumnas][aleatorioFilas]= i;
                } else {
                    do {
                        aleatorioColumnas1 = random.nextInt(tamXTablero);
                        aleatorioFilas1 = random.nextInt(tamYTablero);

                    }
                    while(tablero[aleatorioColumnas1][aleatorioFilas1] != VACIO );
                    tablero[aleatorioColumnas1][aleatorioFilas1]=i;
                }
            }
        } 
        
        //Bloque para generación array parejas encontradas
        for(int x=0; x<tamXTablero;x++){
            for(int y=0; y<tamYTablero; y++){
                encontrado[x][y] = NOPAREJA; 
            }
        }
        
    }
    
    public Control(short tamX, short tamY){
        tamXTablero = tamX;
        tamYTablero = tamY;  
        int canNumeros= tamXTablero * tamYTablero / 2 + 1;
        System.out.println(canNumeros);
        int numRepeticiones=2;
        tablero = new int [tamXTablero][tamYTablero];
        encontrado = new char [tamXTablero][tamYTablero];
        Random random = new Random();
        
        //Bloque para generación de aleatorios array tablero
        for(int i=1; i<canNumeros; i++){
            for(int x=0; x<numRepeticiones; x++){
                aleatorioFilas = random.nextInt(tamXTablero);
                aleatorioColumnas = random.nextInt(tamYTablero);
                if(tablero[aleatorioColumnas][aleatorioFilas] == VACIO){
                    tablero[aleatorioColumnas][aleatorioFilas]= i;
                } else {
                    do {
                        aleatorioColumnas1 = random.nextInt(tamXTablero);
                        aleatorioFilas1 = random.nextInt(tamYTablero);

                    }
                    while(tablero[aleatorioColumnas1][aleatorioFilas1] != VACIO );
                    tablero[aleatorioColumnas1][aleatorioFilas1]=i;
                }
            }
        } 
        
        //Bloque para generación array parejas encontradas
        for(int x=0; x<tamXTablero;x++){
            for(int y=0; y<tamYTablero; y++){
                encontrado[x][y] = NOPAREJA; 
            }
        }
        
    }
   
    
    public void mostrarTableroConsola(){
        for(int y=0; y<tamYTablero; y++){   
            for(int x=0; x<tamXTablero;x++){
                System.out.print(encontrado[x][y]);      
            }
            System.out.println();
        }
        System.out.println();
        for(int y=0; y<tamYTablero; y++){   
            for(int x=0; x<tamXTablero;x++){
                System.out.print(tablero[x][y]);      
            }
            System.out.println();
        }
        System.out.println();
    }
    
    public boolean buscarPareja(int posXcarta1,int posYcarta1, int posXcarta2,  int posYcarta2) {     
       //retorna true si coninciden las parejas de cartas o false si no coincide
        //System.out.println("Xcarta1 " + posXcarta1);
        //System.out.println("Ycarta1 " + posYcarta1);
        //System.out.println("Xcarta2 " + posXcarta2);
        //System.out.println("Ycarta2 " + posYcarta2);
        System.out.println("carta1 " + tablero[posXcarta1][posYcarta1]);
        System.out.println("carta 2 " + tablero[posXcarta2][posYcarta2]);
        mostrarTableroConsola();
       if(tablero[posXcarta1][posYcarta1] == tablero[posXcarta2][posYcarta2]){
            encontrado[posXcarta1][posYcarta1] = SIPAREJA; 
            encontrado[posXcarta2][posYcarta2] = SIPAREJA;
           return true;
           
       }
       return false;
    }  
    
    public void cambiarTurnoJugador() {
        if(turnoJugador == JUGADOR1) {
            turnoJugador = JUGADOR2;
        } else {
            turnoJugador = JUGADOR1;
        }
    }
    
    public boolean finPartida() {
        for(int x=0; x<tamXTablero; x++) {
            for(int y=0; y<tamYTablero; y++) {
                if(encontrado[x][y] == NOPAREJA) {
                    return false; 
                    
                }
            }
        }
        finPartida = true;
        return true;        
    }
}
