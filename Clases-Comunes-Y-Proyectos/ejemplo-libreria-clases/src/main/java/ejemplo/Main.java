package ejemplo;

import java.util.Map;

import commonclasses.animal.Animal;
import commonclasses.persona.Persona;

public class Main {
    public static void main(String[] args) {
        // Crear objetos de Persona y Animal
        Persona persona = new Persona("Juan", 25);
        Animal animal = new Animal("León", 5);

        // Imprimir usando toString
        System.out.println("Persona: " + persona.toString());
        System.out.println("Animal: " + animal.toString());

        // Convertir a Map usando toMap
        Map<String, Object> personaMap = persona.toMap();
        Map<String, Object> animalMap = animal.toMap();

        // Imprimir los Maps
        System.out.println("Persona Map: " + personaMap);
        System.out.println("Animal Map: " + animalMap);
    }
}
