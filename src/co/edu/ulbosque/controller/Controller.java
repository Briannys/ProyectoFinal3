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
		vista.getPanelPortada().devolverBoton(0).addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		if (command.equals("INICIARSESION")) {
			System.out.println(command);
			vista.getPanelRegistro().setVisible(true);		
		}
	}
}
