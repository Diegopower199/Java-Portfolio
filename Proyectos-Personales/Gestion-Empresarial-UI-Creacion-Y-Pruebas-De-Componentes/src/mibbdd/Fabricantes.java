package mibbdd;

import java.util.ArrayList;

/**
 * Lista de fabricates.
 */

public class Fabricantes {
    private ArrayList<Fabricante> listaFabricantes;

    /**
     * Constructor
     */
    public Fabricantes() {
        listaFabricantes = new ArrayList<Fabricante>();
    }

    /**
     * Devuelve el faricante que ocupa una posición en la lista de fabricantes.
     * 
     * @param pos Posición del fabricnte.
     * @return Fabricante.
     */
    public Fabricante getFabricantePos(int pos) {
        return this.listaFabricantes.get(pos);
    }

    /**
     * Devuelve la lista de fabricantes.
     * 
     * @return ArrayList<Fabricante>.
     */
    public ArrayList<Fabricante> getListaFabricantes() {
        return listaFabricantes;
    }

    /**
     * Establece la lista de fabricantes.
     * 
     * @param listaFabricantes Lista de fabricantes.
     */
    public void setListaFabricantes(ArrayList<Fabricante> listaFabricantes) {
        this.listaFabricantes = listaFabricantes;
    }

    /**
     * Añade un fabricante a la lista de fabricantes.
     * 
     * @param fb Fabricante.
     */
    public void aniadeFabricante(Fabricante fb) {
        this.listaFabricantes.add(fb);
    }

    /**
     * Devuelve un fabricante que coincida con la clave que se le pase como
     * parámetro.
     * 
     * @param clave Clave del fabricante.
     * @return Fabricante. Si no ecnuentra el fabricante, devuelve null.
     */
    public Fabricante getFabricante(int clave) {
        Fabricante resul = null;
        Boolean enc = false;
        if (this.listaFabricantes != null) {
            int n = this.listaFabricantes.size();
            int pos = 0;
            while ((!enc) && (pos < n)) {
                resul = this.listaFabricantes.get(pos);
                if (resul.getClave() == clave)
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
     * Devuelve un fabricante que coincida con el código que se le pase como
     * parámetro.
     * 
     * @param codigo Código del fabricante.
     * @return Fabricante. Si no ecnuentra el fabricante, devuelve null.
     */
    public Fabricante getFabricante(String codigo) {
        Fabricante resul = null;
        Boolean enc = false;
        if (this.listaFabricantes != null) {
            int n = this.listaFabricantes.size();
            int pos = 0;
            while ((!enc) && (pos < n)) {
                resul = this.listaFabricantes.get(pos);
                if (resul.getCodigo().equals(codigo))
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
     * Devuelve un fabricante que coincida con un nombre que se le pase como
     * parámetro.
     * 
     * @param nombre Nombre del fabricante.
     * @return Fabricante. Devuelve null si no lo encuentra.
     */
    public Fabricante getFabxNom(String nombre) {
        Fabricante resul = null;
        Boolean enc = false;
        if (this.listaFabricantes != null) {
            int n = this.listaFabricantes.size();
            int pos = 0;
            while ((!enc) && (pos < n)) {
                resul = this.listaFabricantes.get(pos);
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

    /**
     * Devuelve una lista de Fabricantes de un país. Siempre devuelve uan lista,
     * aunque esta esté vacía.
     * 
     * @param codPais Código del país.
     * @return Fabricantes.
     */
    public Fabricantes getFabrPais(int codPais) {
        Fabricantes resultado = new Fabricantes();
        Fabricante elem;
        if (this.listaFabricantes != null) {
            int n = this.listaFabricantes.size();
            for (int pos = 0; pos < n; pos++) {
                elem = this.listaFabricantes.get(pos);
                if (elem.getCodPais() == codPais) {
                    resultado.aniadeFabricante(elem);
                }
            }
        }
        return resultado;
    }

}
