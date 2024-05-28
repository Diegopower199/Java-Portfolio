package mibbdd;

/**
 * Esta clase contiene información de un producto de un pedido. Un pedido está
 * compuesto por uno o varios productos. El detalle del pedido son los productor
 * asociados a un producto.
 */

public class DetPedido {
    private int codPedido;
    private int codProducto;
    private float precioUnidad;
    private int cantidad;

    /**
     * Constructor.
     * 
     * @param codPedido    Código del pedido del detalle del pedido.
     * @param codProducto  Código dle producto del detalle del pedido.
     * @param precioUnidad Precio unitario del producto del detalle del pedido.
     * @param cantidad     Cantidad del producto del detalle del pedido.
     */
    public DetPedido(int codPedido, int codProducto, float precioUnidad, int cantidad) {
        this.codPedido = codPedido;
        this.codProducto = codProducto;
        this.precioUnidad = precioUnidad;
        this.cantidad = cantidad;
    }

    /**
     * Devuelve el código del detalle del pedido.
     * 
     * @return int.
     */
    public int getCodPedido() {
        return codPedido;
    }

    /**
     * Establece el código del detalle del pedido.
     * 
     * @param codPedido Código del detalle del pedido.
     */
    public void setCodPedido(int codPedido) {
        this.codPedido = codPedido;
    }

    /**
     * Devuelve el código del producto del detalle del pedido.
     * 
     * @return int.
     */
    public int getCodProducto() {
        return codProducto;
    }

    /**
     * Establece el código del producto del detalle del pedido.
     * 
     * @param codProducto Código del producto del detalle del pedido.
     */
    public void setCodProducto(int codProducto) {
        this.codProducto = codProducto;
    }

    /**
     * Devuelve el precio unitario del producto del detalle del pedido.
     * 
     * @return float.
     */
    public float getPrecioUnidad() {
        return precioUnidad;
    }

    /**
     * Establece el precio unitario del detalle del pedido.
     * 
     * @param PrecioUnidad Precio unitario del detalle del pedido.
     */
    public void setPrecioUnidad(float PrecioUnidad) {
        this.precioUnidad = PrecioUnidad;
    }

    /**
     * Devuelve la cantidad del producto del detalle del pedido.
     * 
     * @return int.
     */
    public int getCantidad() {
        return cantidad;
    }

    /**
     * Establece la cantidad del detalle del pedido.
     * 
     * @param cantidad Cantidad del detalle del pedido.
     */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * Devuelve la función hash.
     * 
     * @return Un int.
     */

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 47 * hash + this.codPedido;
        hash = 47 * hash + this.codProducto;
        hash = 47 * hash + Float.floatToIntBits(this.precioUnidad);
        hash = 47 * hash + this.cantidad;
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
        final DetPedido other = (DetPedido) obj;
        if (this.codPedido != other.codPedido) {
            return false;
        }
        if (this.codProducto != other.codProducto) {
            return false;
        }
        if (Float.floatToIntBits(this.precioUnidad) != Float.floatToIntBits(other.precioUnidad)) {
            return false;
        }
        if (this.cantidad != other.cantidad) {
            return false;
        }
        return true;
    }

}
