package main;

import java.util.Comparator;

class ComparadorCitasPorTexto implements Comparator<CitaLiteraria> {
    @Override
    public int compare(CitaLiteraria cita1, CitaLiteraria cita2) {
        return cita1.getTexto().compareTo(cita2.getTexto());
    }
}
