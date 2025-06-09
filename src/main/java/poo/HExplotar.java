package poo;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
public class HExplotar extends Habilidades {

    public HExplotar() {
        super("Explotar");
    }

    public HExplotar(int x, int y, int width, int height) {
        super(x, y, width, height);
        //super("Explotar");
    }

    @Override
    public void activarHabilidad(PerLemmings lemming) {
        // El lemming explota, causando daño a los enemigos cercanos
       // lemming.explotar();
        // Aquí podrías agregar lógica para eliminar el lemming o causar efectos adicionales
    }

    @Override
    public BufferedImage getImg() {
        BufferedImage explotar = null;
        try {
            explotar = ImageIO.read(getClass().getResource("ImgLemming/explotar.png"));
        } catch (Exception e) {
            System.out.println("Error al cargar la imagen de explotar: " + e.getMessage());
        }
        return explotar;
    
    }


    @Override
    public void activarHabilidad(PerLemmings lemming, Terreno terreno) {
        // Implementar la lógica para explotar en el terreno
        // Aquí podrías agregar el código que permita al lemming explotar algo en el terreno
        // Por ejemplo, podrías modificar el mapa del terreno para eliminar tiles cercanos.
        
        // Ejemplo de pseudocódigo:
        // int fila = (lemming.getPosY() + lemming.getHeight()) / terreno.sizeCelda;
        // int columna = lemming.getPosX() / terreno.sizeCelda;
        // terreno.explotarEn(fila, columna);
        
        System.out.println("El lemming está explotando en el terreno.");
    }
}
