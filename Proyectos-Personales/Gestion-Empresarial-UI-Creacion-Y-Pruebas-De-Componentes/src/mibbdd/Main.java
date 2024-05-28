package mibbdd;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class Main {

    static File archivo = null;
    static FileReader fr = null;
    static BufferedReader br = null;

    protected static String[] paisesLegibles = new String[249];
    protected static String[] codigoPaises = new String[249];

    public static void main(String[] args) {
        leerArchivo();
        new MenuPrincipal(paisesLegibles, codigoPaises);
    }

    public static void leerArchivo() {
        try {
            InputStream in = Thread.currentThread().getContextClassLoader()
                    .getResourceAsStream("Matriz_Simple_Paises.txt");
            InputStreamReader isr = new InputStreamReader(in,
                    StandardCharsets.UTF_8);
            BufferedReader br = new BufferedReader(isr);

            String texto;
            int inicio = 0;
            int fin = 0;
            String informacion = "";
            int lineaActual = 0;

            try {
                while ((texto = br.readLine()) != null) {
                    inicio = texto.indexOf(39, inicio - 1);
                    fin = texto.indexOf(39, inicio + 1);
                    informacion = texto.substring(inicio + 1, fin);
                    codigoPaises[lineaActual] = informacion;

                    texto = texto.substring(fin);

                    inicio = texto.indexOf(39, inicio);
                    fin = texto.indexOf(39, inicio + 1);
                    informacion = texto.substring(inicio + 1, fin);
                    paisesLegibles[lineaActual] = informacion;

                    lineaActual = lineaActual + 1;
                }
            } catch (NumberFormatException | IOException e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
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

}
