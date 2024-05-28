package main;

public class Main {
    public static void main(String[] args) {
        double[] coeficientes = new double[3];
        coeficientes[2] = 5;
        coeficientes[1] = 3;
        coeficientes[0] = 2;
        Polinomio polinomio = new Polinomio(coeficientes);
        System.out.println(polinomio.toString());

        for (int pos = 0; pos < polinomio.polinomio.size(); pos++) {
            System.out.println(polinomio.polinomio.get(pos));
        }

        polinomio.cuadrado(polinomio);
        System.out.println(polinomio.toString());
    }
}
