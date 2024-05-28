package TiposElectrodomesticos;

import CreacionElectrodomestico.Electrodomestico;

public class Lavadora extends Electrodomestico {

    private static final double CARGA_CONSTANTE = 5;

    private double carga;

    public Lavadora() {
        super();
        this.carga = CARGA_CONSTANTE;
    }

    public Lavadora(double precioBase, double peso) {
        super(precioBase, peso);
        this.carga = CARGA_CONSTANTE;
    }

    public Lavadora(double precioBase, String color, char consumoEnergetico, double peso, double carga) {
        super(precioBase, color, consumoEnergetico, peso);
        this.carga = carga;
    }

    public double getCarga() {
        return carga;
    }

    @Override
    public double precioFinal() {
        double precioFinal = super.precioFinal();
        if (carga > 30) {
            precioFinal += 50;
        }
        return precioFinal;
    }
}
