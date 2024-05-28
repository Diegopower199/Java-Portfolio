package contadores;

import base.ContadorBase;

public class ContadorPalabraRey extends ContadorBase {
    public ContadorPalabraRey(String nombre) {
        super(nombre);
    }

    @Override
    public void procesarLinea(String linea) {
        if (linea.contains("Rey")) {
            contador++;
        }
    }
}
