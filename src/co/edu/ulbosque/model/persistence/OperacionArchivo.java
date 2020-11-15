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
	
	/*
	public void eliminar(ArrayList<Usuario> usuarios, Usuario usuario) throws ClassNotFoundException {
		usuarios = recuperar();
		usuarios.remove(usuario);
		try {
			escribir.writeObject(usuarios);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void agregarUsuario(ArrayList<Usuario> usuarios,Usuario usuario) {
		
		try {
			usuarios = recuperar();
			ObjectOutputStream escribir = new ObjectOutputStream(new FileOutputStream("Data/usuarios.dat"));
			usuarios.add(usuario);
			escribir.writeObject(usuarios);
			
			escribir.close();
			
		}catch(IOException e) {
			System.out.println("No se encontro el archivo");
		}catch(ClassNotFoundException e) {
			System.out.println("F");
		}
	}
	
	public void agregaAdmin(ArrayList<Usuario> usuarios) {
		Correo correoAdmin = new Correo("sergioeduardo2000@gmail.com");
		Usuario admin = new Usuario("Sergio", "Penia",correoAdmin ,
				"3112648995", "Peamolon", "1007351989", "16/03/20000", "123456");
		ObjectOutputStream escribir;
		try {
			escribir = new ObjectOutputStream(new FileOutputStream("Data/usuarios.dat"));
			usuarios.add(admin);
			escribir.writeObject(usuarios);
			escribir.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ArrayList<Usuario>recuperar() throws ClassNotFoundException{
		
		try {
			recuperar = new ObjectInputStream(new FileInputStream("Data/usuarios.dat"));
			ArrayList<Usuario> aux  =  (ArrayList<Usuario>) recuperar.readObject();
			recuperar.close();
			return aux;
			//System.out.println(a);
		} catch (EOFException e) {
			
			e.printStackTrace();
			return null;
		}
		//return null; 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	*/

}
