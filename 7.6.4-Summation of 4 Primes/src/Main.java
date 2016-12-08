import java.io.FileOutputStream;
import java.io.PrintStream;
import java.math.BigInteger;

public class Main {
	
	public static void main(String[] args) {
		try {
				System.setOut(new PrintStream(new FileOutputStream("out.txt")));
		} catch (Exception e) {}
		printApplicablePrimes(10000000);
	}
	
	private static void printApplicablePrimes(int lim){
		p("{");
		for (int i = 2; i < lim; i++)
			if (isPrime(i))
				p(i + ",");
		p("};");
	}
	
	private static boolean isPrime(int n){
		return (new BigInteger(n + "")).equals((new BigInteger(n - 1 + "")).nextProbablePrime());
	}
	
	private static Object p(Object o){
		System.out.println((String)o);
		return o;
	}
}
