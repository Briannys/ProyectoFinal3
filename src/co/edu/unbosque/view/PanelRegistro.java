package co.edu.unbosque.view;
import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import co.edu.ulbosque.controller.Controller;

public class PanelRegistro extends JFrame {
	private static final long serialVersionUID = 8930572727988761228L;
	
	private JComboBox<String> sedes;


	public PanelRegistro(Controller controller) {
		setTitle("Registro de Usuarios");
		setSize(600, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);


		JLabel panelTitle = new JLabel("<html><h1>Registro</h1></html>", SwingConstants.CENTER);
		add(panelTitle, BorderLayout.NORTH);

		JPanel datosRegistro = new JPanel();
		datosRegistro.setLayout(new GridLayout(0, 2));
		
		JLabel nombreUsuario = new JLabel("Nombres y Apellidos: " , SwingConstants.CENTER);
		datosRegistro.add(nombreUsuario);
		JTextField nombreUsuarioText = new JTextField();
		datosRegistro.add(nombreUsuarioText);
		
		JLabel cedulaUsuario = new JLabel("Cédula " , SwingConstants.CENTER);
		datosRegistro.add(cedulaUsuario);
		JTextField cedulaUsuarioTxt = new JTextField();
		datosRegistro.add(cedulaUsuarioTxt);
		
		JLabel sedeJuego = new JLabel("Sede: " , SwingConstants.CENTER);
		datosRegistro.add(sedeJuego);
		sedes = new JComboBox<String>();
		datosRegistro.add(sedes);
		
		JLabel direccionUsuario = new JLabel("Dirección: " , SwingConstants.CENTER);
		datosRegistro.add(direccionUsuario);
		JTextField direccionUsuarioTxt = new JTextField();
		datosRegistro.add(direccionUsuarioTxt);
		
		JLabel usuarioNick = new JLabel("Nombre de Usuario: " , SwingConstants.CENTER);
		datosRegistro.add(usuarioNick);
		JTextField usuarioNickTxt = new JTextField();
		datosRegistro.add(usuarioNickTxt);
		
		
		JLabel clave = new JLabel("Contraseña: " , SwingConstants.CENTER);
		datosRegistro.add(clave);
		JPasswordField claveTxt = new JPasswordField();
		datosRegistro.add(claveTxt);
		
		JLabel validarClave = new JLabel("Confirmar Contraseña: " , SwingConstants.CENTER);
		datosRegistro.add(validarClave);
		JPasswordField validarClavetxt = new JPasswordField();
		datosRegistro.add(validarClavetxt);

		
		add(datosRegistro , BorderLayout.CENTER);
			
			
		JPanel contenerBotones = new JPanel();	
		JButton aceptarRegistro = new JButton("Registrar");
		aceptarRegistro.setActionCommand("ACEPTAR_REGISTRO");
		aceptarRegistro.addActionListener(controller);
		contenerBotones.add(aceptarRegistro);
		JButton cancelarRegistro = new JButton("Cancelar");
		cancelarRegistro.setActionCommand("CANCELAR_REGISTRO");
		cancelarRegistro.addActionListener(controller);
		contenerBotones.add(cancelarRegistro);
		
		add(contenerBotones, BorderLayout.SOUTH);

		setVisible(true);
	}

}
