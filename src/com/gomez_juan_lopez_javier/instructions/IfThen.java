package com.gomez_juan_lopez_javier.instructions;

import com.gomez_juan_lopez_javier.LexicalParser;
import com.gomez_juan_lopez_javier.ParsedProgram;
import com.gomez_juan_lopez_javier.bytecode.one_paramater.conditional_jumps.*;
import com.gomez_juan_lopez_javier.exceptions.ArrayException;
import com.gomez_juan_lopez_javier.exceptions.LexicalAnalysisException;
import com.gomez_juan_lopez_javier.instructions.conditions.*;

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
	public void compile(com.gomez_juan_lopez_javier.Compiler compiler) throws ArrayException {
		
		compiler.addByteCode(this.condition.getTerm1().compile(compiler));
		compiler.addByteCode(this.condition.getTerm2().compile(compiler));
		if (this.condition instanceof Equal ){			
			compiler.addByteCode(new IfEq());
			int instrACambiar = compiler.getByteCode().getProgramSize() -1;
			compiler.compile(this.ifBody);	
			
			int aDondeSaltar = this.ifBody.getNumeroInstrucciones() + 
					compiler.getByteCode().getProgramSize() -1;
			
			compiler.addByteCodeAt(new IfEq(aDondeSaltar), instrACambiar);		
		}
		
		if (this.condition instanceof Less ){			
			compiler.addByteCode(new IfLe());
			int instrACambiar = compiler.getByteCode().getProgramSize() -1;
			compiler.compile(this.ifBody);	
			int aDondeSaltar = this.ifBody.getNumeroInstrucciones() + 
					compiler.getByteCode().getProgramSize() -1;
			
			compiler.addByteCodeAt(new IfLe(aDondeSaltar), instrACambiar);
		}
		
		if (this.condition instanceof LessEq ){			
			compiler.addByteCode(new IfLeq());
			int instrACambiar = compiler.getByteCode().getProgramSize() -1;
			compiler.compile(this.ifBody);	
			int aDondeSaltar = this.ifBody.getNumeroInstrucciones() + 
					compiler.getByteCode().getProgramSize() -1;
			compiler.addByteCodeAt(new IfLeq(aDondeSaltar), instrACambiar);
		}
		if (this.condition instanceof NotEqual ){			
			compiler.addByteCode(new IfNeq());
			int instrACambiar = compiler.getByteCode().getProgramSize() -1;
			compiler.compile(this.ifBody);	
			int aDondeSaltar = this.ifBody.getNumeroInstrucciones() + 
					compiler.getByteCode().getProgramSize() -1;
			compiler.addByteCodeAt(new IfNeq(aDondeSaltar), instrACambiar);
		}
	}

}
