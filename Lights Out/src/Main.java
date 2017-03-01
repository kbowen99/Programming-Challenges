import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	static boolean[][] grid;
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		for (int u = 0; u < 5; u++){
			grid = new boolean[8][8];
			String lineIn = sc.nextLine();
			ArrayList<String> magic = new ArrayList<String>(Arrays.asList(lineIn.split(" ")));
			//MultiCol Rows
			int r = Integer.parseInt(magic.remove(0));//GetNum Rows
			while (!magic.isEmpty() && r-- > 0){
				char[] tmp = magic.remove(0).toCharArray();
				for (int c = 1; c < tmp.length; c++)
					grid[Integer.parseInt(tmp[0] + "") - 1][Integer.parseInt(tmp[c] + "") - 1] = true;
					//pressPixel(Integer.parseInt(tmp[0] + ""),Integer.parseInt(tmp[c] + ""), grid);
			}
			
			
			//Buttons
			int numButtons = Integer.parseInt(magic.remove(0));
			while (numButtons-- > 0){
				pressPixel(Integer.parseInt(magic.get(0).toCharArray()[0] + ""), Integer.parseInt(magic.remove(0).toCharArray()[1] + ""), grid);
				System.out.println("HIH");
			}
			
			int ONTILES = 0;
			for (boolean[] row : grid)
				for (boolean b: row)
					if (b)
						ONTILES++;
			System.out.println(ONTILES);
		}
	}
	
	private static void pressPixel(int x, int y, boolean[][] magic){
		x--;
		y--;
		magic[x][y] = !magic[x][y];
		//Vert/Horiz
		if (x > 0)//X - 1
			magic[x - 1][y] = !magic[x - 1][y];
		if (y > 0)//Y - 1
			magic[x][y - 1] = !magic[x][y - 1];
		if (x < 7)//X + 1
			magic[x + 1][y] = !magic[x+1][y];
		if (y < 7)//Y + 1
			magic[x][y + 1] = !magic[x][y + 1];
		//Diags
		if (x > 0 && y > 0)//- -
			magic[x - 1][y - 1] = !magic[x - 1][y - 1];
		if (x > 0 && y < 7)//- +
			magic[x - 1][y + 1] = !magic[x - 1][y + 1];
		if (x < 7 && y < 7)//+ +
			magic[x + 1][y + 1] = !magic[x + 1][y + 1];
		if (x < 7 && y > 0)//+ -
			magic[x + 1][y - 1] = !magic[x + 1][y - 1];
		//+-2 vert/Horiz
		if (x > 1)//X-
			magic[x - 2][y] = !magic[x - 2][y];
		if (y > 1)//Y -
			magic[x][y - 2] = !magic[x][y - 2];
		if (x < 6)//X +
			magic[x + 2][y] = !magic[x + 2][y];
		if (y < 6)//Y +
			magic[x][y + 2] = !magic[x][y + 2];
		printGrid(grid);
	}
	
	private static void printGrid(boolean[][] grid){
		for (boolean[] row : grid){
			for (boolean c : row)
				System.out.print((c ? "X" : " "));
			System.out.println();
		}
		System.out.println("========");
	}
}
