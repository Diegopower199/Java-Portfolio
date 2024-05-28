package main;

public class Figure {
    protected double area = 0;
    protected double perimetro = 0;

    public void setArea(double areaUsuario) {
        area = areaUsuario;
    }

    public double getArea() {
        return area;
    }

    public void setPerimetro(double perimetroUsuario) {
        perimetro = perimetroUsuario;
    }

    public double getPerimetro() {
        return perimetro;
    }
}
