import java.math.BigInteger;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try {
			while (sc.hasNextLine()) {
				int A = sc.nextInt();
				int B = sc.nextInt();
				int D = gcd(A, B);
				System.out.println(D + "");
			}
		} catch (Exception e) {}
		sc.close();
	}

	public static int gcd(int A, int B) {
		return ((new BigInteger(A + "")).gcd(new BigInteger(B + ""))).intValue();
	}
}
