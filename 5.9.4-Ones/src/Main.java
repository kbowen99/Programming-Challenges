import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNextInt())
			System.out.println(countDigits(sc.nextInt()));
		sc.close();
	}
	
	/**
	 * Just Enough Black Magic.
	 * Totally Read the Book 
	 * @param n
	 * @return
	 */
	private static int countDigits(int n){
		int nDigits = 1, nVal = 1%n;
		while (nVal >= 1){
			nDigits++;
			nVal = ((nVal * 10) + 1)%n;
		}
		return nDigits;
	}
}
