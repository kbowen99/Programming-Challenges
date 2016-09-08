
public class piece {
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
		side = ((int)id < 97); //if caps
		king = (id == 'k' || id == 'K');
		otherID = id + "";
		otherID = ((id == 'p' || id == 'P') ? "pawn" : otherID);
		otherID = ((id == 'r' || id == 'R') ? "rook" : otherID);
		otherID = ((id == 'b' || id == 'B') ? "bishop" : otherID);
		otherID = ((id == 'q' || id == 'Q') ? "queen" : otherID);
		otherID = ((id == 'k' || id == 'K') ? "king" : otherID);
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
			if (this.side){
				if (!rZero){
					if (!cZero)
						canKill = canKill || (board[r-1][c-1].isKing() && (board[r-1][c-1].getSide() != this.getSide()));
					if (!cMax)
						canKill = canKill || (board[r-1][c+1].isKing() && (board[r-1][c+1].getSide() != this.getSide()));
				}
			} else {
				if (!rMax){
					if (!cZero)
						canKill = canKill || (board[r+1][c-1].isKing() && (board[r+1][c-1].getSide() != this.getSide()));
					if (!cMax)
						canKill = canKill || (board[r+1][c+1].isKing() && (board[r+1][c+1].getSide() != this.getSide()));
				}
			}
			return canKill;
		} else if (this.getID().equals("rook")){
			//until 0
			for (int i = r; i > 0; i--)
				canKill = canKill || kingOnBoard(board, i, c);
			//until 8
			for (int i = r; i < 8; i++)
				canKill = canKill || kingOnBoard(board, i, c);
			//until 0
			for (int i = c; i > 0; i--)
				canKill = canKill || kingOnBoard(board, r, i);
			//until 8
			for (int i = c; i < 8; i++)
				canKill = canKill || kingOnBoard(board, r, i);
			return canKill;
		} else if (this.getID().equals("bishop")){
			//check bishop
		} else if (this.getID().equals("queen")){
			//check queen
		} else if (this.getID().equals("knight")){
			//check knight
		}
		
		return canKill;
	}
	
	@SuppressWarnings("unused")
	private boolean kingOnBoard(piece[][] board, int r, int c){
		return (board[r][c].isKing() && (board[r][c].getSide() != this.getSide()));
	}
}
