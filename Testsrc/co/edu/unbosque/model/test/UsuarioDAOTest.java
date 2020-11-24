package co.edu.unbosque.model.test;

import java.io.File;
import java.util.ArrayList;

import co.edu.ulbosque.model.Correo;
import co.edu.ulbosque.model.Usuario;
import co.edu.ulbosque.model.persistence.OperacionArchivo;
import co.edu.ulbosque.model.persistence.UsuarioDAO;
import junit.framework.TestCase;

public class UsuarioDAOTest extends TestCase{
	UsuarioDAO usuarioDao;
	OperacionArchivo archivo;
	File file;
	ArrayList<Usuario> usuarios;
	Usuario usuario1;
	Usuario usuario2;
	Usuario usuario3;
	Usuario usuario4;
	Usuario usuario5;
	
	public UsuarioDAOTest() {
		setUpEscenario();
		assertEquals("La cantidad de usuarios debe ser 4",4,usuarios.size());
	}
	
	
	
	public void setUpEscenario() {
		file = new File("Data/basededatosUsuarioTest.dat");
		archivo = new OperacionArchivo();
		usuarioDao = new UsuarioDAO();
		usuarios = new ArrayList<Usuario>();
		
		Correo correo1 = new Correo("pedro03@gmail.com");
		usuario1 = new Usuario("Pedro", correo1, "3115678934",
				"pedro965", "1009673412", "16/03/1998", "12345");
		usuarios.add(usuario1);
		
		Correo correo2 = new Correo("LuchitoE@gmail.com");
		usuario2 = new Usuario("Luis Eduardo", correo2, "3115472334",
				"Lucho51", "1003173412", "26/07/1990", "12345");
		usuarios.add(usuario2);
		
		Correo correo3 = new Correo("Nat-45@gmail.com");
		usuario3 = new Usuario("Natalia", correo3, "3115699934",
				"natixGar", "1056783412", "30/09/2000", "12345");
		usuarios.add(usuario3);
		
		Correo correo4 = new Correo("Sandra9811@gmail.com");
		usuario4 = new Usuario("Sandra", correo4, "3135628912",
				"San_23", "1075312412", "06/01/1988", "12345");
		usuarios.add(usuario4);
		usuario5 = new Usuario("David");
		
		archivo.escribir(usuarios);
		
	}
	
	public void testCambiarContra() throws ClassNotFoundException {
		setUpEscenario();
		assertTrue("Se debio haber cambiado la contraseña",usuarioDao.cambiarContraseña(usuario1,"66445"));
		assertFalse("No se debe cambiar la contraseña de un usuario no leído en el archivo",usuarioDao.cambiarContraseña(usuario5, "234"));
	}
	
	public void testBuscarCorreo() throws ClassNotFoundException {
		assertTrue("Se debio haber encontrado el correo",usuarioDao.buscarCorreo("Sandra9811@gmail.com"));
		assertFalse("No se debio haber encontrado el correo",usuarioDao.buscarCorreo("pepito67@gmail.com"));	
	}
	
	public void testObtenerUsuario() throws ClassNotFoundException {
		assertNull("No se debio encontrar a un usuario no agregado al archivo",usuarioDao.devolverUsuario("perri67"));
		assertNotNull("Se debe encontrar al usuario agregado al archivo", usuarioDao.devolverUsuario("natixGar"));
	}
	
	public void testComprobarNumeroUsuario() throws ClassNotFoundException {
		assertFalse("No se debio encontrar a un usuario no agregado al archivo",usuarioDao.comprobarNombreUsuario("jimmy67"));
		assertTrue("Se debe encontrar al usuario agregado al archivo",usuarioDao.comprobarNombreUsuario("Lucho51") );
	}
	

}
