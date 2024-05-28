package CreacionElectrodomestico;

public class Electrodomestico {

    private static final char[] CONSUMO_ENERGETICO_DISPONIBLE = { 'A', 'B', 'C', 'D', 'E', 'F' };
    private static final String[] COLORES_DISPONIBLES = { "blanco", "negro", "rojo", "azul", "gris" };

    private static final double PRECIO_BASE_CONSTANTE = 100;
    private static final String COLOR_CONSTANTE = "blanco";
    private static final char CONSUMO_ENERGETICO_CONSTANTE = 'F';
    private static final double PESO_CONSTANTE = 5;

    protected double precioBase;
    protected String color;
    protected char consumoEnergetico;
    protected double peso;

    public Electrodomestico() {
        this(PRECIO_BASE_CONSTANTE, COLOR_CONSTANTE, CONSUMO_ENERGETICO_CONSTANTE, PESO_CONSTANTE);
    }

    public Electrodomestico(double precioBase, double peso) {
        this(precioBase, COLOR_CONSTANTE, CONSUMO_ENERGETICO_CONSTANTE, peso);
    }

    public Electrodomestico(double precioBase, String color, char consumoEnergetico, double peso) {
        this.precioBase = precioBase;
        setColor(color);
        setConsumoEnergetico(consumoEnergetico);
        this.peso = peso;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    public String getColor() {
        return color;
    }

    public char getConsumoEnergetico() {
        return consumoEnergetico;
    }

    public double getPeso() {
        return peso;
    }

    private void setConsumoEnergetico(char consumoEnergetico) {
        boolean found = false;
        for (char c : CONSUMO_ENERGETICO_DISPONIBLE) {
            if (c == consumoEnergetico) {
                found = true;
                break;
            }
        }
        if (found) {
            this.consumoEnergetico = consumoEnergetico;
        } else {
            this.consumoEnergetico = CONSUMO_ENERGETICO_CONSTANTE;
        }
    }

    private void setColor(String color) {
        color = color.toLowerCase();
        boolean found = false;
        for (String c : COLORES_DISPONIBLES) {
            if (c.equals(color)) {
                found = true;
                break;
            }
        }
        if (found) {
            this.color = color;
        } else {
            this.color = COLOR_CONSTANTE;
        }
    }

    public double precioFinal() {
        double precioFinal = precioBase;
        switch (consumoEnergetico) {
            case 'A':
                precioFinal += 100;
                break;
            case 'B':
                precioFinal += 80;
                break;
            case 'C':
                precioFinal += 60;
                break;
            case 'D':
                precioFinal += 50;
                break;
            case 'E':
                precioFinal += 30;
                break;
            case 'F':
                precioFinal += 10;
                break;
        }

        if (peso >= 0 && peso < 20) {
            precioFinal += 10;
        } else if (peso >= 20 && peso < 50) {
            precioFinal += 50;
        } else if (peso >= 50 && peso < 80) {
            precioFinal += 80;
        } else if (peso >= 80) {
            precioFinal += 100;
        }

        return precioFinal;
    }
}
