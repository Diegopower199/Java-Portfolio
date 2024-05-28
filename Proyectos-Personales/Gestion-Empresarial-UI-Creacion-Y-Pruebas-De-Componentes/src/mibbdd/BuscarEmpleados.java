package mibbdd;

import java.awt.Font;
import java.util.ArrayList;
import java.util.EventListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import ComponentesCustoms.CustomBoton;
import ComponentesCustoms.CustomCampoTexto;
import ComponentesCustoms.CustomLabel;
import ComponentesCustoms.EtiquetaComboBoxJuntos;
import ComponentesCustoms.EtiquetaTextFieldJuntos;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.Serializable;
import java.awt.Color;

public class BuscarEmpleados implements EventListener, Serializable {

    private JFrame frame;

    private String[] cabezera = { "Código", "Nombres y apellidos", "Ciudad", "Cargo", "     ", "      " };
    private String[][] informacion = { { "", "", "", "", "", "" }, { "", "", "", "", "", "" },
            { "", "", "", "", "", "" }, { "", "", "", "", "", "" }, { "", "", "", "", "", "" },
            { "", "", "", "", "", "" }, { "", "", "", "", "", "" }, { "", "", "", "", "", "" } };

    JPanel panel;

    JLabel etiquetaMenu;

    final Color colorBackgroundDefectoBotonBuscar;

    final Color colorBackgroundDefectoBotonReiniciar;
    final Color colorBackgroundDefectoComboBoxCiudades;

    protected String[] nombreCiudades;
    protected int[] codigoCiudades;

    static protected ArrayList<Pais> paises;

    static protected ArrayList<Ciudad> ciudades;

    static protected ArrayList<Cargo> cargos;
    protected String[] nombreCargos;
    protected int[] codigoCargos;

    boolean cuadroTextoVacioApellido;
    boolean comboBoxCargoObligatorio;
    String selectedPais;
    String nombreCargo;
    int codigoCargo;
    CustomCampoTexto cargoElegida = new CustomCampoTexto();

