import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		for (int u = 0; u < 5; u++){
			Card opponent = null;
			ArrayList<Card> dealer = new ArrayList<>();
			String input = sc.nextLine();
			for (String s : input.split(","))
				if (s.trim().equals(input.trim().substring(0, 2)))
					opponent = new Card((s.trim().charAt(0) < 65 ? Integer.parseInt(s.trim().toCharArray()[0] + "") : (s.trim().charAt(0) == 'A' ? 1 :(s.trim().charAt(0) == 'T' ? 10 : (s.trim().charAt(0) == 'J' ? 11 : (s.trim().charAt(0) == 'Q' ? 12 : 13))))), s.trim().toCharArray()[1]);
				else
					dealer.add(new Card((s.trim().charAt(0) < 65 ? Integer.parseInt(s.trim().toCharArray()[0] + "") : (s.trim().charAt(0) == 'A' ? 1 :(s.trim().charAt(0) == 'T' ? 10 : (s.trim().charAt(0) == 'J' ? 11 : (s.trim().charAt(0) == 'Q' ? 12 : 13))))), s.trim().toCharArray()[1]));
			System.out.println(findWinner(opponent, dealer).toString());
		}
		sc.close();
	}
	
	@SuppressWarnings("unchecked")
	private static Card findWinner(Card opponent, ArrayList<Card> deals){
		ArrayList<Card> sameSuits = new ArrayList<>();
		for (Card c : deals)
			if (c.getSuit() == opponent.getSuit())
				sameSuits.add(c);
		if (sameSuits.size() < 1){
			Card lowestVal = deals.get(0);
			for (Card c : deals)
				if (c.getVal() < lowestVal.getVal())
					lowestVal = c;
			return lowestVal;
		}
		Collections.sort(sameSuits);
		for (Card c : sameSuits)
			if (c.getVal() > opponent.getVal())
				return c;
		return sameSuits.get(0);

	}
}
