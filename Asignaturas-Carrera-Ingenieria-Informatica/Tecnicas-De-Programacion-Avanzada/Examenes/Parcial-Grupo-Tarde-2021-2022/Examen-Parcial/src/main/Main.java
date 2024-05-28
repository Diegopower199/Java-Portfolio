package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    private ArrayList<String> componentes = new ArrayList<String>();
    private ArrayList<String> GPIO = new ArrayList<String>();
    private ArrayList<Integer> pines = new ArrayList<Integer>();

    private Scanner scan;
    private int pines_max = 20;
    int lineaActual = 1;
    File archivo = null;
    FileReader fr = null;
    BufferedReader br = null;

    public static void main(String[] args) throws IOException {
        Main myM = new Main();
        myM.printMenu();
    }

    public Main() throws IOException {
        scan = new Scanner(System.in);
        int option = 0;
        System.out.println("¿Qué desea hacer?\n");
        leerArchivo();
        while (option != 5) {
            printMenu();

            try {
                option = scan.nextInt();
                scan.nextLine();
                while (option <= 0 || option >= 6) {
                    System.out.println("Esa opcion no esta disponible, introduce otra: ");
                    option = scan.nextInt();
                }

                if (option == 1) {
                    mostrarStock();
                } else if (option == 2) {
                    changePinesSelected();
                    escribirArchivo();
                } else if (option == 3) {
                    eliminarComponente();
                    escribirArchivo();
                } else if (option == 4) {
                    incluirProductosNuevos();
                    escribirArchivo();
                }
            } catch (InputMismatchException e) {
                System.out.println("Debe ingresar obligatoriamente un número entero.");
                scan.next();
            }
        }
    }

    public void leerArchivo() throws IOException {
        try {
            archivo = new File("resources/Stock.txt");
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);
            String texto;
            int cantidad = 0;

            while ((texto = br.readLine()) != null) {
                if (lineaActual == 1) {
                    componentes.add(texto);
                    lineaActual = lineaActual + 1;
                } else if (lineaActual == 2) {
                    GPIO.add(texto);
                    lineaActual = lineaActual + 1;
                } else if (lineaActual == 3) {
                    cantidad = Integer.parseInt(texto);
                    pines.add(cantidad);
                    lineaActual = 1;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }

    }

    public void printMenu() {
        System.out.println("1) Mostrar pines ocupados\n" + "2) Cambiar pines asignados\n" + "3) Eliminar componente\n"
                + "4) Incluir componentes nuevos\r\n" + "5) Salir\r\n" + "");
    }

    public void mostrarStock() throws IOException {
        archivo = new File("resources/Stock.txt");
        fr = new FileReader(archivo);
        br = new BufferedReader(fr);
        String linea;

        System.out.print(
                "  Componentes/Tipo  " + "      Pin (máx . PIN 20)\n -----------------------------------------\n");

        int saltoLinea = 0;

        while ((linea = br.readLine()) != null) {
            System.out.print("  " + linea + "");
            if (saltoLinea < 1) {
                System.out.print(" /");
                saltoLinea++;
            } else if (saltoLinea < 2) {
                saltoLinea++;
                System.out.print("            ");
            } else {
                saltoLinea = 0;
                System.out.println();
            }
        }

        System.out.println("");
    }

    public void changePinesSelected() {
        System.out.println("Elige el pin que quieras cambiar");
        int pinSeleccionadoUsuario = scan.nextInt();
        scan.nextLine();
        System.out.println("Introduce el valor que quieres que tenga ahora todos ellos: ");
        int valorPin = scan.nextInt();
        scan.nextLine();
        boolean pinNoIdentificado = false;
        while (pines.contains(pinSeleccionadoUsuario) && valorPin >= 0 && valorPin <= 20) {
            int position = pines.indexOf(pinSeleccionadoUsuario);
            pines.set(position, valorPin);
            pinNoIdentificado = true;
        }

        if (pinNoIdentificado == false) {
            System.out.println("No hay ningun pin con ese valor");
        }
    }

    public void eliminarComponente() {
        System.out.println("Que producto deseria retirar");
        String producto = scan.next();

        scan.nextLine();

        if (componentes.contains(producto)) {
            int position = componentes.indexOf(producto);
            componentes.remove(position);
            GPIO.remove(position);
            pines.remove(position);
        } else {
            System.out.println("Ese objeto no esta en la lista");
        }
    }

    public void incluirProductosNuevos() {
        boolean nombrePosible = true;
        boolean GPIOPosible = false;
        boolean pinPosible = false;
        System.out.println("Que producto deseria incluir\nNombre:");
        String producto = scan.next();
        System.out.println("Entrada/Salida: ");
        String entradaSalidaElegir = scan.next();

        if (entradaSalidaElegir.equals("entrada") || entradaSalidaElegir.equals("Entrada")) {
            entradaSalidaElegir = "Input";
            GPIOPosible = true;
        } else if (entradaSalidaElegir.equals("salida") || entradaSalidaElegir.equals("Salida")) {
            entradaSalidaElegir = "Output";
            GPIOPosible = true;
        } else {
            System.out.println("GPIO no valido");
        }

        System.out.println("Pin: ");
        int pinSeleccionado = scan.nextInt();
        scan.nextLine();

        if (pinSeleccionado < 0 || pinSeleccionado > 20) {
            System.out.println("Pin no valido, introduce otro: ");
        } else {
            pinPosible = true;
        }

        if (nombrePosible == true && GPIOPosible == true && pinPosible == true) {
            if (!componentes.contains(producto)) {
                try {
                    componentes.add(producto);
                    GPIO.add(entradaSalidaElegir);
                    pines.add(20);
                } catch (NullPointerException ex) {
                    System.out.println("Debe ingresar obligatoriamente una cadena de caracteres: ");
                    scan.next();
                }
            } else {
                System.out.println("Ese objeto ya esta en la lista");
            }
        }
    }

    public void reponerMax() throws IOException {
        System.out.println("Que producto deseria reponer al maximo");
        String producto = scan.next();
        boolean reponerObjetoLista = false;

        while (reponerObjetoLista == false) {
            if (componentes.contains(producto)) {
                int position = componentes.indexOf(producto);
                pines.set(position, pines_max);
                reponerObjetoLista = true;
                escribirArchivo();
            } else {
                System.out.println("Ese objeto no esta en la lista, introduce otro ");
                producto = scan.next();
            }
        }
    }

    public void escribirArchivo() {
        FileWriter fichero = null;
        PrintWriter pw = null;
        try {
            fichero = new FileWriter("resources/Stock.txt");
            pw = new PrintWriter(fichero);
            for (int i = 0; i < componentes.size(); i++) {
                pw.println(componentes.get(i));
                pw.println(GPIO.get(i));
                pw.println(pines.get(i));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != fichero) {
                    fichero.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
