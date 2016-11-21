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
				int X = 0;
				int Y = 0;
				//System.out.println(A + "X + " + B + "Y = " + gcd(A, B));
				Point XP = untilEqXP(A,B,X,Y);
				Point YP = untilEqYP(A,B,X,Y);
				System.out.print(((Math.abs(XP.getX()) + Math.abs(XP.getY())) < (Math.abs(YP.getX()) + Math.abs(YP.getY()))) ? (int)XP.getX() + " " + (int)XP.getY() : (int)YP.getX() + " " + (int)YP.getY());
				System.out.println(" " + gcd(A,B));
			}
		} catch (Exception e) {
		}
		sc.close();
	}
	
	public static int gcd(int A, int B) {
		return ((new BigInteger(A + "")).gcd(new BigInteger(B + ""))).intValue();
	}
	
	public static Point untilEqXP(int A,int B, int X, int Y){
		int D = gcd(A,B);
		int LS = (A*X + B*Y);
		if (LS == D)
			return new Point(X,Y);
		else 
			if (LS < D)
				return untilEqXP(A, B, X + 1,Y);
			else
				return untilEqXP(A,B,X,Y - 1);
	}
	
	public static Point untilEqYP(int A,int B, int X, int Y){
		int D = gcd(A,B);
		int LS = (A*X + B*Y);
		if (LS == D)
			return new Point(X,Y);
		else 
			if (LS < D)
				return untilEqYP(A, B, X, Y + 1);
			else
				return untilEqYP(A,B,X - 1,Y);
	}
}
