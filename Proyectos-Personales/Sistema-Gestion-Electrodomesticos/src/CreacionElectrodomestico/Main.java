package CreacionElectrodomestico;

import TiposElectrodomesticos.*;

public class Main {
    public static void main(String[] args) {
        Electrodomestico[] electrodomesticos = new Electrodomestico[13];
        electrodomesticos[0] = new Electrodomestico(200, "verde", 'C', 60);
        electrodomesticos[1] = new Lavadora(150, 30);
        electrodomesticos[2] = new Television(500, "negro", 'E', 80, 42, false);
        electrodomesticos[3] = new Electrodomestico();
        electrodomesticos[4] = new Electrodomestico(600, "gris", 'D', 20);
        electrodomesticos[5] = new Lavadora(300, "blanco", 'Z', 40, 40);
        electrodomesticos[6] = new Television(250, 70);
        electrodomesticos[7] = new Lavadora(400, "verde", 'A', 100, 15);
        electrodomesticos[8] = new Television(200, "naranja", 'C', 60, 30, true);
        electrodomesticos[9] = new Electrodomestico(50, 10);
        electrodomesticos[10] = new Ordenador(800, "negro", 'B', 5, 16, true);
        electrodomesticos[11] = new Raton(20, "gris", 'F', 0.1, true);
        electrodomesticos[12] = new Teclado(50, "blanco", 'F', 0.5, true);

        double sumaElectrodomesticos = 0;
        double sumaLavadoras = 0;
        double sumaTelevisiones = 0;
        double sumaOrdenadores = 0;
        double sumaRatones = 0;
        double sumaTeclados = 0;

        for (Electrodomestico electrodomestico : electrodomesticos) {
            double precioFinal = electrodomestico.precioFinal();
            sumaElectrodomesticos += precioFinal;
            if (electrodomestico instanceof Lavadora) {
                sumaLavadoras += precioFinal;
            } else if (electrodomestico instanceof Television) {
                sumaTelevisiones += precioFinal;
            } else if (electrodomestico instanceof Ordenador) {
                sumaOrdenadores += precioFinal;
            } else if (electrodomestico instanceof Raton) {
                sumaRatones += precioFinal;
            } else if (electrodomestico instanceof Teclado) {
                sumaTeclados += precioFinal;
            }
        }

        System.out.println("La suma del precio de los electrodomesticos es de " + sumaElectrodomesticos);
        System.out.println("La suma del precio de las lavadoras es de " + sumaLavadoras);
        System.out.println("La suma del precio de las televisiones es de " + sumaTelevisiones);
        System.out.println("La suma del precio de los ordenadores es de " + sumaOrdenadores);
        System.out.println("La suma del precio de los ratones es de " + sumaRatones);
        System.out.println("La suma del precio de los teclados es de " + sumaTeclados);
    }
}
