import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNextLine()){
			int StandardNumOut = Integer.parseInt(sc.nextLine());//First Line of input
			String[] StandardOutput = new String[StandardNumOut];
			for (int i = 0; i < StandardNumOut; i++) //Standard Output
				StandardOutput[i] = sc.nextLine();
			int TeamNumOut = Integer.parseInt(sc.nextLine());
			String[] TeamOutput = new String[TeamNumOut];
			for (int i = 0; i < TeamNumOut; i++) //Team Output
				TeamOutput[i] = sc.nextLine();
			if (arrIsEqual(TeamOutput, StandardOutput))
				System.out.println("That Sucks");
		}
		sc.close();
	}
	
	private static boolean arrIsEqual(String[] arr1, String[] arr2){
		boolean isEqual = true;
		if (arr1.length != arr2.length)
			return false;
		for (int i = 0; i < arr1.length; i++)
			if (arr1[i] != arr2[i])
				isEqual = false;
		return isEqual;
	}

}
