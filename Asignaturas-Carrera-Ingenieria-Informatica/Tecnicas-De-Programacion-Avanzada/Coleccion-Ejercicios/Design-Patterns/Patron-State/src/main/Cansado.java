package main;

public class Cansado implements State {

    private Tamagotchi tamagotchi;

    @Override
    public void jugar() {
        System.out.println("No quiero jugar!");
    }

    @Override
    public void alimentar() {
        System.out.println("No tengo hambre!");
    }

    @Override
    public void dormir() {
        System.out.println("Tengo sueño!");
        tamagotchi.setEstado(new Durmiendo());
    }

    @Override
    public void comoEstas() {
        System.out.println("Estoy cansado!");
    }

    @Override
    public void setTamagotchi(Tamagotchi tama) {
        this.tamagotchi = tama;
    }

}
