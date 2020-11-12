package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;
import com.toedter.calendar.JDateChooser;

public class PanelRegistro extends JPanel {
	private JLabel[] registros;
	private JButton[] botonesRegistro;
	private JTextArea[] camposRegistro;
	private JDateChooser calendar1;
	private String fecha;
	private JPasswordField[] contrase�a;
	private JRadioButton[] tipoCedula;
	DateFormat date;
	public PanelRegistro() {
		setLayout(null);
		setVisible(false);
		setBackground(Color.white);
		inicializarComponentes();
	}
	public void inicializarComponentes() {
		registros = new JLabel[20];	
		inicializarLabels("Nombres y Apellidos",0, 60, 60, 200, 100);
		inicializarLabels("Telefono", 1, 60, 120, 100, 60);
		inicializarLabels("Correo Electronico", 2, 60, 160, 140, 60);
		inicializarLabels("A�o de Nacimiento", 3, 60, 280, 140, 60);
		inicializarLabels("Contrase�a", 4, 60, 360,140,60);
		inicializarLabels("Confirmar Contrase�a", 5, 60, 400,140,60);
		inicializarLabels("Registrar una nueva cuenta", 6, 160, 20, 290, 60);
		registros[6].setFont(new Font("Century Gothic", 0, 20));
		inicializarLabels("C�dula", 7,60, 240, 140, 60);
		inicializarLabels("Nombre de Usuario",8, 60, 320, 140, 60);
		inicializarLabels("Tipo de Documento", 9,60, 200, 140, 60);
		
		devolverImagenLabel("HOUSEBEAT", "png", 140, 160, 7, -8,-60,140,160);
		devolverImagenLabel("usuario", "png", 20, 20, 8, 30, 22, 100, 180);
		devolverImagenLabel("telefono", "png", 20, 20, 9, 30, 65, 100, 170);
		devolverImagenLabel("correo", "png", 20, 20, 10, 30, 105, 100, 170);
		devolverImagenLabel("cedula", "png", 20, 20, 11, 30, 145, 100, 170);
		devolverImagenLabel("a�oNacimiento", "png", 40, 40, 12,20, 225, 100, 170 );
		devolverImagenLabel("contrase�a", "png", 20, 20, 13, 30, 305, 100, 170 );
		devolverImagenLabel("confirmarContra", "png", 20, 20, 14,30, 348, 100, 170);
		devolverImagenLabel("user", "png", 20, 20, 15,30, 265, 100, 170 );
		devolverImagenLabel("cedula", "png", 20, 20, 16, 30, 185, 100, 170);
		
		calendar1 = new JDateChooser("dd/MM/yyyy", "##/##/####", '_');
		calendar1.setBounds(220,300,100,20);
		calendar1.setCursor(new Cursor(Cursor.HAND_CURSOR));
		calendar1.setBorder(new LineBorder(Color.black));
//		calendar1.setMinSelectableDate(new Date(01/01/2020));
//		calendar1.setMaxSelectableDate(new Date(2021, 01, 01));
		add(calendar1);
		
		date = new SimpleDateFormat("dd-MM-yyyy");
		
		camposRegistro = new JTextArea[10];
		inicializarCampos(0, 220, 100, 200, 20);
		inicializarCampos(1, 220, 140, 200, 20);
		inicializarCampos(2, 220, 180, 200, 20);
		inicializarCampos(3, 220, 260, 200, 20);
		inicializarCampos(4, 220, 340, 200, 20);
		//inicializarCampos(4, 220, 300, 200, 20);
		//inicializarCampos(5, 220, 340, 200, 20);
		contrase�a = new JPasswordField[2];
		inicializarJPassword(0,  220, 380, 200, 20);
		inicializarJPassword(1, 220, 420, 200, 20);
		tipoCedula = new JRadioButton[4];
		inicializarBotonesCedula("CC Ciudadan�a", 0,"CIUDADANIA", 220, 215, 120, 30);
		inicializarBotonesCedula("CC Extranjeria", 1, "EXTRANJERIA", 340, 215, 120, 30);
		inicializarBotonesCedula("Pasaporte", 2, "PASAPORTE", 460, 215, 120, 30);
		
		botonesRegistro = new JButton[3];
		inicializarBotones("REGISTRAR", 0, "Registrar" ,170,460, 100, 25, Color.green);
		inicializarBotones("CANCELAR", 1, "Cancelar", 330, 460, 100, 25, Color.red);
		
		
	}
	
