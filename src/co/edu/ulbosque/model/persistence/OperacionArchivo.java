package co.edu.ulbosque.model.persistence;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import co.edu.ulbosque.model.Correo;
import co.edu.ulbosque.model.Usuario;

public class OperacionArchivo {
	private ObjectInputStream recuperar;
	private ObjectOutputStream escribir;
	Correo correoAdmin = new Correo("sergioeduardo2000@gmail.com");
	Usuario admin = new Usuario("Sergio",correoAdmin ,
			"3112648995", "Peamolon", "1007351989", "16/03/20000", "123456");
	public OperacionArchivo() {
		
		
	}
	public void escribir(ArrayList<Usuario> a) {
		try {
			ObjectOutputStream escribir = new ObjectOutputStream(new FileOutputStream("Data/Usuarios.dat"));
			escribir.writeObject(a);
			escribir.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	/*public void escribir(ArrayList<ApuestasBaloto> a, String file) {
		try {
			ObjectOutputStream escribir = new ObjectOutputStream(new FileOutputStream(file));
			escribir.writeObject(a);
			escribir.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}*/
	
	public ArrayList<Usuario> obtener() throws ClassNotFoundException {
		try {
			ObjectInputStream recuperar = new ObjectInputStream(new FileInputStream("Data/Usuarios.dat"));
			ArrayList<Usuario> aux =  (ArrayList<Usuario>) recuperar.readObject();
			recuperar.close();
			return aux;
			//System.out.println(a);
		} catch (EOFException e) {
			//System.out.println("Esta vacio");
			//e.printStackTrace();
			return null;
		}catch(IOException e) {
			//System.out.println("Error");
			return null;
		}
	}
	/*public ArrayList<ApuestasBaloto> obtener(String direccion) throws ClassNotFoundException {
		try {
			ObjectInputStream recuperar = new ObjectInputStream(new FileInputStream(direccion));
			ArrayList<ApuestasBaloto> aux =  (ArrayList<ApuestasBaloto>) recuperar.readObject();
			recuperar.close();
			return aux;
			//System.out.println(a);
		} catch (EOFException e) {
			//System.out.println("Esta vacio");
			//e.printStackTrace();
			return null;
		}catch(IOException e) {
			//System.out.println("Error");
			return null;
		}
	}*/
	/**
	 * @return the recuperar
	 */
	public ObjectInputStream getRecuperar() {
		return recuperar;
	}
	/**
	 * @param recuperar the recuperar to set
	 */
	public void setRecuperar(ObjectInputStream recuperar) {
		this.recuperar = recuperar;
	}
	/**
	 * @return the escribir
	 */
	public ObjectOutputStream getEscribir() {
		return escribir;
	}
	/**
	 * @param escribir the escribir to set
	 */
	public void setEscribir(ObjectOutputStream escribir) {
		this.escribir = escribir;
	}
	/**
	 * @return the correoAdmin
	 */
	public Correo getCorreoAdmin() {
		return correoAdmin;
	}
	/**
	 * @param correoAdmin the correoAdmin to set
	 */
	public void setCorreoAdmin(Correo correoAdmin) {
		this.correoAdmin = correoAdmin;
	}
	/**
	 * @return the admin
	 */
	public Usuario getAdmin() {
		return admin;
	}
	/**
	 * @param admin the admin to set
	 */
	public void setAdmin(Usuario admin) {
		this.admin = admin;
	}

}
