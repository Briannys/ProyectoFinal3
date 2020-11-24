package co.edu.ulbosque.model.persistence;

import java.util.ArrayList;
import java.util.Calendar;

import co.edu.ulbosque.model.Apuesta;
import co.edu.ulbosque.model.Correo;
import co.edu.ulbosque.model.Usuario;

public class UsuarioDAO{
	private OperacionArchivo operacion;
	private ArrayList<Usuario> usuarios;
	
	Calendar today;

	public UsuarioDAO() {
		operacion = new OperacionArchivo();
		usuarios = new ArrayList<Usuario>();
		
		today = Calendar.getInstance();
	}
	
	public void agregarApuestaBaloto(Apuesta ap, Usuario user) throws ClassNotFoundException {
		if (operacion.obtener() != null) {
			usuarios = operacion.obtener();
		}
		for(Usuario a: usuarios) {
			if(a.getUsuario().equals(user.getUsuario())) {
				a.agregarApuesta(ap);
				int cantidad = a.getCantidadApuestasBaloto();
				cantidad++;
				a.setCantidadApuestasBaloto(cantidad);
			}
		}
		operacion.escribir(usuarios);
		
	}
	public void marcarVictoria(Usuario user) throws ClassNotFoundException {
		if (operacion.obtener() != null) {
			usuarios = operacion.obtener();
		}
		for(Usuario a: usuarios) {
			if(a.getUsuario().equals(user.getUsuario())) {
				a.getApuestas().get(a.getApuestas().size()-1).setVictoria(true);
			}
		}
		operacion.escribir(usuarios);
	}
	public void sobreescribirDadoUsuario(Usuario user, Long cantidad,Long cantidadGanada) throws ClassNotFoundException {
		//i = 1 -> si pierde
		//i = 0 -> si gana
		if (operacion.obtener() != null) {
			usuarios = operacion.obtener();
		}
		for(Usuario a: usuarios) {
			if(a.getUsuario().equals(user.getUsuario())) {
				if(cantidadGanada>0) {
					marcarVictoria(a);
				}
				Long saldoG = a.getSaldoGanado();
				Long total = saldoG+cantidadGanada;
				System.out.println("El total es "+total);
				a.setSaldoGanado(total);
				System.out.println("El saldo ganado es "+a.getSaldoGanado());
				a.setSaldoInvertidoBaloto(a.getSaldoInvertidoBaloto()+cantidad);
				a.setSaldoTotalInvertido(a.getSaldoTotalInvertido()+cantidad);
			}
			
		}
		operacion.escribir(usuarios);
	}
	public Usuario comprobarInicioSesion() throws ClassNotFoundException {
		if (operacion.obtener() != null) {
			usuarios = operacion.obtener();
		}
		for(Usuario a: usuarios) {
			if(a.isInicioSesion()) {
				return a;
			}
		}
		return null;
	}
	
	public Usuario obtenerUsuarioDadoCorreo(String m) throws ClassNotFoundException {
		if (operacion.obtener() != null) {
			usuarios = operacion.obtener();
		}
		for(Usuario a: usuarios) {
			if(a.getCorreo().getTo().equals(m)) {
				return a;
			}
		}
		return null;
	}
	
	
	public void obtenerArrayList() throws ClassNotFoundException {
		if (operacion.obtener() != null) {
			usuarios = operacion.obtener();
		}
	}
	
	public boolean cambiarContraseña(Usuario usuarioAux, String contraseniaNueva) throws ClassNotFoundException {
		boolean bandera = false;
		if (operacion.obtener() != null) {
			usuarios = operacion.obtener();
		}
		for(Usuario a: usuarios) {
			if(a.getUsuario().equals(usuarioAux.getUsuario())) {
				a.setContrasenia(contraseniaNueva);
				bandera = true;
			}
		}
		operacion.escribir(usuarios);
		return bandera;
	}
	
	
	
	public boolean buscarCorreo(String m) throws ClassNotFoundException {
		if (operacion.obtener() != null) {
			usuarios = operacion.obtener();
		}
		for(Usuario a: usuarios) {
			if(a.getCorreo().getTo().equals(m)) {
				return true;
			}
		}
		return false;
	}
	
	public void marcarUsuarioComoInicioSesion(Usuario us) {
		for(Usuario a: usuarios) {
			if(a.getUsuario().equals(us.getUsuario())) {
				a.setInicioSesion(true);
			}
		}
		operacion.escribir(usuarios);
	}
	
	public void desmarcarUsuarioComoInicioSesion() {
		for(Usuario a: usuarios) {
			if(a.isInicioSesion()) {
				a.setInicioSesion(false);
			}
		}
		operacion.escribir(usuarios);
	}
	
	public Usuario devolverUsuario(String usuario) throws ClassNotFoundException {
		if (operacion.obtener() != null) {
			usuarios = operacion.obtener();
		}
		for(Usuario a: usuarios) {
			if(a.getUsuario().equals(usuario)) {
				return a;
			}
		}
		return null;
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
		if (operacion.obtener() != null) {
			usuarios = operacion.obtener();
			for (Usuario a : usuarios) {
				if (a.getUsuario().equals(usuario)) {
					return true;
				}
			}
		}else {
			return false;
		}
		
		return false;
	}

	public void cargarUsuarios() {
		try {
			if(operacion.obtener()!=null) {
				if (operacion.obtener().size() != usuarios.size()) {
					for (int i = 0; i < operacion.obtener().size(); i++) {

						usuarios.add(operacion.obtener().get(i));
					}

				} else {
					
				System.out.println("Todos los usuarios han sido leidos.");	

				}
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
	public Calendar getToday() {
		return today;
	}
	/**
	 * @param today the today to set
	 */
	public void setToday(Calendar today) {
		this.today = today;
	}
	/**
	 * @return the usuarios
	 * @throws ClassNotFoundException 
	 */
	public ArrayList<Usuario> getUsuarios() throws ClassNotFoundException {
		if (operacion.obtener() != null) {
			usuarios = operacion.obtener();
		}
		return usuarios;
	}

	
	/**
	 * @param usuarios the usuarios to set
	 */
	public void setUsuarios(ArrayList<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

}
