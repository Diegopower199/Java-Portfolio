package servidor;

import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.List;

import commonclasses.Usuario;

public class ServidorMain {
    // Ruta del archivo donde se guardarán los usuarios
    private static final String ARCHIVO_SERIALIZACION = "LibroBloquesUsuarios.dat";

    // Lista para almacenar los usuarios en memoria
    private static List<Usuario> listaUsuarios = new ArrayList<>();

    // Método principal del servidor
    public static void main(String[] args) {
        // Puerto en el que el servidor estará escuchando
        final int puerto = 12345;

        // Cargar la lista de usuarios desde el archivo al iniciar el servidor
        listaUsuarios = cargarUsuarios();

        // Configurar el servidor para escuchar en el puerto 12345
        try (ServerSocket serverSocket = new ServerSocket(puerto)) {
            // Mensaje para indicar que el servidor está en espera en el puerto especificado
            System.out.println("Servidor en espera en el puerto " + puerto);

            // Esperar conexiones continuamente
            while (true) {
                try (Socket socketCliente = serverSocket.accept();
                        ObjectInputStream objectInputStream = new ObjectInputStream(socketCliente.getInputStream())) {
                    // Configurar el flujo de entrada para recibir un objeto Usuario del cliente
                    // (objectInputStream)

                    // Recibir el objeto Usuario del cliente
                    Usuario usuarioRecibido = (Usuario) objectInputStream.readObject();
                    System.out.println("Usuario recibido: " + usuarioRecibido);

                    // Guardar el usuario en el archivo y actualizar la lista de usuarios
                    guardarUsuario(usuarioRecibido);

                    // Configurar el flujo de salida para enviar un mensaje de confirmación al
                    // cliente
                    ObjectOutputStream oos = new ObjectOutputStream(socketCliente.getOutputStream());
                    oos.writeObject("Usuario recibido y guardado exitosamente.");

                    // Mostrar todos los usuarios almacenados en el archivo
                    mostrarUsuarios();
                } catch (IOException | ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Método para cargar la lista de usuarios desde el archivo
    private static List<Usuario> cargarUsuarios() {
        // Crear una nueva lista para almacenar los usuarios
        List<Usuario> listaUsuariosAlmacenados = new ArrayList<>();

        // Intentar cargar usuarios desde el archivo
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ARCHIVO_SERIALIZACION))) {
            listaUsuariosAlmacenados = (List<Usuario>) ois.readObject();
            System.out.println("Usuarios cargados correctamente." + listaUsuariosAlmacenados);
        } catch (FileNotFoundException e) {
            // El archivo no existe, imprimir mensaje y continuar
            System.out.println("Archivo no encontrado. Se creará uno nuevo.");
        } catch (IOException | ClassNotFoundException e) {
            // Manejar excepciones de entrada/salida o deserialización
            e.printStackTrace();
        }

        // Devolver la lista de usuarios cargada
        return listaUsuariosAlmacenados;
    }

    // Método para guardar un usuario en el archivo y actualizar la lista de
    // usuarios en memoria
    private static void guardarUsuario(Usuario usuarioNuevo) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ARCHIVO_SERIALIZACION))) {
            listaUsuarios.add(usuarioNuevo);
            oos.writeObject(listaUsuarios);
            System.out.println("Usuarios serializados correctamente.");
        } catch (IOException e) {
            // Manejar excepciones de entrada/salida
            e.printStackTrace();
        }
    }

    // Método para mostrar todos los usuarios almacenados en la lista en memoria
    private static void mostrarUsuarios() {
        // Verificar si la lista de usuarios está vacía
        if (listaUsuarios.isEmpty()) {
            System.out.println("No hay usuarios registrados.");
        } else {
            // Imprimir todos los usuarios en la lista
            System.out.println("Usuarios registrados:");
            for (Usuario usuario : listaUsuarios) {
                System.out.println(usuario);
            }
        }
    }
}
