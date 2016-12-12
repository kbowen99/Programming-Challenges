import java.math.BigInteger;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int count = 1;
		for (BigInteger i = sc.nextBigInteger(); i.compareTo(BigInteger.ZERO) > 0; i = i.divide(new BigInteger("2")))
			System.out.println(count++ + " : " + i.toString());
	}

}
