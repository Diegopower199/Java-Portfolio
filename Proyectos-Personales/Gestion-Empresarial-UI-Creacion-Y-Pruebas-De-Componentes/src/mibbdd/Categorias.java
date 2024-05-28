package mibbdd;

import java.util.ArrayList;

/**
 * Lista de categorías de productos.
 */

public class Categorias {
    private ArrayList<Categoria> listaCategorias;

    /**
     * Constructor.
     */
    public Categorias() {
        listaCategorias = new ArrayList<Categoria>();
    }

    /**
     * Devuelve la categoría que ocupa una posición en la lista.
     * 
     * @param pos Posición de la categoría.
     * @return Categoria.
     */
    public Categoria getCategoriaPos(int pos) {
        return this.listaCategorias.get(pos);
    }

    /**
     * Devuelve la lista de categorías de productos.
     * 
     * @return ArrayList<Categoria>
     */
    public ArrayList<Categoria> getListaCategorias() {
        return listaCategorias;
    }

    /**
     * Establece la lista de categorías de productos.
     * 
     * @param listaCategorias Lista de categorías de productos.
     */
    public void setListaCategorias(ArrayList<Categoria> listaCategorias) {
        this.listaCategorias = listaCategorias;
    }

    /**
     * Devuelve la Categoría a partir de un códio de categoría.
     * 
     * @param codigo Código de la categoróa.
     * @return Categoria
     */
    public Categoria getCategoria(int codigo) {
        Categoria resul = null;
        Boolean enc = false;
        if (this.listaCategorias != null) {
            int n = this.listaCategorias.size();
            int pos = 0;
            while ((!enc) && (pos < n)) {
                resul = this.listaCategorias.get(pos);
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
     * Devuelve la Categoria a partir de un nombre de categoría.
     * 
     * @param nombre Nombre de la categoría.
     * @return Categoria. Devolverá null si no encuetra la categoría.
     */
    public Categoria getCategoria(String nombre) {
        Categoria resul = null;
        Boolean enc = false;
        if (this.listaCategorias != null) {
            int n = this.listaCategorias.size();
            int pos = 0;
            while ((!enc) && (pos < n)) {
                resul = this.listaCategorias.get(pos);
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
