package main;

public class CarroEstandar implements AutomovilInterface {

    private String nombre;

    public CarroEstandar(String s) {
        super();
        this.nombre = s;
    }

    @Override
    public void acelerar() {
        System.out.println("Acelerando el carro...");
    }

    @Override
    public void detener() {
        System.out.println("Deteniendo el carro...");
    }

    @Override
    public void encender() {
        System.out.println("Encendiendo el carro...");
    }

}
