package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class PanelMaquina extends JPanel{
	private JLabel nube;
	private JLabel imagen;
	private JLabel dealer;
	private JLabel mensaje;
	private String mensajes[] = {"Mala suerte","Mal tiro","Super F","Perdiste","He visto mejores",
		"Nada que hacer","Malisimo","Ya retirate","Chao dinero"};
	
	public PanelMaquina() {
		setLayout(null);
		iniciar();
		setVisible(true);
		
		
	}

	private void iniciar() {
		setSize(450, 500);
		setBackground(Color.white);
		imagen = new JLabel(devolverImagen("MaquinaB", "png", 260, 400));
		imagen.setBounds(190, 40, 260, 400);
		add(imagen);
		
		mensaje = new JLabel("");
		mensaje.setBounds(50, 90, 150, 100);
		mensaje.setBackground(null);
		mensaje.setForeground(Color.black);
		add(mensaje);
		
		dealer = new JLabel(devolverImagen("Dealer", "png", 190, 240));
		dealer.setBounds(0, 270, 190, 240);
		add(dealer);
		
		nube = new JLabel(devolverImagen("nube", "png", 210, 300));
		nube.setBounds(0, 0, 210, 300);
		add(nube);
		
		
	}
	public void generarMensajeAleatorio() {
		int numero = (int)Math.floor(Math.random()*9);
		mensaje.setText(mensajes[numero]);
	}

	public Icon devolverImagen(String a, String tipo, int tam,int tam2) {
		ImageIcon im = new ImageIcon(getClass().getResource("/imagenes/"+a+"."+tipo));
		ImageIcon ic = new ImageIcon(im.getImage().getScaledInstance(tam, tam2, Image.SCALE_DEFAULT));
		return ic;
	}

	/**
	 * @return the nube
	 */
	public JLabel getNube() {
		return nube;
	}

	/**
	 * @param nube the nube to set
	 */
	public void setNube(JLabel nube) {
		this.nube = nube;
	}

	/**
	 * @return the imagen
	 */
	public JLabel getImagen() {
		return imagen;
	}

	/**
	 * @param imagen the imagen to set
	 */
	public void setImagen(JLabel imagen) {
		this.imagen = imagen;
	}

	/**
	 * @return the dealer
	 */
	public JLabel getDealer() {
		return dealer;
	}

	/**
	 * @param dealer the dealer to set
	 */
	public void setDealer(JLabel dealer) {
		this.dealer = dealer;
	}

	/**
	 * @return the mensaje
	 */
	public JLabel getMensaje() {
		return mensaje;
	}

	/**
	 * @param mensaje the mensaje to set
	 */
	public void setMensaje(JLabel mensaje) {
		this.mensaje = mensaje;
	}

	/**
	 * @return the mensajes
	 */
	public String[] getMensajes() {
		return mensajes;
	}

	/**
	 * @param mensajes the mensajes to set
	 */
	public void setMensajes(String[] mensajes) {
		this.mensajes = mensajes;
	}

}
