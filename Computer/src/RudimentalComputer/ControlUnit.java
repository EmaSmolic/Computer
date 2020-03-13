package RudimentalComputer;

public class ControlUnit {
	
	public void decode(Processor cpu) {
		cpu.instructionRegister.interpret();
		
		cpu.nextInstructionInPC();

		cpu.ALU.setOperation(cpu.instructionRegister.ALUOperation);
		
		//CLOSING BUS FILTERS
		
		if (cpu.instructionRegister.operandFromMemory()) {
			cpu.adressMRegister = cpu.instructionRegister.getOperandAdress();
		}
		
	}

}
