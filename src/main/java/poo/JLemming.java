package poo;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
 
import javax.imageio.ImageIO;

import com.entropyinteractive.JGame;
import com.entropyinteractive.Mouse;

public class JLemming extends JGame{

    BufferedImage puerta, salida = null;
    //Terreno terreno;
    Nivel1 n1;
    ArrayList<PerLemmings> lemmings;
    //private PerLemmings personajeSeleccionado;

    //private boolean mousePressedLastFrame = false;
   

    public JLemming(){
        super("Lemmings", 768, 576); //getwhit = 782 getHeight = 589 REAl
        
        /*addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                int mouseX = e.getX();
                int mouseY = e.getY();

                personajeSeleccionado = null; // Deseleccionar anterior

                for (PerLemmings l : lemmings) {
                    Rectangle rect = new Rectangle(l.x, l.y, l.width, l.height);
                    if (rect.contains(mouseX, mouseY)) {
                        personajeSeleccionado = l;
                        System.out.println("Seleccionado personaje en: " + l.x + ", " + l.y);
                        break;
                    }
                }
            }
        });*/
        
    }

    @Override
    public void gameStartup(){
        //completar
        //terreno = new Terreno();
        n1= new Nivel1();
        lemmings = n1.lemming; // Obtener la lista de lemmings del nivel
        System.out.println("Cantidad de lemmings: " + lemmings.size());
        try{
            puerta = ImageIO.read(getClass().getResource("ImgLemming/Puerta.png"));
            salida = ImageIO.read(getClass().getResource("ImgLemming/salida.png"));
        }catch(Exception e){

        }

        
    }
    
    @Override
    public void gameUpdate(double delta){
        //completar
        Mouse mouse = this.getMouse();
        n1.logicaNivel(delta, mouse);
        lemmings = n1.lemming; 
       
        // Actualizar el estado del botón del mouse
        
    }

    @Override
    public void gameDraw(Graphics2D g2){
        //comoletar
       
        //terreno.draw(g2);
        g2.drawImage(puerta, 300, 150, null);
        g2.drawImage(salida, 600, 450, null);
       

        n1.drawNivel(g2);
      //lemming.draw(g2);
       /*  if (personajeSeleccionado != null) {
            g2.setColor(Color.RED);
            g2.drawRect(personajeSeleccionado.x, personajeSeleccionado.y, personajeSeleccionado.width, personajeSeleccionado.height);
        }*/
        
    }


    @Override
    public void gameShutdown(){

    }
   
}
