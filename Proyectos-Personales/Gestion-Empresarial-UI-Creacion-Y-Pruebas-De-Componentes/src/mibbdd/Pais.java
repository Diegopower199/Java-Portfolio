package mibbdd;

import java.util.Objects;

/**
 * Esta clase contiene información de un país.
 */

public class Pais {
    private int codigo;
    private String nombre;

    /**
     * Constructor
     * 
     * @param c Código del país.
     * @param n Nombre del país.
     */
    public Pais(int c, String n) {
        codigo = c;
        nombre = n;
    }

    /**
     * Devuelve el ódigo del país.
     * 
     * @return int.
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * Establece el código del país.
     * 
     * @param codigo Código del país.
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    /**
     * Devuelve el nombre del país.
     * 
     * @return String.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del país.
     * 
     * @param nombre Nombre del país.
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
        Pais other = (Pais) obj;
        return codigo == other.codigo && Objects.equals(nombre, other.nombre);
    }

}
