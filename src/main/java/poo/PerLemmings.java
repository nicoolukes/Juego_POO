package poo;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class PerLemmings extends ObjetoGrafico {
    private BufferedImage personaje;
    public int velocidadY , velocidadX= 1;
    public Rectangle areaColision;
    public boolean enSuelo, esPared = false;
    private final int gravedad = 1;
    private final int velocidadMax = 1;
    public  boolean estaQuieto = false;
    //public int x, y, width, height;

    
    

    //completar

    public PerLemmings(){

    }
    public PerLemmings(int x, int y, int width, int height){
        //completar
        super(x, y, 16,16);
        /*this.x = x;
        this.y = y;
        this.width= width;
        this.height=height;*/
        //areaColision =new Rectangle(x,y,16,16);
        getPersonaje();
    }
    public void actualizar() {
        if (!enSuelo) {
            velocidadY += gravedad;
            if (velocidadY > velocidadMax){
                velocidadY = velocidadMax;
            } 
        }
        y = y + velocidadY;
        if (enSuelo) {
            velocidadY = 0;
            
            if(!esPared){
                x = x + velocidadX;
            }else {
                x = x - velocidadX;
            }
        }

        


    }

   


    public void getPersonaje(){
        try {
            personaje= ImageIO.read(getClass().getResourceAsStream("ImgLemming/PLemming.png"));

        } catch (Exception e) {
            System.out.println("Hay error en PerLemmings" + e);
        }
    }
    public void draw(Graphics2D g2){
        //g2.drawRect(x, y, 16, 16);
        
        g2.drawImage(personaje,x,y,16,16,null );
        
        
    }
   

   


    
}
