import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

/**
 * Manages Program Output *Logically* for UVA Submissions
 * @version 0.1.0
 * @author Kurt Bowen (Kbowen99)
 */
public class Outputter {
	ArrayList<String> output;
	PrintWriter out = null;
	
	/**
	 * Generates a new Outputter Object
	 */
	public Outputter(){
		this.output = new ArrayList<>();
		try {
			out = new PrintWriter(new OutputStreamWriter(System.out,  "ISO-8859-1"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Prints all Queued Strings without clearing
	 */
	public void output(){
		for (String l : output)
			out.println(l);
		out.flush();
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
				if (output.get(output.size() - 1).trim().length() < 1) //if last in queue is a space
					safety = false; //useless spacing
				else 
					this.println("");
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
			if (s.equals(output.get(output.size() - 1)))
				out += s;
			else
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
