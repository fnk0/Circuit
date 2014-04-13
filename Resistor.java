//==================================================================
// Resistor.java
// Marcus Gabilheri
// CS 1113, Fall 2013
//
// Description:
// This class will represent a single resistor
//==================================================================
import java.util.Scanner;

public class Resistor extends Circuit {

	private double resistor;

	public Resistor(double x) {
		resistor = x;
	}
	
	@Override
	public double getResistance() {
		return resistor;
	}

	@Override
	public void loadCircuit(Scanner scan) {}

	@Override
	public void printHierarchical(String indent) {
		System.out.printf(indent + "resistor %1.2f,\n", getResistance());
	}
}