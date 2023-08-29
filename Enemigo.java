package juego3;

import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public abstract class Enemigo {
	
	private Image imagen;
	public int xInicial;
	public int xFinal;
		
	
	public Enemigo(String ruta) {
		try {
			imagen = ImageIO.read(new File(ruta));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public Image getImage() {
		return imagen;
	}
	
	//public abstract int movimiento();
	
	public abstract Rectangle posicion();
}
