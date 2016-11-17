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
				System.out.println(undoEuclid(A,B));
				System.out.println("(" + X + "," + Y + ")");
				System.out.println(D + "");
			}
		} catch (Exception e) {}
		sc.close();
	}

	public static int gcd(int A, int B) {
		return ((new BigInteger(A + "")).gcd(new BigInteger(B + ""))).intValue();
	}
	
	public static int gcd2(int p, int q, int x, int y){
		int x1 = 0,y1 = 0,g = 0;
		
		if (q > p) return (gcd2(q,p,y,x));
		
		if (q == 0) {
			x = 1;
			y = 0;
			return p;
		}
		
		g = gcd2(q, p%q, x1, y1);
		x = y1;
		y = (int) (x1 - Math.floor(p/q) * y1);
		
		return g;
	}
	
	public static int undoEuclid(int a,int b)
	{
	    int x1 = 0,y1 = 0,d = 0;

	    if(a==0){
	    X=0;
	    Y=1;
	    return b;
	    }

	        d=undoEuclid(b%a,a);
	        X=y1-(b/a)*x1;
	        Y=x1;
	        return d;


	}
}
