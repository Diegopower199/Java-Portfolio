package ComponentesCustoms;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JComboBox;

public class CustomComboBox extends JComboBox {

    public CustomComboBox() {
        Font fuente = new Font("Dialog", Font.BOLD, 12);
        setFont(fuente);
        setForeground(Color.BLACK);
    }

}
