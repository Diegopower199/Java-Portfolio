package main;

public class ServicioDesign implements ServicioInformatico {

    @Override
    public void asignarTrabajo() {
        System.out.println("El trabajador ha sido asignado a diseñadores graficos disponibles...");
    }

    @Override
    public void indicarFechaEntrega() {
        System.out.println("Ellos han terminado el trabajo como maximo el dia 12/10/2022...");

    }

    @Override
    public void informarSobrePago() {
        System.out.println("Debe realizar el pago en efectivo al momento de llegar...");
    }

}
