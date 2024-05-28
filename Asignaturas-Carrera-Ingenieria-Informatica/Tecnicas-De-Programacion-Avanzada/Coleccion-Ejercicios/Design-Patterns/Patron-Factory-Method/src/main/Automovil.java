package main;

public class Automovil implements TransporteInterface {

    @Override
    public void arrancar() {
        System.out.println("Arrancando automovil...");
    }

    @Override
    public void detener() {
        System.out.println("Deteniendo automovil...");
    }

    @Override
    public String tipo() {
        return "Automovil";
    }

}
