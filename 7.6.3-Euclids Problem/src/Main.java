import java.awt.Point;
import java.math.BigInteger;
import java.util.Scanner;

public class Main {
	static int X = 0;
	static int Y = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNextInt()) {
			int A = sc.nextInt(); int B = sc.nextInt();
			Point maybe = newEuclid((A == B ? 0 : A),B);
			System.out.println((int)maybe.getX() + " " + (int)maybe.getY() + " " + gcd(A,B));
		}
		sc.close();
	}
	
	public static int gcd(int A, int B) {
		return ((new BigInteger(A + "")).gcd(new BigInteger(B + ""))).intValue();
	}
	
	/**
	 * AX + BY = D
	 * Recursive Method for finding logical points in either "Y-Positive" (True) or "X-Positive" (false) "searching"
	 * Who Would've guessed Java only has a 512kb stack size? Who also would've guessed this implementation doesn't always work?
	 * @param A - Provided 'A' Value
	 * @param B - Provided 'B' Value
	 * @param X - Calculating 'X' Value
	 * @param Y - Calculating 'Y' Value
	 * @param D - Greatest Common Divisor of A & B (Recalculating every time increases stack)
	 * @param Dir true - XP; false - YP;
	 * @return Calculated Point
	 */
	@Deprecated
	public static Point untilEqDir(int A,int B, int X, int Y, int D, boolean Dir){
		int LS = (A*X + B*Y);
		if (LS == D)
			return new Point(X,Y);
		else 
			if (LS < D)
				return (Dir ? untilEqDir(A, B, X + 1,Y, D, Dir) : untilEqDir(A, B, X, Y + 1, D, Dir));
			else
				return (Dir ? untilEqDir(A,B,X,Y - 1, D, Dir) : untilEqDir(A,B,X - 1,Y, D, Dir));
	}
	
	/**
	 * AX + BY = D
	 * Non-Recursive Method for finding logical points in either "Y-Positive" (True) or "X-Positive" (false) "searching"
	 * @param A - Provided 'A' Value
	 * @param B - Provided 'B' Value
	 * @param X - Calculating 'X' Value
	 * @param Y - Calculating 'Y' Value
	 * @param D - Greatest Common Divisor of A & B (Recalculating every time increases stack)
	 * @param Dir true - XP; false - YP;
	 * @return Calculated Point
	 */
	@Deprecated
	public static Point tilEqDirLoop(int A,int B, int X, int Y, int D, boolean Dir){
		int mS = 1000000001;
		while (true){
			if (Math.abs(X) > mS || Math.abs(Y) > mS)
				return null;
			int LS = (A*X + B*Y);
			if (LS == D)
				return new Point(X,Y);
			else 
				if (LS < D)
					if (Dir)
						X++;
					else
						Y++;
				else
					if (Dir)
						Y--;
					else
						X--;
		}
	}
	
	/**
	 * Euclid's logic, Simplified
	 * @param A
	 * @param B
	 * @return
	 */
	@Deprecated
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
	
	/**
	 * It only took forever to realize, It was that simple
	 * @param A "A"
	 * @param B "B"
	 * @return The Number You've Been Looking For Forever
	 */
	public static Point newEuclid(int A, int B){
		Point X = new Point(0, 1);
		if (A != 0 && B != 0){
			Point tmp = newEuclid(B%A, A);
			X.setLocation((tmp.getY() - (B/A) * tmp.getX()), tmp.getX());
		}
		return X;
	}

}
