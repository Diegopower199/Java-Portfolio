package ComponentesCustoms;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JTextField;

public class CustomCampoTexto extends JTextField {

    public CustomCampoTexto() {
        Font fuente = new Font("Dialog", Font.BOLD, 12);
        setFont(fuente);
        setBackground(Color.WHITE);
        setForeground(Color.BLACK);
    }
}
