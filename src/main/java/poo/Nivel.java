package poo;

import java.awt.Graphics2D;

import com.entropyinteractive.Mouse;
public abstract class  Nivel {
    //completar
   
    public Nivel(){

    }

    //public abstract void inicializarNivel();
    public abstract void logicaNivel(double delta, Mouse mouse);
    public abstract void drawNivel(Graphics2D g2);
    public abstract void finalNivel();
}
