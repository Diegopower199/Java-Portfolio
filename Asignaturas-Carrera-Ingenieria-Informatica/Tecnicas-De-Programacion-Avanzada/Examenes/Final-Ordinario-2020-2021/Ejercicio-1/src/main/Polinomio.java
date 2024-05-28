package main;

import java.util.ArrayList;

public class Polinomio {
    int grado;
    double[] coeficientes;

    ArrayList<Double> polinomio = new ArrayList<Double>();
    ArrayList<String> potencia = new ArrayList<String>();

    public Polinomio(double[] coeficientes) {
        this.grado = coeficientes.length - 1;
        this.coeficientes = new double[coeficientes.length];
        for (int i = 0; i < coeficientes.length; i++) {
            this.coeficientes[i] = coeficientes[i];
        }
    }

    public String toString() {
        if (grado == 0) {
            return "" + coeficientes[0];
        }
        if (grado == 1) {
            return coeficientes[1] + "x + " + coeficientes[0];
        }

        String s = coeficientes[grado] + "x^" + grado;
        System.out.println(coeficientes[grado]);

        polinomio.add(coeficientes[grado]);
        potencia.add(String.valueOf(grado));

        for (int i = grado - 1; i >= 0; i--) {
            if (coeficientes[i] == 0) {
                continue;
            } else if (coeficientes[i] > 0) {
                s = s + " + " + (coeficientes[i]);
                polinomio.add(coeficientes[i]);
                potencia.add(String.valueOf(i));
            } else if (coeficientes[i] < 0) {
                s = s + " - " + (-coeficientes[i]);
                polinomio.add(coeficientes[i]);
                potencia.add(String.valueOf(i));
            }
            if (i == 1) {
                s = s + "x";
            } else if (i > 1) {
                s = s + "x^" + i;

            }
        }
        return s;
    }

    public void ver() {
        for (int i = 0; i < coeficientes.length; i++) {
            System.out.println(coeficientes[i]);
        }
    }

    public Polinomio cuadrado(Polinomio p) {
        for (int pos = 0; pos < p.grado + 1; pos++) {
            for (int a = 0; a < p.grado + 1; a++) {
                p.coeficientes[pos] = Math.pow(p.coeficientes[pos], 2);
            }

        }

        return p;
    }
}
