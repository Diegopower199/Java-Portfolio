package mibbdd;

import java.util.Objects;

/**
 * Esta clase contiene información de un empleado encargado de tramitar un
 * pedido.
 */

public class Empleado {
    private int codigo, codCiudad, codCargo;
    private String nombre, apellidos;

    /**
     * Constructor.
     * 
     * @param codigo    Código del empleado.
     * @param nombre    Nombre del empleado.
     * @param apellidos Apellidos del empleado.
     * @param codCargo  Código del cargo que ocupa el empleado.
     * @param codCiudad Código de la ciudad en la que reside el empleado.
     */

    public Empleado(int codigo, String nombre, String apellidos, int codCargo, int codCiudad) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.codCargo = codCargo;
        this.codCiudad = codCiudad;
    }

    /**
     * Devuelve el código del empleado.
     * 
     * @return int.
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * Establece el código del empleado.
     * 
     * @param codigo Código del empleado.
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    /**
     * Devuelve el código de la ciudad en la que reside el empleado.
     * 
     * @return int.
     */
    public int getCodCiudad() {
        return codCiudad;
    }

    /**
     * Establece el código de la ciudad del empleado.
     * 
     * @param codCiudad Código de la ciudad en la que reside el empleado.
     */
    public void setCodCiudad(int codCiudad) {
        this.codCiudad = codCiudad;
    }

    /**
     * Devuelve el nombre del empleado.
     * 
     * @return String.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del empleado.
     * 
     * @param nombre Nombre del empleado.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Devuelve el nombre del empleado.
     * 
     * @return String.
     */
    public String getApellidos() {
        return apellidos;
    }

    /**
     * Establece los apellidos del empleado.
     * 
     * @param apellidos Apellidos del empleado.
     */
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    /**
     * Devuelve el código del argo que ocupa el empleado.
     * 
     * @return int.
     */
    public int getCodCargo() {
        return codCargo;
    }

    /**
     * Establece el código del argo que ocupa el empleado.
     * 
     * @param codCargo Código del argo que ocupa el empleado.
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
        int hash = 5;
        hash = 53 * hash + this.codigo;
        hash = 53 * hash + this.codCiudad;
        hash = 53 * hash + this.codCargo;
        hash = 53 * hash + Objects.hashCode(this.nombre);
        hash = 53 * hash + Objects.hashCode(this.apellidos);
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
        final Empleado other = (Empleado) obj;
        if (this.codigo != other.codigo) {
            return false;
        }
        if (this.codCiudad != other.codCiudad) {
            return false;
        }
        if (this.codCargo != other.codCargo) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.apellidos, other.apellidos)) {
            return false;
        }
        return true;
    }

}
