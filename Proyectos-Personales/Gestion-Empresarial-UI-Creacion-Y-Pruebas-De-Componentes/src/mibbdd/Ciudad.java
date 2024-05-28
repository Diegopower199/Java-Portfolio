package mibbdd;

import java.util.Objects;

/**
 * Esta clase contiene la información referente a una ciudad. Las ciudades son a
 * nivel mundial y están rlacionadas con un país.
 * No se debe confundir con la clase Municipio, que son municipios de España
 * exclusivamente.
 */

public class Ciudad {
    private int codigo, codPais;
    private String nombre;

    /**
     * Constructor.
     * 
     * @param c  Código de la ciudad.
     * @param n  Nombre de la ciudad.
     * @param cp Código del país al que pertenece la ciudad.
     */
    public Ciudad(int c, String n, int cp) {
        this.codigo = c;
        this.nombre = n;
        this.codPais = cp;
    }

    /**
     * Código de la ciudad.
     * 
     * @return int.
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * Establece el código de la ciudad.
     * 
     * @param codigo Código de la ciudad.
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    /**
     * Devuelve el código del país de la ciudad.
     * 
     * @return int.
     */
    public int getCodPais() {
        return codPais;
    }

    /**
     * Establece el código del país de la ciudad.
     * 
     * @param codPais Código del país.
     */
    public void setCodPais(int codPais) {
        this.codPais = codPais;
    }

    /**
     * Devuelve el nombre de la ciudad.
     * 
     * @return String.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre de la ciudad.
     * 
     * @param nombre String.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Devuelve la función hash.
     * 
     * @return Un int.
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + this.codigo;
        hash = 37 * hash + this.codPais;
        hash = 37 * hash + Objects.hashCode(this.nombre);
        return hash;
    }

    /**
     * Indica si este objeto es igual a otro que se le pasa como parámetro.
     * 
     * @param obj objeto con el que se le compara.
     * @return Un Boolean. Verdadero si son iguales y false en caso contrario.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Ciudad other = (Ciudad) obj;
        if (this.codigo != other.codigo) {
            return false;
        }
        if (this.codPais != other.codPais) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        return true;
    }

}
