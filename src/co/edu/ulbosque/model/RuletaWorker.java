package co.edu.ulbosque.model;

import java.util.Random;

import javax.swing.SwingWorker;

public class RuletaWorker extends SwingWorker<Integer, Void> {

	private Ruleta ruleta;
	private int giro = 0;	// giro de la ruleta
	private int tiempo = 6;	// tiempo en milisegundos por rotacion
	private int valorFinal = 0;
	
	public RuletaWorker(Ruleta ruleta, int valorFinal) {
		this.ruleta = ruleta;
		this.valorFinal = valorFinal;
	}
	
	@Override
	protected Integer doInBackground() throws Exception {
		int noGiros = 0;
		Random random = new Random();
		int noGirosTotal = random.nextInt(7) + 4;
		while(noGiros < noGirosTotal) {
			noGiros++;
			giro = 0;
			for (int i = 0; i < (valorFinal * 10); i++) {
				giro -= 10;
				ruleta.updatePosY(giro);
				Thread.sleep(tiempo);
			}
			
			tiempo += 2;
		}
		
		return -giro/100;
	}

}
