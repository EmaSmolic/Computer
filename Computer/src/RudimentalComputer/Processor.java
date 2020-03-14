package RudimentalComputer;

public class Processor implements Component{
	public static int SR_SIZE = 1;
	public static int CPU_REGISTER_NUMBER = 64;

	public int adressMRegister;
	public Storeable dataMRegister;
	public int programCounter;
	public int stackPointer;
	public Boolean[] stateRegister = new Boolean[SR_SIZE];
	public Storeable[] registers = new Storeable[CPU_REGISTER_NUMBER];
	public Instruction instructionRegister;
	public ArithmeticLogicUnit ALU;
	public ControlUnit CU;
	
	public Bus B1;
	public Bus B2;
	public Bus B3;
	
	public Computer computer;
	
	public void turnOn() {
		programCounter = -1;
	}
	
	public void performInstruction() {
		fetch();
		decode();
		execute();
	}

	private void execute() {
		 Data result = ALU.performOperation();
		 B3.dataWires = Data.toBinary(result);
		 dataMRegister = Data.toData(B3.dataWires);
		 
		 setSRFlags(result);
		
	}

	private void setSRFlags(Data result) {
		// TODO Auto-generated method stub
		
	}

	private void decode() {
		CU.decode(this);
		
	}

	public void fetch() {	
		nextInstructionInPC();
		
		instructionRegister = (Instruction) dataMRegister;		
	}

	public void nextInstructionInPC() {
		do {
			adressMRegister = programCounter++;
			Instruction.load(this, computer.memory, computer.bus);
		} while(!Storeable.isInstruction(dataMRegister) && programCounter < Memory.MEMORY_SIZE);
		
		if (!Storeable.isInstruction(dataMRegister)) throw new Error("No instructions in memory.");
		
	}


}
