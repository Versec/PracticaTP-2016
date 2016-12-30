package com.gomez_juan_lopez_javier.instructions.one_paramater;

import com.gomez_juan_lopez_javier.ByteCode;

/**
 * Clase que representa las instrucciones con un parametro.
 */

public abstract class ByteCodeOneParameter extends ByteCode{
	/**
	 * Parametro de la instruccion.
	 */
	protected int param;
	
	public ByteCodeOneParameter (){
		
	}
	/** Crea una instruccion {@link ByteCode} con un parametro p.
	 * 
	 * @param p Parametro de la instruccion
	 */
	public ByteCodeOneParameter(int p){
		this.param = p;
	}
	/**
	 * Obtiene el parametro de la instruccion.
	 * @return el parametro de la instruccion.
	 */
	public int getParam(){
		return this.param;
	}
	
	/**
	 * Parsea la instruccion con el parametro correspondiente.
	 * @return la instruccion {@link ByteCode} con su parametro.
	 */
	public ByteCode parse(String... line){
		if (line.length==2){
			return parseAux(line[0], line[1]);
		}
		return null;
	}
	/**
	 * Parsea la instruccion con el parametro correspondiente.
	 * @param instruc Cadena que representa la instruccion
	 * @param param Parametro de la instruccion.
	 * @return la instruccion {@link ByteCode} con su parametro.
	 */
	protected abstract ByteCode parseAux(String instruc, String param);

}
