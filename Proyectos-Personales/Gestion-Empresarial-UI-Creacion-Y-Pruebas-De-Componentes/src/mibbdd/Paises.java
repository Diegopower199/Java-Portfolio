package mibbdd;

import java.util.ArrayList;

/**
 * Lista de paises.
 */

public class Paises {
    static protected ArrayList<Pais> paises;
    static protected ArrayList<Pais> paisesLegibles;

    /**
     * Constructor
     */
    public Paises() {
        paises = Cargar.Paises();
    }

    /**
     * Devuelve el país que ocupa una posción determinada.
     * 
     * @param pos Posición de país.
     * @return Pais
     */
    public Pais getPaisPos(int pos) {
        return this.paises.get(pos);
    }

    /**
     * Devuelve la lista de países.
     * 
     * @return ArrayList<Pais>
     */
    public ArrayList<Pais> getPaises() {

        return paises;
    }

    /**
     * Establece la lista de países.
     * 
     * @param paises Lista de países.
     */
    public void setPaises(ArrayList<Pais> paises) {
        this.paises = paises;
    }

    /**
     * Añade un país a la lista de países.
     * 
     * @param p Pais.
     */
    public void aniadePais(Pais p) {
        this.paises.add(p);
    }

    /**
     * Devuleve un Pais a partir de su código.
     * 
     * @param codigo Código del país.
     * @return Pais. Si el país no existe, devuelve null.
     */
    public Pais getPais(int codigo) {
        Pais resul = null;
        Boolean enc = false;
        if (this.paises != null) {
            int n = this.paises.size();
            int pos = 0;
            while ((!enc) && (pos < n)) {
                resul = this.paises.get(pos);
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
     * Devuelve un Pis a partir de su nombre.
     * 
     * @param nombre Nombre del país.
     * @return Pais. Si el país no existe, devuelve null.
     */
    public Pais getPais(String nombre) {
        Pais resul = null;
        Boolean enc = false;
        if (this.paises != null) {
            int n = this.paises.size();
            int pos = 0;
            while ((!enc) && (pos < n)) {
                resul = this.paises.get(pos);
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
