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
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class PanelPrincipal extends JPanel{
	private LaminaPelota panelPelota;
	private JButton lanzar;
	private JButton salir;
	private PanelMaquina panelMaquina;
	private JLabel imagen;
	private JLabel boleto;
	private JLabel numeros[];
	private JLabel numerosBoleta[];
	private String numerosUsuario[];
	private boolean botonEscogido[];
	private JLabel equis[];
	int numeroBaloto = 0;
	int cont = 1;
	int cont2 = 0;
	public PanelPrincipal() {
		setLayout(null);
		iniciar();
		setVisible(true);
		
		
	}

	private void iniciar() {
		setSize(1100, 700);
		//setBackground(new Color(93,107,108));
		setBackground(Color.black);
		
		int auxB = 42;
		botonEscogido = new boolean[6];
		equis = new JLabel[6];
		for (int i = 0; i < botonEscogido.length; i++) {
			botonEscogido[i] = false;
			equis[i] = new JLabel(devolverImagen("equisV", "png", 85, 85));
			equis[i].setVisible(false);
			if(i==3) {
				auxB = 42;
			}
			if(i<3) {
				equis[i].setBounds(auxB, 204, 85, 85);
			}else {
				equis[i].setBounds(auxB, 375, 85, 85);
			}
			add(equis[i]);
			auxB+=80;
		}
		
		
		numerosUsuario = new String[6];

		panelMaquina = new PanelMaquina();
		panelMaquina.setBounds(330, 10, 450, 500);
		add(panelMaquina);
		
		numerosBoleta = new JLabel[6];
		iniciarNumerosUsuario();
		
		boleto = new JLabel(devolverImagen("BALOTO", "png", 300, 500));
		boleto.setBounds(10, 10, 300, 500);
		add(boleto);
		
		
		panelPelota = new LaminaPelota();
		panelPelota.setBounds(780,10 , 300, 500);
		add(panelPelota);
		
		JPanel panelBotones = new JPanel();
		panelBotones.setBounds(10, 520, 1070, 150);
		panelBotones.setBorder(new LineBorder(Color.BLACK));
		panelBotones.setLayout(null);
		panelBotones.setBackground(new Color(252,230,9));

		//panelBotones.setBackground(new Color(22,90,187));
		add(panelBotones);
		
		lanzar = new JButton("Lanzar");
		lanzar.setBounds(750, 70, 140, 30);
		lanzar.setActionCommand("LAN");
		lanzar.setEnabled(true);
		panelBotones.add(lanzar);
		
		
		salir = new JButton("Salir");
		salir.setBounds(900, 70, 140, 30);
		salir.setActionCommand("SAL");
		panelBotones.add(salir);
		
		
		
		numeros = new JLabel[12];
		int aux = 30;
		for (int i = 0; i < 6; i++) {
			numeros[i]= new JLabel("", SwingConstants.CENTER);
			iniciarLabel(panelBotones, numeros[i], aux, 50, 60, 90,0);
			aux+=80;
		}
		int aux2 = 50;
		for (int i = 6; i < 12; i++) {
			numeros[i]= new JLabel("", SwingConstants.CENTER);
			iniciarLabel(panelBotones, numeros[i], aux2, 10, 20, 20,1);
			aux2+=80;
			cont++;
		}
		
	
		
		//panelBotones.add(boton);
		
	}
	
	public int numeroAciertos() {
		int num = 0;
		for (int i = 0; i < botonEscogido.length; i++) {
			if(botonEscogido[i]) {
				num++;
			}
		}
		return num;
	}
	
	public void reinciarEquis() {
		for (int i = 0; i < botonEscogido.length; i++) {
			botonEscogido[i] = false;
			equis[i].setVisible(false);
		}
	}
	public void marcarTiroAFavor() {
		String numero = panelPelota.getNumero().getText();
		for (int i = 0; i < botonEscogido.length; i++) {
			if(numero.equals(numerosBoleta[i].getText())&&!botonEscogido[i]){
				botonEscogido[i] = true;
				equis[i].setVisible(true);
				break;
			}
		}
	}
	
	public JLabel devolverNumBoleta(int i) {
		return numerosBoleta[i];
	}
	
	public void reiniciarBaloto() {
		for (int i = 0; i < numerosBoleta.length; i++) {
			numerosBoleta[i].setText(null);
			numerosUsuario[i] = "";
			numeros[i].setText(null);
		}
		panelMaquina.getMensaje().setText(null);
		panelPelota.getNumero().setVisible(false);
	}
	
	public void agregarNumeroUsuario(int i, String num) {
		numerosUsuario[i] = num;
	}

	public boolean comprobarNumeroEnBoleta() {
		for (int i = 0; i < numerosUsuario.length; i++) {
			System.out.println(numerosUsuario[i]);
			int num = Integer.parseInt(numerosUsuario[i]);
			if(num==numeroBaloto) {
				return true;
			}
		}
		return false;
	}
	//*46
	public void lanzarBola() {
		numeroBaloto = (int) Math.floor(Math.random()*3)+1;
		panelPelota.getNumero().setText(String.valueOf(numeroBaloto));
		
	}
	
	public void reinciarMarcadores() {
		cont2 = 0;
		for (int i = 0; i < numeros.length; i++) {
			numeros[i].setText(null);
		}
	}
	public void agregarMarcador() {
		numeros[cont2].setText(String.valueOf(numeroBaloto));
		if(cont2 == 5) {
			lanzar.setEnabled(false);
			cont2 = 0;
		}else {
			cont2++;
		}
		
	}
	
	public void generarBoleta() {
		for (int i = 0; i < 6; i++) {
			
		}
		panelPelota.getNumero().setVisible(true);
	}
	
	public void iniciarNumerosUsuario() {
		int x1 = 60, y1 = 220;
		int x2 = 60 , y2 = 390;
		for (int i = 0; i < 6; i++) {
			
			numerosBoleta[i] = new JLabel("", SwingConstants.CENTER);
			numerosBoleta[i].setFont(new Font("Century Gothic", Font.BOLD,20));
			numerosBoleta[i].setBackground(null);
			numerosBoleta[i].setForeground(Color.black);
			add(numerosBoleta[i]);
			if(i<=2) {
				numerosBoleta[i].setBounds(x1, y1, 35, 35);
				x1+=84;
			
			}else {
				numerosBoleta[i].setBounds(x2, y2, 35, 35);
				x2+=84;
			}
			
			
		}
	}
	
	
	public void cambiarTexto(int i, String numero) {
		numeros[i].setText(numero);
	}
	
	public void iniciarLabel(JPanel botones, JLabel label, int x, int y, int X, int Y, int dec) {
		
		label.setOpaque(true);
		label.setFont(new Font("Century Gothic", Font.BOLD,20));
		if(dec==0) {
			label.setBackground(Color.white);
			label.setForeground(Color.black);
			label.setBorder(new LineBorder(Color.black,5));
		}else {
			label.setBackground(null);
			label.setForeground(Color.black);
			label.setText(String.valueOf(cont));
			
		}
		
		label.setBounds(x, y, X, Y);
		
		botones.add(label);
	}
	
	public Icon devolverImagen(String a, String tipo, int tam,int tam2) {
		ImageIcon im = new ImageIcon(getClass().getResource("/imagenes/"+a+"."+tipo));
		ImageIcon ic = new ImageIcon(im.getImage().getScaledInstance(tam, tam2, Image.SCALE_DEFAULT));
		return ic;
	}

	/**
	 * @return the boton
	 */
	

	/**
	 * @return the crear
	 */
	

	/**
	 * @return the lanzar
	 */
	public JButton getLanzar() {
		return lanzar;
	}

	/**
	 * @return the numerosBoleta
	 */
	public JLabel[] getNumerosBoleta() {
		return numerosBoleta;
	}

	/**
	 * @param numerosBoleta the numerosBoleta to set
	 */
	public void setNumerosBoleta(JLabel[] numerosBoleta) {
		this.numerosBoleta = numerosBoleta;
	}

	/**
	 * @return the numerosUsuario
	 */
	public String[] getNumerosUsuario() {
		return numerosUsuario;
	}

	/**
	 * @param numerosUsuario the numerosUsuario to set
	 */
	public void setNumerosUsuario(String[] numerosUsuario) {
		this.numerosUsuario = numerosUsuario;
	}

	/**
	 * @return the numeroBaloto
	 */
	public int getNumeroBaloto() {
		return numeroBaloto;
	}

	/**
	 * @param numeroBaloto the numeroBaloto to set
	 */
	public void setNumeroBaloto(int numeroBaloto) {
		this.numeroBaloto = numeroBaloto;
	}

	/**
	 * @return the cont2
	 */
	public int getCont2() {
		return cont2;
	}

	/**
	 * @param cont2 the cont2 to set
	 */
	public void setCont2(int cont2) {
		this.cont2 = cont2;
	}

	/**
	 * @param lanzar the lanzar to set
	 */
	public void setLanzar(JButton lanzar) {
		this.lanzar = lanzar;
	}

	/**
	 * @return the salir
	 */
	public JButton getSalir() {
		return salir;
	}

	/**
	 * @param salir the salir to set
	 */
	public void setSalir(JButton salir) {
		this.salir = salir;
	}

	/**
	 * @return the panelMaquina
	 */
	public PanelMaquina getPanelMaquina() {
		return panelMaquina;
	}

	/**
	 * @param panelMaquina the panelMaquina to set
	 */
	public void setPanelMaquina(PanelMaquina panelMaquina) {
		this.panelMaquina = panelMaquina;
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
	 * @return the boleto
	 */
	public JLabel getBoleto() {
		return boleto;
	}

	/**
	 * @param boleto the boleto to set
	 */
	public void setBoleto(JLabel boleto) {
		this.boleto = boleto;
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
	 * @return the cont
	 */
	public int getCont() {
		return cont;
	}

	/**
	 * @param cont the cont to set
	 */
	public void setCont(int cont) {
		this.cont = cont;
	}

	/**
	 * @return the panelPelota
	 */
	public LaminaPelota getPanelPelota() {
		return panelPelota;
	}

	/**
	 * @param panelPelota the panelPelota to set
	 */
	public void setPanelPelota(LaminaPelota panelPelota) {
		this.panelPelota = panelPelota;
	}

}
