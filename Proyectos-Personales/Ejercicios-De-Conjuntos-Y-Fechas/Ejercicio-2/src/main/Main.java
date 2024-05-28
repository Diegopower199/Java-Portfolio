package main;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws Exception {
        final int CANTIDAD_COLORES = 10;

        List<String> lista1 = new ArrayList<>();
        List<String> lista2 = new ArrayList<>();

        for (int i = 0; i < CANTIDAD_COLORES; i++) {
            lista1.add(Utilidades.colorAleatorio());
            lista2.add(Utilidades.colorAleatorio());
        }

        System.out.println("Contenido inicial de la lista 1: " + lista1);
        System.out.println("Contenido inicial de la lista 2: " + lista2);

        List<String> coloresEliminados = new ArrayList<>();
        List<Integer> posicionesEliminadas = new ArrayList<>();
        Set<String> coloresEliminadosSinRepetir = new HashSet<>();

        for (int i = 0; i < CANTIDAD_COLORES; i++) {
            if (lista1.get(i).equals(lista2.get(i))) {
                String color = lista1.get(i);
                coloresEliminados.add(color);
                posicionesEliminadas.add(i);
                coloresEliminadosSinRepetir.add(color);
                lista1.set(i, "---");
                lista2.set(i, "---");
            }
        }

        System.out.println("Contenido final de la lista 1: " + lista1);
        System.out.println("Contenido final de la lista 2: " + lista2);
        System.out.println("Colores eliminados: " + coloresEliminados);
        System.out.println("Posiciones eliminadas: " + posicionesEliminadas);
        System.out.println("Conjunto de colores eliminados sin repetir: " + coloresEliminadosSinRepetir);
    }
}
