package co.edu.ulbosque.controller;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import co.edu.ulbosque.model.CasaApuesta;
import co.edu.ulbosque.model.Correo;
import co.edu.ulbosque.model.Usuario;
import co.edu.ulbosque.model.persistence.UsuarioDAO;
import co.edu.unbosque.view.VentanaPrincipal;

public class Controller implements ActionListener {
	private VentanaPrincipal vista;
	private UsuarioDAO usuarioDAO;
	private CasaApuesta casaApuesta;
	private excel2 excel23;

	public Controller() {
		usuarioDAO = new UsuarioDAO();
		vista = new VentanaPrincipal();
		casaApuesta = new CasaApuesta();
		List<JTable> tb = new ArrayList<>();
        tb.add(cargarTabla());
		try {
			excel23 = new excel2(tb, new File("D://Briannys//book"+".xls"));
			 if (excel23.export()) {
	                System.out.println("TABLAS EXPORTADOS CON EXITOS!");
	            }
		} catch (Exception e) {
			// TODO Bloque catch generado automáticamente
			e.printStackTrace();
		} ;
		asignarOyentes();
		mouseListener();
		cargarTabla();
		vista.getPanelControlAdmin().getPanelSede().setVisible(true);
	}

	public boolean enviarCorreo(Correo c) {
		try {
			Properties p = System.getProperties();
			p.setProperty("mail.smtp.transport.protocol", "smtp.gmail.com");
			p.setProperty("mail.smtp.port", "587");
			p.put("mail.smtp.host", "smtp.gmail.com");
			p.setProperty("mail.smtp.starttls.enable", "true");
			p.setProperty("mail.smtp.user", "houseappinc@gmail.com");
			p.setProperty("mail.smtp.auth", "true");

			Session s = Session.getDefaultInstance(p);
			MimeMessage msg = new MimeMessage(s);
			msg.setFrom(new InternetAddress(c.getFrom()));
			msg.addRecipient(Message.RecipientType.TO, new InternetAddress(c.getTo()));
			msg.setSubject(c.getSubject());
			msg.setText(c.getMensaje());
			Transport transport = s.getTransport("smtp");
			try {

				System.out.println("Enviando mensaje");
				transport.connect("houseappinc@gmail.com", "warzone2020");
				transport.sendMessage(msg, msg.getAllRecipients());
				transport.close();
				System.out.println("Mesnaje enviado");
				return true;
			} catch (Exception e) {
				System.out.println(e.toString());
				System.out.println("F");
				return false;
			}
		} catch (Exception e) {
			System.out.println(e.toString());
			System.out.println("F");
			return false;
		}
	}

