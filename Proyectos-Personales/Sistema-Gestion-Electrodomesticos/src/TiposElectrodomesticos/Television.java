package TiposElectrodomesticos;

import CreacionElectrodomestico.Electrodomestico;

public class Television extends Electrodomestico {

    private static final int RESOLUCION_CONSTANTE = 20;
    private static final boolean SINTONIZADOR_TDT_CONSTANTE = false;

    private int resolucion;
    private boolean sintonizadorTDT;

    public Television() {
        super();
        this.resolucion = RESOLUCION_CONSTANTE;
        this.sintonizadorTDT = SINTONIZADOR_TDT_CONSTANTE;
    }

    public Television(double precioBase, double peso) {
        super(precioBase, peso);
        this.resolucion = RESOLUCION_CONSTANTE;
        this.sintonizadorTDT = SINTONIZADOR_TDT_CONSTANTE;
    }

    public Television(double precioBase, String color, char consumoEnergetico, double peso, int resolucion,
            boolean sintonizadorTDT) {
        super(precioBase, color, consumoEnergetico, peso);
        this.resolucion = resolucion;
        this.sintonizadorTDT = sintonizadorTDT;
    }

    public int getResolucion() {
        return resolucion;
    }

    public boolean isSintonizadorTDT() {
        return sintonizadorTDT;
    }

    @Override
    public double precioFinal() {
        double precioFinal = super.precioFinal();
        if (resolucion > 40) {
            precioFinal += precioFinal * 0.3;
        }
        if (sintonizadorTDT) {
            precioFinal += 50;
        }
        return precioFinal;
    }
}
