import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCases = sc.nextInt();
		for (int useless = 0; useless < testCases; useless++){
			int huts = sc.nextInt();
			ArrayList<Integer> neighborhood = new ArrayList<>();
			for (int a = 0; a < huts; a++)
					neighborhood.add(sc.nextInt());
			Collections.sort(neighborhood);
			int average = (int)neighborhood.get(neighborhood.size() / 2);
			int VitosLaziness = 0;
			for (Integer i : neighborhood)
				VitosLaziness += Math.abs(average - i);
			System.out.println(VitosLaziness);
		}
		sc.close();
	}
}
