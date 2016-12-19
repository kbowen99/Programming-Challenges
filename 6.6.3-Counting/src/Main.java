import java.math.BigInteger;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		BigInteger[] magic = calulateSeq(1001);
	    Scanner sc = new Scanner(System.in);
	    while (sc.hasNextInt())
	    	System.out.println(magic[sc.nextInt()]);
	    sc.close();
	}
	
	/**
	 * Calculates Sequence using Given Equation.
	 * Expansion of 1/(1-2*x-x^2-x^3).
	 * https://oeis.org/A077939
	 * @return
	 */
	private static BigInteger[] calulateSeq(int until){
		BigInteger[] o = new BigInteger[until];
	    o[0] = BigInteger.valueOf(1);
	    o[1] = BigInteger.valueOf(2);
	    o[2] = BigInteger.valueOf(5);
	    o[3] = BigInteger.valueOf(13);
	    for(int i = 4; i < o.length; i++ )
	      o[i] = o[i-1].add(o[i-1]).add(o[i-2]).add(o[i-3]);
	    return o;
	}

}
