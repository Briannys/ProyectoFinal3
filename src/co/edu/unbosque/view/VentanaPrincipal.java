package co.edu.unbosque.view;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.Icon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class VentanaPrincipal extends JFrame {
	private PanelPortada panelInicioSesion;
	private PanelIniciarSesion panelPortada;
	private PanelRegistro panelRegistro;
	private PanelOlvidarContra panelOlvidarContra;
	
	public VentanaPrincipal() {
		setTitle("Casa de Apuestas");
		setSize(900, 700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setBackground(Color.LIGHT_GRAY);
		getContentPane().setLayout(new BorderLayout(10, 10));
		inicializarComponentes();
		setLocationRelativeTo(null);
		setVisible(true);
	}

	public void inicializarComponentes() {
		panelInicioSesion = new PanelPortada();
		//add(panelInicioSesion, BorderLayout.CENTER);
		getContentPane().add(panelInicioSesion);
		panelPortada = new PanelIniciarSesion();
		panelRegistro = new PanelRegistro();
		panelOlvidarContra = new PanelOlvidarContra();
	}
	
	

	public PanelPortada getPanelInicioSesion() {
		return panelInicioSesion;
	}

	public void setPanelInicioSesion(PanelPortada panelInicioSesion) {
		this.panelInicioSesion = panelInicioSesion;
	}

	public void mensajeInformativo() {
		String[] options = { "Administrador", "Jugador" };
		int seleccion = JOptionPane.showOptionDialog(null, "Tipo de persona", "Titulo", JOptionPane.DEFAULT_OPTION,
				JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
		System.out.println("Tu seleccion fue " + seleccion);
		if (seleccion == -1) {
			seleccion = JOptionPane.showOptionDialog(null, "Tipo de persona", "Titulo", JOptionPane.DEFAULT_OPTION,
					JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
		} else if (seleccion == 1) {

		}
	}
	/**
	 * @return el panelRegistro
	 */
	public PanelRegistro getPanelRegistro() {
		return panelRegistro;
	}

	/**
	 * @param panelRegistro el panelRegistro a establecer
	 */
	public void setPanelRegistro(PanelRegistro panelRegistro) {
		this.panelRegistro = panelRegistro;
	}

	

	/**
	 * @return the panelPortada
	 */
	public PanelIniciarSesion getPanelPortada() {
		return panelPortada;
	}

	/**
	 * @param panelPortada the panelPortada to set
	 */
	public void setPanelPortada(PanelIniciarSesion panelPortada) {
		this.panelPortada = panelPortada;
	}

	/**
	 * @return el panelOlvidarContra
	 */
	public PanelOlvidarContra getPanelOlvidarContra() {
		return panelOlvidarContra;
	}

	/**
	 * @param panelOlvidarContra el panelOlvidarContra a establecer
	 */
	public void setPanelOlvidarContra(PanelOlvidarContra panelOlvidarContra) {
		this.panelOlvidarContra = panelOlvidarContra;
	}
	
}
