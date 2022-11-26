package inicializacion;

import java.awt.EventQueue;

import ui.PruebaListas;

public class Main {
	public static void main(String[] args){
		Inicializadora.instanciarPrincipal();
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PruebaListas frame = new PruebaListas();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
