package blockchain;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import commonclasses.Block;
import commonclasses.MensajeClienteServidor;
import commonclasses.RespuestaServidorCliente;
import commonclasses.TransaccionVacacion;

public class BlockchainServerMain {

    private static final String ARCHIVO_LIBRO_VACACIONES = "libroVacaciones.dat";

    private static Blockchain libroVacaciones = cargarLibroVacaciones();

    public static void main(String[] args) {
        final int puerto = 12345;

        try (ServerSocket serverSocket = new ServerSocket(puerto)) {
            System.out.println("Servidor en espera en el puerto " + puerto);

            while (true) {
                try (Socket socketCliente = serverSocket.accept();
                        ObjectInputStream objectInputStream = new ObjectInputStream(socketCliente.getInputStream());
                        ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                                socketCliente.getOutputStream());) {

                    MensajeClienteServidor mensajeDelCliente = (MensajeClienteServidor) objectInputStream.readObject();

                    String tipoOperacionRecibida = mensajeDelCliente.getTipoOperacion();
                    TransaccionVacacion transaccionVacacionRecibido = mensajeDelCliente
                            .getTransaccionVacacionAutorizada();

                    RespuestaServidorCliente respuestaAlCliente;

                    switch (tipoOperacionRecibida) {
                        case "GET ALL":
                            respuestaAlCliente = new RespuestaServidorCliente(
                                    libroVacaciones.getLibroTransaccionesVacacionesAutorizadas(), 200);
                            objectOutputStream.writeObject(respuestaAlCliente);

                            break;
                        case "ADD":
                            guardarTransaccionVacacion(transaccionVacacionRecibido);

                            respuestaAlCliente = new RespuestaServidorCliente(
                                    "Transaccion vacacion recibido y guardado exitosamente", 200);
                            objectOutputStream.writeObject(respuestaAlCliente);

                            break;
                        default:
                            System.out.println("Operacion no valida - " + tipoOperacionRecibida);
                            respuestaAlCliente = new RespuestaServidorCliente(
                                    "Operacion no valida", 200);
                            objectOutputStream.writeObject(respuestaAlCliente);

                            break;
                    }
                } catch (IOException | ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static Blockchain cargarLibroVacaciones() {
        List<Block> listaBloquesDeVacacionesAlmacenados = new ArrayList<>();

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ARCHIVO_LIBRO_VACACIONES))) {
            Object objetoLeido = ois.readObject();
            Blockchain blockchainDesdeArchivo = (Blockchain) objetoLeido;
            listaBloquesDeVacacionesAlmacenados = blockchainDesdeArchivo.getLibroTransaccionesVacacionesAutorizadas();
            System.out.println("Vacaciones cargados correctamente");
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado. Se creara uno nuevo");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return new Blockchain(listaBloquesDeVacacionesAlmacenados);
    }

    private static void guardarTransaccionVacacion(TransaccionVacacion newTransaccionVacacion) {

        System.out.println("HOLA");
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ARCHIVO_LIBRO_VACACIONES))) {
            libroVacaciones.addBlock(newTransaccionVacacion);
            oos.writeObject(libroVacaciones);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void mostrarInformacionLibroTransaccionVacacion() {
        List<Block> blockChain = libroVacaciones.getLibroTransaccionesVacacionesAutorizadas();

        if (blockChain.isEmpty()) {
            System.out.println("No hay transacciones de vacaciones registrados");
        } else {
            System.out.println("Hay transacciones de vacaciones registrados");

        }
    }

}