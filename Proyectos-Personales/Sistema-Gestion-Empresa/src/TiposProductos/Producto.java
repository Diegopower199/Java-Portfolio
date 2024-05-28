package TiposProductos;

import TiposEdificios.Edificio;

public class Producto {
    private int id;
    private String nombre;
    private String tipo;
    private float anchura;
    private float profundidad;
    private float altura;
    private String color;
    private Edificio edificioActual;

    public Producto() {
    }

    public Producto(int id, String nombre, String tipo, float anchura, float profundidad, float altura, String color,
            Edificio edificioActual) {
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
        this.anchura = anchura;
        this.profundidad = profundidad;
        this.altura = altura;
        this.color = color;
        this.edificioActual = edificioActual;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if (id > 0) {
            this.id = id;
        } else {
            throw new IllegalArgumentException("ID debe ser positivo");
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public float getAnchura() {
        return anchura;
    }

    public void setAnchura(float anchura) {
        if (anchura > 0) {
            this.anchura = anchura;
        } else {
            throw new IllegalArgumentException("Anchura debe ser positiva");
        }
    }

    public float getProfundidad() {
        return profundidad;
    }

    public void setProfundidad(float profundidad) {
        if (profundidad > 0) {
            this.profundidad = profundidad;
        } else {
            throw new IllegalArgumentException("Profundidad debe ser positiva");
        }
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        if (altura > 0) {
            this.altura = altura;
        } else {
            throw new IllegalArgumentException("Altura debe ser positiva");
        }
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Edificio getEdificioActual() {
        return edificioActual;
    }

    public void setEdificioActual(Edificio edificioActual) {
        this.edificioActual = edificioActual;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", tipo='" + tipo + '\'' +
                ", anchura=" + anchura +
                ", profundidad=" + profundidad +
                ", altura=" + altura +
                ", color='" + color + '\'' +
                ", edificioActual=" + (edificioActual != null ? edificioActual.getTipoEdificioFuncionalidad() : "N/A") +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        Producto producto = (Producto) o;

        return id == producto.id;
    }

    @Override
    public int hashCode() {
        return id;
    }

    public void print() {
        System.out.println(this);
    }
}
