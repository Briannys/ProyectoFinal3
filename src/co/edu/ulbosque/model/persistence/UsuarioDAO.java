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
		if (operacion.obtener() != null) {
			usuarios = operacion.obtener();
		}
		usuarios.add(a);
		operacion.escribir(usuarios);
	}

	public void imprimir() {
		for (Usuario a : usuarios) {
			System.out.println(a.toString());
		}
	}

	public boolean comprobarNombreUsuario(String usuario) throws ClassNotFoundException {
		usuarios = operacion.obtener();
		for (Usuario a : usuarios) {
			if (a.getUsuario().equals(usuario)) {
				return true;
			}
		}
		return false;
	}

	public void cargarUsuarios() {
		try {
			if (operacion.obtener().size() != usuarios.size()) {
				for (int i = 0; i < operacion.obtener().size(); i++) {

					usuarios.add(operacion.obtener().get(i));
				}

			} else {
				
			System.out.println("Todos los usuarios han sido leidos.");	

			}
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}
	}

	/**
	 * @return the operacion
	 */
	public OperacionArchivo getOperacion() {
		return operacion;
	}

	/**
	 * @param operacion the operacion to set
	 */
	public void setOperacion(OperacionArchivo operacion) {
		this.operacion = operacion;
	}

	/**
	 * @return the usuarios
	 */
	public ArrayList<Usuario> getUsuarios() {
		return usuarios;
	}

	/**
	 * @param usuarios the usuarios to set
	 */
	public void setUsuarios(ArrayList<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

}
