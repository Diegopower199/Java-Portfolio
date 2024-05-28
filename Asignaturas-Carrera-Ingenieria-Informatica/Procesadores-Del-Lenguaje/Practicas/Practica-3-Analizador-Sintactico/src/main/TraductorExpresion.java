package main;

import java.util.Stack;

public class TraductorExpresion {

    private Lexico lexico;
    private ComponenteLexico componenteLexico;
    private Stack<Integer> pila;
    private String postfijo;

    public TraductorExpresion(Lexico lexico) {
        this.lexico = lexico;
        this.setComponenteLexico(this.lexico.getComponenteLexico());
        this.pila = new Stack<Integer>();
        this.postfijo = "";
    }

    public boolean isOperator(String c) {
        if (c.equals("+") || c.equals("-") || c.equals("*") || c.equals("/") || c.equals("%") || c.equals("^")) {
            return true;
        } else {
            return false;
        }
    }

    public int getPriority(String c) {
        if (c.equals("+") || c.equals("-")) {
            return 1;
        } else if (c.equals("*") || c.equals("/") || c.equals("%")) {
            return 2;
        } else if (c.equals("^")) {
            return 3;
        } else {
            return 0;
        }
    }

    public String postfijo(String infijo) {
        Stack stack = new Stack();
        String postfix = new String();
        for (int i = 0; infijo != null && i < infijo.length(); i++) {
            char letra = infijo.charAt(i);
            String c = String.valueOf(letra);

            if (!c.equals(" ")) {

                if (c.equals("(")) {

                    stack.push(c);
                }

                else if (c.equals(")")) {

                    String top = (String) stack.pop();
                    while (!top.equals("(")) {
                        postfix += " ";
                        postfix = postfix.concat(String.valueOf(top));
                        top = (String) stack.pop();

                    }
                }

                else if (isOperator(c)) {

                    if (!stack.isEmpty()) {
                        postfix += " ";
                        String top = (String) stack.pop();
                        if (getPriority(c) > getPriority(top))

                            stack.push(top);
                        else

                        {
                            while (getPriority(c) <= getPriority(top)) {
                                postfix = postfix.concat(String.valueOf(top));
                                if (stack.isEmpty())
                                    break;
                                top = (String) stack.pop();
                            }
                        }
                    }
                    postfix += " ";
                    stack.push(c);
                }

                else {
                    postfix = postfix.concat(String.valueOf(c));
                }
            }
        }
        while (!stack.isEmpty()) {
            postfix += " ";
            postfix = postfix.concat(String.valueOf(stack.pop()));
        }

        return postfix;
    }

    public int valor(String result) {

        String cadenaNumero = "";

        for (int i = 0; result != null && i < result.length(); i++) {
            char letra = result.charAt(i);

            if (letra >= '0' && letra <= '9')
                cadenaNumero = cadenaNumero + letra;

            else if (isOperator(String.valueOf(letra))) {
                int d2 = Integer.valueOf(pila.pop().toString());
                int d1 = Integer.valueOf(pila.pop().toString());
                int d3 = 0;

                if (letra == '+') {
                    d3 = d1 + d2;
                } else if (letra == '-') {
                    d3 = d1 - d2;
                } else if (letra == '*') {
                    d3 = d1 * d2;
                } else if (letra == '/') {
                    d3 = d1 / d2;
                } else if (letra == '%') {
                    d3 = d1 % d2;
                } else if (letra == '^') {
                    d3 = (int) Math.pow(d1, d2);
                }

                pila.push((int) d3);
            } else if (letra == ' ' && cadenaNumero.length() > 0) {
                pila.push(Integer.valueOf(cadenaNumero));
                cadenaNumero = "";
            }
        }
        return (Integer) pila.pop();
    }

    public ComponenteLexico getComponenteLexico() {
        return componenteLexico;
    }

    public void setComponenteLexico(ComponenteLexico componenteLexico) {
        this.componenteLexico = componenteLexico;
    }

    public String getPostfijo() {
        return postfijo;
    }

    public void setPostfijo(String postfijo) {
        this.postfijo = postfijo;
    }

    public void recorrerStack() {
        while (!pila.isEmpty()) {
            System.out.print(pila.pop() + "-  ");
        }
    }
}
