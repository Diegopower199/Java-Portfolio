package ComponentesCustoms;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JRadioButton;

public class CustomRadioButton extends JRadioButton {

    public CustomRadioButton(String palabra) {
        setText(palabra);
        Font fuente = new Font(palabra, Font.BOLD, 12);
        setFont(fuente);
        setForeground(Color.BLACK);
    }

}
