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
    private ArrayList<String> productos = new ArrayList<String>();
    private ArrayList<Integer> cantidades = new ArrayList<Integer>();
    private Scanner scan;
    private int stock_max = 80;
    boolean estadoActual = false;
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
                    retirarProductos();
                    escribirArchivo();

                } else if (option == 3) {
                    reponerMax();
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
                if (estadoActual == false) {
                    productos.add(texto);
                    estadoActual = true;
                } else {
                    cantidad = Integer.parseInt(texto);
                    cantidades.add(cantidad);
                    estadoActual = false;
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
        System.out.println("1) Mostrar stock\r\n" + "2) Retirar (n) productos\r\n" + "3)Reponer producto (al máx.)\r\n"
                + "4) Incluir productos nuevos (al máx.)\r\n" + "5) Salir\r\n" + "");
    }

    public void mostrarStock() throws IOException {
        archivo = new File("resources/Stock.txt");
        fr = new FileReader(archivo);
        br = new BufferedReader(fr);
        String linea;

        System.out.print("  Productos  " + "      Cantidades (máx . 80)\n -----------------------------------------\n");

        int saltoLinea = 0;

        while ((linea = br.readLine()) != null) {
            System.out.print("   " + linea + "                  ");
            if (saltoLinea < 1) {
                saltoLinea++;

            } else {
                saltoLinea = 0;
                System.out.println();
            }
        }
    }

    public void retirarProductos() {
        System.out.println("Que producto deseria retirar");
        String producto = scan.next();

        scan.nextLine();

        int retirar = 0;
        boolean retirarObjetoLista = false;

        while (retirarObjetoLista == false) {
            if (productos.contains(producto)) {

                int position = productos.indexOf(producto);

                if (cantidades.get(position) == 0) {
                    System.out
                            .println("No puedes retirar ninguna cantidad de este producto, ya que tiene 0 cantidades");
                    break;
                }
                System.out.print("Cuanta cantidad desea retirar: ");
                retirar = scan.nextInt();

                scan.nextLine();
                cantidades.set(position, cantidades.get(position) - retirar);

                if (cantidades.get(position) < 0) {
                    cantidades.set(position, 0);
                }
                escribirArchivo();
                retirarObjetoLista = true;
            } else {
                System.out.println("Ese objeto no esta en la lista, introduce otro ");
                producto = scan.next();
            }
        }

    }

    public void incluirProductosNuevos() {
        System.out.println("Que producto deseria incluir");
        String producto = scan.next();
        boolean incluirObjetoLista = false;

        while (incluirObjetoLista == false) {
            if (!productos.contains(producto)) {
                try {
                    productos.add(producto);
                    cantidades.add(80);
                    incluirObjetoLista = true;
                } catch (NullPointerException ex) {

                    System.out.println("Debe ingresar obligatoriamente una cadena de caracteres: ");
                    scan.next();
                }
            } else {
                System.out.println("Ese objeto ya esta en la lista, introduce otro ");
                producto = scan.next();
            }
        }

    }

    public void reponerMax() throws IOException {
        System.out.println("Que producto deseria reponer al maximo");
        String producto = scan.next();

        boolean reponerObjetoLista = false;

        while (reponerObjetoLista == false) {
            if (productos.contains(producto)) {
                int position = productos.indexOf(producto);
                cantidades.set(position, stock_max);
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
            for (int i = 0; i < productos.size(); i++) {
                pw.println(productos.get(i));
                pw.println(cantidades.get(i));
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
