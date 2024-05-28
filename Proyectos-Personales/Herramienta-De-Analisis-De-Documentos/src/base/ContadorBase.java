package base;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public abstract class ContadorBase implements Runnable {
    private String nombre;
    protected int contador = 0;

    public ContadorBase(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void run() {
        try {
            leerArchivo();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public abstract void procesarLinea(String linea);

    private void leerArchivo() throws IOException {
        File archivo = new File("resources/Constitucion1812.txt");
        try (FileReader fr = new FileReader(archivo);
             BufferedReader br = new BufferedReader(fr)) {
            String linea;
            while ((linea = br.readLine()) != null) {
                procesarLinea(linea);
            }
        }
        System.out.println(nombre + ": " + contador);
    }
}

