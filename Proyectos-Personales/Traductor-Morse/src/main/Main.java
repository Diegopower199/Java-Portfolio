package main;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.print("Introduzca una frase: ");
        Scanner teclado = new Scanner(System.in);
        String fraseUsuario = teclado.nextLine();

        while (!esFraseValida(fraseUsuario)) {
            System.out.print("\nLa frase contiene caracteres no permitidos. Introduzca otra frase: ");
            fraseUsuario = teclado.nextLine();
        }

        teclado.close();

        String fraseTraducidaMorse = traducirAMorse(fraseUsuario.toLowerCase());

        System.out.println(fraseTraducidaMorse);
    }

    static boolean esFraseValida(String frase) {
        for (int pos = 0; pos < frase.length(); pos++) {
            char letraFrase = frase.charAt(pos);
            if (letraFrase == 'ñ' || letraFrase == 'ç' || (letraFrase >= '0' && letraFrase <= '9')) {
                return false;
            }
        }
        return true;
    }

    static String traducirAMorse(String frase) {
        StringBuilder fraseTraducidaMorse = new StringBuilder();
        for (int pos = 0; pos < frase.length(); pos++) {
            char letraFrase = frase.charAt(pos);
            switch (letraFrase) {
                case 'a':
                    fraseTraducidaMorse.append(".- ");
                    break;
                case 'b':
                    fraseTraducidaMorse.append("-... ");
                    break;
                case 'c':
                    fraseTraducidaMorse.append("-.-. ");
                    break;
                case 'd':
                    fraseTraducidaMorse.append("-.. ");
                    break;
                case 'e':
                    fraseTraducidaMorse.append(". ");
                    break;
                case 'f':
                    fraseTraducidaMorse.append("..-. ");
                    break;
                case 'g':
                    fraseTraducidaMorse.append("--. ");
                    break;
                case 'h':
                    fraseTraducidaMorse.append(".... ");
                    break;
                case 'i':
                    fraseTraducidaMorse.append(".. ");
                    break;
                case 'j':
                    fraseTraducidaMorse.append(".--- ");
                    break;
                case 'k':
                    fraseTraducidaMorse.append("-.- ");
                    break;
                case 'l':
                    fraseTraducidaMorse.append(".-.. ");
                    break;
                case 'm':
                    fraseTraducidaMorse.append("-- ");
                    break;
                case 'n':
                    fraseTraducidaMorse.append("-. ");
                    break;
                case 'o':
                    fraseTraducidaMorse.append("--- ");
                    break;
                case 'p':
                    fraseTraducidaMorse.append(".--. ");
                    break;
                case 'q':
                    fraseTraducidaMorse.append("--.- ");
                    break;
                case 'r':
                    fraseTraducidaMorse.append(".-. ");
                    break;
                case 's':
                    fraseTraducidaMorse.append("... ");
                    break;
                case 't':
                    fraseTraducidaMorse.append("- ");
                    break;
                case 'u':
                    fraseTraducidaMorse.append("..- ");
                    break;
                case 'v':
                    fraseTraducidaMorse.append("...- ");
                    break;
                case 'w':
                    fraseTraducidaMorse.append(".-- ");
                    break;
                case 'x':
                    fraseTraducidaMorse.append("-..- ");
                    break;
                case 'y':
                    fraseTraducidaMorse.append("-.-- ");
                    break;
                case 'z':
                    fraseTraducidaMorse.append("--.. ");
                    break;
                case ' ':
                    fraseTraducidaMorse.append("/ ");
                    break;
                default:

                    break;
            }
        }
        return fraseTraducidaMorse.toString();
    }
}
