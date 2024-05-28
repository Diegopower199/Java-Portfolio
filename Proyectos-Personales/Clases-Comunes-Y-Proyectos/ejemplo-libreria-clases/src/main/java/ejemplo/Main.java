package ejemplo;

import java.util.Map;

import commonclasses.animal.Animal;
import commonclasses.persona.Persona;

public class Main {
    public static void main(String[] args) {

        Persona persona = new Persona("Juan", 25);
        Animal animal = new Animal("León", 5);

        System.out.println("Persona: " + persona.toString());
        System.out.println("Animal: " + animal.toString());

        Map<String, Object> personaMap = persona.toMap();
        Map<String, Object> animalMap = animal.toMap();

        System.out.println("Persona Map: " + personaMap);
        System.out.println("Animal Map: " + animalMap);
    }
}
