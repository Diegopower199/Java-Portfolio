package main;

import java.util.Comparator;

class ComparadorCitasPorLongitud implements Comparator<CitaLiteraria> {
    @Override
    public int compare(CitaLiteraria cita1, CitaLiteraria cita2) {
        return Integer.compare(cita1.getTexto().length(), cita2.getTexto().length());
    }
}
