import java.text.Collator;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNextLine()){
			String line1 = sc.nextLine();
			String line2 = sc.nextLine();
			String Out = "";
			for (int c1 = 0; c1 < line1.length(); c1++)
				for(int c2 = 0; c2 < line2.length(); c2++)
					if ((line1.toCharArray()[c1] == line2.toCharArray()[c2]) && !(Out.contains(line1.toCharArray()[c1] + "")))
						Out += line1.toCharArray()[c1];
			String[] OutA = Out.split("");
			Arrays.sort(OutA, Collator.getInstance(new Locale("en", "EN")));
			for (String c : OutA)
				System.out.print(c);
			System.out.println();
		}
		sc.close();
	}

}
