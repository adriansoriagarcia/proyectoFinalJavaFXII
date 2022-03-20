
package es.adriansoriagarcia.proyectofinaljavafxii;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class Carta extends ImageView {

    static final int TAM_CARTA=140;//constante para el tamaño de la carta.
    //Método constructor Casilla
    /**
    * Selecciona la imágen dependiendo del numcarta correspondiente
    * @param numCarta es el numero correspondiente a su nombre
    */
    public Carta(byte numCarta){
        //System.out.println(numCarta);
        Image carta = new Image(getClass().getResourceAsStream("/images/"+numCarta+".PNG"));
        this.setImage(carta);
    }
     
}
