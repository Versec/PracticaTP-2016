package com.gomez_juan_lopez_javier;

/**
 * Crea un objeto {@link Engine} y lo inicia.
 * 
 * @author Javier Lopez
 * @author Juan Gomez
 * @version 3.0
 */

public class Main {
	
	/**
	 * Arranca el motor del programa llamando a {@link Engine#start()}.
	 * 
	 * @param args No utilizado.
	 */
	public static void main(String[] args) {		
		Engine engine = new Engine();
		engine.start();
	}

}
