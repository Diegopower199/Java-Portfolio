package main;

public class Empleado {

    private String nombre;
    private String apellidos;
    private String dni;
    private int salario;
    private int edad;

    public Empleado(String nombre, String apellidos, String dni, int salario, int edad) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
        this.salario = salario;
        this.edad = edad;
    }

    public Empleado() {
        this("", "", "", 0, 0);
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setSalario(int salario) {
        this.salario = salario;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getDni() {
        return dni;
    }

    public int getSalario() {
        return salario;
    }

    public int getEdad() {
        return edad;
    }

    public String print() {
        return nombre + " - " + apellidos + " - " + dni + " - " + salario + " - " + edad;
    }
}
