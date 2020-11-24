package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.text.StyledEditorKit.BoldAction;

import co.edu.ulbosque.model.Pelota;

public class LaminaPelota extends JPanel{
	private ArrayList<Pelota> pelotas=new ArrayList<Pelota>();
	private Dimension dimAux;
	private Dimension dimCanvas;
	private Image imagenAux;
	private JLabel numero;
	private Graphics gAux;
	JLabel imagen;
	
	
	public LaminaPelota() {
		setLayout(null);
		iniciar();
		setVisible(true);
		
		//super.paintComponent(g);
		setSize(300, 500);
	}
	
	private void iniciar() {
		setBackground(Color.white);
		
		numero = new JLabel("");
		numero.setBounds(218, 365, 30, 30);
		numero.setForeground(Color.white);
		numero.setFont(new Font("Century Gothic",Font.BOLD,15));
		numero.setVisible(true);
		add(numero);
	
		
		/*imagen = new JLabel(devolverImagen("balon", "png", 260, 400));
		imagen.setBounds(0, 0, 260, 400);
		add(imagen);*/
		
		
	}
	
	
	public void paintComponent(Graphics g){
		
		//super.paintComponent(g);
		if(gAux==null||dimAux == null||dimCanvas ==  null||dimCanvas.width!=dimCanvas.height||dimCanvas.height!=dimCanvas.width) {
			dimCanvas = this.getSize();
			dimAux = this.getSize();
			dimAux= dimCanvas; 
			imagenAux =createImage(dimAux.width, dimAux.height);
			gAux =  imagenAux.getGraphics();
		}
		g.setColor(Color.yellow);
		
		Graphics2D g2=(Graphics2D)gAux;
		Graphics2D rec = (Graphics2D)gAux;

		Graphics2D lineas[] = new Graphics2D[10];
		for (int i = 0; i < lineas.length; i++) {
			lineas[i] = (Graphics2D)gAux;
		}
		
		//1
		lineas[0].drawLine(0, 40, 250, 40);
		//2
		lineas[1].drawLine(250, 40, 250, 200);
		//3
		lineas[2].drawLine(90, 200, 250, 200);
		//4
		lineas[3].drawLine(90, 200, 90, 360);
		//5
		lineas[4].drawLine(90, 360, 250, 360);
		//6
		
		//7
		lineas[6].drawLine(0, 90, 200, 90);
		//8
		lineas[7].drawLine(40, 150, 200, 150);
		//9
		lineas[8].drawLine(40, 150, 40, 410);
		//10
		lineas[9].drawLine(40, 410, 250, 410);
		//11
		lineas[5].drawLine(200, 90, 200, 150);
		

		rec.setColor(Color.black);
		g2.setColor(Color.black);
		for(Pelota b: pelotas){
			g2.fill(b.getShape());
			
			
		}
		g.drawImage(imagenAux, 0, 0, this);
		g.setColor(Color.yellow);
	}
	
	public void eliminar() {
		pelotas.clear();
	}
	

	
	/**
	 * @return the pelotas
	 */
	public ArrayList<Pelota> getPelotas() {
		return pelotas;
	}

	/**
	 * @param pelotas the pelotas to set
	 */
	public void setPelotas(ArrayList<Pelota> pelotas) {
		this.pelotas = pelotas;
	}

	/**
	 * @return the dimAux
	 */
	public Dimension getDimAux() {
		return dimAux;
	}

	/**
	 * @param dimAux the dimAux to set
	 */
	public void setDimAux(Dimension dimAux) {
		this.dimAux = dimAux;
	}

	/**
	 * @return the dimCanvas
	 */
	public Dimension getDimCanvas() {
		return dimCanvas;
	}

	/**
	 * @param dimCanvas the dimCanvas to set
	 */
	public void setDimCanvas(Dimension dimCanvas) {
		this.dimCanvas = dimCanvas;
	}

	/**
	 * @return the imagenAux
	 */
	public Image getImagenAux() {
		return imagenAux;
	}

	/**
	 * @param imagenAux the imagenAux to set
	 */
	public void setImagenAux(Image imagenAux) {
		this.imagenAux = imagenAux;
	}

	/**
	 * @return the numero
	 */
	public JLabel getNumero() {
		return numero;
	}

	/**
	 * @param numero the numero to set
	 */
	public void setNumero(JLabel numero) {
		this.numero = numero;
	}

	/**
	 * @return the gAux
	 */
	public Graphics getgAux() {
		return gAux;
	}

	/**
	 * @param gAux the gAux to set
	 */
	public void setgAux(Graphics gAux) {
		this.gAux = gAux;
	}

	/**
	 * @return the imagen
	 */
	public JLabel getImagen() {
		return imagen;
	}

	/**
	 * @param imagen the imagen to set
	 */
	public void setImagen(JLabel imagen) {
		this.imagen = imagen;
	}

	public Icon devolverImagen(String a, String tipo, int tam,int tam2) {
		ImageIcon im = new ImageIcon(getClass().getResource("/imagenes/"+a+"."+tipo));
		ImageIcon ic = new ImageIcon(im.getImage().getScaledInstance(tam, tam2, Image.SCALE_DEFAULT));
		return ic;
	}
	

	public void add(Pelota b){
		dimCanvas = this.getSize();
		dimAux = this.getSize();
		pelotas.add(b);
	}
	@Override
	public void update(Graphics g) {
		paintComponent(g);
	}
	
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		
	}
	@Override
	public void show() {
		// TODO Auto-generated method stub
		super.show();
	}
	

}
