package main;

import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) {
        Semaphore sem1 = new Semaphore(1);
        Semaphore sem2 = new Semaphore(0);
        Semaphore sem3 = new Semaphore(0);
        Semaphore sem4 = new Semaphore(0);

        Thread hilo1 = new Thread(new ImpresorLinea(sem1, sem2, "Dale a tu cuerpo alegría Macarena"));
        Thread hilo2 = new Thread(new ImpresorLinea(sem2, sem3, "Que tu cuerpo es pa darle alegría y cosa buena"));
        Thread hilo3 = new Thread(new ImpresorLinea(sem3, sem4, "Dale a tu cuerpo alegría Macarena"));
        Thread hilo4 = new Thread(new ImpresorLinea(sem4, sem1, "Heeeeyyyyy Macarena"));

        hilo1.start();
        hilo2.start();
        hilo3.start();
        hilo4.start();
    }
}
