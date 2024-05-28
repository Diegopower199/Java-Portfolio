package main;

public class Main {

    public static void main(String[] args) {
        Empleado emp1 = new Empleado();

        emp1.setNombre("Javier");
        emp1.setApellidos("Perez Gomez");
        emp1.setDni("4747464L");
        emp1.setSalario(1200);
        emp1.setEdad(23);

        System.out.println(emp1.getNombre());
        System.out.println(emp1.getApellidos());
        System.out.println(emp1.getDni());
        System.out.println(emp1.getSalario());
        System.out.println(emp1.getEdad());

        System.out.println(emp1.print());
    }
}
