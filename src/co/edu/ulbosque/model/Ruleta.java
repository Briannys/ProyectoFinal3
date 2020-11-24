package co.edu.ulbosque.model;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JComponent;

public class Ruleta extends JComponent {

	private static final long serialVersionUID = -6483306239487183221L;
	private ImageIcon imagen;
	private int posicionY = 0;

	private Dimension d = new Dimension(100, 100);

	// ImageIcon(getClass().getResource("/co/edu/unbosque/res/superastro/num.png"));
	public Ruleta(String imagePath) {
		imagen = new ImageIcon(getClass().getResource(imagePath));
		setSize(d);
		setPreferredSize(d);
		setVisible(true);
	}

	public void updatePosY(int value) {
		this.posicionY = value;
		repaint();
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.drawImage(imagen.getImage(), 0, posicionY, imagen.getIconWidth(), imagen.getIconHeight(), this);
	}

}
