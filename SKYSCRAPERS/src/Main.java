import java.util.Scanner;

public class Main {
	
	static int[][] Grid = new int[6][6];
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		String magic = sc.nextLine();
		Scanner lineScan = new Scanner(magic);
		lineScan.useDelimiter(", ");
		
		/*
		 * Extremely Over Complicated Data Input
		 * Parses first Line of Data into starting grid
		 */
		try{
			String s;
			for (int i = 0;!(s = lineScan.next()).isEmpty(); i++){
				if (i == 0 || i == 5)
					for (int c = 0; c < Grid[0].length; c++)
						Grid[i][c] = ((" " + s.trim() + " ").toCharArray()[c]==' ' ? 0 : Integer.parseInt((" " + s.trim() + " ").toCharArray()[c] + ""));
				else if (s.trim().length() == 2)
					for (int C = 0; C < 2; C++)
						Grid[i][(C==0?0:5)] = Integer.parseInt(s.trim().toCharArray()[(C==0?0:1)] + "");
				else if (s.trim().length() == 6)
					for (int c = 0; c < s.trim().length(); c++)
						Grid[i][c] = Integer.parseInt(s.trim().toCharArray()[c] + "");
				else
					System.out.println(s);
			}
		} catch (Exception x){}
		lineScan.close();
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
