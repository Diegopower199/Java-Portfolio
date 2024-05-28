package main;

public class Cuadrado extends Figure {

    Cuadrado(int lado) {
        setArea(lado);
        setPerimetro(lado);
    }

    public void setArea(double lado) {
        area = lado * lado;
    }

    public double getArea() {
        return area;
    }

    public void setPerimetro(double lado) {
        perimetro = lado * 4;
    }

    public double getPerimetro() {
        return perimetro;
    }
}
