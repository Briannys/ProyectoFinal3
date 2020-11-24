package co.edu.unbosque.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import co.edu.ulbosque.controller.Controller;
import co.edu.ulbosque.model.Ruleta;
import co.edu.ulbosque.model.SuperAstro;

public class PanelSuperstro extends JPanel {
	private static final long serialVersionUID = 8930572727988761228L;

	private SuperAstro superAstro;
	private JComboBox<Integer> numero1;
	private JComboBox<Integer> numero2;
	private JComboBox<Integer> numero3;
	private JComboBox<Integer> numero4;
	private JComboBox<String> signos;
	private JLabel creditos;
	private JLabel visualizarGanoPerdio;
	private JTextField montoApuesta;
	private JButton botonIniciar;

	private Ruleta ruletaNumeros1;
	private Ruleta ruletaNumeros2;
	private Ruleta ruletaNumeros3;
	private Ruleta ruletaNumeros4;
	private Ruleta ruletaAstro;

	private void initComponents() {
		
		superAstro = new SuperAstro();
		ruletaNumeros1 = new Ruleta("/co/edu/unbosque/res/superastro/num.png");
		ruletaNumeros2 = new Ruleta("/co/edu/unbosque/res/superastro/num.png");
		ruletaNumeros3 = new Ruleta("/co/edu/unbosque/res/superastro/num.png");
		ruletaNumeros4 = new Ruleta("/co/edu/unbosque/res/superastro/num.png");
		ruletaAstro = new Ruleta("/co/edu/unbosque/res/superastro/signos.png");

	}

	public PanelSuperstro() {
		setPreferredSize(new Dimension(800, 400));
		setSize(800, 400);
		initComponents();

		JPanel contenedorTableroJuego = new JPanel();

		setLayout(new BorderLayout());

		JPanel numeroTablero1 = new JPanel();
		numeroTablero1.setPreferredSize(new Dimension(130, 100));
		JLabel primerNumero = new JLabel("<html><h5>Seleccione  su " + "<br>" + "primer numero", SwingConstants.CENTER);
		numeroTablero1.add(primerNumero);
		numero1 = new JComboBox<Integer>(superAstro.getNumero());
		numeroTablero1.add(numero1);
		contenedorTableroJuego.add(numeroTablero1);

		JPanel numeroTablero2 = new JPanel();
		numeroTablero2.setPreferredSize(new Dimension(130, 100));
		JLabel segundoNumero = new JLabel("<html><h5>Seleccione  su " + "<br>" + "segundo numero",
				SwingConstants.CENTER);
		numeroTablero2.add(segundoNumero);
		numero2 = new JComboBox<Integer>(superAstro.getNumero());
		numeroTablero2.add(numero2);
		contenedorTableroJuego.add(numeroTablero2);

		JPanel numeroTablero3 = new JPanel();
		numeroTablero3.setPreferredSize(new Dimension(130, 100));
		JLabel tercerNumero = new JLabel("<html><h5>Seleccione  su " + "<br>" + "tercer numero", SwingConstants.CENTER);
		numeroTablero3.add(tercerNumero);
		numero3 = new JComboBox<Integer>(superAstro.getNumero());
		numeroTablero3.add(numero3);
		contenedorTableroJuego.add(numeroTablero3);

		JPanel numeroTablero4 = new JPanel();
		numeroTablero4.setPreferredSize(new Dimension(130, 100));
		JLabel cuartoNumero = new JLabel("<html><h5>Seleccione  su " + "<br>" + "cuarto numero", SwingConstants.CENTER);
		numeroTablero4.add(cuartoNumero);
		numero4 = new JComboBox<Integer>(superAstro.getNumero());
		numeroTablero4.add(numero4);
		contenedorTableroJuego.add(numeroTablero4);

		JPanel signoTablero5 = new JPanel();
		signoTablero5.setPreferredSize(new Dimension(130, 100));
		JLabel signoZodiac = new JLabel("<html><h5>Seleccione su " + "<br>" + "signo zodiacal", SwingConstants.CENTER);
		signoTablero5.add(signoZodiac);
		signos = new JComboBox<String>(superAstro.getSignosZodiacales());
		signoTablero5.add(signos);
		contenedorTableroJuego.add(signoTablero5);

		JPanel boton = new JPanel();
		botonIniciar = new JButton("Jugar");
		botonIniciar.setActionCommand("JUGAR_SUPER_ASTRO");
		boton.add(botonIniciar);
		contenedorTableroJuego.add(boton);

		add(contenedorTableroJuego, BorderLayout.NORTH);
		setVisible(true);

		JPanel apuestaResultado = new JPanel();

		Border borde = LineBorder.createGrayLineBorder();

		JPanel credito = new JPanel();
		credito.setLayout(new GridLayout(2, 0));
		credito.setBorder(borde);
		credito.setPreferredSize(new Dimension(200, 100));
		creditos = new JLabel(" ", SwingConstants.CENTER);
		creditos.setText("100000");
		credito.add(creditos);
		JLabel creditoDispo = new JLabel("Creditos para la apuesta", SwingConstants.CENTER);
		credito.add(creditoDispo);
		apuestaResultado.add(credito);

		JPanel apuesta = new JPanel();
		apuesta.setLayout(new GridLayout(2, 0));
		apuesta.setBorder(borde);
		apuesta.setPreferredSize(new Dimension(200, 100));
		JLabel valorApuesta = new JLabel("Valor que desea Apostar", SwingConstants.CENTER);
		montoApuesta = new JTextField();
		montoApuesta.setText("5000");
		apuesta.add(montoApuesta);
		apuesta.add(valorApuesta);
		apuestaResultado.add(apuesta);

		JPanel resultado = new JPanel();
		resultado.setLayout(new GridLayout(2, 0));
		resultado.setBorder(borde);
		resultado.setPreferredSize(new Dimension(200, 100));
		visualizarGanoPerdio = new JLabel(" ", SwingConstants.CENTER);
		resultado.add(visualizarGanoPerdio);
		JLabel resultadoApuesta = new JLabel("Resultado de su apuesta", SwingConstants.CENTER);
		resultado.add(resultadoApuesta);
		apuestaResultado.add(resultado);

		add(apuestaResultado, BorderLayout.CENTER);
		setVisible(true);

		JPanel contenedorNumerosSigno = new JPanel();

		Border border = LineBorder.createGrayLineBorder();

		JPanel num1 = new JPanel();
		num1.setPreferredSize(new Dimension(110, 110));
		num1.setBorder(border);
		num1.add(ruletaNumeros1);
		contenedorNumerosSigno.add(num1);

		JPanel num2 = new JPanel();
		num2.setPreferredSize(new Dimension(110, 110));
		num2.setBorder(border);
		num2.add(ruletaNumeros2);
		contenedorNumerosSigno.add(num2);

		JPanel num3 = new JPanel();
		num3.setPreferredSize(new Dimension(110, 110));
		num3.setBorder(border);
		num3.add(ruletaNumeros3);
		contenedorNumerosSigno.add(num3);

		JPanel num4 = new JPanel();
		num4.setPreferredSize(new Dimension(110, 110));
		num4.setBorder(border);
		num4.add(ruletaNumeros4);
		contenedorNumerosSigno.add(num4);

		JPanel signo = new JPanel();
		signo.setPreferredSize(new Dimension(110, 110));
		signo.setBorder(border);
		signo.add(ruletaAstro);
		contenedorNumerosSigno.add(signo);

		add(contenedorNumerosSigno, BorderLayout.SOUTH);
		setVisible(true);

	}

