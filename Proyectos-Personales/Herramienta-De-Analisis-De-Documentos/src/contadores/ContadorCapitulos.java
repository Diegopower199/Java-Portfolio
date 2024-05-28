package contadores;

import base.ContadorBase;

public class ContadorCapitulos extends ContadorBase {
    public ContadorCapitulos(String nombre) {
        super(nombre);
    }

    @Override
    public void procesarLinea(String linea) {
        if (linea.contains("CAPITULO")) {
            contador++;
        }
    }
}

