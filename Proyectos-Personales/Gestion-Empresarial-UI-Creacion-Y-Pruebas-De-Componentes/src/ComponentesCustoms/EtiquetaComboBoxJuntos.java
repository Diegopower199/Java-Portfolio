package ComponentesCustoms;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.Serializable;
import java.util.EventListener;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class EtiquetaComboBoxJuntos implements Serializable, EventListener {
    private CustomComboBox comboBoxUnido;
    private CustomComboBox comboBox_Codigo;
    private CustomLabel labelUnido;

    final Color colorBackgroundDefecto;

    boolean cuadroTextoVacioApellido;
    private CustomLabel etiquetaFotoError;

    private BufferedImage image;

    private CustomCampoTexto itemSeleccionado;
    private String nombreItem;
    private int codigoSeleccionado;

    public EtiquetaComboBoxJuntos(String[] comboBoxCualquiera, int[] arrayCodigo) {
        comboBoxUnido = new CustomComboBox();
        comboBox_Codigo = new CustomComboBox();
        labelUnido = new CustomLabel();
        etiquetaFotoError = new CustomLabel();
        itemSeleccionado = new CustomCampoTexto();

        comboBoxUnido.addItem("Elija un cargo");

        for (int i = 0; i < comboBoxCualquiera.length; i++) {
            comboBoxUnido.addItem(comboBoxCualquiera[i]);
        }

        colorBackgroundDefecto = comboBoxUnido.getBackground();

        image = null;

        try {
            image = ImageIO.read(getClass().getResource("/FotoError.jpeg"));
            ImageIcon imagenLogo = new ImageIcon(image.getScaledInstance(39, 34, Image.SCALE_SMOOTH));
            etiquetaFotoError.setIcon(imagenLogo);
        } catch (IOException e) {
        }

        etiquetaFotoError.setVisible(false);

        comboBoxUnido.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                itemSeleccionado.setText(comboBoxUnido.getSelectedItem().toString());
                for (int pos = 0; pos < comboBoxCualquiera.length; pos++) {
                    if (comboBoxUnido.getSelectedItem().toString().equals(comboBoxCualquiera[pos])) {
                        setCodigo(arrayCodigo[pos]);
                        nombreItem = comboBoxUnido.getSelectedItem().toString();
                    }
                }
            }
        });

        comboBoxUnido.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
                e.getComponent().setBackground(Color.RED);
            }

            public void focusLost(FocusEvent e) {
                if (!(itemSeleccionado.getText().equals(""))
                        && !(itemSeleccionado.getText().equals("Elija un cargo"))) {
                    labelUnido.setForeground(Color.BLACK);
                    etiquetaFotoError.setVisible(false);
                } else {
                    labelUnido.setForeground(Color.RED);
                    etiquetaFotoError.setVisible(true);
                }
                e.getComponent().setBackground(colorBackgroundDefecto);
            }
        });
    }

    public void setLabel(String label) {
        labelUnido.setText(label);
    }

    public String getComboBox() {
        return nombreItem;
    }

    public void setCodigo(int codigo) {
        codigoSeleccionado = codigo;
    }

    public int getCodigo() {
        return codigoSeleccionado;
    }

    public void setBoundsLabel(int x, int y, int width, int height) {
        labelUnido.setBounds(x, y, width, height);
    }

    public void setBoundsComboBoxNombres(int x, int y, int width, int height) {
        comboBoxUnido.setBounds(x, y, width, height);
    }

    public void setBoundsComboBoxCodigo(int x, int y, int width, int height) {
        comboBox_Codigo.setBounds(x, y, width, height);
    }

    public void anadirPanel(JPanel panel) {
        panel.add(labelUnido);
        panel.add(comboBoxUnido);
        panel.add(etiquetaFotoError);
    }

    public void setBoundsFotoError(int x, int y, int width, int height) {
        etiquetaFotoError.setBounds(x, y, width, height);
    }
}