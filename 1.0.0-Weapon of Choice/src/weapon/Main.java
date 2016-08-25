package weapon;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;
/**
 * Weapon of Choice
 * Terrible Java Code
 * @author Kurt Bowen (Kbowen99)
 *
 */
public class Main {

	//Whole bunch of Arrays for printing seven segment, works nicely with ASCII
	static String[] zero = {
			"┌─┐",
			"│ │",
			"└─┘"
	};
	static String[] one = {
			"  ┐",
			"  │",
			"  │"
	};
	static String[] two = {
			"──┐",
			"┌─┘",
			"└──"
	};
	static String[] three = {
			"──┐",
			" ─┤",
			"──┘"
	};
	static String[] four = {
			"│ │",
			"└─┤",
			"  │"
	};
	static String[] five = {
			"┌──",
			"└─┐",
			"──┘"
	};
	static String[] six = {
			"┌──",
			"├─┐",
			"└─┘"
	};
	static String[] seven = {
			"──┐",
			"  │",
			"  │"
	};
	static String[] eight = {
			"┌─┐",
			"├─┤",
			"└─┘"
	};
	static String[] nine = {
			"┌─┐",
			"└─┤",
			"  │"			
	};
	static String[] colon = {
			" ■ ",
			"   ",
			" ■ "
	};
	
	//2D Array of Arrays
	static String[][] display = new String[][]{zero,one,two,three,four,five,six,seven,eight,nine,colon};
	//Array to Output
	static String[] pOut = {"","",""};
	
	
	/**
	 * Main Method, Starts taking input from user
	 * @param args - Java Required
	 */
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		String input = "";
		while (!input.equals("q")){ //Uses 'q' to quit out of program
			input = sc.nextLine();
			if (input.toLowerCase().equals("time")){ //Print 7 seg time 
				printCurrTime();
			}
			if (input.toLowerCase().equals("ctime")){//print 7 seg time repeatedly, looks really cool
				while (true){
					printCurrTime();
				}
			}
			if (input.toLowerCase().equals("magic")){//Creates new 'magic' structure and prints its magics
				System.out.println((new magic()).print());
			}
			
		}
		sc.close();

	}
	
	/**
	 * Prints System Time HH:mm:ss:ms in 7 Seg
	 * Runs Helper methods for you
	 */
	private static void printCurrTime(){
		pOut[0] = "";//Clear out array, allows repeated printing
		pOut[1] = "";
		pOut[2] = "";
		String time = (new SimpleDateFormat("HH:mm:ss.SSS")).format(Calendar.getInstance().getTime());
		print7Seg(time);
	}
	
	/**
	 * Prints Provided String in 7 Seg
	 * @param sInput
	 */
	private static void print7Seg(String sInput){
		char[] toPrint = sInput.toCharArray();
		for (int i = 0; i < toPrint.length; i++){
			addChar(toPrint[i]);
		}
		printArray(pOut);
	}
	
	/**
	 * adds 'char' (0-9, or ':') to printing array
	 * @param chr - 0-9, or ':'
	 */
	private static void addChar(char chr){
		try {
			addRawNum(Integer.parseInt(chr + ""));
			addSpace(pOut);
		} catch (Exception e) {
			addRawNum(10);
			addSpace(pOut);
		}
	}
	
	/**
	 * adds 'raw number' from Display Array (Contains all drawing Arrays)
	 * @param numArray
	 */
	private static void addRawNum(int numArray){
		for (int i = 0; i < 3; i++){
			pOut[i] += display[numArray][i];
		}
		addSpace(pOut);
	}
	
	/**
	 * Appends strings to String Array
	 * @param toSpace - Array to Space
	 */
	private static void addSpace(String[] toSpace){
		for (int i = 0; i < toSpace.length; i++){
			toSpace[i] += " ";
		}
	}
	
	/**
	 * Prints Array to Console
	 * @param arr - Array to Print
	 */
	private static void printArray(String[] arr){
		for (int i = 0; i < arr.length; i++){
			System.out.println(arr[i]);
		}
	}
}

