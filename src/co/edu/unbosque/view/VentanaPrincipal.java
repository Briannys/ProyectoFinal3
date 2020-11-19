package co.edu.unbosque.view;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.Icon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class VentanaPrincipal extends JFrame {
	private PanelIniciarSesion panelIniciarSesion;
	private PanelPortada panelInicioSesion;
	private PanelIniciarSesion panelPortada;
	private PanelRegistro panelRegistro;
	private PanelOlvidarContra panelOlvidarContra;
	private PanelDecisionAdminUser panelDecisionAdminUser;
	public VentanaPrincipal() {
		setTitle("Casa de Apuestas");
		setSize(900, 700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		getContentPane().setLayout(new BorderLayout(10, 10));
		inicializarComponentes();
		setLocationRelativeTo(null);
		setVisible(true);
	}

	public void inicializarComponentes() {
		panelInicioSesion = new PanelPortada();
		//add(panelInicioSesion, BorderLayout.CENTER);
		getContentPane().add(panelInicioSesion);
		panelIniciarSesion = new PanelIniciarSesion();
		panelPortada = new PanelIniciarSesion();
		panelRegistro = new PanelRegistro();
		panelOlvidarContra = new PanelOlvidarContra();
		panelDecisionAdminUser = new PanelDecisionAdminUser();
	}
	
	public void capturarMnesaje(String m) {
		UIManager.put("OptionPane.background", Color.white);
		UIManager.put("Panel.background", Color.white);
		UIManager.put("Button.background", Color.white);
		UIManager.put("OptionPane.messageForeground", Color.black);
		JOptionPane.showMessageDialog(null, m);
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
	public PanelPortada getPanelInicioSesion() {
		return panelInicioSesion;
	}

	public void setPanelInicioSesion(PanelPortada panelInicioSesion) {
		this.panelInicioSesion = panelInicioSesion;
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
	 * @return el panelDecisionAdminUser
	 */
	public PanelDecisionAdminUser getPanelDecisionAdminUser() {
		return panelDecisionAdminUser;
	}

	/**
	 * @param panelDecisionAdminUser el panelDecisionAdminUser a establecer
	 */
	public void setPanelDecisionAdminUser(PanelDecisionAdminUser panelDecisionAdminUser) {
		this.panelDecisionAdminUser = panelDecisionAdminUser;
	}
}
