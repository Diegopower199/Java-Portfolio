package main;

public class Main {
    public static void main(String[] args) {
        Cuadrado cuadrado1 = new Cuadrado(2);
        Rectangulo rectangulo1 = new Rectangulo(4, 8);
        Circulo circulo1 = new Circulo(3);

        System.out.println("Area cuadrado: " + cuadrado1.getArea());
        System.out.println("Area rectangulo: " + rectangulo1.getArea());
        System.out.println("Perimetro cuadrado: " + cuadrado1.getPerimetro());
        System.out.println("Perimetro rectangulo: " + rectangulo1.getPerimetro());
        System.out.println("Area circulo: " + circulo1.getArea());
        System.out.println("Perimetro circulo: " + circulo1.getPerimetro());
    }
}
