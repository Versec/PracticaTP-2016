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
	
	/**
	 * Condicion de la instruccion IF.
	 */
	private Condition condition;
	
	/**
	 * Cuerpo interno.
	 */
	private ParsedProgram ifBody;
	
	
	public IfThen() {
		// TODO Auto-generated constructor stub
	}
	
	
	public IfThen(Condition cond, ParsedProgram body) {
		this.condition = cond;
		this.ifBody = body;
	}

	
	@Override
	public Instruction lexParse(String[] words, LexicalParser lexParser) throws LexicalAnalysisException, ArrayException {
		if(words.length != 4)
			return null;
		if (!words[0].equals("if")){
			return null;
		}
		
		Condition cond = ConditionParser.parse(words, lexParser);
		ParsedProgram wBody = new ParsedProgram();
		lexParser.lexicalParser(wBody, "ENDIF");		
		return new IfThen(cond, wBody);
	}

	
	/**
	 * @throws LexicalAnalysisException 
	 * 
	 */
	@Override
	public void compile(com.gomez_juan_lopez_javier.Compiler compiler) throws ArrayException, LexicalAnalysisException {
		try {
		//Compilación de los terminos a comparar.
		compiler.addNextByteCode(this.condition.getTerm1().compile(compiler));
		compiler.addNextByteCode(this.condition.getTerm2().compile(compiler));
		
		} catch(NullPointerException e){
			throw new LexicalAnalysisException ("Error en la compilación de una condición IF. \n");
		}
			 
		if (this.condition instanceof Equal ){			
			compiler.addNextByteCode(new IfEq());
			int instrACambiar = compiler.getByteCode().getProgramSize() -1;
			compiler.compile(this.ifBody);	
			
			int aDondeSaltar = this.ifBody.getNumeroInstrucciones() + 
					compiler.getByteCode().getProgramSize() -1;
			
			compiler.addByteCodeAt(new IfEq(aDondeSaltar), instrACambiar);		
		}
		
		if (this.condition instanceof Less ){			
			compiler.addNextByteCode(new IfLe());
			int instrACambiar = compiler.getByteCode().getProgramSize() -1;
			compiler.compile(this.ifBody);	
			int aDondeSaltar = this.ifBody.getNumeroInstrucciones() + 
					compiler.getByteCode().getProgramSize() -1;
			
			compiler.addByteCodeAt(new IfLe(aDondeSaltar), instrACambiar);
		}
		
		if (this.condition instanceof LessEq ){			
			compiler.addNextByteCode(new IfLeq());
			int instrACambiar = compiler.getByteCode().getProgramSize() -1;
			compiler.compile(this.ifBody);	
			int aDondeSaltar = this.ifBody.getNumeroInstrucciones() + 
					compiler.getByteCode().getProgramSize() -1;
			compiler.addByteCodeAt(new IfLeq(aDondeSaltar), instrACambiar);
		}
		
		if (this.condition instanceof NotEqual ){			
			compiler.addNextByteCode(new IfNeq());
			int instrACambiar = compiler.getByteCode().getProgramSize() -1;
			compiler.compile(this.ifBody);	
			int aDondeSaltar = this.ifBody.getNumeroInstrucciones() + 
					compiler.getByteCode().getProgramSize() -1;
			compiler.addByteCodeAt(new IfNeq(aDondeSaltar), instrACambiar);
		}
	
	}

}
