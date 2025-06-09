package poo;

import java.awt.Graphics2D;
import java.util.ArrayList;

import com.entropyinteractive.Mouse;

public class Nivel1 extends Nivel {
    
    private double tiempoDesdeUltimoLemming = 0;
    protected double intervaloCreacion = 1;
    private int lemmingsCreados = 0;
    private int totalLemmings;
    private int x;
    private int y;
    Terreno terreno;
    public ArrayList<PerLemmings> lemming;
    //private ArrayList<Habilidades> habilidades;
    private GesColisiones colisiones;
    private PerLemmings personajeSeleccionado;
    boolean mousePressedLastFrame = false;
    private Habilidades[] habilidad;
    private BarraHabilidad BHabilidades;
    private int cantHabili = 0;
    private int habilidadSeleccionada = -1; // -1 significa que no hay habilidad seleccionada
    private boolean botonPress = false;
    private int habilidadActual = -1; // -1 significa que no hay habilidad seleccionada
    
    

    
    public Nivel1(){
        x=330;
        y=155;
        terreno = new Terreno("src//main//resources//poo//ImgLemming//terrenoMatriz.txt", 16);
        totalLemmings = 5;
        lemming = new ArrayList<>();
       // habilidad= new Habilidades[4];
    
        colisiones = new GesColisiones(terreno);
        
        BHabilidades = new BarraHabilidad();
        
       

    }

    @Override
    public void drawNivel(Graphics2D g2){
        terreno.draw(g2);
        for (PerLemmings l : lemming) {
            l.draw(g2);
        }
        if (personajeSeleccionado != null) {
            g2.setColor(java.awt.Color.RED);
            g2.drawRect(personajeSeleccionado.x, personajeSeleccionado.y, personajeSeleccionado.width, personajeSeleccionado.height);
        }
        BHabilidades.draw(g2, habilidadSeleccionada);

    }

    @Override
    public void logicaNivel(double delta, Mouse mouse) {

        int mouseX = mouse.getX()-2;
        int mouseY = mouse.getY()+23;

        boolean mousePressed = mouse.isLeftButtonPressed();
       
        tiempoDesdeUltimoLemming += delta;

        if (lemmingsCreados < totalLemmings && tiempoDesdeUltimoLemming >= intervaloCreacion) {
            PerLemmings nuevo = new PerLemmings(x, y, 16, 16); // posición inicial
            lemming.add(nuevo);
            lemmingsCreados++;
            tiempoDesdeUltimoLemming = 0;
            System.out.println("se creo un personaje"); 
        } 
        


        colisiones.aplicarColisiones(lemming);
        colisiones.aplicarColisionQ(lemming);
        for (PerLemmings l : lemming) {
            l.actualizar();
        }

        if (mousePressed && !mousePressedLastFrame) {
            int idx = BHabilidades.getHabilidadIndexAt(mouseX, mouseY);
            if (idx != -1) {
                habilidadSeleccionada = (habilidadSeleccionada == idx) ? -1 : idx;
            } else {
                // Selección de lemming
                personajeSeleccionado = null;
                for (PerLemmings l : lemming) {
                    if (mouseX >= l.x && mouseX <= l.x + l.width &&
                        mouseY >= l.y && mouseY <= l.y + l.height) {
                        personajeSeleccionado = l;
                        break;
                    }
                }
            }


            
        }
        mousePressedLastFrame = mousePressed;

        if (habilidadSeleccionada != -1 && personajeSeleccionado != null) {
            Habilidades habilidad = BHabilidades.habilidades[habilidadSeleccionada];
           switch (habilidadSeleccionada) {
                case 0:

                    habilidad.activarHabilidad(personajeSeleccionado);
                    break;

                case 1:
                    habilidad.activarHabilidad(personajeSeleccionado, terreno);

                    break;
               default:
                   throw new AssertionError();
           }
            
            habilidad.activarHabilidad(personajeSeleccionado, terreno);
            //System.out.println(" Habilidad activada: " + per);
            
            
                
            
        }
        
    }

    @Override
    public void finalNivel(){

    }

    public PerLemmings getLemmings(){
        return lemming.get(0);
    }



   

   
}
