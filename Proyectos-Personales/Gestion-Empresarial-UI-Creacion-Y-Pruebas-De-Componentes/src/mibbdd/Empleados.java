package mibbdd;

import java.util.ArrayList;

/**
 * Lista de empleados encargados de tramitar pedidos.
 */

public class Empleados {
    private ArrayList<Empleado> listaEmpleados;

    /**
     * Constructor
     */
    public Empleados() {
        listaEmpleados = new ArrayList<>();
        listaEmpleados = Cargar.Empleados();
    }

    /**
     * Devuelve el empleado que ocupa una psoción en la lista de empleados.
     * 
     * @param pos Posición del empleado en la lista.
     * @return Empleado.
     */
    public Empleado getEmpleadoPos(int pos) {
        return this.listaEmpleados.get(pos);
    }

    /**
     * Añade un empleado a la lista de empleados.
     * 
     * @param e Empleado.
     */
    public void AniadeEmpleado(Empleado e) {
        this.listaEmpleados.add(e);
    }

    /**
     * devuelve la lista de empleados.
     * 
     * @return ArrayList<Empleado>.
     */
    public ArrayList<Empleado> getListaEmpleados() {
        return listaEmpleados;
    }

    /**
     * Establece la lista de empleados.
     * 
     * @param listaEmpleados Lista de empleados.
     */
    public void setListaEmpleados(ArrayList<Empleado> listaEmpleados) {
        this.listaEmpleados = listaEmpleados;
    }

    /**
     * Devuelve un empleado a partir de su código.
     * 
     * @param codigo Código del empleado
     * @return Empleado. Devolverá null si no encuentra el empleado..
     */
    public Empleado getEmpleado(int codigo) {
        Empleado resul = null;
        Boolean enc = false;
        if (this.listaEmpleados != null) {
            int n = this.listaEmpleados.size();
            int pos = 0;
            while ((!enc) && (pos < n)) {
                resul = this.listaEmpleados.get(pos);
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
     * Devuelve los Empleados que ocupan un cargo.
     * 
     * @param codigo Código del cargo.
     * @return Empleados
     */
    public Empleados getEmplCargo(int codigo) {
        Empleados listaResul = new Empleados();
        if (this.listaEmpleados != null) {
            int n = this.listaEmpleados.size();
            for (int pos = 0; pos < n; pos++) {
                if (this.listaEmpleados.get(pos).getCodigo() == codigo)
                    listaResul.AniadeEmpleado(this.listaEmpleados.get(pos));
            }
        }
        return listaResul;
    }

    /**
     * Duvelve los Empleados de una ciudad.
     * 
     * @param codigo Código de una ciudad.
     * @return Empleados
     */
    public Empleados getEmplCiu(int codigo) {
        Empleados listaResul = new Empleados();
        if (this.listaEmpleados != null) {
            int n = this.listaEmpleados.size();
            for (int pos = 0; pos < n; pos++) {
                if (this.listaEmpleados.get(pos).getCodCiudad() == codigo)
                    listaResul.AniadeEmpleado(this.listaEmpleados.get(pos));
            }
        }
        return listaResul;
    }

    /**
     * Devuelve los Empleados de un pais.
     * 
     * @param codPais Código del país.
     * @param c       Lista de ciudades.
     * @return Empleados.
     */
    public Empleados getEmplPais(int codPais, Ciudades c) {
        Empleados listaResul = new Empleados();
        Ciudades misCiudades = c.getCiudadesPais(codPais);
        int numCiu = misCiudades.getNumCiudades();
        if ((this.listaEmpleados != null) && (numCiu > 0)) {
            int n;
            int codCiu;
            for (int a = 0; a < numCiu; a++) {
                codCiu = misCiudades.getCiudadPos(a).getCodigo();
                n = this.listaEmpleados.size();
                for (int pos = 0; pos < n; pos++) {
                    if (this.listaEmpleados.get(pos).getCodCiudad() == codCiu)
                        listaResul.AniadeEmpleado(this.listaEmpleados.get(pos));
                }
            }
        }
        return listaResul;
    }

}
