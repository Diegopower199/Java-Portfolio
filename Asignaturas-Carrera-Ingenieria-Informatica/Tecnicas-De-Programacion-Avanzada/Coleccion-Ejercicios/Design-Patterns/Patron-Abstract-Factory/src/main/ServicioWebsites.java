package main;

public class ServicioWebsites implements ServicioInformatico {

    @Override
    public void asignarTrabajo() {
        System.out.println("El trabajador ha sido asignado a sitios web...");
    }

    @Override
    public void indicarFechaEntrega() {
        System.out.println("Ellos han terminado el trabajo como maximo el dia 15/06/2022...");
    }

    @Override
    public void informarSobrePago() {
        System.out.println("Debe realizar el pago en tarjeta al momento de llegar...");
    }

}
