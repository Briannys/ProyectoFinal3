package co.edu.ulbosque.model.persistence;

import java.util.ArrayList;

import co.edu.ulbosque.model.Correo;
import co.edu.ulbosque.model.Usuario;

public class UsuarioDAO {
	private OperacionArchivo operacion;
	private ArrayList<Usuario> usuarios;
	
	public UsuarioDAO() {
		operacion = new OperacionArchivo();
		usuarios = new ArrayList<Usuario>();
	}
	
	public void agregarUsuario(Usuario a) throws ClassNotFoundException {
		if(operacion.obtener()!=null) {
			usuarios = operacion.obtener();
		}
		usuarios.add(a);
		operacion.escribir(usuarios);
	}
	
	public void imprimir() {
		for (Usuario a: usuarios) {
			System.out.println(a.toString());
		}
	}
	public boolean comprobarNombreUsuario(String usuario) throws ClassNotFoundException {
		usuarios = operacion.obtener();
		for(Usuario a:usuarios) {
			if(a.getUsuario().equals(usuario)) {
				return true;
			}
		}
		return false;
	}

}
