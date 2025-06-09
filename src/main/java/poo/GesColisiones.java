package poo;


import java.util.ArrayList;

public class GesColisiones {
    Terreno terreno;
    
    public GesColisiones(Terreno terreno){
        this.terreno = terreno;
    }

    public void aplicarColisiones( ArrayList<PerLemmings> lemmings){
        for(PerLemmings lemming : lemmings){
            aplicarColision(lemming);
        }
    }

    public void aplicarColision(PerLemmings lemming){
        int sizeCelda = terreno.sizeCelda;
        int[][] posTile= terreno.posTile;
        Tile[] tile = terreno.tile;

        //Determina la celda del terreno en la que se encuentra el lemming
        int izquierda = lemming.x / sizeCelda;
        int derecha = (lemming.x + lemming.width -1) /sizeCelda;
        int abajo = (lemming.y + lemming.height) / sizeCelda;



        if (abajo < posTile.length) {
            boolean colision = false;
            for (int i = izquierda; i <= derecha; i++) {
                if (i >= 0 && i < posTile[0].length && tile[posTile[abajo][i]].esSolido) {
                    colision = true;
                    break;
                }
                
            }
            if (colision) {
                lemming.y = abajo * sizeCelda - lemming.height;
                lemming.velocidadY = 0;
                lemming.enSuelo = true;
            } else {
                lemming.enSuelo = false;
            }
        }

        if(izquierda >=0 && izquierda < posTile[0].length && tile[posTile[lemming.y / sizeCelda][izquierda]].esSolido) {
            lemming.x = izquierda * sizeCelda + sizeCelda;
            lemming.velocidadX*= -1;
            lemming.esPared = true;
        }

        if(derecha >=0 && derecha < posTile[0].length && tile[posTile[lemming.y / sizeCelda][derecha]].esSolido) {
            lemming.x = derecha * sizeCelda - lemming.width;
            lemming.velocidadX*= -1;
            lemming.esPared =true;
        }
        
    }

   

    public void aplicarColisionQ(ArrayList<PerLemmings> lemming){
        for (PerLemmings quieto : lemming) {
            if (quieto.estaQuieto) {
                for (PerLemmings l : lemming){
                    if (l != quieto) {
                    
                        if (l.intersects(quieto)) {
                            l.velocidadX *= -1;
                            //l.x += l.velocidadX * 2;
                        }
                    }
                }
            }
        }    

    }
}
