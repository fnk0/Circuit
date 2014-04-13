//==================================================================
// SerialCircuit.java
// Marcus Gabilheri
// CS 1113, Fall 2013
//
// Description:
// This class can store any number of circuits in series. Using a ArrayList<Circuit>
//==================================================================
import java.util.ArrayList;
import java.util.Scanner;

public class SerialCircuit extends Circuit {
	
	protected ArrayList<Circuit> serial = new ArrayList<Circuit>();
	
	@Override
	public double getResistance() {
		
		double resistance = 0.0;
		for(Circuit x : serial) {
			resistance += x.getResistance();
		}
		return resistance;
	}

	@Override
	public void loadCircuit(Scanner scan) {

		while(scan.hasNext()) {
			String s = scan.next();
			if(s.contains("#")) {
				scan.nextLine();
			} else if(s.contains("resistor")) {
				String rS = scan.next();
				rS = rS.replace(',', '\0');
				Resistor r = new Resistor(Double.parseDouble(rS));
				serial.add(r);
			} else if(s.contains("parallel")) {
				Circuit parC = new ParallelCircuit();
				parC.loadCircuit(scan);
				serial.add(parC);
			} else if(s.contains("series")) {
				Circuit serialC = new SerialCircuit();
				serialC.loadCircuit(scan);
				serial.add(serialC);
			} else if(s.contains("}")) {
				return;
			}
		}
	}

	@Override
	public void printHierarchical(String indent) {
		
		System.out.printf(indent + "Series # %1.2f\n" + indent +"{\n", getResistance());
		
		for(Circuit x : serial) {
			x.printHierarchical("\t");
		}
		
		System.out.printf(indent + "}\n", 3.0);
	}
}