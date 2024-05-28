package main;

public class Main {
    public static void main(String[] args) {
        ComponenteLexicoBasico etiquetaLexica;

        String programa = "{\r\n"
                + " float suma = 0.0;\r\n"
                + " int [10] v;\r\n"
                + " for (int k=0; k<10; k=k+1) {\r\n"
                + " if (k % 2 == 0)\r\n"
                + " suma = suma + k*10.5;\r\n"
                + " else\r\n"
                + " suma = suma + k*15.75;\r\n"
                + " v[i] = suma;\r\n"
                + " }\r\n"
                + " if (suma <= 25.0)\r\n"
                + " suma = suma / 2.5;\r\n"
                + " else\r\n"
                + " suma = suma * 4.5;\r\n"
                + "}";

        LexicoBasico lexico = new LexicoBasico(programa);

        int c = 0;

        System.out.println("Test léxico basico \t" + programa + "\n");

        do {
            etiquetaLexica = lexico.getComponenteLexico();

            System.out.println("<" + etiquetaLexica.toString() + ">");

            c++;
        } while (!etiquetaLexica.getEtiqueta().equals("end_program"));

        System.out.println("\nComponentes léxicos: " + c + ", lineas: " + lexico.getLineas());
    }
}