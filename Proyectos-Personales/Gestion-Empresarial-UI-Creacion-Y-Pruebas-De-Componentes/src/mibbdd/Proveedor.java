
package mibbdd;

import java.util.Objects;

/**
 * Esta clase contiene información sobre Proveedores.
 */

public class Proveedor {
    private int codigo, codigoPais, codigoMunicipio;
    private String nombre, nombreContacto, telefono, emailContacto;

    /**
     * Constructor
     * 
     * @param codigo          Código del proveedor.
     * @param nombre          Nombre del proveedor.
     * @param nombreContacto  Nombre del contacto del proveedor.
     * @param telefono        Teléfono del proveedor.
     * @param emailContacto   Correo electrónico del proveedor.
     * @param codigoPais      Código del país del proveedor.
     * @param codigoMunicipio Código del municipio del proveedor.
     */
    public Proveedor(int codigo, String nombre, String nombreContacto, String telefono, String emailContacto,
            int codigoPais, int codigoMunicipio) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.nombreContacto = nombreContacto;
        this.telefono = telefono;
        this.emailContacto = emailContacto;
        this.codigoPais = codigoPais;
        this.codigoMunicipio = codigoMunicipio;
    }

    /**
     * Establece el código del proveedor.
     * 
     * @param codigo Código del proveedor.
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    /**
     * Devuelve el código del proveedor.
     * 
     * @return int.
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * Devuelve el código del país del proveedor.
     * 
     * @return int.
     */
    public int getCodigoPais() {
        return codigoPais;
    }

    /**
     * Establece el código del país del proveedor.
     * 
     * @param codigoPais Código del país del proveedor.
     */
    public void setCodigoPais(int codigoPais) {
        this.codigoPais = codigoPais;
    }

    /**
     * Devuelve el código del municipio del proveedor.
     * 
     * @return int.
     */
    public int getCodigoMunicipio() {
        return codigoMunicipio;
    }

    /**
     * Establece el código del municipio del proveedor.
     * 
     * @param codigoMunicipio Código del municipio del proveedor.
     */
    public void setCodigoMunicipio(int codigoMunicipio) {
        this.codigoMunicipio = codigoMunicipio;
    }

    /**
     * Devuelve el nombre del proveedor.
     * 
     * @return String.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del proveedor.
     * 
     * @param nombre Nombre del proveedor.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Devuelve el nombre del contacto del proveedor.
     * 
     * @return String.
     */
    public String getNombreContacto() {
        return nombreContacto;
    }

    /**
     * Establece el nombre del contacto del proveedor.
     * 
     * @param nombreContacto Nombre del contacto del proveedor.
     */
    public void setNombreContacto(String nombreContacto) {
        this.nombreContacto = nombreContacto;
    }

    /**
     * Devuelve el teléfono del proveedor.
     * 
     * @return String.
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Establece el teléfono del proveedor.
     * 
     * @param telefono Teléfono del proveedor.
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * Devuelve el correo electrónico del proveedor.
     * 
     * @return String.
     */
    public String getEmailContacto() {
        return emailContacto;
    }

    /**
     * Establece el correo electrónico del proveedor.
     * 
     * @param emailContacto Correo electrónico del proveedor.
     */
    public void setEmailContacto(String emailContacto) {
        this.emailContacto = emailContacto;
    }

    /**
     * Devuelve la función hash.
     * 
     * @return Un int.
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + this.codigo;
        hash = 23 * hash + this.codigoPais;
        hash = 23 * hash + this.codigoMunicipio;
        hash = 23 * hash + Objects.hashCode(this.nombre);
        hash = 23 * hash + Objects.hashCode(this.nombreContacto);
        hash = 23 * hash + Objects.hashCode(this.telefono);
        hash = 23 * hash + Objects.hashCode(this.emailContacto);
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
        final Proveedor other = (Proveedor) obj;
        if (this.codigo != other.codigo) {
            return false;
        }
        if (this.codigoPais != other.codigoPais) {
            return false;
        }
        if (this.codigoMunicipio != other.codigoMunicipio) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.nombreContacto, other.nombreContacto)) {
            return false;
        }
        if (!Objects.equals(this.telefono, other.telefono)) {
            return false;
        }
        if (!Objects.equals(this.emailContacto, other.emailContacto)) {
            return false;
        }
        return true;
    }

}
