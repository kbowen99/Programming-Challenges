import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int gameNum = 0;
		while (sc.hasNext()){
			gameNum++;
			piece[][] board = new piece[8][8];
			
			for (int r = 0; r < board.length; r++){
				String input = sc.nextLine();
				for (int c = 0; c < board[0].length; c++){
					char id = (char)input.getBytes()[c];
					board[r][c] = new piece(id);
				}
			}
			sc.nextLine();
			System.out.println("Game #" + gameNum + ": ");
			board[0][0].canKillKing(board);
			
		}
		sc.close();
	}
}
