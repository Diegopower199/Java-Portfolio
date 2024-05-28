package main;

public class MotorElectrico {

    private boolean conectado = false;

    public MotorElectrico() {
        super();
        System.out.println("Creando motor electrico...");
    }

    public void conectar() {
        System.out.println("Conectando motor electrico...");
        this.conectado = true;
    }

    public void activar() {
        if (!this.conectado) {
            System.out.println("No se puede activar porque no esta conectado el motor electrico...");
        } else {
            System.out.println("Activando motor electrico...");
        }
    }

    public void moverMasRapido() {
        if (!this.conectado) {
            System.out.println("No se puede mover rapido porque no esta conectado el motor electrico...");
        } else {
            System.out.println("Moviendo rapido el motor electrico...");
        }
    }

    public void detener() {
        if (!this.conectado) {
            System.out.println("No se puede detener porque no esta conectado el motor electrico...");
        } else {
            System.out.println("Deteniendo motor electrico...");
        }
    }

    public void desconectar() {
        if (!this.conectado) {
            System.out.println("No se puede desconectar porque no esta conectado el motor electrico...");
        } else {
            System.out.println("Desconectando motor electrico...");
        }
    }

}
