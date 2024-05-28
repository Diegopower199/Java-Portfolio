package main;

public class Rectangulo extends Figure {

    Rectangulo(double base, double altura) {
        setArea(base, altura);
        setPerimetro(base, altura);
    }

    public void setArea(double base, double altura) {
        area = base * altura;
    }

    public double getArea() {
        return area;
    }

    public void setPerimetro(double base, double altura) {
        perimetro = (base * 2) + (altura * 2);
    }

    public double getPerimetro() {
        return perimetro;
    }
}
