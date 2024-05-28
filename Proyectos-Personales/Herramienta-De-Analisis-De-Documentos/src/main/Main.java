package main;

import contadores.*;

public class Main {
    public static void main(String[] args) {
        Thread[] hilos = new Thread[]{
            new Thread(new ContadorPalabras("Palabras")),
            new Thread(new ContadorLineas("Lineas")),
            new Thread(new ContadorTitulos("Titulos")),
            new Thread(new ContadorArticulos("Articulos")),
            new Thread(new ContadorCapitulos("Capitulos")),
            new Thread(new ContadorPalabraConstitucion("Palabra Constitucion")),
            new Thread(new ContadorPalabraRey("Palabra Rey"))
        };

        for (Thread hilo : hilos) {
            hilo.start();
        }

        for (Thread hilo : hilos) {
            try {
                hilo.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
