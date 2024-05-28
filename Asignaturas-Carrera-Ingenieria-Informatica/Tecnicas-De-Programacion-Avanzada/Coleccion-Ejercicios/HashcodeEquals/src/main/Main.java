package main;

public class Main {
    public static void main(String[] args) {

        // == -> es una comparación de referencia, es decir, ambos objetos apuntan a la
        // misma ubicación de memoria
        // .equals() -> evalúa la comparación de valores en los objetos

        String s1 = "HELLO";
        String s2 = "HELLO"; // String constant pool
        String s3 = new String("HELLO");
        String s4 = s1;

        System.out.println("s1 == s2, is \t" + (s1 == s2)); // true
        System.out.println("s1 == s3, is \t" + (s1 == s3)); // false
        System.out.println("s1 == s4, is \t" + (s1 == s4)); // true

        System.out.println("\ns1 equals s2, is " + (s1.equals(s2))); // true
        System.out.println("s1 equals s3, is " + (s1.equals(s3))); // true
        System.out.println("s1 equals s4, is " + (s1.equals(s4))); // true

        System.out.println("\nAdress s1: " + System.identityHashCode(s1)); // 1784662007
        System.out.println("Adress s2: " + System.identityHashCode(s2)); // 1784662007
        System.out.println("Adress s3: " + System.identityHashCode(s3)); // 997110508
        System.out.println("Adress s4: " + System.identityHashCode(s4)); // 1784662007

        int a = 5;
        int b = 5;
        int c = a;

        System.out.println("\na == b, is \t" + (a == b)); // true
        System.out.println("a == c, is \t" + (a == c)); // true
        // System.out.println(a.equals(b)); ERROR: can not invoke that method for
        // primitive types

        System.out.println("\nAdress a: " + System.identityHashCode(a)); // 509886383
        System.out.println("Adress b: " + System.identityHashCode(b)); // 509886383
        System.out.println("Adress c: " + System.identityHashCode(c)); // 509886383

        Integer d = 5;
        Integer e = 5; // Integer constant pool
        Integer f = new Integer(5); // deprecated
        Integer g = d;

        System.out.println("\nd == e, is \t" + (d == e)); // true
        System.out.println("d == f, is \t" + (d == f)); // false
        System.out.println("d == g, is \t" + (d == g)); // true

        System.out.println("\nd equals e, is \t" + (d.equals(e))); // true
        System.out.println("d equals f, is \t" + (d.equals(f))); // true
        System.out.println("d equals g, is \t" + (d.equals(g))); // true

        System.out.println("\nAdress d: " + System.identityHashCode(d)); // 509886383
        System.out.println("Adress e: " + System.identityHashCode(e)); // 509886383
        System.out.println("Adress f: " + System.identityHashCode(f)); // 1854778591
        System.out.println("Adress g: " + System.identityHashCode(g)); // 509886383
    }
}
