package poo;

import java.awt.Color;
import java.awt.Rectangle;
import java.awt.Graphics2D;

public class ObjetoGrafico extends Rectangle{

    //completar
    protected Color color;
       
    protected int width;    
    protected int height;   
    
    public ObjetoGrafico(Color color, int x, int y, int width, int height) {
        super(x, y, width, height);
        this.color= color;
    }
    public ObjetoGrafico(int x, int y, int width, int height) {
        super(x, y, width, height);
    }
    
    public ObjetoGrafico(){
    }


    /*public void draw(Graphics2D g){
        g.setColor(color);
        g.fillRect(x, y, 10, 100);

    }*/


    public void setX(double x){
        this.x = (int) x;
    }

    public void setY(double y){
        this.y = (int) y;
    }

    public void setPos(double x, double y){
        this.x = (int) x;
        this.y = (int) y;
    }
    
}