package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class PanelTamanio extends JPanel implements ChangeListener{
	private JSlider sliders[];
	private JLabel numeros[];
	private JLabel enumeracion[];
	private JLabel mensaje;
	private JButton continuar;
	String valores[] = new String[6];
	
	public PanelTamanio() {
		setLayout(null);
		iniciar();
		setVisible(true);
	}

	private void iniciar() {
		setSize(500, 800);
		setBackground(Color.blue);
		sliders = new JSlider[6];
		numeros = new JLabel[6];
		enumeracion = new JLabel[6];
		
		continuar = new JButton(devolverImagen("Jugar1", "png", 100, 60));
		continuar.setBounds(200, 700, 90, 50);
		continuar.setActionCommand("JUEGA");
		add(continuar);
		
		mensaje = new JLabel("Escoga los números de su boleta");
		mensaje.setBounds(70, 10, 350, 40);
		mensaje.setFont(new Font("Century Gothic",Font.BOLD,20));
		mensaje.setForeground(Color.white);
		mensaje.setBackground(null);
		add(mensaje);
		int cont = 1;
		int aux = 60;
		int aux2 = 130;
		for (int i = 0; i < sliders.length; i++) {
			enumeracion[i] = new JLabel(String.valueOf(cont));
			enumeracion[i].setBounds(30, aux+20, 40, 40);
			enumeracion[i].setFont(new Font("Century Gothic",Font.BOLD,30));
			enumeracion[i].setForeground(Color.red);
			add(enumeracion[i]);
			
			numeros[i] = new JLabel();
			numeros[i].setFont(new Font("Century Gothic",Font.BOLD,20));
			numeros[i].setBounds(240, aux2,30 , 30);
			numeros[i].setForeground(Color.yellow);
			add(numeros[i]);
			
			sliders[i] = new JSlider(JSlider.HORIZONTAL,1,45,21);
			sliders[i].setMajorTickSpacing(1);
			sliders[i].setPaintTicks(true);
			sliders[i].addChangeListener(this);
			sliders[i].setSnapToTicks(true);
			sliders[i].setMinorTickSpacing(1);
			sliders[i].setForeground(Color.white);
			sliders[i].setBounds(110, aux, 280, 80);
			add(sliders[i]);
			aux+=100;
			aux2+=100;
			cont++;
		}
		
	}
	public Icon devolverImagen(String a, String tipo, int tam,int tam2) {
		ImageIcon im = new ImageIcon(getClass().getResource("/imagenes/"+a+"."+tipo));
		ImageIcon ic = new ImageIcon(im.getImage().getScaledInstance(tam, tam2, Image.SCALE_DEFAULT));
		return ic;
	}
	public JSlider devolverSlider(int i) {
		return sliders[i];
	}
	
	public String devolverNumero(int i) {
		return valores[i];
	}
	
	public void reiniciarSLiders() {
		for (int i = 0; i < enumeracion.length; i++) {
			sliders[i].setValue(21);
		}
	}
	@Override
	public void stateChanged(ChangeEvent e) {
		
		for (int i = 0; i < 6; i++) {
			valores[i] = String.valueOf(devolverSlider(i).getValue());
			numeros[i].setText(valores[i]);
		}
		
	}

	/**
	 * @return the sliders
	 */
	public JSlider[] getSliders() {
		return sliders;
	}

	/**
	 * @param sliders the sliders to set
	 */
	public void setSliders(JSlider[] sliders) {
		this.sliders = sliders;
	}

	/**
	 * @return the numeros
	 */
	public JLabel[] getNumeros() {
		return numeros;
	}

	/**
	 * @param numeros the numeros to set
	 */
	public void setNumeros(JLabel[] numeros) {
		this.numeros = numeros;
	}

	/**
	 * @return the enumeracion
	 */
	public JLabel[] getEnumeracion() {
		return enumeracion;
	}

	/**
	 * @param enumeracion the enumeracion to set
	 */
	public void setEnumeracion(JLabel[] enumeracion) {
		this.enumeracion = enumeracion;
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
	 * @return the continuar
	 */
	public JButton getContinuar() {
		return continuar;
	}

	/**
	 * @param continuar the continuar to set
	 */
	public void setContinuar(JButton continuar) {
		this.continuar = continuar;
	}
	
	

	
}
