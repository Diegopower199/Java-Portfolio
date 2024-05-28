package main;

public class Fabrica {

    public static TransporteInterface construir(String tipo) {
        if (tipo == "Motocicleta") {
            return new Motocicleta();
        } else if (tipo == "Automovil") {
            return new Automovil();
        }
        return null;
    }

}
