
public class Card implements Comparable{
	int val;
	char suit;
	
	public Card(int v, char s){
		this.val = v;
		this.suit = s;
	}
	public int getVal(){
		return this.val;
	}
	public char getSuit(){
		return this.suit;
	}
	public String toString(){
		return (this.val <= 9 && this.val >= 2 ? this.val : (this.val == 1 ? "A" : (this.val == 10 ? "T" : (this.val == 11 ? "J" : (this.val == 12 ? "Q" : "K"))))) + "" + this.suit;
	}
	@Override
	public int compareTo(Object o) {
		return (this.suit == ((Card)o).getSuit() ? (new Integer(this.val)).compareTo(new Integer(((Card)o).getVal())) : (this.suit + "").compareTo(((Card)o).getSuit() + ""));
	}
}
