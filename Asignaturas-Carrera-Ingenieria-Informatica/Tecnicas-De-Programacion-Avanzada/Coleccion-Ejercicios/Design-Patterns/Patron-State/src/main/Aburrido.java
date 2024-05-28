package main;

public class Aburrido implements State {

    private Tamagotchi tamagotchi;

    @Override
    public void jugar() {
        System.out.println("Vamos a jugar!");
        tamagotchi.setEstado(new Cansado());
    }

    @Override
    public void alimentar() {
        System.out.println("No tengo hambre!");
    }

    @Override
    public void dormir() {
        System.out.println("No tengo sueño!");
    }

    @Override
    public void comoEstas() {
        System.out.println("Estoy aburrido!");
    }

    @Override
    public void setTamagotchi(Tamagotchi tama) {
        this.tamagotchi = tama;
    }

}
