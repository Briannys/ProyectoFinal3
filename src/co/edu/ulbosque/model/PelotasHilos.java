package co.edu.ulbosque.model;

import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Component;

import co.edu.unbosque.view.LaminaPelota;
import co.edu.unbosque.view.PanelPrincipal;

public class PelotasHilos implements Runnable{
	private Pelota pelota;
	private AudioClip sonido;
	private PanelPrincipal principal;
	private LaminaPelota pPelota;
	private Component comp;
	public PelotasHilos(Pelota pelota, Component comp) {
		this.pelota = pelota;
		this.comp = comp;
		sonido = java.applet.Applet.newAudioClip(getClass().getResource("/musica/SonidoBolasCortado.wav"));
		pPelota = new LaminaPelota();
		principal = new PanelPrincipal();
	}
	
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		sonido.play();
		for (int i=1; i<=150; i++){
			
			pelota.mueve_pelota(comp.getBounds());
			
			comp.paint(comp.getGraphics());
			try {
				Thread.sleep(4);
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt(); 
			}
			if(i==149) {
				pPelota.getNumero().setForeground(Color.BLACK);
			}
			
		}
	
		
		sonido.stop();
		
		
		
	}
	
	
	

}
