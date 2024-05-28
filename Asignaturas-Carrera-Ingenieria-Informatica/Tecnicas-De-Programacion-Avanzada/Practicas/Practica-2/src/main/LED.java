package main;

import java.util.Random;
import javax.swing.JOptionPane;

public class LED extends Component implements Actuator {

    private boolean booleanoAleatorio = false;

    public LED(int pin, eGPIO pinMode) {
        super(pin, pinMode);
    }

    public LED(int pin) {
        super(pin);
    }

    @Override
    public String doTask() {
        booleanoAleatorio = getRandomBoolean();
        if (booleanoAleatorio == false) {
            start();
        } else {
            stop();
        }
        return "ESTAS EN EL LED";

    }

    @Override
    public void start() {
        JOptionPane.showMessageDialog(null, "El actuador se ha encendido");
    }

    @Override
    public void stop() {
        JOptionPane.showMessageDialog(null, "El actuador se ha apagado");
    }

    public boolean getRandomBoolean() {
        Random random = new Random();
        return random.nextBoolean();
    }

    /*
     * start() - si es true (Mostrando por pantalla que el actuador se ha encendido)
     * b. stop() - si es false (Mostrando por pantalla que el actuador se ha
     * apagado)
     * 
     */

}
