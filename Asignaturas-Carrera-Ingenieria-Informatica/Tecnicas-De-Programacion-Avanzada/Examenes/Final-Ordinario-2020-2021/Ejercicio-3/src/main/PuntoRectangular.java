package main;

public class PuntoRectangular implements IPuntoRectangular {

    PuntoPolar p1;

    @Override
    public double getX() {
        return p1.getRadio() * Math.cos(p1.getAngulo());
    }

    @Override
    public double getY() {
        return p1.getRadio() * Math.sin(p1.getAngulo());
    }

}
