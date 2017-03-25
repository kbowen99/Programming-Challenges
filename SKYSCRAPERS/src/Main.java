import java.util.Scanner;

/**
 * Tries to solve a weird japanese game that i barely understand, avoids Brute Force. Probably doesnt work
 * 
 * I Hate Permutations
 * @author Kurtis Bowen
 *
 */
public class Main {
	/**
	 * Turns on/off Pretty Visuals
	 */
	public final static boolean DEBUG = false;
	
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
		
		/*
		 * Try to sort
		 */
		if (DEBUG){
			System.out.println("Starting Grid");
			printGrid(Grid);
		}
		
		gypsyMagic(Grid);
		
		if (DEBUG){
			System.out.println("GYPSY GRID");
			printGrid(Grid);
		}
		
		rowFiller(Grid);
		
		if (DEBUG){
			System.out.println("GUESSED GRID");
			printGrid(Grid);
		}
		
		/*
		 * Answer User Inputted Queries
		 */
		for (int z = 0; z < 5; z++){
			String s = sc.nextLine();
			System.out.println(Grid[Integer.parseInt(s.trim().toCharArray()[0] + "")][Integer.parseInt(s.trim().toCharArray()[1] + "")]);
		}
		sc.close();
	}
	
	/**
	 * Finds all Zeroes Within Internal Grid, And Passes them to the laziest algorithm ever
	 * @param m
	 */
	private static void rowFiller(int[][] m){
		for (int ROW = 1; ROW < (m.length - 1); ROW++)
			for (int COL = 1; COL < (m.length - 1); COL++)
				if (m[ROW][COL] == 0)
					m[ROW][COL] = guessValue(m, ROW, COL);
	}
	
	/**
	 * Guestimates Value @ Position
	 * Yeah, its bad
	 * @param grid Grid to Guess
	 * @param ROW X Val
	 * @param COL Y Val
	 * @return A Guess
	 */
	private static int guessValue(int[][] grid, int ROW, int COL){
		int rowGuess = grid[ROW][1] + grid[ROW][2] + grid[ROW][3] + grid[ROW][4];
		int colGuess = grid[1][COL] + grid[2][COL] + grid[3][COL] + grid[4][COL];
		return (1 + 2 + 3 + 4) - (rowGuess > colGuess ? rowGuess : colGuess);
	}
	
	/**
	 * Try some form of Solving. Miller Said Run Time Doesn't Matter so...
	 * @param m 2D Array to Attack, I Mean Sort
	 */
	private static void gypsyMagic(int[][] m){
		//Check the Easiest Possible Solutions
		for (int R = 0; R < m.length; R++){//Go Through All Rows
			if (m[R][0]==1 && m[R][5]==4)
				for (int i = 0; i < m[R].length; i++)
					m[R][i] = Integer.parseInt(("143214").toCharArray()[i] + "");
			if (m[R][0]==4 && m[R][5]==1)
				for (int i = 0; i < m[R].length; i++)
					m[R][i] = Integer.parseInt(("412341").toCharArray()[i] + "");
		}
		for (int C = 0; C < m[0].length; C++){
			if (m[0][C]==1 && m[5][C]==4)
				for (int i = 0; i < m.length; i++)
					m[i][C] = Integer.parseInt(("143214").toCharArray()[i] + "");
			if (m[0][C]==4 && m[5][C]==1)
				for (int i = 0; i < m.length; i++)
					m[i][C] = Integer.parseInt(("412341").toCharArray()[i] + "");
		}
		
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
		System.out.println("========");
	}
}
