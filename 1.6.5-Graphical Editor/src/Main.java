import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[][] picture = new char[0][0];
		while (true) {
			String input = sc.nextLine();

			/*
			 * "I" Command - Creates new array of specified size
			 */
			if (input.substring(0, 1).equals("I")) {
				Scanner numScan = new Scanner(input);
				numScan.useDelimiter("[^0-9]+");
				int useless = numScan.nextInt();
				picture = clearPic(new char[numScan.nextInt()][useless]);
				numScan.close();
			}

			/*
			 * "C" Command - Clears Current Array
			 */
			if (input.substring(0, 1).equals("C"))
				picture = clearPic(picture);

			/*
			 * "X" Command - For Quitters
			 */
			if (input.substring(0, 1).equals("X")){
				System.out.println();
				break;
			}

			/*
			 * "L" Command - Color a pixel
			 */
			if (input.substring(0, 1).equals("L")) {
				Scanner numScan = new Scanner(input);
				numScan.useDelimiter("[^0-9]+");
				int Y = numScan.nextInt();
				picture[numScan.nextInt() - 1][Y - 1] = input.substring(input.length() - 1).toCharArray()[0];
				numScan.close();
			}

			/*
			 * "V" Command - Color a vertical pixel area
			 */
			if (input.substring(0, 1).equals("V")) {
				Scanner numScan = new Scanner(input);
				numScan.useDelimiter("[^0-9]+");
				int X = numScan.nextInt() - 1;
				int Y1 = numScan.nextInt() - 1;
				int Y2 = numScan.nextInt() - 1;
				if (Y1 < Y2)
					for (int Y = Y1; Y <= Y2; Y++)
						picture[Y][X] = input.substring(input.length() - 1).toCharArray()[0];
				if (Y2 < Y1)
					for (int Y = Y1; Y >= Y2; Y--)
						picture[Y][X] = input.substring(input.length() - 1).toCharArray()[0];
				numScan.close();
			}

			/*
			 * "H" Command - Color a Horizontal pixel area
			 */
			if (input.substring(0, 1).equals("H")) {
				Scanner numScan = new Scanner(input);
				numScan.useDelimiter("[^0-9]+");
				int X1 = numScan.nextInt() - 1;
				int X2 = numScan.nextInt() - 1;
				int Y = numScan.nextInt() - 1;
				// System.out.println("X1: " + X1 + " X2: " + X2 + " Y: " + Y);
				if (X1 < X2)
					for (int X = X1; X <= X2; X++)
						picture[Y][X] = input.substring(input.length() - 1).toCharArray()[0];
				if (X2 < X1)
					for (int X = X1; X >= X2; X--)
						picture[Y][X] = input.substring(input.length() - 1).toCharArray()[0];
				numScan.close();
			}

			/*
			 * "K" Command - Fills In Defined Region
			 */
			if (input.substring(0, 1).equals("K")) {
				Scanner numScan = new Scanner(input);
				numScan.useDelimiter("[^0-9]+");
				int X1 = numScan.nextInt() - 1;
				int Y1 = numScan.nextInt() - 1;
				int X2 = numScan.nextInt() - 1;
				int Y2 = numScan.nextInt() - 1;

				if (X1 > X2) {
					int tmp = X1;
					X1 = X2;
					X2 = tmp;
				}
				if (Y1 > Y2) {
					int tmp = Y1;
					Y1 = Y2;
					Y2 = tmp;
				}
				for (int Y = Y1; Y <= Y2; Y++)
					for (int X = X1; X <= X2; X++)
						picture[Y][X] = input.substring(input.length() - 1).toCharArray()[0];
				numScan.close();
			}

			/*
			 * "S" Command - "Saves" file to console
			 */
			if (input.substring(0, 1).equals("S")) {
				System.out.println(input.substring(input.indexOf(' ') + 1));
				for (char[] arr : picture) {
					for (char p : arr)
						System.out.print(p);
					System.out.println();
				}
			}

			/*
			 * "F" Command - Fills in defined Region
			 */
			if (input.substring(0, 1).equals("F")) {
				Scanner numScan = new Scanner(input);
				numScan.useDelimiter("[^0-9]+");
				int X = numScan.nextInt() - 1;
				int Y = numScan.nextInt() - 1;
				char C = input.substring(input.length() - 1).toCharArray()[0];
				recursiveColor(Y, X, C, picture);
				numScan.close();
			}

		}
		sc.close();
		System.exit(0);
	}

	private static char[][] clearPic(char[][] pic) {
		for (int r = 0; r < pic.length; r++)
			for (int c = 0; c < pic[0].length; c++)
				pic[r][c] = 'O';
		return pic;
	}

	/**
	 * Recursively colors at pixel
	 * 
	 * @param X
	 * @param Y
	 * @param toReplace
	 * @param replaceWith
	 */
	private static void recursiveColor(int X, int Y, char C, char[][] picture) {
		char oldChar = picture[X][Y];
		picture[X][Y] = C;
		while (true) {
			if (oldChar == picture[X][Y])
				break;
			
			boolean XP = (X + 1) < picture.length;
			boolean XM = X != 0;
			boolean YP = (Y + 1) < picture[0].length;
			boolean YM = Y != 0;
			// X-
			if (XM && picture[X - 1][Y] == oldChar) {
				recursiveColor(X - 1, Y, C, picture);
				//break;
			}
			// X+
			if (XP && picture[X + 1][Y] == oldChar) {
				recursiveColor(X + 1, Y, C, picture);
				//break;
			}
			// Y-
			if (YM && picture[X][Y - 1] == oldChar) {
				recursiveColor(X, Y - 1, C, picture);
				//break;
			}
			// Y+
			if (YP && picture[X][Y + 1] == oldChar) {
				recursiveColor(X, Y + 1, C, picture);
				//break;
			}
			
//			//-------------------------
//			// X- Y-
//			if (XM && YM && picture[X - 1][Y - 1] == oldChar) {
//				recursiveColor(X - 1, Y - 1, C, picture);
//			}
//			// X- Y+
//			if (XM && YP && picture[X - 1][Y + 1] == oldChar) {
//				recursiveColor(X - 1, Y + 1, C, picture);
//			}
//			// X+ Y+
//			if (XP && YP && picture[X + 1][Y + 1] == oldChar) {
//				recursiveColor(X + 1, Y + 1, C, picture);
//			}
//			// X+ Y-
//			if (XP && YM && picture[X + 1][Y - 1] == oldChar) {
//				recursiveColor(X + 1, Y - 1, C, picture);
//			}
			break;
		}

	}
}
