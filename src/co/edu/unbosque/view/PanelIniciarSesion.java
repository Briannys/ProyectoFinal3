package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.font.TextAttribute;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;

public class PanelIniciarSesion extends JPanel {
	private JButton olvidarContra;
	private JLabel[] registros;
	private JTextArea camposRegistro;
	private JPasswordField contrasena;
	private JButton ingresar;
	private JButton registrar;
	private JButton atras;
	public PanelIniciarSesion() {
		setLayout(null);
		setVisible(false);
		setBackground(Color.white);
		inicializarComponentes();
	}
	public void inicializarComponentes() {
		registros = new JLabel[4];
		inicializarLabels("Usuario", 0, 60, 100, 100, 30);
		inicializarLabels("Contraseña", 1, 60, 150, 100, 30);
		inicializarLabels("Iniciar Sesión", 2, 180, 10, 290, 60);
		registros[2].setFont(new Font("Century Gothic", 0, 20));
		inicializarLabels("¿Aún no tienes cuenta?", 3, 155, 275, 130, 30);
		registros[3].setFont(new Font("Century Gothic", 1, 11));
		devolverImagenLabel("user", "png", 20, 20, 2,30, 32, 100, 170 );
		devolverImagenLabel("contrasena", "png",20, 20, 3, 30, 80, 100, 170);
		
		atras = new JButton("Atras");
		atras.setBounds(400, 280, 60, 30);
		atras.setActionCommand("ATR-SESION");
		add(atras);
		
		camposRegistro = new JTextArea();
		camposRegistro.setBounds(220, 102, 200, 20);
		camposRegistro.setBorder(new LineBorder(Color.black));
		add(camposRegistro);
		
		contrasena = new JPasswordField();
		contrasena.setBounds(220, 156, 200, 20);
		contrasena.setBorder(new LineBorder(Color.black));
		add(contrasena);
		
		ingresar = new JButton("Ingresar");
		ingresar.setBounds(195,200, 100, 25);
		ingresar.setActionCommand("INGRESAR");
		ingresar.setBackground(Color.green);
		add(ingresar);
		
		olvidarContra = new JButton("<HTML><U>¿Olvidaste la contraseña?</U></HTML>");
		olvidarContra.setCursor(new Cursor(Cursor.HAND_CURSOR));
		olvidarContra.setBounds(120, 240, 250, 30);
		olvidarContra.setContentAreaFilled(false);
		olvidarContra.setBorder(null);
		olvidarContra.setActionCommand("OLVIDARCONTRA");
		add(olvidarContra);
		
		registrar = new JButton("<HTML><U>Registrate</U></HTML>");
		registrar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		registrar.setBounds(260,275,100,30);
		registrar.setFont(new Font("Century Gothic", 1, 11));
		registrar.setContentAreaFilled(false);
		registrar.setBorder(null);
		registrar.setActionCommand("REGISTRATE");
		add(registrar);
		
	}
	public void inicializarLabels(String tipoRegistro, int pos, int x, int y, int xB, int yB) {
		registros[pos]= new JLabel(tipoRegistro);
		registros[pos].setVisible(true);
		registros[pos].setBounds(x, y, xB, yB);
		registros[pos].setFont(new Font("Century Gothic", 1, 15));
		add(registros[pos]);
	}
	public void devolverImagenLabel(String src, String tipo, int escalax, int escalay, int b, int x, int y, int xB, int yB) {
		registros[b] = new JLabel();
		ImageIcon imagen1 = new ImageIcon(getClass().getResource("/imagenes/" + src + "." + tipo));
		ImageIcon icon = new ImageIcon(imagen1.getImage().getScaledInstance(escalax, escalay, Image.SCALE_DEFAULT));
		registros[b].setIcon(icon);
		registros[b].setBounds(x,y,xB,yB);
		add(registros[b]);
	}
	public void reiniciarTextos() {
		camposRegistro.setText(null);
		contrasena.setText(null);
	}
	/**
	 * @return el olvidarContra
	 */
	public JButton getOlvidarContra() {
		return olvidarContra;
	}
	/**
	 * @param olvidarContra el olvidarContra a establecer
	 */
	public void setOlvidarContra(JButton olvidarContra) {
		this.olvidarContra = olvidarContra;
	}
	/**
	 * @return el registros
	 */
	public JLabel[] getRegistros() {
		return registros;
	}
	/**
	 * @param registros el registros a establecer
	 */
	public void setRegistros(JLabel[] registros) {
		this.registros = registros;
	}
	/**
	 * @return el camposRegistro
	 */
	public JTextArea getCamposRegistro() {
		return camposRegistro;
	}
	/**
	 * @param camposRegistro el camposRegistro a establecer
	 */
	public void setCamposRegistro(JTextArea camposRegistro) {
		this.camposRegistro = camposRegistro;
	}
	/**
	 * @return el contrasena
	 */
	public JPasswordField getContrasena() {
		return contrasena;
	}
	/**
	 * @param contrasena el contrasena a establecer
	 */
	public void setContrasena(JPasswordField contrasena) {
		this.contrasena = contrasena;
	}
	/**
	 * @return el ingresar
	 */
	public JButton getIngresar() {
		return ingresar;
	}
	/**
	 * @param ingresar el ingresar a establecer
	 */
	public void setIngresar(JButton ingresar) {
		this.ingresar = ingresar;
	}
	/**
	 * @return el registrar
	 */
	public JButton getRegistrar() {
		return registrar;
	}
	/**
	 * @param registrar el registrar a establecer
	 */
	public void setRegistrar(JButton registrar) {
		this.registrar = registrar;
	}
	/**
	 * @return el atras
	 */
	public JButton getAtras() {
		return atras;
	}
	/**
	 * @param atras el atras a establecer
	 */
	public void setAtras(JButton atras) {
		this.atras = atras;
	}
}