	public void asignarOyentes() {

		vista.getPanelPortada().getReg().addActionListener(this);
		oyentesBotonesRegistro();
		vista.getPanelIniciarSesion().getIngresar().addActionListener(this);
		vista.getPanelIniciarSesion().getOlvidarContra().addActionListener(this);
		vista.getPanelIniciarSesion().getRegistrar().addActionListener(this);
		vista.getPanelRegistro().devolverRadioButton(0).addActionListener(this);
		vista.getPanelRegistro().devolverRadioButton(1).addActionListener(this);
		vista.getPanelRegistro().devolverRadioButton(2).addActionListener(this);
		vista.getPanelIniciarSesion().getOlvidarContra().addActionListener(this);
		vista.getPanelIniciarSesion().getRegistrar().addActionListener(this);
		vista.getPanelRegistro().getIniciarSesion().addActionListener(this);
		vista.getPanelPortada().getLogin().addActionListener(this);
		vista.getPanelPortada().getReg().addActionListener(this);
		vista.getPanelPortada().getAstro().addActionListener(this);
		vista.getPanelPortada().getFutbol().addActionListener(this);
		vista.getPanelPortada().getBaloto().addActionListener(this);
		vista.getPanelDecisionAdminUser().getUser().addActionListener(this);
		vista.getPanelDecisionAdminUser().getAdmin().addActionListener(this);

		// listeners Control

		vista.getPanelControlAdmin().devolverBoton(0, vista.getPanelControlAdmin().getBotonesControl())
				.addActionListener(this);
		vista.getPanelControlAdmin().getPanelSede()
				.devolverBoton(0, vista.getPanelControlAdmin().getPanelSede().getBotonesControlSedes())
				.addActionListener(this);

		vista.getPanelControlAdmin().getPanelSede()
				.devolverBoton(1, vista.getPanelControlAdmin().getPanelSede().getBotonesControlSedes())
				.addActionListener(this);

		vista.getPanelControlAdmin().getPanelSede()
				.devolverBoton(2, vista.getPanelControlAdmin().getPanelSede().getBotonesControlSedes())
				.addActionListener(this);

		vista.getPanelControlAdmin().devolverBoton(1, vista.getPanelControlAdmin().getBotonesControl())
				.addActionListener(this);

		vista.getPanelControlAdmin().getPanelEventos()
				.devolverBoton(0, vista.getPanelControlAdmin().getPanelEventos().getBotonesControlEventos())
				.addActionListener(this);

		vista.getPanelControlAdmin().getPanelEventos()
				.devolverBoton(1, vista.getPanelControlAdmin().getPanelEventos().getBotonesControlEventos())
				.addActionListener(this);

		vista.getPanelControlAdmin().getPanelSede().getGuardarCrear().addActionListener(this);
		vista.getPanelControlAdmin().getPanelSede().getGuardarSedeModificar().addActionListener(this);
		vista.getPanelControlAdmin().getPanelSede().getBorrarSede().addActionListener(this);
		vista.getPanelControlAdmin().getPanelEventos().getGuardarEvento().addActionListener(this);
		vista.getPanelControlAdmin().getPanelEventos().getBorrarEvento().addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {

		int flag = 0;
		String user = "";
		String password = "";

		String command = e.getActionCommand();
		System.out.println(command);
		if (command.equals("REGISTRARSE")) {
			tamanoVentanas(550, 420);
			cambiarPanel(vista.getPanelDecisionAdminUser());
		} else if (command.equals("CIUDADANIA")) {
			if (vista.getPanelRegistro().devolverRadioButton(0).isSelected() == true) {
				vista.getPanelRegistro().devolverRadioButton(1).setEnabled(false);
				vista.getPanelRegistro().devolverRadioButton(2).setEnabled(false);
			} else {
				vista.getPanelRegistro().devolverRadioButton(1).setEnabled(true);
				vista.getPanelRegistro().devolverRadioButton(2).setEnabled(true);
			}
		} else if (command.equals("EXTRANJERIA")) {
			if (vista.getPanelRegistro().devolverRadioButton(1).isSelected() == true) {
				vista.getPanelRegistro().devolverRadioButton(0).setEnabled(false);
				vista.getPanelRegistro().devolverRadioButton(2).setEnabled(false);
			} else {
				vista.getPanelRegistro().devolverRadioButton(0).setEnabled(true);
				vista.getPanelRegistro().devolverRadioButton(2).setEnabled(true);
			}
		} else if (command.equals("PASAPORTE")) {
			if (vista.getPanelRegistro().devolverRadioButton(2).isSelected() == true) {
				vista.getPanelRegistro().devolverRadioButton(0).setEnabled(false);
				vista.getPanelRegistro().devolverRadioButton(1).setEnabled(false);
			} else {
				vista.getPanelRegistro().devolverRadioButton(0).setEnabled(true);
				vista.getPanelRegistro().devolverRadioButton(1).setEnabled(true);
			}
		} else if (command.equals("OLVIDARCONTRA")) {
			tamanoVentanas(500, 350);
			cambiarPanel(vista.getPanelOlvidarContra());

		} else if (command.equals("INICIARSESIONREGISTRAR")) { // user
			tamanoVentanas(500, 350);
			cambiarPanel(vista.getPanelIniciarSesion());
		} else if (command.equals("USERD")) { // registro para el usuario
			flag = 1;
			tamanoVentanas(600, 650);
			cambiarPanel(vista.getPanelRegistro());

		} else if (command.equals("ADMIND")) { // registro para el admin
			flag = 0;
			tamanoVentanas(600, 650);
			cambiarPanel(vista.getPanelRegistro());

		} else if (command.equals("INGRESAR")) { // ingresar login

			user = vista.getPanelIniciarSesion().getUsuario().getText();
			password = vista.getPanelIniciarSesion().getContrasena().getText();

			if (validarUsuario(user, password) == 1) { // si es admin
				System.out.println("Es admin");
				tamanoVentanas(900, 700);
				cambiarPanel(vista.getPanelControlAdmin());

			} else if (validarUsuario(user, password) == 2) { // si es user
				System.out.println("Es user");
				tamanoVentanas(900, 700);
				vista.getPanelPortada().quitarInicioSesion(1);
				vista.getPanelPortada().getHolix().setText("Bienvenido " + user);
				vista.getPanelPortada().activarJuegos();
				cambiarPanel(vista.getPanelPortada());

			} else if (validarUsuario(user, password) == 0) { // si no existe
				System.out.println("No esta registrado");
			}

		} else if (command.equals("INICIARSESION")) {
			tamanoVentanas(500, 350);
			cambiarPanel(vista.getPanelIniciarSesion());

		} else if (command.equals("REGISTRATE")) {

			tamanoVentanas(550, 420);
			cambiarPanel(vista.getPanelDecisionAdminUser());

		} else if (command.equals("BALOTO")) {

			vista.getPanelPortada().setVisible(false);

		} else if (command.equals("SUPERASTRO")) {

			vista.getPanelPortada().setVisible(false);

		} else if (command.equals("FUTBOL")) {
			vista.getPanelPortada().setVisible(false);

		} else if (command.equals("ATR-SESION")) {
			vista.getPanelIniciarSesion().setVisible(false);
			// vista.getPanelIniciarSesion().reiniciarTextos();
			tamanoVentanas(900, 700);
			cambiarPanel(vista.getPanelPortada());
		} else if (command.equals("CANCELAR")) {
			vista.getPanelRegistro().setVisible(false);
			// vista.getPanelIniciarSesion().reiniciarTextos();
			tamanoVentanas(900, 700);
			cambiarPanel(vista.getPanelPortada());
		} else if (command.equals("REGISTRAR")) {

			String nombre = vista.getPanelRegistro().devolverCampo(0).getText();
			String telefono = vista.getPanelRegistro().devolverCampo(1).getText();
			String correo = vista.getPanelRegistro().devolverCampo(2).getText();
			String documento = vista.getPanelRegistro().devolverCampo(3).getText();
			String anioN = "";
			String usuario = vista.getPanelRegistro().devolverCampo(4).getText();
			@SuppressWarnings("deprecation")
			String contrasenia = vista.getPanelRegistro().devolverContra(0).getText();
			@SuppressWarnings("deprecation")
			String confirmaContra = vista.getPanelRegistro().devolverContra(1).getText();
//			if (comprobarCamposRegistro() == false ) {
//				vista.capturarMnesaje("Campos Vac�os");
//				} else 
//					if (validarCampos() == 1) {
//					vista.capturarMnesaje("ERROR estas ingresando numeros en un campo de letras");
//				}else if (validarCampos() == 2) {
//					vista.capturarMnesaje("ERROR estas ingresando letras en un campo de numeros");
//				}else if (validarCampos() == 3) {
//					vista.capturarMnesaje("Error en el correo");
//				}else if (validarCampos() == 4) {
//					vista.capturarMnesaje("ERROR");
//				}else if (validarCampos() == 5) {
//					vista.capturarMnesaje("ERROR las contrase�as no son iguales");
//				}else if (validarCampos() == 6) {
//					vista.capturarMnesaje("ERROR en el nombre");
//				}else if (validarCampos() == 7) {
//					vista.capturarMnesaje("ERROR debes leer los t�rminos y condiciones");
//				}else if (validarCampos() == 8) {
//					cambiarPanel(vista.getPanelIniciarSesion());
//					tamanoVentanas(500, 350);
//				}

			if (flag == 1) {
				Correo correoAux = new Correo(correo);
				if (contrasenia.equals(confirmaContra)) {
					Usuario aux = new Usuario(nombre, correoAux, telefono, usuario, documento, anioN, contrasenia);
					correoAux.mensajeBienvenida(nombre);
					enviarCorreo(correoAux);
					try {
						usuarioDAO.agregarUsuario(aux);
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				try {
					if (usuarioDAO.comprobarNombreUsuario(usuario)) {
						String m = "";
						m = "ya hay un usuario";
					}
				} catch (ClassNotFoundException e1) {
					// TODO Bloque catch generado autom�ticamente
					e1.printStackTrace();
				}
				usuarioDAO.imprimir();

			} else if (flag == 0) {

				casaApuesta.getAdminDAO().leerAdmnins();

				if (contrasenia.equals(confirmaContra)) {

					if (casaApuesta.getAdminDAO().comprobarUsuario(nombre) == 0) {

						Correo correoAdmin = new Correo(correo);
						correoAdmin.mensajeBienvenidaAdmin(nombre);
						enviarCorreo(correoAdmin);

						casaApuesta.getAdminDAO().ingresoAdmin(nombre, correoAdmin, usuario, telefono, documento, anioN,
								contrasenia);
						System.out.println("Admin creado con exito");
					} else {
						System.out.println("Nombre de usuario invalido, por favor cambielo.");
					}
				} else {
					System.out.println("Valide la contraseña");

				}
			}
		}

		if (command.equals("SEDES"))

		{

			vista.getPanelControlAdmin().getPanelSede().setVisible(true);
			vista.getPanelControlAdmin().getPanelEventos().setVisible(false);
			casaApuesta.getSedesDAO().leerSedes();
			vista.getPanelControlAdmin().getPanelSede().devolverPaneles(0).setVisible(true);
			vista.getPanelControlAdmin().getPanelSede().devolverPaneles(4).setVisible(true);
			vista.getPanelControlAdmin().getPanelSede().devolverPaneles(1).setVisible(false);
			vista.getPanelControlAdmin().getPanelSede().devolverPaneles(2).setVisible(false);
			vista.getPanelControlAdmin().getPanelSede().devolverPaneles(3).setVisible(false);
			cargarSedesTabla();
			vista.repaint();

		} else if (command.equals("CREARSEDE")) {

			vista.getPanelControlAdmin().getPanelSede().devolverPaneles(1).setVisible(true);
			vista.getPanelControlAdmin().getPanelSede().devolverPaneles(2).setVisible(false);
			vista.getPanelControlAdmin().getPanelSede().devolverPaneles(3).setVisible(false);
			vista.getPanelControlAdmin().getPanelSede().devolverPaneles(4).setVisible(false);
			vista.repaint();

		} else if (command.equals("SAVESEDE")) {

			if (vista.getPanelControlAdmin().getPanelSede()
					.devolverTextField(0, vista.getPanelControlAdmin().getPanelSede().getCampoCrear()).getText()
					.isEmpty()
					|| vista.getPanelControlAdmin().getPanelSede()
							.devolverTextField(1, vista.getPanelControlAdmin().getPanelSede().getCampoCrear()).getText()
							.isEmpty()
					|| vista.getPanelControlAdmin().getPanelSede()
							.devolverTextField(2, vista.getPanelControlAdmin().getPanelSede().getCampoCrear()).getText()
							.isEmpty()) {

				vista.getPanelControlAdmin().getPanelSede().getToolkit().beep();
				vista.mostrarMensaje("Seño usuario hay campos vacios.");

			} else {

				if (vista.getPanelControlAdmin().getPanelSede()
						.devolverTextField(0, vista.getPanelControlAdmin().getPanelSede().getCampoCrear()).getText()
						.isBlank()
						|| vista.getPanelControlAdmin().getPanelSede()
								.devolverTextField(1, vista.getPanelControlAdmin().getPanelSede().getCampoCrear())
								.getText().isBlank()
						|| vista.getPanelControlAdmin().getPanelSede()
								.devolverTextField(2, vista.getPanelControlAdmin().getPanelSede().getCampoCrear())
								.getText().isBlank()) {

					vista.getPanelControlAdmin().getPanelSede().getToolkit().beep();
					vista.mostrarMensaje("Señor usuario hay campos vacios");

				} else {

					if (esNumero(vista.getPanelControlAdmin().getPanelSede()
							.devolverTextField(0, vista.getPanelControlAdmin().getPanelSede().getCampoCrear())
							.getText()) == true
							|| esNumero(vista.getPanelControlAdmin().getPanelSede()
									.devolverTextField(1, vista.getPanelControlAdmin().getPanelSede().getCampoCrear())
									.getText()) == false
							|| esNumero(vista.getPanelControlAdmin().getPanelSede()
									.devolverTextField(2, vista.getPanelControlAdmin().getPanelSede().getCampoCrear())
									.getText()) == false) {
						vista.getPanelControlAdmin().getPanelSede().getToolkit().beep();
						vista.mostrarMensaje("Señor usuario verifique los datos ingresados");
					} else {

						if (vista.getPanelControlAdmin().getPanelSede().getLocalidadCrear().getSelectedIndex() > 0) {

							casaApuesta.getSedesDAO().leerSedes();
							String nom = vista.getPanelControlAdmin().getPanelSede()
									.devolverTextField(0, vista.getPanelControlAdmin().getPanelSede().getCampoCrear())
									.getText();

							Double presu = Double.parseDouble(vista.getPanelControlAdmin().getPanelSede()
									.devolverTextField(1, vista.getPanelControlAdmin().getPanelSede().getCampoCrear())
									.getText());

							String localidad = (String) vista.getPanelControlAdmin().getPanelSede().getLocalidadCrear()
									.getSelectedItem();

							int empleados = Integer.parseInt(vista.getPanelControlAdmin().getPanelSede()
									.devolverTextField(2, vista.getPanelControlAdmin().getPanelSede().getCampoCrear())
									.getText());

							casaApuesta.getSedesDAO().crearSede(nom, presu, localidad, empleados);

							vista.getPanelControlAdmin().getPanelSede()
									.devolverTextField(0, vista.getPanelControlAdmin().getPanelSede().getCampoCrear())
									.setText("");

							vista.getPanelControlAdmin().getPanelSede()
									.devolverTextField(1, vista.getPanelControlAdmin().getPanelSede().getCampoCrear())
									.setText("");

							vista.getPanelControlAdmin().getPanelSede()
									.devolverTextField(2, vista.getPanelControlAdmin().getPanelSede().getCampoCrear())
									.setText("");

							vista.getPanelControlAdmin().getPanelSede().getLocalidadCrear().setSelectedIndex(0);

							vista.mostrarMensaje("Sede creada con exito. ");

						} else {

							vista.getPanelControlAdmin().getPanelSede().getToolkit().beep();
							vista.mostrarMensaje("Señor usuario no ha escogido ninguna localidad para la nueva sede. ");

						}

					}

				}

			}

		} else if (command.equals("MODIFICARSEDE")) {

			casaApuesta.getSedesDAO().leerSedes();
			vista.getPanelControlAdmin().getPanelSede().getSedesModificar().removeAllItems();
			vista.getPanelControlAdmin().getPanelSede().getSedesModificar().addItem("");

			for (int i = 0; i < casaApuesta.getSedesDAO().getSedes().size(); i++) {

				vista.getPanelControlAdmin().getPanelSede().getSedesModificar()
						.addItem(casaApuesta.getSedesDAO().getSedes().get(i).getNombre());

			}

			vista.getPanelControlAdmin().getPanelSede().devolverPaneles(1).setVisible(false);
			vista.getPanelControlAdmin().getPanelSede().devolverPaneles(2).setVisible(true);
			vista.getPanelControlAdmin().getPanelSede().devolverPaneles(3).setVisible(false);
			vista.getPanelControlAdmin().getPanelSede().devolverPaneles(4).setVisible(false);
			vista.repaint();

		} else if (command.equals("SAVEMODIFI")) {

			if (vista.getPanelControlAdmin().getPanelSede()
					.devolverTextField(0, vista.getPanelControlAdmin().getPanelSede().getCampoModificar()).getText()
					.isEmpty()
					|| vista.getPanelControlAdmin().getPanelSede()
							.devolverTextField(1, vista.getPanelControlAdmin().getPanelSede().getCampoModificar())
							.getText().isEmpty()
					|| vista.getPanelControlAdmin().getPanelSede()
							.devolverTextField(2, vista.getPanelControlAdmin().getPanelSede().getCampoModificar())
							.getText().isEmpty()) {

				vista.getPanelControlAdmin().getPanelSede().getToolkit().beep();
				vista.mostrarMensaje("Señor usuario hay campos vacios.");

			} else {

				if (vista.getPanelControlAdmin().getPanelSede()
						.devolverTextField(0, vista.getPanelControlAdmin().getPanelSede().getCampoModificar()).getText()
						.isBlank()
						|| vista.getPanelControlAdmin().getPanelSede()
								.devolverTextField(1, vista.getPanelControlAdmin().getPanelSede().getCampoModificar())
								.getText().isBlank()
						|| vista.getPanelControlAdmin().getPanelSede()
								.devolverTextField(2, vista.getPanelControlAdmin().getPanelSede().getCampoModificar())
								.getText().isBlank()) {

					vista.getPanelControlAdmin().getPanelSede().getToolkit().beep();
					vista.mostrarMensaje("Señor usuario hay campos vacios.");

				} else {

					if (vista.getPanelControlAdmin().getPanelSede().getLocalidadesModificar().getSelectedIndex() > 0
							|| vista.getPanelControlAdmin().getPanelSede().getSedesModificar().getSelectedIndex() > 0) {

						if (esNumero(vista.getPanelControlAdmin().getPanelSede()
								.devolverTextField(0, vista.getPanelControlAdmin().getPanelSede().getCampoModificar())
								.getText()) == true
								|| esNumero(vista.getPanelControlAdmin().getPanelSede()
										.devolverTextField(1,
												vista.getPanelControlAdmin().getPanelSede().getCampoModificar())
										.getText()) == false
								|| esNumero(vista.getPanelControlAdmin().getPanelSede()
										.devolverTextField(2,
												vista.getPanelControlAdmin().getPanelSede().getCampoModificar())
										.getText()) == false) {

							vista.mostrarMensaje("Valide datos de ingreso. ");
						} else {

							int pos = vista.getPanelControlAdmin().getPanelSede().getSedesModificar()
									.getSelectedIndex();

							String nom = vista.getPanelControlAdmin().getPanelSede().devolverTextField(0,
									vista.getPanelControlAdmin().getPanelSede().getCampoModificar()).getText();
							Double presu = Double
									.parseDouble(vista.getPanelControlAdmin().getPanelSede()
											.devolverTextField(1,
													vista.getPanelControlAdmin().getPanelSede().getCampoModificar())
											.getText());

							String localidad = (String) vista.getPanelControlAdmin().getPanelSede()
									.getLocalidadesModificar().getSelectedItem();

							int empleados = Integer
									.parseInt(vista.getPanelControlAdmin().getPanelSede()
											.devolverTextField(2,
													vista.getPanelControlAdmin().getPanelSede().getCampoModificar())
											.getText());

							casaApuesta.getSedesDAO().modificarSede(pos - 1, nom, presu, localidad, empleados);

							vista.mostrarMensaje("Sede editada con exito. ");

							casaApuesta.getSedesDAO().leerSedes();
							vista.getPanelControlAdmin().getPanelSede().getSedesModificar().removeAllItems();
							vista.getPanelControlAdmin().getPanelSede().getSedesModificar().addItem("");

							for (int i = 0; i < casaApuesta.getSedesDAO().getSedes().size(); i++) {

								vista.getPanelControlAdmin().getPanelSede().getSedesModificar()
										.addItem(casaApuesta.getSedesDAO().getSedes().get(i).getNombre());

							}

							vista.getPanelControlAdmin().getPanelSede()
									.devolverTextField(0,
											vista.getPanelControlAdmin().getPanelSede().getCampoModificar())
									.setText("");

							vista.getPanelControlAdmin().getPanelSede()
									.devolverTextField(1,
											vista.getPanelControlAdmin().getPanelSede().getCampoModificar())
									.setText("");

							vista.getPanelControlAdmin().getPanelSede()
									.devolverTextField(2,
											vista.getPanelControlAdmin().getPanelSede().getCampoModificar())
									.setText("");

							vista.getPanelControlAdmin().getPanelSede().getLocalidadesModificar().setSelectedIndex(0);

							vista.getPanelControlAdmin().getPanelSede().getSedesModificar().setSelectedIndex(0);

						}

					} else {

						vista.getPanelControlAdmin().getPanelSede().getToolkit().beep();
						vista.mostrarMensaje(
								"Valide sede a modificar o localidad de la sede (no pueden estar en blanco). ");

					}

				}
			}

		} else if (command.equals("ELIMINARSEDE")) {

			casaApuesta.getSedesDAO().leerSedes();
			vista.getPanelControlAdmin().getPanelSede().getSedesBorrar().removeAllItems();
			vista.getPanelControlAdmin().getPanelSede().getSedesBorrar().addItem("");

			for (int i = 0; i < casaApuesta.getSedesDAO().getSedes().size(); i++) {

				vista.getPanelControlAdmin().getPanelSede().getSedesBorrar()
						.addItem(casaApuesta.getSedesDAO().getSedes().get(i).getNombre());

			}

			vista.getPanelControlAdmin().getPanelSede().devolverPaneles(1).setVisible(false);
			vista.getPanelControlAdmin().getPanelSede().devolverPaneles(2).setVisible(false);
			vista.getPanelControlAdmin().getPanelSede().devolverPaneles(3).setVisible(true);
			vista.getPanelControlAdmin().getPanelSede().devolverPaneles(4).setVisible(false);
			vista.repaint();

		} else if (command.equals("BORRARSEDE")) {

			int selec = vista.getPanelControlAdmin().getPanelSede().getSedesBorrar().getSelectedIndex();

			if (!vista.getPanelControlAdmin().getPanelSede().getBorrar().isSelected()
					|| vista.getPanelControlAdmin().getPanelSede().getSedesBorrar().getSelectedIndex() == 0) {

				vista.getPanelControlAdmin().getPanelSede().getToolkit().beep();
				vista.mostrarMensaje("Señor usuario no confirmo eliminar la sede o no selecciono sede para eliminar. ");

			} else {
				casaApuesta.getSedesDAO().eliminarSede(selec - 1);

				vista.mostrarMensaje("Sede eliminada con exito.");

				casaApuesta.getSedesDAO().leerSedes();
				vista.getPanelControlAdmin().getPanelSede().getSedesBorrar().removeAllItems();
				vista.getPanelControlAdmin().getPanelSede().getSedesBorrar().addItem("");
				for (int i = 0; i < casaApuesta.getSedesDAO().getSedes().size(); i++) {

					vista.getPanelControlAdmin().getPanelSede().getSedesBorrar()
							.addItem(casaApuesta.getSedesDAO().getSedes().get(i).getNombre());

				}

				vista.getPanelControlAdmin().getPanelSede().getBorrar().setSelected(false);

			}

		} else if (command.equals("EVENTOS")) {

			vista.getPanelControlAdmin().getPanelEventos().setVisible(true);
			vista.getPanelControlAdmin().getPanelSede().setVisible(false);
			vista.getPanelControlAdmin().getPanelEventos().getTablaEventos().setVisible(false);
			vista.getPanelControlAdmin().getPanelEventos().getSptable().setVisible(false);
			vista.getPanelControlAdmin().getPanelEventos().devolverPaneles(0).setVisible(true);
			vista.getPanelControlAdmin().getPanelEventos().devolverPaneles(4).setVisible(true);
			vista.getPanelControlAdmin().getPanelEventos().devolverPaneles(1).setVisible(false);
			vista.getPanelControlAdmin().getPanelEventos().devolverPaneles(2).setVisible(false);
			vista.repaint();

			cargarListaSedesEventos(vista.getPanelControlAdmin().getPanelEventos().getListaSedes());

		} else if (command.equals("CREAR_EVENTO")) {

			casaApuesta.getSedesDAO().leerSedes();

			vista.getPanelControlAdmin().getPanelEventos().devolverPaneles(1).setVisible(true);
			vista.getPanelControlAdmin().getPanelEventos().devolverPaneles(4).setVisible(false);
			vista.repaint();

			casaApuesta.getSedesDAO().leerSedes();
			vista.getPanelControlAdmin().getPanelEventos().devolverBox(0).removeAllItems();
			vista.getPanelControlAdmin().getPanelEventos().devolverBox(0).addItem("");

			for (int i = 0; i < casaApuesta.getSedesDAO().getSedes().size(); i++) {

				vista.getPanelControlAdmin().getPanelEventos().devolverBox(0)
						.addItem(casaApuesta.getSedesDAO().getSedes().get(i).getNombre());

			}

		} else if (command.equals("SAVE_EVENTO")) {

			if (vista.getPanelControlAdmin().getPanelEventos().devolverTextField(0).getText().isEmpty()
					|| vista.getPanelControlAdmin().getPanelEventos().devolverTextField(1).getText().isEmpty()
					|| vista.getPanelControlAdmin().getPanelEventos().devolverTextField(0).getText().isBlank()
					|| vista.getPanelControlAdmin().getPanelEventos().devolverTextField(1).getText().isBlank()
					|| vista.getPanelControlAdmin().getPanelEventos().devolverCalendario(0).getDate() == null) {

				vista.mostrarMensaje("Señor usuario hay espacios en blanco :) ");

			} else {

				if (esNumero(vista.getPanelControlAdmin().getPanelEventos().devolverTextField(1).getText()) == false
						|| esNumero(vista.getPanelControlAdmin().getPanelEventos().devolverTextField(0)
								.getText()) == true) {

					vista.getPanelControlAdmin().getPanelEventos().getToolkit().beep();
					vista.mostrarMensaje("Valide datos ingresados");

				} else {
					if (vista.getPanelControlAdmin().getPanelEventos().devolverBox(0).getSelectedIndex() == 0) {

						vista.getPanelControlAdmin().getPanelEventos().getToolkit().beep();
						vista.mostrarMensaje("Seleccione sede del evento. ");
					} else {

						String nombre = vista.getPanelControlAdmin().getPanelEventos().devolverTextField(0).getText();

						Date hoy = new Date();
						String fecha = "";

						if (vista.getPanelControlAdmin().getPanelEventos().devolverCalendario(0).getDate()
								.compareTo(hoy) >= 0) {

							fecha = vista.getPanelControlAdmin().getPanelEventos().devolverCalendario(0).getDate()
									.toGMTString();

							String sede = vista.getPanelControlAdmin().getPanelEventos().devolverBox(0)
									.getSelectedItem().toString();

							int selecSede = vista.getPanelControlAdmin().getPanelEventos().devolverBox(0)
									.getSelectedIndex() - 1;

							Double presupuesto = 0.0;

							if (Double.parseDouble(vista.getPanelControlAdmin().getPanelEventos().devolverTextField(1)
									.getText()) <= casaApuesta.getSedesDAO().getSedes().get(selecSede)
											.getPresupuesto()) {

								presupuesto = Double.parseDouble(
										vista.getPanelControlAdmin().getPanelEventos().devolverTextField(1).getText());

								Double temp = casaApuesta.getSedesDAO().getSedes().get(selecSede).getPresupuesto()
										- presupuesto;

								casaApuesta.getSedesDAO().getSedes().get(selecSede).setPresupuesto(temp);

								casaApuesta.cargarEventosSedes(selecSede, nombre, sede, presupuesto, fecha);

								vista.mostrarMensaje("Evento creado con exito. ");

								vista.getPanelControlAdmin().getPanelEventos().devolverTextField(0).setText("");
								vista.getPanelControlAdmin().getPanelEventos().devolverTextField(1).setText("");
								vista.getPanelControlAdmin().getPanelEventos().devolverBox(0).setSelectedIndex(0);

							} else {
								vista.getPanelControlAdmin().getPanelEventos().getToolkit().beep();
								vista.mostrarMensaje("El valor ingresado supera el presupuesto de la sede. ");

							}

						} else {
							vista.getPanelControlAdmin().getPanelEventos().getToolkit().beep();
							vista.mostrarMensaje("Fecha invalida.");
						}

					}

				}

			}

		} else if (command.equals("ELIMINAR_EVENTO")) {
			vista.getPanelControlAdmin().getPanelEventos().devolverPaneles(1).setVisible(false);
			vista.getPanelControlAdmin().getPanelEventos().devolverPaneles(4).setVisible(false);
			vista.getPanelControlAdmin().getPanelEventos().devolverPaneles(2).setVisible(true);
			vista.repaint();

			cargarListaSedesEventos(vista.getPanelControlAdmin().getPanelEventos().getListaSedesBorrar());

		} else if (command.equals("BORRAR_EVENTO")) {

			int selecEvento = vista.getPanelControlAdmin().getPanelEventos().devolverBox(1).getSelectedIndex();
			int selecLista = vista.getPanelControlAdmin().getPanelEventos().getListaSedesBorrar().getSelectedIndex();

			if (selecEvento > 0 || vista.getPanelControlAdmin().getPanelEventos().getBorrar().isSelected()) {

				casaApuesta.getEventosDAO().eliminarEvento(selecLista, selecEvento - 1,
						casaApuesta.getSedesDAO().getSedes());
				vista.mostrarMensaje("Evento borrado con exito");

				vista.getPanelControlAdmin().getPanelEventos().devolverBox(1).removeAllItems();
				vista.getPanelControlAdmin().getPanelEventos().devolverBox(1).addItem("");
				for (int i = 0; i < casaApuesta.getSedesDAO().getSedes().get(selecLista).getEventos().size(); i++) {

					vista.getPanelControlAdmin().getPanelEventos().devolverBox(1).addItem(
							casaApuesta.getSedesDAO().getSedes().get(selecLista).getEventos().get(i).getNombreEvento());

				}
			} else {

				vista.getPanelControlAdmin().getPanelEventos().getToolkit().beep();
				vista.mostrarMensaje("Valide datos :) ");
			}

		}
	}

	public int validarUsuario(String user, String password) {

		int temp = 0;

		usuarioDAO.cargarUsuarios();
		casaApuesta.getAdminDAO().leerAdmnins();

		for (int i = 0; i < casaApuesta.getAdminDAO().getAdmins().size(); i++) {

			if (user.equals(casaApuesta.getAdminDAO().getAdmins().get(i).getUsuario())
					&& password.equals(casaApuesta.getAdminDAO().getAdmins().get(i).getContrasenia())) {
				temp = 1;
			}
		}

		for (int i = 0; i < usuarioDAO.getUsuarios().size(); i++) {
			if (user.equals(usuarioDAO.getUsuarios().get(i).getUsuario())
					&& password.equals(usuarioDAO.getUsuarios().get(i).getContrasenia())) {
				temp = 2;
			}
		}

		return temp;

	}

	public void oyentesBotonesRegistro() {
		for (int i = 0; i < 2; i++) {
			vista.getPanelRegistro().devolverBoton(i).addActionListener(this);
		}
	}

	public void cambiarPanel(Component panel) {
		vista.getContentPane().removeAll();
		vista.getContentPane().add(panel);
		panel.setVisible(true);
		vista.getContentPane().repaint();
	}

	public void tamanoVentanas(int x, int y) {
		vista.setSize(x, y);
		vista.setLocationRelativeTo(null);
	}

	public boolean comprobarNumerosLetras(String m) {
		if (m.length() > 9) {
			float numero = 0;
			try {
				numero = Float.parseFloat(m);
				if (numero < 0) {
					return false;
				}
				return true;
			} catch (NumberFormatException e) {
				return false;
			}
		} else {
			int numero = 0;
			try {
				numero = Integer.parseInt(m);
				if (numero < 1) {
					return false;
				}
				return true;
			} catch (NumberFormatException e) {
				return false;
			}
		}
	}

	public boolean comprobarCamposRegistro() {
		char[] pass = new char[1];
		String comprobarJText = "";
		for (int j = 0; j < 4; j++) {
			comprobarJText = vista.getPanelRegistro().devolverCampo(j).getText();
		}
		if (comprobarJText.length() == 0) {
			return false;
		} else {
			for (int k = 0; k < 2; k++) {
				pass = vista.getPanelRegistro().devolverContra(k).getPassword();
				comprobarJText = new String(pass);
			}
			if (comprobarJText.length() == 0) {
				return false;
			} else {
				if (!vista.getPanelRegistro().devolverRadioButton(0).isSelected()
						&& !vista.getPanelRegistro().devolverRadioButton(1).isSelected()
						&& !vista.getPanelRegistro().devolverRadioButton(2).isSelected()) {
					return false;
				} else {
					return true;
				}
			}

		}
	}

	@SuppressWarnings("deprecation")
	public int validarCampos() {
		String[] comprobarJText = new String[4];
		String contra = vista.getPanelRegistro().devolverContra(0).getText();
		String confirmarContra = vista.getPanelRegistro().devolverContra(1).getText();
		for (int j = 0; j < 4; j++) {
			comprobarJText[j] = vista.getPanelRegistro().devolverCampo(j).getText();
		}
		if (comprobarNumerosLetras(comprobarJText[0])) {

			return 1;
		} else if (!comprobarNumerosLetras(comprobarJText[1]) || !comprobarNumerosLetras(comprobarJText[3])) {
			return 2;
		} else if (comprobarJText[1].length() < 10 || comprobarJText[1].length() > 10 || comprobarJText[3].length() < 10
				|| comprobarJText[3].length() > 10) {
			return 4;
		} else if (!contra.equals(confirmarContra)) {
			return 5;
		} else if (vista.getPanelRegistro().getConfirmarEdad().isSelected() == false) {
			return 7;
		} else {
			char aux;
			char aux2;
			for (int i = 0; i < comprobarJText[2].length(); i++) {
				aux = comprobarJText[2].charAt(i);
				if (aux == '@') {
					return 3;
				}
			}
			for (int i = 0; i < comprobarJText[0].length(); i++) {
				aux2 = comprobarJText[0].charAt(i);
				if (aux2 == '@' || aux2 == '.' || aux2 == '<' || aux2 == '>' || aux2 == '-' || aux2 == '_') {
					return 6;
				}
			}
		}
		return 8;
	}

	private boolean esNumero(String m) {
		try {
			Double.parseDouble(m);
			return true;
		} catch (NumberFormatException nfe) {
			return false;

		}

	}

	public void cargarSedesTabla() {

		String headTable[];
		headTable = new String[4];
		headTable[0] = "Nombre";
		headTable[1] = "Presupuesto";
		headTable[2] = "Localidad";
		headTable[3] = "Empleados";

		String datos[][];

		casaApuesta.getSedesDAO().getFileSede().leerRegistros();
		datos = new String[casaApuesta.getSedesDAO().getSedes().size()][4];

		for (int i = 0; i < casaApuesta.getSedesDAO().getSedes().size(); i++) {

			datos[i][0] = casaApuesta.getSedesDAO().getSedes().get(i).getNombre();
			datos[i][1] = casaApuesta.getSedesDAO().getSedes().get(i).getPresupuesto().toString();
			datos[i][2] = casaApuesta.getSedesDAO().getSedes().get(i).getLocalidad();
			datos[i][3] = Integer.toString(casaApuesta.getSedesDAO().getSedes().get(i).getEmpleados());

		}

		DefaultTableModel modelo = new DefaultTableModel(datos, headTable);
		vista.getPanelControlAdmin().getPanelSede().getTablaSede().setModel(modelo);

		//return vista.getPanelControlAdmin().getPanelSede().getTablaSede();
	}
	public JTable cargarTabla() {
		String headTable[];
		headTable = new String[4];
		headTable[0] = "Nombre";
		headTable[1] = "Presupuesto";
		headTable[2] = "Localidad";
		headTable[3] = "Empleados";

		String datos[][];

		casaApuesta.getSedesDAO().getFileSede().leerRegistros();
		datos = new String[casaApuesta.getSedesDAO().getSedes().size()][4];

		for (int i = 0; i < casaApuesta.getSedesDAO().getSedes().size(); i++) {

			datos[i][0] = casaApuesta.getSedesDAO().getSedes().get(i).getNombre();
			datos[i][1] = casaApuesta.getSedesDAO().getSedes().get(i).getPresupuesto().toString();
			datos[i][2] = casaApuesta.getSedesDAO().getSedes().get(i).getLocalidad();
			datos[i][3] = Integer.toString(casaApuesta.getSedesDAO().getSedes().get(i).getEmpleados());

		}
		for (int i = 0; i <  casaApuesta.getSedesDAO().getSedes().size(); i++) {
			for (int j = 0; j < 4; j++) {
				System.out.println(datos[i][j]);
			}
		}
		JTable tabla = new JTable(datos, headTable);
	//	System.out.println(datos);
		System.out.println(headTable);
		return tabla;
	}

	public void cargarEventosTabla(int selec) {

		vista.getPanelControlAdmin().getPanelEventos().getTablaEventos().setVisible(true);
		vista.getPanelControlAdmin().getPanelEventos().getSptable().setVisible(true);
		vista.repaint();

		String headTable[];
		headTable = new String[4];
		headTable[0] = "Nombre";
		headTable[1] = "Sede";
		headTable[2] = "Presupuesto";
		headTable[3] = "Fecha";

		String datos[][];

		casaApuesta.getSedesDAO().getFileSede().leerRegistros();
		datos = new String[casaApuesta.getSedesDAO().getSedes().get(selec).getEventos().size()][4];

		for (int i = 0; i < casaApuesta.getSedesDAO().getSedes().get(selec).getEventos().size(); i++) {

			datos[i][0] = casaApuesta.getSedesDAO().getSedes().get(selec).getEventos().get(i).getNombreEvento();
			datos[i][1] = casaApuesta.getSedesDAO().getSedes().get(selec).getEventos().get(i).getSede();
			datos[i][2] = casaApuesta.getSedesDAO().getSedes().get(selec).getEventos().get(i).getPresupuesto()
					.toString();
			datos[i][3] = casaApuesta.getSedesDAO().getSedes().get(selec).getEventos().get(i).getFecha();

		}

		DefaultTableModel modelo = new DefaultTableModel(datos, headTable);
		vista.getPanelControlAdmin().getPanelEventos().getTablaEventos().setModel(modelo);

	}

	public void cargarListaSedesEventos(JList<String> lis) {

		DefaultListModel<String> lista = new DefaultListModel<String>();

		casaApuesta.getSedesDAO().leerSedes();

		for (int i = 0; i < casaApuesta.getSedesDAO().getSedes().size(); i++) {

			lista.addElement(casaApuesta.getSedesDAO().getSedes().get(i).getNombre());

		}

		lis.setModel(lista);

	}

	public void mouseListener() {
		vista.getPanelControlAdmin().getPanelEventos().getListaSedes().addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent me) {
				if (me.getClickCount() == 1) {
					JList target = (JList) me.getSource();
					int index = target.locationToIndex(me.getPoint());
					if (index >= 0) { // CARGA LOS DATOS SELECCIONADOS
						cargarEventosTabla(index); // ACTUALIZA
					}

				}
			}

		});

		vista.getPanelControlAdmin().getPanelEventos().getListaSedesBorrar().addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent me) {
				if (me.getClickCount() == 1) {
					JList target = (JList) me.getSource();
					int index = target.locationToIndex(me.getPoint());
					if (index >= 0) { // CARGA LOS DATOS SELECCIONADOS
						vista.getPanelControlAdmin().getPanelEventos().devolverBox(1).removeAllItems();
						vista.getPanelControlAdmin().getPanelEventos().devolverBox(1).addItem("");
						for (int i = 0; i < casaApuesta.getSedesDAO().getSedes().get(index).getEventos().size(); i++) {

							vista.getPanelControlAdmin().getPanelEventos().devolverBox(1).addItem(casaApuesta
									.getSedesDAO().getSedes().get(index).getEventos().get(i).getNombreEvento());

						}

					}

				}
			}

		});
	}

}
