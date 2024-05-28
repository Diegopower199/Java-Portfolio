package mibbdd;

import java.util.Objects;

/**
 * Clasificación de un producto (lácteo, carnes, etc.)
 */

public class Categoria {
    private int codigo;
    private String nombre, descripcion;

    /**
     * Constructor de Categoría.
     */
    public Categoria() {
    }

    /**
     * Constructor de categoría.
     * 
     * @param c Código de la categoría.
     * @param n Nombre de la categoría.
     * @param d Descripción de la categoría.
     */
    public Categoria(int c, String n, String d) {
        this.codigo = c;
        this.nombre = n;
        this.descripcion = d;
    }

    /**
     * Devuelve el código de la categoría.
     * 
     * @return int.
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * Establece el código de una categoría.
     * 
     * @param codigo Código de la categoría.
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    /**
     * Devuelve el nombre de la categoría.
     * 
     * @return String.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre de la categoría.
     * 
     * @param nombre Nombre de la categoría.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Devuelve la descripción de la categoría.
     * 
     * @return String.
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Establece la descripción de la categoría.
     * 
     * @param descripcion Descripción de la categoría.
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Devuelve la función hash.
     * 
     * @return Un int.
     */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + this.codigo;
        hash = 89 * hash + Objects.hashCode(this.nombre);
        hash = 89 * hash + Objects.hashCode(this.descripcion);
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
        final Categoria other = (Categoria) obj;
        if (this.codigo != other.codigo) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.descripcion, other.descripcion)) {
            return false;
        }
        return true;
    }

}
