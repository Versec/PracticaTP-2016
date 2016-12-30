package com.gomez_juan_lopez_javier;

/**
 * Clase abstracta Command:
 * 
 * Representa los comandos que puede utilizar el usuario.
 * 
 * @author Juan Gomez 
 * @author Javier Lopez
 * @version 3.0
 */

public abstract class Command {
	
	/**
	 * Hace que el motor {@link Engine} ejecute los comandos.
	 * 
	 * @param engine {@link Engine}
	 * @return true si ejecuta correctamente un comando, false si no lo ejecuta correctamente.
	 */
	abstract public boolean execute(Engine engine);

	/**
	 * Crea un comando {@link Command} a partir del {@link String} line. En caso de que la instruccion 
	 * o su paramatero sean invalidos, devuelve un objeto {@link Command} con valor null.
	 * 
	 * @param line La cadena que contiene el comando.
	 * 
	 * @return El comando {@link Command} y su posible parametro.
	 */
	public abstract Command parse(String... line);
	
	/**
	 * Almacena en un {@link String} el texto de ayuda de cada instruccion.
	 * @return El texto de ayuda en {@link String}.
	 */
	public abstract String textHelp();
}