	public JComboBox<Integer> getNumero1() {
		return numero1;
	}

	public void setNumero1(JComboBox<Integer> numero1) {
		this.numero1 = numero1;
	}

	public JComboBox<Integer> getNumero2() {
		return numero2;
	}

	public void setNumero2(JComboBox<Integer> numero2) {
		this.numero2 = numero2;
	}

	public JComboBox<Integer> getNumero3() {
		return numero3;
	}

	public void setNumero3(JComboBox<Integer> numero3) {
		this.numero3 = numero3;
	}

	public JComboBox<Integer> getNumero4() {
		return numero4;
	}

	public void setNumero4(JComboBox<Integer> numero4) {
		this.numero4 = numero4;
	}

	public JComboBox<String> getSignos() {
		return signos;
	}

	public void setSignos(JComboBox<String> signos) {
		this.signos = signos;
	}

	public Ruleta getRuletaNumeros1() {
		return ruletaNumeros1;
	}

	public void setRuletaNumeros1(Ruleta ruletaNumeros1) {
		this.ruletaNumeros1 = ruletaNumeros1;
	}

	public Ruleta getRuletaNumeros2() {
		return ruletaNumeros2;
	}

	public void setRuletaNumeros2(Ruleta ruletaNumeros2) {
		this.ruletaNumeros2 = ruletaNumeros2;
	}

	public Ruleta getRuletaNumeros3() {
		return ruletaNumeros3;
	}

	public void setRuletaNumeros3(Ruleta ruletaNumeros3) {
		this.ruletaNumeros3 = ruletaNumeros3;
	}

	public Ruleta getRuletaNumeros4() {
		return ruletaNumeros4;
	}

	public void setRuletaNumeros4(Ruleta ruletaNumeros4) {
		this.ruletaNumeros4 = ruletaNumeros4;
	}

	public Ruleta getRuletaAstro() {
		return ruletaAstro;
	}

	public void setRuletaAstro(Ruleta ruletaAstro) {
		this.ruletaAstro = ruletaAstro;
	}

	public JLabel getVisualizarGanoPerdio() {
		return visualizarGanoPerdio;
	}

	public JLabel getCreditos() {
		return creditos;
	}

	public JTextField getMontoApuesta() {
		return montoApuesta;
	}

	public JButton getBtonIniciar() {
		return botonIniciar;
	}

}
