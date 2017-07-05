package com.gomez_juan_lopez_javier;

import com.gomez_juan_lopez_javier.bytecode.ByteCode;
import com.gomez_juan_lopez_javier.exceptions.ArrayException;
import com.gomez_juan_lopez_javier.instructions.Instruction;

public class Compiler {
	
	/**
	 * Prgrama bytecode generado por el compilador
	 */
	private ByteCodeProgram bytecode;
	
	/**
	 * Tabla con la posisición de cada variable en memoria.
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
		//Necesita esto estar inicializado aquí?
		this.bytecode = new ByteCodeProgram ();
		this.numVars = 0;
		this.varTable = new String [10];
	}
	
	public void compile (ParsedProgram pProgram) throws ArrayException { //throws exception? cuál?
		
		for (int i = 0; i < pProgram.getNumeroInstrucciones(); i++) {
			Instruction instr = pProgram.getInstruction(i);
			instr.compile(this);
		}
	}
	
	public void addByteCode(ByteCode b){
		this.bytecode.writeNextInstruction(b);
	}
	
	public void addByteCodeAt(ByteCode b, int i){
		this.bytecode.writeInstructionAt(b, i);
	}
	
	/**
	 * No estoy seguro de si necesitamos este método.
	 */
	public void writeToVarTable (String varName){
		this.varTable [this.numVars] = varName;
		this.numVars++;
	}
	
	public int getIndex (String varName) {
		for (int i = 0; i < varTable.length; i++) {
			if (varTable [i].equals(varName)) {
				return i;
			}
		}
		return -1;
	}
	
	public ByteCodeProgram getByteCode (){
		return this.bytecode;
		
	}

}
