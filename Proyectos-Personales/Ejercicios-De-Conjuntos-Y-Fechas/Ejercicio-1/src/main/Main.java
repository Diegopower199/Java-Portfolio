package main;

import java.util.HashSet;
import java.util.Set;

public class Main {
    static final int CANTIDAD_COLORES = 3;

    public static void main(String[] args) throws Exception {
        Set<String> conjunto1 = new HashSet<>();
        Set<String> conjunto2 = new HashSet<>();

        while (conjunto1.size() < CANTIDAD_COLORES) {
            conjunto1.add(Utilidades.colorAleatorio());
        }

        while (conjunto2.size() < CANTIDAD_COLORES) {
            conjunto2.add(Utilidades.colorAleatorio());
        }

        System.out.println("Conjunto 1: " + conjunto1);
        System.out.println("Conjunto 2: " + conjunto2);

        Set<String> conjunto3 = new HashSet<>(conjunto1);
        conjunto3.addAll(conjunto2);
        System.out.println("Conjunto Unión (Conjunto 3): " + conjunto3);

        Set<String> conjunto4 = new HashSet<>(conjunto1);
        conjunto4.retainAll(conjunto2);
        System.out.println("Conjunto Intersección (Conjunto 4): " + conjunto4);

        Set<String> conjunto5 = new HashSet<>(conjunto1);
        conjunto5.removeAll(conjunto2);
        System.out.println("Conjunto Diferencia (Conjunto 5): " + conjunto5);
    }
}
