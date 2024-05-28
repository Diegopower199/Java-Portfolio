package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static Scanner scan;
    static List<Jugador> jugadores = new ArrayList<>();
    static int num1Ganadora = 0;
    static int num2Ganadora = 0;

    public static void main(String[] args) throws Exception {
        System.out.println("BIENVENIDOS AL PROGRAMA DE LOTERIA DOBLE ACIERTO");
        scan = new Scanner(System.in);

        while (true) {
            System.out.println("1. Registrar jugador\n2. Jugar\n3. Mostrar historial\n4. Salir");
            int opcion = scan.nextInt();
            scan.nextLine();

            switch (opcion) {
                case 1:
                    registrarJugador();
                    break;
                case 2:
                    jugar();
                    break;
                case 3:
                    mostrarHistorial();
                    break;
                case 4:
                    System.out.println("Gracias por jugar. ¡Adiós!");
                    return;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }

    static void registrarJugador() {
        System.out.print("Introduce el nombre del jugador: ");
        String nombre = scan.nextLine();
        jugadores.add(new Jugador(nombre));
        System.out.println("Jugador " + nombre + " registrado.");
    }

    static void jugar() {
        if (jugadores.isEmpty()) {
            System.out.println("No hay jugadores registrados. Registra al menos un jugador para jugar.");
            return;
        }

        combinacionGanadora();

        for (Jugador jugador : jugadores) {
            System.out.println("\nTurno de " + jugador.getNombre());
            combinacionUsuario(jugador);

            int aciertos = calculaAciertos(jugador.getNum1(), jugador.getNum2());

            if (aciertos == 0) {
                System.out.println("No has acertado ningún número");
            } else {
                System.out.println("Has acertado " + aciertos + " número(s)");
            }

            jugador.agregarHistorial(new Historial(jugador.getNum1(), jugador.getNum2(), aciertos));
        }
    }

    static int pideNumEntreRango(int min, int max) {
        System.out.println("Introduce un número entre " + min + " y " + max + ": ");
        int num = scan.nextInt();
        scan.nextLine();

        while (num < min || num > max) {
            System.out.println("Error, introduce un número entre " + min + " y " + max + ": ");
            num = scan.nextInt();
            scan.nextLine();
        }

        return num;
    }

    static void combinacionGanadora() {
        num1Ganadora = (int) (Math.random() * 10);
        num2Ganadora = (int) (Math.random() * 10);

        while (num1Ganadora == num2Ganadora) {
            num2Ganadora = (int) (Math.random() * 10);
        }

        System.out.println("La combinación ganadora es: " + num1Ganadora + " - " + num2Ganadora);
    }

    static void combinacionUsuario(Jugador jugador) {
        jugador.setNum1(pideNumEntreRango(0, 9));
        jugador.setNum2(pideNumEntreRango(0, 9));
    }

    static int calculaAciertos(int usu1, int usu2) {
        int numeroAciertos = 0;

        if (num1Ganadora == usu1 || num1Ganadora == usu2) {
            numeroAciertos++;
        }

        if (num2Ganadora == usu1 || num2Ganadora == usu2) {
            numeroAciertos++;
        }

        return numeroAciertos;
    }

    static void mostrarHistorial() {
        for (Jugador jugador : jugadores) {
            System.out.println("\nHistorial de " + jugador.getNombre() + ":");
            for (Historial entrada : jugador.getHistorial()) {
                System.out.println("Números jugados: " + entrada.getNum1() + " - " + entrada.getNum2() + ", Aciertos: "
                        + entrada.getAciertos());
            }
        }
    }
}
