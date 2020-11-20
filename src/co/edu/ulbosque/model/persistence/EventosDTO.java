package co.edu.ulbosque.model.persistence;

import java.io.Serializable;

public class EventosDTO implements Serializable {

	private String nombreEvento;
	private String sede;
	private Double presupuesto;
	private String fecha;

	public EventosDTO(String nombreEvento, String sede, Double presu, String fecha) {

		this.nombreEvento = nombreEvento;
		this.sede = sede;
		this.presupuesto = presu;
		this.fecha = fecha;

	}

	/**
	 * @return the nombreEvento
	 */
	public String getNombreEvento() {
		return nombreEvento;
	}

	/**
	 * @param nombreEvento the nombreEvento to set
	 */
	public void setNombreEvento(String nombreEvento) {
		this.nombreEvento = nombreEvento;
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
	 * @return the presupuesto
	 */
		

	/**
	 * @return the fecha
	 */
	public String getFecha() {
		return fecha;
	}

	/**
	 * @return the presupuesto
	 */
	public Double getPresupuesto() {
		return presupuesto;
	}

	/**
	 * @param presupuesto the presupuesto to set
	 */
	public void setPresupuesto(Double presupuesto) {
		this.presupuesto = presupuesto;
	}

	/**
	 * @param fecha the fecha to set
	 */
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	@Override
	public String toString() {
		return "EventosDTO [nombreEvento=" + nombreEvento + ", sede=" + sede + ", presupuesto=" + presupuesto
				+ ", fecha=" + fecha + "]";
	}

}
