package main;

public class MotorComun implements Motor {

    public MotorComun() {
        super();
        System.out.println("Creando motor comun...");

    }

    @Override
    public void encender() {
        System.out.println("Encendiendo motor comun...");
    }

    @Override
    public void acelerar() {
        System.out.println("Acelerando motor comun...");
    }

    @Override
    public void apagar() {
        System.out.println("Apagando motor comun...");
    }

}
