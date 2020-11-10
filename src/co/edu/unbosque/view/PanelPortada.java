package co.edu.unbosque.view;


import java.awt.Color;
import java.awt.Cursor;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelPortada extends JPanel {
	private JButton[] botones;
	private JLabel personaLogo;
	public PanelPortada() {
		setLayout(null);
		setVisible(true);
		setBackground(Color.black);
		inicializarComponentes();
	}
	public void inicializarComponentes() {
		botones = new JButton[2];
		inicializarBotones("INICIARSESION", 0, 120, 240, 150, 40, "Iniciar Sesión");
		inicializarBotones("REGISTRAR", 1, 320, 240, 150, 40, "Registrarse");
		
		personaLogo = new JLabel();
		devolverImagenLabel("HouseApp", "png", 200, 200, personaLogo);
		personaLogo.setBounds(200,70,200,200);
		add(personaLogo);
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
	public void devolverImagenLabel(String src, String tipo, int escalax, int escalay, JLabel b) {
		ImageIcon imagen1 = new ImageIcon(getClass().getResource("/imagenes/" + src + "." + tipo));
		ImageIcon icon = new ImageIcon(imagen1.getImage().getScaledInstance(escalax, escalay, Image.SCALE_DEFAULT));
		b.setIcon(icon);
	}
}
