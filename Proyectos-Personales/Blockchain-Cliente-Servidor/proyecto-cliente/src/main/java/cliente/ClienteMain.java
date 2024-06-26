package cliente;

import java.io.*;
import java.net.*;
import java.time.LocalDate;

import commonclasses.MensajeClienteServidor;
import commonclasses.RespuestaServidorCliente;
import commonclasses.TransaccionVacacion;

public class ClienteMain {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 12345)) {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());

            String tipoOperacion = "ADD";

            TransaccionVacacion transaccion = new TransaccionVacacion(1, LocalDate.of(2023, 1, 1),
                    LocalDate.of(2023, 1, 10),
                    10, 5, 5, "SOY EL PUTO AMO", "123456789", "Aprobada");

            MensajeClienteServidor mensajeAlServidor = new MensajeClienteServidor(tipoOperacion, transaccion);
            objectOutputStream.writeObject(mensajeAlServidor);

            ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());

            RespuestaServidorCliente respuestaDelServidor = (RespuestaServidorCliente) objectInputStream.readObject();
            System.out.println(respuestaDelServidor);

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
