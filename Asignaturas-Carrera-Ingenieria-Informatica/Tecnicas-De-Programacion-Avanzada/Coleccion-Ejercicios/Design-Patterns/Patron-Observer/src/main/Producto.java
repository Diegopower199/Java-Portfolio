package main;

import java.util.Observable;
import java.util.Observer;

public class Producto extends Observable {

    private String nombre;
    private String descripcion;
    private float precio;
    private int stock;

    private Observer observer;

    public Producto() {
        super();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
        notifyObservers();
    }

    @Override
    public synchronized void addObserver(Observer observer) {

        this.observer = observer;
    }

    @Override
    public void notifyObservers() {

        // nos notifica que la clase ha sido actualizada.
        if (observer != null) {
            observer.update(this, "stock");
        }
    }

}
