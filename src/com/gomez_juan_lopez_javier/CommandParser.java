package com.gomez_juan_lopez_javier;

import com.gomez_juan_lopez_javier.commands.*;

/**
 * Clase CommandParser:
 * 
 * Se encarga de parsear un objeto {@link String} y convertirlo en un objeto comando {@link Command}.
 * 
 * @author Juan Gomez 
 * @author Javier Lopez
 * @version 3.0
 */

public class CommandParser {
	/**
	 * Array constante de todos los comandos de tipo {@link Command}.
	 */
	private final static Command[] commands = {new Help (), new Reset(), new Compile(),
			new Quit(), new Replace(), new Run(), new LoadFich()};
	
	/**
	 * A partir de un {@link String}, genera un objeto {@link Command}. Si el comando no existe, o no tiene parametros validos
	 * devuelve NULL.
	 * 
	 * @param line La cadena que contiene el comando.
	 * @return Un objeto {@link Command} ya parseado.
	 */
	public static Command parse (String line){
		Command comando = null;
		
		//Separa la cadena por espacios.
		String myArray[] = line.split(" ", 2);
		
		//Recorre el array hasta que se encuentre un comando valido o se sobrepase el numero de elementos.
		for (int i = 0; i < commands.length; i++) {
			comando = commands[i].parse(myArray);
			if (comando != null) {
				break;
			}
		}
		return comando;
	}
	
	/**
	 * Recorre el array {@link CommandParser#commands} y muestra la ayuda de cada comando. 
	 */
	public static void showHelp(){
		for (int i = 0; i < commands.length; i++) {
			System.out.print(commands[i].textHelp());
		}
	}
}
