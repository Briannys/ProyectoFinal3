package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class PanelSede extends JPanel {

	private JPanel[] panelesSede;
	private JButton[] botonesControlSedes;
	private JLabel[] labelsControlSedes, labelsCrear, labelsModificar, labelsBorrar, labelsSedes;
	private JTextField[] campoCrear, campoModificar;
	private JButton guardarCrear, guardarSedeModificar, borrarSede;
	private JComboBox<String> localidadesModificar, localidadCrear, sedesModificar, sedesBorrar;
	private JCheckBox borrar;
	private JTable tablaSede;
	private JScrollPane sp1;

	public PanelSede() {

		setLayout(null);
		setVisible(true);
		setBounds(180, 5, 700, 655);
		inicializaComponentes();

	}

	private void inicializaComponentes() {

		panelesSede = new JPanel[5];
		inicializarPaneles(0, new Color(3, 6, 97), 0, 0, 700, 150);// panel control sedes

		botonesControlSedes = new JButton[3];
		inicializarBotones(botonesControlSedes, "CREARSEDE", 0, "Crear Sede", 80, 80, 120, 30, new Color(218, 238, 238),
				devolverPaneles(0));
		inicializarBotones(botonesControlSedes, "MODIFICARSEDE", 1, "Modificar Sede", 300, 80, 120, 30,
				new Color(218, 238, 238), devolverPaneles(0));
		inicializarBotones(botonesControlSedes, "ELIMINARSEDE", 2, "Eliminar Sede", 520, 80, 120, 30,
				new Color(218, 238, 238), devolverPaneles(0));

		labelsControlSedes = new JLabel[4];
		inicializarLabels(labelsControlSedes, "Gesti�n de sedes: ", 0, 30, 25, 200, 30, devolverPaneles(0),
				new Color(218, 238, 238), 20);
		devolverImagenLabel(labelsControlSedes, "agregar", "png", 30, 30, 1, 35, 80, 30, 30, devolverPaneles(0));
		devolverImagenLabel(labelsControlSedes, "editar", "png", 30, 30, 2, 260, 80, 30, 30, devolverPaneles(0));
		devolverImagenLabel(labelsControlSedes, "borrar", "png", 30, 30, 3, 480, 80, 30, 30, devolverPaneles(0));

		inicializarPaneles(1, Color.WHITE, 0, 155, 700, 500); // pane crear sede

		labelsCrear = new JLabel[9];
		inicializarLabels(labelsCrear, "Crear nueva sede", 0, 30, 50, 210, 20, devolverPaneles(1), new Color(3, 6, 97),
				20);
		inicializarLabels(labelsCrear, "Nombre de la sede : ", 1, 50, 110, 210, 15, devolverPaneles(1), Color.BLACK,
				15);
		inicializarLabels(labelsCrear, "Presupuesto para la sede : ", 2, 50, 170, 210, 15, devolverPaneles(1),
				Color.BLACK, 15);
		inicializarLabels(labelsCrear, "localidad :", 3, 50, 230, 140, 15, devolverPaneles(1), Color.BLACK, 15);
		inicializarLabels(labelsCrear, "Cantindad de empleados : ", 4, 50, 290, 210, 15, devolverPaneles(1),
				Color.BLACK, 15);

		devolverImagenLabel(labelsCrear, "casa", "png", 20, 20, 4, 15, 105, 20, 20, devolverPaneles(1));
		devolverImagenLabel(labelsCrear, "presupuesto", "png", 20, 20, 5, 15, 165, 20, 20, devolverPaneles(1));
		devolverImagenLabel(labelsCrear, "localidad", "png", 20, 20, 6, 15, 225, 20, 20, devolverPaneles(1));
		devolverImagenLabel(labelsCrear, "usuarios", "png", 20, 20, 7, 15, 285, 20, 20, devolverPaneles(1));
		inicializarLabels(labelsCrear, "Guardar Sede", 8, 296, 445, 100, 10, devolverPaneles(1), new Color(3, 6, 97),
				10);

		campoCrear = new JTextField[3];
		inicializarCampos(campoCrear, 0, 250, 105, 430, 20, devolverPaneles(1));
		inicializarCampos(campoCrear, 1, 250, 165, 430, 20, devolverPaneles(1));
		inicializarCampos(campoCrear, 2, 250, 285, 430, 20, devolverPaneles(1));

		localidadCrear = new JComboBox<String>();
		localidadCrear.addItem("");
		localidadCrear.addItem("Usaqu�n");
		localidadCrear.addItem("Chapinero");
		localidadCrear.addItem("San Cristobal");
		localidadCrear.addItem("Santa Fe");
		localidadCrear.addItem("San Crist�bal");
		localidadCrear.addItem("Usme");
		localidadCrear.addItem("Tunjuelito");
		localidadCrear.addItem("Bosa");
		localidadCrear.addItem("Kennedy");
		localidadCrear.addItem("Fontibon");
		localidadCrear.addItem("Engativ�");
		localidadCrear.addItem("suba");
		localidadCrear.setBounds(250, 225, 430, 20);
		devolverPaneles(1).add(localidadCrear);

		guardarCrear = new JButton(devolverImagen("guardar", "png", 60, 60));
		guardarCrear.setBorder(null);
		guardarCrear.setBackground(Color.WHITE);
		guardarCrear.setActionCommand("SAVESEDE");
		guardarCrear.setToolTipText("Guardar Sede");
		guardarCrear.setRolloverIcon(devolverImagen("guardar", "png", 70, 70));
		guardarCrear.setBounds(300, 380, 60, 60);
		devolverPaneles(1).add(guardarCrear);

		inicializarPaneles(2, Color.WHITE, 2, 155, 700, 500); // panel modificar sede

		labelsModificar = new JLabel[9];

		inicializarLabels(labelsModificar, "Modificar sede", 0, 30, 50, 210, 20, devolverPaneles(2),
				new Color(3, 6, 97), 20);
		inicializarLabels(labelsModificar, "Nombre de la sede : ", 1, 50, 110, 210, 15, devolverPaneles(2), Color.BLACK,
				15);
		inicializarLabels(labelsModificar, "Presupuesto para la sede : ", 2, 50, 170, 210, 15, devolverPaneles(2),
				Color.BLACK, 15);
		inicializarLabels(labelsModificar, "localidad :", 3, 50, 230, 140, 15, devolverPaneles(2), Color.BLACK, 15);
		inicializarLabels(labelsModificar, "Cantindad de empleados : ", 4, 50, 290, 210, 15, devolverPaneles(2),
				Color.BLACK, 15);

		devolverImagenLabel(labelsModificar, "casa", "png", 20, 20, 4, 15, 105, 20, 20, devolverPaneles(2));
		devolverImagenLabel(labelsModificar, "presupuesto", "png", 20, 20, 5, 15, 165, 20, 20, devolverPaneles(2));
		devolverImagenLabel(labelsModificar, "localidad", "png", 20, 20, 6, 15, 225, 20, 20, devolverPaneles(2));
		devolverImagenLabel(labelsModificar, "usuarios", "png", 20, 20, 7, 15, 285, 20, 20, devolverPaneles(2));
		inicializarLabels(labelsModificar, "Guardar cambios", 8, 296, 445, 100, 10, devolverPaneles(2),
				new Color(3, 6, 97), 10);

		campoModificar = new JTextField[3];
		inicializarCampos(campoModificar, 0, 250, 105, 430, 20, devolverPaneles(2));
		inicializarCampos(campoModificar, 1, 250, 165, 430, 20, devolverPaneles(2));
		inicializarCampos(campoModificar, 2, 250, 285, 430, 20, devolverPaneles(2));

		guardarSedeModificar = new JButton(devolverImagen("guardar", "png", 60, 60));
		guardarSedeModificar.setBorder(null);
		guardarSedeModificar.setBackground(Color.WHITE);
		guardarSedeModificar.setActionCommand("SAVEMODIFI");
		guardarSedeModificar.setToolTipText("Eliminar Sede");
		guardarSedeModificar.setRolloverIcon(devolverImagen("guardar", "png", 65, 65));
		guardarSedeModificar.setBounds(310, 380, 60, 60);
		devolverPaneles(2).add(guardarSedeModificar);

		localidadesModificar = new JComboBox<String>();
		localidadesModificar.addItem("");
		localidadesModificar.addItem("Usaqu�n");
		localidadesModificar.addItem("Chapinero");
		localidadesModificar.addItem("San Cristobal");
		localidadesModificar.addItem("Santa Fe.");
		localidadesModificar.addItem("San Crist�bal");
		localidadesModificar.addItem("Usme");
		localidadesModificar.addItem("Tunjuelito");
		localidadesModificar.addItem("Bosa");
		localidadesModificar.addItem("Kennedy");
		localidadesModificar.addItem("Fontibon");
		localidadesModificar.addItem("Engativ�");
		localidadesModificar.addItem("suba");
		localidadesModificar.setBounds(250, 225, 430, 20);
		devolverPaneles(2).add(localidadesModificar);

		sedesModificar = new JComboBox<String>();
		sedesModificar.setBounds(350, 50, 200, 20);
		devolverPaneles(2).add(sedesModificar);

		inicializarPaneles(3, Color.WHITE, 0, 155, 700, 500); // panel borrar

		labelsBorrar = new JLabel[5];
		inicializarLabels(labelsBorrar, "Eliminar Sede: ", 0, 30, 50, 210, 20, devolverPaneles(3), new Color(3, 6, 97),
				20);

		inicializarLabels(labelsBorrar, "Seleccione la sede que desea eliminar : ", 1, 50, 120, 290, 15,
				devolverPaneles(3), Color.BLACK, 15);
		inicializarLabels(labelsModificar, "Borrar sede", 2, 300, 445, 100, 10, devolverPaneles(3), new Color(3, 6, 97),
				10);

		sedesBorrar = new JComboBox<String>();
		sedesBorrar.setBounds(140, 200, 400, 20);
		devolverPaneles(3).add(sedesBorrar);

		borrar = new JCheckBox("¿ Estas seguro de eliminar la sede ?");
		borrar.setBounds(220, 300, 400, 20);
		borrar.setBackground(Color.WHITE);
		devolverPaneles(3).add(borrar);

		borrarSede = new JButton(devolverImagen("borrarAzul", "png", 60, 60));
		borrarSede.setBorder(null);
		borrarSede.setBackground(Color.WHITE);
		borrarSede.setActionCommand("BORRARSEDE");
		borrarSede.setToolTipText("Borrar Sede");
		borrarSede.setRolloverIcon(devolverImagen("borrarAzul", "png", 70, 70));
		borrarSede.setBounds(300, 380, 60, 60);
		devolverPaneles(3).add(borrarSede);

		inicializarPaneles(4, new Color(218, 238, 238), 0, 155, 700, 500);

		tablaSede = new JTable();
		tablaSede.setBounds(40, 100, 620, 350);
		sp1 = new JScrollPane(tablaSede);
		sp1.setBounds(40, 100, 620, 350);
		devolverPaneles(4).add(sp1);

		inicializarLabels(labelsBorrar, "Sedes activas: ", 3, 30, 50, 210, 20, devolverPaneles(4), new Color(3, 6, 97),
				20);

	}

	public void inicializarPaneles(int pos, Color color, int x, int y, int ancho, int largo) {
		panelesSede[pos] = new JPanel();
		panelesSede[pos].setBackground(color);
		panelesSede[pos].setLayout(null);
		panelesSede[pos].setVisible(false);
		panelesSede[pos].setBounds(x, y, ancho, largo);
		add(panelesSede[pos]);
	}

	public JPanel devolverPaneles(int pos) {
		return panelesSede[pos];
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

	public JLabel devolverLabels(int pos, JLabel[] jb) {

		return jb[pos];
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

	public JButton devolverBoton(int pos, JButton[] botones) {
		return botones[pos];
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

	public void inicializarCampos(JTextField[] campos, int pos, int x, int y, int xB, int yB, JPanel jp) {
		campos[pos] = new JTextField();
		campos[pos].setBounds(x, y, xB, yB);
		campos[pos].setBorder(new LineBorder(Color.black));
		jp.add(campos[pos]);

	}

	public ImageIcon devolverImagen(String src, String tipo, int escalax, int escalay) {
		ImageIcon imagen1 = new ImageIcon(getClass().getResource("/imagenesAd/" + src + "." + tipo));
		ImageIcon icon = new ImageIcon(imagen1.getImage().getScaledInstance(escalax, escalay, Image.SCALE_DEFAULT));
		return icon;
	}

	public JTextField devolverTextField(int pos, JTextField[] txt) {
		return txt[pos];

	}

	/**
	 * @return the panelesSede
	 */
	public JPanel[] getPanelesSede() {
		return panelesSede;
	}

	/**
	 * @param panelesSede the panelesSede to set
	 */
	public void setPanelesSede(JPanel[] panelesSede) {
		this.panelesSede = panelesSede;
	}

	/**
	 * @return the botonesControlSedes
	 */
	public JButton[] getBotonesControlSedes() {
		return botonesControlSedes;
	}

	/**
	 * @param botonesControlSedes the botonesControlSedes to set
	 */
	public void setBotonesControlSedes(JButton[] botonesControlSedes) {
		this.botonesControlSedes = botonesControlSedes;
	}

	/**
	 * @return the labelsControlSedes
	 */
	public JLabel[] getLabelsControlSedes() {
		return labelsControlSedes;
	}

	/**
	 * @param labelsControlSedes the labelsControlSedes to set
	 */
	public void setLabelsControlSedes(JLabel[] labelsControlSedes) {
		this.labelsControlSedes = labelsControlSedes;
	}

	/**
	 * @return the labelsCrear
	 */
	public JLabel[] getLabelsCrear() {
		return labelsCrear;
	}

	/**
	 * @param labelsCrear the labelsCrear to set
	 */
	public void setLabelsCrear(JLabel[] labelsCrear) {
		this.labelsCrear = labelsCrear;
	}

	/**
	 * @return the campoCrear
	 */
	public JTextField[] getCampoCrear() {
		return campoCrear;
	}

	/**
	 * @param campoCrear the campoCrear to set
	 */
	public void setCampoCrear(JTextField[] campoCrear) {
		this.campoCrear = campoCrear;
	}

	/**
	 * @return the localidadCrear
	 */
	public JComboBox<String> getLocalidadCrear() {
		return localidadCrear;
	}

	/**
	 * @param localidadCrear the localidadCrear to set
	 */
	public void setLocalidadCrear(JComboBox<String> localidadCrear) {
		this.localidadCrear = localidadCrear;
	}

	/**
	 * @return the guardarCrear
	 */
	public JButton getGuardarCrear() {
		return guardarCrear;
	}

	/**
	 * @param guardarCrear the guardarCrear to set
	 */
	public void setGuardarCrear(JButton guardarCrear) {
		this.guardarCrear = guardarCrear;
	}

	/**
	 * @return the labelsModificar
	 */
	public JLabel[] getLabelsModificar() {
		return labelsModificar;
	}

	/**
	 * @param labelsModificar the labelsModificar to set
	 */
	public void setLabelsModificar(JLabel[] labelsModificar) {
		this.labelsModificar = labelsModificar;
	}

	/**
	 * @return the campoModificar
	 */
	public JTextField[] getCampoModificar() {
		return campoModificar;
	}

	/**
	 * @param campoModificar the campoModificar to set
	 */
	public void setCampoModificar(JTextField[] campoModificar) {
		this.campoModificar = campoModificar;
	}

	/**
	 * @return the localidadesModificar
	 */
	public JComboBox<String> getLocalidadesModificar() {
		return localidadesModificar;
	}

	/**
	 * @param localidadesModificar the localidadesModificar to set
	 */
	public void setLocalidadesModificar(JComboBox<String> localidadesModificar) {
		this.localidadesModificar = localidadesModificar;
	}

	/**
	 * @return the guardarSedeModificar
	 */
	public JButton getGuardarSedeModificar() {
		return guardarSedeModificar;
	}

	/**
	 * @param guardarSedeModificar the guardarSedeModificar to set
	 */
	public void setGuardarSedeModificar(JButton guardarSedeModificar) {
		this.guardarSedeModificar = guardarSedeModificar;
	}

	/**
	 * @return the sedesModificar
	 */
	public JComboBox<String> getSedesModificar() {
		return sedesModificar;
	}

	/**
	 * @param sedesModificar the sedesModificar to set
	 */
	public void setSedesModificar(JComboBox<String> sedesModificar) {
		this.sedesModificar = sedesModificar;
	}

	/**
	 * @return the labelsBorrar
	 */
	public JLabel[] getLabelsBorrar() {
		return labelsBorrar;
	}

	/**
	 * @param labelsBorrar the labelsBorrar to set
	 */
	public void setLabelsBorrar(JLabel[] labelsBorrar) {
		this.labelsBorrar = labelsBorrar;
	}

	/**
	 * @return the borrarSede
	 */
	public JButton getBorrarSede() {
		return borrarSede;
	}

	/**
	 * @param borrarSede the borrarSede to set
	 */
	public void setBorrarSede(JButton borrarSede) {
		this.borrarSede = borrarSede;
	}

	/**
	 * @return the sedesBorrar
	 */
	public JComboBox<String> getSedesBorrar() {
		return sedesBorrar;
	}

	/**
	 * @param sedesBorrar the sedesBorrar to set
	 */
	public void setSedesBorrar(JComboBox<String> sedesBorrar) {
		this.sedesBorrar = sedesBorrar;
	}

	/**
	 * @return the borrar
	 */
	public JCheckBox getBorrar() {
		return borrar;
	}

	/**
	 * @param borrar the borrar to set
	 */
	public void setBorrar(JCheckBox borrar) {
		this.borrar = borrar;
	}

	/**
	 * @return the tablaSede
	 */
	public JTable getTablaSede() {
		return tablaSede;
	}

	/**
	 * @param tablaSede the tablaSede to set
	 */
	public void setTablaSede(JTable tablaSede) {
		this.tablaSede = tablaSede;
	}

	/**
	 * @return the labelsSedes
	 */
	public JLabel[] getLabelsSedes() {
		return labelsSedes;
	}

	/**
	 * @param labelsSedes the labelsSedes to set
	 */
	public void setLabelsSedes(JLabel[] labelsSedes) {
		this.labelsSedes = labelsSedes;
	}

}
