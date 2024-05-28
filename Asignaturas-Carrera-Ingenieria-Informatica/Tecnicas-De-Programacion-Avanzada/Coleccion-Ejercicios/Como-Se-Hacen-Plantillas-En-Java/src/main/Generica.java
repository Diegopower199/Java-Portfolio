package main;

public class Generica {

    public <T> boolean generico(T valor1, T valor2) {
        if (valor1 == valor2) {
            return true;
        }

        else {
            return false;
        }
    }
}
