package mibbdd;

import java.util.ArrayList;

/**
 * Es una lista de clientes.
 */

public class Clientes {
    private ArrayList<Cliente> listaClientes;

    /**
     * Constructor.
     */
    public Clientes() {
        this.listaClientes = new ArrayList<>();
    }

    /**
     * Devuelve el cliente que ocupa una posicón en la lista.
     * 
     * @param pos Posición del cliente.
     * @return Cliente.
     */
    public Cliente getClientePos(int pos) {
        return this.listaClientes.get(pos);
    }

    /**
     * Devuelve la lista de clientes.
     * 
     * @return ArrayList<Cliente>.
     */
    public ArrayList<Cliente> getListaClientes() {
        return listaClientes;
    }

    /**
     * establece la lista de clientes.
     * 
     * @param listaClientes Lista de clientes.
     */
    public void setListaClientes(ArrayList<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }

    /**
     * Añade un cliente a la lista de clientes.
     * 
     * @param c Cliente.
     */
    public void aniadeCliente(Cliente c) {
        this.listaClientes.add(c);
    }

    /**
     * Devuelve un cliente a través de su identificador
     * 
     * @param id Identificador del cliente.
     * @return Cliente. Si no encuentra al cliente, devolverá null.
     */
    public Cliente getCliente(String id) {
        Cliente resul = null;
        Boolean enc = false;
        if (this.listaClientes != null) {
            int n = this.listaClientes.size();
            int pos = 0;
            while ((!enc) && (pos < n)) {
                resul = this.listaClientes.get(pos);
                if (resul.getIdCliente().equals(id))
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
     * Devuelve la posición que ocupa un cliente. La búsqued a se hace a través de
     * su identificador.
     * 
     * @param id
     * @return int. Si no lo encuentra, devuelve -1.
     */
    public int getPos(String id) {
        int resul = -1;
        Boolean enc = false;
        if (this.listaClientes != null) {
            int n = this.listaClientes.size();
            resul = 0;
            while ((!enc) && (resul < n)) {
                if (this.listaClientes.get(resul).getIdCliente().equals(id))
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
     * Devuelve un cliente a través del nombre de compañía
     * 
     * @param nomComp Nombre de la compañía cliente.
     * @return Cliente. Si no encuentra al cliente, devolverá null.
     */
    public Cliente getClienteComp(String nomComp) {
        Cliente resul = null;
        Boolean enc = false;
        if (this.listaClientes != null) {
            int n = this.listaClientes.size();
            int pos = 0;
            while ((!enc) && (pos < n)) {
                resul = this.listaClientes.get(pos);
                if (resul.getNomCompania().equals(nomComp))
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
     * Devuelve los Clientes en cuyo nombre de contacto aparezca el nombre que se le
     * pasa como parámetro
     * 
     * @param nom Nombre del contacto.
     * @return Clientes.
     */
    public Clientes getClientesNomCont(String nom) {
        Clientes listaResul = new Clientes();
        nom = nom.toLowerCase();
        if (this.listaClientes != null) {
            int n = this.listaClientes.size();
            for (int pos = 0; pos < n; pos++) {
                if (this.listaClientes.get(pos).getNomContacto().toLowerCase().contains(nom))
                    listaResul.aniadeCliente(this.listaClientes.get(pos));
            }
        }
        return listaResul;
    }

    /**
     * Devuelve los clientes que ocupan un cargo determinado
     * 
     * @param codigo Código del cargo que ocupa el contacto del cliente.
     * @return Clientes
     */
    public Clientes getClientesCargo(int codigo) {
        Clientes listaResul = new Clientes();
        if (this.listaClientes != null) {
            int n = this.listaClientes.size();
            for (int pos = 0; pos < n; pos++) {
                if (this.listaClientes.get(pos).getCodCargo() == codigo)
                    aniadeCliente(this.listaClientes.get(pos));
            }
        }
        return listaResul;
    }

    private void busca(Clientes listaResul, int codigo) {
        if (this.listaClientes != null) {
            int n = this.listaClientes.size();
            for (int pos = 0; pos < n; pos++) {
                if (this.listaClientes.get(pos).getCodCiudad() == codigo)
                    listaResul.aniadeCliente(this.listaClientes.get(pos));
            }
        }
    }

    /**
     * Devuelve los clientes que residen en una ciudad.
     * 
     * @param codigo Código de la ciudad en la que reside el cliente.
     * @return Clientes
     */
    public Clientes getClientesCiudad(int codigo) {
        Clientes listaResul = new Clientes();
        this.busca(listaResul, codigo);
        return listaResul;
    }

    /**
     * Devuelve los Clientes de un pais.
     * 
     * @param codPais  Código del país.
     * @param ciudades Lista de ciudades.
     * @return Clientes
     */
    public Clientes getClientesPais(int codPais, Ciudades ciudades) {
        Clientes listaResul = new Clientes();
        Ciudades ciu = ciudades.getCiudadesPais(codPais);
        int n = ciu.getNumCiudades();
        if (n > 0) {
            for (int pos = 0; pos < n; pos++) {
                this.busca(listaResul, ciu.getCiudadPos(pos).getCodPais());
            }
        }
        return listaResul;
    }

}
