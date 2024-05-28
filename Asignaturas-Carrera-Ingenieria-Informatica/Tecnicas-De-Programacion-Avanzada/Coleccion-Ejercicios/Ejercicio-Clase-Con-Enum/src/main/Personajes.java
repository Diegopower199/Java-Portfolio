package main;

import java.util.ArrayList;

public enum Personajes {

    ELF("elfo"), DWARF("dwarf"), ORC("orc");

    private String personaje = "";

    Personajes(String personaje) {
        this.personaje = personaje;
    }

    public String getPersonajes() {
        return personaje;
    }

    public static ArrayList<String> enumIteration() {
        Personajes[] races = Personajes.values();
        ArrayList<String> stringPersonajes = new ArrayList<String>();
        for (Personajes race : races) {
            stringPersonajes.add(race.toString());
        }
        return stringPersonajes;
    }
}
