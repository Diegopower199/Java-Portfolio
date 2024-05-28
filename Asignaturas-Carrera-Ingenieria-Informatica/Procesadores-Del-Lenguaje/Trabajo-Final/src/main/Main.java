package main;

import java.nio.charset.StandardCharsets;

public class Main {
    public static void main(String[] args) {

        for (int pos = 1; pos <= 12; pos++) {

            boolean mostrarComponentesLexicos = true;
            String ficheroEntrada = "resources/programa" + pos + ".txt";

            ComponenteLexico etiquetaLexica;

            Lexico lexico = new Lexico(ficheroEntrada, StandardCharsets.UTF_8);
            if (mostrarComponentesLexicos)
                do {
                    etiquetaLexica = lexico.getComponenteLexico();
                } while (!etiquetaLexica.getEtiqueta().equals("end_program"));

            AnalizadorSintactico compilador = new AnalizadorSintactico(
                    new Lexico(ficheroEntrada, StandardCharsets.UTF_8));

            System.out.println("\n\n\n-------------------------------------------------------\n\n\n");
            compilador.programa();

            System.out.println("\nPrograma " + pos + "\n");
            System.out.println("\nTabla de simbolos \n" + compilador.tablaSimbolos());

            System.out.println("\n\nCódigo de la máquina de pila\r\n" + compilador.codigoMaquinaPila());
        }
    }
}
