package weapon;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

public class Main {

	static String[] zero = {
			"┌-┐",
			"│ │",
			"└-┘"
	};
	String[] one = {
			"  ┐",
			"  │",
			"  │"
	};
	String[] two = {
			"--┐",
			"┌-┘",
			"└--"
	};
	String[] three = {
			"--┐",
			" -┤",
			"--┘"
	};
	String[] four = {
			"│ │",
			"└-┤",
			"  │"
	};
	String[] five = {
			"┌--",
			"└-┐",
			"--┘"
	};
	String[] six = {
			"┌--",
			"├-┐",
			"└-┘"
	};
	public static void main(String[] args) {
		System.out.println(zero[0]);
		Scanner sc = new Scanner(System.in);
		String input = "";
		while (!input.equals("q")){
			input = sc.nextLine();
			if (input.toLowerCase().equals("time")){
				System.out.println((new SimpleDateFormat("HH:mm:ss")).format(Calendar.getInstance().getTime()));
				
			}
		}
		sc.close();

	}

}
