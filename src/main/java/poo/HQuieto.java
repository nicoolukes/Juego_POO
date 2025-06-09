package poo;

import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class HQuieto extends Habilidades{
    private boolean activo =false;
    

    public HQuieto(int habilidadX, int habilidadY, int habilidadAncho, int habilidadAlto) {
        super(habilidadX, habilidadY, habilidadAncho, habilidadAlto);
        //super("Quieto");
    }

    @Override
    public void activarHabilidad(PerLemmings lemming) {
        // No hace nada, el lemming se queda quieto
        lemming.velocidadX = 0; // Aseguramos que no se mueva
        lemming.estaQuieto = true;
        activo = true; // Marcamos la habilidad como activa
       
    }

    public boolean isActivo() {
        return activo;
    }



    @Override
    public BufferedImage getImg(){
        BufferedImage quieto= null;
        try {
            quieto = ImageIO.read(getClass().getResource("ImgLemming/quieto.png"));
            //return quieto;
        } catch (Exception e) {
            System.out.println("Error al cargar la imagen de quieto: " + e.getMessage());
        }
        return quieto;
    }

    @Override
    public void activarHabilidad(PerLemmings lemming, Terreno terreno) {
       
    }
    
}
