package com.gomez_juan_lopez_javier.instructions;

import com.gomez_juan_lopez_javier.LexicalParser;
import com.gomez_juan_lopez_javier.ParsedProgram;
import com.gomez_juan_lopez_javier.bytecode.one_paramater.GoTo;
import com.gomez_juan_lopez_javier.exceptions.ArrayException;
import com.gomez_juan_lopez_javier.exceptions.LexicalAnalysisException;
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
	
	/**
	 * Condicion de la instruccion WHILE.
	 */
	private Condition condition;
	
	/**
	 * Cuerpo interno de bucle WHILE.
	 */
	private ParsedProgram whileBody;
	
	
	public While() {
		// TODO Auto-generated constructor stub
	}

	
	public While(Condition cond, ParsedProgram body) {
		this.condition = cond;
		this.whileBody = body;
	}

	
	@Override
	public Instruction lexParse(String[] words, LexicalParser lexParser) throws LexicalAnalysisException, ArrayException {
		if(words.length != 4) {
			return null;
		}
		if (!words[0].equals("while")){
			return null;
		}
		Condition cond;
		cond = ConditionParser.parse(words, lexParser);
		ParsedProgram wBody = new ParsedProgram();
		lexParser.lexicalParser(wBody, "ENDWHILE");		
		//lexParser.increaseProgramCounter();
		return new While(cond, wBody);
	}


	@Override
	public void compile(com.gomez_juan_lopez_javier.Compiler compiler) throws ArrayException, LexicalAnalysisException {
		
		int goToParam = compiler.getByteCode().getProgramSize();
		IfThen ifthen = new IfThen (this.condition, this.whileBody);
		ifthen.compile(compiler);
		compiler.addNextByteCode(new GoTo(goToParam));
	}

}
