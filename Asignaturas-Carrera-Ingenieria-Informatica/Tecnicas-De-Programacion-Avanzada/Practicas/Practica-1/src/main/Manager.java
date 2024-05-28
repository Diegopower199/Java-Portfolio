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

public class Manager {

    ArrayList<Integer> numeros = new ArrayList<Integer>();
    File archivo = null;
    FileReader fr = null;
    BufferedReader br = null;

    public Manager() throws IOException {

        Scanner teclado = new Scanner(System.in);
        int option = 0;
        System.out.println("¡Buenos días! ¿Qué desea hacer?\n");

        while (option != 6) {
            menu();

            try {
                option = teclado.nextInt();

                if (option == 1) {
                    try {
                        archivo = new File("resources/practica1JavaArchivo.txt");
                        fr = new FileReader(archivo);
                        br = new BufferedReader(fr);
                        String texto;
                        while ((texto = br.readLine()) != null) {
                            int numEntero = Integer.parseInt(texto);
                            numeros.add(numEntero);
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

                if (option == 2) {
                    archivo = new File("resources/practica1JavaArchivo.txt");
                    fr = new FileReader(archivo);
                    br = new BufferedReader(fr);
                    String linea;
                    while ((linea = br.readLine()) != null) {
                        System.out.print(linea + ", ");
                    }

                    if (archivo.length() == 0) {
                        System.out.println("Archivo vacio");
                    }

                    else {
                        System.out.println("Archivo con informacion");
                    }

                    if (numeros.size() == 0) {
                        System.out.println("Array vacio");
                    }

                    System.out.println("");

                }

                if (option == 3) {
                    Scanner introducirNumeros = new Scanner(System.in);
                    int numeroUsuario = 1;
                    while (numeroUsuario != 0) {

                        try {
                            numeroUsuario = introducirNumeros.nextInt();
                            numeros.add(numeroUsuario);
                        } catch (InputMismatchException ex) {
                            System.out.println("Debe ingresar obligatoriamente un número entero: ");
                            introducirNumeros.next();
                        }
                    }
                    introducirNumeros.close();
                }

                if (option == 4) {
                    File archivo = new File("resources/practica1JavaArchivo.txt");
                    FileReader fr = new FileReader(archivo);
                    BufferedReader br = new BufferedReader(fr);

                    int sumaTotal = 0;

                    for (int i = 0; i < numeros.size(); i++) {
                        sumaTotal += numeros.get(i);
                    }
                    System.out.println(sumaTotal);

                    br.close();
                }

                if (option == 5) {
                    FileWriter fichero = null;
                    PrintWriter pw = null;
                    try {
                        fichero = new FileWriter("resources/practica1JavaArchivo.txt");
                        pw = new PrintWriter(fichero);
                        for (int i = 0; i < numeros.size(); i++) {
                            pw.println(numeros.get(i));
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

            catch (InputMismatchException e) {
                System.out.println("Debe ingresar obligatoriamente un número entero.");
                teclado.next();
            }

        }
    }

    public void menu() throws IOException {
        System.out.println("1 - Cargar números desde un archivo (.txt)\n" + "2 - Mostrar números\n"
                + "3 - Añadir números (enteros)\n" + "4 - Calcular la suma total del array\n"
                + "5 - Guardar los valores introducidos en un archivo (.txt)\n" + "6 - Salir");

    }

}
