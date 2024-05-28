package mibbdd;

import java.util.ArrayList;

/**
 * Es una lista de compañías de envíos de paquete
 */

public class CompEnvios {
    private ArrayList<CompEnvio> listaCompEnvios;

    /**
     * Constructor.
     */
    public CompEnvios() {
        this.listaCompEnvios = new ArrayList<>();
    }

    /**
     * Devuelve la compañia de envíos que ocupa una posicón en la lista.
     * 
     * @param pos Posición en la lista.
     * @return CompEnvio.
     */
    public CompEnvio getCompEnvioPos(int pos) {
        return this.listaCompEnvios.get(pos);
    }

    /**
     * Devuelve la lista de compañías de envíos.
     * 
     * @return ArrayList<CompEnvio>
     */
    public ArrayList<CompEnvio> getListaCompEnvios() {
        return listaCompEnvios;
    }

    /**
     * Establece la lista de compañías de envíos.
     * 
     * @param listaCompEnvios Lista de compañías de envíos.
     */
    public void setListaCompEnvios(ArrayList<CompEnvio> listaCompEnvios) {
        this.listaCompEnvios = listaCompEnvios;
    }

    /**
     * Añade una empresa de envíos a la lista.
     * 
     * @param c Compañía de envíos.
     */
    public void aniadeCompEnv(CompEnvio c) {
        this.listaCompEnvios.add(c);
    }

    /**
     * Devuelve la compañía de envíos que se corresponde con el código pasado como
     * parámetro.
     * 
     * @param codigo Código de la compañía de envíos.
     * @return CompEnvio Compañía de envíos. Si no encunta la compañía, devoverá
     *         null.
     */
    public CompEnvio getCompEnv(int codigo) {
        CompEnvio resul = null;
        Boolean enc = false;
        if (this.listaCompEnvios != null) {
            int n = this.listaCompEnvios.size();
            int pos = 0;
            while ((!enc) && (pos < n)) {
                resul = this.listaCompEnvios.get(pos);
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
