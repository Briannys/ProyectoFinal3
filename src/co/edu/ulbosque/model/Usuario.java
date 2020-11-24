package co.edu.ulbosque.model;

import java.io.Serializable;
import java.util.ArrayList;

public class Usuario extends Persona implements Serializable {

	private String nombre = "";
	private boolean inicioSesion = false;
	private Correo correo = null;
	private String telefono = "";
	private String usuario = "";
	private String documento = "";
	private String fechaNacimiento = "";
	private String contrasenia = "";
	private String sede = "";
	private ArrayList<Apuesta> apuestas;
	private Long saldoTotalInvertido;
	private Long saldoInvertidoBaloto;
	private Long saldoInvertidoAstro;
	private Long saldoInvertidoDeportes;
	private Long saldoGanado = (long)0;
	private String fechaRegistro;
	private int cantidadApuestasBaloto = 0;
	private int cantidadApuestasDeportes = 0;
	private int cantidadApuestasAstro = 0;
	

	public Usuario() {

	}

	public Usuario(String n) {
		nombre = n;
	}

	public Usuario(String nombre, Correo correo, String telefono, String usuario, String documento,
			String fechaNacimiento, String contrasenia) {
		apuestas = new ArrayList<Apuesta>();
		super.nombre = this.nombre = nombre;
		super.correo = this.correo = correo;
		super.telefono = this.telefono = telefono;
		super.usuario = this.usuario = usuario;
		super.documento = this.documento = documento;
		super.fechaNacimiento = this.fechaNacimiento = fechaNacimiento;
		super.contrasenia = this.contrasenia = contrasenia;
		saldoTotalInvertido = (long) 0;
		//saldoGanado = (long)0;
		saldoInvertidoBaloto= (long)0 ;
		saldoInvertidoAstro= (long)0;
		saldoInvertidoDeportes= (long)0;
		
	}
	
	public void agregarApuesta(Apuesta a) {
		apuestas.add(a);
	}
	
	public void modificarVictoria(int i) {
		apuestas.get(i).setVictoria(true);
	}

	@Override
	public String toString() {
		return "Nombre: " + nombre + "\nCorreo: " + correo.getTo() + "\nTelefono: " + telefono + "\nUsuario: " + usuario
				+ "\nDocumento: " + documento + "\nFecha Nacimiento: " + fechaNacimiento + "\nContrasenia: "
				+ contrasenia + "\nSaldo total invertido: "+saldoTotalInvertido+"\nSaldo invetido en baloto: "+saldoInvertidoBaloto
				+"\nSaldo invetido en astro: "+saldoInvertidoAstro+"\nSaldo invetido en deportes: "+saldoInvertidoDeportes
				+"\nSaldo ganado: "+saldoGanado+"\nSede: "+sede+"\nFecha registro "+fechaRegistro+"\nApuestas baloto: "+cantidadApuestasBaloto+
				"\nApuestas Deportes: "+cantidadApuestasDeportes+"\nApuestas Astro: "+cantidadApuestasAstro;
	}
	

	/**
	 * @return the apuestas
	 */
	public ArrayList<Apuesta> getApuestas() {
		return apuestas;
	}

	/**
	 * @param apuestas the apuestas to set
	 */
	public void setApuestas(ArrayList<Apuesta> apuestas) {
		this.apuestas = apuestas;
	}

	/**
	 * @return the cantidadApuestasBaloto
	 */
	public int getCantidadApuestasBaloto() {
		return cantidadApuestasBaloto;
	}

	/**
	 * @param cantidadApuestasBaloto the cantidadApuestasBaloto to set
	 */
	public void setCantidadApuestasBaloto(int cantidadApuestasBaloto) {
		this.cantidadApuestasBaloto = cantidadApuestasBaloto;
	}

	/**
	 * @return the cantidadApuestasDeportes
	 */
	public int getCantidadApuestasDeportes() {
		return cantidadApuestasDeportes;
	}

	/**
	 * @param cantidadApuestasDeportes the cantidadApuestasDeportes to set
	 */
	public void setCantidadApuestasDeportes(int cantidadApuestasDeportes) {
		this.cantidadApuestasDeportes = cantidadApuestasDeportes;
	}

	/**
	 * @return the cantidadApuestasAstro
	 */
	public int getCantidadApuestasAstro() {
		return cantidadApuestasAstro;
	}

