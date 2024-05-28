package main;

public class Utilidades {

    private static String[] arrayColores = { "NGR", "BLA", "ROJ", "VER", "AZL", "AMR" };

    public static String colorAleatorio() {

        int aleatorio = (int) (Math.random() * arrayColores.length);
        return arrayColores[aleatorio];
    }

}