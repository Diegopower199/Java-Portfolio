package mibbdd;

import java.util.Objects;

/**
 * Posición que ocupa una persona dentro de una empresa (Agente de ventas,
 * Gerente de marketing, propietario, etc).
 */

public class Cargo {
    private int codigo;
    private String nombre;

    /**
     * Constructor de la clase cargo.
     * 
     * @param c Código del cargo.
     * @param n Nombre del cargo.
     */
    public Cargo(int c, String n) {
        this.codigo = c;
        this.nombre = n;
    }

    /**
     * Devuelve el código del cargo.
     * 
     * @return Un int.
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * Establece el código del cargo.
     * 
     * @param codigo Código del cargo.
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    /**
     * Devuelve el nombre del cargo.
     * 
     * @return Un String.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del cargo.
     * 
     * @param nombre Nombre del cargo.
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
        int hash = 5;
        hash = 97 * hash + this.codigo;
        hash = 97 * hash + Objects.hashCode(this.nombre);
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
        final Cargo other = (Cargo) obj;
        if (this.codigo != other.codigo) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        return true;
    }

}
