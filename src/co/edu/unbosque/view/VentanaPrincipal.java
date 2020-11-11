package co.edu.unbosque.view;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.Icon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class VentanaPrincipal extends JFrame {
	private PanelPortada panelPortada;
	private PanelRegistro panelRegistro;
	public VentanaPrincipal() {
		setTitle("Casa de Apuestas");
		setSize(600, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setBackground(Color.red);
		getContentPane().setLayout(new BorderLayout(10, 10));
		inicializarComponentes();
		setLocationRelativeTo(null);
		setVisible(true);
	}

	public void inicializarComponentes() {
		panelPortada = new PanelPortada();
		getContentPane().add(panelPortada);
		
		panelRegistro = new PanelRegistro(null);
	//	getContentPane().add(panelRegistro);
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
	 * @return el panelPortada
	 */
	public PanelPortada getPanelPortada() {
		return panelPortada;
	}

	/**
	 * @param panelPortada el panelPortada a establecer
	 */
	public void setPanelPortada(PanelPortada panelPortada) {
		this.panelPortada = panelPortada;
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
	
}
