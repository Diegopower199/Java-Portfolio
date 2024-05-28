package TiposVehiculos;

public interface GestionVehiculo {
    boolean acelerar(float incrementoVelocidadActual);

    boolean frenar(float decrementoVelocidadActual);

    boolean arrancar();

    boolean parar();
}
