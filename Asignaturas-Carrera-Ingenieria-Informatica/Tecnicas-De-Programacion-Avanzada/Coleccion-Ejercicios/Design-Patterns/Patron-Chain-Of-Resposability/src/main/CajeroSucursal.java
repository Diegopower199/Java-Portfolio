package main;

public class CajeroSucursal implements IManejador {

    private IManejador sucesor;

    @Override
    public void peticion(int monto) {
        if (monto <= 100) {
            System.out.println("La peticion ha sido atendida por el cajero automatico...");
        } else {
            sucesor.peticion(monto);
        }
    }

    @Override
    public IManejador getSucesor() {
        return sucesor;
    }

    @Override
    public void setSucesor(IManejador sucesor) {
        this.sucesor = sucesor;
    }

}