package juego3;


import javax.swing.JFrame;

public class Ventana extends JFrame implements Runnable{

	Etapa panel;
	
	public Ventana() {
		setBounds(0,0,1500,500);
		panel = new Etapa();
		add(panel);
		addKeyListener(panel);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
		Thread hilo = new Thread(this);
		hilo.start();
				
	}
	
	
	public void run() {
		while(panel.colision()) {
			try {
				Thread.sleep(40);
				panel.repaint();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		panel.setGameOver();
	  	panel.repaint();
	}
	
}
