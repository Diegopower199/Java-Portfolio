package main;

public class Main {
    public static void main(String[] args) throws Exception {
        // Creation of the Client and the SErvice
        Client ClienteA = new Client();
        Service ServicioA = new Service();

        // Creation of the adapter, to do ServicioA compatible with ClienteA
        Adapter adp = new Adapter(ServicioA);

        // Use of Service methods from Client (uncomment when ready)
        ClienteA.setNumbers(adp.dataGeneration(10, 50, 20));
        ClienteA.setNumbers(adp.dataSelection(5, 10, ClienteA.getNumbers()));

        // Example output of a sliced array into an ArrrayList
        System.out.println(ClienteA.getNumbers());
    }
}
