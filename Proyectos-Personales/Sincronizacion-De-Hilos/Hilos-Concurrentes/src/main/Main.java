package main;

public class Main {
    public static void main(String[] args) {
        MiHilo hilo1 = new MiHilo("SI");
        MiHilo hilo2 = new MiHilo("NO");

        Thread thread1 = new Thread(hilo1);
        Thread thread2 = new Thread(hilo2);

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