	/**
	 * @param cantidadApuestasAstro the cantidadApuestasAstro to set
	 */
	public void setCantidadApuestasAstro(int cantidadApuestasAstro) {
		this.cantidadApuestasAstro = cantidadApuestasAstro;
	}

	/**
	 * @return the fechaRegistro
	 */
	public String getFechaRegistro() {
		return fechaRegistro;
	}

	/**
	 * @param fechaRegistro the fechaRegistro to set
	 */
	public void setFechaRegistro(String fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	/**
	 * @return the sede
	 */
	public String getSede() {
		return sede;
	}

	/**
	 * @param sede the sede to set
	 */
	public void setSede(String sede) {
		this.sede = sede;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the correo
	 */
	public Correo getCorreo() {
		return correo;
	}
	/**
	 * @return the saldoTotalInvertido
	 */
	public Long getSaldoTotalInvertido() {
		return saldoTotalInvertido;
	}

	/**
	 * @param saldoTotalInvertido the saldoTotalInvertido to set
	 */
	public void setSaldoTotalInvertido(Long saldoTotalInvertido) {
		this.saldoTotalInvertido = saldoTotalInvertido;
	}

	/**
	 * @return the saldoInvertidoBaloto
	 */
	public Long getSaldoInvertidoBaloto() {
		return saldoInvertidoBaloto;
	}

	/**
	 * @param saldoInvertidoBaloto the saldoInvertidoBaloto to set
	 */
	public void setSaldoInvertidoBaloto(Long saldoInvertidoBaloto) {
		this.saldoInvertidoBaloto = saldoInvertidoBaloto;
	}

	/**
	 * @return the saldoInvertidoAstro
	 */
	public Long getSaldoInvertidoAstro() {
		return saldoInvertidoAstro;
	}

	/**
	 * @param saldoInvertidoAstro the saldoInvertidoAstro to set
	 */
	public void setSaldoInvertidoAstro(Long saldoInvertidoAstro) {
		this.saldoInvertidoAstro = saldoInvertidoAstro;
	}

	/**
	 * @return the saldoInvertidoDeportes
	 */
	public Long getSaldoInvertidoDeportes() {
		return saldoInvertidoDeportes;
	}

	/**
	 * @param saldoInvertidoDeportes the saldoInvertidoDeportes to set
	 */
	public void setSaldoInvertidoDeportes(Long saldoInvertidoDeportes) {
		this.saldoInvertidoDeportes = saldoInvertidoDeportes;
	}



	/**
	 * @return the saldoGanado
	 */
	public Long getSaldoGanado() {
		return saldoGanado;
	}

	/**
	 * @param saldoGanado the saldoGanado to set
	 */
	public void setSaldoGanado(Long saldoGanado) {
		this.saldoGanado = saldoGanado;
	}

	/**
	 * @param correo the correo to set
	 */
	public void setCorreo(Correo correo) {
		this.correo = correo;
	}

	/**
	 * @return the inicioSesion
	 */
	public boolean isInicioSesion() {
		return inicioSesion;
	}

	/**
	 * @param inicioSesion the inicioSesion to set
	 */
	public void setInicioSesion(boolean inicioSesion) {
		this.inicioSesion = inicioSesion;
	}

	/**
	 * @return the telefono
	 */
	public String getTelefono() {
		return telefono;
	}

	/**
	 * @param telefono the telefono to set
	 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	/**
	 * @return the usuario
	 */
	public String getUsuario() {
		return usuario;
	}

	/**
	 * @param usuario the usuario to set
	 */
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	/**
	 * @return the documento
	 */
	public String getDocumento() {
		return documento;
	}

	/**
	 * @param documento the documento to set
	 */
	public void setDocumento(String documento) {
		this.documento = documento;
	}

	/**
	 * @return the fechaNacimiento
	 */
	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	/**
	 * @param fechaNacimiento the fechaNacimiento to set
	 */
	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	/**
	 * @return the contrasenia
	 */
	public String getContrasenia() {
		return contrasenia;
	}

	/**
	 * @param contrasenia the contrasenia to set
	 */
	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	/**
	 * @return the creditos
	 */
	public Long getCreditos() {
		return saldoTotalInvertido;
	}

	/**
	 * @param creditos the creditos to set
	 */
	public void setCreditos(Long creditos) {
		this.saldoTotalInvertido = creditos;
	}

}
