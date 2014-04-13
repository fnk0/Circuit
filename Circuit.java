//==================================================================
// Circuit.java
// David Cline
// CS 1113, Fall 2013
//
// Description:
// Abstract circuit class used to compute circuit resistances
//==================================================================
import java.util.Scanner;

public abstract class Circuit {
	/**
	 * Get the resistance of the circuit
	 * @return the resistance of the circuit.
	 */
	public abstract double getResistance();
	/**
	 * Loads the circuit from a scanner. It is assumed
	 * that it may call this recursively.
	 * @param scan the input stream
	 */
	public abstract void loadCircuit(Scanner scan);
	/**
	 * Prints the circuit in a hierarchical fashion, giving
	 * the resistance of each piece.
	 * @param indent indentation string for each line of the output.
	 */
	public abstract void printHierarchical(String indent);
}
