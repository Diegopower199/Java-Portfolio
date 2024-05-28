package main;

import java.util.ArrayList;
import java.util.List;

public class Jugador {
    private String nombre;
    private int num1;
    private int num2;
    private List<Historial> historial;

    public Jugador(String nombre) {
        this.nombre = nombre;
        this.historial = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public int getNum1() {
        return num1;
    }

    public void setNum1(int num1) {
        this.num1 = num1;
    }

    public int getNum2() {
        return num2;
    }

    public void setNum2(int num2) {
        this.num2 = num2;
    }

    public List<Historial> getHistorial() {
        return historial;
    }

    public void agregarHistorial(Historial historial) {
        this.historial.add(historial);
    }
}
