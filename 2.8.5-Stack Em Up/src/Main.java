import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCases = sc.nextInt();
		for (int useless = 0; useless < testCases; useless++){
			int numShuffles = sc.nextInt();//Number of Known Shuffles
			
			ArrayList<int[]> Shuffles = new ArrayList<>();
			
			for (int shuffle = 0; shuffle < numShuffles; shuffle++){
				int[] newShuffle = new int[52];
				for (int i = 0; i < newShuffle.length; i++)
					newShuffle[i] = sc.nextInt();
				Shuffles.add(newShuffle);
			}
			
			int[] currGame = new int[52];
			for (int i = 0; i < 52; i++)
				currGame[i] = i + 1;
			
			sc.nextLine();
			while (true){
				String input = sc.nextLine();
				//System.out.println("Shuffling: " + input);
				if (input.trim().equals(""))
					break;
				try{
				currGame = performShuffle(currGame, Shuffles.get((Integer.parseInt(input) - 1)));
				} catch (Exception e){}
			}
			
			for (int i : currGame)
				System.out.println((new Card(i)));
		}
		sc.close();
	}
	
	private static int[] performShuffle(int[] currentGame, int[] toShuffle){
		int[] newGame = new int[52];
		for (int i : toShuffle){
			newGame[i] = currentGame[toShuffle[i] - 1];
		}
		return newGame;
	}
}
