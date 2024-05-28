package CreacionEmpresa;

import TiposEdificios.*;
import TiposProductos.*;
import TiposVehiculos.*;

public class Main {

    public static void main(String[] args) {
        Empresa empresaGeneral = new Empresa();

        empresaGeneral.agregarVehiculo(new Electrico(), false, 100);
        empresaGeneral.agregarVehiculo(new Electrico(), false, 130);
        empresaGeneral.agregarVehiculo(new Gasolina(), false, 90);
        empresaGeneral.agregarVehiculo(new Gasoil(), false, 150);

        empresaGeneral.agregarEdificio(new Fabrica());
        empresaGeneral.agregarEdificio(new Oficina());
        empresaGeneral.agregarEdificio(new Almacen());

        Producto producto1 = new Producto();
        Producto producto2 = new Producto();
        Producto producto3 = new Producto();
        Producto producto4 = new Producto();
        Producto producto5 = new Producto();

        producto1.setTipo("Puerta");
        producto2.setTipo("Puerta");
        producto3.setTipo("Silla");
        producto4.setTipo("Silla");

        empresaGeneral.crearProducto(producto1);
        empresaGeneral.crearProducto(producto2);
        empresaGeneral.crearProducto(producto3);
        empresaGeneral.crearProducto(producto4);

        empresaGeneral.venderProducto(producto1);
        empresaGeneral.venderProducto(producto3);

        producto5.setTipo("Puerta");

        empresaGeneral.crearProducto(producto5);

        producto4.setTipo("Puerta");
        producto4.setId(10);
    }
}
