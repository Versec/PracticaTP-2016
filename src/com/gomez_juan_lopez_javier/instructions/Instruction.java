package com.gomez_juan_lopez_javier.instructions;

import com.gomez_juan_lopez_javier.LexicalParser;
import com.gomez_juan_lopez_javier.exceptions.ArrayException;
import com.gomez_juan_lopez_javier.exceptions.LexicalAnalysisException;

public interface Instruction {
	
	/**
	 * 
	 * @param words
	 * @param lexParser
	 * @return
	 * @throws LexicalAnalysisException
	 * @throws ArrayException 
	 */
	Instruction lexParse(String[] words, LexicalParser lexParser) throws LexicalAnalysisException, ArrayException;
	
	/**
	 * Compila una instruccion.
	 * 
	 * @param compiler
	 * @throws ArrayException
	 * @throws LexicalAnalysisException 
	 */
	void compile (com.gomez_juan_lopez_javier.Compiler compiler)throws ArrayException, LexicalAnalysisException;
}
