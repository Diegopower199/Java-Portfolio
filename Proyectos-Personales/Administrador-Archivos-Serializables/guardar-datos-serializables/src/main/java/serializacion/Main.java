package serializacion;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private static final String ARCHIVO_SERIALIZACION = "usuarios.dat";
    private static List<Usuario> listaUsuarios = new ArrayList<>();

    public static void main(String[] args) {
        listaUsuarios = cargarUsuarios();

        Usuario usuario1 = new Usuario("Juan", "juan@example.com");
        Usuario usuario2 = new Usuario("Maria", "maria@example.com");

        guardarUsuario(usuario1);
        guardarUsuario(usuario2);

        mostrarUsuarios();
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
            System.out.println("\n\n\nUsuarios registrados:");
            for (Usuario usuario : listaUsuarios) {
                System.out.println(usuario);
            }
        }
    }
}