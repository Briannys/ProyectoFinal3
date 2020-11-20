package co.edu.ulbosque.model.persistence;

import java.util.ArrayList;

import co.edu.ulbosque.model.Correo;

public class AdminDAO {

	private ArrayList<AdminDTO> admins;
	private AdminFile file;

	public AdminDAO() {

		admins = new ArrayList<>();
		file = new AdminFile();

	}

	public void ingresoAdmin(String nombre, Correo correo, String usuario, String telefono, String documentos,
			String fecha, String contraseña) {

		AdminDTO admi = new AdminDTO(nombre, correo, telefono, usuario, documentos, fecha, contraseña);

		admins.add(admi);

		file.escribirRegistros(admins);

	}

	public void leerAdmnins() {

		if (admins.size() != file.leerRegistros().size()) {
			for (int i = 0; i < file.leerRegistros().size(); i++) {

				admins.add(file.leerRegistros().get(i));
			}
		} else {
			System.out.println("Se han leido todos los administradores");

		}

	}

	public int comprobarUsuario(String nombre) {

		int temp = 0;
		leerAdmnins();

		for (int i = 0; i < admins.size(); i++) {

			if (nombre.equals(admins.get(i).getNombre())) {
				temp++;
			}
		}
		return temp;

	}

	/**
	 * @return the admins
	 */
	public ArrayList<AdminDTO> getAdmins() {
		return admins;
	}

	/**
	 * @param admins the admins to set
	 */
	public void setAdmins(ArrayList<AdminDTO> admins) {
		this.admins = admins;
	}

	/**
	 * @return the file
	 */
	public AdminFile getFile() {
		return file;
	}

	/**
	 * @param file the file to set
	 */
	public void setFile(AdminFile file) {
		this.file = file;
	}

}
