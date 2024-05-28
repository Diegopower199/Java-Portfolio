package main;

public class Main {
    public static void main(String[] args) {

        String fraseMayuscula = "HOLA";

        StringBuffer nuevaCadenaMinusculas = new StringBuffer();

        for (int i = 0; i < fraseMayuscula.length(); i++) {
            if (Character.isUpperCase(fraseMayuscula.charAt(i))) {
                nuevaCadenaMinusculas.append(Character.toLowerCase(fraseMayuscula.charAt(i)));

            }

            else {
                nuevaCadenaMinusculas.append(fraseMayuscula.charAt(i));
            }
        }

        System.out.println("De mayusculas: " + fraseMayuscula + " a " + nuevaCadenaMinusculas + "\n\n\n");

        String fraseMinuscula = "hola";

        StringBuffer nuevaCadenaMayuscula = new StringBuffer();

        for (int i = 0; i < fraseMinuscula.length(); i++) {
            if (Character.isLowerCase(fraseMinuscula.charAt(i))) {
                nuevaCadenaMayuscula.append(Character.toUpperCase(fraseMinuscula.charAt(i)));

            }

            else {
                nuevaCadenaMayuscula.append(fraseMinuscula.charAt(i));
            }
        }

        System.out.println("De mayusculas: " + fraseMinuscula + " a " + nuevaCadenaMayuscula);
    }
}
