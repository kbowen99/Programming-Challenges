import java.math.BigInteger;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		int MAX = 100000;
		Scanner sc = new Scanner(System.in);
		BigInteger[] discus = new BigInteger[MAX + 6];
		discus[0] = BigInteger.ZERO;
		int n = 0, count = 0;
		//Pre-Calculate TM, Ghetto TM
		for (int i = 1; i < MAX; ++count){
			BigInteger op = (BigInteger.ONE.shiftLeft(count - 1));
			for (int j = count; j > 0 && i < MAX; j--, ++i)
				discus[i] = discus[i - 1].add(op);
		}
		while (sc.hasNext())
			System.out.println(discus[sc.nextInt()]);
		sc.close();
	}
}
