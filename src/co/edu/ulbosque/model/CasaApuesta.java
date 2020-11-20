package co.edu.ulbosque.model;

import co.edu.ulbosque.model.persistence.AdminDAO;
import co.edu.ulbosque.model.persistence.EventosDAO;
import co.edu.ulbosque.model.persistence.SedesDAO;

public class CasaApuesta {

	private SedesDAO sedesDAO;
	private EventosDAO eventosDAO;
	private AdminDAO adminDAO;

	public CasaApuesta() {

		sedesDAO = new SedesDAO();
		eventosDAO = new EventosDAO();
		adminDAO = new AdminDAO();

	}

	public void cargarEventosSedes(int selec, String nombre, String sede, Double presupuesto, String fecha) {

		sedesDAO.getSedes().get(selec).getEventos().add(eventosDAO.ingresarEvento(nombre, sede, presupuesto, fecha));

		sedesDAO.getFileSede().escribirRegistros(sedesDAO.getSedes());
	}
	

	/**
	 * @return the sedesDAO
	 */
	public SedesDAO getSedesDAO() {
		return sedesDAO;
	}

	/**
	 * @param sedesDAO the sedesDAO to set
	 */
	public void setSedesDAO(SedesDAO sedesDAO) {
		this.sedesDAO = sedesDAO;
	}

	/**
	 * @return the eventosDAO
	 */
	public EventosDAO getEventosDAO() {
		return eventosDAO;
	}

	/**
	 * @param eventosDAO the eventosDAO to set
	 */
	public void setEventosDAO(EventosDAO eventosDAO) {
		this.eventosDAO = eventosDAO;
	}

	/**
	 * @return the adminDAO
	 */
	public AdminDAO getAdminDAO() {
		return adminDAO;
	}

	/**
	 * @param adminDAO the adminDAO to set
	 */
	public void setAdminDAO(AdminDAO adminDAO) {
		this.adminDAO = adminDAO;
	}

}
