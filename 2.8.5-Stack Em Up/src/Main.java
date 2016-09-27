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
			
			for (int[] magic: Shuffles)
				for (int i : magic)
					System.out.println(i);
		}
		sc.close();
	}
}
