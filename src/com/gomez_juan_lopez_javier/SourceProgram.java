package com.gomez_juan_lopez_javier;

import com.gomez_juan_lopez_javier.exceptions.ArrayException;

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
	private static final int MAX_PROGRAM_SIZE = 10;
	
	
	/**
	 * Programa fuente con la clase String.
	 */
	private String[] sProgram;
	
	
	/**
	 * Numero de instrucciones que ocupa actualmente el programa.
	 */
	private int programSize;
	
	
	/**
	 * Constructor para crear la clase {@link SourceProgram} en cada posicion del programa.
	 */
	public SourceProgram(){
		this.sProgram = new String [MAX_PROGRAM_SIZE];
		this.programSize = 0;
	}
	
	
	/**
	 * Escribe una instruccion al final del programa fuente y e incrementa el contador de la dimension del programa,
	 * {@link SourceProgram#programSize} en 1.
	 * 
	 * @param instruction Instruccion de tipo String a escribir.
	 * @throws ArrayException 
	 */
	public boolean writeNextInstruction(String instruction) throws ArrayException{
		try {
			sProgram[programSize]= instruction;
			programSize++;
			return true;
		} 
		catch (IndexOutOfBoundsException e){
			throw new ArrayException ();
		}
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
	
	/**
	 * 
	 * @return
	 */
	public int getMaxProgramSize(){
		return SourceProgram.MAX_PROGRAM_SIZE;
	}

	
	/**
	 * 
	 * 
	 * @param programCounter
	 * @return
	 * @throws ArrayException
	 */
	public String getInstructionAt(int programCounter) throws ArrayException {
		try {
			return this.sProgram[programCounter];
		}
		catch (IndexOutOfBoundsException e){
			throw new ArrayException ();
		}
	}
}
