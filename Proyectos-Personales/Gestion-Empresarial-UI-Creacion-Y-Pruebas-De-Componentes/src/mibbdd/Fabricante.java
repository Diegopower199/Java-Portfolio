
package mibbdd;

import java.util.Objects;

/**
 * Esta clase contiene información sobre un fabricante de productos
 */

public class Fabricante {
    private int clave, codPais;
    private String codigo, nombre;
    private Boolean activo;

    /**
     * Constructor.
     * 
     * @param cl  Clave del fabricante.
     * @param cod Código del fabricante. Es código alfanumérico para hacer
     *            referencia aun fabricante y no tener que utilizar el nombre, que
     *            suele ser más incómdo de manejar. Es, en definitiva, como un
     *            nombre corto del fabricante.
     * @param nom Nombre del fabricante.
     * @param act Indica si el fabricante sigue existiendo.
     * @param cpa Código del país del fabricante.
     */
    public Fabricante(int cl, String cod, String nom, Boolean act, int cpa) {
        clave = cl;
        codPais = cpa;
        codigo = cod;
        nombre = nom;
        activo = act;
    }

    /**
     * Devuelve la clave del fabricante.
     * 
     * @return int.
     */
    public int getClave() {
        return clave;
    }

    /**
     * Establece la clave del fabricante.
     * 
     * @param clave Clave del fabricante.
     */
    public void setClave(int clave) {
        this.clave = clave;
    }

    /**
     * Devuelve el código del país del fabricante.
     * 
     * @return int.
     */
    public int getCodPais() {
        return codPais;
    }

    /**
     * Establece el código del país del fabricante.
     * 
     * @param codPais Código del país del fabricante.
     */
    public void setCodPais(int codPais) {
        this.codPais = codPais;
    }

    /**
     * Devuelve el código alfanumérico del fabricante.
     * 
     * @return String.
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * Establece el código alfanumérico del fabricante.
     * 
     * @param codigo Código alfanumérico del fabricante.
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     * Devuelve el nombre del fabricante.
     * 
     * @return String.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del fabricante.
     * 
     * @param nombre Nombre del fabricante.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Indica si sigue existiendo el fabricante.
     * 
     * @return Boolean.
     */
    public Boolean getActivo() {
        return activo;
    }

    /**
     * Establece si el fabricante sigue existiendo o no.
     * 
     * @param activo Fabricante sigue existiendo o no.
     */
    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    /**
     * Devuelve la función hash.
     * 
     * @return Un int.
     */
    @Override
    public int hashCode() {
        return Objects.hash(activo, clave, codigo, codPais, nombre);
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
        Fabricante other = (Fabricante) obj;
        return Objects.equals(activo, other.activo) && clave == other.clave && Objects.equals(codigo, other.codigo)
                && codPais == other.codPais && Objects.equals(nombre, other.nombre);
    }
}
