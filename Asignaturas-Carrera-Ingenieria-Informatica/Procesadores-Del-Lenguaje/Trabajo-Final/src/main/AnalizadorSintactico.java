package main;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
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

    ArrayList<String> erroresPrograma = new ArrayList<String>();
    ArrayList<String> codigoPila = new ArrayList<String>();
    ArrayList<String> signosDeOperaciones = new ArrayList<String>();
    ArrayList<String> operadoresRelacionales = new ArrayList<String>();
    Iterator it;
    Iterator it2;

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

        declaraciones();
        instrucciones();

        compara("closed_bracket");
        if (erroresPrograma.size() != 0) {
            for (String elem : erroresPrograma) {
                System.out.println(elem);
            }
        } else {
            System.out.println("Programa compilado correctamente");
        }
    }

    public String codigoMaquinaPila() {
        String codigo = "";
        for (String elem : codigoPila) {
            codigo += elem + "\n";
        }

        return codigo + "halt";
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
            instrucciones();
        }
    }

    public void instruccion() {
        String etiqueta = this.componenteLexico.getEtiqueta();

        if (etiqueta.equals("id")) {

            Identificador idComp = (Identificador) this.componenteLexico;

            if (this.simbolos.containsKey(idComp.getLexema())) {
                String tipoVariable = this.simbolos.get(idComp.getLexema()).getTipo();

                variable();

                compara("assignment");

                expresion(tipoVariable);

                compara("semicolon");

            } else {
                String error = "Error en la linea " + lexico.getLineas() + ", la variable " + idComp.getLexema()
                        + " no esta declarada";
                erroresPrograma.add(error);
                compara("semicolon");
            }
        }

        else if (etiqueta.equals("if")) {
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
            codigoPila.add("label_0");
            compara("open_parenthesis");
            expresionLogica();
            compara("closed_parenthesis");
            Iterator it2 = operadoresRelacionales.iterator();
            while (it2.hasNext()) {
                codigoPila.add((String) it2.next());
            }
            operadoresRelacionales.clear();
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

            if (tipo1.getTipo().equals(tipo2.getTipo())) {
                System.out
                        .println(id1.getLexema() + " (" + tipo1 + ") vs " + id2.getLexema() + " (" + tipo2 + ") is ok");
            } else {
                System.out.println(
                        id1.getLexema() + " (" + tipo1 + ") vs " + id2.getLexema() + " (" + tipo2 + ") type mismatch");
            }
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
            String error = "Error, se esperaba int o float o boolean";
            erroresPrograma.add(error);
        }

        return tipo;
    }

    private void identificadores(String tipo) {

        if (this.componenteLexico.getEtiqueta().equals("id")) {

            Identificador id = (Identificador) this.componenteLexico;

            if (this.simbolos.containsKey(id.getLexema())) {

                String error = "Error en la línea " + this.lexico.getLineas() + ", identificador " + id.getLexema()
                        + " ya declarado";
                erroresPrograma.add(error);
            } else {
                simbolos.put(id.getLexema(), new TipoPrimitivo(tipo));
                codigoPila.add("lvalue " + id.getLexema());
            }

            compara("id");

            asignacionDeclaracion(tipo);
            masIdentificadores(tipo);
        }
    }

    private void masIdentificadores(String tipo) {

        if (this.componenteLexico.getEtiqueta().equals("comma")) {
            compara("comma");
            codigoPila.add("=");
            Identificador id = (Identificador) this.componenteLexico;
            if (this.simbolos.containsKey(id.getLexema())) {

                String error = "Error en la línea " + this.lexico.getLineas() + ", identificador " + id.getLexema()
                        + " ya declarado";
                erroresPrograma.add(error);
            }

            else {
                simbolos.put(id.getLexema(), new TipoPrimitivo(tipo));
                codigoPila.add("lvalue " + id.getLexema());
            }

            compara("id");
            asignacionDeclaracion(tipo);

            masIdentificadores(tipo);
        } else {
            if (signosDeOperaciones != null) {
                it = signosDeOperaciones.iterator();
                while (it.hasNext()) {
                    codigoPila.add((String) it.next());
                }
                signosDeOperaciones.clear();
            }
            codigoPila.add("=");
        }
    }

    private void asignacionDeclaracion(String tipo) {

        if (this.componenteLexico.getEtiqueta().equals("assignment")) {
            compara("assignment");
            expresion(tipo);
        }
    }

    public void expresion(String tipo) {
        termino(tipo);
        masTerminos(tipo);
    }

    private void masTerminos(String tipo) {

        if (this.componenteLexico.getEtiqueta().equals("add")) {
            compara("add");
            termino(tipo);
            codigoPila.add("+");

            postfijo += " + ";
            masTerminos(tipo);
        } else if (this.componenteLexico.getEtiqueta().equals("subtract")) {
            compara("subtract");
            termino(tipo);
            codigoPila.add("-");

            postfijo += " - ";
            masTerminos(tipo);
        }
    }

    private void termino(String tipo) {
        factor(tipo);
        masFactores(tipo);
    }

    private void masFactores(String tipo) {
        if (this.componenteLexico.getEtiqueta().equals("multiply")) {
            compara("multiply");
            factor(tipo);
            codigoPila.add("*");

            postfijo += " * ";
            masFactores(tipo);
        } else if (this.componenteLexico.getEtiqueta().equals("divide")) {
            compara("divide");
            factor(tipo);
            codigoPila.add("/");

            postfijo += " / ";
            masFactores(tipo);
        }
    }

    private void factor(String tipo) {

        if (this.componenteLexico.getEtiqueta().equals("open_parenthesis")) {
            compara("open_parenthesis");
            expresion(tipo);
            compara("closed_parenthesis");

        } else if (this.componenteLexico.getEtiqueta().equals("int")) {
            NumeroEntero numero = (NumeroEntero) this.componenteLexico;

            postfijo += numero.getValor();
            codigoPila.add("push " + numero.getValor());
            compara("int");

        } else if (this.componenteLexico.getEtiqueta().equals("float")) {
            NumeroReal numero = (NumeroReal) this.componenteLexico;

            postfijo += numero.getValor();
            compara("float");
        } else if (this.componenteLexico.getEtiqueta().equals("id")) {
            Identificador idComp = (Identificador) this.componenteLexico;
            String tipoFactor = this.simbolos.get(idComp.getLexema()).getTipo();

            if (tipoFactor.equals(tipo)) {
                codigoPila.add("rvalue " + idComp.getLexema());
                variable();
            }

            else {
                String error = "Error en la linea " + lexico.getLineas()
                        + ", incompatibilidad de tipos en la instrucción de asignación\r\n";
                erroresPrograma.add(error);

            }
        } else {
            String error = "Error, se esperaba paréntesis abierto o número o identificador";
            erroresPrograma.add(error);
        }
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
        expresion("int");
        if (this.componenteLexico.getEtiqueta().equals("less_than")
                || this.componenteLexico.getEtiqueta().equals("less_equals")
                || this.componenteLexico.getEtiqueta().equals("greater_than")
                || this.componenteLexico.getEtiqueta().equals("greater_equals")
                || this.componenteLexico.getEtiqueta().equals("equals")
                || this.componenteLexico.getEtiqueta().equals("not_equals")) {
            operadorRelacional();
            expresion("int");
        }
    }

    private String operadorRelacional() {
        String operadorRelacional = this.componenteLexico.getEtiqueta();

        if (operadorRelacional.equals("less_than")) {
            compara("less_than");
            operadoresRelacionales.add("<");
        } else if (operadorRelacional.equals("less_equals")) {
            compara("less_equals");
            operadoresRelacionales.add("<=");
        } else if (operadorRelacional.equals("greater_than")) {
            compara("greater_than");
            operadoresRelacionales.add(">=");
        } else if (operadorRelacional.equals("greater_equals")) {
            compara("greater_equals");
            operadoresRelacionales.add(">");
        } else if (operadorRelacional.equals("equals")) {
            compara("equals");
            operadoresRelacionales.add("==");
        } else if (operadorRelacional.equals("not_equals")) {
            compara("not_equals");
            operadoresRelacionales.add("!=");
        }

        return operadorRelacional;
    }

    private void variable() {
        String etiqueta = this.componenteLexico.getEtiqueta();

        if (etiqueta.equals("id")) {
            compara("id");

            if (this.componenteLexico.getEtiqueta().equals("open_square_bracket")) {
                compara("open_square_bracket");
                expresion("int");
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
            } else {
                continue;
            }
        }
        System.out.println(postfijo);
        return pila.pop();
    }

}
