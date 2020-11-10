package co.edu.unbosque.view;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import co.edu.ulbosque.controller.Controller;

public class PanelRegistro extends JFrame {
	private static final long serialVersionUID = 8930572727988761228L;

	public PanelRegistro(Controller controller) {
		setTitle("Registro de Usuarios");
		setSize(600, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		panelRegistro(controller);

	}

	public JPanel panelRegistro(Controller controller) {
		setLayout(new BorderLayout());

		JPanel contenerPanel = new JPanel();
		
		JLabel panelTitle = new JLabel("<html><h1>Registro</h1></html>", SwingConstants.CENTER);
		add(panelTitle, BorderLayout.NORTH);
		contenerPanel.add(panelTitle);

		
		JButton aceptarRegistro = new JButton("Registrar");
		aceptarRegistro.setActionCommand("ACEPTAR_REGISTRO");
		aceptarRegistro.addActionListener(controller);
		contenerPanel.add(aceptarRegistro);
		
		JButton cancelarRegistro = new JButton("Cancelar");
		cancelarRegistro.setActionCommand("CANCELAR_REGISTRO");
		cancelarRegistro.addActionListener(controller);
		contenerPanel.add(cancelarRegistro);

		add(contenerPanel, BorderLayout.CENTER);
		setVisible(true);
		return contenerPanel;
	}

}
