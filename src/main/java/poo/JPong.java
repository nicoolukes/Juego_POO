package poo;

//falta controlar que se termine cuando llegue a 10
//reiniciar contador
// anunciar ganador
// configuracion 

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Stroke; //imagenes
import java.awt.event.KeyEvent;

import com.entropyinteractive.JGame;
import com.entropyinteractive.Keyboard;
import com.entropyinteractive.Log;

public class JPong extends JGame {


    // atributos
    Paleta paddle1;
    Paleta paddle2;
    Pelota ball;
    Color Cpaleta1;
    Color Cpaleta2;
    Color Cpelota;
   
    int AnchoVentana=600;
    int AltoVentana=800;
    Color colorFondo;
    Jugador j1 = new Jugador();
    Jugador j2 = new Jugador();
    boolean gameover = false;
    String mensaje = "";    

    public JPong(int AnchoVentana, int AltoVentana, Color colorFondo, Color Cpaleta1, Color Cpaleta2, Color Cpelota) 
     // Llamada al constructor de JGame con título y dimensiones
    {
        super("Pong", AnchoVentana, AltoVentana);
        this.colorFondo = colorFondo;
        this.Cpelota = Cpelota;
        this.Cpaleta1 = Cpaleta1;
        this.Cpaleta2 = Cpaleta2;
        
    }
    // fin costructores



    //>>>>>>>>>>>>>>>> metodos de JGame

    @Override
    public void gameStartup(){
        //completar
        try{

            paddle1 = new Paleta(Cpaleta1, 40, (this.getHeight()/2 - 50));
            paddle2 = new Paleta(Cpaleta2,this.getWidth()-49, this.getHeight()/2 - 50);
            ball = new Pelota(Cpelota, this.getWidth()/2, this.getHeight()/2);

        }catch(Exception e){

        }
        
    }
    
    @Override
    public void gameUpdate(double delta){
       

        //completar
        //boolean stop = true;
        Keyboard presiono = this.getKeyboard();

        ball.moverPelota(getWidth(), getHeight()); // Movimiento continuo de la pelota

        if (j1.getPuntos() == 5 || j2.getPuntos() == 5) {
            ball.detenerPelota();
            ball.setPos(getWidth() / 2, getHeight());
            mensaje = "¡Jugador 1 gana!";
            gameover = true;
        }
        if (gameover) {
            return; // No actualices más el juego
        }



        //movimiento de pelota
        ball.moverPelota(getWidth(), getHeight());
        if(ball.getFueraDer()){
            ball.invertirMovX();
            ball.setFueraDer();
            ball.setPos(getWidth()/2, getHeight()/2);
            j1.sumarPuntos();
        }

        if(ball.getFueraIzq()){
            ball.invertirMovX();
            ball.setFueraIzq();
            ball.setPos(getWidth()/2, getHeight()/2);
            j2.sumarPuntos();
        }
        
        //-------------------------------------------

        //movimiento de paleta
        if(presiono.isKeyPressed(KeyEvent.VK_UP) && paddle2.getY() >= 25 ){
            paddle2.moverArriba(delta);
        }

        if(presiono.isKeyPressed(KeyEvent.VK_DOWN) && paddle2.getY() <= getHeight()-100){
            paddle2.moverAbajo(delta);
        }

        if(presiono.isKeyPressed(KeyEvent.VK_S) && paddle1.getY() <= getHeight()-100){
            paddle1.moverAbajo(delta);
        }

         if(presiono.isKeyPressed(KeyEvent.VK_W) && paddle1.getY() >= 25  ){
            paddle1.moverArriba(delta);
        }
        //--------------------------------------------



        if( ball.intersects(paddle1)){ //colicion 
            ball.invertirMovX();
            //ball.setVelociPeloX(6);
            //ball.setVelociPeloY(6);


        }
        if(/*ball.velocidadPelotaX > 0 &&*/ ball.intersects(paddle2)){ //colicion
            ball.invertirMovX();
        }

        

        

    
    }

    @Override
    public void gameDraw(Graphics2D g2){
        
        //fondo
        g2.setColor(colorFondo);
        g2.fillRect(0, 0, getWidth(), getHeight());


        //linea en el medio
        g2.setColor(Color.WHITE);
        Graphics2D line = g2;
        Stroke dashed = new BasicStroke(10, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[] { 9 }, 0);
        line.setStroke(dashed);
        g2.drawLine(getWidth() / 2 , 0, getWidth() / 2 , getHeight());


        //puntaje
        g2.setFont(new Font("Press Start 2P", Font.BOLD, 70));
        String puntosJ1 = "" + j1.getPuntos();
        String puntosJ2 = "" + j2.getPuntos();
        int wJ1 = g2.getFontMetrics().stringWidth(puntosJ1);
        int wJ2 = g2.getFontMetrics().stringWidth(puntosJ2);
        g2.drawString(puntosJ1, getWidth() / 2 - 80 - wJ1/2, 120);
        g2.drawString(puntosJ2, getWidth() / 2 + 80 - wJ2/2, 120);
            
        //Mensaje centrado   
        g2.setFont(new Font("Press Start 2P", Font.BOLD, 35));
        int wMsg = g2.getFontMetrics().stringWidth(mensaje);
        int xMsg = (getWidth() - wMsg) / 2;
        g2.drawString(mensaje, xMsg, 300);

        ball.draw(g2);
        paddle1.draw(g2);
        paddle2.draw(g2);

      
    }
    //Registra un mensaje informando que el juego se está cerrando
    @Override
    public void gameShutdown(){
            Log.info(getClass().getSimpleName(), "Shutting down game");
    }

    //>>>>>>>>>>>>>>>>>>> terminan los metodos de JGame
}
