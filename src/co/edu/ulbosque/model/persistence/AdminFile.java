package co.edu.ulbosque.model.persistence;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class AdminFile {

	private String ruta;

	public AdminFile() {

		ruta = "./Data/admin.dat";

	}

	public void escribirRegistros(ArrayList<AdminDTO> reg) {

		try {
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(ruta));
			out.writeObject(reg);
			out.close();
			System.out.println("dato ingresado con exito");

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error de IO");
		}

	}

	public ArrayList<AdminDTO> leerRegistros() {
		ObjectInputStream in;
		ArrayList<AdminDTO> reg = new ArrayList<AdminDTO>();
		try {

			in = new ObjectInputStream(new FileInputStream(ruta));

			reg = (ArrayList<AdminDTO>) in.readObject();

			in.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return reg;

	}

}
