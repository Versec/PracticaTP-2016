package com.gomez_juan_lopez_javier;

import com.gomez_juan_lopez_javier.exceptions.StackException;

/**
 * Clase: OperandStack
 * 
 * Implementacion de la pila de operandos.
 * 
 * @author Juan Gomez
 * @author Javier Lopez
 * @version 3.0
 *
 */

public class OperandStack {
	/**
	 * Maximo tamanio de la pila de operandos.
	 */
	private final int MAX_STACK_SIZE = 10;
	
	/**
	 * Array de enteros que representa la pila.
	 */
	private int stack [] = new int [MAX_STACK_SIZE];
	
	/**
	 * Contador de la posicion actual en la que se encuentra la pila.
	 */
	private int stackCounter=0;
	
	/**
	 * Inserta un nuevo operando en la pila y aumenta {@link OperandStack#stackCounter} en 1.
	 * 
	 * @param i Operando a introducir.
	 * @throws StackException 
	 */
	public void push(int i) throws StackException  {
		try{
			this.stack[stackCounter]=i;
			stackCounter++;
		}
		catch(Exception ArrayIndexOutOfBoundsException){
			throw new StackException ("Tamaño de pila insuficiente. \n");
		}
	}
	
	/**
	 * Extrae un operando en la cima de la pila y reduce {@link OperandStack#stackCounter} en 1.
	 * 
	 * @return Operando a extraer.
	 */
	public int pop() throws StackException{
		if (this.stackCounter == 0){
			throw new StackException ("Tamaño de pila insuficiente. \n");
		}
		stackCounter--;
		return stack[stackCounter];
	}
	
	/** 
	 * Convierte a {@link String} lo que esta almacenado en la pila de operandos.
	 * 
	 * @return Cadena {@link String} que representa la pila de operandos.
	 */
	public String toString (){
		String s = "";
		for (int i = 0; i < stackCounter; i++) {
			s = s + stack [i] + "  ";
		}
		return s;
	}
	/**
	 * Devuelve el valor de {@link OperandStack#stackCounter}
	 * 
	 * @return El valor actual de {@link OperandStack#stackCounter}.
	 */
	public int getStackCounter(){
		return stackCounter;
	}

	public int getMaxSize() {
		return this.MAX_STACK_SIZE;
	}
}
