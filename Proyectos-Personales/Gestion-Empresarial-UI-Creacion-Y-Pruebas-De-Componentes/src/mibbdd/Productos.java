package mibbdd;

import java.util.ArrayList;

/**
 * Lista de productos.
 */

public class Productos {
    ArrayList<Producto> listaProductos;

    /**
     * Constructor.
     */
    public Productos() {
        this.listaProductos = new ArrayList<Producto>();
    }

    /**
     * Devuelve la lista de productos.
     * 
     * @return ArrayList<Producto>
     */
    public ArrayList<Producto> getListaProductos() {
        return listaProductos;
    }

    /**
     * Establece la lista de productos.
     * 
     * @param listaProductos Lista de productos.
     */
    public void setListaProductos(ArrayList<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }

    /**
     * Añade un producto a la lista de productos.
     * 
     * @param p Producto.
     */
    public void aniadeProducto(Producto p) {
        this.listaProductos.add(p);
    }

    /**
     * Devuelve el número de productos que hay en la lista.
     * 
     * @return int.
     */
    public int getNumProductos() {
        return this.listaProductos.size();
    }

    /**
     * Devuelve el product que ocupa una posición en la lista de productos.
     * 
     * @param pos Posición del producto.
     * @return Producto.
     */
    public Producto getProduPos(int pos) {
        return this.listaProductos.get(pos);
    }

    /**
     * Devuelve el producto que tiene un código.
     * 
     * @param codigo Código del producto.
     * @return Producto. Devuelve null si no encuentra el producto.
     */
    public Producto getProductos(int codigo) {
        Producto resul = null;
        Boolean enc = false;
        if (this.listaProductos != null) {
            int n = this.listaProductos.size();
            int pos = 0;
            while ((!enc) && (pos < n)) {
                resul = this.listaProductos.get(pos);
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
     * Devuelve la posición que ocupa un productoa partir de su código.
     * 
     * @param codigo Código del producto.
     * @return int. Si no encuentra el producto, devuelve -1.
     */
    public int getPos(int codigo) {
        int resul = -1;
        Boolean enc = false;
        if (this.listaProductos != null) {
            int n = this.listaProductos.size();
            resul = 0;
            while ((!enc) && (resul < n)) {
                if (this.listaProductos.get(resul).getCodigo() == codigo)
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
     * Devuelve una lista de productos de una categoría concreta.
     * 
     * @param codigo Código de la categoría.
     * @return Productos.
     */
    public Productos getProdCat(int codigo) {
        Productos listaResul = new Productos();
        if (this.listaProductos != null) {
            int n = this.listaProductos.size();
            for (int pos = 0; pos < n; pos++) {
                if (this.listaProductos.get(pos).getCodCateg() == codigo)
                    listaResul.aniadeProducto(this.listaProductos.get(pos));
            }
        }
        return listaResul;
    }

    /**
     * Devuelve los productos de una categoróa que no están suspendidos.
     * 
     * @param codigo Código de la categoría.
     * @return Productos.
     */
    public Productos getProdCatActiv(int codigo) {
        Productos listaResul = new Productos();
        if (this.listaProductos != null) {
            int n = this.listaProductos.size();
            for (int pos = 0; pos < n; pos++) {
                if ((this.listaProductos.get(pos).getCodCateg() == codigo)
                        && (!this.listaProductos.get(pos).getSuspendido()))
                    listaResul.aniadeProducto(this.listaProductos.get(pos));
            }
        }
        return listaResul;
    }

    /**
     * Devuelve Productos suministrados por un proveedor.
     * 
     * @param codigo Código del proveedor.
     * @return Productos
     */
    public Productos getProdProv(int codigo) {
        Productos listaResul = new Productos();
        if (this.listaProductos != null) {
            int n = this.listaProductos.size();
            for (int pos = 0; pos < n; pos++) {
                if (this.listaProductos.get(pos).getCodProv() == codigo)
                    listaResul.aniadeProducto(this.listaProductos.get(pos));
            }
        }
        return listaResul;
    }

    /**
     * Devuelve Productos en cuyo nombre aparezca una palabra.
     * No distingue entre mayúsculas y minúsculas.
     * 
     * @param palabra Palabra buscada.
     * @return Produtos
     */
    public Productos getProdLike(String palabra) {
        Productos listaResul = new Productos();
        palabra = palabra.toLowerCase();
        if (this.listaProductos != null) {
            int n = this.listaProductos.size();
            for (int pos = 0; pos < n; pos++) {
                if (this.listaProductos.get(pos).getNombre().toLowerCase().indexOf(palabra) != -1)
                    listaResul.aniadeProducto(this.listaProductos.get(pos));
            }
        }
        return listaResul;
    }

    /**
     * Devuelve Productos suministrados por un proveedor que no están suspendidos.
     * 
     * @param codigo Código del proveedor.
     * @return Productos.
     */
    public Productos getProdProvActiv(int codigo) {
        Productos listaResul = new Productos();
        if (this.listaProductos != null) {
            int n = this.listaProductos.size();
            for (int pos = 0; pos < n; pos++) {
                if ((this.listaProductos.get(pos).getCodProv() == codigo)
                        && (!this.listaProductos.get(pos).getSuspendido()))
                    listaResul.aniadeProducto(this.listaProductos.get(pos));
            }
        }
        return listaResul;
    }

    /**
     * Devuelve Productos suspendidos.
     * 
     * @return Productos.
     */
    public Productos getProdSuspendidos() {
        Productos listaResul = new Productos();
        if (this.listaProductos != null) {
            int n = this.listaProductos.size();
            for (int pos = 0; pos < n; pos++) {
                if (this.listaProductos.get(pos).getSuspendido())
                    listaResul.aniadeProducto(this.listaProductos.get(pos));
            }
        }
        return listaResul;
    }

    /**
     * Devuelve Productos que no están suspendidos.
     * 
     * @return Productos.
     */
    public Productos getProdActivos() {
        Productos listaResul = new Productos();
        if (this.listaProductos != null) {
            int n = this.listaProductos.size();
            for (int pos = 0; pos < n; pos++) {
                if (!this.listaProductos.get(pos).getSuspendido())
                    listaResul.aniadeProducto(this.listaProductos.get(pos));
            }
        }
        return listaResul;
    }

    /**
     * Devuelve la lista de los produtos fabricandos por un fabricante.
     * 
     * @param codFabri Código del fabriante.
     * @return Productos.
     */
    public Productos getProdFabricante(int codFabri) {
        Productos listaResul = new Productos();
        if (this.listaProductos != null) {
            int n = this.listaProductos.size();
            for (int pos = 0; pos < n; pos++) {
                if (this.listaProductos.get(pos).codFab == codFabri)
                    listaResul.aniadeProducto(this.listaProductos.get(pos));
            }
        }
        return listaResul;
    }

    /**
     * Devuelve la lista de los produtos activos fabricandos por un fabricante.
     * 
     * @param codFabri Código del fabriante.
     * @return Productos.
     */
    public Productos getProdActFabri(int codFabri) {
        Productos listaResul = new Productos();
        if (this.listaProductos != null) {
            int n = this.listaProductos.size();
            for (int pos = 0; pos < n; pos++) {
                if ((this.listaProductos.get(pos).codFab == codFabri)
                        && (!this.listaProductos.get(pos).getSuspendido()))
                    aniadeProducto(this.listaProductos.get(pos));
            }
        }
        return listaResul;
    }

}
