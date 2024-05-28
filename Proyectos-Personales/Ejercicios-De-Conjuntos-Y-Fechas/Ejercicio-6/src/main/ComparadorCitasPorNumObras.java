package main;

import java.util.Comparator;

class ComparadorCitasPorNumObras implements Comparator<CitaLiteraria> {
    @Override
    public int compare(CitaLiteraria cita1, CitaLiteraria cita2) {
        return Integer.compare(cita1.getUsos().size(), cita2.getUsos().size());
    }
}
