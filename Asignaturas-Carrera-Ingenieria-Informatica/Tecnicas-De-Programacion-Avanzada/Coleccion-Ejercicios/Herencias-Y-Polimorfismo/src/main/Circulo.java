package main;

import java.lang.Math;

public class Circulo extends Figure {

    Circulo(double radio) {
        setArea(radio);
        setPerimetro(radio);
    }

    public void setArea(double radio) {
        area = (Math.PI) * (radio * 2);
    }

    public double getArea() {
        return area;
    }

    public void setPerimetro(double radio) {
        perimetro = 2 * (Math.PI) * radio;
    }

    public double getPerimetro() {
        return perimetro;
    }
}
