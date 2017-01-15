package com.gomez_juan_lopez_javier.instructions;

import com.gomez_juan_lopez_javier.LexicalParser;
import com.gomez_juan_lopez_javier.exceptions.ArrayException;

public interface Instruction {
	
	
	Instruction lexParse(String[] words, LexicalParser lexParser);
	
	void Compile (Compiler compiler)throws ArrayException;
}
