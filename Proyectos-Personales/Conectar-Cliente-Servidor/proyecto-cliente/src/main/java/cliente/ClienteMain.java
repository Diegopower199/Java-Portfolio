package cliente;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import commonclasses.Libro;

public class ClienteMain {

    public static void main(String[] args) {
        final String servidorDireccion = "localhost";
        final int puerto = 12345;

        try (Socket socket = new Socket(servidorDireccion, puerto);
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream())) {

            Libro libro = new Libro("El Quijote", "Miguel de Cervantes", 1605);

            objectOutputStream.writeObject(libro);

            System.out.println("Libro enviado al servidor: " + libro);

            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            String respuesta = (String) ois.readObject();
            System.out.println("Respuesta del servidor: " + respuesta);

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
