package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {

        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {
            archivo = new File("resources/PersonajesPracticar.txt");
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            String linea;

            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (fr != null) {
                    fr.close();
                }
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }

        Personajes personaje = null;
        ArrayList<String> stringPersonajes = new ArrayList<String>();
        stringPersonajes = personaje.enumIteration();

        System.out.println("---------------------");

        FileWriter fichero = null;
        PrintWriter pw = null;
        try {
            fichero = new FileWriter("resources/PersonajesPracticar.txt", true);
            pw = new PrintWriter(fichero);
            for (int i = 0; i < stringPersonajes.size(); i++)
                pw.println(stringPersonajes.get(i));
        } catch (Exception e4) {
            e4.printStackTrace();
        } finally {
            try {
                if (null != fichero)
                    fichero.close();
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }

    }

}
