package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelDecisionAdminUser extends JPanel {
	private JLabel texto;
	private JLabel texto2;
	private JButton user;
	private JButton admin;
	public PanelDecisionAdminUser() {
		setLayout(null);
		setVisible(true);
		setBackground(Color.white);
		inicializarComponentes();
	}
	public void inicializarComponentes() {
		user = new JButton();
		ImageIcon im = new ImageIcon(getClass().getResource("/imagenes/adminD.png"));
		ImageIcon icono = new ImageIcon(im.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT));
		user.setIcon(icono);
		user.setBounds(40,70,200,200);
		user.setActionCommand("ADMIND");
		add(user);
		
		admin = new JButton();
		ImageIcon im1 = new ImageIcon(getClass().getResource("/imagenes/userD.png"));
		ImageIcon icono1 = new ImageIcon(im1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT));
		admin.setIcon(icono1);
		admin.setBounds(290,70,200,200);
		admin.setActionCommand("USERD");
		add(admin);
		
		texto = new JLabel("Administrador");
		texto.setBounds(85,270,200,40);
		texto.setFont(new Font("Century Gothic", 0, 16));
		add(texto);
		
		texto2 = new JLabel("Usuario");
		texto2.setBounds(355,270,200,40);
		texto2.setFont(new Font("Century Gothic", 0, 16));
		add(texto2);
	}
	/**
	 * @return el texto
	 */
	public JLabel getTexto() {
		return texto;
	}
	/**
	 * @param texto el texto a establecer
	 */
	public void setTexto(JLabel texto) {
		this.texto = texto;
	}
	/**
	 * @return el texto2
	 */
	public JLabel getTexto2() {
		return texto2;
	}
	/**
	 * @param texto2 el texto2 a establecer
	 */
	public void setTexto2(JLabel texto2) {
		this.texto2 = texto2;
	}
	/**
	 * @return el user
	 */
	public JButton getUser() {
		return user;
	}
	/**
	 * @param user el user a establecer
	 */
	public void setUser(JButton user) {
		this.user = user;
	}
	/**
	 * @return el admin
	 */
	public JButton getAdmin() {
		return admin;
	}
	/**
	 * @param admin el admin a establecer
	 */
	public void setAdmin(JButton admin) {
		this.admin = admin;
	}
}
