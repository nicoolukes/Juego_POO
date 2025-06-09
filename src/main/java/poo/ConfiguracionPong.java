package poo;

import java.util.HashMap;
import java.util.Map;
import java.awt.Color;

import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ConfiguracionPong extends ConfiguracionVideoJuego {
    // Controles Swing
    private JCheckBox chkPantallaCompleta = new JCheckBox("Pantalla Completa");
    private JCheckBox chkSonido = new JCheckBox("Sonido Activado", true);
    private JComboBox<String> cmbPistaMusical = new JComboBox<>(new String[]{"tema original", "retro", "electro"});
    // Controles Swing para elegir colores
    private JComboBox<String> cmbColorPaleta1 = new JComboBox<>(new String[]{"Azul", "Rojo", "Verde"});
    private JComboBox<String> cmbColorPaleta2 = new JComboBox<>(new String[]{"Rojo", "Azul", "Verde"});
    private JComboBox<String> cmbColorPelota = new JComboBox<>(new String[]{"Blanco", "Amarillo", "Naranja"});

    public ConfiguracionPong() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(chkPantallaCompleta);
        add(chkSonido);

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(new JLabel("Color Paleta 1:"));
        add(cmbColorPaleta1);
        add(new JLabel("Color Paleta 2:"));
        add(cmbColorPaleta2);
        add(new JLabel("Color Pelota:"));
        add(cmbColorPelota);

        add(new JLabel("Pista musical:"));
        add(cmbPistaMusical);
        // ...agrega otros controles si quieres...
    }

    @Override
    public void aplicarConfiguracion() {
        // Aplicar configuración de pantalla completa
        if (chkPantallaCompleta.isSelected()) {
            anchoVentana = 1920; // Ancho de pantalla completa
            altoVentana = 1080;  // Alto de pantalla completa
        } else {
            anchoVentana = 800;  // Ancho por defecto
            altoVentana = 600;   // Alto por defecto
        }

        // Aquí puedes agregar más lógica para aplicar otras configuraciones si es necesario
    }

    public Color getColorPaleta1() {
        String color = (String) cmbColorPaleta1.getSelectedItem();
        switch (color) {
            case "Azul": return Color.BLUE;
            case "Rojo": return Color.RED;
            case "Verde": return Color.GREEN;
            default: return Color.BLUE;
        }
    }

    public Color getColorPaleta2() {
        String color = (String) cmbColorPaleta2.getSelectedItem();
        switch (color) {
            case "Rojo": return Color.RED;
            case "Azul": return Color.BLUE;
            case "Verde": return Color.GREEN;
            default: return Color.RED;
        }
    }

    public Color getColorPelota() {
        String color = (String) cmbColorPelota.getSelectedItem();
        switch (color) {
            case "Blanco": return Color.WHITE;
            case "Amarillo": return Color.YELLOW;
            case "Naranja": return Color.ORANGE;
            default: return Color.WHITE;
        }
    }

}

