package poo;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
public class HConstruir extends Habilidades {

    public HConstruir() {
        super("Construir");
    }

    public HConstruir(int x, int y, int width, int height) {
        super(x, y, width, height);
    }

    @Override
    public void activarHabilidad(PerLemmings lemming) {
        // Implementar la lógica para construir un puente o plataforma
        // Aquí podrías agregar el código que permita al lemming construir algo
        // Por ejemplo, podrías crear un nuevo objeto de tipo Plataforma o similar
        // y añadirlo al entorno del juego.
        
        // Ejemplo de pseudocódigo:
        // Plataforma nuevaPlataforma = new Plataforma(lemming.getPosX(), lemming.getPosY());
        // entorno.addPlataforma(nuevaPlataforma);
        
        System.out.println("El lemming está construyendo algo.");
    }

    @Override
    public BufferedImage getImg() {
        BufferedImage construir = null;
        try {
            construir = ImageIO.read(getClass().getResource("ImgLemming/constructor.png"));
        } catch (Exception e) {
            System.out.println("Error al cargar la imagen de construir: " + e.getMessage());
        }
        return construir;
    }

    @Override
    public void activarHabilidad(PerLemmings lemming, Terreno terreno) {
        // Implementar la lógica para construir en el terreno
        // Aquí podrías agregar el código que permita al lemming construir algo en el terreno
        // Por ejemplo, podrías modificar el mapa del terreno para incluir una nueva estructura.
        
        // Ejemplo de pseudocódigo:
        // int fila = (lemming.getPosY() + lemming.getHeight()) / terreno.sizeCelda;
        // int columna = lemming.getPosX() / terreno.sizeCelda;
        // terreno.construirEn(fila, columna);
        
        System.out.println("El lemming está construyendo en el terreno.");
    }
    
}
