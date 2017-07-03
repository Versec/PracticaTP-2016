package com.gomez_juan_lopez_javier.instructions;

import com.gomez_juan_lopez_javier.LexicalParser;
import com.gomez_juan_lopez_javier.ParsedProgram;
import com.gomez_juan_lopez_javier.exceptions.ArrayException;
import com.gomez_juan_lopez_javier.exceptions.LexicalAnalysisException;
import com.gomez_juan_lopez_javier.instructions.conditions.Condition;
import com.gomez_juan_lopez_javier.instructions.conditions.ConditionParser;

/**
 * Clase IfThen:
 * 
 * Representa la condicion if.
 * 
 * @author Juan Gomez
 * @author Javier Lopez
 * @version 3.0
 */

public class IfThen implements Instruction {
	
	private Condition condition;
	private ParsedProgram ifBody;
	
	public IfThen() {
		// TODO Auto-generated constructor stub
	}
	
	public IfThen(Condition cond, ParsedProgram body) {
		this.condition = cond;
		this.ifBody = body;
	}

	@Override
	public Instruction lexParse(String[] words, LexicalParser lexParser) throws LexicalAnalysisException {
		if(words.length != 4)
			return null;
		Condition cond;
		cond = ConditionParser.parse(words, lexParser);
		ParsedProgram wBody = new ParsedProgram();
		lexParser.lexicalParser(wBody, "ENDIF");		
		//lexParser.increaseProgramCounter();
		return new IfThen(cond, wBody);
	}

	@Override
	public void Compile(Compiler compiler) throws ArrayException {
		// TODO Auto-generated method stub
		
	}

}
