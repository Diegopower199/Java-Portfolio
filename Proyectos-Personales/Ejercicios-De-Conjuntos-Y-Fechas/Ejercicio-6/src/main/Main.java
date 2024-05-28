package main;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {

        List<CitaLiteraria> listaCitas = new ArrayList<>();

        System.out.println("ORDENACIÓN DE CITAS LITERARIAS");
        System.out.println("------------------------------");

        listaCitas.add(new CitaLiteraria("Soy el mejor en morir en la escena", "Libro 1"));
        listaCitas.add(new CitaLiteraria("El mundo acaba hoy", "Libro 1", "Libro 2"));
        listaCitas.add(new CitaLiteraria("Silba una vez y vendré siempre", "Libro 3", "Libro 4", "Libro 5"));
        listaCitas.add(new CitaLiteraria("Un invitado invita a cien"));

        System.out.println("Contenido inicial de la lista:");
        for (CitaLiteraria cita : listaCitas) {
            System.out.println(cita);
        }
        System.out.println();

        System.out.println("Ordenación por texto de la cita:");
        listaCitas.sort(new ComparadorCitasPorTexto());
        for (CitaLiteraria cita : listaCitas) {
            System.out.println(cita);
        }
        System.out.println();

        System.out.println("Ordenación por longitud de la cita:");
        listaCitas.sort(new ComparadorCitasPorLongitud());
        for (CitaLiteraria cita : listaCitas) {
            System.out.println(cita);
        }
        System.out.println();

        System.out.println("Ordenación por número de obras en las que aparece la cita:");
        listaCitas.sort(new ComparadorCitasPorNumObras());
        for (CitaLiteraria cita : listaCitas) {
            System.out.println(cita);
        }
    }
}
