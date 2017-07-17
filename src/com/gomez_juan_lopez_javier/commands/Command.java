package com.gomez_juan_lopez_javier.commands;

import com.gomez_juan_lopez_javier.Engine;
import com.gomez_juan_lopez_javier.exceptions.ArrayException;
import com.gomez_juan_lopez_javier.exceptions.ExecutionErrorException;
import com.gomez_juan_lopez_javier.exceptions.LexicalAnalysisException;

/**
 * Clase abstracta Command:
 * 
 * Representa los comandos que puede utilizar el usuario.
 * 
 * @author Juan Gomez 
 * @author Javier Lopez
 * @version 3.0
 */

public interface Command {
	
	/**
	 * Hace que el motor {@link Engine} ejecute los comandos.
	 * 
	 * @param engine {@link Engine}
	 * @return true si ejecuta correctamente un comando, false si no lo ejecuta correctamente.
	 * @throws ArrayException 
	 * @throws LexicalAnalysisException 
	 * @throws ExecutionErrorException 
	 */
	boolean execute(Engine engine) throws LexicalAnalysisException, ArrayException, ExecutionErrorException;

	/**
	 * Crea un comando {@link Command} a partir del {@link String} line. En caso de que la instruccion 
	 * o su paramatero sean invalidos, devuelve un objeto {@link Command} con valor null.
	 * 
	 * @param line La cadena que contiene el comando.
	 * 
	 * @return El comando {@link Command} y su posible parametro.
	 */
	Command parse(String... line);
	
	/**
	 * Almacena en un {@link String} el texto de ayuda de cada instruccion.
	 * @return El texto de ayuda en {@link String}.
	 */
	String textHelp();
}
