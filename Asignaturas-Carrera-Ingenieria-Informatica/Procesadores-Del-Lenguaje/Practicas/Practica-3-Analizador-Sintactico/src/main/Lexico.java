package main;

import java.util.Hashtable;

public class Lexico {

    private Hashtable<String, String> palabrasReservadas;
    private int posicion;
    private int lineas;
    private char caracter;
    private String programa;

    public Lexico(String programa) {
        this.posicion = 0;
        this.lineas = 1;

        this.palabrasReservadas = new Hashtable<String, String>();

        this.palabrasReservadas.put("break", "break");
        this.palabrasReservadas.put("do", "do");
        this.palabrasReservadas.put("else", "else");
        this.palabrasReservadas.put("float", "float");
        this.palabrasReservadas.put("for", "for");
        this.palabrasReservadas.put("if", "if");
        this.palabrasReservadas.put("int", "int");
        this.palabrasReservadas.put("while", "while");

        this.programa = programa + (char) (0);
    }

    private char extraeCaracter() {
        return this.programa.charAt(this.posicion++);
    }

    private void devuelveCaracter() {
        this.posicion--;
    }

    @SuppressWarnings("unused")
    private boolean extraeCaracter(char c) {
        if (this.posicion < this.programa.length() - 1) {
            this.caracter = extraeCaracter();

            if (c == this.caracter)
                return true;
            else {
                devuelveCaracter();

                return false;
            }
        } else
            return false;
    }

    public int getLineas() {
        return this.lineas;
    }

    public ComponenteLexico getComponenteLexico() {

        while (true) {
            this.caracter = extraeCaracter();

            if (this.caracter == 0)
                return new ComponenteLexico("end_program");
            else if (this.caracter == ' ' || (int) this.caracter == 9 || (int) this.caracter == 13)
                continue;
            else if ((int) this.caracter == 10)
                this.lineas++;
            else
                break;
        }

        if (Character.isDigit(this.caracter)) {
            String numero = "";

            do {
                numero = numero + this.caracter;

                this.caracter = extraeCaracter();
            } while (Character.isDigit(this.caracter));

            if (this.caracter != '.') {
                devuelveCaracter();

                return new ComponenteLexico("int", numero);
            }

            do {
                numero = numero + this.caracter;

                this.caracter = extraeCaracter();
            } while (Character.isDigit(this.caracter));

            devuelveCaracter();
            return new ComponenteLexico("float", numero);
        }

        if (Character.isLetter(this.caracter)) {
            String lexema = "";

            do {

                lexema = lexema + this.caracter;
                this.caracter = extraeCaracter();
            } while (Character.isLetterOrDigit(this.caracter));

            devuelveCaracter();

            if (this.palabrasReservadas.containsKey(lexema))
                return new ComponenteLexico((String) this.palabrasReservadas.get(lexema));
            else
                return new ComponenteLexico("id", lexema);
        }

        switch (this.caracter) {
            case '=':
                return new ComponenteLexico("assignment");
            case '<':
                return new ComponenteLexico("less_than");
            case '>':
                return new ComponenteLexico("greater_than");
            case '+':
                return new ComponenteLexico("add");
            case '-':
                return new ComponenteLexico("subtract");
            case '*':
                return new ComponenteLexico("multiply");
            case '/':
                return new ComponenteLexico("divide");
            case '%':
                return new ComponenteLexico("remainder");
            case ';':
                return new ComponenteLexico("semicolon");
            case '(':
                return new ComponenteLexico("open_parenthesis");
            case ')':
                return new ComponenteLexico("closed_parenthesis");
            case '{':
                return new ComponenteLexico("open_bracket");
            case '}':
                return new ComponenteLexico("closed_bracket");
            case '[':
                return new ComponenteLexico("open_square_bracket");
            case ']':
                return new ComponenteLexico("closed_square_bracket");
            default:
                return new ComponenteLexico("invalid_char");
        }
    }
}
