package com.gomez_juan_lopez_javier;

import com.gomez_juan_lopez_javier.instructions.Instruction;

/**
 * Clase ParsedProgram:
 * 
 * Representa el programa parseado.
 * 
 * @author Juan Gomez
 * @author Javier Lopez
 * @version 3.0
 */

public class ParsedProgram {
	
	private static final int MAX_PROGRAM_SIZE = 10;
	
	
	private Instruction[] pProgram;
	
	private int programSize;
	
	public ParsedProgram() {
		this.pProgram = new Instruction [MAX_PROGRAM_SIZE];
		this.programSize = 0;
	}

	public void addInstruction(Instruction instr) {
		this.pProgram[programSize] = instr;
		programSize++;
	}

}
