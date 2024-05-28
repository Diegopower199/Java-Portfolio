package TiposVehiculos;

public class Vehiculo implements GestionVehiculo {
    private String marca;
    private float velocidadActual;
    private boolean estaArrancado;
    private float precio;
    private float peso;
    private String color;
    private float longitud;

    public Vehiculo() {
    }

    public Vehiculo(String marca, float precio, float peso, String color, float longitud) {
        this.marca = marca;
        this.precio = precio;
        this.peso = peso;
        this.color = color;
        this.longitud = longitud;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public float getVelocidadActual() {
        return velocidadActual;
    }

    public void setVelocidadActual(float velocidadActual) {
        if (velocidadActual >= 0) {
            this.velocidadActual = velocidadActual;
        } else {
            throw new IllegalArgumentException("La velocidad actual debe ser positiva");
        }
    }

    public boolean getEstaArrancado() {
        return estaArrancado;
    }

    public void setEstaArrancado(boolean estaArrancado) {
        this.estaArrancado = estaArrancado;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public float getLongitud() {
        return longitud;
    }

    public void setLongitud(float longitud) {
        this.longitud = longitud;
    }

    @Override
    public boolean acelerar(float incrementoVelocidadActual) {
        if (estaArrancado) {
            velocidadActual += incrementoVelocidadActual;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean frenar(float decrementoVelocidadActual) {
        if (estaArrancado) {
            velocidadActual -= decrementoVelocidadActual;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean arrancar() {
        if (!estaArrancado) {
            estaArrancado = true;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean parar() {
        if (estaArrancado) {
            estaArrancado = false;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "Vehiculo{" +
                "marca='" + marca + '\'' +
                ", velocidadActual=" + velocidadActual +
                ", estaArrancado=" + estaArrancado +
                ", precio=" + precio +
                ", peso=" + peso +
                ", color='" + color + '\'' +
                ", longitud=" + longitud +
                '}';
    }

    public void print() {
        System.out.println(this);
    }
}
