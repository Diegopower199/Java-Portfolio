package ComponentesCustoms;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

public class CustomLabel extends JLabel {

    String palabraLabel;

    public CustomLabel() {
        setText(palabraLabel);
        Font fuente = new Font(palabraLabel, Font.BOLD, 12);
        setFont(fuente);
        setForeground(Color.BLACK);
    }

    public CustomLabel(String palabra, boolean obligatorio) {
        if (obligatorio) {
            setText(palabra);
            Font fuente = new Font(palabra, Font.BOLD, 12);
            setFont(fuente);
            setForeground(Color.BLACK);
        } else {
            setText(palabra);
            Font fuente = new Font(palabra, Font.PLAIN, 12);
            setFont(fuente);
        }
    }

}
