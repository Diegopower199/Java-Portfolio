package main;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    final static int MAXCADENA = 20;

    static Scanner scan = new Scanner(System.in);
    static int opcionElegida = 0;
    static ArrayList<String> vNombreCompleto = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        System.out.println("BIENVENIDOS AL PROGRAMA GESTION NOMBRE ALUMNOS: ");
        pintaMenu();

        while (opcionElegida != 0) {
            switch (opcionElegida) {
                case 1:
                    nuevoAlumno();
                    break;
                case 2:
                    listarAlumnos();
                    break;
                case 3:
                    modificarNombreAlumno();
                    break;
                case 4:
                    eliminarAlumno();
                    break;
                case 5:
                    buscarAlumno();
                    break;
            }

            pintaMenu();
        }
    }

    static void pintaMenu() {
        System.out.println("1. Insertar un alumno.");
        System.out.println("2. Listar alumnos.");
        System.out.println("3. Modificar nombre del alumno.");
        System.out.println("4. Eliminar alumno.");
        System.out.println("5. Buscar alumno.");
        System.out.println("0. Salir.");
        pideNumEntreRango(0, 5);
    }

    static int pideNumEntreRango(int min, int max) {
        System.out.print("Escoge una opcion(" + min + "-" + max + "): ");
        opcionElegida = scan.nextInt();
        scan.nextLine();

        while (opcionElegida < min || opcionElegida > max) {
            System.out.print("Error, fuera del rango. Escoge una opcion: ");
            opcionElegida = scan.nextInt();
            scan.nextLine();
        }
        return opcionElegida;
    }

    static void listarAlumnos() {
        if (vNombreCompleto.isEmpty()) {
            System.out.println("No hay alumnos en el array de cadenas.");
            return;
        }
        for (int i = 0; i < vNombreCompleto.size(); i++) {
            System.out.println((i + 1) + ". " + vNombreCompleto.get(i));
        }
    }

    static void nuevoAlumno() {
        System.out.print("Introduce el nombre de un alumno: ");
        String nombre = scan.nextLine();
        if (nombre.length() > MAXCADENA) {
            System.out.println("Error, se ha pasado del limite.");
            return;
        }
        vNombreCompleto.add(nombre);
        System.out.println("Alumno añadido.");
    }

    static void modificarNombreAlumno() {
        listarAlumnos();
        System.out.print("Introduce el numero del alumno que quieres modificar: ");
        int indice = scan.nextInt() - 1;
        scan.nextLine();

        if (indice < 0 || indice >= vNombreCompleto.size()) {
            System.out.println("Indice invalido.");
            return;
        }

        System.out.print("Introduce el nuevo nombre del alumno: ");
        String nuevoNombre = scan.nextLine();
        if (nuevoNombre.length() > MAXCADENA) {
            System.out.println("Error, se ha pasado del limite.");
            return;
        }

        vNombreCompleto.set(indice, nuevoNombre);
        System.out.println("Nombre del alumno actualizado.");
    }

    static void eliminarAlumno() {
        listarAlumnos();
        System.out.print("Introduce el numero del alumno que quieres eliminar: ");
        int indice = scan.nextInt() - 1;
        scan.nextLine();

        if (indice < 0 || indice >= vNombreCompleto.size()) {
            System.out.println("Indice invalido.");
            return;
        }

        vNombreCompleto.remove(indice);
        System.out.println("Alumno eliminado.");
    }

    static void buscarAlumno() {
        System.out.print("Introduce el nombre del alumno que quieres buscar: ");
        String nombre = scan.nextLine();
        boolean encontrado = false;

        for (int i = 0; i < vNombreCompleto.size(); i++) {
            if (vNombreCompleto.get(i).equalsIgnoreCase(nombre)) {
                System.out.println("Alumno encontrado: " + (i + 1) + ". " + vNombreCompleto.get(i));
                encontrado = true;
            }
        }

        if (!encontrado) {
            System.out.println("No se encontró ningún alumno con ese nombre.");
        }
    }
}
