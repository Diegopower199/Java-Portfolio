package main;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Color;

public class Main extends JFrame {

    private JTextField textField_Numeros;
    private double numero1;
    private double numero2;
    private String signoOperativo = "";
    private double resultado;

    private JButton botonValorCE;
    private final JButton botonOperacionIgual;
    private JButton botonValorNumeroUno;
    private JButton botonValorNumeroDos;
    private JButton botonValorNumeroTres;
    private JButton botonValorNumeroCuatro;
    private JButton botonValorNumeroCinco;
    private JButton botonValorNumeroSeis;
    private JButton botonValorNumeroSiete;
    private JButton botonValorNumeroOcho;
    private JButton botonValorNumeroNueve;
    private JButton botonValorNumeroCero;
    private JButton botonOperacionSuma;
    private JButton botonOperacionResta;
    private JButton botonOperacionMultiplicacion;
    private JButton botonOperacionDivision;
    private JButton botonBin;
    private JButton botonComa;

    private boolean puntoDecimal = false;

    String textoBotones[] = { "Resultado", "7", "8", "9", "/", "4", "5", "6", "*", "1", "2", "3", "-", "C", "0", ".",
            "+" };

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Main frame = new Main();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Main() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 483, 396);

        Font fuente = new Font("Dialog", Font.BOLD, 26);
        getContentPane().setLayout(null);

        JPanel panel = new JPanel();
        panel.setBounds(0, 11, 457, 471);
        getContentPane().add(panel);
        panel.setLayout(null);

        textField_Numeros = new JTextField();
        textField_Numeros.setForeground(Color.BLACK);
        textField_Numeros.setBackground(Color.WHITE);
        textField_Numeros.setBounds(23, 11, 340, 62);
        panel.add(textField_Numeros);
        textField_Numeros.setColumns(10);
        textField_Numeros.setFont(fuente);

        botonValorCE = new JButton("CE");
        botonValorCE.setForeground(Color.WHITE);
        botonValorCE.setOpaque(true);
        botonValorCE.setBackground(new Color(114, 199, 255));
        botonValorCE.setBounds(373, 11, 74, 62);
        panel.add(botonValorCE);
        botonValorCE.setFont(fuente);

        botonValorCE.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                signoOperativo = "";
                textField_Numeros.setText("");

                botonOperacionIgual.setEnabled(true);
                botonValorNumeroUno.setEnabled(true);
                botonValorNumeroDos.setEnabled(true);
                botonValorNumeroTres.setEnabled(true);
                botonValorNumeroCuatro.setEnabled(true);
                botonValorNumeroCinco.setEnabled(true);
                botonValorNumeroSeis.setEnabled(true);
                botonValorNumeroSiete.setEnabled(true);
                botonValorNumeroOcho.setEnabled(true);
                botonValorNumeroNueve.setEnabled(true);
                botonValorNumeroCero.setEnabled(true);
                botonOperacionSuma.setEnabled(true);
                botonOperacionResta.setEnabled(true);
                botonOperacionMultiplicacion.setEnabled(true);
                botonOperacionDivision.setEnabled(true);
                botonBin.setEnabled(true);
                botonComa.setEnabled(true);
            }
        });

        botonValorNumeroUno = new JButton("1");
        botonValorNumeroUno.setForeground(Color.WHITE);
        botonValorNumeroUno.setOpaque(true);
        botonValorNumeroUno.setBackground(new Color(114, 199, 255));
        botonValorNumeroUno.setBounds(23, 204, 84, 46);
        panel.add(botonValorNumeroUno);
        botonValorNumeroUno.setFont(fuente);

        botonValorNumeroUno.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (textField_Numeros.getText().length() < 16) {
                    String numero = textField_Numeros.getText() + botonValorNumeroUno.getText();
                    textField_Numeros.setText(numero);
                } else {
                    JOptionPane.showMessageDialog(panel, "Te has pasado de los limites");
                }
            }
        });

        botonValorNumeroDos = new JButton("2");
        botonValorNumeroDos.setForeground(Color.WHITE);
        botonValorNumeroDos.setOpaque(true);
        botonValorNumeroDos.setBackground(new Color(114, 199, 255));
        botonValorNumeroDos.setBounds(117, 204, 86, 46);
        panel.add(botonValorNumeroDos);
        botonValorNumeroDos.setFont(fuente);

        botonValorNumeroDos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (textField_Numeros.getText().length() < 16) {
                    String numero = textField_Numeros.getText() + botonValorNumeroDos.getText();
                    textField_Numeros.setText(numero);
                } else {
                    JOptionPane.showMessageDialog(panel, "Te has pasado de los limites");
                }
            }
        });

        botonValorNumeroTres = new JButton("3");
        botonValorNumeroTres.setForeground(Color.WHITE);
        botonValorNumeroTres.setOpaque(true);
        botonValorNumeroTres.setBackground(new Color(114, 199, 255));
        botonValorNumeroTres.setBounds(213, 204, 84, 46);
        panel.add(botonValorNumeroTres);
        botonValorNumeroTres.setFont(fuente);

        botonValorNumeroTres.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (textField_Numeros.getText().length() < 16) {
                    String numero = textField_Numeros.getText() + botonValorNumeroTres.getText();
                    textField_Numeros.setText(numero);
                } else {
                    JOptionPane.showMessageDialog(panel, "Te has pasado de los limites");
                }
            }
        });

        botonValorNumeroCuatro = new JButton("4");
        botonValorNumeroCuatro.setForeground(Color.WHITE);
        botonValorNumeroCuatro.setOpaque(true);
        botonValorNumeroCuatro.setBackground(new Color(114, 199, 255));
        botonValorNumeroCuatro.setBounds(119, 144, 84, 46);
        panel.add(botonValorNumeroCuatro);
        botonValorNumeroCuatro.setFont(fuente);

        botonValorNumeroCuatro.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (textField_Numeros.getText().length() < 16) {
                    String numero = textField_Numeros.getText() + botonValorNumeroCuatro.getText();
                    textField_Numeros.setText(numero);
                } else {
                    JOptionPane.showMessageDialog(panel, "Te has pasado de los limites");
                }
            }
        });

        botonValorNumeroCinco = new JButton("5");
        botonValorNumeroCinco.setForeground(Color.WHITE);
        botonValorNumeroCinco.setOpaque(true);
        botonValorNumeroCinco.setBackground(new Color(114, 199, 255));
        botonValorNumeroCinco.setBounds(211, 144, 86, 46);
        panel.add(botonValorNumeroCinco);
        botonValorNumeroCinco.setFont(fuente);

        botonValorNumeroCinco.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (textField_Numeros.getText().length() < 16) {
                    String numero = textField_Numeros.getText() + botonValorNumeroCinco.getText();
                    textField_Numeros.setText(numero);
                } else {
                    JOptionPane.showMessageDialog(panel, "Te has pasado de los limites");
                }
            }
        });

        botonValorNumeroSeis = new JButton("6");
        botonValorNumeroSeis.setForeground(Color.WHITE);
        botonValorNumeroSeis.setOpaque(true);
        botonValorNumeroSeis.setBackground(new Color(114, 199, 255));
        botonValorNumeroSeis.setBounds(23, 144, 84, 46);
        panel.add(botonValorNumeroSeis);
        botonValorNumeroSeis.setFont(fuente);

        botonValorNumeroSeis.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (textField_Numeros.getText().length() < 16) {
                    String numero = textField_Numeros.getText() + botonValorNumeroSeis.getText();
                    textField_Numeros.setText(numero);
                } else {
                    JOptionPane.showMessageDialog(panel, "Te has pasado de los limites");
                }
            }
        });

        botonValorNumeroSiete = new JButton("7");
        botonValorNumeroSiete.setForeground(Color.WHITE);
        botonValorNumeroSiete.setOpaque(true);
        botonValorNumeroSiete.setBackground(new Color(114, 199, 255));
        botonValorNumeroSiete.setBounds(23, 84, 84, 46);
        panel.add(botonValorNumeroSiete);
        botonValorNumeroSiete.setFont(fuente);

        botonValorNumeroSiete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (textField_Numeros.getText().length() < 16) {
                    String numero = textField_Numeros.getText() + botonValorNumeroSiete.getText();
                    textField_Numeros.setText(numero);
                } else {
                    JOptionPane.showMessageDialog(panel, "Te has pasado de los limites");
                }
            }
        });

        botonValorNumeroOcho = new JButton("8");
        botonValorNumeroOcho.setForeground(Color.WHITE);
        botonValorNumeroOcho.setOpaque(true);
        botonValorNumeroOcho.setBackground(new Color(114, 199, 255));
        botonValorNumeroOcho.setBounds(117, 84, 86, 46);
        panel.add(botonValorNumeroOcho);
        botonValorNumeroOcho.setFont(fuente);

        botonValorNumeroOcho.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (textField_Numeros.getText().length() < 16) {
                    String numero = textField_Numeros.getText() + botonValorNumeroOcho.getText();
                    textField_Numeros.setText(numero);
                } else {
                    JOptionPane.showMessageDialog(panel, "Te has pasado de los limites");
                }
            }
        });

        botonValorNumeroNueve = new JButton("9");
        botonValorNumeroNueve.setForeground(Color.WHITE);
        botonValorNumeroNueve.setOpaque(true);
        botonValorNumeroNueve.setBackground(new Color(114, 199, 255));
        botonValorNumeroNueve.setBounds(213, 84, 84, 46);
        panel.add(botonValorNumeroNueve);
        botonValorNumeroNueve.setFont(fuente);

        botonValorNumeroNueve.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (textField_Numeros.getText().length() < 16) {
                    String numero = textField_Numeros.getText() + botonValorNumeroNueve.getText();
                    textField_Numeros.setText(numero);
                } else {
                    JOptionPane.showMessageDialog(panel, "Te has pasado de los limites");
                }
            }
        });

        botonValorNumeroCero = new JButton("0");
        botonValorNumeroCero.setForeground(Color.WHITE);
        botonValorNumeroCero.setOpaque(true);
        botonValorNumeroCero.setBackground(new Color(114, 199, 255));
        botonValorNumeroCero.setBounds(117, 261, 86, 46);
        panel.add(botonValorNumeroCero);
        botonValorNumeroCero.setFont(fuente);

        botonValorNumeroCero.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (textField_Numeros.getText().length() < 16) {
                    String numero = textField_Numeros.getText() + botonValorNumeroCero.getText();
                    textField_Numeros.setText(numero);
                } else {
                    JOptionPane.showMessageDialog(panel, "Te has pasado de los limites");
                }
            }
        });

        botonOperacionIgual = new JButton("=");
        botonOperacionIgual.setForeground(Color.WHITE);
        botonOperacionIgual.setOpaque(true);
        botonOperacionIgual.setBackground(new Color(114, 199, 255));
        botonOperacionIgual.setBounds(373, 84, 74, 223);
        panel.add(botonOperacionIgual);
        botonOperacionIgual.setFont(fuente);

        botonOperacionIgual.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    double numeroDelTextField = Double.parseDouble(textField_Numeros.getText());
                    numero2 = numeroDelTextField;
                    String resultadoString;

                    switch (signoOperativo) {
                        case "+":
                            resultado = numero1 + numero2;
                            resultadoString = String.valueOf(resultado);
                            textField_Numeros.setText(resultadoString);
                            break;

                        case "-":
                            resultado = numero1 - numero2;
                            resultadoString = String.valueOf(resultado);
                            textField_Numeros.setText(resultadoString);
                            break;

                        case "*":
                            resultado = numero1 * numero2;
                            resultadoString = String.valueOf(resultado);
                            textField_Numeros.setText(resultadoString);
                            break;

                        case "/":
                            resultado = numero1 / numero2;
                            resultadoString = String.valueOf(resultado);
                            textField_Numeros.setText(resultadoString);
                            break;
                    }

                    Locale localeActual = Locale.GERMAN;
                    DecimalFormatSymbols simbolos = new DecimalFormatSymbols(localeActual);
                    simbolos.setDecimalSeparator('.');
                    DecimalFormat formatoResultado = new DecimalFormat("#.######", simbolos);
                    textField_Numeros.setText(String.valueOf(formatoResultado.format(resultado)));

                    textField_Numeros.setText("");

                    numero1 = 0;
                    numero2 = 0;
                    signoOperativo = "";
                    resultado = 0;

                    puntoDecimal = false;
                } catch (NumberFormatException e1) {
                    textField_Numeros.setText("Error");
                    botonOperacionIgual.setEnabled(false);
                    botonValorNumeroUno.setEnabled(false);
                    botonValorNumeroDos.setEnabled(false);
                    botonValorNumeroTres.setEnabled(false);
                    botonValorNumeroCuatro.setEnabled(false);
                    botonValorNumeroCinco.setEnabled(false);
                    botonValorNumeroSeis.setEnabled(false);
                    botonValorNumeroSiete.setEnabled(false);
                    botonValorNumeroOcho.setEnabled(false);
                    botonValorNumeroNueve.setEnabled(false);
                    botonValorNumeroCero.setEnabled(false);
                    botonOperacionSuma.setEnabled(false);
                    botonOperacionResta.setEnabled(false);
                    botonOperacionMultiplicacion.setEnabled(false);
                    botonOperacionDivision.setEnabled(false);
                } catch (ArithmeticException e2) {
                    textField_Numeros.setText("Indeterminación");
                }
            }
        });

        botonOperacionSuma = new JButton("+");
        botonOperacionSuma.setForeground(Color.WHITE);
        botonOperacionSuma.setOpaque(true);
        botonOperacionSuma.setBackground(new Color(114, 199, 255));
        botonOperacionSuma.setBounds(307, 84, 60, 46);
        panel.add(botonOperacionSuma);
        botonOperacionSuma.setFont(fuente);

        botonOperacionSuma.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    double numeroDelTextField = Double.parseDouble(textField_Numeros.getText());

                    numero1 = numeroDelTextField;
                    signoOperativo = "+";
                    textField_Numeros.setText("");

                    puntoDecimal = false;
                } catch (NumberFormatException e1) {
                    textField_Numeros.setText("Error");
                    botonOperacionIgual.setEnabled(false);
                    botonValorNumeroUno.setEnabled(false);
                    botonValorNumeroDos.setEnabled(false);
                    botonValorNumeroTres.setEnabled(false);
                    botonValorNumeroCuatro.setEnabled(false);
                    botonValorNumeroCinco.setEnabled(false);
                    botonValorNumeroSeis.setEnabled(false);
                    botonValorNumeroSiete.setEnabled(false);
                    botonValorNumeroOcho.setEnabled(false);
                    botonValorNumeroNueve.setEnabled(false);
                    botonValorNumeroCero.setEnabled(false);
                    botonOperacionSuma.setEnabled(false);
                    botonOperacionResta.setEnabled(false);
                    botonOperacionMultiplicacion.setEnabled(false);
                    botonOperacionDivision.setEnabled(false);
                }
            }
        });

        botonOperacionResta = new JButton("-");
        botonOperacionResta.setForeground(Color.WHITE);
        botonOperacionResta.setOpaque(true);
        botonOperacionResta.setBackground(new Color(114, 199, 255));
        botonOperacionResta.setBounds(308, 144, 59, 46);
        panel.add(botonOperacionResta);
        botonOperacionResta.setFont(fuente);

        botonOperacionResta.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    double numeroDelTextField = Double.parseDouble(textField_Numeros.getText());

                    numero1 = numeroDelTextField;
                    signoOperativo = "-";
                    textField_Numeros.setText("");

                    puntoDecimal = false;
                } catch (NumberFormatException e1) {
                    textField_Numeros.setText("Error");
                    botonOperacionIgual.setEnabled(false);
                    botonValorNumeroUno.setEnabled(false);
                    botonValorNumeroDos.setEnabled(false);
                    botonValorNumeroTres.setEnabled(false);
                    botonValorNumeroCuatro.setEnabled(false);
                    botonValorNumeroCinco.setEnabled(false);
                    botonValorNumeroSeis.setEnabled(false);
                    botonValorNumeroSiete.setEnabled(false);
                    botonValorNumeroOcho.setEnabled(false);
                    botonValorNumeroNueve.setEnabled(false);
                    botonValorNumeroCero.setEnabled(false);
                    botonOperacionSuma.setEnabled(false);
                    botonOperacionResta.setEnabled(false);
                    botonOperacionMultiplicacion.setEnabled(false);
                    botonOperacionDivision.setEnabled(false);
                }
            }
        });

        botonOperacionMultiplicacion = new JButton("x");
        botonOperacionMultiplicacion.setForeground(Color.WHITE);
        botonOperacionMultiplicacion.setOpaque(true);
        botonOperacionMultiplicacion.setBackground(new Color(114, 199, 255));
        botonOperacionMultiplicacion.setBounds(308, 204, 59, 46);
        panel.add(botonOperacionMultiplicacion);
        botonOperacionMultiplicacion.setFont(fuente);

        botonOperacionMultiplicacion.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    double numeroDelTextField = Double.parseDouble(textField_Numeros.getText());

                    numero1 = numeroDelTextField;
                    signoOperativo = "*";
                    textField_Numeros.setText("");

                    puntoDecimal = false;
                } catch (NumberFormatException e1) {
                    textField_Numeros.setText("Error");
                    botonOperacionIgual.setEnabled(false);
                    botonValorNumeroUno.setEnabled(false);
                    botonValorNumeroDos.setEnabled(false);
                    botonValorNumeroTres.setEnabled(false);
                    botonValorNumeroCuatro.setEnabled(false);
                    botonValorNumeroCinco.setEnabled(false);
                    botonValorNumeroSeis.setEnabled(false);
                    botonValorNumeroSiete.setEnabled(false);
                    botonValorNumeroOcho.setEnabled(false);
                    botonValorNumeroNueve.setEnabled(false);
                    botonValorNumeroCero.setEnabled(false);
                    botonOperacionSuma.setEnabled(false);
                    botonOperacionResta.setEnabled(false);
                    botonOperacionMultiplicacion.setEnabled(false);
                    botonOperacionDivision.setEnabled(false);
                }
            }
        });

        botonOperacionDivision = new JButton(":");
        botonOperacionDivision.setForeground(Color.WHITE);
        botonOperacionDivision.setOpaque(true);
        botonOperacionDivision.setBackground(new Color(114, 199, 255));
        botonOperacionDivision.setBounds(308, 261, 59, 46);
        panel.add(botonOperacionDivision);
        botonOperacionDivision.setFont(fuente);

        botonOperacionDivision.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    double numeroDelTextField = Double.parseDouble(textField_Numeros.getText());
                    numero1 = numeroDelTextField;
                    signoOperativo = "/";
                    textField_Numeros.setText("");
                    puntoDecimal = false;
                } catch (NumberFormatException e1) {
                    textField_Numeros.setText("Error");
                    botonOperacionIgual.setEnabled(false);
                    botonValorNumeroUno.setEnabled(false);
                    botonValorNumeroDos.setEnabled(false);
                    botonValorNumeroTres.setEnabled(false);
                    botonValorNumeroCuatro.setEnabled(false);
                    botonValorNumeroCinco.setEnabled(false);
                    botonValorNumeroSeis.setEnabled(false);
                    botonValorNumeroSiete.setEnabled(false);
                    botonValorNumeroOcho.setEnabled(false);
                    botonValorNumeroNueve.setEnabled(false);
                    botonValorNumeroCero.setEnabled(false);
                    botonOperacionSuma.setEnabled(false);
                    botonOperacionResta.setEnabled(false);
                    botonOperacionMultiplicacion.setEnabled(false);
                    botonOperacionDivision.setEnabled(false);
                }
            }
        });

        botonBin = new JButton("BIN");
        botonBin.setForeground(Color.WHITE);
        botonBin.setOpaque(true);
        botonBin.setBackground(new Color(114, 199, 255));
        botonBin.setFont(new Font("Dialog", Font.BOLD, 26));
        botonBin.setBounds(23, 261, 84, 46);
        panel.add(botonBin);

        botonBin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (textField_Numeros.getText().length() != 0 || textField_Numeros.getText().equals(",")) {
                    if (!puntoDecimal) {
                        double numero = numero1 + Double.parseDouble(textField_Numeros.getText());
                        int numeroSinDecimales = (int) (numero);

                        String binario = Integer.toBinaryString(numeroSinDecimales);
                        textField_Numeros.setText(binario);
                    } else {
                        textField_Numeros.setText("Inserta un numero positivo");
                        botonOperacionIgual.setEnabled(false);
                        botonValorNumeroUno.setEnabled(false);
                        botonValorNumeroDos.setEnabled(false);
                        botonValorNumeroTres.setEnabled(false);
                        botonValorNumeroCuatro.setEnabled(false);
                        botonValorNumeroCinco.setEnabled(false);
                        botonValorNumeroSeis.setEnabled(false);
                        botonValorNumeroSiete.setEnabled(false);
                        botonValorNumeroOcho.setEnabled(false);
                        botonValorNumeroNueve.setEnabled(false);
                        botonValorNumeroCero.setEnabled(false);
                        botonOperacionSuma.setEnabled(false);
                        botonOperacionResta.setEnabled(false);
                        botonOperacionMultiplicacion.setEnabled(false);
                        botonOperacionDivision.setEnabled(false);
                        botonBin.setEnabled(false);
                        botonComa.setEnabled(false);
                    }
                }
            }
        });

        botonComa = new JButton(",");
        botonComa.setForeground(Color.WHITE);
        botonComa.setOpaque(true);
        botonComa.setBackground(new Color(114, 199, 255));
        botonComa.setFont(new Font("Dialog", Font.BOLD, 26));
        botonComa.setBounds(211, 261, 84, 46);
        panel.add(botonComa);

        botonComa.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (!puntoDecimal) {
                    textField_Numeros.setText(textField_Numeros.getText() + textoBotones[15]);
                    puntoDecimal = true;
                }
            }
        });
    }
}
