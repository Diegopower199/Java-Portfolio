package serializacion;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    // Ruta del archivo donde se guardarán los usuarios
    private static final String ARCHIVO_SERIALIZACION = "usuarios.dat";

    // Lista para almacenar los usuarios en memoria
    private static List<Usuario> listaUsuarios = new ArrayList<>();

    public static void main(String[] args) {

        // Cargar usuarios existentes si el archivo ya existe
        listaUsuarios = cargarUsuarios();

        // Crear nuevos usuarios
        Usuario usuario1 = new Usuario("Juan", "juan@example.com");
        // Usuario usuario2 = new Usuario("Maria", "maria@example.com");

        // Serializar la lista de usuarios
        guardarUsuario(usuario1);

        // Mostrar usuarios
        mostrarUsuarios();
    }

    // Método para cargar usuarios desde un archivo de serialización
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

    // Método para serializar la lista de usuarios y guardarla en un archivo
    private static void guardarUsuario(Usuario usuarioNuevo) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ARCHIVO_SERIALIZACION))) {
            listaUsuarios.add(usuarioNuevo);
            oos.writeObject(listaUsuarios);
            System.out.println("Usuarios serializados correctamente.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Método para mostrar los usuarios almacenados en el archivo de serialización
    private static void mostrarUsuarios() {
        // Verificar si la lista de usuarios está vacía
        if (listaUsuarios.isEmpty()) {
            System.out.println("No hay usuarios registrados.");
        } else {
            System.out.println("\n\n\nUsuarios registrados:");
            for (Usuario usuario : listaUsuarios) {
                System.out.println(usuario);
            }
        }
    }
}

// MIRAR ESTO:
// https://chat.openai.com/share/26da1408-76b2-40d1-9cc7-77a4b5bd8c09
