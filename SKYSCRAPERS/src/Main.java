import java.util.Scanner;

public class Main {
	
	static int[][] Grid = new int[6][6];
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		String magic = sc.nextLine();
		Scanner lineScan = new Scanner(magic);
		lineScan.useDelimiter(", ");
		
		try{
			String s;
			for (int i = 0;!(s = lineScan.next()).isEmpty(); i++){
				if (i == 0)
					for (int c = 0; c < Grid[0].length; c++)
						Grid[0][c] = ((" " + s.trim() + " ").toCharArray()[c]==' ' ? 0 : Integer.parseInt((" " + s.trim() + " ").toCharArray()[c] + ""));
				System.out.println(s);
			}
		} catch (Exception x){}
		printGrid(Grid);
	}
	
	
	/**
	 * Fancy Debugging Output
	 * @param magic - The Array to be printed
	 */
	public static void printGrid(int[][] magic){
		for (int r = 0; r < magic.length; r++){
			for (int c = 0; c < magic[0].length; c++){
				if ((r == 0 || r == 5) && (c == 0 || c == 5))
					System.out.print(" ");
				else
					System.out.print(magic[r][c]);
				if (c == 0 || c == 4)
					System.out.print("│");
			}
			System.out.println();
			if (r == 0 || r == 4)
				System.out.println("─┼────┼─");
		}
	}
}
