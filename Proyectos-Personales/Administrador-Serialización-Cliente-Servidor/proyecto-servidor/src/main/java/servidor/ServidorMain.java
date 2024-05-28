package servidor;

import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.List;

import commonclasses.Usuario;

public class ServidorMain {
    private static final String ARCHIVO_SERIALIZACION = "LibroBloquesUsuarios.dat";
    private static List<Usuario> listaUsuarios = new ArrayList<>();

    public static void main(String[] args) {

        final int puerto = 12345;

        listaUsuarios = cargarUsuarios();

        try (ServerSocket serverSocket = new ServerSocket(puerto)) {
            System.out.println("Servidor en espera en el puerto " + puerto);

            while (true) {
                try (Socket socketCliente = serverSocket.accept();
                        ObjectInputStream objectInputStream = new ObjectInputStream(socketCliente.getInputStream())) {

                    Usuario usuarioRecibido = (Usuario) objectInputStream.readObject();
                    System.out.println("Usuario recibido: " + usuarioRecibido);

                    guardarUsuario(usuarioRecibido);

                    ObjectOutputStream oos = new ObjectOutputStream(socketCliente.getOutputStream());
                    oos.writeObject("Usuario recibido y guardado exitosamente.");

                    mostrarUsuarios();
                } catch (IOException | ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static List<Usuario> cargarUsuarios() {
        List<Usuario> listaUsuariosAlmacenados = new ArrayList<>();

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ARCHIVO_SERIALIZACION))) {
            listaUsuariosAlmacenados = (List<Usuario>) ois.readObject();
            System.out.println("Usuarios cargados correctamente." + listaUsuariosAlmacenados);
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado. Se creará uno nuevo.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return listaUsuariosAlmacenados;
    }

    private static void guardarUsuario(Usuario usuarioNuevo) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ARCHIVO_SERIALIZACION))) {
            listaUsuarios.add(usuarioNuevo);
            oos.writeObject(listaUsuarios);
            System.out.println("Usuarios serializados correctamente.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void mostrarUsuarios() {
        if (listaUsuarios.isEmpty()) {
            System.out.println("No hay usuarios registrados.");
        } else {
            System.out.println("Usuarios registrados:");
            for (Usuario usuario : listaUsuarios) {
                System.out.println(usuario);
            }
        }
    }
}
