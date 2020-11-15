package co.edu.ulbosque.model;

import java.io.Serializable;
import java.util.Random;

public class Correo implements Serializable{
	private final String PORT = "587";
	private final String BODY = String.join(System.getProperty("line.separator"), "Prueba de java");
	private final String from = "houseappinc@gmail.com";
	private String to = "";
	private final String contrasenia = "warzone2020";
	private final String fromname = "HouseApp";
	private final String subject = "HouseApp";
	private final String configSet = "ConfigSet";
	private String contraseniaGenerada = "";
	private final String asunto = "Cambio de contrasenia";
	private String mensaje = "";
	 
	public Correo(String to) {
		this.to = to;
		generarContrasenia();
		
	}
	public Correo() {
		
	}
	public void mensajeBienvenida(String nombre) {
		mensaje = "Bienvenido a la familia HouseBeat estimado/estimada "+nombre+"\n¡¡¡Gracias por registrarse con nosotros!!!"
				+"\nPara dudas, quejas o reclamos puede contactarse con houseappinc@gmail.com";
	}
	
	public void generarContrasenia() {
		int n = (int) (Math.random() * (9999999 + 1 - 1000000)) + 1000000;
		contraseniaGenerada = String.valueOf(n);
		mensaje = "Cambio de contraseña\nContraseña: "+contraseniaGenerada+"\n";
		mensaje+="Atentamente el equipo técnico de HouseApp";
	}
	
	
	public String getContrasenia() {
		return contrasenia;
	}
	public String getFrom() {
		return from;
	}
	
	
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getAsunto() {
		return asunto;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	public String getPORT() {
		return PORT;
	}
	public String getBODY() {
		return BODY;
	}
	public String getFromname() {
		return fromname;
	}
	public String getSubject() {
		return subject;
	}
	public String getConfigSet() {
		return configSet;
	}
	public String getContraseniaGenerada() {
		return contraseniaGenerada;
	}
	public void setContraseniaGenerada(String contraseniaGenerada) {
		this.contraseniaGenerada = contraseniaGenerada;
	}
	
	

}
