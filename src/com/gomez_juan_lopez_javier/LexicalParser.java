package com.gomez_juan_lopez_javier;

import com.gomez_juan_lopez_javier.exceptions.ArrayException;
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
	
	public void lexicalParser(ParsedProgram pProgram, String stopKey) throws LexicalAnalysisException, ArrayException {
		boolean stop = false;
		if(!this.sProgram.getInstructionAt(sProgram.getProgramSize()-1).equals("end")){
			throw new LexicalAnalysisException ("Falta terminación end. \n");
		}
		while(programCounter < sProgram.getProgramSize() && !stop){
			String line = sProgram.getInstructionAt(programCounter);
			if(line.equalsIgnoreCase(stopKey)){
				increaseProgramCounter();
				stop = true;
			}
			else {
				//System.out.println("PC: " + this.programCounter);
				increaseProgramCounter();
				Instruction instr = InstructionParser.parse(line, this);
				pProgram.addInstruction(instr);
			
			}
		}
	}
	
	public void increaseProgramCounter(){
		this.programCounter++;
	}

}
