package commonclasses.animal;

import java.util.HashMap;
import java.util.Map;

public class Animal {
    private String especie;
    private int edad;

    public Animal(String especie, int edad) {
        this.especie = especie;
        this.edad = edad;
    }

    public String getEspecie() {
        return especie;
    }

    public int getEdad() {
        return edad;
    }

    @Override
    public String toString() {
        return "Animal {especie='" + especie + "', edad=" + edad + "}";
    }

    public Map<String, Object> toMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("especie", especie);
        map.put("edad", edad);
        return map;
    }
}
