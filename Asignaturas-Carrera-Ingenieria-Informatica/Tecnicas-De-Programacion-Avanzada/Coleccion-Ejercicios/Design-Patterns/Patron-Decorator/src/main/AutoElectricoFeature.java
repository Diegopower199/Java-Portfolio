package main;

public class AutoElectricoFeature extends AutomovilDecorador {

    public AutoElectricoFeature(AutomovilInterface auto) {
        super(auto);
    }

    @Override
    public void acelerar() {
        System.out.println("Iniciando electricamente...");
        getAuto().acelerar();

    }

    @Override
    public void detener() {
        System.out.println("Deteniendo electricamente...");
        getAuto().detener();
    }

    @Override
    public void encender() {
        System.out.println("Encendiendo electricamente...");
        getAuto().encender();

    }

}
