package main;

import java.util.ArrayList;

public final class BaseDatos {

    private static BaseDatos BD;

    private ArrayList<String> Personas;

    public BaseDatos() {
        Personas = new ArrayList<String>();
    }

    public void add(String name) {
        Personas.add(name);
    }

    public static BaseDatos getInstance() {
        if (BD == null) {
            BD = new BaseDatos();
        }
        return BD;
    }
}
