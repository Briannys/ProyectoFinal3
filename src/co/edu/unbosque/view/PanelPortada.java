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
		inicializarBotones("INICIARSESION", 0, 120, 240, 178, 40,"/imagenes/Login.png", "/imagenes/Login1.png");
		inicializarBotones("REGISTRAR", 1, 320, 240, 154, 40, "/imagenes/reg.png" , "/imagenes/reg1.png" );
		
		personaLogo = new JLabel();
		devolverImagenLabel("logo", "gif", 200, 200, personaLogo);
		personaLogo.setBounds(200,70,200,200);
		add(personaLogo);
	}
	public void inicializarBotones(String command, int i, int x, int y, int xB, int yB, String ruta , String ruta1 ) {
		botones[i]= new JButton();
		//botones[i].setContentAreaFilled(false);
		botones[i].setBorder(null);
		botones[i].setBackground(Color.BLACK);
		botones[i].setIcon(new ImageIcon(getClass().getResource(ruta)));
		botones[i].setRolloverIcon(new ImageIcon (getClass().getResource(ruta1)));
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
	public JButton devolverBoton(int i) {
		  return botones[i];
	}
	/**
	 * @return el botones
	 */
	public JButton[] getBotones() {
		return botones;
	}
	/**
	 * @param botones el botones a establecer
	 */
	public void setBotones(JButton[] botones) {
		this.botones = botones;
	}
	/**
	 * @return el personaLogo
	 */
	public JLabel getPersonaLogo() {
		return personaLogo;
	}
	/**
	 * @param personaLogo el personaLogo a establecer
	 */
	public void setPersonaLogo(JLabel personaLogo) {
		this.personaLogo = personaLogo;
	}
}
