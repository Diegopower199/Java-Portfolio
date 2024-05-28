package main;

class CalculoTotal implements Runnable {
    Thread hilo;
    double resultadoEcuacion1;
    double resultadoEcuacion2;
    double resultadoTotal = 0;

    public CalculoTotal(String nombre, double resultadoEcuacion1, double resultadoEcuacion2) {
        hilo = new Thread(this, nombre);
        this.resultadoEcuacion1 = resultadoEcuacion1;
        this.resultadoEcuacion2 = resultadoEcuacion2;

    }

    public void run() {
        resultadoTotal = resultadoEcuacion1 + resultadoEcuacion2;
        System.out.println("El resultado es: " + resultadoTotal);
    }
}
