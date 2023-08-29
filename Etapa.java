package juego3;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;



public class Etapa extends Component implements KeyListener{

	final int CONT_SALTO = 20;
    private Image mario;
    private Image game_over;
    public Point posicion;
    public boolean saltar = false;
    private boolean gameOver = false;
    //private boolean derechaOIzquierda = true;
    private Enemigo[] enemigos;
    private boolean colision = true;
    private boolean salto  = false;
    private int cuentaSalto;

    public Etapa() {
        try {
            mario =  ImageIO.read(new File("mario bros.png"));
            game_over = ImageIO.read(new File("game over.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        posicion = new Point(100,300);
        enemigos = new Enemigo[3];
        enemigos[0] = new BowserMini("bowser1.png",100,300);
        enemigos[1] = new Bola("bola.png",200,300);
        enemigos[2]= new Fantasma("fantasma.png");
        //Thread hilo = new Thread(this); 
        //hilo.start();

    }

    public void paint(Graphics g) {
    	super.paint(g);
    	g.setColor(Color.green);
        g.fillRect(0, 340,1500, 200);
        if(salto) {
			if(cuentaSalto >= CONT_SALTO/2) {
				posicion.y -= 8;
				posicion.x += 6;
			}else {
				posicion.y += 8;
				posicion.x += 6;
			}	
			if(cuentaSalto < 0) {
				salto = false;
			}
			cuentaSalto--;
		}
        if(posicion.x >= 1200) {
        	g.setFont(new Font("Arial", Font.BOLD, 40));
        	g.setColor(Color.BLUE);
        	g.drawString("ganaste", 540, 230);
        }else {        	
	        g.drawImage(mario,posicion.x,posicion.y,40,40,null);
	        g.drawImage(enemigos[1].getImage(),enemigos[1].posicion().x,enemigos[1].posicion().y, 40,40,null);
	        g.drawImage(enemigos[0].getImage(),enemigos[0].posicion().x,enemigos[0].posicion().y,40,40,null);
	        g.drawImage(enemigos[2].getImage(),enemigos[2].posicion().x,enemigos[2].posicion().y,40,40,null);
	        if(gameOver)
	        	g.drawImage(game_over,getWidth()/2 - 100,getHeight()/2 - 75,200,150,null);
        }
    }


    /*public synchronized void saltar() {
        for(int i = 0; i < 50; i++) {
            posicion.y -= 2;
            if(derechaOIzquierda)
                posicion.x += 2;
            else
                posicion.x -= 2;
            try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

        }
        for(int i = 0; i < 50; i++) {
            posicion.y += 2;
            if(derechaOIzquierda)
                posicion.x += 2;
            else
                posicion.x -= 2;
            try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

        }
    }*/

    public void moverDerecha() {
        posicion.x += 7;
        //derechaOIzquierda = true;
    }

    public void moverIzquierda() {
        posicion.x -= 7;
        //derechaOIzquierda = false;
    }

    public synchronized boolean colision() {
       	for(Enemigo n: enemigos) {
       		if(Math.abs(n.posicion().x - posicion.x) > 40) {
    			continue;
    		}else {
    			if(Math.abs(n.posicion().y - posicion.y)< 40) {
    				colision =  false;
    				return false;
    			}
    		}
    	}
    	return true;
    }

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	public  void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_CONTROL) {
			salto = true;
			cuentaSalto = CONT_SALTO;
		}else if(e.getKeyCode() == KeyEvent.VK_RIGHT){
			moverDerecha();
		}else if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			moverIzquierda();
		}
			
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
	}
	
	public  synchronized void setSaltar(boolean tf) {
		saltar = tf;
	}

	public synchronized boolean getSaltar() {
		return saltar;
	}
	
	public void setGameOver() {
		gameOver = true;
	}
}

