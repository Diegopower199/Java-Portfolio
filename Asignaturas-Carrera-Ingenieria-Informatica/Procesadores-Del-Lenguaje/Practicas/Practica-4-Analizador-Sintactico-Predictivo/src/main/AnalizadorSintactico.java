package main;

import java.util.Hashtable;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class AnalizadorSintactico {
    private ComponenteLexico componenteLexico;

    private Identificador identificador;

    private Lexico lexico;
    private Hashtable<String, TipoDato> simbolos;
    private String postfijo;
    private Stack<Integer> pila;

    public AnalizadorSintactico(Lexico lexico) {
        this.simbolos = new Hashtable<String, TipoDato>();
        this.lexico = lexico;
        this.componenteLexico = this.lexico.getComponenteLexico();
        this.identificador = null;
        this.pila = new Stack<Integer>();
        this.postfijo = "";
    }

    private void compara(String etiqueta) {
        this.identificador = new Identificador(etiqueta);

        if (this.identificador.getLexema().equals(etiqueta)) {
            this.componenteLexico = this.lexico.getComponenteLexico();
            tipo();

        } else {
            System.out.println("Error, se esperaba " + etiqueta);
        }
    }

    public String tablaSimbolos() {
        String simbolos = "";
        Set<Map.Entry<String, TipoDato>> s = this.simbolos.entrySet();

        for (Map.Entry<String, TipoDato> m : s)
            simbolos = simbolos + "<'" + m.getKey() + "', " + m.getValue().toString() + "> \n";

        return simbolos;
    }

    public void programa() {
        compara("void");
        compara("main");
        compara("open_bracket");

        declaracion();
        declaraciones();
        instrucciones();

        compara("closed_bracket");
    }

    private void declaraciones() {
        String etiqueta = this.componenteLexico.getEtiqueta();

        if (etiqueta.equals("int") || etiqueta.equals("float") || etiqueta.equals("boolean")) {
            declaracion();
            declaraciones();
        }
    }

    private void declaracion() {
        String tipo = tipo();

        int tamaño = 1;

        if (this.componenteLexico.getEtiqueta().equals("open_square_bracket")) {
            compara("open_square_bracket");
            if (this.componenteLexico.getEtiqueta().equals("int")) {
                NumeroEntero numero = (NumeroEntero) this.componenteLexico;
                tamaño = numero.getValor();

            }
            compara("int");
            compara("closed_square_bracket");

            if (this.componenteLexico.getEtiqueta().equals("id")) {
                Identificador id = (Identificador) this.componenteLexico;
                simbolos.put(id.getLexema(), new TipoArray(tipo, tamaño));
            }
            compara("id");
            compara("semicolon");
        } else {
            identificadores(tipo);
            compara("semicolon");
        }
    }

    public void instrucciones() {
        String etiqueta = this.componenteLexico.getEtiqueta();

        if (etiqueta.equals("id") || etiqueta.equals("if") || etiqueta.equals("while") || etiqueta.equals("do")
                || etiqueta.equals("print") || etiqueta.equals("open_bracket") || etiqueta.equals("open_square_bracket")
                || etiqueta.equals("int") || etiqueta.equals("float") || etiqueta.equals("boolean")) {
            instruccion();

        }
    }

    public void instruccion() {
        String etiqueta = this.componenteLexico.getEtiqueta();

        if (etiqueta.equals("id")) {
            Identificador idComp = (Identificador) this.componenteLexico;

            if (this.simbolos.contains(idComp.getLexema())) {
                variable();
                compara("assignment");
                expresionLogica();
                compara("semicolon");
            } else {
                System.out.println("Error, la variable " + idComp.getLexema() + " no esta declarada");
            }
        } else if (etiqueta.equals("if")) {
            compara("if");
            compara("open_parenthesis");
            expresionLogica();
            compara("closed_parenthesis");
            instruccion();
            if (this.componenteLexico.getEtiqueta().equals("else")) {
                compara("else");
                instruccion();
            }
        } else if (etiqueta.equals("while")) {
            compara("while");
            compara("open_parenthesis");
            expresionLogica();
            compara("closed_parenthesis");
            instruccion();
        } else if (etiqueta.equals("do")) {
            compara("do");
            instruccion();
            compara("while");
            compara("open_parenthesis");
            expresionLogica();
            compara("closed_parenthesis");
            compara("semicolon");
        } else if (etiqueta.equals("print")) {
            compara("print");
            compara("open_parenthesis");
            variable();
            compara("closed_parenthesis");
            compara("semicolon");
        } else if (etiqueta.equals("open_bracket")) {
            compara("open_bracket");
            instrucciones();
            compara("closed_bracket");
        } else if (etiqueta.equals("int") || etiqueta.equals("float") || etiqueta.equals("boolean")) {
            declaracion();
        }
    }

    public void asignacion() {
        if (this.componenteLexico.getEtiqueta().equals("id")) {
            Identificador id1 = (Identificador) this.componenteLexico;

            TipoDato tipo1 = this.simbolos.get(id1.getLexema());

            compara("id");
            compara("assignment");

            Identificador id2 = (Identificador) this.componenteLexico;

            TipoDato tipo2 = this.simbolos.get(id2.getLexema());
            compara("id");

            if (tipo1.getTipo().equals(tipo2.getTipo()))
                System.out
                        .println(id1.getLexema() + " (" + tipo1 + ") vs " + id2.getLexema() + " (" + tipo2 + ") is ok");
            else
                System.out.println(
                        id1.getLexema() + " (" + tipo1 + ") vs " + id2.getLexema() + " (" + tipo2 + ") type mismatch");
        }
    }

    private String tipo() {
        String tipo = this.componenteLexico.getEtiqueta();

        if (tipo.equals("int")) {
            compara("int");
        } else if (tipo.equals("float")) {
            compara("float");
        } else if (tipo.equals("boolean")) {
            compara("boolean");
        } else {
            System.out.println("Error, se esperaba int o float o boolean");
        }

        return tipo;
    }

    private void identificadores(String tipo) {
        if (this.componenteLexico.getEtiqueta().equals("id")) {
            Identificador id = (Identificador) this.componenteLexico;

            simbolos.put(id.getLexema(), new TipoPrimitivo(tipo));

            compara("id");
            asignacionDeclaracion();
            masIdentificadores(tipo);
        }
    }

    private void masIdentificadores(String tipo) {
        if (this.componenteLexico.getEtiqueta().equals("comma")) {
            compara("comma");

            Identificador id = (Identificador) this.componenteLexico;

            simbolos.put(id.getLexema(), new TipoPrimitivo(tipo));

            compara("id");
            masIdentificadores(tipo);
        }
    }

    private void asignacionDeclaracion() {
        if (this.componenteLexico.getEtiqueta().equals("equals")) {
            compara("equals");
            expresionLogica();
        }
    }

    public void expresion() {
        termino();
        masTerminos();
    }

    private void masTerminos() {
        if (this.componenteLexico.getEtiqueta().equals("add")) {
            compara("add");
            termino();

            postfijo += " + ";
            masTerminos();
        } else if (this.componenteLexico.getEtiqueta().equals("subtract")) {
            compara("subtract");
            termino();

            postfijo += " - ";
            masTerminos();
        }
    }

    private void termino() {
        factor();
        masFactores();
    }

    private void masFactores() {
        if (this.componenteLexico.getEtiqueta().equals("multiply")) {
            compara("multiply");
            factor();

            postfijo += " * ";
            masFactores();
        } else if (this.componenteLexico.getEtiqueta().equals("divide")) {
            compara("divide");
            factor();

            postfijo += " / ";
            masFactores();
        }
    }

    private void factor() {
        if (this.componenteLexico.getEtiqueta().equals("open_parenthesis")) {
            compara("open_parenthesis");
            expresion();
            compara("closed_parenthesis");
        } else if (this.componenteLexico.getEtiqueta().equals("int")) {
            NumeroEntero numero = (NumeroEntero) this.componenteLexico;

            postfijo += numero.getValor();
            compara("int");
        } else if (this.componenteLexico.getEtiqueta().equals("id"))
            variable();
        else
            System.out.println("Error, se esperaba paréntesis abierto o número o identificador");
    }

    public void expresionLogica() {
        terminoLogico();
        masTerminosLogicos();
    }

    private void masTerminosLogicos() {
        if (this.componenteLexico.getEtiqueta().equals("or")) {
            compara("or");
            terminoLogico();
            masTerminosLogicos();
        }
    }

    private void terminoLogico() {
        factorLogico();
        masFactoresLogicos();
    }

    private void masFactoresLogicos() {
        if (this.componenteLexico.getEtiqueta().equals("and")) {
            compara("and");
            factorLogico();
            masFactoresLogicos();
        }
    }

    private void factorLogico() {
        if (this.componenteLexico.getEtiqueta().equals("not")) {
            compara("not");
            factorLogico();
        } else if (this.componenteLexico.getEtiqueta().equals("true")) {

            compara("true");
        } else if (this.componenteLexico.getEtiqueta().equals("false")) {

            compara("false");
        } else
            expresionRelacional();
    }

    private void expresionRelacional() {
        expresion();
        if (this.componenteLexico.getEtiqueta().equals("less_than")
                || this.componenteLexico.getEtiqueta().equals("less_equals")
                || this.componenteLexico.getEtiqueta().equals("greater_than")
                || this.componenteLexico.getEtiqueta().equals("greater_equals")
                || this.componenteLexico.getEtiqueta().equals("equals")
                || this.componenteLexico.getEtiqueta().equals("not_equals")) {
            operadorRelacional();
            expresion();
        }
    }

    private String operadorRelacional() {
        String operadorRelacional = this.componenteLexico.getEtiqueta();
        if (operadorRelacional.equals("less_than")) {
            compara("less_than");
        } else if (operadorRelacional.equals("less_equals")) {
            compara("less_equals");
        } else if (operadorRelacional.equals("greater_than")) {
            compara("greater_than");
        } else if (operadorRelacional.equals("greater_equals")) {
            compara("greater_equals");
        } else if (operadorRelacional.equals("equals")) {
            compara("equals");
        } else if (operadorRelacional.equals("not_equals")) {
            compara("not_equals");
        }

        return operadorRelacional;
    }

    private void variable() {
        String etiqueta = this.componenteLexico.getEtiqueta();
        if (etiqueta.equals("id")) {
            compara("id");
            if (this.componenteLexico.getEtiqueta().equals("open_square_bracket")) {
                compara("open_square_bracket");
                expresion();
                compara("closed_square_bracket");
            }
        }
    }

    public int valor() {
        int op1, op2;
        for (int i = 0; i < postfijo.length(); i++) {
            if (postfijo.charAt(i) >= '0' && postfijo.charAt(i) <= '9') {
                pila.push(Integer.valueOf(postfijo.charAt(i)));
            } else if (postfijo.charAt(i) == '+') {
                op1 = pila.pop();
                op2 = pila.pop();
                pila.push(op1 + op2);
            } else if (postfijo.charAt(i) == '-') {
                op1 = pila.pop();
                op2 = pila.pop();
                pila.push(op1 - op2);
            } else if (postfijo.charAt(i) == '*') {
                op1 = pila.pop();
                op2 = pila.pop();
                pila.push(op1 * op2);
            } else if (postfijo.charAt(i) == '/') {
                op1 = pila.pop();
                op2 = pila.pop();
                pila.push(op1 / op2);
            } else
                continue;
        }

        return pila.pop();
    }
}
