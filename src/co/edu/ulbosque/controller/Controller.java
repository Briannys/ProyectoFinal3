package co.edu.ulbosque.controller;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import co.edu.ulbosque.model.Correo;
import co.edu.ulbosque.model.Usuario;
import co.edu.ulbosque.model.persistence.UsuarioDAO;
import co.edu.unbosque.view.VentanaPrincipal;

public class Controller implements ActionListener {
	private VentanaPrincipal vista;
	private UsuarioDAO usuarioDAO;

	public Controller() {
		usuarioDAO = new UsuarioDAO();
		vista = new VentanaPrincipal();
		asignarOyentes();
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
				transport.connect("houseappinc@gmail.com","warzone2020");
				transport.sendMessage(msg, msg.getAllRecipients());
				transport.close();
				System.out.println("Mesnaje enviado");
				return true;
			}catch(Exception e) {
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
		vista.getPanelInicioSesion().getReg().addActionListener(this);
		oyentesBotonesRegistro();
		vista.getPanelRegistro().devolverRadioButton(0).addActionListener(this);
		vista.getPanelRegistro().devolverRadioButton(1).addActionListener(this);
		vista.getPanelRegistro().devolverRadioButton(2).addActionListener(this);
		vista.getPanelPortada().getOlvidarContra().addActionListener(this);
		vista.getPanelPortada().getRegistrar().addActionListener(this);
		vista.getPanelRegistro().getIniciarSesion().addActionListener(this);
		vista.getPanelInicioSesion().getLogin().addActionListener(this);
		vista.getPanelInicioSesion().getReg().addActionListener(this);
		vista.getPanelInicioSesion().getAstro().addActionListener(this);
		vista.getPanelInicioSesion().getFutbol().addActionListener(this);
		vista.getPanelInicioSesion().getBaloto().addActionListener(this);
		vista.getPanelIniciarSesion().getAtras().addActionListener(this);
		vista.getPanelDecisionAdminUser().getUser().addActionListener(this);
		vista.getPanelDecisionAdminUser().getAdmin().addActionListener(this);
	
	}

	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		System.out.println(command);
		if (command.equals("REGISTRARSE")) {
			tamanoVentanas(600, 650);
			cambiarPanel(vista.getPanelRegistro());
		}else if (command.equals("CIUDADANIA")) {
			if (vista.getPanelRegistro().devolverRadioButton(0).isSelected() == true) {
				vista.getPanelRegistro().devolverRadioButton(1).setEnabled(false);
				vista.getPanelRegistro().devolverRadioButton(2).setEnabled(false);
			}else {
				vista.getPanelRegistro().devolverRadioButton(1).setEnabled(true);
				vista.getPanelRegistro().devolverRadioButton(2).setEnabled(true);
			} 
		}else if (command.equals("EXTRANJERIA")) {
			if (vista.getPanelRegistro().devolverRadioButton(1).isSelected() == true) {
				vista.getPanelRegistro().devolverRadioButton(0).setEnabled(false);
				vista.getPanelRegistro().devolverRadioButton(2).setEnabled(false);
			}else {
				vista.getPanelRegistro().devolverRadioButton(0).setEnabled(true);
				vista.getPanelRegistro().devolverRadioButton(2).setEnabled(true);
			}
		}else if (command.equals("PASAPORTE")) {
			if (vista.getPanelRegistro().devolverRadioButton(2).isSelected() == true) {
				vista.getPanelRegistro().devolverRadioButton(0).setEnabled(false);
				vista.getPanelRegistro().devolverRadioButton(1).setEnabled(false);
			}else {
				vista.getPanelRegistro().devolverRadioButton(0).setEnabled(true);
				vista.getPanelRegistro().devolverRadioButton(1).setEnabled(true);
			}
			}else if (command.equals("OLVIDARCONTRA")) {
				tamanoVentanas(500, 350);
				cambiarPanel(vista.getPanelOlvidarContra());
			}else if (command.equals("REGISTRATE")) {
				tamanoVentanas(600, 650);
				tamanoVentanas(550, 400);
				cambiarPanel(vista.getPanelDecisionAdminUser());
			}else if (command.equals("INICIARSESIONREGISTRAR")) {
				tamanoVentanas(500, 350);
				cambiarPanel(vista.getPanelPortada());
			}else if (command.equals("USERD")) {
				tamanoVentanas(600, 650);
				cambiarPanel(vista.getPanelRegistro());
			}else if (command.equals("INICIARSESION")) {
			System.out.println(command);
			tamanoVentanas(500, 350);
			cambiarPanel(vista.getPanelPortada());
		} else if (command.equals("BALOTO")) {

			vista.getPanelInicioSesion().setVisible(false);

		} else if (command.equals("SUPERASTRO")) {

			vista.getPanelInicioSesion().setVisible(false);

		} else if (command.equals("FUTBOL")) {
			vista.getPanelInicioSesion().setVisible(false);

		} else if(command.equals("ATR-SESION")) {
			vista.getPanelIniciarSesion().setVisible(false);
			vista.getPanelIniciarSesion().reiniciarTextos();
			tamanoVentanas(900, 700);
			cambiarPanel(vista.getPanelInicioSesion());
		}else if(command.equals("CANCELAR")) {
			vista.getPanelRegistro().setVisible(false);
			vista.getPanelIniciarSesion().reiniciarTextos();
			tamanoVentanas(900, 700);
			cambiarPanel(vista.getPanelInicioSesion());
		}else if(command.equals("REGISTRAR")) {
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
			Correo correoAux = new Correo(correo);
			if(contrasenia.equals(confirmaContra)) {
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
					String m= "";
					m = "ya hay un usuario";
				}
			} catch (ClassNotFoundException e1) {
				// TODO Bloque catch generado autom�ticamente
				e1.printStackTrace();
			}
			usuarioDAO.imprimir();	
		}
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
		if(m.length()>9) {
			float numero = 0;
			try {
				numero = Float.parseFloat(m);
				if(numero<0) {
					return false;
				}
				return true;
			}catch(NumberFormatException e) {
				return false;
			}
		}else {
			int numero = 0;
			try {
				numero = Integer.parseInt(m);
				if(numero<1) {
					return false;
				}
				return true;			
			}catch(NumberFormatException e) {
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
			}else {
				for (int k = 0; k < 2; k++) {
					pass = vista.getPanelRegistro().devolverContra(k).getPassword();
					comprobarJText = new String(pass);
				}
				if (comprobarJText.length() == 0) {
					return false;
				}else {
						if (!vista.getPanelRegistro().devolverRadioButton(0).isSelected() && !vista.getPanelRegistro().devolverRadioButton(1).isSelected() &&
								!vista.getPanelRegistro().devolverRadioButton(2).isSelected()) {
							return false;
						}else {
							return true;
					}	
				}
				
			}
	}
	@SuppressWarnings("deprecation")
	public int validarCampos() {
		String  [] comprobarJText = new String [4];
		String contra = vista.getPanelRegistro().devolverContra(0).getText();
		String confirmarContra = vista.getPanelRegistro().devolverContra(1).getText();
		for (int j = 0; j < 4; j++) {
			comprobarJText[j] = vista.getPanelRegistro().devolverCampo(j).getText();
		}
		if (comprobarNumerosLetras(comprobarJText[0])) {
		
			return 1;
		}else if (!comprobarNumerosLetras(comprobarJText[1]) || !comprobarNumerosLetras(comprobarJText[3])) {
			return 2;
		}else if (comprobarJText[1].length() < 10 || comprobarJText[1].length() > 10 || comprobarJText[3].length() < 10 || comprobarJText[3].length() > 10) {
			return 4;
		}else if (!contra.equals(confirmarContra)) {
			return 5;
		}else if (vista.getPanelRegistro().getConfirmarEdad().isSelected() == false) {
			return 7;
		}else {
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
				if (aux2 == '@' || aux2 == '.' || aux2 == '<' || aux2== '>' || aux2 == '-' || aux2 == '_' ) {
					return 6;
				}
			}
		}
	return 8;
	}
	
	
}
