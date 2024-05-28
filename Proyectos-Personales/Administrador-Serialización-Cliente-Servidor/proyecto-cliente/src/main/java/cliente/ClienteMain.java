package cliente;

import java.io.*;
import java.net.*;

import commonclasses.Usuario;

public class ClienteMain {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 12345)) {
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());

            Usuario usuario = new Usuario("Diego", "ejemplo@dominio.com");
            oos.writeObject(usuario);

            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            String respuesta = (String) ois.readObject();
            System.out.println("Respuesta del servidor: " + respuesta);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
