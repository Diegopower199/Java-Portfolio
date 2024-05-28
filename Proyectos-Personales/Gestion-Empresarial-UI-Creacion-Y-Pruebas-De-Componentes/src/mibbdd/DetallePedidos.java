package mibbdd;

import java.util.ArrayList;

/**
 * Lista de los productos junto a su cantidad y precio de cada uno de los
 * pedidos.
 */

public class DetallePedidos {
    private ArrayList<DetPedido> listaDetallePedidos;

    /**
     * Constructor.
     */
    public DetallePedidos() {
        listaDetallePedidos = new ArrayList<DetPedido>();
    }

    /**
     * Devuelve el detalle de un pedido que ocupa una posición en la lista.
     * 
     * @param pos Posición del detalle del pedido.
     * @return DetPedido.
     */
    public DetPedido getDetallePedidosPos(int pos) {
        return this.listaDetallePedidos.get(pos);
    }

    /**
     * Constructor
     * 
     * @param listaDetallePedidos Lista de detalles de pedidos.
     */
    public DetallePedidos(ArrayList<DetPedido> listaDetallePedidos) {
        this.listaDetallePedidos = listaDetallePedidos;
    }

    /**
     * Añade un detalle de pedido a la lista.
     * 
     * @param dp Detalle de pedido.
     */
    public void aniadeDetPedido(DetPedido dp) {
        this.listaDetallePedidos.add(dp);
    }

    /**
     * Devuelve la lista de detalles de pedidos.
     * 
     * @return ArrayList<DetPedido>.
     */
    public ArrayList<DetPedido> getListaDetallePedidos() {
        return listaDetallePedidos;
    }

    /**
     * Establece la lista de detalles de pedidos.
     * 
     * @param listaDetallePedidos Lista de pedidos.
     */
    public void setListaDetallePedidos(ArrayList<DetPedido> listaDetallePedidos) {
        this.listaDetallePedidos = listaDetallePedidos;
    }

    /**
     * Devuelve el DetPedido con un codPedido y codProducto determinado.
     * 
     * @param codPedido   Código del pedido.
     * @param codProducto Código del producto.
     * @return DetPedido. Si la lista de detalles de pedido es null, devolverá null.
     */
    public DetPedido getDetPedido(int codPedido, int codProducto) {
        DetPedido dp = null;
        if (listaDetallePedidos != null) {
            int n = listaDetallePedidos.size();
            Boolean enc = false;
            int pos = 0;
            do {
                dp = listaDetallePedidos.get(pos);
                if ((dp.getCodPedido() == codPedido) && (dp.getCodProducto() == codProducto))
                    enc = true;
                else
                    pos++;
            } while ((!enc) && (pos < n));
            if (!enc)
                dp = null;
        }
        return dp;
    }

    /**
     * Devuelve los detalles de pedido de un pedido cuyo código se pasa como
     * parámetro.
     * 
     * @param codPedido Código del pedido.
     * @return DetallePedidos
     */
    public DetallePedidos getProductosPedido(int codPedido) {
        DetallePedidos listaResul = new DetallePedidos();
        if (this.listaDetallePedidos != null) {
            int n = this.listaDetallePedidos.size();
            for (int pos = 0; pos < n; pos++) {
                if (this.listaDetallePedidos.get(pos).getCodPedido() == codPedido)
                    listaResul.aniadeDetPedido(this.listaDetallePedidos.get(pos));
            }
        }
        return listaResul;
    }

    /**
     * Devuelve los detalles de pedido que contengan un producto concreto. (
     * 
     * @param codProducto Código del prodcuto.
     * @return DetallePedidos
     */
    public DetallePedidos getPedidosProducto(int codProducto) {
        DetallePedidos listaResul = new DetallePedidos();
        if (this.listaDetallePedidos != null) {
            int n = this.listaDetallePedidos.size();
            for (int pos = 0; pos < n; pos++) {
                if (this.listaDetallePedidos.get(pos).getCodProducto() == codProducto)
                    listaResul.aniadeDetPedido(this.listaDetallePedidos.get(pos));
            }
        }
        return listaResul;
    }

}
