package main;

class SegundaEcuacion implements Runnable {
    Thread hilo;
    int x, y, z;
    double resultado = 0;

    public SegundaEcuacion(String nombre, int x, int y, int z) {
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

        resultado = Math.pow(5 * z - 7 * y + Math.pow(x, 2), 3) - Math.pow(4 * x + 3 * y - 8 * z, 2);

        try {
            hilo.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
