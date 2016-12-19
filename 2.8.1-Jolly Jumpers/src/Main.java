import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
			while (sc.hasNext()) {
				int[] jumpers = new int[sc.nextInt()];
				boolean[] taken = new boolean[jumpers.length - 1];
				// fill the array
				for (int i = 0; i < jumpers.length; i++)
					jumpers[i] = sc.nextInt();
				for (int i = 1; i < jumpers.length; i++)
					if ((Math.abs(jumpers[i - 1] - jumpers[i]) - 1) >= 0 && (Math.abs(jumpers[i - 1] - jumpers[i]) - 1) < taken.length)
						taken[(Math.abs(jumpers[i - 1] - jumpers[i]) - 1)] = true;
				boolean o = false;
				for (boolean b : taken)
					o = o || !b;
				System.out.println((o ? "Not jolly" : "Jolly"));
			}
		sc.close();
	}

}
