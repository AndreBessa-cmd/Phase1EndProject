package phase1.project.exception;

public class ProperOptionValue extends Exception{
	
	public ProperOptionValue() {  //no-argument constructor
		
	}
	
	public ProperOptionValue (String name){  //constructor
		super(name);
		
	}
}
