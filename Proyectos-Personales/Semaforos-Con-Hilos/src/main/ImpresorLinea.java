package main;

import java.util.concurrent.Semaphore;

public class ImpresorLinea implements Runnable {
    private Semaphore semActual;
    private Semaphore semSiguiente;
    private String linea;

    public ImpresorLinea(Semaphore semActual, Semaphore semSiguiente, String linea) {
        this.semActual = semActual;
        this.semSiguiente = semSiguiente;
        this.linea = linea;
    }

    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                semActual.acquire();
                System.out.println(linea);
                Thread.sleep(1000);
                semSiguiente.release();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
