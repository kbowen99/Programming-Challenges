
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
		otherID = (id == 'p' || id == 'P' ? "pawn" : "");
		otherID = (id == 'r' || id == 'R' ? "rook" : "");
		otherID = (id == 'b' || id == 'B' ? "bishop" : "");
		otherID = (id == 'q' || id == 'Q' ? "queen" : "");
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
				canKill = canKill || (board[c-1][r-1].isKing() && (board[c-1][r-1].getSide() != this.getSide()));
			if (!cZero)
				canKill = canKill || (board[c-1][r].isKing() && (board[c-1][r].getSide() != this.getSide()));
			if (!rZero)
				canKill = canKill || (board[c][r-1].isKing() && (board[c][r-1].getSide() != this.getSide()));
			if (!rZero && !cMax)
				canKill = canKill || (board[c+1][r-1].isKing() && (board[c+1][r-1].getSide() != this.getSide()));
			if (!cMax)
				canKill = canKill || (board[c+1][r].isKing() && (board[c+1][r].getSide() != this.getSide()));
			if (!rMax)
				canKill = canKill || (board[c][r+1].isKing() && (board[c][r+1].getSide() != this.getSide()));
			if (!rMax && !cZero)
				canKill = canKill || (board[c-1][r+1].isKing() && (board[c-1][r+1].getSide() != this.getSide()));
			if (!rMax && !cMax)
				canKill = canKill || (board[c+1][r+1].isKing() && (board[c+1][r+1].getSide() != this.getSide()));
			return canKill;
			
			//Check King
		} else if (this.getID().equals("pawn")){
			//check pawn
		} else if (this.getID().equals("rook")){
			//check rook
		} else if (this.getID().equals("bishop")){
			//check bishop
		} else if (this.getID().equals("queen")){
			//check queen
		}
		
		return canKill;
	}
}
