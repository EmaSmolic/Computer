package RudimentalComputer;

public class Bus {
	public static int CONTROL_SIZE = 1;
	public static int DATA_SIZE = 16;
	public static int ADRESS_SIZE = 7;
	
	public Boolean[] controlWires = new Boolean[CONTROL_SIZE];
	public Boolean[] dataWires = new Boolean[DATA_SIZE];
	public Boolean[] adressWires = new Boolean[ADRESS_SIZE];
	
	public Computer computer;

}
