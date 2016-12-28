package com.GomezJuan.LopezJavier;

/**
 * Clase CPU:
 * 
 * Unidad de procesamiento del programa.
 * 
 * @author Juan Gomez
 * @author Javier Lopez
 * @version 1.0
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
	 * Ejecuta una instruccion {@link ByteCode}. Devolvera true si la instruccion se ejecuta correctamente.
	 * En cualquier otro caso, devolvera false.
	 * 
	 * <P>
	 * En las instrucciones que necesitan dos operaciones (ADD, SUB, MUL, DIV), el orden en el que se
	 * realiza la operacion es #cimadepila (OPERACION) #subcimadepila. Por ejemplo, un programa asi: </P>
	 * 
	 * <P> PUSH 5 </P>
	 * <P> PUSH 2 </P>
	 * <P> SUB </P>
	 * 
	 * Hara la resta de 2 - 5 y guardara el resultado -3 en la pila de operandos {@link OperandStack}.
	 * Para las divisiones entre 0, la cpu lo considerara como un caso invalido e informará al usuario
	 * 
	 * @param instr La instruccion {@link ByteCode} a ejecutar.
	 * @return true si la instruccion se ha ejecutado correctamente. Si no es el caso, false.
	 */
	public boolean execute (ByteCode instr){
		int i,j;
		switch(instr.getByteCode()){
		case ADD:
			if(operandStack.getStackCounter()>=2){
				i = this.operandStack.pop();
				j = this.operandStack.pop();
				this.operandStack.push (i + j);
				return true;
			}
			break;
			
		case SUB:
			if(operandStack.getStackCounter()>=2){
				i = this.operandStack.pop();
				j = this.operandStack.pop();
				this.operandStack.push (i - j);
				return true;
			}
			break;
			
		case MUL:
			if(operandStack.getStackCounter()>=2){
				i = this.operandStack.pop();
				j = this.operandStack.pop();
				this.operandStack.push (i*j);
				return true;
			}
			break;
			
		case DIV:
			if(operandStack.getStackCounter()>=2){
				i = this.operandStack.pop();
				j = this.operandStack.pop();
				if(j != 0){
					this.operandStack.push (i / j);
					return true;
				}
			}
			break;
			
		case HALT:
			isRunning = false;
			return true;
			
		case LOAD:
			if(!this.memory.isAddressEmpty(instr.getParam())){
				int k = this.memory.read(instr.getParam());
				this.operandStack.push(k);
				return true;
			}
			else {
				return false;
			}
		
		case OUT:
			return true;
			
		case PUSH:
			this.operandStack.push(instr.getParam());
			return true;
			
		case STORE:
			if(operandStack.getStackCounter()>0){
				if (this.memory.write(instr.getParam(), operandStack.pop()));
				return true;
			}
			break;
		
		default:
			break;
		}
		return false;
	}
	
	/**
	 * Constructor para crear la memoria de la CPU, la pila de operandos y si el procesador
	 * sigue activo.
	 */
	public CPU (){
		this.memory= new Memory();
		this.operandStack = new OperandStack();
		this.isRunning = true;
	}
	
	/**
	 * Metodo para obtener una representacion en un objeto {@link String} de la memoria almacenada
	 * @return Cadena {@link String} que representa al estado actual de la memoria de la CPU.
	 */
	public String getMemoryState(){
		return "Memoria: " + this.memory.toString();
	}
	/**
	 * Metodo para obtener una representacion en un objeto {@link String} de la pila de operandos.
	 * 
	 * @return Cadena {@link String} que representa la pila de operandos.
	 */
	public String getStackState(){
		return "Pila: " + this.operandStack.toString();
	}
	/**
	 * Mï¿½todo que devuelve el estado de la CPU.
	 * 
	 * @return {@link CPU#isRunning}, true si esta funcionando, false si la CPU ha acabado su ejecucion.
	 */
	public boolean isRunning() {
		return this.isRunning;
	}
}
