package mibbdd;

import java.util.Objects;

/**
 * Esta información contiene información sobre un producto.
 */

public class Producto {
    int codigo, unidExist, unidAviso, codProv, codCateg, codFab;
    String nombre, descripcion;
    float precioUni;
    Boolean suspendido;

    /**
     * Constructor
     * 
     * @param cod  Código del producto.
     * @param nom  Nombre del producto.
     * @param desc Descripción del producto.
     * @param pu   Precio unitario del producto.
     * @param ue   Unidades existentes (stock) del producto.
     * @param ua   Cantidad a partir de la cual saltará un aviso de que hay que
     *             adquirir más producto.
     * @param sus  Indica si el producto está o no suspendido.
     * @param cp   Código del proveedor que nos sirve el producto.
     * @param cc   Código de la categoría del producto
     * @param cf   Código del fabricante del producto.
     */
    public Producto(int cod, String nom, String desc, float pu, int ue, int ua, Boolean sus, int cp, int cc, int cf) {
        codigo = cod;
        nombre = nom;
        descripcion = desc;
        precioUni = pu;
        unidExist = ue;
        unidAviso = ua;
        suspendido = sus;
        codProv = cp;
        codCateg = cc;
        codFab = cf;
    }

    /**
     * Devuelve el código del fabricante del producto.
     * 
     * @return int.
     */
    public int getcodFab() {
        return codFab;
    }

    /**
     * Establece el código del fabricante del producto.
     * 
     * @param codFab Código del fabricante del producto.
     */
    public void setcodFab(int codFab) {
        this.codFab = codFab;
    }

    /**
     * Devuelve el código del producto.
     * 
     * @return int.
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * Establece el código del producto.
     * 
     * @param codigo Código del producto.
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    /**
     * Devuelve la unidades que hay en stock del producto.
     * 
     * @return int.
     */
    public int getUnidExist() {
        return unidExist;
    }

    /**
     * Establece la unidades que hay en stock del producto.
     * 
     * @param unidExist Unidades que hay en stock del producto.
     */
    public void setUnidExist(int unidExist) {
        this.unidExist = unidExist;
    }

    /**
     * Devuelve la cantida a partir de la cual se avisará de que hay que adquirir
     * más producto.
     * 
     * @return int.
     */
    public int getUnidAviso() {
        return unidAviso;
    }

    /**
     * Establece la cantida a partir de la cual se avisará de que hay que adquirir
     * más producto.
     * 
     * @param unidAviso Cantida a partir de la cual se avisará de que hay que
     *                  adquirir más producto.
     */
    public void setUnidAviso(int unidAviso) {
        this.unidAviso = unidAviso;
    }

    /**
     * Devuelve el código del proveedor del producto.
     * 
     * @return int.
     */
    public int getCodProv() {
        return codProv;
    }

    /**
     * Establece el código del proveedor del producto.
     * 
     * @param codProv Código del proveedor del producto.
     */
    public void setCodProv(int codProv) {
        this.codProv = codProv;
    }

    /**
     * Devuelve el código de la categoría del producto.
     * 
     * @return int.
     */
    public int getCodCateg() {
        return codCateg;
    }

    /**
     * Establece el código de la categoría del producto.
     * 
     * @param codCateg Código de la categoría del producto.
     */
    public void setCodCateg(int codCateg) {
        this.codCateg = codCateg;
    }

    /**
     * Devuelve el nombre del producto.
     * 
     * @return String.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Devuelve el nombre del producto.
     * 
     * @param nombre Nombre del producto.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Devuelve la descripción del producto.
     * 
     * @return String.
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Establece la descripción del producto.
     * 
     * @param descripcion Descripción del producto.
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Devuelve el precio unitario del producto.
     * 
     * @return float.
     */
    public float getPrecioUni() {
        return precioUni;
    }

    /**
     * Establece el precio unitario del producto.
     * 
     * @param precioUni Precio unitario del producto.
     */
    public void setPrecioUni(float precioUni) {
        this.precioUni = precioUni;
    }

    /**
     * Indica si el producto está o no suspendido.
     * 
     * @return Boolean.
     */
    public Boolean getSuspendido() {
        return suspendido;
    }

    /**
     * Establece si el producto está o no suspendido.
     * 
     * @param suspendido true/false para indicar si el producto está suspendido.
     */
    public void setSuspendido(Boolean suspendido) {
        this.suspendido = suspendido;
    }

    /**
     * Devuelve la función hash.
     * 
     * @return Un int.
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + this.codigo;
        hash = 61 * hash + this.unidExist;
        hash = 61 * hash + this.unidAviso;
        hash = 61 * hash + this.codProv;
        hash = 61 * hash + this.codCateg;
        hash = 61 * hash + Objects.hashCode(this.nombre);
        hash = 61 * hash + Objects.hashCode(this.descripcion);
        hash = 61 * hash + Float.floatToIntBits(this.precioUni);
        hash = 61 * hash + Objects.hashCode(this.suspendido);
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
        final Producto other = (Producto) obj;
        if (this.codigo != other.codigo) {
            return false;
        }
        if (this.unidExist != other.unidExist) {
            return false;
        }
        if (this.unidAviso != other.unidAviso) {
            return false;
        }
        if (this.codProv != other.codProv) {
            return false;
        }
        if (this.codCateg != other.codCateg) {
            return false;
        }
        if (Float.floatToIntBits(this.precioUni) != Float.floatToIntBits(other.precioUni)) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.descripcion, other.descripcion)) {
            return false;
        }
        if (!Objects.equals(this.suspendido, other.suspendido)) {
            return false;
        }
        return true;
    }

}
