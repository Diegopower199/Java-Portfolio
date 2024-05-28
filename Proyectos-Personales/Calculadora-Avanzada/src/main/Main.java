package main;

import java.util.Scanner;

public class Main {
    static Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Calculadora de Calculator S.A");

        int option = -1;

        while (option != 0) {
            mostrarMenu();
            option = leerOpcion();

            switch (option) {
                case 1:
                    realizarOperacion("sumar");
                    break;
                case 2:
                    realizarOperacion("restar");
                    break;
                case 3:
                    realizarOperacion("multiplicar");
                    break;
                case 4:
                    realizarOperacion("dividir");
                    break;
                case 5:
                    realizarOperacion("modulo");
                    break;
                case 6:
                    mostrarSignoZodiaco();
                    break;
                case 7:
                    mostrarNumeroMayor();
                    break;
                case 8:
                    calcularFactorial();
                    break;
                case 0:
                    System.out.println("El programa ha finalizado");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }

    static void mostrarMenu() {
        System.out.println("\n1. Sumar\n" +
                "2. Restar\n" +
                "3. Multiplicar\n" +
                "4. Dividir\n" +
                "5. Resto (modulo)\n" +
                "6. Zodíaco\n" +
                "7. Número mayor de 3 números\n" +
                "8. Factorial\n" +
                "0. Salir\n" +
                "El usuario introduce un número del 0 al 8: ");
    }

    static int leerOpcion() {
        int option = -1;
        try {
            option = teclado.nextInt();
            teclado.nextLine();
        } catch (Exception e) {
            System.out.println("Error: debe introducir un número.");
            teclado.nextLine();
        }
        return option;
    }

    static void realizarOperacion(String operacion) {
        float num1 = leerNumero("Introduce el primer número: ");
        float num2 = leerNumero("Introduce el segundo número: ");
        float resultado = 0;

        switch (operacion) {
            case "sumar":
                resultado = num1 + num2;
                break;
            case "restar":
                resultado = num1 - num2;
                break;
            case "multiplicar":
                resultado = num1 * num2;
                break;
            case "dividir":
                if (num2 != 0) {
                    resultado = num1 / num2;
                } else {
                    System.out.println("Error: división por 0.");
                    return;
                }
                break;
            case "modulo":
                if (num2 != 0) {
                    resultado = num1 % num2;
                } else {
                    System.out.println("Error: división por 0.");
                    return;
                }
                break;
        }
        System.out.println("El resultado es: " + resultado);
    }

    static float leerNumero(String mensaje) {
        System.out.println(mensaje);
        while (!teclado.hasNextFloat()) {
            System.out.println("Error: debe introducir un número.");
            teclado.next();
        }
        return teclado.nextFloat();
    }

    static void mostrarSignoZodiaco() {
        System.out.println("Introduzca su mes de nacimiento (1-12): ");
        int mesNacimiento = teclado.nextInt();

        while (mesNacimiento < 1 || mesNacimiento > 12) {
            System.out.println("Error: debe introducir un número del 1 al 12.");
            mesNacimiento = teclado.nextInt();
        }

        String[] signosZodiaco = {
                "Aries", "Tauro", "Géminis", "Cáncer", "Leo", "Virgo",
                "Libra", "Escorpio", "Sagitario", "Capricornio", "Acuario", "Piscis"
        };

        System.out.println("Su signo zodiacal es: " + signosZodiaco[mesNacimiento - 1]);
    }

    static void mostrarNumeroMayor() {
        float num1 = leerNumero("Introduzca el primer número: ");
        float num2 = leerNumero("Introduzca el segundo número: ");
        float num3 = leerNumero("Introduzca el tercer número: ");

        float mayor = num1;
        if (num2 > mayor)
            mayor = num2;
        if (num3 > mayor)
            mayor = num3;

        System.out.println("El número mayor es: " + mayor);
    }

    static void calcularFactorial() {
        System.out.println("Introduce un número para calcular el factorial: ");
        int numero = teclado.nextInt();

        if (numero < 0) {
            System.out.println("Error: el número debe ser mayor o igual a 0.");
            return;
        }

        int factorial = 1;
        for (int i = 1; i <= numero; i++) {
            factorial *= i;
        }

        System.out.println("El factorial de " + numero + " es: " + factorial);
    }
}
