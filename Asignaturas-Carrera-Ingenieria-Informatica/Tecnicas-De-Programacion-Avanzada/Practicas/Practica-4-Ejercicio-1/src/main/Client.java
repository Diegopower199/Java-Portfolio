package main;

public class Client {

    private BaseDatos BD;

    Client(BaseDatos BD) {
        this.BD = BD;
    }

    public void addPerson(String name) {
        BD.add(name);
    }

    public BaseDatos getBD() {
        return BD;
    }

}
