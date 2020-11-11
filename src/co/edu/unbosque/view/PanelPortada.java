package co.edu.unbosque.view;


import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelPortada extends JPanel {
	private JButton[] botones;
	public PanelPortada() {
		setLayout(null);
		setVisible(true);
		inicializarComponentes();
	}
	public void inicializarComponentes() {
		botones = new JButton[2];
		botones[0]= new JButton("Iniciar Sesión");
		botones[0].setBounds(0,0,100,100);
		add(botones[0]);
	}
}
