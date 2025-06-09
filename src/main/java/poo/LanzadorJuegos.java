package poo;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import com.entropyinteractive.*; //las librerias JGame,GameLoop,KeyBoard,Mouse,etc...
//panel de Swing que puede contener componentes gráficos
//Implementa ActionListener, lo que permite capturar eventos cuando el usuario hace clic en los botones.
public class LanzadorJuegos extends JPanel implements ActionListener{
    JGame juego;
    Thread t;
    public LanzadorJuegos(){
        int filas = 0;
        int columnas = 1;
        int separacion = 10;
        this.setLayout(new GridLayout(filas, columnas, separacion, separacion));
        JLabel titulo = new JLabel("Juegos", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 28));
        this.add(titulo);

        String[] arrEtiquetas = {"Pong", "Lemmings"};
        for (String etiqueta : arrEtiquetas) {
            JButton boton = new JButton(etiqueta);
            boton.setFont(new Font("Arial", Font.PLAIN, 18));
            boton.addActionListener(this);
            this.add(boton);
        }

        // --- Configuración de la ventana ---
        JFrame f = new JFrame("Lanzador");
        f.setSize(400, 500);
        f.add(this);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }
        

    
    
    public void actionPerformed(ActionEvent e){

		if (e.getActionCommand().equals("Pong")){
    
            ConfiguracionPong config = new ConfiguracionPong();
            // Mostrar la configuración en un diálogo antes de iniciar el juego
            int result = JOptionPane.showConfirmDialog(
            null,
            config,
            "Configuración Pong",
            JOptionPane.OK_CANCEL_OPTION,
            JOptionPane.PLAIN_MESSAGE
        ); 
            if (result == JOptionPane.OK_OPTION) {
                config.aplicarConfiguracion(); // Aplicar la configuración
    

                // Configurar el tamaño de la ventana según la configuración
                this.setPreferredSize(new Dimension(config.getAnchoVentana(), config.getAltoVentana()));
                this.setSize(config.getAnchoVentana(), config.getAltoVentana());
                this.setVisible(true);
                
                
			    juego = new JPong(
                config.getAnchoVentana(), // ancho de la ventana
                config.getAltoVentana(),  // alto de la ventana
                Color.BLACK,   // color de fondo
                config.getColorPaleta1(),   // color paleta 1
                config.getColorPaleta2(),   // color paleta 2
                config.getColorPelota() // color pelota
                );

		    t = new Thread() {
			    public void run() {
					juego.run(1.0 / 60.0);
				}
			};

			t.start();
            } else {
                // El usuario canceló la configuración, no iniciar el juego
                System.out.println("Configuración cancelada.");
            }
        }
	}

    public static void main(String...z){
        new LanzadorJuegos();
    }
}
   
    
