package main;

public class Main {
    public static void main(String[] args) {

        AutomovilInterface carro = new AutoElectricoFeature(new CarroEstandar("Chevy"));
        carro.encender();
        carro.acelerar();
        carro.detener();
    }
}
