package contadores;

import base.ContadorBase;

public class ContadorArticulos extends ContadorBase {
    public ContadorArticulos(String nombre) {
        super(nombre);
    }

    @Override
    public void procesarLinea(String linea) {
        if (linea.contains("Art")) {
            contador++;
        }
    }
}

