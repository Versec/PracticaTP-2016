package com.gomez_juan_lopez_javier;

import com.gomez_juan_lopez_javier.exceptions.LexicalAnalysisException;
import com.gomez_juan_lopez_javier.instructions.*;
import com.gomez_juan_lopez_javier.instructions.Instruction;

public class InstructionParser {
	
	private static final Instruction [] instructions = {new CompoundAssignment(), new IfThen(), new Return(),
				new SimpleAssignment(), new While(), new Write()};
	
	public static Instruction parse(String instruction, LexicalParser lexParser) throws LexicalAnalysisException{
		Instruction instr = null;
		String words[] = instruction.split(" ", 5);
		for (int i = 0; i < instructions.length; i++) {
			instr = instructions[i].lexParse(words, lexParser);
			if(instr != null)
				break;
		}
		return instr;
	}
}
