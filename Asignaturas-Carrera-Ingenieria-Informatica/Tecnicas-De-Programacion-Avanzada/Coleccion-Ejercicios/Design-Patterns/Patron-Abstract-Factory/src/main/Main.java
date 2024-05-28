package main;

public class Main {
    public static void main(String[] args) {

        usarServicio(new DesignFactory());
        usarServicio(new WebsiteFactory());
        usarServicio(new SoftwareFactory());

    }

    public static void usarServicio(ServicioFactory factory) {
        ServicioInformatico si = factory.crearServicio();

        si.asignarTrabajo();
        si.indicarFechaEntrega();
        si.informarSobrePago();
    }
}
