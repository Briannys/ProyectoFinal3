package co.edu.ulbosque.model.persistence;

import java.util.ArrayList;

public class SedesDAO {

	private ArrayList<SedesDTO> sedes;
	private SedesFile fileSede;

	public SedesDAO() {

		sedes = new ArrayList<>();
		fileSede = new SedesFile();

	}

	public void leerSedes() {
		if (sedes.size() != fileSede.leerRegistros().size()) {
			for (int i = 0; i < fileSede.leerRegistros().size(); i++) {
				sedes.add(fileSede.leerRegistros().get(i));
			}
		} else {
			System.out.println("Todas las sedes leidas con exito. ");
		}

	}

	public void crearSede(String nombreSede, Double presupuesto, String localidad, int empleados) {

		sedes.add(new SedesDTO(nombreSede, presupuesto, localidad, empleados));

		fileSede.escribirRegistros(sedes);

	}

	public void modificarSede(int pos, String nom, Double presu, String localidad, int empleados) {

		sedes.get(pos).setNombre(nom);
		sedes.get(pos).setPresupuesto(presu);
		sedes.get(pos).setEmpleados(empleados);
		sedes.get(pos).setLocalidad(localidad);
		fileSede.escribirRegistros(sedes);

		System.out.println("Sede editada con exito.");
	}

	public void eliminarSede(int pos) {

		sedes.remove(pos);

		fileSede.escribirRegistros(sedes);
		
		
	}

	/**
	 * @return the sedes
	 */
	public ArrayList<SedesDTO> getSedes() {
		return sedes;
	}

	/**
	 * @param sedes the sedes to set
	 */
	public void setSedes(ArrayList<SedesDTO> sedes) {
		this.sedes = sedes;
	}

	/**
	 * @return the fileSede
	 */
	public SedesFile getFileSede() {
		return fileSede;
	}

	/**
	 * @param fileSede the fileSede to set
	 */
	public void setFileSede(SedesFile fileSede) {
		this.fileSede = fileSede;
	}

}
