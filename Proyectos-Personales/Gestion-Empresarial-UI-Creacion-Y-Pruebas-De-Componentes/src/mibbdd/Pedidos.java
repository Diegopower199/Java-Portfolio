package mibbdd;

import java.util.ArrayList;

/**
 * Lista de pedidos.
 */

public class Pedidos {
    private ArrayList<Pedido> listaPedidos;

    /**
     * Constructor.
     */
    public Pedidos() {
        this.listaPedidos = new ArrayList<>();
    }

    /**
     * Devuelve la lista de pedidos.
     * 
     * @return ArrayList<Pedido>
     */
    public ArrayList<Pedido> getListaPedidos() {
        return listaPedidos;
    }

    /**
     * edstablece la lista de pedidos.
     * 
     * @param listaPedidos Lista de pedidos.
     */
    public void setListaPedidos(ArrayList<Pedido> listaPedidos) {
        this.listaPedidos = listaPedidos;
    }

    /**
     * Añade un pedido a la lista.
     * 
     * @param p Pedido.
     */
    public void aniadePedido(Pedido p) {
        this.listaPedidos.add(p);
    }

    /**
     * Devuelve el número de pedidos de la lista.
     * 
     * @return int.
     */
    public int getNumPedidos() {
        return this.listaPedidos.size();
    }

    /**
     * Devuelve el pedido que ocupa una posición determinada.
     * 
     * @param pos Posición del pedido.
     * @return Pedido.
     */
    public Pedido getPedidoPos(int pos) {
        return this.listaPedidos.get(pos);
    }

    /**
     * Devuelve un Pedido a partir de su código.
     * 
     * @param codigo Código del pedido.
     * @return Pedido. Si el pedido no existe, devuelve null.
     */
    public Pedido getPedido(int codigo) {
        Pedido resul = null;
        Boolean enc = false;
        if (this.listaPedidos != null) {
            int n = this.listaPedidos.size();
            int pos = 0;
            while ((!enc) && (pos < n)) {
                resul = this.listaPedidos.get(pos);
                if (resul.getCodigo() == codigo)
                    enc = true;
                else
                    pos++;
            }
        }
        if (enc)
            return resul;
        else
            return null;
    }

    /**
     * Devuelve la posición que ocupa un pedido con un código concreto.
     * 
     * @param codigo Código dle pedido.
     * @return int. Devuelve -1 si no encuentra el pedido.
     */
    public int getPos(int codigo) {
        int resul = -1;
        Boolean enc = false;
        if (this.listaPedidos != null) {
            int n = this.listaPedidos.size();
            resul = 0;
            while ((!enc) && (resul < n)) {
                if (this.listaPedidos.get(resul).getCodigo() == codigo)
                    enc = true;
                else
                    resul++;
            }
        }
        if (enc)
            return resul;
        else
            return -1;
    }

    /**
     * Devuelve los pedidos de un cliente.
     * 
     * @param idCliente Identificador del cliente.
     * @return Pedidos
     */
    public Pedidos getPedidosCliente(String idCliente) {
        Pedidos resul = new Pedidos();
        Pedido po;
        idCliente = idCliente.toLowerCase();
        int n = this.listaPedidos.size();
        for (int f = 0; f < n; f++) {
            po = this.listaPedidos.get(f);
            if (po.getIdCliente().toLowerCase().equals(idCliente))
                resul.aniadePedido(po);
        }
        return resul;
    }

    /**
     * Devuelve los pedidos gestionados por un empleado.
     * 
     * @param codEmpl Código del empleado.
     * @return Pedidos
     */
    public Pedidos getPedidosEmpleado(int codEmpl) {
        Pedidos resul = new Pedidos();
        int n = this.listaPedidos.size();
        for (int f = 0; f < n; f++) {
            if (this.listaPedidos.get(f).getCodEmpleado() == codEmpl)
                resul.aniadePedido(this.listaPedidos.get(f));
        }
        return resul;
    }

    /**
     * Devuelve los pedidos que han sido enviados por una empresa (compañía) de
     * envíos
     * 
     * @param codEmpEnv Código de la empresa (compañía) de envíos.
     * @return Pedidos
     */
    public Pedidos getPedidosEmprEnvio(int codEmpEnv) {
        Pedidos resul = new Pedidos();
        int n = this.listaPedidos.size();
        for (int f = 0; f < n; f++) {
            if (this.listaPedidos.get(f).getCodEmprEnvio() == codEmpEnv)
                resul.aniadePedido(this.listaPedidos.get(f));
        }
        return resul;
    }

    /**
     * Devuelve los pedidos enviados a una ciudad.
     * 
     * @param codCiudad Código de la ciudad.
     * @return Pedidos
     */
    public Pedidos getPedidosCiudad(int codCiudad) {
        Pedidos resul = new Pedidos();
        int n = this.listaPedidos.size();
        for (int f = 0; f < n; f++) {
            if (this.listaPedidos.get(f).getCodCiudad() == codCiudad)
                resul.aniadePedido(this.listaPedidos.get(f));
        }
        return resul;
    }

}
