package main;

public class Tamagotchi {

    private State estado;

    public Tamagotchi() {
        super();
        setEstado(new Aburrido());

    }

    public void setEstado(State estado) {
        this.estado = estado;
        this.estado.setTamagotchi(this);
    }

}
