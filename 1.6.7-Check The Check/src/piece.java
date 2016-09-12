
public class piece {
	boolean kingSideKilled = true;
	boolean side; //True = caps = white
	boolean king;
	char id;
	
	int r;
	int c;
	
	String otherID;
	
	public piece(char id, int r, int c){
		this.id = id;
		this.c = c;
		this.r = r;
		side = Character.isUpperCase(id); //((int)id < 97); //if caps
		king = (id == 'k' || id == 'K');
		otherID = id + "";
		otherID = ((id == 'p' || id == 'P') ? "pawn" : otherID);
		otherID = ((id == 'r' || id == 'R') ? "rook" : otherID);
		otherID = ((id == 'b' || id == 'B') ? "bishop" : otherID);
		otherID = ((id == 'q' || id == 'Q') ? "queen" : otherID);
		otherID = ((id == 'k' || id == 'K') ? "king" : otherID);
		otherID = ((id == 'n' || id == 'N') ? "knight" : otherID);
	}
	
	public boolean isKing(){
		return this.king;
	}
	
	public String getID(){
		return this.otherID;
	}
	
	public boolean getSide(){
		return this.side;
	}
	
	public int getC(){
		return this.c;
	}
	
	public int getR(){
		return this.r;
	}
	
	public boolean canKillKing(piece[][] board){
		boolean cZero = !(c > 0);
		boolean cMax = (c >= 7);
		boolean rZero = !(r > 0);
		boolean rMax = (r >= 7);
		
		boolean canKill = false;
		if (this.isKing()){
			if (!cZero && !rZero)
				canKill = canKill || (board[r-1][c-1].isKing() && (board[r-1][c-1].getSide() != this.getSide()));
			if (!cZero)
				canKill = canKill || (board[r][c-1].isKing() && (board[r][c-1].getSide() != this.getSide()));
			if (!rZero)
				canKill = canKill || (board[r-1][c].isKing() && (board[r-1][c].getSide() != this.getSide()));
			if (!rZero && !cMax)
				canKill = canKill || (board[r-1][c+1].isKing() && (board[r-1][c+1].getSide() != this.getSide()));
			if (!cMax)
				canKill = canKill || (board[r][c+1].isKing() && (board[r][c+1].getSide() != this.getSide()));
			if (!rMax)
				canKill = canKill || (board[r+1][c].isKing() && (board[r+1][c].getSide() != this.getSide()));
			if (!rMax && !cZero)
				canKill = canKill || (board[r+1][c-1].isKing() && (board[r+1][c-1].getSide() != this.getSide()));
			if (!rMax && !cMax)
				canKill = canKill || (board[r+1][c+1].isKing() && (board[r+1][c+1].getSide() != this.getSide()));
			return canKill;
		} else if (this.getID().equals("pawn")){
			if (this.side){//White & True & Up
				if (!rZero){
					if (!cZero)
						canKill = canKill || kingOnBoard(board, r-1, c-1);
					if (!cMax)
						canKill = canKill || kingOnBoard(board, r-1, c+1);
				}
			} else {//Black & false & Down
				if (!rMax){
					if (!cZero)
						canKill = canKill || kingOnBoard(board, r+1, c-1);
					if (!cMax)
						canKill = canKill || kingOnBoard(board, r+1, c+1);
				}
			}
			return canKill;
		} else if (this.getID().equals("rook")){
			//until 0
			for (int i = r; i >= 0; i--)
				canKill = canKill || kingOnBoard(board, i, c);
			//until 8
			for (int i = r; i < 8; i++)
				canKill = canKill || kingOnBoard(board, i, c);
			//until 0
			for (int i = c; i >= 0; i--)
				canKill = canKill || kingOnBoard(board, r, i);
			//until 8
			for (int i = c; i < 8; i++)
				canKill = canKill || kingOnBoard(board, r, i);
			return canKill;
		} else if (this.getID().equals("bishop")){
			//Diag top-Left
			for (int i = 0; (r-i >= 0) && (c-i >= 0); i++)
				canKill = canKill || kingOnBoard(board, r - i, c - i);
			//Diag Top Right
			for (int i = 0; (r-i >= 0) && (c+i < 8); i++)
				canKill = canKill || kingOnBoard(board, r - i, c + i);
			//Diag Bot. Left
			for (int i = 0; (r+i < 8) && (c-i >= 0); i++)
				canKill = canKill || kingOnBoard(board, r + i, c - i);
			//diag Bot. Right
			for (int i = 0; (r+i < 8) && (c+i < 8); i++)
				canKill = canKill || kingOnBoard(board, r + i, c + i);
			return canKill;
		} else if (this.getID().equals("queen")){
			//Check Bishop
				//Diag top-Left
				for (int i = 0; (r-i >= 0) && (c-i > 0); i++)
					canKill = canKill || kingOnBoard(board, r - i, c - i);
				//Diag Top Right
				for (int i = 0; (r-i >= 0) && (c+i < 8); i++)
					canKill = canKill || kingOnBoard(board, r - i, c + i);
				//Diag Bot. Left
				for (int i = 0; (r+i < 8) && (c-i > 0); i++)
					canKill = canKill || kingOnBoard(board, r + i, c - i);
				//diag Bot. Right
				for (int i = 0; (r+i < 8) && (c+i < 8); i++)
					canKill = canKill || kingOnBoard(board, r + i, c + i);
			//Check Rook
				//until 0
				for (int i = r; i >= 0; i--)
					canKill = canKill || kingOnBoard(board, i, c);
				//until 8
				for (int i = r; i < 8; i++)
					canKill = canKill || kingOnBoard(board, i, c);
				//until 0
				for (int i = c; i >= 0; i--)
					canKill = canKill || kingOnBoard(board, r, i);
				//until 8
				for (int i = c; i < 8; i++)
					canKill = canKill || kingOnBoard(board, r, i);
				return canKill;
		} else if (this.getID().equals("knight")){
			//Top
			if (r - 1 >= 0 && c + 2 < 8)
				canKill = canKill || kingOnBoard(board, r - 1, c + 2);
			if (r - 1 >= 0 && c - 2 >= 0)
				canKill = canKill || kingOnBoard(board, r - 1, c - 2);
			if (r - 2 >= 0 && c - 1 >= 0)
				canKill = canKill || kingOnBoard(board, r - 2, c - 1);
			if (r - 2 >= 0 && c + 1 < 8)
				canKill = canKill || kingOnBoard(board, r - 2, c + 1);
			//Bottom
			if (r + 1 < 8 && c + 2 < 8)
				canKill = canKill || kingOnBoard(board, r + 1, c + 2);
			if (r + 1 < 8 && c - 2 >= 0)
				canKill = canKill || kingOnBoard(board, r + 1, c - 2);
			if (r + 2 < 8 && c - 1 >= 0)
				canKill = canKill || kingOnBoard(board, r + 2, c - 1);
			if (r + 2 < 8 && c + 1 < 8)
				canKill = canKill || kingOnBoard(board, r + 2, c + 1);
		}
		
		return canKill;
	}
	
	public boolean getKingSideKilled(){
		return this.kingSideKilled;
	}
	
	@SuppressWarnings("unused")
	private boolean kingOnBoard(piece[][] board, int r, int c){
		boolean canKill = board[r][c].isKing() && (board[r][c].getSide() != this.getSide());
		this.kingSideKilled = board[r][c].getSide();
		if (canKill && Main.DEBUG){
			System.out.println("Piece Side: " + this.getSide());
			System.out.println("King Side: " + board[r][c].getSide());
			System.out.println("King Killed: " + r + " , " + c);
			System.out.println("Piece Killing: " + this.r + " , " + this.c);
		}
		return canKill;
	}
}
