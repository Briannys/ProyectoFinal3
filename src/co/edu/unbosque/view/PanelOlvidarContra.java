package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;

public class PanelOlvidarContra extends JPanel{
	private JLabel[] olvidarContra;
	private JButton verificar;
	private JButton atras;
	private JTextArea campoUsuario;
	private JTextArea confirmarUser;
	public PanelOlvidarContra() {
		setLayout(null);
		setVisible(false);
		setBackground(Color.white);
		inicializarComponentes();
	}
	public void inicializarComponentes() {
		olvidarContra = new JLabel[5];
		inicializarLabels("Olvidaste Contraseña", 0, 140, 10, 290, 60);
		olvidarContra[0].setFont(new Font("Century Gothic", 0, 20));
		inicializarLabels("Correo", 1,60, 100, 100, 30);
		inicializarLabels("Confirmar Correo", 2, 60, 150, 140, 30);

		verificar = new JButton("Enviar Correo");
		verificar.setBounds(185,225,120,30);
		verificar.setActionCommand("VERI");
		verificar.setBackground(Color.green);
		add(verificar);
		
		campoUsuario = new JTextArea();
		campoUsuario.setBounds(220, 102, 200, 20);
		campoUsuario.setBorder(new LineBorder(Color.black));
		add(campoUsuario);
		
		confirmarUser = new JTextArea();
		confirmarUser.setBounds(220, 156, 200, 20);
		confirmarUser.setBorder(new LineBorder(Color.black));
		add(confirmarUser);
		
		atras = new JButton("Atras");
		atras.setBounds(400, 280, 70, 40);
		atras.setActionCommand("ATR-OLV");
		add(atras);
		
		devolverImagenLabel("correo", "png", 20, 20, 3,30, 32, 100, 170 );
		devolverImagenLabel("correo", "png", 20, 20, 4, 30, 80, 100, 170);
	}
	public void inicializarLabels(String tipoRegistro, int pos, int x, int y, int xB, int yB) {
			olvidarContra[pos]= new JLabel(tipoRegistro);
			olvidarContra[pos].setVisible(true);
			olvidarContra[pos].setBounds(x, y, xB, yB);
			olvidarContra[pos].setFont(new Font("Century Gothic", 1, 15));
			add(olvidarContra[pos]);
	}
	public void devolverImagenLabel(String src, String tipo, int escalax, int escalay, int b, int x, int y, int xB, int yB) {
		olvidarContra[b] = new JLabel();
		ImageIcon imagen1 = new ImageIcon(getClass().getResource("/imagenes/" + src + "." + tipo));
		ImageIcon icon = new ImageIcon(imagen1.getImage().getScaledInstance(escalax, escalay, Image.SCALE_DEFAULT));
		olvidarContra[b].setIcon(icon);
		olvidarContra[b].setBounds(x,y,xB,yB);
		add(olvidarContra[b]);
	}
	public void reiniciarPanel() {
		campoUsuario.setText(null);
		confirmarUser.setText(null);
	}
	/**
	 * @return the olvidarContra
	 */
	public JLabel[] getOlvidarContra() {
		return olvidarContra;
	}
	/**
	 * @param olvidarContra the olvidarContra to set
	 */
	public void setOlvidarContra(JLabel[] olvidarContra) {
		this.olvidarContra = olvidarContra;
	}
	/**
	 * @return the verificar
	 */
	public JButton getVerificar() {
		return verificar;
	}
	
	/**
	 * @return the atras
	 */
	public JButton getAtras() {
		return atras;
	}
	/**
	 * @param atras the atras to set
	 */
	public void setAtras(JButton atras) {
		this.atras = atras;
	}
	/**
	 * @param verificar the verificar to set
	 */
	public void setVerificar(JButton verificar) {
		this.verificar = verificar;
	}
	/**
	 * @return the campoUsuario
	 */
	public JTextArea getCampoUsuario() {
		return campoUsuario;
	}
	/**
	 * @param campoUsuario the campoUsuario to set
	 */
	public void setCampoUsuario(JTextArea campoUsuario) {
		this.campoUsuario = campoUsuario;
	}
	/**
	 * @return the confirmarUser
	 */
	public JTextArea getConfirmarUser() {
		return confirmarUser;
	}
	/**
	 * @param confirmarUser the confirmarUser to set
	 */
	public void setConfirmarUser(JTextArea confirmarUser) {
		this.confirmarUser = confirmarUser;
	}
	
}
