package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws Exception {
        final int CANTIDAD_COLORES = 15;

        List<String> lista1 = new ArrayList<>();
        List<String> lista2 = new ArrayList<>();

        for (int pos = 0; pos < CANTIDAD_COLORES; pos++) {
            lista1.add(Utilidades.colorAleatorio());
            lista2.add(Utilidades.colorAleatorio());
        }

        System.out.println("Contenido inicial de la lista 1: " + lista1);
        System.out.println("Contenido inicial de la lista 2: " + lista2);

        Map<String, List<Integer>> mapa = new HashMap<>();

        for (int pos = 0; pos < lista1.size(); pos++) {
            if (lista1.get(pos).equals(lista2.get(pos))) {
                String color = lista1.get(pos);

                mapa.putIfAbsent(color, new ArrayList<>());

                mapa.get(color).add(pos);
            }
        }

        System.out.println("Contenido del mapa:");
        for (Map.Entry<String, List<Integer>> entrada : mapa.entrySet()) {
            System.out.println("Color: " + entrada.getKey() + " - Posiciones: " + entrada.getValue());
        }
    }
}
