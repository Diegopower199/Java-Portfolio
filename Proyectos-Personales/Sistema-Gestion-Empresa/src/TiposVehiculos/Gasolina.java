package TiposVehiculos;

public class Gasolina extends Vehiculo {
    private float contaminacion;
    private float tamanyoDeposito;

    public Gasolina() {
        super();
    }

    public Gasolina(String marca, float precio, float peso, String color, float longitud, float contaminacion,
            float tamanyoDeposito) {
        super(marca, precio, peso, color, longitud);
        this.contaminacion = contaminacion;
        this.tamanyoDeposito = tamanyoDeposito;
    }

    public float getContaminacion() {
        return contaminacion;
    }

    public void setContaminacion(float contaminacion) {
        this.contaminacion = contaminacion;
    }

    public float getTamanyoDeposito() {
        return tamanyoDeposito;
    }

    public void setTamanyoDeposito(float tamanyoDeposito) {
        this.tamanyoDeposito = tamanyoDeposito;
    }

    @Override
    public String toString() {
        return "Gasolina{" +
                "contaminacion=" + contaminacion +
                ", tamanyoDeposito=" + tamanyoDeposito +
                ", " + super.toString() +
                '}';
    }
}
