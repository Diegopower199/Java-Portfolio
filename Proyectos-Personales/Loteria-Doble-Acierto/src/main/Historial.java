package main;

public class Historial {
    private int num1;
    private int num2;
    private int aciertos;

    public Historial(int num1, int num2, int aciertos) {
        this.num1 = num1;
        this.num2 = num2;
        this.aciertos = aciertos;
    }

    public int getNum1() {
        return num1;
    }

    public int getNum2() {
        return num2;
    }

    public int getAciertos() {
        return aciertos;
    }
}
