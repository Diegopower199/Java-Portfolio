package main;

import java.util.Random;

import javax.swing.JOptionPane;

public class Buzzer extends Component implements Actuator {

    private boolean booleanoAleatorio = false;

    public Buzzer(int pin, eGPIO pinMode) {
        super(pin, pinMode);
    }

    public Buzzer(int pin) {
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
        return "ESTAS EN EL BUZZER";
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

}
