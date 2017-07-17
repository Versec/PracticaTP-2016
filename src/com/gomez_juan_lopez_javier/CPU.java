package com.gomez_juan_lopez_javier;

import com.gomez_juan_lopez_javier.bytecode.one_paramater.ByteCodeOneParameter;
import com.gomez_juan_lopez_javier.exceptions.ArrayException;
import com.gomez_juan_lopez_javier.exceptions.DivByZeroException;
import com.gomez_juan_lopez_javier.exceptions.ExecutionErrorException;
import com.gomez_juan_lopez_javier.exceptions.StackException;

/**
 * Clase CPU:
 * 
 * Unidad de procesamiento del programa.
 * 
 * @author Juan Gomez
 * @author Javier Lopez
 * @version 3.0
 */

public class CPU {
	
	/**
	 * Boolean que indica si la CPU esta funcionando.
	 */
	private boolean isRunning;
	/**
	 * Objeto {@link Memory} que representa la memoria de la maquina.
	 */
	private Memory memory;
	/**
	 * Objeto {@link OperandStack} que representa la pila de operandos de la CPU.
	 */
	private OperandStack operandStack; 
	
	/**
	 * Indica la instruccion a ejecutar.
	 */
	private int programCounter;
	
	/**
	 * Objeto {@link ByteCodeProgram} que representa el programa.
	 */
	private ByteCodeProgram bcProgram;
	
	
	/**
	 * Constructor para crear la memoria de la CPU, la pila de operandos y si el procesador
	 * sigue activo.
	 */
	public CPU (){
		this.memory= new Memory();
		this.operandStack = new OperandStack();
		this.bcProgram = new ByteCodeProgram();
		this.isRunning = true;
	}
	
	
	/**
	 * Metodo para obtener una representacion en un objeto {@link String} de la memoria almacenada
	 * @return Cadena {@link String} que representa al estado actual de la memoria de la CPU.
	 */
	public String memoryToString(){
		return "Memoria: " + this.memory.toString();
	}
	
	
	/**
	 * Metodo para obtener una representacion en un objeto {@link String} de la pila de operandos.
	 * 
	 * @return Cadena {@link String} que representa la pila de operandos.
	 */
	public String stackToString(){
		return "Pila: " + this.operandStack.toString();
	}
	
	
	/**
	 * Metodo que devuelve el estado de la CPU.
	 * 
	 * @return {@link CPU#isRunning}, true si esta funcionando, false si la CPU ha acabado su ejecucion.
	 */
	public boolean isRunning() {
		return this.isRunning;
	}
	
	
	/**
	 * Metodo que ejecuta la instruccion PUSH.
	 * @param instr Instruccion {@link ByteCodeOneParameter}.
	 * @return true si no hay error. 
	 * @throws StackException 
	 */
	public boolean push(ByteCodeOneParameter instr) throws StackException {
		//if(this.operandStack.getStackCounter() < this.operandStack.getMaxSize()){
			this.operandStack.push(instr.getParam());
			return true;
	}
	
	
	/**
	 * Metodo que ejecuta el comando Run. 
	 * @return true si se ha ejecutado correctamente. De lo contrario false. 
	 * @throws ExecutionErrorException 
	 * @throws ArrayException 
	 */
	public boolean run() throws ExecutionErrorException, ArrayException{
		this.setProgramCounter(0);
		
		for (programCounter = 0; this.programCounter < this.bcProgram.getProgramSize(); this.programCounter++) {
			if(this.isRunning()){
				//System.out.println("Instrucción a ejecutar: " + 
			      //        this.bcProgram.readInstructionAt(this.programCounter));
				if(this.bcProgram.readInstructionAt(this.programCounter).execute(this)){
					System.out.println(this.memoryToString());
					System.out.println(this.stackToString());
				} 
				else{
					return false;
				}
			}
		}
		return true;
	}
	/**
	 * Metodo que ejecuta la instruccion HALT.
	 */
	public void halt() {
		isRunning = false;
	}
	/**
	 * Metodo que ejecuta la instruccion Add.
	 * @return true si el numero de elementos de la pila es mayor a 2 para que se pueda sumar. De lo contrario false.
	 * @throws StackException 
	 */
	public boolean add() throws StackException{
		
		int i,j;
		
		//if(operandStack.getStackCounter()<2){
			i = this.operandStack.pop();
			j = this.operandStack.pop();
			this.operandStack.push (i + j);
			return true;

		//return false;
		//return false;
	}
	/**
	 * Metodo que ejecuta la instruccion SUB.
	 * @return true si el numero de elementos de la pila es mayor a 2 para que se pueda restar. De lo contario false. 
	 * @throws StackException 
	 */
	public boolean sub() throws StackException{
		int minuendo,sustraendo;
		if(operandStack.getStackCounter()>=2){
			sustraendo = this.operandStack.pop();
			minuendo = this.operandStack.pop();
			this.operandStack.push (minuendo - sustraendo);
			return true;
		}
		return false;
	}
	/**
	 * Metodo que ejecuta la instruccion MUL.
	 * @return true si el numero de elementos de la pila es mayor a 2 para que se pueda multiplicar. De lo contrario false.
	 * @throws StackException 
	 */
	public boolean mul() throws StackException{
		int i,j;
		
		if(operandStack.getStackCounter()>=2){
			i = this.operandStack.pop();
			j = this.operandStack.pop();
			this.operandStack.push (i*j);
			return true;
		}
		return false;
	}
	/**
	 * Metodo que ejecuta la instruccion DIV.
	 * @return true si el numero de elementos de la pila es mayor a 2 y el denominador sea distinto de 0 para que se pueda dividir. De lo contrario false.
	 * @throws StackException 
	 */
	public boolean div()throws DivByZeroException, StackException{
		try {
		int divisor,dividendo;
		
		if(operandStack.getStackCounter()>=2){
			divisor = this.operandStack.pop();
			dividendo = this.operandStack.pop();
			if(divisor == 0){
				throw new DivByZeroException("El divisor no puede ser 0. \n");
			}
				this.operandStack.push (dividendo / divisor);
				return true;
			}
		}finally{
			
		}
		return false;
	}
	/**
	 * Metodo que ejecuta la instruccion LOAD N.
	 * @param instr Instruccion {@link ByteCodeOneParameter}.
	 * @return true si no hay error. False en caso contrario.
	 * @throws StackException 
	 */
	public boolean load(ByteCodeOneParameter instr) throws StackException {
		if(this.memory.isAddressEmpty(instr.getParam())){
			throw new StackException ("stack vacío");
		}
		int k = this.memory.read(instr.getParam());
		this.operandStack.push(k);
		return true;
	}
	/**
	 * Metodo que ejecuta la instruccion out.
	 * @return true si no hay error. False en caso contrario.
	 * @throws StackException 
	 */
	public boolean out() throws StackException{
		if(this.operandStack.getStackCounter() > 0){
			int i = this.operandStack.pop();
			System.out.println("Cima de la pila: "+ String.valueOf(i));
			this.operandStack.push(i);
			return true;
		}
		return false;
	}
	/**
	 * Metodo que ejecuta la instruccion Store.
	 * @param instr Instruccion {@link ByteCodeOneParameter}.
	 * @return true si no hay error. False en caso contrario.
	 * @throws StackException 
	 */
	public boolean store(ByteCodeOneParameter instr) throws StackException {
		if(operandStack.getStackCounter()>0){
			if (this.memory.write(instr.getParam(), operandStack.pop()));
			return true;
		}
		return false;
	}
	/**
	 * Pasa el programa a {@link CPU#bcProgram}.
	 * @param program El programa a ejecutar por la CPU.
	 */
	public void programToCPU(ByteCodeProgram program){
		this.bcProgram = program;
	}
	/**
	 * @return el tamaÃ±o actual de la pila.
	 */
	public int getStackSize(){
		return this.operandStack.getStackCounter();
	}
	/**
	 * Extrae un numero de la cima de la pila.
	 * @return numero de la cima de la pila.
	 * @throws StackException 
	 */
	public int pop() throws StackException {
		return operandStack.pop();
	}
	/**
	 * Incrementa en 1 el contador del programa.
	 */
	public void increaseProgramCounter(){
		this.programCounter++;
	}
	/**
	 * Establece el contador del programa.
	 * @param param contador a establecer.
	 */
	public void setProgramCounter(int param) {
		this.programCounter = param;
	}
	
	/**
	 * 
	 * @return El valor actual del Contador del Programa (PC)
	 */
	public int getCurrentPC(){
		return this.programCounter;
	}

	public void printErrorLine() throws ArrayException {
		System.out.println("Excepción en la ejecución de la LÍNEA: BYTECODE");
		System.out.println(this.programCounter +": " +
				this.bcProgram.readInstructionAt(this.programCounter));
	}
	
}
