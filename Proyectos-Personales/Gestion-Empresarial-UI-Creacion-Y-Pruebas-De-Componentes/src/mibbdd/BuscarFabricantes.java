package mibbdd;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import ComponentesCustoms.CustomBoton;
import ComponentesCustoms.CustomLabel;
import ComponentesCustoms.CustomRadioButton;
import ComponentesCustoms.EtiquetaTextFieldJuntos;

public class BuscarFabricantes implements Serializable {

    private JFrame frame;

    private BufferedImage image;

    protected String[] nombreCiudades;
    protected int[] codigoCiudades;

    protected String[] nombreCargos;
    protected int[] codigoCargos;

    static protected ArrayList<Ciudad> ciudades;

    static protected ArrayList<Cargo> cargos;

    final Color colorBackgroundDefectoBotonAceptar;

    final Color colorBackgroundDefectoBotonReiniciar;

    static protected ArrayList<Pais> paises;
    protected String[] paisesLegibles2;
    protected String[] codigoPaises2;

    private String[] cabezera = { "Clave", "Codigo", "Nombre", "     ", "      " };
    private String[][] informacion;

    int codigoCiudad = 0;
    int codigoCargo = 0;
    String selectedPais = "";

    boolean cuadroTextoVacioCodigo = true;
    boolean listPaisObligatorio = true;

