package juego3;

import java.awt.Point;
import java.awt.Rectangle;

public class Bola extends Enemigo{
	
	private int incremento = 1;
	private int x,xInicial,xFinal;
	private Rectangle posicion;
	
	public Bola(String ruta, int xInicial, int xFinal) {
		super(ruta);
		this.xInicial = xInicial;
		this.xFinal = xFinal;
		x = xInicial;
		posicion = new Rectangle(x,300,40,40);
	}

	/*public int movimiento() {
		x += incremento; 
		if(x <= xInicial || x >= xFinal) {
			incremento *= -1; 
		}
		return x;
	}*/

	public Rectangle posicion() {
		x += incremento; 
		if(x <= xInicial || x >= xFinal) {
			incremento *= -1; 
		}
		return new Rectangle(x,300,40,40);
	}
	
	

}
