package main;

import java.util.ArrayList;

public final class BomboPremios extends Bolas {

    ArrayList<String> numeros = new ArrayList<String>();
    private static BomboPremios instance;

    public static BomboPremios getInstance() {
        if (instance == null) {
            instance = new BomboPremios();
        }
        return instance;
    }

}
