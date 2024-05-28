package TiposElectrodomesticos;

import CreacionElectrodomestico.Electrodomestico;

public class Raton extends Electrodomestico {

    private static final boolean INALAMBRICO_CONSTANTE = false;

    private boolean inalambrico;

    public Raton() {
        super();
        this.inalambrico = INALAMBRICO_CONSTANTE;
    }

    public Raton(double precioBase, double peso) {
        super(precioBase, peso);
        this.inalambrico = INALAMBRICO_CONSTANTE;
    }

    public Raton(double precioBase, String color, char consumoEnergetico, double peso, boolean inalambrico) {
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
