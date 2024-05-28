package main;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Main {

    public static void main(String[] args) {
        String[] palabras = new String[] { "pera", "manzana", "naranja", "uva", "melon" };

        String palabraSecreta = palabras[numeroAleatorioEnRango(0, palabras.length - 1)];

        ArrayList<Character> caracteresPorAdivinar = new ArrayList<>();
        for (char c : palabraSecreta.toCharArray()) {
            caracteresPorAdivinar.add('_');
        }

        Scanner scan = new Scanner(System.in);
        int vidasJugador = 6;

        while (vidasJugador > 0 && caracteresPorAdivinar.contains('_')) {
            System.out.println("Palabra: " + caracteresPorAdivinar);
            System.out.println("Vidas restantes: " + vidasJugador);

            System.out.print("Introduce una letra: ");
            char letra = scan.next().charAt(0);

            boolean acierto = false;
            for (int i = 0; i < palabraSecreta.length(); i++) {
                if (palabraSecreta.charAt(i) == letra) {
                    caracteresPorAdivinar.set(i, letra);
                    acierto = true;
                }
            }

            if (!acierto) {
                vidasJugador--;
                System.out.println("¡Incorrecto! Te quedan " + vidasJugador + " vidas.");
            } else {
                System.out.println("¡Correcto!");
            }
        }

        if (vidasJugador > 0) {
            System.out.println("¡Felicidades! Has adivinado la palabra: " + palabraSecreta);
        } else {
            System.out.println("¡Has perdido! La palabra era: " + palabraSecreta);
        }

        scan.close();
    }

    public static int numeroAleatorioEnRango(int minimo, int maximo) {
        return ThreadLocalRandom.current().nextInt(minimo, maximo + 1);
    }
}
