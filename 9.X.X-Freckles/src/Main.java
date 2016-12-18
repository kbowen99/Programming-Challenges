import java.awt.Point;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int CASES = sc.nextInt();
		for (int u = 0; u < CASES; u++){
			int nFreckles = sc.nextInt();
			Double total = 0.0;
			ArrayList<Point2D> freckles = new ArrayList<>();
			int[] sets = new int[nFreckles];
			for (int i = 0; i < nFreckles; i++){
				freckles.add(new Point2D.Double(sc.nextDouble(),sc.nextDouble()));
				sets[i] = i;
			}

			for (int i = 1; i < nFreckles; i++) {
				Double shortest = Double.MAX_VALUE;
				int s = -1;
				for (int j = 0; j < nFreckles; j++) {
					s = -1;
					if (sets[i] != sets[j]) {
						Double n = freckles.get(i).distance(freckles.get(j));
						if (n < shortest) {
							shortest = n;
							s = sets[j];
						}
					}
				}
				total += shortest;
				sets[i] = s;
			}
			System.out.printf("%.2f\n", total);
			System.out.println();
		}
	}
	

}
