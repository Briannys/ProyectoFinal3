package co.edu.ulbosque.model.persistence;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class SedesFile {

	private String ruta = "./Data/Sedes.dat";

	public void escribirRegistros(ArrayList<SedesDTO> reg) {

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

	public ArrayList<SedesDTO> leerRegistros() {
		ObjectInputStream in;
		ArrayList<SedesDTO> reg = new ArrayList<SedesDTO>();
		try {

			in = new ObjectInputStream(new FileInputStream(ruta));

			reg = (ArrayList<SedesDTO>) in.readObject();

			in.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return reg;

	}

}
