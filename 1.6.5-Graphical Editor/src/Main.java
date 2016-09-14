import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[][] picture = new char[0][0];
		while (true){
			String input = sc.nextLine();
			
			/*
			 * "I" Command - Creates new array of specified size
			 */
			if (input.substring(0,1).equals("I")){
				Scanner numScan = new Scanner(input);
				numScan.useDelimiter("[^0-9]+");
				picture = clearPic(new char[numScan.nextInt()][numScan.nextInt()]);
				numScan.close();
			}
			
			/*
			 * "C" Command - Clears Current Array
			 */
			if (input.substring(0,1).equals("C"))
				picture = clearPic(picture);
			
			/*
			 * "X" Command - For Quitters
			 */
			if (input.substring(0,1).equals("X"))
				break;
			
			/*
			 * "L" Command - Creates new array of specified size
			 */
			if (input.substring(0,1).equals("L")){
				Scanner numScan = new Scanner(input);
				numScan.useDelimiter("[^0-9]+");
				picture[numScan.nextInt()][numScan.nextInt()] = input.substring(input.length() - 1).toCharArray()[0];
				numScan.close();
			}
			
		}
		sc.close();
	}
	
	@SuppressWarnings("unused")
	private static char[][] clearPic(char[][] pic){
		for (char[] col : pic)
			for (char pix : col)
				pix = 'O';
		return pic;
	}
}
