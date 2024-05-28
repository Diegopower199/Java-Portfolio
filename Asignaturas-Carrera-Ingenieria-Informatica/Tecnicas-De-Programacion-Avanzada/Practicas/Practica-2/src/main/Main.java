package main;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Main {

    private static ArrayList<Component> selectedComp = new ArrayList<Component>();
    private static String[] stock;

    public static void main(String[] args) {

        stock = ComponentList.getItems();

        int opcionElegidaUsuario = JOptionPane.showOptionDialog(null, "¿Que componente desea elegir?", "WindowTitle",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, stock,
                stock[0]);

        if (opcionElegidaUsuario == 0) {
            LED objetoLED = new LED(17);
            System.out.println(objetoLED.doTask());
            selectedComp.add(objetoLED);
        } else if (opcionElegidaUsuario == 1) {
            Buzzer objetoBUZZER = new Buzzer(24);
            System.out.println(objetoBUZZER.doTask());
            selectedComp.add(objetoBUZZER);
        } else if (opcionElegidaUsuario == 2) {
            IR objetoIR = new IR(4);
            System.out.println(objetoIR.doTask());
            objetoIR.detect();
            selectedComp.add(objetoIR);

        }

        for (int i = 0; i < selectedComp.size(); i++) {
            System.out.println(selectedComp.get(i));
        }

    }

}
