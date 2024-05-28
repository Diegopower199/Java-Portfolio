package main;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int x = 0;
        int y = 0;
        int z = 0;

        Scanner scan = new Scanner(System.in);
        while (x <= 0 || x > 10) {
            System.out.println("Escribe el valor de la variable x: ");
            x = scan.nextInt();
            scan.nextLine();
            if (x <= 0 || x > 10) {
                System.out.println("Escribe un valor entre 1 y 10 ");
            }
        }

        while (y <= 0 || y > 10) {
            System.out.println("Escribe el valor de la variable y: ");
            y = scan.nextInt();
            scan.nextLine();
            if (y <= 0 || y > 10) {
                System.out.println("Escribe un valor entre 1 y 10 ");
            }
        }

        while (z <= 0 || z > 10) {
            System.out.println("Escribe el valor de la variable z: ");
            z = scan.nextInt();
            scan.nextLine();
            if (z <= 0 || z > 10) {
                System.out.println("Escribe un valor entre 1 y 10 ");
            }
        }

        PrimeraEcuacion hilo1 = new PrimeraEcuacion("Hilo 1", x, y, z);
        SegundaEcuacion hilo2 = new SegundaEcuacion("Hilo 2", x, y, z);
        hilo1.run();
        hilo2.run();

        CalculoTotal hilo3 = new CalculoTotal("Hilo 3", hilo1.resultado, hilo2.resultado);
        hilo3.run();

        scan.close();
    }

}