    public BuscarEmpleados(String[] paisesLegibles, String[] codigoPaises) {
        frame = new JFrame("Buscar Empleado");
        frame.setBounds(100, 100, 980, 673);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel();
        frame.getContentPane().add(panel, BorderLayout.CENTER);
        panel.setLayout(null);

        etiquetaMenu = new JLabel("MEN\u00DA");
        etiquetaMenu.setBounds(10, 44, 46, 14);
        panel.add(etiquetaMenu);

        JPanel panel_1 = new JPanel();
        panel_1.setBounds(50, 356, 848, 204);
        panel.add(panel_1);
        panel_1.setLayout(null);

        DefaultTableModel mod = new DefaultTableModel(informacion, cabezera);
        JTable tabla = new JTable(mod);

        JScrollPane scroll = new JScrollPane(tabla);
        scroll.setBounds(50, 101, 829, 157);

        panel.add(scroll);

        EtiquetaTextFieldJuntos apellido = new EtiquetaTextFieldJuntos(true, "Apellido");
        apellido.setBoundsLabel(10, 11, 70, 14);
        apellido.setBoundsTextField(10, 36, 110, 20);
        apellido.setBoundsFotoError(129, 33, 39, 34);
        apellido.anadirPanel(panel_1);

        CustomLabel etiquetaCargo = new CustomLabel("*Cargo", true);
        etiquetaCargo.setBounds(10, 90, 46, 14);
        panel_1.add(etiquetaCargo);

        panel.add(panel_1);

        CustomBoton botonBuscar = new CustomBoton("Buscar");
        colorBackgroundDefectoBotonBuscar = botonBuscar.getBackground();
        botonBuscar.setBounds(701, 35, 110, 55);
        panel_1.add(botonBuscar);

        CustomBoton botonReiniciar = new CustomBoton("Reiniciar");
        colorBackgroundDefectoBotonReiniciar = botonReiniciar.getBackground();
        botonReiniciar.setBounds(701, 105, 110, 55);
        panel_1.add(botonReiniciar);

        ciudades = Cargar.Ciudades();

        nombreCiudades = new String[ciudades.size()];
        codigoCiudades = new int[ciudades.size()];
        for (int pos = 0; pos < ciudades.size(); pos++) {
            nombreCiudades[pos] = ciudades.get(pos).getNombre();
            codigoCiudades[pos] = ciudades.get(pos).getCodPais();
        }

        colorBackgroundDefectoComboBoxCiudades = botonBuscar.getBackground();

        EtiquetaComboBoxJuntos comboBoxCiudades = new EtiquetaComboBoxJuntos(nombreCiudades, codigoCiudades);
        comboBoxCiudades.setBoundsLabel(521, 36, 46, 14);
        comboBoxCiudades.setBoundsComboBoxNombres(514, 70, 132, 34);
        comboBoxCiudades.setBoundsFotoError(533, 105, 39, 34);
        comboBoxCiudades.anadirPanel(panel_1);

        JList listPaises = new JList(paisesLegibles);
        listPaises.setFont(new Font("Tahoma", Font.BOLD, 15));
        listPaises.setVisibleRowCount(4);

        JScrollPane jcp = new JScrollPane(listPaises);
        jcp.setBounds(202, 33, 258, 109);
        panel_1.add(jcp);

        cargos = Cargar.Cargos();

        nombreCargos = new String[cargos.size()];
        codigoCargos = new int[cargos.size()];
        for (int pos = 0; pos < cargos.size(); pos++) {
            nombreCargos[pos] = cargos.get(pos).getNombre();
            codigoCargos[pos] = cargos.get(pos).getCodigo();
        }

        EtiquetaComboBoxJuntos comboBoxCargo = new EtiquetaComboBoxJuntos(nombreCargos, codigoCargos);
        comboBoxCargo.setBoundsLabel(10, 90, 46, 14);
        comboBoxCargo.setBoundsComboBoxNombres(10, 126, 132, 34);
        comboBoxCargo.setBoundsFotoError(150, 126, 39, 34);
        comboBoxCargo.anadirPanel(panel_1);

        CustomLabel lblNewLabel_1 = new CustomLabel("Pais", false);
        lblNewLabel_1.setBounds(204, 11, 46, 14);
        panel_1.add(lblNewLabel_1);

        panel.add(panel_1);

        JButton botonMenuPrincipal = new JButton("MENU PRINCIPAL");
        botonMenuPrincipal.setForeground(Color.RED);
        botonMenuPrincipal.setBounds(790, 40, 127, 36);
        panel.add(botonMenuPrincipal);

        botonMenuPrincipal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                new MenuPrincipal(paisesLegibles, codigoPaises);
            }
        });

        botonBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean empleadoEncontrado = false;
                if (!(apellido.getCampoTexto().equals("")) || !(comboBoxCargo.getComboBox().equals(""))
                        || !(comboBoxCargo.getComboBox().equals(null))) {
                    int codigoConfirmar = 0;
                    String nombreConfirmar = "";
                    String apellidoConfirmar = "";
                    int ciudadCodigoConfirmar = 0;
                    int cargoCodigoConfirmar = 0;
                    for (Empleado elem : Cargar.Empleados()) {

                        if (apellido.getCampoTexto().equals(elem.getApellidos())) {
                            codigoConfirmar = elem.getCodigo();
                            nombreConfirmar = elem.getNombre();
                            apellidoConfirmar = elem.getApellidos();
                            ciudadCodigoConfirmar = elem.getCodCiudad();
                            cargoCodigoConfirmar = elem.getCodCargo();

                            boolean puestoEnTabla = false;
                            for (int i = 0; i < 7; i++) {
                                for (int j = 0; j < 5; j++) {
                                    if (tabla.getValueAt(i, 0).equals("")) {
                                        informacion[i][0] = String.valueOf(codigoConfirmar);
                                        informacion[i][1] = nombreConfirmar + " " + apellidoConfirmar;
                                        informacion[i][2] = String.valueOf(ciudadCodigoConfirmar);
                                        informacion[i][3] = String.valueOf(cargoCodigoConfirmar);
                                        tabla.setValueAt(informacion[i][0], i, 0);
                                        tabla.setValueAt(informacion[i][1], i, 1);
                                        tabla.setValueAt(informacion[i][2], i, 2);
                                        tabla.setValueAt(informacion[i][3], i, 3);
                                        puestoEnTabla = true;
                                        empleadoEncontrado = true;
                                    }

                                    if (puestoEnTabla) {
                                        i = 7;
                                        j = 5;
                                    }
                                }
                            }
                        }
                    }

                    if (!(empleadoEncontrado)) {
                        JOptionPane.showMessageDialog(null, "Empleado no encontrado", "", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Introduce un apellido y un cargo",
                            "WARNING_MESSAGE", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        botonBuscar.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
                e.getComponent().setBackground(Color.RED);
            }

            public void focusLost(FocusEvent e) {
                e.getComponent().setBackground(colorBackgroundDefectoBotonBuscar);
            }
        });

        botonReiniciar.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
                e.getComponent().setBackground(Color.RED);
            }

            public void focusLost(FocusEvent e) {
                e.getComponent().setBackground(colorBackgroundDefectoBotonReiniciar);
            }
        });

        frame.setVisible(true);
    }
}
