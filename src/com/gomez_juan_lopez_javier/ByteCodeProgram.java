package com.gomez_juan_lopez_javier;

/**
 * Clase ByteCodeProgram:
 * 
 * Representa el programa escrito por el usuario.
 * 
 * @author Juan Gomez 
 * @author Javier Lopez
 * @version 2.0
 */

public class ByteCodeProgram {
	/**
	 * Dimension maxima del programa.
	 */
	private final int MAX_PROGRAM_SIZE = 10;
	/**
	 * Programa con la clase ByteCode.
	 */
	private ByteCode[] program;
	/**
	 * Numero de instrucciones que ocupa actualmente el programa.
	 */
	private int programSize;
	
	/**
	 * Escribe una instruccion al final del programa y e incrementa el contador de la dimension del programa,
	 * {@link ByteCodeProgram#programSize} en 1.
	 * 
	 * @param instruction Instruccion a escribir.
	 */
	public void writeNextInstruction(ByteCode instruction){
		program[programSize]= instruction;
		programSize++;
	}
	
	/**
	 * Escribe una instruccion {@link ByteCode} en una posicion dada. Si la instruccion es null, o la posicion es invalida 
	 * - menor que 0, o mayor que {@link ByteCodeProgram#programSize} - devuelve false.
	 * 
	 * @param instruction Instruccion a escribir {@link ByteCode}.
	 * 
	 * @param i Posicion en la que se escribira la instruccion.
	 * 
	 * @return Devuelve true si la instruccion se ha escrito correctamente, false en cualquier otro caso.
	 */
	public boolean writeInstructionAt(ByteCode instruction,int i){
		if(instruction == null){
			return false;
		}
		if(i<0){
			return false;
		}
		if (i > programSize){
			return false;
		}
		else{
			this.program [i] = instruction;
			return true;
		}
	}

	/**
	 * Constructor para crear la clase {@link ByteCode} en cada posicion del programa.
	 */
	public ByteCodeProgram (){
		this.program = new ByteCode [MAX_PROGRAM_SIZE];
		this.programSize = 0;
	}
	
	/**
	 * Metodo que devuelve la dimension actual del programa {@link programSize}.
	 * 
	 * @return Dimension actual del programa.
	 */
	public int getProgramSize(){
		return programSize;
	}
	
	/**
	 * Lee la instruccion en una posicion dada.
	 * 
	 * @param i posicion a leer.
	 * @return Instruccion {@link ByteCode} en la posicion dada.
	 */
	public ByteCode readInstructionAt(int i){
		return program [i];
	}
	
	/**
	 * Convierte todas las instrucciones del programa en un objeto {@link String}.
	 * 
	 * @return Representacion en un objeto {@link String} con las instrucciones programadas.
	 */
	public String toString (){
		String s = "";
		for (int i = 0; i < programSize; i++) {
			s = s+ i +": " +this.program[i].toString()+ "\n";
		}
		return s;
	}
	
	/**
	 * Constructor para crear un nuevo programa. El tanaño maximo del program esta definido por
	 * {@link ByteCodeProgram#MAX_PROGRAM_SIZE}.
	 */
	public void eraseAll() {
		this.program = new ByteCode[MAX_PROGRAM_SIZE];
		this.programSize = 0;
	}

}

