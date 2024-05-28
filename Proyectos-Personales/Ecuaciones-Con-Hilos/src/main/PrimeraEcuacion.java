package main;

class PrimeraEcuacion implements Runnable {
    Thread hilo;
    int x, y, z;
    double resultado = 0;

    public PrimeraEcuacion(String nombre, int x, int y, int z) {
        hilo = new Thread(this, nombre);
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public void run() {
        try {
            hilo.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        resultado = Math.pow(x + y, 2) - (4 * x + 3 * y - 2 * z);

        try {
            hilo.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
