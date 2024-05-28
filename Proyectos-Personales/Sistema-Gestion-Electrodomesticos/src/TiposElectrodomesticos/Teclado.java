package TiposElectrodomesticos;

import CreacionElectrodomestico.Electrodomestico;

public class Teclado extends Electrodomestico {

    private static final boolean INALAMBRICO_CONSTANTE = false;

    private boolean inalambrico;

    public Teclado() {
        super();
        this.inalambrico = INALAMBRICO_CONSTANTE;
    }

    public Teclado(double precioBase, double peso) {
        super(precioBase, peso);
        this.inalambrico = INALAMBRICO_CONSTANTE;
    }

    public Teclado(double precioBase, String color, char consumoEnergetico, double peso, boolean inalambrico) {
        super(precioBase, color, consumoEnergetico, peso);
        this.inalambrico = inalambrico;
    }

    public boolean isInalambrico() {
        return inalambrico;
    }

    @Override
    public double precioFinal() {
        double precioFinal = super.precioFinal();
        if (inalambrico) {
            precioFinal += 20;
        }
        return precioFinal;
    }
}
