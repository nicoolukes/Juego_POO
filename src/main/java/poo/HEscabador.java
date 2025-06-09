package poo;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
public class HEscabador extends Habilidades {

    public HEscabador() {
        super("Escabador");
    }
    
    public HEscabador(int x, int y, int width, int height) {
        super(x, y, width, height);
        //super("Escabador");
    }

    @Override
    public void activarHabilidad(PerLemmings lemming, Terreno terreno) {
        // El lemming escava hacia abajo
        int fila =(lemming.y + lemming.height)/ terreno.sizeCelda;
        int colum = lemming.x / terreno.sizeCelda;
        if(fila < terreno.getMapa().length && colum < terreno.getMapa()[0].length){
            if(terreno.getMapa()[fila][colum] != 0){
                terreno.eliminarTile(fila,colum);
            }
        }
        //lemming.velocidadY = 1; // Aumenta la velocidad hacia abajo
        //lemming.velocidadX = 0; // Asegura que no se mueva horizontalmente
       


        //lemming.estado = "escavando"; // Cambia el estado del lemming a escavando
    }

    @Override
    public BufferedImage getImg() {
        BufferedImage escabador = null;
        try {
            escabador = ImageIO.read(getClass().getResource("ImgLemming/escabador.png"));
        } catch (Exception e) {
            System.out.println("Error al cargar la imagen de escabador: " + e.getMessage());
        }
        return escabador;
    }




    @Override
    public void activarHabilidad(PerLemmings lemming) {
        
    }
    
    
    
}
