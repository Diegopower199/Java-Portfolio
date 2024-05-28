package ComponentesCustoms;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;

public class CustomBoton extends JButton {

    public CustomBoton(String palabra) {
        setText(palabra);
        Font fuente = new Font(palabra, Font.BOLD, 12);
        setFont(fuente);
        setForeground(Color.BLACK);
    }
}
