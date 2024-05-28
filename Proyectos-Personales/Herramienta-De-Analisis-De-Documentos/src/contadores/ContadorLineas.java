package contadores;

import base.ContadorBase;

public class ContadorLineas extends ContadorBase {
    public ContadorLineas(String nombre) {
        super(nombre);
    }

    @Override
    public void procesarLinea(String linea) {
        contador++;
    }
}

