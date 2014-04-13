//==================================================================
// MainCircuit.java
// Marcus Gabilheri
// CS 1113, Fall 2013
//
// Description:
// MainCircuit loads a circuit and prints it in a nice format.
//==================================================================

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class MainCircuit {
		
	public static void main(String[] args) throws FileNotFoundException {
			
		Scanner scan = new Scanner(new File(args[0]));
		ArrayList<Circuit> mainCircuit = new ArrayList<Circuit>();
		String circuitType = "";

		while(scan.hasNext()) {
			String s = scan.next();
			
			if(s.contains("#")) {
				scan.nextLine();
			} else if(s.contains("series")) {
				circuitType = "series";
			} else if(s.contains("parallel")) {
				circuitType = "parallel";
			} else if(s.contains("{")) { 
				if(circuitType.equals("series")) {
					Circuit serialCircuit = new SerialCircuit();
					serialCircuit.loadCircuit(scan);
					mainCircuit.add(serialCircuit);
					circuitType = "";
				} else if(circuitType.equals("parallel")) {
					Circuit parallelCircuit = new ParallelCircuit();
					parallelCircuit.loadCircuit(scan);
					mainCircuit.add(parallelCircuit);
					circuitType = "";
				} 
				
			} else if(s.contains("}")) {
				return;
			}
		}
		
		for(Circuit c : mainCircuit) {
			c.printHierarchical("");
		}
	
		scan.close();
	}
}