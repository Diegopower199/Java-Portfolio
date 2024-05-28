package mibbdd;

import java.util.Objects;

/**
 * Esta clase contiene información de una compañía de envío de paquetes
 */

public class CompEnvio {
    private int codigo;
    private String nombre;

    /**
     * Constructor
     * 
     * @param c Código de la compañia de envíos.
     * @param n Nombre de la compañia de envíos.
     */
    public CompEnvio(int c, String n) {
        this.codigo = c;
        this.nombre = n;
    }

    /**
     * Devuelve el código de la compañia de envíos.
     * 
     * @return int.
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * Establece el código de la compañia de envíos.
     * 
     * @param codigo Código de la compañia de envíos.
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    /**
     * Devuelve el nombre de la compañía de envíos.
     * 
     * @return String.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre de la compañía de envíos.
     * 
     * @param nombre Nombre de la compañía de envíos.
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
        hash = 29 * hash + this.codigo;
        hash = 29 * hash + Objects.hashCode(this.nombre);
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
        final CompEnvio other = (CompEnvio) obj;
        if (this.codigo != other.codigo) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        return true;
    }

}
