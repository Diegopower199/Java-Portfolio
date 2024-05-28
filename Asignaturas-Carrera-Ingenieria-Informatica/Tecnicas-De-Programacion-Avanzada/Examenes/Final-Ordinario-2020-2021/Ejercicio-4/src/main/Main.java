package main;

public class Main {
    public static void main(String[] args) {
        int[] datos = { 8, 4, 9, 11, 4, 3, 7, 11, 11, 3, 10, 2, 4 };

        ModaArray m = new ModaArray(datos);
        System.out.println("La moda es " + m.moda());
    }
}
