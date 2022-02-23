
package es.adriansoriagarcia.proyectofinaljavafxii;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class Carta extends ImageView {
    
    
    //Método constructor Casilla
    public Carta(byte numCarta){
        Image carta = new Image(getClass().getResourceAsStream("/images/"+numCarta+".PNG"));
        this.setImage(carta);
    }
    
    
    
}