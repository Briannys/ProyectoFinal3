package co.edu.unbosque.view;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.Icon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class VentanaPrincipal extends JFrame {
	private PanelInicioSesion panelInicioSesion;
	private PanelIniciarSesion panelIniciarSesion;
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
		panelInicioSesion = new PanelInicioSesion();
		//add(panelInicioSesion, BorderLayout.CENTER);
		getContentPane().add(panelInicioSesion);
		panelIniciarSesion = new PanelIniciarSesion();
		panelRegistro = new PanelRegistro();
		panelOlvidarContra = new PanelOlvidarContra();
	}
	
	

	public PanelInicioSesion getPanelInicioSesion() {
		return panelInicioSesion;
	}

	public void setPanelInicioSesion(PanelInicioSesion panelInicioSesion) {
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
	 * @return el panelIniciarSesion
	 */
	public PanelIniciarSesion getPanelIniciarSesion() {
		return panelIniciarSesion;
	}

	/**
	 * @param panelIniciarSesion el panelIniciarSesion a establecer
	 */
	public void setPanelIniciarSesion(PanelIniciarSesion panelIniciarSesion) {
		this.panelIniciarSesion = panelIniciarSesion;
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
