import java.awt.Point;
import java.math.BigInteger;
import java.util.Scanner;

public class Main {
	static int X = 0;
	static int Y = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//try {
			while (sc.hasNextLine()) {
				BigInteger A = new BigInteger(sc.nextInt() + "");
				BigInteger B = new BigInteger(sc.nextInt() + "");
				BigInteger X = new BigInteger("0");
				BigInteger Y = new BigInteger("0");
				if (!A.equals(BigInteger.ZERO) && !B.equals(BigInteger.ZERO)){
					int zero = 0;
					Point XP = untilEqXP(A,B,X,Y,zero); zero = 0;
					Point YP = untilEqYP(A,B,X,Y, zero);
					System.out.println(XP + " " + YP);
					//System.out.print(((Math.abs(XP.getX()) + Math.abs(XP.getY())) < (Math.abs(YP.getX()) + Math.abs(YP.getY()))) ? (int)XP.getX() + " " + (int)XP.getY() : (int)YP.getX() + " " + (int)YP.getY());
				} else 
					if (A.equals(BigInteger.ZERO) && !B.equals(BigInteger.ZERO))
						System.out.print("0 1");
					else if (B.equals(BigInteger.ZERO) && !A.equals(BigInteger.ZERO))
						System.out.print("1 0");
					else
						System.out.print("0 0");
				System.out.println(" " + A.gcd(B));
			}
		//} catch (Exception e) {
		//}
		sc.close();
	}
	
	public static int gcd(int A, int B) {
		return ((new BigInteger(A + "")).gcd(new BigInteger(B + ""))).intValue();
	}
	
	
	public static Point untilEqXP(BigInteger A,BigInteger B, BigInteger X, BigInteger Y, int iteration){
		iteration++;
		BigInteger LS = (A.multiply(X)).add(B.multiply(Y));//(A*X + B*Y);
		if (iteration > 200)
			return null;
		else if (LS == A.gcd(B))
			return new Point(X.intValue(),Y.intValue());
		else 
			if (LS.compareTo(A.gcd(B)) < 0)
				return untilEqXP(A, B, X.add(BigInteger.ONE),Y,iteration);
			else
				return untilEqXP(A,B,X,Y.subtract(BigInteger.ONE),iteration);
	}
	
	public static Point untilEqYP(BigInteger A,BigInteger B, BigInteger X, BigInteger Y, int iteration){
		iteration++;
		BigInteger LS = (A.multiply(X)).add(B.multiply(Y));//(A*X + B*Y);
		if (iteration > 200)
			return null;
		else if (LS == A.gcd(B))
			return new Point(X.intValue(),Y.intValue());
		else 
			if (LS.compareTo(A.gcd(B)) < 0)
				return untilEqYP(A, B, X, Y.add(BigInteger.ONE),iteration);
			else
				return untilEqYP(A,B,X.subtract(BigInteger.ONE),Y,iteration);
	}
}
