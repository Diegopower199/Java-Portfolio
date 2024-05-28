package mibbdd;

import java.util.ArrayList;

/**
 * Lista de Municipios.
 */

public class Municipios {
    /**
     * Contiene la lista de municipios.
     */
    ArrayList<Municipio> ListaMunicipios;

    /**
     * Constructor.
     */
    public Municipios() {
        ListaMunicipios = new ArrayList<>();
    }

    /**
     * Devuelve el municipio que ocupa una posición en la lista.
     * 
     * @param pos Posición que ocupa el municipio en l lista.
     * @return Municipio.
     */
    public Municipio getMunicipioPos(int pos) {
        return this.ListaMunicipios.get(pos);
    }

    /**
     * Devuelve la lista de municipios.
     * 
     * @return ArrayList<Municipio>
     */
    public ArrayList<Municipio> getListaMunicipios() {
        return ListaMunicipios;
    }

    /**
     * Establece la lista de municipios.
     * 
     * @param ListaMunicipios Lista de municipios.
     */
    public void setListaMunicipios(ArrayList<Municipio> ListaMunicipios) {
        this.ListaMunicipios = ListaMunicipios;
    }

    /**
     * Añade un municipio a la lista de municipios.
     * 
     * @param mun Municipio.
     */
    public void aniadeMunicipio(Municipio mun) {
        this.ListaMunicipios.add(mun);
    }

    /**
     * Devuelve un mucipio a partir de su código.
     * 
     * @param codigo Código del municipio.
     * @return Municipio. Devuelve null si no encuentra el municipio.
     */
    public Municipio getMunicipio(int codigo) {
        Municipio resul = null;
        Boolean enc = false;
        if (this.ListaMunicipios != null) {
            int n = this.ListaMunicipios.size();
            int pos = 0;
            while ((!enc) && (pos < n)) {
                resul = this.ListaMunicipios.get(pos);
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
     * Devuelve el municipio a partir del nombre del minicipio.
     * 
     * @param nombre Nombre del municipio.
     * @return Municipio. Devuelve null si no encuentra el municipio.
     */
    public Municipio getMunicipio(String nombre) {
        Municipio resul = null;
        Boolean enc = false;
        if (this.ListaMunicipios != null) {
            int n = this.ListaMunicipios.size();
            int pos = 0;
            while ((!enc) && (pos < n)) {
                resul = this.ListaMunicipios.get(pos);
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
     * Devuelve una lista de municipios (Municipios) de una provincia
     * 
     * @param codProvincia Código de la provincia.
     * @return Municipios
     */
    public Municipios getMunicipiosProv(int codProvincia) {
        Municipios ListMun = new Municipios();
        Municipio mun;
        if (this.ListaMunicipios != null) {
            int n = this.ListaMunicipios.size();
            for (int pos = 0; pos < n; pos++) {
                mun = this.ListaMunicipios.get(pos);
                if (mun.getCodProvincia() == codProvincia)
                    ListMun.aniadeMunicipio(mun);
            }
        }
        return ListMun;
    }

    /**
     * Devuelve el número de municipos que hay en la clase.
     * En caso de que la clase esté vacía, devolverá 0.
     * En el caso de que la lista sea null, devolverá -1.
     * 
     * @return int
     */
    public int getNumMunicipios() {
        int resul = -1;
        if (this.ListaMunicipios != null)
            resul = this.ListaMunicipios.size();
        return resul;
    }

}