    public BuscarFabricantes(String[] paisesLegibles, String[] codigoPaises) {
        frame = new JFrame("Buscar Fabricantes");
        frame.setBounds(100, 100, 663, 432);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        informacion = new String[][] { { "", "", "", "", "" }, { "", "", "", "", "" }, { "", "", "", "", "" },
                { "", "", "", "", "" }, { "", "", "", "", "" }, { "", "", "", "", "" }, { "", "", "", "", "" },
                { "", "", "", "", "" } };

        JPanel panel = new JPanel();
        frame.getContentPane().add(panel, BorderLayout.CENTER);
        panel.setLayout(null);

        CustomLabel etiquetaFormularioAltaEmpleado = new CustomLabel("Formulario de alta de empleado", false);
        etiquetaFormularioAltaEmpleado.setBounds(10, 11, 163, 35);
        panel.add(etiquetaFormularioAltaEmpleado);

        DefaultTableModel mod = new DefaultTableModel(informacion, cabezera);
        JTable tabla = new JTable(mod);

        JScrollPane scroll = new JScrollPane(tabla);
        scroll.setBounds(10, 38, 598, 116);

        panel.add(scroll);

        EtiquetaTextFieldJuntos codigo = new EtiquetaTextFieldJuntos(true, "Codigo");
        codigo.setBoundsLabel(20, 167, 163, 28);
        codigo.setBoundsTextField(36, 190, 109, 20);
        codigo.setBoundsFotoError(100, 221, 39, 34);
        codigo.anadirPanel(panel);

        EtiquetaTextFieldJuntos nombre = new EtiquetaTextFieldJuntos(false, "Nombre");
        nombre.setBoundsLabel(168, 164, 70, 35);
        nombre.setBoundsTextField(168, 190, 109, 20);
        nombre.anadirPanel(panel);

        ciudades = Cargar.Ciudades();

        nombreCiudades = new String[ciudades.size()];
        codigoCiudades = new int[ciudades.size()];
        for (int pos = 0; pos < ciudades.size(); pos++) {
            nombreCiudades[pos] = ciudades.get(pos).getNombre();
            codigoCiudades[pos] = ciudades.get(pos).getCodPais();

        }

        cargos = Cargar.Cargos();

        nombreCargos = new String[cargos.size()];
        codigoCargos = new int[cargos.size()];
        for (int pos = 0; pos < cargos.size(); pos++) {
            nombreCargos[pos] = cargos.get(pos).getNombre();
            codigoCargos[pos] = cargos.get(pos).getCodigo();
        }

        CustomBoton botonAceptar = new CustomBoton("Aceptar");
        colorBackgroundDefectoBotonAceptar = botonAceptar.getBackground();
        botonAceptar.setBounds(168, 302, 89, 23);
        panel.add(botonAceptar);

        CustomBoton botonReiniciar = new CustomBoton("Reiniciar");
        colorBackgroundDefectoBotonReiniciar = botonReiniciar.getBackground();
        botonReiniciar.setBounds(318, 302, 89, 23);
        panel.add(botonReiniciar);

        CustomRadioButton radioButtonActivo = new CustomRadioButton("ACTIVO");
        radioButtonActivo.setBounds(515, 170, 109, 23);
        panel.add(radioButtonActivo);

        CustomRadioButton radioButtonNoActivo = new CustomRadioButton("NO ACTIVO");
        radioButtonNoActivo.setBounds(515, 207, 109, 23);
        panel.add(radioButtonNoActivo);

        ButtonGroup grupo = new ButtonGroup();
        grupo.add(radioButtonActivo);
        grupo.add(radioButtonNoActivo);

        DefaultListModel modelo = new DefaultListModel();
        for (String elem : paisesLegibles) {
            modelo.addElement(elem.toString());
        }

        JList listPaises = new JList();
        listPaises.setVisibleRowCount(4);
        listPaises.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listPaises.setModel(modelo);

        JScrollPane scrollLista = new JScrollPane(listPaises);
        panel.add(scrollLista);
        scrollLista.setBounds(299, 192, 177, 101);
        scrollLista.setViewportView(listPaises);

        CustomLabel label = new CustomLabel("", false);
        label.setBounds(336, 277, 49, 14);
        panel.add(label);

        CustomLabel etiquetaFotoErrorPais = new CustomLabel("", false);
        CustomLabel etiquetaFotoErrorCodigo = new CustomLabel("", false);
        image = null;

        try {
            image = ImageIO.read(getClass().getResource("/FotoError.jpeg"));
            ImageIcon imagenLogo = new ImageIcon(image.getScaledInstance(39, 34, Image.SCALE_SMOOTH));
            etiquetaFotoErrorCodigo.setIcon(imagenLogo);
            etiquetaFotoErrorPais.setIcon(imagenLogo);
        } catch (IOException e) {
        }

        etiquetaFotoErrorPais.setBounds(486, 257, 39, 34);
        panel.add(etiquetaFotoErrorPais);

        etiquetaFotoErrorPais.setVisible(false);
        etiquetaFotoErrorCodigo.setVisible(false);

        CustomLabel etiquetaPais = new CustomLabel("*Pais", listPaisObligatorio);
        etiquetaPais.setBounds(296, 165, 163, 28);
        panel.add(etiquetaPais);

        JButton botonMenuPrincipal = new JButton("MENU PRINCIPAL");
        botonMenuPrincipal.setForeground(Color.RED);
        botonMenuPrincipal.setBounds(10, 346, 127, 36);
        panel.add(botonMenuPrincipal);

        botonMenuPrincipal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                new MenuPrincipal(paisesLegibles, codigoPaises);

            }
        });

        listPaises.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if ((String) listPaises.getSelectedValue() != null) {
                    selectedPais = (String) listPaises.getSelectedValue();
                    label.setText(selectedPais);
                }
            }
        });

        botonAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean empleadoEncontrado = false;
                if (!(codigo.getCampoTexto().equals("")) && !(selectedPais.equals(""))) {
                    String claveConfirmar = "";
                    String codigoConfirmar = "";
                    String nombreConfirmar = "";
                    for (Empleado elem : Cargar.Empleados()) {
                        int intCodigo = Integer.parseInt(codigo.getCampoTexto().toString());
                        if (intCodigo == elem.getCodigo()) {
                            codigoConfirmar = codigo.getCampoTexto();
                            nombreConfirmar = elem.getNombre();
                            claveConfirmar = "Ninguna";
                        }

                    }

                    boolean puestoEnTabla = false;
                    for (int i = 0; i < 7; i++) {
                        for (int j = 0; j < 5; j++) {
                            if (tabla.getValueAt(i, 0).equals("")) {
                                informacion[i][0] = claveConfirmar;
                                informacion[i][1] = codigoConfirmar;
                                informacion[i][2] = nombreConfirmar;
                                tabla.setValueAt(informacion[i][0], i, 0);
                                tabla.setValueAt(informacion[i][1], i, 1);
                                tabla.setValueAt(informacion[i][2], i, 2);
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

                if (!(empleadoEncontrado)) {
                    JOptionPane.showMessageDialog(null, "Empleado no encontrado", "", JOptionPane.ERROR_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Introduce un codigo y un pais",
                            "WARNING_MESSAGE", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        listPaises.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
                e.getComponent().setBackground(Color.RED);
            }

            public void focusLost(FocusEvent e) {
                if (!(label.getText().equals(""))) {
                    listPaisObligatorio = false;
                    etiquetaPais.setForeground(Color.BLACK);
                    etiquetaFotoErrorPais.setVisible(false);
                } else {
                    etiquetaFotoErrorPais.setVisible(true);
                    etiquetaPais.setForeground(Color.RED);
                    listPaisObligatorio = true;
                }
            }
        });

        botonAceptar.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
                e.getComponent().setBackground(Color.RED);
            }

            public void focusLost(FocusEvent e) {
                e.getComponent().setBackground(colorBackgroundDefectoBotonAceptar);
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