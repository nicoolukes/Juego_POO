package poo;


import java.awt.Graphics2D;

import com.entropyinteractive.JGame; // todo de  BucleJuego

public class JPong extends JGame {
    // atributos

    Paleta paddle1;
    Paleta paddle2;
    Pelota ball;
    
    //constructor
    public JPong(){ 

        super("Pong", 1024, 768);
    }


    //>>>>>>>>>>>>>>>> metodos de JGame

    @Override
    public void gameStartup(){
        //completar
    }
    
    @Override
    public void gameUpdate( double delta){
        //completar
    }

    @Override
    public void gameDraw(Graphics2D g2){
        //completar
    }

    @Override
    public void gameShutdown(){
        //completar
    }

    //>>>>>>>>>>>>>>>>>>> terminan los metodos de JGame



    
}
