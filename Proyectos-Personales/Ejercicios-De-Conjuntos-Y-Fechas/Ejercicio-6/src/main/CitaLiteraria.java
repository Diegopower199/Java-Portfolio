package main;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CitaLiteraria {
    private final String texto;
    private final List<String> obras;

    public CitaLiteraria(String texto, String... obras) {
        this.texto = texto;
        this.obras = new LinkedList<>();
        this.obras.addAll(Arrays.asList(obras));
    }

    public String getTexto() {
        return this.texto;
    }

    public List getUsos() {
        return this.obras;
    }

    @Override
    public String toString() {
        return String.format("{\"%s\", %s}",
                this.getTexto(),
                this.getUsos());
    }
}
