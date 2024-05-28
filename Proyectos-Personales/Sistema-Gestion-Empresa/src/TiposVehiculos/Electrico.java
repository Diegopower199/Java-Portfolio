package TiposVehiculos;

public class Electrico extends Vehiculo {
    private float potencia;
    private float velocidadMaxima;

    public Electrico() {
        super();
    }

    public Electrico(String marca, float precio, float peso, String color, float longitud, float potencia,
            float velocidadMaxima) {
        super(marca, precio, peso, color, longitud);
        this.potencia = potencia;
        this.velocidadMaxima = velocidadMaxima;
    }

    public float getPotencia() {
        return potencia;
    }

    public void setPotencia(float potencia) {
        this.potencia = potencia;
    }

    public float getVelocidadMaxima() {
        return velocidadMaxima;
    }

    public void setVelocidadMaxima(float velocidadMaxima) {
        this.velocidadMaxima = velocidadMaxima;
    }

    @Override
    public String toString() {
        return "Electrico{" +
                "potencia=" + potencia +
                ", velocidadMaxima=" + velocidadMaxima +
                ", " + super.toString() +
                '}';
    }
}
