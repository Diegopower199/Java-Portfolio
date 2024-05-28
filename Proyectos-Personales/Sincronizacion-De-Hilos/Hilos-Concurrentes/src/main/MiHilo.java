package main;

class MiHilo implements Runnable {
    private String message;

    MiHilo(String message) {
        this.message = message;
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.print(message + " ");
        }
    }
}
