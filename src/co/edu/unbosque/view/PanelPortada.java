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
	private JLabel holix;

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
		devolverImagenLabel("house_beat_logo", "png", 160, 80, l1);
		l1.setBounds(10, 15, 160, 80);
		inicio.add(l1);

		juegos = new JPanel();
		juegos.setBounds(5, 113, 875, 545);
		juegos.setLayout(null);
		juegos.setVisible(true);
		juegos.setBackground(new Color(3, 6, 97));
		add(juegos);

		baloto = new JButton(devolverImagenButton("Baloto", "gif", 220, 300));
		baloto.setBounds(60, 100, 220, 300);
		baloto.setActionCommand("BALOTO");
		baloto.setEnabled(false);
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
		astro.setEnabled(false);
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
		futbol.setEnabled(false);
		futbol.setBounds(600, 100, 220, 300);
		juegos.add(futbol);

		lfutbol = new JLabel("Marcadores");
		lfutbol.setBackground(Color.WHITE);
		lfutbol.setFont(new Font("Century Gothic", Font.PLAIN, 30));
		lfutbol.setForeground(Color.WHITE);
		lfutbol.setBounds(620, 60, 240, 40);
		juegos.add(lfutbol);

		holix = new JLabel();
		holix.setVisible(false);
		holix.setForeground(new Color(3, 6, 97));
		holix.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		holix.setBounds(540, 35, 300, 30);
		inicio.add(holix);

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

	public void activarJuegos() {
		futbol.setEnabled(true);
		baloto.setEnabled(true);
		astro.setEnabled(true);
	}

	public void quitarInicioSesion(int a) {

		if (a == 1) {

			reg.setVisible(false);
			login.setVisible(false);
			holix.setVisible(true);
		} else {
			reg.setVisible(true);
			login.setVisible(true);
			holix.setVisible(false);

		}

	}

	public void setJuegos(JPanel juegos) {
		this.juegos = juegos;
	}

	/**
	 * @return the l1
	 */
	public JLabel getL1() {
		return l1;
	}

	/**
	 * @param l1 the l1 to set
	 */
	public void setL1(JLabel l1) {
		this.l1 = l1;
	}

	/**
	 * @return the l2
	 */
	public JLabel getL2() {
		return l2;
	}

	/**
	 * @param l2 the l2 to set
	 */
	public void setL2(JLabel l2) {
		this.l2 = l2;
	}

	/**
	 * @return the lbalo
	 */
	public JLabel getLbalo() {
		return lbalo;
	}

	/**
	 * @param lbalo the lbalo to set
	 */
	public void setLbalo(JLabel lbalo) {
		this.lbalo = lbalo;
	}

	/**
	 * @return the lsupe
	 */
	public JLabel getLsupe() {
		return lsupe;
	}

	/**
	 * @param lsupe the lsupe to set
	 */
	public void setLsupe(JLabel lsupe) {
		this.lsupe = lsupe;
	}

	/**
	 * @return the lfutbol
	 */
	public JLabel getLfutbol() {
		return lfutbol;
	}

	/**
	 * @param lfutbol the lfutbol to set
	 */
	public void setLfutbol(JLabel lfutbol) {
		this.lfutbol = lfutbol;
	}

	/**
	 * @return the login
	 */
	public JButton getLogin() {
		return login;
	}

	/**
	 * @param login the login to set
	 */
	public void setLogin(JButton login) {
		this.login = login;
	}

	/**
	 * @return the reg
	 */
	public JButton getReg() {
		return reg;
	}

	/**
	 * @param reg the reg to set
	 */
	public void setReg(JButton reg) {
		this.reg = reg;
	}

	/**
	 * @return the baloto
	 */
	public JButton getBaloto() {
		return baloto;
	}

	/**
	 * @param baloto the baloto to set
	 */
	public void setBaloto(JButton baloto) {
		this.baloto = baloto;
	}

	/**
	 * @return the astro
	 */
	public JButton getAstro() {
		return astro;
	}

	/**
	 * @param astro the astro to set
	 */
	public void setAstro(JButton astro) {
		this.astro = astro;
	}

	/**
	 * @return the futbol
	 */
	public JButton getFutbol() {
		return futbol;
	}

	/**
	 * @param futbol the futbol to set
	 */
	public void setFutbol(JButton futbol) {
		this.futbol = futbol;
	}

	/**
	 * @return the inicio
	 */
	public JPanel getInicio() {
		return inicio;
	}

	/**
	 * @param inicio the inicio to set
	 */
	public void setInicio(JPanel inicio) {
		this.inicio = inicio;
	}

	/**
	 * @return the juegos
	 */
	public JPanel getJuegos() {
		return juegos;
	}

	/**
	 * @return the holix
	 */
	public JLabel getHolix() {
		return holix;
	}

	/**
	 * @param holix the holix to set
	 */
	public void setHolix(JLabel holix) {
		this.holix = holix;
	}

}