	public void inicializarLabels(String tipoRegistro, int pos, int x, int y, int xB, int yB) {
		registros[pos]= new JLabel(tipoRegistro);
		registros[pos].setVisible(true);
		registros[pos].setBounds(x, y, xB, yB);
		add(registros[pos]);
	}
	public void devolverImagenLabel(String src, String tipo, int escalax, int escalay, int b, int x, int y, int xB, int yB) {
		registros[b] = new JLabel();
		ImageIcon imagen1 = new ImageIcon(getClass().getResource("/imagenes/" + src + "." + tipo));
		ImageIcon icon = new ImageIcon(imagen1.getImage().getScaledInstance(escalax, escalay, Image.SCALE_DEFAULT));
		registros[b].setIcon(icon);
		registros[b].setBounds(x,y,xB,yB);
		add(registros[b]);
	}
	public void inicializarBotones(String command, int pos, String nomBoton, int x, int y, int xB, int yB, Color color) {
		botonesRegistro[pos] = new JButton(nomBoton);
		botonesRegistro[pos].setBackground(color);
		botonesRegistro[pos].setActionCommand(command);
		botonesRegistro[pos].setCursor(new Cursor(Cursor.HAND_CURSOR));
		botonesRegistro[pos].setBounds(x, y, xB, yB);
		add(botonesRegistro[pos]);
	}
	public void inicializarCampos(int pos,  int x, int y, int xB, int yB) {
		camposRegistro[pos] = new JTextArea();
		camposRegistro[pos].setBounds(x, y, xB, yB);
		camposRegistro[pos].setBorder(new LineBorder(Color.black));
		add(camposRegistro[pos]);
		
	}
	public void inicializarJPassword(int pos,  int x, int y, int xB, int yB) {
		contrase�a[pos] = new JPasswordField();
		contrase�a[pos].setBounds(x, y, xB, yB);
		contrase�a[pos].setBorder(new LineBorder(Color.black));
		add(contrase�a[pos]);
	}
	public void inicializarBotonesCedula(String tipoCedula, int pos, String command, int x, int y, int xB, int yB) {
		this.tipoCedula[pos]= new JRadioButton(tipoCedula);
		this.tipoCedula[pos].setBounds(x,y,xB,yB);
		this.tipoCedula[pos].setContentAreaFilled(false);
		this.tipoCedula[pos].setActionCommand(command);
		add(this.tipoCedula[pos]);
	}
	public JButton devolverBoton(int pos) {
		  return botonesRegistro[pos];
	}
	public JRadioButton devolverRadioButton(int pos) {
		return tipoCedula[pos];
	}
	/**
	 * @return el fecha
	 */
	public String getFecha() {
		return fecha;
	}
	/**
	 * @param fecha el fecha a establecer
	 */
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	/**
	 * @return el date
	 */
	public DateFormat getDate() {
		return date;
	}
	/**
	 * @param date el date a establecer
	 */
	public void setDate(DateFormat date) {
		this.date = date;
	}
	/**
	 * @return el calendar1
	 */
	public JDateChooser getCalendar1() {
		return calendar1;
	}
	/**
	 * @param calendar1 el calendar1 a establecer
	 */
	public void setCalendar1(JDateChooser calendar1) {
		this.calendar1 = calendar1;
	}
	/**
	 * @return el registros
	 */
	public JLabel[] getRegistros() {
		return registros;
	}
	/**
	 * @param registros el registros a establecer
	 */
	public void setRegistros(JLabel[] registros) {
		this.registros = registros;
	}
	/**
	 * @return el botonesRegistro
	 */
	public JButton[] getBotonesRegistro() {
		return botonesRegistro;
	}
	/**
	 * @param botonesRegistro el botonesRegistro a establecer
	 */
	public void setBotonesRegistro(JButton[] botonesRegistro) {
		this.botonesRegistro = botonesRegistro;
	}
	/**
	 * @return el camposRegistro
	 */
	public JTextArea[] getCamposRegistro() {
		return camposRegistro;
	}
	/**
	 * @param camposRegistro el camposRegistro a establecer
	 */
	public void setCamposRegistro(JTextArea[] camposRegistro) {
		this.camposRegistro = camposRegistro;
	}
	/**
	 * @return el contrase�a
	 */
	public JPasswordField[] getContrase�a() {
		return contrase�a;
	}
	/**
	 * @param contrase�a el contrase�a a establecer
	 */
	public void setContrase�a(JPasswordField[] contrase�a) {
		this.contrase�a = contrase�a;
	}
}