package TiposElectrodomesticos;

import CreacionElectrodomestico.Electrodomestico;

public class Ordenador extends Electrodomestico {

    private static final int MEMORIA_CONSTANTE = 8;
    private static final boolean SSD_CONSTANTE = false;

    private int memoria;
    private boolean ssd;

    public Ordenador() {
        super();
        this.memoria = MEMORIA_CONSTANTE;
        this.ssd = SSD_CONSTANTE;
    }

    public Ordenador(double precioBase, double peso) {
        super(precioBase, peso);
        this.memoria = MEMORIA_CONSTANTE;
        this.ssd = SSD_CONSTANTE;
    }

    public Ordenador(double precioBase, String color, char consumoEnergetico, double peso, int memoria, boolean ssd) {
        super(precioBase, color, consumoEnergetico, peso);
        this.memoria = memoria;
        this.ssd = ssd;
    }

    public int getMemoria() {
        return memoria;
    }

    public boolean isSsd() {
        return ssd;
    }

    @Override
    public double precioFinal() {
        double precioFinal = super.precioFinal();
        if (memoria > 16) {
            precioFinal += 200;
        }
        if (ssd) {
            precioFinal += 100;
        }
        return precioFinal;
    }
}
