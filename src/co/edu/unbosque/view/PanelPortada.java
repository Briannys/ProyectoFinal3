package co.edu.unbosque.view;


import java.awt.Cursor;

import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelPortada extends JPanel {
	private JButton[] botones;
	public PanelPortada() {
		setLayout(null);
		setVisible(true);
		inicializarComponentes();
	}
	public void inicializarComponentes() {
		botones = new JButton[2];
		inicializarBotones("INICIARSESION", 0, 0, 0, 40, 40, "Iniciar Sesión");
	}
	public void inicializarBotones(String command, int i, int x, int y, int xB, int yB, String nombre) {
		botones[i]= new JButton(nombre);
		//botones[i].setContentAreaFilled(false);
		//botones[i].setBorder(null);
		botones[i].setActionCommand(command);
		botones[i].setCursor(new Cursor(Cursor.HAND_CURSOR));
		botones[i].setBounds(x, y, xB, yB);
		add(botones[i]);
			
	}
}
