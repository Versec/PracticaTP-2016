package com.GomezJuan.LopezJavier;

/**
 * Clase Command:
 * 
 * Representa los comandos que puede utilizar el usuario.
 * 
 * @author Juan Gomez 
 * @author Javier Lopez
 * @version 1.0
 */

public class Command {
	/**
	 * Representacion {@link ENUM_COMMAND} del comando.
	 */
	private ENUM_COMMAND command;
	
	/**
	 * Instruccion {@link ByteCode} que puede acompañar al comando.
	 */
	private ByteCode instruction;
	
	/**
	 * Entero que representa la instruccion a substituir si se realiza el comando REPLACE.
	 */
	private int replace;
	
	/**
	 * Constructor para el comando NEWINST.
	 * 
	 * @param enum_command enumerado {@link ENUM_COMMAND} del commando.
	 * @param instruccion Objeto Instruccion {@link ByteCode} que acompaña del enumerado.
	 */
	public Command (ENUM_COMMAND enum_command, ByteCode instruccion){
		this.command = enum_command;
		this.instruction = instruccion;
	}
	
	/**
	 * Constructor para el comando REPLACE.
	 * 
	 * @param enum_command enumerado {@link ENUM_COMMAND} del commando.
	 * @param param parametro que acompaña del comando.
	 */
	public Command(ENUM_COMMAND enum_command, int param) {
		this.command = enum_command;
		this.replace = param;
	}
	
	/**
	 * Constructor para el resto de comandos.
	 * 
	 * @param enum_command enumerado {@link ENUM_COMMAND} del commando.
	 */
	public Command (ENUM_COMMAND enum_command){
		this.command = enum_command;
	}
	
	/**
	 * Hace que el motor {@link Engine} ejecute los comandos.
	 * 
	 * @param engine {@link Engine}
	 * @return true si ejecuta correctamente un comando, false si no lo ejecuta correctamente.
	 */
	public boolean execute(Engine engine){
		if (this.command == ENUM_COMMAND.HELP) {
			engine.ejecutarHelp();
			return true;
		}
		
		if (this.command == ENUM_COMMAND.NEWINST) {
			engine.ejecutarNewInst(instruction);
			return true;
		}
		
		if (this.command == ENUM_COMMAND.RUN) {
			engine.ejecutarRun();
			return true;
		}
		
		if (this.command == ENUM_COMMAND.RESET) {
			engine.ejecutarReset();
			return true;
		}
		
		if (this.command == ENUM_COMMAND.REPLACE) {
			engine.ejecutarReplace(replace);
			return true;
		}
		
		if (this.command == ENUM_COMMAND.QUIT) {
			engine.ejecutarQuit();
			return true;
		}
		
		return false;
	}
}
