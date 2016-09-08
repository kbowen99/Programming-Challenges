import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int gameNum = 0;
		while (sc.hasNext()) {
			gameNum++;
			piece[][] board = new piece[8][8];

			for (int r = 0; r < board.length; r++) {
				String input = sc.nextLine();
				for (int c = 0; c < board[0].length; c++) {
					char id = (char) input.getBytes()[c];
					board[r][c] = new piece(id, r, c);
				}
			}

			boolean kingDown = false;
			boolean sideDown = false;// white = true; black = false;
			for (piece[] row : board)
				for (piece p : row){
					kingDown = kingDown || p.canKillKing(board);
					//sideDown = !p.getSide();
				}
			//System.out.print("Game #" + gameNum + ": " + (kingDown ? (sideDown ? "white king is in check." : "black king is in check.") : "no king is in check."));
			System.out.print("Game #" + gameNum + ": " + (kingDown ? "king is in check" : "no king is in check."));
			sc.nextLine();

		}
		sc.close();
	}
}
