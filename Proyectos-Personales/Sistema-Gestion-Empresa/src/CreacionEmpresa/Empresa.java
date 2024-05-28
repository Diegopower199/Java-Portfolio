package CreacionEmpresa;

import java.util.Scanner;
import TiposEdificios.*;
import TiposProductos.*;
import TiposVehiculos.*;

public class Empresa {
    private Vehiculo[] vehiculos;
    private Edificio[] edificios;
    public Producto[] productos;
    private static final int MAX_PRODUCTOS = 4;
    private int productosCreados;

    public Empresa() {
        vehiculos = new Vehiculo[4];
        edificios = new Edificio[3];
        productos = new Producto[MAX_PRODUCTOS];
        productosCreados = 0;
    }

    public void agregarVehiculo(Vehiculo vehiculo, boolean estaArrancado, int velocidadActual) {
        for (int i = 0; i < vehiculos.length; i++) {
            if (vehiculos[i] == null) {
                vehiculos[i] = vehiculo;
                vehiculos[i].setEstaArrancado(estaArrancado);
                vehiculos[i].setVelocidadActual(velocidadActual);
                break;
            }
        }
    }

    public void agregarEdificio(Edificio edificio) {
        for (int i = 0; i < edificios.length; i++) {
            if (edificios[i] == null) {
                edificios[i] = edificio;
                break;
            }
        }
    }

    public void agregarEdificio(Edificio edificio, String color, int costePintura) {
        agregarEdificio(edificio);
        edificio.calcularCostePintura(color, costePintura);
    }

    public boolean agregarProducto(String tipo) {
        if (productosCreados < MAX_PRODUCTOS) {
            Producto producto = new Producto();
            producto.setTipo(tipo);
            productos[productosCreados] = producto;
            productosCreados++;
            return true;
        }
        return false;
    }

    public boolean crearProducto(Producto p) {
        if (productosCreados >= MAX_PRODUCTOS) {
            return false;
        }

        Scanner scan = new Scanner(System.in);
        System.out.println("Pon un identificador al producto: ");
        int identificadorUsuario = scan.nextInt();
        scan.nextLine();

        for (int pos = 0; pos < productos.length; pos++) {
            if (productos[pos] == null) {
                productos[pos] = p;
                productos[pos].setId(identificadorUsuario);
                productosCreados++;
                scan.close();
                return true;
            }
        }
        scan.close();
        return false;
    }

    public boolean venderProducto(Producto p) {
        for (int pos = 0; pos < productos.length; pos++) {
            if (productos[pos] != null && productos[pos].getId() == p.getId()) {
                productos[pos] = null;
                productosCreados--;
                return true;
            }
        }
        return false;
    }

    public boolean cambiarUbicacionProducto(Producto p, Edificio e) {
        for (int pos = 0; pos < productos.length; pos++) {
            if (productos[pos] != null && productos[pos].getId() == p.getId()) {
                p.setEdificioActual(e);
                return true;
            }
        }
        return false;
    }

    public void mostrarEstadoProductos() {
        for (Producto producto : productos) {
            if (producto != null) {
                System.out.println("Producto ID: " + producto.getId() + ", Tipo: " + producto.getTipo());
            }
        }
    }
}
