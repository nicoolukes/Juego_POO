package poo;
import java.awt.image.BufferedImage;
public class Tile  {

    public BufferedImage imagen;
    public boolean esSolido = false; // false si el lemming no puede pasar
    public String tipo;

    public Tile(BufferedImage imagen, boolean esSolido){
        this.imagen = imagen;
        this.esSolido = esSolido;
    }

 
}
