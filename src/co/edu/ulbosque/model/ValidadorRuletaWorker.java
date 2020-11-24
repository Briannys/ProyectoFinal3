package co.edu.ulbosque.model;

import java.awt.Color;
import java.util.concurrent.ExecutionException;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingWorker;

public class ValidadorRuletaWorker extends SwingWorker<Boolean, Void> {

	private RuletaWorker ruleta1;
	private RuletaWorker ruleta2;
	private RuletaWorker ruleta3;
	private RuletaWorker ruleta4;
	private RuletaWorker ruletaAstro;
	private JLabel visualizarGanoperdio;
	private JLabel creditos;
	private JTextField montoApuesta;

	private int valor1;
	private int valor2;
	private int valor3;
	private int valor4;
	private int valorAstro;

	public ValidadorRuletaWorker(RuletaWorker ruleta1, RuletaWorker ruleta2, RuletaWorker ruleta3, RuletaWorker ruleta4,
			RuletaWorker ruletaAstro, int valor1, int valor2, int valor3, int valor4, int valorAstro, JLabel label,
			JLabel label2, JTextField field) {
		this.ruleta1 = ruleta1;
		this.ruleta2 = ruleta2;
		this.ruleta3 = ruleta3;
		this.ruleta4 = ruleta4;
		this.ruletaAstro = ruletaAstro;

		this.valor1 = valor1;
		this.valor2 = valor2;
		this.valor3 = valor3;
		this.valor4 = valor4;
		this.valorAstro = valorAstro;
		visualizarGanoperdio = label;
		creditos = label2;
		montoApuesta = field;
	}

	@Override
	protected Boolean doInBackground() throws Exception {
		// Obtener el resultado de los workers
		int val1 = ruleta1.get();
		int val2 = ruleta2.get();
		int val3 = ruleta3.get();
		int val4 = ruleta4.get();
		int valAstro = ruletaAstro.get();

		if (val1 == valor1 || val2 == valor2 || val3 == valor3 || val4 == valor4 || valAstro == valorAstro) {

			return true;
		} else {
			return false;
		}
	}

	@Override
	protected void done() {
		try {
			if (get()) {
				creditos.setText(
						"" + (Integer.parseInt(creditos.getText()) + Integer.parseInt(montoApuesta.getText())));
				visualizarGanoperdio.setForeground(Color.RED);
				visualizarGanoperdio.setText("¡Has Ganado!");
			} else {
				creditos.setText(
						"" + (Integer.parseInt(creditos.getText()) - Integer.parseInt(montoApuesta.getText())));
				visualizarGanoperdio.setForeground(Color.RED);
				visualizarGanoperdio.setText("¡Has Perdido!");
			}
		} catch (InterruptedException | ExecutionException e) {
			System.err.println("InterruptedException: " + e.getMessage());
			e.printStackTrace();
		}
	}

}
