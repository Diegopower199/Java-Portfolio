package main;

public class PuntoPolar implements IPuntoPolar {

    private int radio, angulo;

    public PuntoPolar(int radio, int angulo) {
        this.radio = radio;
        this.angulo = angulo;
    }

    @Override
    public double getRadio() {
        return radio;
    }

    @Override
    public double getAngulo() {
        return angulo;
    }

}
