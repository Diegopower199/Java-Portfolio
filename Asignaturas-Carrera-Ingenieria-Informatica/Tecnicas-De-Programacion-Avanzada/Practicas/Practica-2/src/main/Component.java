package main;

public abstract class Component {

    protected int pin = 0;
    protected eGPIO pinMode;
    protected ePinState pinState;

    public Component(int pin, eGPIO pinMode) {

    }

    public Component(int pin) {
        this.pin = pin;
    }

    public abstract String doTask();

}
