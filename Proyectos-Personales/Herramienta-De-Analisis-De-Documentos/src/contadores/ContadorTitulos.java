package contadores;

import base.ContadorBase;

public class ContadorTitulos extends ContadorBase {
    public ContadorTitulos(String nombre) {
        super(nombre);
    }

    @Override
    public void procesarLinea(String linea) {
        if (linea.contains("TITULO")) {
            contador++;
        }
    }
}

