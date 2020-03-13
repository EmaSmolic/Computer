package RudimentalComputer;

public class Memory implements Component {
	
	public static int MEMORY_SIZE = 64;
	
	public int adressRegister;
	public Storeable contentRegister;
	public Boolean[][] memory = new Boolean[MEMORY_SIZE][];
	
	public Computer computer;


}
