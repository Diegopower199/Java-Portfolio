package main;

import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    static private Scanner scan;

    public static void main(String[] args) throws IOException {
        scan = new Scanner(System.in);
        int opcion = -1;

        while (opcion != 0) {
            printMenu();

            try {
                opcion = scan.nextInt();
                scan.nextLine();
                while (opcion < 0 || opcion > 5) {
                    System.out.println("Esa opción no está disponible, introduce otra: ");
                    opcion = scan.nextInt();
                    scan.nextLine();
                }

                switch (opcion) {
                    case 1:
                        crearArchivo();
                        break;
                    case 2:
                        editarArchivo();
                        break;
                    case 3:
                        borrarArchivo();
                        break;
                    case 4:
                        crearCarpeta();
                        break;
                    case 5:
                        borrarCarpeta();
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Debe ingresar obligatoriamente un número entero.");
                scan.next();
            }
        }
        System.out.println("Programa finalizado");
    }

    static public void printMenu() {
        System.out.println("1) Crear un archivo de texto\n" +
                "2) Editar un archivo de texto\n" +
                "3) Borrar un archivo de texto\n" +
                "4) Crear una carpeta\n" +
                "5) Borrar una carpeta\n" +
                "0) Salir\n" +
                "Opción: ");
    }

    static public void crearArchivo() throws IOException {
        System.out.println("Introduzca la ruta donde desea crear el archivo:");
        String ruta = scan.nextLine();
        System.out.println("Introduzca el nombre del nuevo archivo de texto:");
        String nombreDocumentoTexto = scan.nextLine();
        String rutaCompleta = ruta + File.separator + nombreDocumentoTexto + ".txt";

        File archivo = new File(rutaCompleta);

        if (!archivo.exists()) {
            System.out.println("Se va a crear un nuevo archivo de texto");
            archivo.createNewFile();
        } else {
            System.out.println("El archivo ya existe");
        }
    }

    static public void editarArchivo() {
        System.out.println("Introduzca la ruta del archivo a editar:");
        String nombreArchivoEditar = scan.nextLine();

        File archivo = new File(nombreArchivoEditar);
        if (!archivo.exists()) {
            System.out.println("Archivo inexistente");
        } else {
            System.out.println("Introduzca el texto que desea añadir al archivo: ");
            String textoUsuario = scan.nextLine();

            try (FileWriter fichero = new FileWriter(archivo, true);
                    PrintWriter pw = new PrintWriter(fichero)) {
                pw.println(textoUsuario);
                System.out.println("Archivo editado correctamente");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    static public void borrarArchivo() {
        System.out.println("Introduzca la ruta del archivo a borrar:");
        String nombreArchivoEliminar = scan.nextLine();

        File archivo = new File(nombreArchivoEliminar);
        if (!archivo.exists()) {
            System.out.println("Archivo inexistente");
        } else {
            System.out.println("¿Está seguro que desea borrarlo (Afirmación Si)?");
            String afirmacion = scan.nextLine();

            if (afirmacion.equalsIgnoreCase("Si")) {
                archivo.delete();
                System.out.println("Archivo borrado correctamente");
            } else {
                System.out.println("Operación de borrado cancelada");
            }
        }
    }

    static public void crearCarpeta() {
        System.out.println("Introduzca la ruta donde desea crear la carpeta:");
        String ruta = scan.nextLine();
        System.out.println("Introduzca el nombre de la carpeta a crear:");
        String nombreCarpeta = scan.nextLine();
        String rutaCompleta = ruta + File.separator + nombreCarpeta;

        File carpeta = new File(rutaCompleta);

        if (!carpeta.exists()) {
            System.out.println("Carpeta se va a crear una nueva");
            carpeta.mkdirs();
        } else {
            System.out.println("La carpeta ya existe");
        }
    }

    static public void borrarCarpeta() {
        System.out.println("Introduzca la ruta de la carpeta a borrar:");
        String rutaCarpetaEliminar = scan.nextLine();

        File carpeta = new File(rutaCarpetaEliminar);
        if (!carpeta.exists()) {
            System.out.println("Carpeta inexistente");
        } else {
            System.out.println("¿Está seguro que desea borrarla (Afirmación Si)?");
            String afirmacion = scan.nextLine();

            if (afirmacion.equalsIgnoreCase("Si")) {
                carpeta.delete();
                System.out.println("Carpeta borrada correctamente");
            } else {
                System.out.println("Operación de borrado cancelada");
            }
        }
    }
}
