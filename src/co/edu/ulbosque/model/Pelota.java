package co.edu.ulbosque.model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

public class Pelota {
	private static final int TAMX=45;
	
	private static final int TAMY=45;
	
	private double x=0;
	
	private double y=42;
	
	private final double dx=8;
	
	private final double dy=8;
	public void mueve_pelota(Rectangle2D limites){
		
		if((x>=0&&x<=200)&&y==42) {
			x+=dx;
		}
		//mov 2
		if(x >=200&&y<=142){
			x=200;
			y+=dy;
		
		}
		//mov 3
		if(x>=45&&(y==146)) {
			
			//dx=-dx;
			x-=dx;
			
		}
		//mov 4
		if(x<=44&&(y<=352&&y>=44)) {
			
			x = 44;
			y+=dy;
		
		}
		//mov 5
		if(x<=200&&y==354) {
			y = 354;
			x+=dx;
		}
		
	}
	
	//Forma de la pelota en su posici�n inicial
	
	public Ellipse2D getShape(){
		
		return new Ellipse2D.Double(x,y,TAMX,TAMY);
		
	}

	/**
	 * @return the x
	 */
	public double getX() {
		return x;
	}

	/**
	 * @param x the x to set
	 */
	public void setX(double x) {
		this.x = x;
	}

	/**
	 * @return the y
	 */
	public double getY() {
		return y;
	}

	/**
	 * @param y the y to set
	 */
	public void setY(double y) {
		this.y = y;
	}

	/**
	 * @return the dx
	 */
	public double getDx() {
		return dx;
	}

	
	

	/**
	 * @return the dy
	 */
	public double getDy() {
		return dy;
	}

	

	/**
	 * @return the tamx
	 */
	public static int getTamx() {
		return TAMX;
	}

	/**
	 * @return the tamy
	 */
	public static int getTamy() {
		return TAMY;
	}	
	
	
	
	

}
