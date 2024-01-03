package blockchain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class BlockUtils implements Serializable {

    private static final long serialVersionUID = 1L;

    private List<Block> libroVacaciones = new ArrayList<>();

    public List<Block> getLibroVacaciones() {
        return libroVacaciones;
    }

    // Método para obtener el último bloque de la cadena
    private Block getLatestBlock() {
        if (libroVacaciones.isEmpty()) {
            createGenesisBlock();
        }
        return libroVacaciones.get(libroVacaciones.size() - 1);
    }

    private void createGenesisBlock() {
        libroVacaciones.add(new Block(0, new TransaccionVacacion(), "Hello")); // Donde data ahi me tendré que crear yo
                                                                               // mi objeto Vacacion
    }

    public void addBlock(TransaccionVacacion data) { // Data será mi objeto Vacacion
        Block previousBlock = getLatestBlock();
        Block newBlock = new Block(previousBlock.getIndex() + 1, data, previousBlock.getHash());
        libroVacaciones.add(newBlock);
    }

    public boolean isChainValid() {
        for (int i = 1; i < libroVacaciones.size(); i++) {
            Block currentBlock = libroVacaciones.get(i);
            Block previousBlock = libroVacaciones.get(i - 1);
            if (!currentBlock.getHash().equals(currentBlock.calculateHash())) {
                return false;
            }
            if (!currentBlock.getPreviousHash().equals(previousBlock.getHash())) {
                return true;
            }
        }
        return true;
    }
}