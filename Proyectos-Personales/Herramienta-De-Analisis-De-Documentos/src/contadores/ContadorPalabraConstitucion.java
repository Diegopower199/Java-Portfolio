package contadores;

import base.ContadorBase;

public class ContadorPalabraConstitucion extends ContadorBase {
    public ContadorPalabraConstitucion(String nombre) {
        super(nombre);
    }

    @Override
    public void procesarLinea(String linea) {
        if (linea.contains("constitucion")) {
            contador++;
        }
    }
}

