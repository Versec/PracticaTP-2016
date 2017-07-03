package com.gomez_juan_lopez_javier.instructions.conditions;

import com.gomez_juan_lopez_javier.LexicalParser;

public class ConditionParser {
	
	
	private final static Condition[] conditions={new Less(), new LessEq(), new Equal(), new NotEqual()};
	
	
	public static Condition parse(String []words, LexicalParser lexParse){
		Condition cond = null;
		for (int i = 0; i < conditions.length; i++) {
			cond = conditions[i].parse(words[1],words[2],words[3],lexParse);
			if (cond!= null)
				break;
		}
		return cond;
	}
}
