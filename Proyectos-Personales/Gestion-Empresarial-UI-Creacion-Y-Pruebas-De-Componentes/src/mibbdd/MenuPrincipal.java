package mibbdd;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import javax.swing.JButton;

public class MenuPrincipal {

    private JFrame frame;

    public MenuPrincipal(String[] paisesLegibles, String[] codigoPaises) {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.getContentPane().add(panel, BorderLayout.CENTER);
        panel.setLayout(null);

        JLabel lblNewLabel = new JLabel("MENU PRINCIPAL");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 35));
        lblNewLabel.setBounds(10, 11, 400, 112);
        panel.add(lblNewLabel);

        JButton botonAltaEmpleado = new JButton("<html>Alta de un Empleado<hmtl>");
        botonAltaEmpleado.setHorizontalAlignment(SwingConstants.TRAILING);
        botonAltaEmpleado.setBounds(20, 180, 96, 41);
        panel.add(botonAltaEmpleado);

        JButton botonBuscarEmpleado = new JButton("<html>Buscar empleado<html>");
        botonBuscarEmpleado.setHorizontalAlignment(SwingConstants.LEADING);
        botonBuscarEmpleado.setBounds(163, 178, 89, 45);
        panel.add(botonBuscarEmpleado);

        JButton botonBuscarFabricantes = new JButton("<html>Buscar fabricantes<html>");
        botonBuscarFabricantes.setHorizontalAlignment(SwingConstants.LEADING);
        botonBuscarFabricantes.setBounds(302, 178, 89, 45);
        panel.add(botonBuscarFabricantes);

        botonAltaEmpleado.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                new AltaDeUnEmpleado(paisesLegibles, codigoPaises);
            }
        });

        botonBuscarEmpleado.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                new BuscarEmpleados(paisesLegibles, codigoPaises);
            }
        });

        botonBuscarFabricantes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                new BuscarFabricantes(paisesLegibles, codigoPaises);
            }
        });

        frame.setVisible(true);

    }

}
