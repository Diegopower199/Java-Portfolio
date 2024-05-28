package main;

public class AdaptadorPolarRectangular implements IPuntoRectangular {

    PuntoPolar p1;

    public AdaptadorPolarRectangular(PuntoPolar p1) {
        this.p1 = p1;
    }

    @Override
    public double getX() {
        return p1.getRadio() * Math.cos(Math.toRadians(p1.getAngulo()));
    }

    @Override
    public double getY() {
        return p1.getRadio() * Math.sin(Math.toRadians(p1.getAngulo()));
    }
}
