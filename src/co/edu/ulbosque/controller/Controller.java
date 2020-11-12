package co.edu.ulbosque.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import co.edu.unbosque.view.VentanaPrincipal;

public class Controller implements ActionListener {
	private VentanaPrincipal vista;

	public Controller() {
		vista = new VentanaPrincipal();
		asignarOyentes();
	}

	public void asignarOyentes() {

		vista.getPanelInicioSesion().getLogin().addActionListener(this);
		vista.getPanelInicioSesion().getReg().addActionListener(this);
		vista.getPanelInicioSesion().getAstro().addActionListener(this);
		vista.getPanelInicioSesion().getFutbol().addActionListener(this);
		vista.getPanelInicioSesion().getBaloto().addActionListener(this);

	}

	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		if (command.equals("INICIARSESION")) {

			System.out.println(command);

		} else if (command.equals("REGISTRARSE")) {

			System.out.println(command);

		}
	}
}
