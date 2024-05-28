package mibbdd;

import java.util.Objects;

/**
 * Esta clase contiene información de un municipio de España.
 */

public class Municipio {
    private int codigo;
    private int codProvincia;
    private String nombre;

    /**
     * Constructor.
     * 
     * @param c  Código del municipio.
     * @param cp Código de la provincia del municipio.
     * @param n  Nombre del municipio.
     */
    public Municipio(int c, int cp, String n) {
        this.codigo = c;
        this.codProvincia = cp;
        this.nombre = n;

    }

    /**
     * Devuelve el código del municipio.
     * 
     * @return int.
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * Establece el código del municipio.
     * 
     * @param codigo Código del municipio.
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    /**
     * Devuelve el código de la provincia del municipio.
     * 
     * @return int.
     */
    public int getCodProvincia() {
        return codProvincia;
    }

    /**
     * Establece el código de la provincia del municipio.
     * 
     * @param codProvincia Código de la provincia del municipio.
     */
    public void setCodProvincia(int codProvincia) {
        this.codProvincia = codProvincia;
    }

    /**
     * Devuelve el nombre del municipio.
     * 
     * @return String.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del municipio.
     * 
     * @param nombre Nombre del municipio.
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
        hash = 53 * hash + this.codigo;
        hash = 53 * hash + this.codProvincia;
        hash = 53 * hash + Objects.hashCode(this.nombre);
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
        final Municipio other = (Municipio) obj;
        if (this.codigo != other.codigo) {
            return false;
        }
        if (this.codProvincia != other.codProvincia) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        return true;
    }

}
