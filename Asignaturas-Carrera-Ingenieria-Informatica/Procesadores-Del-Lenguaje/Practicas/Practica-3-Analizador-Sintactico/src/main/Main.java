package main;

public class Main {
    public static void main(String[] args) {
        String expresion = "(25 * (2 + 2)) / 2 * 3";
        TraductorExpresion expr = new TraductorExpresion(new Lexico(expresion));
        String postfijo = expr.postfijo(expresion);
        int valor = expr.valor(postfijo);

        expr.recorrerStack();

        System.out.println("\nLa expresión " + expresion + " en notación postfija es " + postfijo
                + " y su valor es " + valor);
    }
}
