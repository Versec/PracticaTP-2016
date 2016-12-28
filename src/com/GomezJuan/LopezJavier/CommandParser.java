package com.GomezJuan.LopezJavier;

/**
 * Clase CommandParser:
 * 
 * Se encarga de parsear un objeto {@link String} y convertirlo en un objeto comando {@link Command}.
 * 
 * @author Juan Gomez 
 * @author Javier Lopez
 * @version 1.0
 */

public class CommandParser {
	/**
	 * A partir de un String, genera un objeto {@link Command}. Si el comando no existe no tiene parametros validos
	 * devuelve NULL
	 * 
	 * @param line La cadena que contiene el comando.
	 * @return comando Un objeto {@link Command} ya parseado.
	 */
	public static Command parse (String line){
		Command comando =  null;
		line = line.toLowerCase();
		String myArray[] = line.split(" ", 2);
		
		if (line.matches("help")){
			comando = new Command(ENUM_COMMAND.HELP);
			return comando;
		}
		if (line.matches("quit")){
			comando = new Command(ENUM_COMMAND.QUIT);
			return comando;
		}
		if(line.matches("newinst" + "\\s{1}" + ".+")){ 
			/*"newinst" + "espacio en blanco" + "al menos, otro caracter mas que sea la instruccion."
			 * Sera el ByteCodeParser quien se encargue de comprobar si la instruccion es valida
			 */
			comando = new Command(ENUM_COMMAND.NEWINST, ByteCodeParser.parse(myArray[1]));
			return comando;
		}
		if(line.matches("run")){
			comando = new Command(ENUM_COMMAND.RUN);
			return comando;
		}
		if (line.matches("reset")){
			comando = new Command(ENUM_COMMAND.RESET);
			return comando;
		}
		if(line.matches("replace " + "(\\+)?[0-9]+")){
			//Este regex tampoco acepta numeros negativos
			comando = new Command(ENUM_COMMAND.REPLACE, Integer.parseInt(myArray[1]));
			return comando;
		}
		return comando;
	}
}
