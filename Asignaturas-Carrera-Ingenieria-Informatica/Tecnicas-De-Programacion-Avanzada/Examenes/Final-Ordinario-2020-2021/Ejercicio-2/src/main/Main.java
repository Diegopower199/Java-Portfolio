package main;

public class Main {
    public static void main(String[] args) {
        Cola<Integer> cola = new Cola<Integer>();

        cola.inserta(1);
        cola.inserta(2);
        cola.inserta(4);
        cola.inserta(8);
        cola.inserta(16);

        System.out.println("Cola " + cola.toString());
        System.out.println("Primero " + cola.primero());
        System.out.println("Ultimo " + cola.ultimo());

        cola.elimina();

        System.out.println("Cola " + cola.toString());
        System.out.println("Primero " + cola.primero());
        System.out.println("Ultimo " + cola.ultimo());
    }
}
