import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNextLine()){
			char[] line1 = sc.nextLine().toCharArray();
			char[] line2 = sc.nextLine().toCharArray();
			String Out = "";
			for (int c1 = 0; c1 < line1.length; c1++)
				for(int c2 = 0; c2 < line2.length; c2++)
					if (line1[c1] == line2[c2]){
						Out += line1[c1];
						break;
					}
			String[] OutA = Out.split("");
			Arrays.sort(OutA);
			for (String c : OutA)
				System.out.print(c);
			System.out.println();
		}
		sc.close();
	}

}
