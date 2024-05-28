package mibbdd;

import java.util.ArrayList;

/**
 * Contiene una lista de ciudades.
 */

public class Ciudades {
    private ArrayList<Ciudad> listaCiudades;
    ArrayList<Ciudad> listaCiudadesString;

    /**
     * Constructor.
     */
    public Ciudades() {
        this.listaCiudades = new ArrayList<>();
        listaCiudades = new ArrayList<Ciudad>();
        listaCiudades = Cargar.Ciudades();

    }

    /**
     * Devuelve la lista de ciudades.
     * 
     * @return ArrayList<Ciudad>
     */
    public ArrayList<Ciudad> getListaCiudades() {
        return listaCiudades;
    }

    /**
     * Establece la lista de ciudades.
     * 
     * @param listaCiudades Lista de ciudades.
     */
    public void setListaCiudades(ArrayList<Ciudad> listaCiudades) {
        this.listaCiudades = listaCiudades;
    }

    /**
     * Añade una ciudad a la lista.
     * 
     * @param c Ciudad.
     */
    public void aniadeCiudad(Ciudad c) {
        this.listaCiudades.add(c);
    }

    /**
     * Devuelve el número de ciudades almacenadas en la lista.
     * 
     * @return int
     */
    public int getNumCiudades() {
        int resul;
        if (this.listaCiudades == null)
            resul = 0;
        else
            resul = this.listaCiudades.size();
        return resul;
    }

    /**
     * Devuelve una ciudada partir de su código.
     * 
     * @param codigo Código de la ciudad.
     * @return Ciudad. Devolverá null si no encuentra la ciudad.
     */
    public Ciudad getCiudad(int codigo) {
        Ciudad resul = null;
        Boolean enc = false;
        if (this.listaCiudades != null) {
            int n = this.listaCiudades.size();
            int pos = 0;
            while ((!enc) && (pos < n)) {
                resul = this.listaCiudades.get(pos);
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
     * Devuelve una lista de las ciudades de un pais.
     * 
     * @param codigo Código del país
     * @return Ciudades
     */
    public Ciudades getCiudadesPais(int codigo) {
        Ciudades listaResul = new Ciudades();
        if (this.listaCiudades != null) {
            int n = this.listaCiudades.size();
            for (int pos = 0; pos < n; pos++) {
                if (this.listaCiudades.get(pos).getCodPais() == codigo)
                    listaResul.aniadeCiudad(this.listaCiudades.get(pos));
            }
        }
        return listaResul;
    }

    /**
     * Devuelve la ciudad que ocupa una posición en la lista.
     * 
     * @param posicion Posición que ocupa la ciudad en la lista.
     * @return Ciudad.
     */
    public Ciudad getCiudadPos(int posicion) {
        return this.listaCiudades.get(posicion);
    }

}
