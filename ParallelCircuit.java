//==================================================================
// ParallelCircuit.java
// Marcus Gabilheri
// CS 1113, Fall 2013
//
// Description:
// This can store any number of circuits in parallel using ArrayList<Circuit>.
//==================================================================

import java.util.ArrayList;
import java.util.Scanner;

public class ParallelCircuit extends Circuit {
	
	protected ArrayList<Circuit> parallel = new ArrayList<Circuit>();
	
	@Override
	public double getResistance() {
		double resistance = 0.0;
		for(Circuit x : parallel) {
			resistance += 1 / x.getResistance();
		}
		resistance = 1 / resistance;
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
				parallel.add(r);
			} else if(s.contains("series")) {
				Circuit serialC = new SerialCircuit();
				serialC.loadCircuit(scan);
				parallel.add(serialC);
			} else if(s.contains("parallel")) {
				Circuit parallelC = new ParallelCircuit();
				parallelC.loadCircuit(scan);
				parallel.add(parallelC);
			} else if(s.contains("}")) {
				return;
			}
		}	
	}

	@Override
	public void printHierarchical(String indent) {
		
		System.out.printf(indent + "Parallel # %1.2f\n" + indent + "{\n", getResistance());
		
		for(Circuit x : parallel) {
			x.printHierarchical("\t" + indent);
		}
		
		System.out.printf(indent + "}\n");	
	}
}