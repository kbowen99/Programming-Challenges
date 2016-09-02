import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int gameNum = 0;
		while (sc.hasNext()){
			gameNum++;
			char[][] board = new char[8][8];
			for (int r = 0; r < 8; r++){
				String input = sc.nextLine();
				for (int c = 0; c < 8; c++){
					board[r][c] = (char)input.getBytes()[c];
				}
			}
			System.out.print("Game #" + gameNum + ": ");
		}
		sc.close();
	}
	
	public static boolean checkPawn(char[][] board, int kingsRow, int kingsCollumn){
		return false;
	}
	
	public static boolean checkRook(char[][] board, int kingsRow, int kingsCollumn){
		return false;
	}
	
	public static boolean checkBishop(char[][] board, int kingsRow, int kingsCollumn){
		return false;
	}
	
	public static boolean checkQueen(char[][] board, int kingsRow, int kingsCollumn){
		return false;
	}
	
	public static boolean checkKing(char[][] board, int kingsRow, int kingsCollumn){
		return false;
	}
	
	public static boolean checkKnight(char[][] board, int kingsRow, int kingsCollumn){
		return false;
	}
}
