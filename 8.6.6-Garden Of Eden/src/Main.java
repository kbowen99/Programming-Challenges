import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNextInt())
			System.out.println((isReachable(AutoMagic(sc.nextInt()), sc.nextInt(), makeTargArr(sc.nextLine())) ? "REACHABLE" : "GARDEN OF EDEN"));
		sc.close();
	}
	/**
	 * Generates Automata Array
	 * @param AN - Automata Num (Gotta Love Shorthand)
	 * @return Hopefully, an Automata Array
	 */
	private static int[][][] AutoMagic(int AN) {
		int[][][] out = new int[2][2][2];
		for (int i = 0; i < 2; i++)
			for (int j = 0; j < 2; j++)
				for (int k = 0; k < 2; k++) {// Remind you of calculus?
					out[i][j][k] = AN % 2;
					AN = AN / 2; // Remainder
				}
		return out;
	}
	
	/**
	 * Converts String -> Array 'O ints
	 * Did You Know You Can't Cast a char Array to an int Array with built in methods? Kinda Sucks.
	 * @param targ - To be "Arrayed"
	 * @return "Array"
	 */
	private static int[] makeTargArr(String targ) {
		char[] a = (targ + "").trim().toCharArray();
		int[] t = new int[a.length];
		for (int i = 0; i < a.length; i++)
			t[i] = Integer.parseInt(a[i] + "");
		return t;
	}
	/**
	 * Determines Garden O Eden Scenario
	 * @param a - Automata Array
	 * @param no - Nothing, Simplifies Runner While() tenfold though
	 * @param t - "Target" array
	 * @return
	 */
	public static boolean isReachable(int[][][] a,int no, int[] t) {
		int[] s = new int[t.length];
		for (int i = 0; i < 2; i++) 
			for (int j = 0; j < 2; j++) 
				for (int k = 0; k < 2; k++) //more Calculus Variables!
					if (a[i][j][k] == t[0] && isCandidate(a, i, t[t.length - 1])) {
						s[s.length - 1] = i;
						s[0] = j;
						s[1] = k;
						if (backTrack5(a, t, s, 1, i))
							return true;
					}
		return false;
	}

	/**
	 * The Best PenTesting Tool. BackTracking is still BlackMagic to Me....
	 * @param a - Automata
	 * @param t - Target
	 * @param s - Reachability
	 * @param i - Current
	 * @param last - Last
	 * @return
	 */
	public static boolean backTrack5(int[][][] a, int[] t, int[] s, int i, int last) {
		if (i == s.length - 1)
			if (a[s[i - 1]][s[i]][s[0]] == t[i] && s[i] == last)// Dont Question it
				return true;
			else
				return false;
		for (int k = 0; k < 2; k++)
			if (a[s[i - 1]][s[i]][k] == t[i]) {
				s[i + 1] = k;
				if (backTrack5(a, t, s, i + 1, last))
					return true;
			}
		return false;
	}
	/**
	 * Some Conjecture Whose Name IDK. just find it using many For's
	 * @param a
	 * @param i
	 * @param t
	 * @return
	 */
	public static boolean isCandidate(int[][][] a, int i, int t) {
		for (int j = 0; j < 2; j++) 
			for (int k = 0; k < 2; k++) 
				if (a[j][i][k] == t)
					return true;
		return false;
	}
}
