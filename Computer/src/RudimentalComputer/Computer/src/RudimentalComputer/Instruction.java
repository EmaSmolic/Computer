package RudimentalComputer;

public class Instruction implements Storeable{

	public ALUOperation ALUOperation;
	
	public int internalRegisterNumber;
	
	public int branchAdress;
	public boolean isConditionalBranch;
	public boolean isUnconditionalBranch;
	public boolean branchConditionTrue;
	
	public int procedureCallAdress;
	
	public InstructionType type;


	public static void load(Processor cpu, Memory mem, Bus bus) {
		//CPU:
		bus.adressWires = Data.toBinary(cpu.adressMRegister); //TODO: ERROR
		bus.controlWires[0] = true;
		
		//MEM:
		mem.adressRegister = Data.toInteger(bus.adressWires);
		mem.contentRegister = Storeable.toStoreable(mem.memory[mem.adressRegister]);
		bus.dataWires = Storeable.toBinary(mem.contentRegister);
		
		//CPU:
		cpu.dataMRegister = Data.toData(bus.adressWires);
			
	}
	
	public static void store(Processor cpu, Memory mem, Bus bus) {
		//CPU:
		bus.adressWires = Data.toBinary(cpu.adressMRegister);
		bus.controlWires[0] = false;
		bus.dataWires = Data.toBinary(cpu.dataMRegister);
		
		//MEM:
		mem.adressRegister = Data.toInteger(bus.adressWires);
		mem.memory[mem.adressRegister] = bus.dataWires;
		
	}
	
//	public static void unconditionalBranch(Processor cpu, Memory mem, Bus bus) {
//		
//	}


	@Override
	public void decode() { //MUST SET FIELDS
		// TODO Auto-generated method stub
		
	}

	public boolean operand2FromMemory() {
		// TODO Auto-generated method stub
		return false;
	}

	public int getOperandAdress() {
		// TODO Auto-generated method stub
		return 0;
	}

	public boolean operand2FromRegister () {
		return false;
	}

}
