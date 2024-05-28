package mibbdd;

import java.util.ArrayList;

/**
 * Lista de provincias.
 */

public class Provincias {
    private ArrayList<Provincia> listaProvincias;

    /**
     * Constructor.
     */
    public Provincias() {
        listaProvincias = new ArrayList<Provincia>();
    }

    /**
     * Devuelve la provincia que ocupa una posición.
     * 
     * @param pos Posición que ocupa la provincia.
     * @return Provincia.
     */
    public Provincia getProvinciaPos(int pos) {
        return this.listaProvincias.get(pos);
    }

    /**
     * Devuelve la lista de provincias.
     * 
     * @return ArrayList<Provincia>.
     */
    public ArrayList<Provincia> getListaProvincias() {
        return listaProvincias;
    }

    /**
     * Establece la lista deprovincias.
     * 
     * @param listaProvincias Lista deprovincias.
     */
    public void setListaProvincias(ArrayList<Provincia> listaProvincias) {
        this.listaProvincias = listaProvincias;
    }

    /**
     * Devuelve la provincia según el código pasado como parámetro.
     * 
     * @param codigo Código de la provincia.
     * @return Provincia. Devolverá null si no encuentra la provincia.
     */
    public Provincia getProvincia(int codigo) {
        Provincia resul = null;
        Boolean enc = false;
        if (this.listaProvincias != null) {
            int n = this.listaProvincias.size();
            int pos = 0;
            while ((!enc) && (pos < n)) {
                resul = this.listaProvincias.get(pos);
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

    /**
     * Devuelve la provincia según el nombre pasado como parámetro.
     * 
     * @param nombre Nombre de la provincia.
     * @return Provincia. Devolverá null si no encuentra la provincia.
     */
    public Provincia getProvincia(String nombre) {
        Provincia resul = null;
        Boolean enc = false;
        if (this.listaProvincias != null) {
            int n = this.listaProvincias.size();
            int pos = 0;
            while ((!enc) && (pos < n)) {
                resul = this.listaProvincias.get(pos);
                if (resul.getNombre().equals(nombre))
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
