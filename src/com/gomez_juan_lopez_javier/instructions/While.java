package com.gomez_juan_lopez_javier.instructions;

import com.gomez_juan_lopez_javier.LexicalParser;
import com.gomez_juan_lopez_javier.ParsedProgram;
import com.gomez_juan_lopez_javier.exceptions.ArrayException;
import com.gomez_juan_lopez_javier.instructions.conditions.Condition;
import com.gomez_juan_lopez_javier.instructions.conditions.ConditionParser;

/**
 * Clase While:
 * 
 * Representa un bucle.
 * 
 * @author Juan Gomez
 * @author Javier Lopez
 * @version 3.0
 */

public class While implements Instruction {
	
	private Condition condition;
	private ParsedProgram body;
	
	public While() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Instruction lexParse(String[] words, LexicalParser lexParser) {
		Condition cond;
		if(words.length != 4)
			return null;
		//cond = ConditionParser.parse(words);
		return null;
	}

	@Override
	public void Compile(Compiler compiler) throws ArrayException {
		// TODO Auto-generated method stub
		
	}

}
