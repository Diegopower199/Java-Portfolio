package main;

import java.util.ArrayList;

public final class BomboNumeros extends Bolas {

    ArrayList<Integer> numeros = new ArrayList<Integer>();
    protected int numeroIdentificador = 0;
    private static BomboNumeros instance;

    public BomboNumeros() {
        numeroIdentificador = numeroAleatorio();
    }

    public static BomboNumeros getInstance() {
        if (instance == null) {
            instance = new BomboNumeros();
        }
        return instance;
    }

}
