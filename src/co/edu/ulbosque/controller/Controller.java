package co.edu.ulbosque.controller;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;

import co.edu.unbosque.view.VentanaPrincipal;

public class Controller implements ActionListener {
	private VentanaPrincipal vista;

	public Controller() {
		vista = new VentanaPrincipal();
		asignarOyentes();
	}
	public void asignarOyentes() {
		vista.getPanelInicioSesion().getReg().addActionListener(this);
		oyentesBotonesRegistro();
		vista.getPanelRegistro().devolverRadioButton(0).addActionListener(this);
		vista.getPanelRegistro().devolverRadioButton(1).addActionListener(this);
		vista.getPanelRegistro().devolverRadioButton(2).addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();

		if (command.equals("REGISTRARSE")) {
			cambiarPanel(vista.getPanelRegistro());
			vista.setSize(600,540);
			vista.setLocationRelativeTo(null);
		}else if (command.equals("CIUDADANIA")) {
			if (vista.getPanelRegistro().devolverRadioButton(0).isSelected() == true) {
				vista.getPanelRegistro().devolverRadioButton(1).setEnabled(false);
				vista.getPanelRegistro().devolverRadioButton(2).setEnabled(false);
			}else {
				vista.getPanelRegistro().devolverRadioButton(1).setEnabled(true);
				vista.getPanelRegistro().devolverRadioButton(2).setEnabled(true);
			} 
		}else if (command.equals("EXTRANJERIA")) {
			if (vista.getPanelRegistro().devolverRadioButton(1).isSelected() == true) {
				vista.getPanelRegistro().devolverRadioButton(0).setEnabled(false);
				vista.getPanelRegistro().devolverRadioButton(2).setEnabled(false);
			}else {
				vista.getPanelRegistro().devolverRadioButton(0).setEnabled(true);
				vista.getPanelRegistro().devolverRadioButton(2).setEnabled(true);
			}
		}else if (command.equals("PASAPORTE")) {
			if (vista.getPanelRegistro().devolverRadioButton(2).isSelected() == true) {
				vista.getPanelRegistro().devolverRadioButton(0).setEnabled(false);
				vista.getPanelRegistro().devolverRadioButton(1).setEnabled(false);
			}else {
				vista.getPanelRegistro().devolverRadioButton(0).setEnabled(true);
				vista.getPanelRegistro().devolverRadioButton(1).setEnabled(true);
			}
		if (command.equals("INICIARSESION")) {

			System.out.println(command);


		} else if (command.equals("BALOTO")) {

			vista.getPanelInicioSesion().setVisible(false);

		} else if (command.equals("SUPERASTRO")) {

			vista.getPanelInicioSesion().setVisible(false);

		} else if (command.equals("FUTBOL")) {

			vista.getPanelInicioSesion().setVisible(false);

		}
		}
	}
	public void oyentesBotonesRegistro() {
		for (int i = 0; i < 2; i++) {
			vista.getPanelRegistro().devolverBoton(i).addActionListener(this);
		}
	}
	public void cambiarPanel(Component panel) {
		vista.getContentPane().removeAll();
		vista.getContentPane().add(panel);
		panel.setVisible(true);
		vista.getContentPane().repaint();
	}
	public void tamañoVentanas(int x, int y) {
		vista.setSize(x , y);
		vista.setLocationRelativeTo(null);
	}
}
