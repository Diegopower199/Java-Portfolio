package main;

public class Durmiendo implements State {

    private Tamagotchi tamagotchi;

    @Override
    public void jugar() {
        System.out.println("No quiero jugar!");
    }

    @Override
    public void alimentar() {
        System.out.println("Tengo hambre!");
    }

    @Override
    public void dormir() {
        System.out.println("Tengo sueño!");
    }

    @Override
    public void comoEstas() {
        System.out.println("Dame de comer!");
    }

    @Override
    public void setTamagotchi(Tamagotchi tama) {
        this.tamagotchi = tama;

    }

}
