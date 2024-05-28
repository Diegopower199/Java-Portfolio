package main;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws Exception {
        final int NUM_DIAS = 5;

        Map<LocalDate, String> mapaColores = new HashMap<>();
        Set<String> coloresUsados = new HashSet<>();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        LocalDate fechaInicial = LocalDate.of(2022, 3, 1);

        for (int i = 0; i < NUM_DIAS; i++) {
            LocalDate fecha = fechaInicial.plusDays(i);
            String colorAleatorio;

            do {
                colorAleatorio = Utilidades.colorAleatorio();
            } while (coloresUsados.contains(colorAleatorio));

            mapaColores.put(fecha, colorAleatorio);
            coloresUsados.add(colorAleatorio);
        }

        Map<LocalDate, String> mapaOrdenado = new TreeMap<>(mapaColores);

        System.out.println("Asignación de colores: un color diferente por cada fecha");
        System.out.println("--------------------------------------------------------");
        for (Map.Entry<LocalDate, String> entrada : mapaOrdenado.entrySet()) {
            System.out.println("Fecha: " + formatter.format(entrada.getKey()) + " - Color: " + entrada.getValue());
        }
    }
}
