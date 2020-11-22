package co.edu.unbosque.view;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.Icon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class VentanaPrincipal extends JFrame {
	private PanelIniciarSesion panelIniciarSesion;
	private PanelPortada panelPortada;
	private PanelRegistro panelRegistro;
	private PanelOlvidarContra panelOlvidarContra;
	private PanelDecisionAdminUser panelDecisionAdminUser;
	private PanelControlAdmin panelControlAdmin;

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
		panelPortada = new PanelPortada();
		// add(panelInicioSesion, BorderLayout.CENTER);
		getContentPane().add(panelPortada);
		panelIniciarSesion = new PanelIniciarSesion();
		panelRegistro = new PanelRegistro();
		panelOlvidarContra = new PanelOlvidarContra();
		panelDecisionAdminUser = new PanelDecisionAdminUser();
		panelControlAdmin =  new PanelControlAdmin();
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

	/**
	 * @return the panelIniciarSesion
	 */
	public PanelIniciarSesion getPanelIniciarSesion() {
		return panelIniciarSesion;
	}

	/**
	 * @param panelIniciarSesion the panelIniciarSesion to set
	 */
	public void setPanelIniciarSesion(PanelIniciarSesion panelIniciarSesion) {
		this.panelIniciarSesion = panelIniciarSesion;
	}

	/**
	 * @return the panelPortada
	 */
	public PanelPortada getPanelPortada() {
		return panelPortada;
	}

	/**
	 * @param panelPortada the panelPortada to set
	 */
	public void setPanelPortada(PanelPortada panelPortada) {
		this.panelPortada = panelPortada;
	}

	/**
	 * @return the panelRegistro
	 */
	public PanelRegistro getPanelRegistro() {
		return panelRegistro;
	}

	/**
	 * @param panelRegistro the panelRegistro to set
	 */
	public void setPanelRegistro(PanelRegistro panelRegistro) {
		this.panelRegistro = panelRegistro;
	}

	/**
	 * @return the panelOlvidarContra
	 */
	public PanelOlvidarContra getPanelOlvidarContra() {
		return panelOlvidarContra;
	}

	/**
	 * @param panelOlvidarContra the panelOlvidarContra to set
	 */
	public void setPanelOlvidarContra(PanelOlvidarContra panelOlvidarContra) {
		this.panelOlvidarContra = panelOlvidarContra;
	}

	/**
	 * @return the panelDecisionAdminUser
	 */
	public PanelDecisionAdminUser getPanelDecisionAdminUser() {
		return panelDecisionAdminUser;
	}

	/**
	 * @param panelDecisionAdminUser the panelDecisionAdminUser to set
	 */
	public void setPanelDecisionAdminUser(PanelDecisionAdminUser panelDecisionAdminUser) {
		this.panelDecisionAdminUser = panelDecisionAdminUser;
	}



	/**
	 * @return the panelControlAdmin
	 */
	public PanelControlAdmin getPanelControlAdmin() {
		return panelControlAdmin;
	}

	/**
	 * @param panelControlAdmin the panelControlAdmin to set
	 */
	public void setPanelControlAdmin(PanelControlAdmin panelControlAdmin) {
		this.panelControlAdmin = panelControlAdmin;
	}
	
	public void mostrarMensaje(String m) {
		JOptionPane.showMessageDialog(null, m);
	}
	



}
