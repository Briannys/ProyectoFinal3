package co.edu.ulbosque.model;

import java.util.Random;

public class SuperAstro {

	private int numero1;
	private int numero2;
	private int numero3;
	private int numero4;
	private int numero5Astro;

	public SuperAstro() {
		generarAleatorios();
	}

	public void generarAleatorios() {
		this.numero1 = numeroAleatorio();
		this.numero2 = numeroAleatorio();
		this.numero3 = numeroAleatorio();
		this.numero4 = numeroAleatorio();
		this.numero5Astro = astroAleatorio();

	}

	private int numeroAleatorio() {
		Random numero = new Random();

		int minimum = 1;
		int maximum = 10;
		int random = (minimum + numero.nextInt((maximum - minimum)));
		return random;
	}

	private int astroAleatorio() {
		Random numero = new Random();

		int minimum = 1;
		int maximum = 12;
		int random = (minimum + numero.nextInt((maximum - minimum)));
		return random;
	}

	public int getSignoNumber(String signoSeleccionado) {
		for (int i = 0; i < signosZodiacales.length; i++) {
			if (signoSeleccionado.equals(signosZodiacales[i])) {
				return i;
			}
		}

		return 0;
	}

	private String signosZodiacales[] = { "Acuario", "Piscis", "Aries", " Tauro", "Géminis", "Cáncer", "Leo", "Virgo",
			"Libra", "Escorpio", "Sagitario", "Capricornio" };

	private Integer numero[] = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };

	public int getNumero1() {
		return numero1;
	}

	public int getNumero2() {
		return numero2;
	}

	public int getNumero3() {
		return numero3;
	}

	public int getNumero4() {
		return numero4;
	}

	public int getNumeroAstro() {
		return numero5Astro;
	}

	public String[] getSignosZodiacales() {
		return signosZodiacales;
	}

	public Integer[] getNumero() {
		return numero;
	}
}
