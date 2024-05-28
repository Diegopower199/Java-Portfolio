package commonclasses.persona;

import java.util.HashMap;
import java.util.Map;

public class Persona {
    private String nombre;
    private int edad;

    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    @Override
    public String toString() {
        return "Persona {nombre='" + nombre + "', edad=" + edad + "}";
    }

    public Map<String, Object> toMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("nombre", nombre);
        map.put("edad", edad);
        return map;
    }
}
