import java.util.ArrayList;

/**
 * Manages Program Output *Logically* for UVA Submissions
 * @version 0.1.0
 * @author Kurt Bowen (Kbowen99)
 */
public class Outputter {
	ArrayList<String> output;
	
	/**
	 * Generates a new Outputter Object
	 */
	public Outputter(){
		this.output = new ArrayList<>();
	}
	
	/**
	 * Prints all Queued Strings without clearing
	 */
	public void output(){
		for (String l : output)
			System.out.println(l);
	}
	
	/**
	 * Prints all Queued Strings, and dumps queue
	 */
	public void dump(){
		this.output();
		this.clear();
	}
	
	/**
	 * clears all Queued entries
	 */
	public void clear(){
		this.output = new ArrayList<>();
	}
	
	/**
	 * Appends to last line of output queue
	 * @param input - String to print
	 */
	public void print(String input){
		if (output.size() > 0)
			output.set((output.size() - 1), (output.get(output.size() - 1) + input));
		else
			this.println(input);
	}
	
	/**
	 * Adds String to output queue
	 * @param input
	 */
	public void println(String input){
		output.add(input);
	}
	
	/**
	 * Print a New Line with optional safety check
	 * @param safety - whether or not to avoid double spacing
	 */
	public void println(boolean safety){
		if (!safety) //no safety check
			this.println("");
		else //safety check
			if (output.size() > 0) //if prior output
				if (output.get(output.size() - 1).trim().length() < 0) //if last in queue is a space
					java.awt.Toolkit.getDefaultToolkit().beep();
				else 
					this.println("");
	}
	
	/**
	 * Print a New Line with Default safety check
	 */
	public void println(){
		println(true);
	}
	
	/**
	 * Converts Queue to Single String
	 * @return Queue as String
	 */
	public String passQueueAsString(){
		String out = "";
		for (String s : output)
			out += s + "\n";
		return out;
	}
	
	/**
	 * @return Current Queue
	 */
	public ArrayList<String> getQueue(){
		return this.output;
	}
}
