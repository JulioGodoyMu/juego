package juego3;

import java.awt.Rectangle;

public class Fantasma extends Enemigo{

	int xInicial = 1000,yInicial = 300,x,y;
	int incremento = 1, r  = 100;
	Rectangle posicion = new Rectangle(x,y,40,40);
	
	public Fantasma(String ruta) {
		super(ruta);
		
	}


	public Rectangle posicion() {
		incremento += 2;
		x = xInicial + (int)(100*Math.cos(incremento * Math.PI/180));
		y = yInicial + (int)(100*Math.sin(incremento * Math.PI/180));
		return new Rectangle(x,y,40,40);
	}

}
