package mibbdd;

import java.util.ArrayList;

/**
 * Lista de cargos que puede ocupar una persona dentro de una empresa.
 */

public class Cargos {
    private ArrayList<Cargo> listaCargos;

    public Cargos() {
        listaCargos = new ArrayList<>();
        listaCargos = Cargar.Cargos();
    }

    /**
     * Devuelve el cargo que ocupa una posición en la lista
     * 
     * @param pos Posición del caro.
     * @return Cargo
     */
    public Cargo getCargoPos(int pos) {
        return this.listaCargos.get(pos);
    }

    /**
     * Devuelve la lista de cargos.
     * 
     * @return Lista de cargos.
     */
    public ArrayList<Cargo> getListaCargos() {
        return listaCargos;
    }

    /**
     * Establece una lista de cargos.
     * 
     * @param listaCargos Lista de cargos.
     */
    public void setListaCargos(ArrayList<Cargo> listaCargos) {
        this.listaCargos = listaCargos;
    }

    /**
     * Devuelve un cargo a partir de un código.
     * 
     * @param codigo Código del cargo a buscar.
     * @return Cargo. Si no encuentra el cargo, devolverá null.
     */
    public Cargo getCargo(int codigo) {
        Cargo resul = null;
        Boolean enc = false;
        if (this.listaCargos != null) {
            int n = this.listaCargos.size();
            int pos = 0;
            while ((!enc) && (pos < n)) {
                resul = this.listaCargos.get(pos);
                if (resul.getCodigo() == codigo)
                    enc = true;
                else
                    pos++;
            }
        }
        if (enc)
            return resul;
        else
            return null;
    }
}
