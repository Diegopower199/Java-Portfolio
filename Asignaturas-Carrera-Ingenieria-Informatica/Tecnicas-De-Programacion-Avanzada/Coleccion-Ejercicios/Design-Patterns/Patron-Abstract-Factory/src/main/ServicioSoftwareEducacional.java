package main;

public class ServicioSoftwareEducacional implements ServicioInformatico {

    @Override
    public void asignarTrabajo() {
        System.out.println("El trabajador ha sido asignado a software educacional...");
    }

    @Override
    public void indicarFechaEntrega() {
        System.out.println("Ellos han terminado el trabajo como maximo el dia 20/11/2022...");
    }

    @Override
    public void informarSobrePago() {
        System.out.println("Pago ya realizado por transferencia...");
    }

}
