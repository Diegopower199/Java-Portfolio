package main;

import java.util.GregorianCalendar;

public class Main {
    public static void main(String[] args) {

        Producto producto = new Producto();
        producto.setNombre("Patatas");
        producto.setDescripcion("Patatas fritas");
        producto.setPrecio(1.20f);
        producto.setStock(0);

        Cliente cliente = new Cliente();
        cliente.setVodigo("C001");
        cliente.setNombre("Pepe");
        cliente.setApellidos("Solis Rodriguez");
        cliente.setEmail("n@n.com");
        cliente.setFechaNacimiento(new GregorianCalendar().getTime());

        // Se añaden observables a la clase observable
        producto.addObserver(cliente);

        // Un cambio en la clase observada hara "reaccionar" a la clase observadora
        producto.setStock(23);

    }
}
