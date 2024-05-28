package main;

public class Main {
    public static void main(String[] args) {
        MiHilo hiloSI = new MiHilo("SI");
        MiHilo hiloNO = new MiHilo("NO");

        Thread threadSI = new Thread(hiloSI);
        Thread threadNO = new Thread(hiloNO);

        threadSI.start();
        threadNO.start();

        try {
            threadSI.join();
            threadNO.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
