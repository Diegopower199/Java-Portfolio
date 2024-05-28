package main;

public class Main {
    public static void main(String[] args) throws Exception {
        Client ClienteA, ClienteB;
        BaseDatos BD1 = null, BD2 = null;

        BD1 = new BaseDatos().getInstance();
        BD2 = new BaseDatos().getInstance();

        ClienteA = new Client(BD1);
        ClienteB = new Client(BD2);

        // Comprobar que al implementar el Singleton, el resultado es true
        System.out.println(ClienteA.getBD() == ClienteB.getBD());
    }
}
