package contadores;

import base.ContadorBase;

public class ContadorPalabras extends ContadorBase {
    public ContadorPalabras(String nombre) {
        super(nombre);
    }

    @Override
    public void procesarLinea(String linea) {
        contador += linea.split("\\s+").length;
    }
}
