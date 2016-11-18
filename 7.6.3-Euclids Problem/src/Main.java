import java.math.BigInteger;
import java.util.Scanner;

public class Main {
	static int X = 0;
	static int Y = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try {
			while (sc.hasNextLine()) {
				int A = sc.nextInt();
				int B = sc.nextInt();
				int D = gcd(A, B);
				System.out.println(A + "X + " + B + "Y = " + D);
				tryEuclid(A, B);
				//System.out.println("(" + X + "," + Y + ")");
				//System.out.println(D + "");
			}
		} catch (Exception e) {
		}
		sc.close();
	}
	
	public static int gcd(int A, int B) {
		return ((new BigInteger(A + "")).gcd(new BigInteger(B + ""))).intValue();
	}
	
	public static int eGCD(int A, int B){
		if (B>A)
			return eGCD(B,A);
		if (A%B > 0){
			//System.out.println("GCD-Ing: " + A + " = " + (A/B) + " * " + B + " + " + (A%B));
			//System.out.println("Maybe: " + (A%B) + " = " + A + " * -" + (A/B) + " " + B);
			return eGCD(B,(A%B));
		} else
			return A/B;
	}
	
	public static void tryEuclid(int A, int B){
		int t = 2;
		int D = gcd(A,B);
		int X = t*A/D;
		int Y = -t*B/D;
		
		System.out.println(A + "(" + X + ")" + "+" + B + "(" + Y + ") = " + D);
	}
}
