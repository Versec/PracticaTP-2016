package com.gomez_juan_lopez_javier;

/**
 * Clase SourceProgram:
 * 
 * Representa el programa fuente que se carga del archivo.
 * 
 * @author Juan Gomez
 * @author Javier Lopez
 * @version 3.0
 */

public class SourceProgram {
	/**
	 * Dimension maxima del programa.
	 */
	private final int MAX_PROGRAM_SIZE = 10;
	/**
	 * Programa fuente con la clase String.
	 */
	private String[] sProgram;
	/**
	 * Programa fuente con la clase SourceProgram.
	 */
	private SourceProgram[] program;
	/**
	 * Numero de instrucciones que ocupa actualmente el programa.
	 */
	private int programSize;
	
	/**
	 * Constructor para crear la clase {@link SourceProgram} en cada posicion del programa.
	 */
	public SourceProgram(){
		this.program = new SourceProgram [MAX_PROGRAM_SIZE];
		this.programSize = 0;
	}
	
	/**
	 * Escribe una instruccion al final del programa fuente y e incrementa el contador de la dimension del programa,
	 * {@link SourceProgram#programSize} en 1.
	 * 
	 * @param instruction Instruccion de tipo String a escribir.
	 */
	public boolean writeNextInstruction(String instruction){
		if (programSize < MAX_PROGRAM_SIZE){
			sProgram[programSize]= instruction;
			programSize++;
			return true;
		}
		else
			return false;
	}
	
	/**
	 * Metodo que devuelve la dimension actual del programa fuente{@link programSize}.
	 * 
	 * @return Dimension actual del programa fuente.
	 */
	public int getProgramSize(){
		return programSize;
	}
	/**
	 * Metodo que comprueba si se puede escribir la siguiente instruccion.
	 * @return True si se puede escribir la siguiente instruccion. False en caso contrario.
	 */
	public boolean canWrite(){
		if (programSize < MAX_PROGRAM_SIZE)
			return true;
		else
			return false;
	}
	
	/**
	 * Convierte todas las instrucciones del programa en un objeto {@link String}.
	 * 
	 * @return Representacion en un objeto {@link String} con las instrucciones programadas.
	 */
	public String toString (){
		String s = "";
		for (int i = 0; i < programSize; i++) {
			s = s+ i +": " +this.sProgram[i].toString()+ "\n";
		}
		return s;
	}
}
