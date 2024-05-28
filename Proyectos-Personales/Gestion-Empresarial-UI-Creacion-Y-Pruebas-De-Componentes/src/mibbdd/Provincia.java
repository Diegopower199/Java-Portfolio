
package mibbdd;

import java.util.Objects;

/**
 * Esta clase contiene información sobre una provincia de España.
 */

public class Provincia {
    private int codigo;
    private String nombre;

    /**
     * Constructor
     * 
     * @param c Código de la provincia.
     * @param n Nombre de la provincia.
     */
    public Provincia(int c, String n) {
        this.codigo = c;
        this.nombre = n;
    }

    /**
     * Devuelve el código de la provincia.
     * 
     * @return int.
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * Establece el código de la provincia.
     * 
     * @param codigo Código de la provincia.
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    /**
     * Devuelve el nombre de la provincia.
     * 
     * @return String.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre de la provincia.
     * 
     * @param nombre Nombre de la provincia.
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
        return Objects.hash(codigo, nombre);
    }

    /**
     * Indica si este objeto es igual a otro que se le pasa como parámetro.
     * 
     * @param obj objeto con el que se le compara.
     * @return Un Boolean. Verdadero si son iguales y false en caso contrario.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Provincia other = (Provincia) obj;
        return codigo == other.codigo && Objects.equals(nombre, other.nombre);
    }
}
