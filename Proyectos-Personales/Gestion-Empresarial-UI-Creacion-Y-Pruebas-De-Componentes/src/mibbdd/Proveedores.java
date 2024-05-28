package mibbdd;

import java.util.ArrayList;

/**
 * Lista de proveedores.
 */

public class Proveedores {
    private ArrayList<Proveedor> listaProveedores;

    /**
     * Constructor.
     */
    public Proveedores() {
        listaProveedores = new ArrayList<Proveedor>();
    }

    /**
     * Devuelve el proveedor que ocupa una posición en la lista.
     * 
     * @param pos Posición del proveedor.
     * @return Proveedor.
     */
    public Proveedor getProveedorPos(int pos) {
        return this.listaProveedores.get(pos);
    }

    /**
     * Devuelve la lista de proveedores.
     * 
     * @return ArrayList<Proveedor>.
     */
    public ArrayList<Proveedor> getListaProveedores() {
        return listaProveedores;
    }

    /**
     * Establece la lista de proveedores.
     * 
     * @param listaProveedores Lista de proveedores.
     */
    public void setListaProveedores(ArrayList<Proveedor> listaProveedores) {
        this.listaProveedores = listaProveedores;
    }

    /**
     * Añade un proveedor a la lista.
     * 
     * @param p Proveedor.
     */
    public void aniadeProveedor(Proveedor p) {
        listaProveedores.add(p);
    }

    /**
     * Devuelve el proveedor según el código pasado como parámetro.Esta clase
     * contiene información sobre Proveedores.
     * 
     * @param codigo Código del proveedor.
     * @return Proveedor. Devuelve null si no encuentra el proveedor.
     */
    public Proveedor getProveedor(int codigo) {
        Proveedor resul = null;
        Boolean enc = false;
        if (this.listaProveedores != null) {
            int n = this.listaProveedores.size();
            int pos = 0;
            while ((!enc) && (pos < n)) {
                resul = this.listaProveedores.get(pos);
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
     * Devuelve el proveedor según el nombre pasado como parámetro.Esta clase
     * contiene información sobre Proveedores.
     * 
     * @param nombre. Nombre del proveedor.
     * @return Proveedor. Devuelve null si no encuentra el proveedor.
     */
    public Proveedor getProveedor(String nombre) {
        Proveedor resul = null;
        Boolean enc = false;
        if (this.listaProveedores != null) {
            int n = this.listaProveedores.size();
            int pos = 0;
            while ((!enc) && (pos < n)) {
                resul = this.listaProveedores.get(pos);
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
     * Devuelve un objeto de la clase Proveedores con los proveedores de un país.
     * Siempre devolverá un objeto Proveedores.
     * 
     * @param codigo Código del país de proveedores.
     * @return Proveedores
     */
    public Proveedores getProveedoresPais(int codigo) {
        Proveedores resul = new Proveedores();
        if (this.listaProveedores != null) {
            int n = this.listaProveedores.size();
            for (int pos = 0; pos < n; pos++) {
                if (this.listaProveedores.get(pos).getCodigoPais() == codigo)
                    aniadeProveedor(this.listaProveedores.get(pos));
            }
        }
        return resul;
    }

    /**
     * Devuelve el número de proveedores.
     * 
     * @return int. Devolverá -1 si la lista de proveedores es null.
     */
    public int getNumProveedores() {
        int resul = -1;
        if (this.listaProveedores != null)
            resul = this.listaProveedores.size();
        return resul;
    }

}
