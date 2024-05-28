package main;

import java.util.Random;
import javax.swing.JOptionPane;

public class IR extends Component implements Sensor {

    private boolean booleanoAleatorio = false;

    public IR(int pin, eGPIO pinMode) {
        super(pin, pinMode);
    }

    public IR(int pin) {
        super(pin);
    }

    @Override
    public String doTask() {
        return "ESTAS EN EL IR";
    }

    @Override
    public void detect() {
        booleanoAleatorio = getRandomBoolean();
        if (booleanoAleatorio == false) {
            JOptionPane.showMessageDialog(null, "No se ha detectado algo");
        } else {
            JOptionPane.showMessageDialog(null, "Se ha detectado algo");
        }
    }

    public boolean getRandomBoolean() {
        Random random = new Random();
        return random.nextBoolean();
    }

    /*
     * Para comprobar si el sensor IR detecta algo o no, se llamará al método
     * detect() que retornará
     * un valor random de tipo booleano. Por tanto, doTask, mostrará en una ventana
     * si se ha
     * detectado algo o no.
     */
}
