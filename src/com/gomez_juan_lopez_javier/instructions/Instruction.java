package com.gomez_juan_lopez_javier.instructions;

import com.gomez_juan_lopez_javier.LexicalParser;
import com.gomez_juan_lopez_javier.exceptions.ArrayException;
import com.gomez_juan_lopez_javier.exceptions.LexicalAnalysisException;

public interface Instruction {
	
	
	Instruction lexParse(String[] words, LexicalParser lexParser) throws LexicalAnalysisException;
	
	void Compile (Compiler compiler)throws ArrayException;
}
