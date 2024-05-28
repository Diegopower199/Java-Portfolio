package ComponentesCustoms;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.Serializable;
import java.util.EventListener;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class EtiquetaTextFieldJuntos implements Serializable, EventListener {
    private CustomCampoTexto campoTextoUnido;
    private CustomLabel labelUnido;

    final Color colorBackgroundDefecto;
    boolean cuadroTextoVacioApellido;
    private CustomLabel etiquetaFotoError;

    private BufferedImage image;

    public EtiquetaTextFieldJuntos(boolean obligatorio, String labelText) {
        campoTextoUnido = new CustomCampoTexto();
        labelUnido = new CustomLabel();
        etiquetaFotoError = new CustomLabel();

        if (obligatorio) {
            labelUnido.setText("*" + labelText);
            Font fuente = new Font(labelText, Font.BOLD, 12);
            labelUnido.setFont(fuente);
            labelUnido.setForeground(Color.BLACK);
        } else {
            labelUnido.setText(labelText);
            Font fuente = new Font(labelText, Font.PLAIN, 12);
            labelUnido.setFont(fuente);
        }

        colorBackgroundDefecto = campoTextoUnido.getBackground();

        image = null;

        try {
            image = ImageIO.read(getClass().getResource("/FotoError.jpeg"));
            ImageIcon imagenLogo = new ImageIcon(image.getScaledInstance(39, 34, Image.SCALE_SMOOTH));
            etiquetaFotoError.setIcon(imagenLogo);
        } catch (IOException e) {
        }

        etiquetaFotoError.setVisible(false);

        campoTextoUnido.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
                e.getComponent().setBackground(Color.GREEN);
            }

            public void focusLost(FocusEvent e) {
                if (!(campoTextoUnido.getText().equals(""))) {
                    cuadroTextoVacioApellido = false;
                    labelUnido.setForeground(Color.BLACK);
                    etiquetaFotoError.setVisible(false);
                } else {
                    etiquetaFotoError.setVisible(true);
                    labelUnido.setForeground(Color.RED);
                    cuadroTextoVacioApellido = true;
                }
                e.getComponent().setBackground(colorBackgroundDefecto);
            }
        });
    }

    public void setLabel(String label) {
        labelUnido.setText(label);
    }

    public String getCampoTexto() {
        return campoTextoUnido.getText();
    }

    public void setCampoTexto(String textField) {
        this.campoTextoUnido.setText(textField);
    }

    public void setBoundsLabel(int x, int y, int width, int height) {
        labelUnido.setBounds(x, y, width, height);
    }

    public void setBoundsTextField(int x, int y, int width, int height) {
        campoTextoUnido.setBounds(x, y, width, height);
    }

    public void anadirPanel(JPanel panel) {
        panel.add(labelUnido);
        panel.add(campoTextoUnido);
        panel.add(etiquetaFotoError);
    }

    public void setBoundsFotoError(int x, int y, int width, int height) {
        etiquetaFotoError.setBounds(x, y, width, height);
    }

}
