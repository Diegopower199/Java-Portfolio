package main;

import java.time.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Map<Month, Map<DayOfWeek, Set<LocalDate>>> mapaFechas = new HashMap<>();

        int year = 2022;

        for (Month mes : Month.values()) {
            Map<DayOfWeek, Set<LocalDate>> mapaDiasSemana = new HashMap<>();

            int diasEnMes = mes.length(Year.isLeap(year));

            for (int dia = 1; dia <= diasEnMes; dia++) {
                LocalDate fecha = LocalDate.of(year, mes, dia);

                DayOfWeek diaSemana = fecha.getDayOfWeek();

                Set<LocalDate> fechasDia = mapaDiasSemana.computeIfAbsent(diaSemana, k -> new HashSet<>());

                fechasDia.add(fecha);
            }

            mapaFechas.put(mes, mapaDiasSemana);
        }

        System.out.println("Fechas de febrero que caen en lunes:");
        mapaFechas.get(Month.FEBRUARY).get(DayOfWeek.MONDAY).forEach(System.out::println);
        System.out.println();

        System.out.println("Fechas de marzo que caen en jueves:");
        mapaFechas.get(Month.MARCH).get(DayOfWeek.THURSDAY).forEach(System.out::println);
        System.out.println();

        System.out.println("Fechas de diciembre que caen en domingo:");
        mapaFechas.get(Month.DECEMBER).get(DayOfWeek.SUNDAY).forEach(System.out::println);
    }
}
