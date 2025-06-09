package poo;

import javax.swing.*;

public abstract class ConfiguracionVideoJuego extends JPanel{
    protected int anchoVentana;
    protected int altoVentana;
    protected String titulo;

    public int getAnchoVentana() {
        return anchoVentana;
    }

    public int getAltoVentana() {
        return altoVentana;
    }

    public String getTitulo() {
        return titulo;
    }

    public abstract void aplicarConfiguracion();
}

