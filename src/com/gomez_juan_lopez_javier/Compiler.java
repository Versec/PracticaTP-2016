package com.gomez_juan_lopez_javier;

import com.gomez_juan_lopez_javier.bytecode.ByteCode;
import com.gomez_juan_lopez_javier.exceptions.ArrayException;
import com.gomez_juan_lopez_javier.exceptions.LexicalAnalysisException;
import com.gomez_juan_lopez_javier.instructions.Instruction;

public class Compiler {
	
	/**
	 * Prgrama bytecode generado por el compilador
	 */
	private ByteCodeProgram bytecodeProgram;
	
	/**
	 * Tabla con la posisición de cada variable en memoria. El tamaño por defecto es 10.
	 */
	private String varTable [];
	
	/**
	 * número de variables almacenadas en {@link varTable}
	 */
	private int numVars;
	
	/**
	 * Compilador del programa. Inicia el programa ByteCode y la tabla de variables.
	 */
	public Compiler() {
		this.bytecodeProgram = new ByteCodeProgram ();
		this.numVars = 0;
		this.varTable = new String [10];
		for (int i = 0; i < varTable.length; i++) {
			varTable [i] = "";
		}
	}
	/**
	 * 
	 * @param pProgram
	 * @throws ArrayException
	 * @throws LexicalAnalysisException 
	 */
	public void compile (ParsedProgram pProgram) throws ArrayException, LexicalAnalysisException {
		for (int i = 0; i < pProgram.getNumeroInstrucciones(); i++) {
			Instruction instr = pProgram.getInstruction(i);
			instr.compile(this);
		}
	}
	
	
	/**
	 * Añade una instruccion Bytecode en la siguiente linea de memoria libre.
	 * 
	 * @param b
	 * @throws ArrayException
	 */
	public void addNextByteCode(ByteCode b) throws ArrayException{
		this.bytecodeProgram.writeNextInstruction(b);
	}
	
	/**
	 * Añade una instrucción Bytecode en una posicion i determinada
	 * 
	 * @param b Instruccion Bytecode a añadir.
	 * @param i Posicion de memoria.
	 * @throws ArrayException
	 */
	public void addByteCodeAt(ByteCode b, int i) throws ArrayException{
		this.bytecodeProgram.writeInstructionAt(b, i);
	}
	
	/**
	 * 
	 */
	public void writeToVarTable (String varName){
		int i = this.getVarIndex(varName);
		if (i == -1){
			this.varTable [this.numVars] = varName;
			this.numVars++;
		}		
	}
	
	/**
	 * Busca el índice de una variable en la tabla. No comprueba si la variable existe.
	 * 
	 * @param varName
	 * @return
	 */
	public int getVarIndex (String varName) {
		for (int i = 0; i < varTable.length; i++) {
			if (varTable [i].equals(varName)) {
				return i;
			}
		}
		return -1;
	}
	
	/**
	 * 
	 * @return
	 */
	public ByteCodeProgram getByteCode (){
		return this.bytecodeProgram;
		
	}

}
