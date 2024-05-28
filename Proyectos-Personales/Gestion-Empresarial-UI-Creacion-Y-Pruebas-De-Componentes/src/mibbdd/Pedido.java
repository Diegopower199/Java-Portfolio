package mibbdd;

import java.util.Date;
import java.util.Objects;

/**
 * Esta clase contiene información sobre un pedido.
 */

public class Pedido {
    private int codigo;
    private String idCliente;
    private int codEmpleado;
    private Date fechaPedido;
    private Date fechaEntrega;
    private Date fechaEnvio;
    private float cargo;
    private String direccion;
    private String codPostal;
    private int codCiudad;
    private int codEmprEnvio;

    /**
     *
     * @param codigo       Código del pedido.
     * @param idCliente    Identificador del pedido.
     * @param codEmpleado  Código del empleado que ha gestionado el pedido.
     * @param fechaPedido  Fecha en la que se ha realizado el pedido.
     * @param fechaEntrega Fecha en la que se ha entregado el pedido.
     * @param fechaEnvio   Fecha en la que se ha enviado el pedido.
     * @param cargo        Cargo del pedido.
     * @param direccion    Dirección del pedido.
     * @param codPostal    Código postal del pedido.
     * @param codCiudad    Código de la ciudad a la que se ha enviado el pedido.
     * @param codEmprEnvio Código de la empresa a través de la cual se ha enviado el
     *                     pedido.
     */
    public Pedido(int codigo, String idCliente, int codEmpleado, Date fechaPedido, Date fechaEntrega, Date fechaEnvio,
            float cargo, String direccion, String codPostal, int codCiudad, int codEmprEnvio) {
        this.codigo = codigo;
        this.idCliente = idCliente;
        this.codEmpleado = codEmpleado;
        this.fechaPedido = fechaPedido;
        this.fechaEntrega = fechaEntrega;
        this.fechaEnvio = fechaEnvio;
        this.cargo = cargo;
        this.direccion = direccion;
        this.codPostal = codPostal;
        this.codCiudad = codCiudad;
        this.codEmprEnvio = codEmprEnvio;
    }

    /**
     * Devuelve el código del pedido.
     * 
     * @return int.
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * Establece el código del pedido.
     * 
     * @param codigo Código del pedido.
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    /**
     * Devuelve el identificador cliente del pedido.
     * 
     * @return String.
     */
    public String getIdCliente() {
        return idCliente;
    }

    /**
     * Establece el identificador cliente del pedido.
     * 
     * @param idCliente Identificador cliente del pedido.
     */
    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    /**
     * Devuelve el código del empleado que ha tramitado el pedido.
     * 
     * @return int.
     */
    public int getCodEmpleado() {
        return codEmpleado;
    }

    /**
     * Establece el código del empleado que ha tramitado el pedido.
     * 
     * @param codEmpleado Código del empleado que ha tramitado el pedido.
     */
    public void setCodEmpleado(int codEmpleado) {
        this.codEmpleado = codEmpleado;
    }

    /**
     * Devuelve la fecha de realización del pedido.
     * 
     * @return Date.
     */
    public Date getFechaPedido() {
        return fechaPedido;
    }

