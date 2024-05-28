package mibbdd;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import ComponentesCustoms.CustomBoton;
import ComponentesCustoms.CustomLabel;
import ComponentesCustoms.EtiquetaComboBoxJuntos;
import ComponentesCustoms.EtiquetaTextFieldJuntos;

import javax.swing.JButton;
import java.awt.Font;

public class AltaDeUnEmpleado {

    private JFrame frame;

    protected String[] nombreCiudades;
    protected int[] codigoCiudades;

    protected String[] nombreCargos;
    protected int[] codigoCargos;

    static protected ArrayList<Ciudad> ciudades;

    static protected ArrayList<Cargo> cargos;

    static protected ArrayList<Pais> paises;
    protected String[] paisesLegibles2;
    protected String[] codigoPaises2;

    int codigoCiudad;
    int codigoCargo;
    String selectedPais;
    String nombreCargo;

    boolean cuadroTextoVacioNombreObligatorio = true;
    boolean cuadroTextoVacioApellidoObligatorio = true;
    boolean comboBoxCargoObligatorio = true;

    public AltaDeUnEmpleado(String[] paisesLegibles, String[] codigoPaises) {
        frame = new JFrame();
        frame.setBounds(100, 100, 534, 377);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.getContentPane().add(panel, BorderLayout.CENTER);
        panel.setLayout(null);

        CustomLabel etiquetaFormularioAltaEmpleado = new CustomLabel("Formulario de alta de empleado", false);
        etiquetaFormularioAltaEmpleado.setBounds(10, 11, 163, 50);
        panel.add(etiquetaFormularioAltaEmpleado);

        EtiquetaTextFieldJuntos nombre = new EtiquetaTextFieldJuntos(true, "Nombre");
        nombre.setBoundsLabel(10, 72, 70, 35);
        nombre.setBoundsTextField(64, 79, 109, 20);
        nombre.setBoundsFotoError(183, 72, 39, 34);
        nombre.anadirPanel(panel);

        EtiquetaTextFieldJuntos apellido = new EtiquetaTextFieldJuntos(true, "Apellido");
        apellido.setBoundsLabel(10, 106, 70, 50);
        apellido.setBoundsTextField(64, 121, 109, 20);
        apellido.setBoundsFotoError(183, 122, 39, 34);
        apellido.anadirPanel(panel);

        ciudades = Cargar.Ciudades();

        nombreCiudades = new String[ciudades.size()];
        codigoCiudades = new int[ciudades.size()];
        for (int pos = 0; pos < ciudades.size(); pos++) {
            nombreCiudades[pos] = ciudades.get(pos).getNombre();
            codigoCiudades[pos] = ciudades.get(pos).getCodPais();

        }

        EtiquetaComboBoxJuntos comboBoxCiudades = new EtiquetaComboBoxJuntos(nombreCiudades, codigoCiudades);
        comboBoxCiudades.setBoundsLabel(177, 186, 163, 28);
        comboBoxCiudades.setBoundsComboBoxNombres(177, 230, 132, 34);
        comboBoxCiudades.setBoundsFotoError(177, 270, 132, 34);
        comboBoxCiudades.anadirPanel(panel);

        CustomLabel etiquetaCiudad = new CustomLabel("Ciudad", false);
        etiquetaCiudad.setBounds(177, 186, 163, 28);
        panel.add(etiquetaCiudad);

        cargos = Cargar.Cargos();

        nombreCargos = new String[cargos.size()];
        codigoCargos = new int[cargos.size()];
        for (int pos = 0; pos < cargos.size(); pos++) {
            nombreCargos[pos] = cargos.get(pos).getNombre();
            codigoCargos[pos] = cargos.get(pos).getCodigo();
        }

        EtiquetaComboBoxJuntos comboBoxCargo = new EtiquetaComboBoxJuntos(nombreCiudades, codigoCargos);
        comboBoxCargo.setBoundsLabel(318, 186, 163, 28);
        comboBoxCargo.setBoundsComboBoxNombres(337, 230, 132, 34);
        comboBoxCargo.setBoundsFotoError(469, 230, 39, 34);
        comboBoxCargo.anadirPanel(panel);

        CustomBoton botonAceptar = new CustomBoton("Aceptar");
        botonAceptar.setBounds(300, 304, 89, 23);
        panel.add(botonAceptar);

        CustomBoton botonCancelar = new CustomBoton("Cancelar");
        botonCancelar.setBounds(419, 304, 89, 23);
        panel.add(botonCancelar);

        JList listPaises = new JList(paisesLegibles);
        listPaises.setVisibleRowCount(4);

        listPaises.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));

        JScrollPane jcp = new JScrollPane(listPaises);
        panel.add(jcp);
        jcp.setBounds(10, 176, 163, 66);

        CustomLabel label = new CustomLabel();
        label.setBounds(49, 248, 89, 43);

        listPaises.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                selectedPais = (String) listPaises.getSelectedValue();
                label.setText(selectedPais);
            }
        });

        panel.add(label);

        listPaises.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
                e.getComponent().setBackground(Color.RED);
            }

            public void focusLost(FocusEvent e) {
                if (selectedPais == null || selectedPais.equals("Elija un país")) {
                    JOptionPane.showMessageDialog(null, "Introduce un apellido", "ERROR_MESSAGE",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        botonAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });

        JButton botonMenuPrincipal = new JButton("MENU PRINCIPAL");
        botonMenuPrincipal.setForeground(Color.RED);
        botonMenuPrincipal.setBounds(356, 19, 127, 36);
        panel.add(botonMenuPrincipal);

        botonMenuPrincipal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                new MenuPrincipal(paisesLegibles, codigoPaises);
            }
        });
        frame.setVisible(true);
    }

}