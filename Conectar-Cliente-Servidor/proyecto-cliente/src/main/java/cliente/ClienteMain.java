package cliente;



import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import commonclasses.Libro;




public class ClienteMain {

    public static void main(String[] args) {
        // Dirección del servidor y puerto al que conectarse
        final String servidorDireccion = "localhost";
        final int puerto = 12345;

        // Bloque try-with-resources: asegura que los recursos se cierren correctamente
        // al salir del bloque
        try (Socket socket = new Socket(servidorDireccion, puerto);
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream())) {

            // Crear un objeto Libro para enviar al servidor
            Libro libro = new Libro("El Quijote", "Miguel de Cervantes", 1605);

            // Enviar el objeto Libro al servidor
            objectOutputStream.writeObject(libro);

            // Imprimir mensaje indicando que el libro ha sido enviado al servidor
            System.out.println("Libro enviado al servidor: " + libro);

             // Recibir la respuesta del servidor
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            String respuesta = (String) ois.readObject();
            System.out.println("Respuesta del servidor: " + respuesta);

        } catch (IOException | ClassNotFoundException  e) {
            // Manejar la excepción si hay un problema de entrada/salida al establecer la
            // conexión o enviar datos
            e.printStackTrace();
        }
    }
}
