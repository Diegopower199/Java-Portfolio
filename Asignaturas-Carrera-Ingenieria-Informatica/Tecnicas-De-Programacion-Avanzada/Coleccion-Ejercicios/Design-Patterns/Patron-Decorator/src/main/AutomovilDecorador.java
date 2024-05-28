package main;

public abstract class AutomovilDecorador implements AutomovilInterface {

    private AutomovilInterface auto;

    public AutomovilDecorador(AutomovilInterface auto) {
        super();
        this.auto = auto;

    }

    // solo lo utilizan las clases que hereden
    protected AutomovilInterface getAuto() {
        return auto;
    }

}
