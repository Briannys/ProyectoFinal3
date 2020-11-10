package co.edu.unbosque.view;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;

public class VentanaPrincipal extends JFrame {
	private PanelPortada panelPortada;
	public VentanaPrincipal() {
		setTitle("Programa Objetos de la Casa");
		setSize(600, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setBackground(Color.red);
		getContentPane().setLayout(new BorderLayout(10,10));
		inicializarComponentes();
		setLocationRelativeTo(null);
		setVisible(true);
	}
	public void inicializarComponentes() {
	panelPortada = new PanelPortada();
	getContentPane().add(panelPortada);
	}
}
