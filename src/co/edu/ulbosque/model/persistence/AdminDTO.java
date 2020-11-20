package co.edu.ulbosque.model.persistence;

import java.io.Serializable;

import co.edu.ulbosque.model.Correo;
import co.edu.ulbosque.model.Persona;
import co.edu.ulbosque.model.Usuario;

public class AdminDTO extends Persona implements Serializable {

	private String nombre = "";
	private Correo correo = null;
	private String telefono = "";
	private String usuario = "";
	private String documento = "";
	private String fechaNacimiento = "";
	private String contrasenia = "";

	public AdminDTO(String nombre, Correo correo, String telefono, String usuario, String documento,
			String fechaNacimiento, String contraseña) {

		super.nombre = this.nombre = nombre;
		super.correo = this.correo = correo;
		super.telefono = this.telefono = telefono;
		super.usuario = this.usuario = usuario;
		super.documento = this.documento = documento;
		super.fechaNacimiento = this.fechaNacimiento = fechaNacimiento;
		super.contrasenia = this.contrasenia = contraseña;

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
	 * @param correo the correo to set
	 */
	public void setCorreo(Correo correo) {
		this.correo = correo;
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

	@Override
	public String toString() {
		return "nombre= " + nombre + ", correo= " + correo + ", telefono= " + telefono + ", usuario= " + usuario
				+ ", documento= " + documento + ", fechaNacimiento= " + fechaNacimiento + ", contrasenia= "
				+ contrasenia;
	}

}
