package mibbdd;

import java.util.Objects;

/**
 * Esta clase contiene información sobre un cliente. El cliente es una compañía.
 */

public class Cliente {
    private String idCliente;
    private String nomCompania;
    private String nomContacto;
    private String direccion;
    private String codigoPostal;
    private int codCiudad;
    private String telefono;
    private int codCargo;

    /**
     * Constructor.
     * 
     * @param idCliente    Identificador del cliente. Es un código alfanumérico
     *                     (String).
     * @param nomCompania  Nombre de la compañía cliente.
     * @param nomContacto  Nombre del contacto de la compañía cliente.
     * @param dirección    Dirección de la compañía cliente.
     * @param codigoPostal Código postal de la ciudad de la compañía cliente.
     * @param ciudad       Código de la ciudad en la que se encuentra la compañía
     *                     cliente.
     * @param telefono     Teléfono de contacto de la compañía cliente.
     * @param codCargo     Código del cargo que ocupa el contacto de la compañía
     *                     cliente.
     */
    public Cliente(String idCliente, String nomCompania, String nomContacto, String direccion, String codigoPostal,
            int ciudad, String telefono, int codCargo) {
        this.idCliente = idCliente;
        this.nomCompania = nomCompania;
        this.nomContacto = nomContacto;
        this.direccion = direccion;
        this.codigoPostal = codigoPostal;
        this.codCiudad = ciudad;
        this.telefono = telefono;
        this.codCargo = codCargo;
    }

    /**
     * Devuelve el identificador del cliente.
     * 
     * @return String.
     */
    public String getIdCliente() {
        return idCliente;
    }

    /**
     * Establece el identificador del cliente.
     * 
     * @param idCliente Identificador del cliente.
     */
    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    /**
     * Devuelve el nombre de la compañía cliente.
     * 
     * @return String
     */
    public String getNomCompania() {
        return nomCompania;
    }

    /**
     * Establece el nombre de la compañía cliente.
     * 
     * @param nomCompania Nombre de la compañía cliente.
     */
    public void setNomCompania(String nomCompania) {
        this.nomCompania = nomCompania;
    }

    /**
     * Devuelve el nombre d econtacto de la compañía cliente.
     * 
     * @return String.
     */
    public String getNomContacto() {
        return nomContacto;
    }

    /**
     * Establece el nombre del contacto de la compañía cliente.
     * 
     * @param nomContacto Nombre del contacto de la compañía cliente.
     */
    public void setNomContacto(String nomContacto) {
        this.nomContacto = nomContacto;
    }

    /**
     * Devuelve la dirección de la compañía cliente.
     * 
     * @return String.
     */
    public String getdireccion() {
        return direccion;
    }

    /**
     * Establece la dirección de la compañía cliente.
     * 
     * @param dirección Dirección de la compañía cliente.
     */
    public void setdireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * Devuelve el código postal de la compañía cliente.
     * 
     * @return String.
     */
    public String getCodigoPostal() {
        return codigoPostal;
    }

    /**
     * Establece el código postal de la compañía cliente.
     * 
     * @param codigoPostal Código postal de la compañía cliente.
     */
    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    /**
     * Devuelve el código de la ciudad de la compañía cliente.
     * 
     * @return int.
     */
    public int getCodCiudad() {
        return codCiudad;
    }

    /**
     * Establece el código de la cidad de la compañía cliente.
     * 
     * @param ciudad Código de la cidad de la compañía cliente.
     */
    public void setCodCiudad(int ciudad) {
        this.codCiudad = ciudad;
    }

    /**
     * Devuelve el teléfono de la compañía cliente.
     * 
     * @return String.
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Establece el teléfono de la compañía cliente.
     * 
     * @param telefono Número (String) de teléfono de la compañía cliente.
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * Devuelve el código del cargo que ocupa el contacto de la compañía cliente.
     * 
     * @return int.
     */
    public int getCodCargo() {
        return codCargo;
    }

    /**
     * Establece el cargo de la compañía cliente.
     * 
     * @param codCargo Cargo de la compañía cliente.
     */
    public void setCodCargo(int codCargo) {
        this.codCargo = codCargo;
    }

    /**
     * Devuelve la función hash.
     * 
     * @return Un int.
     */

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + Objects.hashCode(this.idCliente);
        hash = 19 * hash + Objects.hashCode(this.nomCompania);
        hash = 19 * hash + Objects.hashCode(this.nomContacto);
        hash = 19 * hash + Objects.hashCode(this.direccion);
        hash = 19 * hash + Objects.hashCode(this.codigoPostal);
        hash = 19 * hash + this.codCiudad;
        hash = 19 * hash + Objects.hashCode(this.telefono);
        hash = 19 * hash + this.codCargo;
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
        final Cliente other = (Cliente) obj;
        if (this.codCiudad != other.codCiudad) {
            return false;
        }
        if (this.codCargo != other.codCargo) {
            return false;
        }
        if (!Objects.equals(this.idCliente, other.idCliente)) {
            return false;
        }
        if (!Objects.equals(this.nomCompania, other.nomCompania)) {
            return false;
        }
        if (!Objects.equals(this.nomContacto, other.nomContacto)) {
            return false;
        }
        if (!Objects.equals(this.direccion, other.direccion)) {
            return false;
        }
        if (!Objects.equals(this.codigoPostal, other.codigoPostal)) {
            return false;
        }
        if (!Objects.equals(this.telefono, other.telefono)) {
            return false;
        }
        return true;
    }

}
