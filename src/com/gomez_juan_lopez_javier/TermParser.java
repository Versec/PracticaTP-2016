package com.gomez_juan_lopez_javier;

import com.gomez_juan_lopez_javier.terms.*;
import com.gomez_juan_lopez_javier.terms.Number;

public class TermParser {
	
	private final static Term [] terms = {new Variable(""), new Number(0)};
	
	public static Term parse(String st){
		Term tm;
		for (int i = 0; i < terms.length; i++) {
			tm = terms[i].parse(st);
			if (tm!= null)
				return tm;
		}
		return null;
	}
}
