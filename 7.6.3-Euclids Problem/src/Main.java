import java.awt.Point;
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
				int D = gcd(A,B);
				int X = 0;
				int Y = 0;
				if (A != 0 && B != 0){
					Point XP = untilEqDir(A,B,X,Y,D,true);
					Point YP = untilEqDir(A,B,X,Y,D,false);
					System.out.print(((Math.abs(XP.getX()) + Math.abs(XP.getY())) < (Math.abs(YP.getX()) + Math.abs(YP.getY()))) ? (int)XP.getX() + " " + (int)XP.getY() : (int)YP.getX() + " " + (int)YP.getY());
				} else 
					if (A > 0)
						System.out.print("1 0");
					else
						System.out.print("0 1");
				System.out.println(" " + gcd(A,B));
			}
		} catch (Exception e) {
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
}
