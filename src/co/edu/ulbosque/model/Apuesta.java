package co.edu.ulbosque.model;

import java.io.Serializable;

public class Apuesta implements Serializable{
	private String tipoApuesta="";
	private Long valor = (long)0;
	private String fechaApuesta="";
	private String sedeApuesta="";
	private boolean victoria = false;
	
	public Apuesta() {
		
	}
	public Apuesta(String tipoApuesta, Long valor, String fechaApuesta, String sedeApuesta) {
		this.tipoApuesta = tipoApuesta;
		this.valor = valor;
		this.fechaApuesta = fechaApuesta;
		this.sedeApuesta = sedeApuesta;
	}
	@Override
	public String toString() {
		String vic;
		if(victoria==false) {
			vic = "No";
		}else {
			vic = "Si";
		}
		return "Tipo apuesta; "+tipoApuesta+"\nValor "+valor+"\nFecha "+fechaApuesta
				+"\nSede "+sedeApuesta+"\nVictoria: "+vic;
	}
	
	/**
	 * @return the victoria
	 */
	public boolean isVictoria() {
		return victoria;
	}
	/**
	 * @param victoria the victoria to set
	 */
	public void setVictoria(boolean victoria) {
		this.victoria = victoria;
	}
	/**
	 * @return the tipoApuesta
	 */
	public String getTipoApuesta() {
		return tipoApuesta;
	}
	/**
	 * @param tipoApuesta the tipoApuesta to set
	 */
	public void setTipoApuesta(String tipoApuesta) {
		this.tipoApuesta = tipoApuesta;
	}
	/**
	 * @return the valor
	 */
	public Long getValor() {
		return valor;
	}
	/**
	 * @param valor the valor to set
	 */
	public void setValor(Long valor) {
		this.valor = valor;
	}
	/**
	 * @return the fechaApuesta
	 */
	public String getFechaApuesta() {
		return fechaApuesta;
	}
	/**
	 * @param fechaApuesta the fechaApuesta to set
	 */
	public void setFechaApuesta(String fechaApuesta) {
		this.fechaApuesta = fechaApuesta;
	}
	/**
	 * @return the sedeApuesta
	 */
	public String getSedeApuesta() {
		return sedeApuesta;
	}
	/**
	 * @param sedeApuesta the sedeApuesta to set
	 */
	public void setSedeApuesta(String sedeApuesta) {
		this.sedeApuesta = sedeApuesta;
	}
	
	

}
