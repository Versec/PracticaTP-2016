package com.GomezJuan.LopezJavier;

/**
 * Crea un objeto {@link Engine} y lo inicia.
 * 
 * @author Javier Lopez
 * @author Juan Gomez
 * @version 1.0
 *
 */

public class Main {
	
	/**
	 * Arranca el motor del programa llamando a {@link Engine#start()}.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Engine engine = new Engine();
		engine.start();
	}

}
