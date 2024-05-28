package main;

public class Main {
    public static void main(String[] args) {
        PuntoPolar p1 = new PuntoPolar(5, 40);
        PuntoPolar p2 = new PuntoPolar(15, 120);

        AdaptadorPolarRectangular r1 = new AdaptadorPolarRectangular(p1);
        AdaptadorPolarRectangular r2 = new AdaptadorPolarRectangular(p2);

        System.out.println("Polar " + p1.getRadio() + " " + p1.getAngulo() + " grados");
        System.out.println("Rectangular " + r1.getX() + " " + r1.getY() + "\n");
        System.out.println("Polar " + p2.getRadio() + " " + p2.getAngulo() + " grados");
        System.out.println("Rectangular " + r2.getX() + " " + r2.getY() + "\n");
    }
}
