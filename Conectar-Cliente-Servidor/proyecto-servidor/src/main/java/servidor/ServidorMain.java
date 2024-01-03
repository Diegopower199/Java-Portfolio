package servidor;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import commonclasses.Libro;

public class ServidorMain {

    public static void main(String[] args) {
        // Puerto en el que el servidor estará escuchando
        final int puerto = 12345;

        try (ServerSocket serverSocket = new ServerSocket(puerto)) {
            // Mensaje para indicar que el servidor está en espera en el puerto especificado
            System.out.println("Servidor en espera en el puerto " + puerto);

            while (true) {
                try (Socket socketCliente = serverSocket.accept();
                        ObjectInputStream objectInputStream = new ObjectInputStream(socketCliente.getInputStream())) {

                    // Leer el objeto del cliente
                    Object objetoRecibido = objectInputStream.readObject();

                    // Verificar si el objeto recibido es una instancia de la clase Libro
                    if (objetoRecibido instanceof Libro) {
                        // Si es un Libro, realizar un cast para trabajar con él
                        Libro libroRecibido = (Libro) objetoRecibido;
                        System.out.println("Libro recibido del cliente: " + libroRecibido);
                        ObjectOutputStream oos = new ObjectOutputStream(socketCliente.getOutputStream());
                        oos.writeObject("Usuario recibido y guardado exitosamente.");
                    } else {
                        // Si el objeto no es reconocido, imprimir un mensaje de advertencia
                        System.out.println("Objeto no reconocido recibido del cliente.");
                    }

                } catch (ClassNotFoundException e) {
                    // Manejar la excepción si la clase del objeto no se puede encontrar
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            // Manejar la excepción si hay un problema de entrada/salida al establecer el
            // servidor
            e.printStackTrace();
        }
    }
}
