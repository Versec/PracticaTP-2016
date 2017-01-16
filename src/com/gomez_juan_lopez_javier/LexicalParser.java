package com.gomez_juan_lopez_javier;

import com.gomez_juan_lopez_javier.exceptions.LexicalAnalysisException;
import com.gomez_juan_lopez_javier.instructions.Instruction;

/**
 * Clase LexicalParser:
 * 
 * Realiza el analisis lexico.
 * 
 * @author Juan Gomez
 * @author Javier Lopez
 * @version 3.0
 */

public class LexicalParser {
	
	private SourceProgram sProgram;
	
	private int programCounter;
	
	public LexicalParser(SourceProgram sprogram){
		this.sProgram = sprogram;
	}
	
	public void lexicalParser(ParsedProgram pProgram, String stopKey) throws LexicalAnalysisException {
		boolean stop;
		while(programCounter < sProgram.getProgramSize()){
			String line = sProgram.getInstructionAt(programCounter);
			if(line.equalsIgnoreCase(stopKey))
				stop = true;
			else {
				Instruction instr = InstructionParser.parse(line, this);
				pProgram.addInstruction(instr);
				programCounter++;
			}
		}
	}
	
	public void increaseProgramCounter(){
		this.programCounter++;
	}

}
