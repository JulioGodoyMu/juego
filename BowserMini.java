package juego3;

import java.awt.Point;
import java.awt.Rectangle;

public class BowserMini extends Enemigo {
	
	private int y,YInicial,YFinal;
	private int incremento = 3;
	private Rectangle posicion;
	
	public BowserMini(String ruta, int YInicial, int YFinal) {
		super(ruta);
		y = YInicial;
		this.YInicial = YInicial;
		this.YFinal = YFinal;
		posicion = new Rectangle(500,y,40,40);
	}
	
	/*public int movimiento() {
		y += incremento; 
		if(y <=YInicial || y >= YFinal) {
			incremento *= -1; 
		}
		return y;
	}*/

	public Rectangle posicion() {
		y += incremento; 
		if(y <=YInicial || y >= YFinal) {
			incremento *= -1; 
		}
		return new Rectangle(500,y,40,40);
	}
}
