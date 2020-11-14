package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelPortada extends JPanel {

	private JLabel l1, l2, lbalo, lsupe, lfutbol;
	private JButton login, reg, baloto, astro, futbol;
	private JPanel inicio, juegos;

	public PanelPortada() {
		setLayout(null);
		setVisible(true);
		setBackground(Color.LIGHT_GRAY);
		inicializarComponentes();

	}

	private void inicializarComponentes() {

		inicio = new JPanel();
		inicio.setBounds(5, 5, 875, 100);
		inicio.setLayout(null);
		inicio.setBackground(Color.WHITE);
		inicio.setVisible(true);
		add(inicio);

		l2 = new JLabel();
		devolverImagenLabel("User", "gif", 40, 40, l2);
		l2.setBounds(460, 30, 40, 40);
		inicio.add(l2);

		login = new JButton(devolverImagenButton("login", "gif", 160, 30));
		login.setBackground(Color.WHITE);
		login.setRolloverIcon(devolverImagenButton("log1", "png", 160, 30));
		login.setBorder(null);
		login.setActionCommand("INICIARSESION");
		login.setBounds(520, 35, 160, 30);
		inicio.add(login);

		reg = new JButton(devolverImagenButton("reg", "gif", 160, 30));
		reg.setBackground(Color.WHITE);
		reg.setBorderPainted(false);
		reg.setRolloverIcon(devolverImagenButton("registro", "png", 160, 30));
		reg.setActionCommand("REGISTRARSE");
		reg.setBounds(700, 35, 160, 30);
		inicio.add(reg);

		l1 = new JLabel();
		devolverImagenLabel("HOUSEBEAT", "png", 160, 80, l1);
		l1.setBounds(10, 15, 160, 80);
		inicio.add(l1);
		
		
		juegos = new JPanel();
		juegos.setBounds(5,113, 875, 545);
		juegos.setLayout(null);
		juegos.setVisible(true);
		juegos.setBackground(new Color(3,6, 97));
		add(juegos);
		
		baloto = new JButton(devolverImagenButton("Baloto", "gif", 220, 300));
		baloto.setBounds(60, 100, 220, 300);
		baloto.setActionCommand("BALOTO");
		baloto.setBackground(Color.WHITE);
		juegos.add(baloto);

		lbalo = new JLabel("Baloto");
		lbalo.setFont(new Font("Century Gothic", Font.PLAIN, 30));
		lbalo.setForeground(Color.WHITE);
		lbalo.setBounds(110, 60, 220, 40);
		juegos.add(lbalo);

		astro = new JButton(devolverImagenButton("super", "gif", 220, 300));
		astro.setBackground(Color.WHITE);
		astro.setActionCommand("SUPERASTRO");
		astro.setBounds(330, 100, 220, 300);
		juegos.add(astro);

		lsupe = new JLabel("Super Astro");
		lsupe.setFont(new Font("Century Gothic", Font.PLAIN, 30));
		lsupe.setForeground(Color.WHITE);
		lsupe.setBounds(360, 60, 220, 40);
		juegos.add(lsupe);

		futbol = new JButton(devolverImagenButton("futbol", "gif", 220, 300));
		futbol.setBackground(Color.WHITE);
		futbol.setActionCommand("FUTBOL");
		futbol.setBounds(600, 100, 220, 300);
		juegos.add(futbol);

		lfutbol = new JLabel("Marcadores");
		lfutbol.setBackground(Color.WHITE);
		lfutbol.setFont(new Font("Century Gothic", Font.PLAIN, 30));
		lfutbol.setForeground(Color.WHITE);
		lfutbol.setBounds(620, 60, 240, 40);
		juegos.add(lfutbol);
		
	}
	

	public void devolverImagenLabel(String src, String tipo, int escalax, int escalay, JLabel b) {
		ImageIcon imagen1 = new ImageIcon(getClass().getResource("/imagenes/" + src + "." + tipo));
		ImageIcon icon = new ImageIcon(imagen1.getImage().getScaledInstance(escalax, escalay, Image.SCALE_DEFAULT));
		b.setIcon(icon);
	}

	public ImageIcon devolverImagenButton(String src, String tipo, int escalax, int escalay) {
		ImageIcon imagen1 = new ImageIcon(getClass().getResource("/imagenes/" + src + "." + tipo));
		ImageIcon icon = new ImageIcon(imagen1.getImage().getScaledInstance(escalax, escalay, Image.SCALE_DEFAULT));
		return icon;
	}

	public JLabel getL1() {
		return l1;
	}

	public void setL1(JLabel l1) {
		this.l1 = l1;
	}

	public JLabel getL2() {
		return l2;
	}

	public void setL2(JLabel l2) {
		this.l2 = l2;
	}

	public JLabel getLbalo() {
		return lbalo;
	}

	public void setLbalo(JLabel lbalo) {
		this.lbalo = lbalo;
	}

	public JLabel getLsupe() {
		return lsupe;
	}

	public void setLsupe(JLabel lsupe) {
		this.lsupe = lsupe;
	}

	public JLabel getLfutbol() {
		return lfutbol;
	}

	public void setLfutbol(JLabel lfutbol) {
		this.lfutbol = lfutbol;
	}

	public JButton getLogin() {
		return login;
	}

	public void setLogin(JButton login) {
		this.login = login;
	}

	public JButton getReg() {
		return reg;
	}

	public void setReg(JButton reg) {
		this.reg = reg;
	}

	public JButton getBaloto() {
		return baloto;
	}

	public void setBaloto(JButton baloto) {
		this.baloto = baloto;
	}

	public JButton getAstro() {
		return astro;
	}

	public void setAstro(JButton astro) {
		this.astro = astro;
	}

	public JButton getFutbol() {
		return futbol;
	}

	public void setFutbol(JButton futbol) {
		this.futbol = futbol;
	}

	public JPanel getInicio() {
		return inicio;
	}

	public void setInicio(JPanel inicio) {
		this.inicio = inicio;
	}

	public JPanel getJuegos() {
		return juegos;
	}

	public void setJuegos(JPanel juegos) {
		this.juegos = juegos;
	}
	
	
}