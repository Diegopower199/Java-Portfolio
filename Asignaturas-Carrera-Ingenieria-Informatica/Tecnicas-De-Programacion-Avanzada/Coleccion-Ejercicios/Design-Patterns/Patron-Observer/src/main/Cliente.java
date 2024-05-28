package main;

import java.util.Date;
import java.util.Observable;
import java.util.Observer;

public class Cliente implements Observer {

    private String vodigo;
    private String nombre;
    private String apellidos;
    private String email;
    private Date fechaNacimiento;

    public Cliente() {
        super();
    }

    public String getVodigo() {
        return vodigo;
    }

    public void setVodigo(String vodigo) {
        this.vodigo = vodigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    @Override
    public void update(Observable o, Object arg) {
        if (((String) arg).equals("stock")) {
            System.out.println("El cliente ha sido notificado de un cambio en el stock...");
        }
    }

}
