
public class Card {
	
	/**
	 * Suit of the Card
	 * IE: Clubs, Diamonds, Hearts, Spades
	 */
	String suit;
	
	/**
	 * Value of the Card
	 * IE: 2, 3, 4, 5, 6, 7, 8, 9, 10, Jack, Queen, King, or Ace
	 */
	String value;
	
	/**
	 * originally assigned number
	 */
	int num;
	
	public Card(int num){
		int offset = 0;
		if (num <= 13){
			suit = "Clubs";
		} else if (num <= 26){
			suit = "Diamonds";
			offset = 13;
		} else if (num <= 39){
			suit = "Hearts";
			offset = 26;
		} else if (num <= 52){
			suit = "Spades";
			offset = 39;
		}
		
		if ((num - offset) < 10)
			value = ((num - offset) + 1) + "";
		else if ((num - offset) == 10)
			value = "Jack";
		else if ((num - offset) == 11)
			value = "Queen";
		else if ((num - offset) == 12)
			value = "King";
		else if ((num - offset) == 13)
			value = "Ace";
	}
	
	@Override
	public String toString(){
		return this.value + " of " + this.suit;
	}
}