    /**
     * Establece la fecha de realización del pedido.
     * 
     * @param fechaPedido Fecha de realización del pedido.
     */
    public void setFechaPedido(Date fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    /**
     * Devuelve la fecha de entrega del pedido.
     * 
     * @return Date.
     */
    public Date getFechaEntrega() {
        return fechaEntrega;
    }

    /**
     * Establece la fecha de entrega del pedido.
     * 
     * @param fechaEntrega Fecha de entrega del pedido.
     */
    public void setFechaEntrega(Date fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    /**
     * Devuelve la fecha de envío del pedido.
     * 
     * @return Date.
     */
    public Date getFechaEnvio() {
        return fechaEnvio;
    }

    /**
     * Establece la fecha de envío del pedido.
     * 
     * @param fechaEnvio Fecha de envío del pedido.
     */
    public void setFechaEnvio(Date fechaEnvio) {
        this.fechaEnvio = fechaEnvio;
    }

    /**
     * Devuelve el cargo del pedido.
     * 
     * @return float.
     */
    public float getCargo() {
        return cargo;
    }

    /**
     * Establece el cargo del pedido.
     * 
     * @param cargo Cargo del pedido.
     */
    public void setCargo(float cargo) {
        this.cargo = cargo;
    }

    /**
     * Devuelve la dirección del pedido.
     * 
     * @return String.
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * Establece la dirección del pedido.
     * 
     * @param direccion Dirección del pedido.
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * Devuelve el código postal del pedido.
     * 
     * @return String.
     */
    public String getCodPostal() {
        return codPostal;
    }

    /**
     * Establece el código postal del pedido.
     * 
     * @param codPostal Código postal del pedido.
     */
    public void setCodPostal(String codPostal) {
        this.codPostal = codPostal;
    }

    /**
     * Devuelve el código de la ciudad a la que se ha enviado el pedido.
     * 
     * @return int.
     */
    public int getCodCiudad() {
        return codCiudad;
    }

    /**
     * Establece el código de la ciudad a la que se ha enviado el pedido.
     * 
     * @param codCiudad Código de la ciudad a la que se ha enviado el pedido.
     */
    public void setCodCiudad(int codCiudad) {
        this.codCiudad = codCiudad;
    }

    /**
     * Devuelve el código de la empresa a través de la cual se ha enviado el pedido.
     * 
     * @return int.
     */
    public int getCodEmprEnvio() {
        return codEmprEnvio;
    }

    /**
     * Establece el código de la empresa a través de la cual se ha enviado el
     * pedido.
     * 
     * @param codEmprEnvio Código de la empresa a través de la cual se ha enviado el
     *                     pedido.
     */
    public void setCodEmprEnvio(int codEmprEnvio) {
        this.codEmprEnvio = codEmprEnvio;
    }

    /**
     * Devuelve la función hash.
     * 
     * @return Un int.
     */
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 13 * hash + this.codigo;
        hash = 13 * hash + Objects.hashCode(this.idCliente);
        hash = 13 * hash + this.codEmpleado;
        hash = 13 * hash + Objects.hashCode(this.fechaPedido);
        hash = 13 * hash + Objects.hashCode(this.fechaEntrega);
        hash = 13 * hash + Objects.hashCode(this.fechaEnvio);
        hash = 13 * hash + Float.floatToIntBits(this.cargo);
        hash = 13 * hash + Objects.hashCode(this.direccion);
        hash = 13 * hash + Objects.hashCode(this.codPostal);
        hash = 13 * hash + this.codCiudad;
        hash = 13 * hash + this.codEmprEnvio;
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
        final Pedido other = (Pedido) obj;
        if (this.codigo != other.codigo) {
            return false;
        }
        if (this.codEmpleado != other.codEmpleado) {
            return false;
        }
        if (Float.floatToIntBits(this.cargo) != Float.floatToIntBits(other.cargo)) {
            return false;
        }
        if (this.codCiudad != other.codCiudad) {
            return false;
        }
        if (this.codEmprEnvio != other.codEmprEnvio) {
            return false;
        }
        if (!Objects.equals(this.idCliente, other.idCliente)) {
            return false;
        }
        if (!Objects.equals(this.direccion, other.direccion)) {
            return false;
        }
        if (!Objects.equals(this.codPostal, other.codPostal)) {
            return false;
        }
        if (!Objects.equals(this.fechaPedido, other.fechaPedido)) {
            return false;
        }
        if (!Objects.equals(this.fechaEntrega, other.fechaEntrega)) {
            return false;
        }
        if (!Objects.equals(this.fechaEnvio, other.fechaEnvio)) {
            return false;
        }
        return true;
    }

}
