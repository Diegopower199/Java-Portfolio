package servidor;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import commonclasses.Libro;

public class ServidorMain {

    public static void main(String[] args) {
        final int puerto = 12345;

        try (ServerSocket serverSocket = new ServerSocket(puerto)) {
            System.out.println("Servidor en espera en el puerto " + puerto);

            while (true) {
                try (Socket socketCliente = serverSocket.accept();
                        ObjectInputStream objectInputStream = new ObjectInputStream(socketCliente.getInputStream())) {

                    Object objetoRecibido = objectInputStream.readObject();

                    if (objetoRecibido instanceof Libro) {
                        Libro libroRecibido = (Libro) objetoRecibido;
                        System.out.println("Libro recibido del cliente: " + libroRecibido);
                        ObjectOutputStream oos = new ObjectOutputStream(socketCliente.getOutputStream());
                        oos.writeObject("Usuario recibido y guardado exitosamente.");
                    } else {
                        System.out.println("Objeto no reconocido recibido del cliente.");
                    }

                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
