package RudimentalComputer;

public class ControlUnit {
	
	public void decode(Processor cpu) {
		cpu.instructionRegister.decode();
		
		cpu.nextInstructionInPC();

		cpu.ALU.setOperation(cpu.instructionRegister.ALUOperation);
		
		cpu.B2.dataWires = Data.toBinary(cpu.registers[cpu.instructionRegister.internalRegisterNumber]);
		cpu.ALU.getOperandFromBus(cpu.B2);
		
		if (cpu.instructionRegister.operand2FromRegister()) {
			cpu.ALU.getOperandFromBus(cpu.B1);
		}
		
		else if (cpu.instructionRegister.operand2FromMemory()) {
			cpu.adressMRegister = cpu.instructionRegister.getOperandAdress();
			Instruction.load(cpu, cpu.computer.memory, cpu.computer.bus);
			cpu.B1.dataWires = Data.toBinary(cpu.dataMRegister);
			cpu.ALU.getOperandFromBus(cpu.B1);
		}
		
	}

}
