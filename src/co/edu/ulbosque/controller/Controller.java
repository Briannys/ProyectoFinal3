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
		vista.getPanelIniciarSesion().getOlvidarContra().addActionListener(this);
		vista.getPanelIniciarSesion().getRegistrar().addActionListener(this);
		vista.getPanelRegistro().getIniciarSesion().addActionListener(this);
		vista.getPanelInicioSesion().getLogin().addActionListener(this);
		vista.getPanelInicioSesion().getReg().addActionListener(this);
		vista.getPanelInicioSesion().getAstro().addActionListener(this);
		vista.getPanelInicioSesion().getFutbol().addActionListener(this);
		vista.getPanelInicioSesion().getBaloto().addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();

		if (command.equals("REGISTRARSE")) {
			cambiarPanel(vista.getPanelRegistro());
			tamanoVentanas(600, 650);
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
			}else if (command.equals("OLVIDARCONTRA")) {
				tamanoVentanas(500, 350);
				cambiarPanel(vista.getPanelOlvidarContra());
			}else if (command.equals("REGISTRATE")) {
				tamanoVentanas(600, 650);
				cambiarPanel(vista.getPanelRegistro());
			}else if (command.equals("INICIARSESIONREGISTRAR")) {
				tamanoVentanas(500, 350);
				cambiarPanel(vista.getPanelIniciarSesion());
			}else if (command.equals("INICIARSESION")) {
			System.out.println(command);
			tamanoVentanas(500, 350);
			cambiarPanel(vista.getPanelIniciarSesion());
		} else if (command.equals("BALOTO")) {

			vista.getPanelInicioSesion().setVisible(false);

		} else if (command.equals("SUPERASTRO")) {

			vista.getPanelInicioSesion().setVisible(false);

		} else if (command.equals("FUTBOL")) {
			vista.getPanelInicioSesion().setVisible(false);

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
	public void tamanoVentanas(int x, int y) {
		vista.setSize(x, y);
		vista.setLocationRelativeTo(null);
	}
}
