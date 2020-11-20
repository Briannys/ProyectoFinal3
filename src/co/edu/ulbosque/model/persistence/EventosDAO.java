package co.edu.ulbosque.model.persistence;

import java.util.ArrayList;


public class EventosDAO {

	private SedesFile file;

	public EventosDAO() {

		file = new SedesFile();

	}

	public EventosDTO ingresarEvento(String nombre, String sede, Double presupuesto, String fecha) {

		EventosDTO evento = new EventosDTO(nombre, sede, presupuesto, fecha);

		return evento;

	}

	public boolean leerEvento(int selec, ArrayList<SedesDTO> sedes) {

		boolean temp = false;

		if (sedes.get(selec).getEventos().size() != file.leerRegistros().size()) {

			if (file.leerRegistros().isEmpty()) {

				System.err.println("No hay eventos para leer");

			} else {

				for (int i = 0; i < file.leerRegistros().size(); i++) {

					sedes.get(selec).getEventos().add(file.leerRegistros().get(selec).getEventos().get(i));

				}

				System.out.println("Eventos leidos con exito.");

				temp = true;
			}
		} else {

			temp = false;

		}

		return temp;

	}
	
	public void eliminarEvento(int selec, int pos, ArrayList<SedesDTO> reg ) {
		
		reg.get(selec).getEventos().remove(pos);
		
		file.escribirRegistros(reg);
		
	}

}
