package weapon;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

public class Main {

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
	
	static String[][] display = new String[][]{zero,one,two,three,four,five,six,seven,eight,nine,colon};
	static String[] pOut = {"","",""};
	
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		String input = "";
		while (!input.equals("q")){
			input = sc.nextLine();
			if (input.toLowerCase().equals("time")){
				printCurrTime();
			}
			if (input.toLowerCase().equals("ctime")){
				while (!input.equals("q")){
					//input = sc.nextLine();
					printCurrTime();
				}
			}
		}
		sc.close();

	}
	
	private static void printCurrTime(){
		pOut[0] = "";
		pOut[1] = "";
		pOut[2] = "";
		String time = (new SimpleDateFormat("HH:mm:ss.SSS")).format(Calendar.getInstance().getTime());
		print7Seg(time);
	}
	
	private static void print7Seg(String sInput){
		char[] toPrint = sInput.toCharArray();
		for (int i = 0; i < toPrint.length; i++){
			addChar(toPrint[i]);
		}
		printArray(pOut);
	}
	
	private static void addChar(char chr){
		try {
			addRawNum(Integer.parseInt(chr + ""));
			addSpace(pOut);
		} catch (Exception e) {
			addRawNum(10);
			addSpace(pOut);
		}
	}
	
	private static void addRawNum(int numArray){
		for (int i = 0; i < 3; i++){
			pOut[i] += display[numArray][i];
		}
		addSpace(pOut);
	}
	
	private static void addSpace(String[] toSpace){
		for (int i = 0; i < toSpace.length; i++){
			toSpace[i] += " ";
		}
	}
	
	private static void printArray(String[] arr){
		for (int i = 0; i < arr.length; i++){
			System.out.println(arr[i]);
		}
	}
}

