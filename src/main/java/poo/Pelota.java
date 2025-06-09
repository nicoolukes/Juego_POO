package poo;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Pelota extends ObjetoGrafico {

    //completar
    public double velocidadPelotaX = 5;
    public double velocidadPelotaY = 5;
    private boolean fueraIzq = false;
    private boolean fueraDer = false;

    public Pelota(Color Cpelota, double x, double y){
        super(Cpelota, (int) x,(int) y, 20, 20);
    }

    //@Override
    public void draw(Graphics2D g){
        g.setColor(this.color);
        g.fillOval(x, y, 15, 15);

    }

    public void moverPelota(int maxX, int maxY){
        super.setX(getX() + velocidadPelotaX);
        super.setY(getY() + velocidadPelotaY);

        if(getY() >= maxY-25){
            velocidadPelotaY= -velocidadPelotaY;
        }

        if(getY() <= 25){
            velocidadPelotaY = -velocidadPelotaY;
        }

        if(getX() <= 0){
            fueraIzq= true;
        }

        if(getX() >= maxX){
            fueraDer = true;
        }
    }

    public boolean getFueraIzq(){
        return fueraIzq;
    }

    public boolean getFueraDer(){
        return fueraDer;
    }

    public void setFueraIzq(){
        fueraIzq = false;
    }

    public void setFueraDer(){
        fueraDer = false;
    }

    public void invertirMovX(){
        velocidadPelotaX *= -1;
        setX(getX() + 2 * velocidadPelotaX);
    }

    public void invertirMovY(){
       velocidadPelotaY *= -1;
    }

    public void detenerPelota(){
        velocidadPelotaX = 0;
        velocidadPelotaY = 0;
    }

    public void setVelociPeloX(int velocidadPelotaX){
        this.velocidadPelotaX= velocidadPelotaX;
    }

    public void setVelociPeloY(int velocidadPelotaY){
        this.velocidadPelotaY = velocidadPelotaY;
    }
   
   
}
