package com.gomez_juan_lopez_javier;

import com.gomez_juan_lopez_javier.bytecode.one_paramater.ByteCodeOneParameter;

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
	 * Metodo que ejecuta la instruccion Push.
	 * @param instr Instruccion {@link ByteCodeOneParameter}.
	 * @return true si no hay error. 
	 */
	public boolean push(ByteCodeOneParameter instr){
		if(this.operandStack.getStackCounter() < this.operandStack.getMaxSize()){
			this.operandStack.push(instr.getParam());
			return true;
		}
		return false;
	}
	/**
	 * Metodo que ejecuta el comando Run. 
	 * @return true si se ha ejecutado correctamente. De lo contrario false. 
	 */
	public boolean run(){
		this.setProgramCounter(0);
		for (this.programCounter = 0; this.programCounter < this.bcProgram.getProgramSize(); this.programCounter++) {
			if(this.isRunning()){
				if(this.bcProgram.readInstructionAt(this.programCounter).execute(this)){
				} 
				else{
					return false;
				}
			}
		}
		return true;
	}
	/**
	 * Metodo que ejecuta la instruccion Halt.
	 */
	public void halt() {
		System.out.println("halt");
		isRunning = false;
	}
	/**
	 * Metodo que ejecuta la instruccion Add.
	 * @return true si el numero de elementos de la pila es mayor a 2 para que se pueda sumar. De lo contrario false.
	 */
	public boolean add(){
		int i,j;
		
		if(operandStack.getStackCounter()>=2){
			i = this.operandStack.pop();
			j = this.operandStack.pop();
			this.operandStack.push (i + j);
			return true;
		}
		return false;
	}
	/**
	 * Metodo que ejecuta la instruccion Sub.
	 * @return true si el numero de elementos de la pila es mayor a 2 para que se pueda restar. De lo contario false. 
	 */
	public boolean sub(){
		int i,j;
		
		if(operandStack.getStackCounter()>=2){
			i = this.operandStack.pop();
			j = this.operandStack.pop();
			this.operandStack.push (i - j);
			return true;
		}
		return false;
	}
	/**
	 * Metodo que ejecuta la instruccion Mul.
	 * @return true si el numero de elementos de la pila es mayor a 2 para que se pueda multiplicar. De lo contrario false.
	 */
	public boolean mul(){
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
	 * Metodo que ejecuta la instruccion Div.
	 * @return true si el numero de elementos de la pila es mayor a 2 y el denominador sea distinto de 0 para que se pueda dividir. De lo contrario false.
	 */
	public boolean div(){
		int i,j;
		
		if(operandStack.getStackCounter()>=2){
			i = this.operandStack.pop();
			j = this.operandStack.pop();
			if(j != 0){
				this.operandStack.push (i / j);
				return true;
			}
		}
		return false;
	}
	/**
	 * Metodo que ejecuta la instruccion Load.
	 * @param instr Instruccion {@link ByteCodeOneParameter}.
	 * @return true si no hay error. False en caso contrario.
	 */
	public boolean load(ByteCodeOneParameter instr) {
		if(!this.memory.isAddressEmpty(instr.getParam())){
			int k = this.memory.read(instr.getParam());
			this.operandStack.push(k);
			return true;
		}
		return false;
	}
	/**
	 * Metodo que ejecuta la instruccion out.
	 * @return true si no hay error. False en caso contrario.
	 */
	public boolean out(){
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
	 */
	public boolean store(ByteCodeOneParameter instr) {
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
	 * @return el tamaño actual de la pila.
	 */
	public int getStackSize(){
		return this.operandStack.getStackCounter();
	}
	/**
	 * Extrae un numero de la cima de la pila.
	 * @return numero de la cima de la pila.
	 */
	public int pop() {
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
	
}
