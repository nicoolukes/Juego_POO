package poo;

public class Jugador{

    private int puntosT = 0;

    public Jugador(){
        this.puntosT = 0;
    }

    public void setPuntos(int p){
        this.puntosT= p;
    }

    public int getPuntos(){
        return puntosT;
    }

    public void sumarPuntos(){
        puntosT++;
    }

    
}