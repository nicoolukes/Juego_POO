package poo;

import java.awt.image.BufferedImage;

public abstract class Habilidades extends ObjetoGrafico {

    // Atributos comunes para todas las habilidades
    protected String nombre;
    
   

    // Constructor
    public Habilidades(String nombre) {
        this.nombre = nombre;
        
    }
    public Habilidades(int x, int y, int width, int height) {
        super(x, y, width, height);
        
    }


    // Métodos abstractos que deben ser implementados por las subclases
    public abstract void activarHabilidad(PerLemmings lemming);
    public abstract void activarHabilidad(PerLemmings lemming, Terreno terreno);

    public abstract BufferedImage getImg();

   
    
    
}
