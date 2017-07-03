package com.gomez_juan_lopez_javier.instructions.conditions;

import com.gomez_juan_lopez_javier.LexicalParser;
import com.gomez_juan_lopez_javier.TermParser;
import com.gomez_juan_lopez_javier.terms.Term;

public abstract class Condition {
	protected Term term1, term2;
	//protected ConditionalJump cj
	
	public Condition parse(String t1, String op, String t2, LexicalParser parser){
		this.term1 = TermParser.parse(t1);
		this.term2 = TermParser.parse(t2);
		
		return parseOp(term1, op, term2, parser);
	}
	
	protected abstract Condition parseOp(Term t1, String op, Term t2, LexicalParser parser);
}
