package poo;
import java.awt.Color;
import java.awt.Graphics2D;
public class BarraHabilidad extends ObjetoGrafico {
    public Habilidades[] habilidades;
    private int habilidadActual;
    private int habilidadY = 515;
    private int habilidadX = 20;
    private int habilidadAncho = 40;
    private int habilidadAlto = 60;
    
   

    public BarraHabilidad() {
        //this.habilidades = habilidades;
    
        this.habilidadActual = 0; // Comienza con la primera habilidad
        habilidades = new Habilidades[] {
            new HQuieto(habilidadX, habilidadY, habilidadAncho, habilidadAlto),
            new HEscabador(habilidadX +50, habilidadY, habilidadAncho, habilidadAlto),
            new HConstruir(habilidadX + 100, habilidadY, habilidadAncho, habilidadAlto),
            new HExplotar(habilidadX + 150, habilidadY, habilidadAncho, habilidadAlto)
        
        };
        
        
    
    }

    public int getHabilidadIndexAt(int mouseX, int mouseY) {
        for (int i = 0; i < habilidades.length; i++) {
            Habilidades h = habilidades[i];
            if (mouseX >= h.x && mouseX <= h.x + h.width &&
                mouseY >= h.y && mouseY <= h.y + h.height) {
                return i;
            }
        }
        return -1;
    }



   

    public void draw(Graphics2D g2, int habilidadSeleccionada) {
        
        int i = 0;
        for (i=0; i < 4; i++) {
            g2.setColor(Color.WHITE);
            //int x = habilidades[i].x + i * (habilidades[i].width);
            if (i == habilidadSeleccionada) {
                g2.setColor(Color.YELLOW); // Resaltar la habilidad seleccionada
            } else {
                g2.setColor(Color.WHITE); // Color normal para las demás habilidades
            }

            g2.drawRect(habilidades[i].x, habilidades[i].y, habilidades[i].width, habilidades[i].height);
            g2.drawString("" + 5, habilidades[i].x+15, habilidades[i].y+15);
            g2.drawImage(habilidades[i].getImg(), habilidades[i].x+10, habilidades[i].y+45,null);
           
        }

       

    }
}
