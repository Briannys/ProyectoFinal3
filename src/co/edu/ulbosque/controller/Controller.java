package co.edu.ulbosque.controller;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
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
				cambiarPanel(vista.getPanelRegistro());
			}else if (command.equals("INICIARSESIONREGISTRAR")) {
				tamanoVentanas(500, 350);
				cambiarPanel(vista.getPanelPortada());
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
}
