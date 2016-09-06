
public class piece {
	boolean side; //True = caps
	boolean king;
	char id;
	
	String otherID;
	
	public piece(char id){
		this.id = id;
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
	
	public boolean canKillKing(piece[][] board){
		if (this.isKing()){
			System.out.print("'Tis a King");
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
		
		return true;
	}
}
