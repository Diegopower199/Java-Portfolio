package blockchain;

import java.time.LocalDate;
import java.util.List;

public class BlockchainMain {

    public static void main(String[] args) {
        BlockUtils blockUtils = new BlockUtils();

        TransaccionVacacion transaccion1 = new TransaccionVacacion(1, LocalDate.of(2023, 1, 1),
                LocalDate.of(2023, 1, 10),
                10, 5, 5, "Vacaciones de invierno", "123456789", "Aprobada");
        TransaccionVacacion transaccion2 = new TransaccionVacacion(2, LocalDate.of(2023, 2, 15),
                LocalDate.of(2023, 2, 25),
                10, 8, 2, "Viaje de negocios", "987654321", "Aprobada");

        TransaccionVacacion transaccion3 = new TransaccionVacacion(3, LocalDate.of(2023, 3, 5),
                LocalDate.of(2023, 3, 12),
                7, 7, 0, "Semana de descanso", "555555555", "Aprobada");

        // Imprimir información de las transacciones
        System.out.println("Transaccion 1: " + transaccion1.toString() + "\n");
        System.out.println("Transaccion 2: " + transaccion2.toString() + "\n");
        System.out.println("Transaccion 3: " + transaccion3.toString() + "\n");

        blockUtils.addBlock(transaccion1);
        blockUtils.addBlock(transaccion2);
        blockUtils.addBlock(transaccion3);

        System.out.println(blockUtils.isChainValid());
        System.out.println("\n\n\nInfo de todos los bloques: \n" + blockUtils.getLibroVacaciones().toString());
        // Recorre la cadena de bloques y muestra la información de cada bloque
        List<Block> blockChain = blockUtils.getLibroVacaciones();
        for (Block block : blockChain) {
            System.out.println("Indice: " + block.getIndex());
            System.out.println("Hash: " + block.getHash());
            System.out.println("Hash Anterior: " + block.getPreviousHash().toString());
            System.out.println("Datos: " + block.getDataTransaccionVacacion());
            System.out.println(
                    "---------------------------------------------------------------------------------------------------------");
        }
    }
}