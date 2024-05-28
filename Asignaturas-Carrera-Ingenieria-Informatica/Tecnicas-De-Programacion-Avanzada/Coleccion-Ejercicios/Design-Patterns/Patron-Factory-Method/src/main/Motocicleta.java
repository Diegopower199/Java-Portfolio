package main;

public class Motocicleta implements TransporteInterface {

    @Override
    public void arrancar() {
        System.out.println("Arrancando motocicleta...");
    }

    @Override
    public void detener() {
        System.out.println("Deteniendo motocicleta...");
    }

    @Override
    public String tipo() {
        return "Motocicleta";
    }

}
