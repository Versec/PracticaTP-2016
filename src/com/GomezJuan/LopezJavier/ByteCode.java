package com.GomezJuan.LopezJavier;

/**
 * Clase Bytecode:
 * 
 * Representa las instrucciones bytecode que maneja el programa.
 * 
 * @author Juan Gomez
 * @author Javier Lopez
 * @version 1.0
 */

public class ByteCode {
	/**
	 * Nombre de la instruccion.
	 */
	private ENUM_BYTECODE name;
	/**
	 * Parametro para la instrucciones PUSH, STORE y LOAD.
	 */
	private int param;

	/**
	 * Constructor para las instrucciones PUSH, STORE y LOAD.
	 * 
	 * @param type tipo del instruccion.
	 * @param param parámetro de la instruccion.
	 */
	public ByteCode(ENUM_BYTECODE type, int param){
		this.name = type;
		this.param = param;
	}
	/**
	 * Constructor para el resto de instrucciones.
	 * 
	 * @param type Tipo de la instruccion.
	 */
	public ByteCode (ENUM_BYTECODE type){
		this.name = type;
		this.param = -1;
	}
	
	/**
	 * Constructor por defecto de ByteCode.
	 */
	public ByteCode(){
		
	}
	
	/**
	 * Conversor del tipo int y ENUM_BYTECODE a String.
	 * 
	 * @return La representacion en forma de String de de la instruccion ByteCode y su parametro.
	 */
	
	public String toString (){
		if (this.name != ENUM_BYTECODE.PUSH && this.name != ENUM_BYTECODE.LOAD && this.name != ENUM_BYTECODE.STORE){
			return this.name +" ";
		}
		else{
			return this.name + " " + this.param;
		}
	}
	
	/**
	 * public ENUM_BYTECODE getByteCode ()
	 * 
	 * @return El nombre de la instruccion {@link ByteCode}.
	 */
	public ENUM_BYTECODE getByteCode (){
		return this.name;
	}
	
	/**
	 * public int getParam()
	 * 
	 * @return El parametro de la instruccion {@link ByteCode}.
	 */
	public int getParam(){
		return this.param;
	}
}
