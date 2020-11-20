package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class PanelControlAdmin extends JPanel {

	private JPanel panelControl;
	private JButton[] botonesControl;
	private JLabel[] labelsControl;
	private PanelSede panelSede;
	private PanelEventos panelEventos;

	public PanelControlAdmin() {

		setLayout(null);
		setVisible(true);
		inicializarComponentes();
	}

	private void inicializarComponentes() {

		panelSede = new PanelSede();
		add(panelSede);

		panelEventos = new PanelEventos();
		add(panelEventos);

		panelControl = new JPanel(); // Panel de control del admin, para moverser por las opciones :)
		panelControl.setBackground(Color.WHITE);
		panelControl.setLayout(null);
		panelControl.setBounds(5, 5, 170, 655);
		add(panelControl);

		botonesControl = new JButton[3];
		inicializarBotones(botonesControl, "SEDES", 0, "Sedes", 60, 30, 100, 30, new Color(218, 238, 238),
				panelControl);
		inicializarBotones(botonesControl, "EVENTOS", 1, "Eventos", 60, 80, 100, 30, new Color(218, 238, 238),
				panelControl);
		inicializarBotones(botonesControl, "PREMIOS", 2, "Premios", 60, 130, 100, 30, new Color(218, 238, 238),
				panelControl);

		labelsControl = new JLabel[4];
		devolverImagenLabel(labelsControl, "Sede", "png", 30, 30, 0, 10, 30, 30, 30, panelControl);
		devolverImagenLabel(labelsControl, "evento", "png", 30, 30, 1, 10, 80, 30, 30, panelControl);
		devolverImagenLabel(labelsControl, "premios", "png", 30, 30, 2, 10, 130, 30, 30, panelControl);
		devolverImagenLabel(labelsControl, "house_beat_logo", "png", 120, 60, 3, 20, 550, 120, 60, panelControl);

	}

	public ImageIcon devolverImagen(String src, String tipo, int escalax, int escalay) {
		ImageIcon imagen1 = new ImageIcon(getClass().getResource("/imagenesAd/" + src + "." + tipo));
		ImageIcon icon = new ImageIcon(imagen1.getImage().getScaledInstance(escalax, escalay, Image.SCALE_DEFAULT));
		return icon;
	}

	public void inicializarBotones(JButton[] bot, String command, int pos, String nomBoton, int x, int y, int xB,
			int yB, Color color, JPanel jp) {
		bot[pos] = new JButton(nomBoton);
		bot[pos].setBackground(color);
		bot[pos].setActionCommand(command);
		bot[pos].setCursor(new Cursor(Cursor.HAND_CURSOR));
		bot[pos].setBounds(x, y, xB, yB);
		jp.add(bot[pos]);
	}

	public void inicializarLabels(JLabel[] lab, String tipoRegistro, int pos, int x, int y, int xB, int yB, JPanel jp,
			Color color, int tamaño) {
		lab[pos] = new JLabel(tipoRegistro);
		lab[pos].setVisible(true);
		lab[pos].setForeground(color);
		lab[pos].setFont(new Font("Century Gothic", Font.PLAIN, tamaño));
		lab[pos].setBounds(x, y, xB, yB);
		jp.add(lab[pos]);
	}

	public void devolverImagenLabel(JLabel[] lab, String src, String tipo, int escalax, int escalay, int b, int x,
			int y, int xB, int yB, JPanel jp) {
		lab[b] = new JLabel();
		ImageIcon imagen1 = new ImageIcon(getClass().getResource("/imagenesAd/" + src + "." + tipo));
		ImageIcon icon = new ImageIcon(imagen1.getImage().getScaledInstance(escalax, escalay, Image.SCALE_DEFAULT));
		lab[b].setIcon(icon);
		lab[b].setBounds(x, y, xB, yB);
		jp.add(lab[b]);
	}

	public JButton devolverBoton(int pos, JButton[] botones) {
		return botones[pos];
	}

	/**
	 * @return the panelControl
	 */
	public JPanel getPanelControl() {
		return panelControl;
	}

	/**
	 * @param panelControl the panelControl to set
	 */
	public void setPanelControl(JPanel panelControl) {
		this.panelControl = panelControl;
	}

	/**
	 * @return the botonesControl
	 */
	public JButton[] getBotonesControl() {
		return botonesControl;
	}

	/**
	 * @param botonesControl the botonesControl to set
	 */
	public void setBotonesControl(JButton[] botonesControl) {
		this.botonesControl = botonesControl;
	}

	/**
	 * @return the labelsControl
	 */
	public JLabel[] getLabelsControl() {
		return labelsControl;
	}

	/**
	 * @param labelsControl the labelsControl to set
	 */
	public void setLabelsControl(JLabel[] labelsControl) {
		this.labelsControl = labelsControl;
	}

	/**
	 * @return the panelSede
	 */
	public PanelSede getPanelSede() {
		return panelSede;
	}

	/**
	 * @param panelSede the panelSede to set
	 */
	public void setPanelSede(PanelSede panelSede) {
		this.panelSede = panelSede;
	}

	/**
	 * @return the panelEventos
	 */
	public PanelEventos getPanelEventos() {
		return panelEventos;
	}

	/**
	 * @param panelEventos the panelEventos to set
	 */
	public void setPanelEventos(PanelEventos panelEventos) {
		this.panelEventos = panelEventos;
	}

}
