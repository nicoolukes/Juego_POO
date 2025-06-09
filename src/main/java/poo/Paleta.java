package poo;
import java.awt.Graphics2D;
import java.awt.Color;
public class Paleta extends ObjetoGrafico {

    //completar
   // protected int posX;
    //protected int posY;

    private final double velocidadPaddle = 500;
    


    public Paleta(Color Cpaleta, double X, double Y){
        super(Cpaleta, (int) X, (int) Y,10,100);
        //this.posX = (int)posX;
        //this.posY = (int)posY;
        
    }

    public void moverArriba(double delta){
        setY(getY() - velocidadPaddle * delta );


    }

    public void moverAbajo(double delta){
        setY(getY() + velocidadPaddle * delta);
    }




    //@Override
    public void draw(Graphics2D g){
        g.setColor(color);
        g.fillRect((int)getX(),(int)getY() , 10, 100);
    }
    @Override
    public String toString(){
        return "paleta x:"+x+" y:"+y ;
    }

    

    
    
    
}
