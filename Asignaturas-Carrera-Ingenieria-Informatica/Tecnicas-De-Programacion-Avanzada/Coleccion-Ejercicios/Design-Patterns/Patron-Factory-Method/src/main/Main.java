package main;

public class Main {
    public static void main(String[] args) throws Exception {
        TransporteInterface t1 = Fabrica.construir("Motocicleta");
        TransporteInterface t2 = Fabrica.construir("Automovil");

        t1.arrancar();
        t1.detener();
        t2.arrancar();
        t2.detener();

        System.out.println(t1.tipo());
        System.out.println(t2.tipo());
    }
}
