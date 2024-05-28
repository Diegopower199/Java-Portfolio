package main;

public class Bolas {

    protected int numeroIdentificador = 0;

    public Bolas() {
        this.numeroIdentificador = numeroAleatorio();
    }

    public int numeroAleatorio() {
        int num1 = 0;
        int num2 = 99999;
        return (int) Math.floor(Math.random() * (num1 - (num2 + 1)) + (num2));
    }

}
